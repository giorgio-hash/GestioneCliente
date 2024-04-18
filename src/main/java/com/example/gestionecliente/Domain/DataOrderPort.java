package com.example.GestioneCliente.Domain;

import com.example.GestioneCliente.Domain.Entity.ClienteEntity;

public interface DataOrderPort {
    void getOrderData();
    void setOrderStatus();

    Iterable<ClienteEntity> getClienti();
}
