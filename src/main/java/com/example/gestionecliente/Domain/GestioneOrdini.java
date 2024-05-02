package com.example.gestionecliente.Domain;

import com.example.gestionecliente.Domain.Entity.ComandaEntity;
import com.example.gestionecliente.Domain.Entity.OrdineEntity;
import com.example.gestionecliente.Domain.dto.OrdineDTO;
import com.example.gestionecliente.Domain.ports.DataOrderPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GestioneOrdini implements OrderManagerIF {

    private final DataOrderPort dataOrderPort;
    private final SessioneIF gestioneSessioni;

    @Autowired
    public GestioneOrdini(DataOrderPort dataOrderPort) {
        this.dataOrderPort = dataOrderPort;
        gestioneSessioni = new GestioneSessioni();
    }


    @Override
    public Optional<Iterable<OrdineEntity>> getOrdersOfCliente(String idcliente) {
        Optional<ComandaEntity> comanda = dataOrderPort.getComandaAttiva(idcliente);
        return Optional.ofNullable(comanda.isEmpty()? null : dataOrderPort.getOrdersOfComanda(comanda.get().getId()));
    }

    @Override
    public ComandaEntity newComanda(String idcliente) {
        ComandaEntity c = new ComandaEntity();
        c.setIdCliente(idcliente);
        return dataOrderPort.insertComanda(c);
    }

    @Override
    public Optional<ComandaEntity> getComandaAttiva(String idcliente) {
        return dataOrderPort.getComandaAttiva(idcliente);
    }

    @Override
    public OrdineEntity addNewOrder(int idcomanda, String idpiatto, int urgenzacliente) {

        OrdineEntity ordineEntity = OrdineEntity.builder()
                .idComanda(idcomanda)
                .idPiatto(idpiatto)
                .urgenzaCliente(urgenzacliente)
                .stato(0)
                .build();

        return dataOrderPort.insertOrder(ordineEntity);

    }

    @Override
    public Optional<OrdineEntity> getOrder(int id) {
        return dataOrderPort.getOrder(id);
    }

    @Override
    public int getOrderStatus(int id) {
        return dataOrderPort.getOrderStatus(id);
    }

}