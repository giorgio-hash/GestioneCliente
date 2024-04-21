package com.example.gestionecliente.Domain;

import com.example.gestionecliente.Domain.Entity.ComandaEntity;
import com.example.gestionecliente.Domain.Entity.OrdineEntity;

import java.util.Optional;

public interface OrderManagerIF {

    OrdineEntity addNewOrder(String idcliente, String idpiatto);

    Optional<OrdineEntity> getOrder(int id);

    int getOrderStatus(int id);

    //TODO
    //Iterable<OrdineEntity> getOrdersFromComanda(int idcomanda);

    //TODO
    //Iterable<OrdineEntity> getOrdersOfCliente(String idcliente);

    Optional<ComandaEntity> getComanda(String idcliente);

}
