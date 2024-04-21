package com.example.gestionecliente.Domain;

import com.example.gestionecliente.Domain.Entity.ClienteEntity;
import com.example.gestionecliente.Domain.Entity.ComandaEntity;
import com.example.gestionecliente.Domain.Entity.OrdineEntity;

import java.util.Optional;

public interface DataOrderPort {
    OrdineEntity insertOrder(OrdineEntity o);
    Optional<OrdineEntity> getOrder(int id);

    int getOrderStatus(int id);

    ComandaEntity insertComanda(ComandaEntity c);

    Optional<ComandaEntity> getComanda(String idcliente);

    void insertTakeoutPhoneNum(ClienteEntity c);
    Iterable<ClienteEntity> getClienti();
    void deleteTakeoutPhoneNum(ClienteEntity c);
}
