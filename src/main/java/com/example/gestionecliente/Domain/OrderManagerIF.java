package com.example.gestionecliente.Domain;

import com.example.gestionecliente.Domain.Entity.OrdineEntity;

import java.util.Optional;

public interface OrderManagerIF {

    OrdineEntity addNewOrder(String idcliente, String idpiatto);

    Optional<OrdineEntity> getOrder(int id, int idcomanda);
}
