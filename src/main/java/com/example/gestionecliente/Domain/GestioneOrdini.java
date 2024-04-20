package com.example.gestionecliente.Domain;

import com.example.gestionecliente.Domain.Entity.ClienteEntity;
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

        //per il momento è "forzato" ad andare sempre in else
        if(cached_idcomanda.isEmpty()){
            ComandaEntity c = new ComandaEntity();
            c.setIdCliente(idcliente);
            c = dataOrderPort.insertComanda(c);
            o.setIdComanda(c.getId());
            o.setIdPiatto(idpiatto);
            o = dataOrderPort.insertOrder(o);
            gestioneSessioni.newComanda(idcliente,c.getId());
            gestioneSessioni.assignToComanda(o.getId(),o.getIdComanda());
        }
        else
        {
            o.setIdComanda(cached_idcomanda.get());
            o.setIdPiatto(idpiatto);
            o = dataOrderPort.insertOrder(o);
            gestioneSessioni.newComanda(idcliente,cached_idcomanda.get());
            gestioneSessioni.assignToComanda(o.getId(),o.getIdComanda());
        }

        return o;
    }

    @Override
    public Optional<OrdineEntity> getOrder(int id, int idcomanda) {
        return dataOrderPort.getOrder(id,idcomanda);
    }

}