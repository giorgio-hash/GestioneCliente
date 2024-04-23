package com.example.gestionecliente.Domain;

import com.example.gestionecliente.Domain.Entity.ComandaEntity;
import com.example.gestionecliente.Domain.Entity.OrdineEntity;

import java.util.Optional;

public interface OrderManagerIF {

    //TODO
    //Iterable<OrdineEntity> getOrdersFromComanda(int idcomanda);
    ComandaEntity newComanda(String idcliente);
    Optional<ComandaEntity> getComandaAttiva(String idcliente);
    OrdineEntity addNewOrder(int idcomanda, String idpiatto);

    Optional<OrdineEntity> getOrder(int id);

    int getOrderStatus(int id);

}
