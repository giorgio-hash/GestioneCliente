package com.example.gestionecliente.Domain;

import com.example.gestionecliente.Domain.Entity.ComandaEntity;
import com.example.gestionecliente.Domain.Entity.OrdineEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GestioneOrdini implements OrderManagerIF {

    private final DataOrderPort dataOrderPort;
    private final SessioneIF gestioneSessioni = new GestioneSessioni();

    @Autowired
    public GestioneOrdini(DataOrderPort dataOrderPort) {
        this.dataOrderPort = dataOrderPort;
    }

    @Override
    public OrdineEntity addNewOrder(String idcliente, String idpiatto) {

        OrdineEntity o = new OrdineEntity();
        Optional<Integer> cached_idcomanda = gestioneSessioni.getComanda(idcliente);

        //per il momento è "forzato" ad andare sempre in if
        if(cached_idcomanda.isEmpty()){
            ComandaEntity c = new ComandaEntity();
            c.setIdCliente(idcliente);
            c = dataOrderPort.insertComanda(c);

            o.setIdcomanda(c.getId());
            o.setIdPiatto(idpiatto);
            o = dataOrderPort.insertOrder(o);
            gestioneSessioni.newComanda(idcliente,c.getId());
            gestioneSessioni.assignToComanda(o.getId(),o.getIdcomanda());
        }
        else
        {
            o.setIdcomanda(cached_idcomanda.get());
            o.setIdPiatto(idpiatto);
            o = dataOrderPort.insertOrder(o);
            gestioneSessioni.assignToComanda(o.getId(),o.getIdcomanda());
        }

        return o;
    }

    @Override
    public Optional<OrdineEntity> getOrder(int id) {
        return dataOrderPort.getOrder(id);
    }

    @Override
    public int getOrderStatus(int id) {
        return dataOrderPort.getOrderStatus(id);
    }

    @Override
    public Optional<ComandaEntity> getComanda(String idcliente) {
        return dataOrderPort.getComanda(idcliente);
    }

}