package com.example.gestionecliente.Domain;

import com.example.gestionecliente.Domain.Entity.ComandaEntity;
import com.example.gestionecliente.Domain.Entity.OrdineEntity;
import com.example.gestionecliente.Domain.Entity.PiattoEntity;

import java.util.Optional;

public interface FrontSignalPort {

    Iterable<PiattoEntity> getMenu();

    Optional<PiattoEntity> getPiatto(String idpiatto);
    OrdineEntity newOrder(String idcliente, String nomepiatto);

    Optional<OrdineEntity> getOrder(int id, int idcomanda);

    int getOrderStatus(int id, int idcomanda);

    //TODO
    //Iterable<OrdineEntity> getOrdersFromComanda(int idcomanda);

    Optional<ComandaEntity> getComanda(String idcliente);


}
