package com.example.GestioneCliente.Domain;

import com.example.GestioneCliente.Domain.Entity.ClienteEntity;

public interface FrontSignalPort {

    Iterable<ClienteEntity> getClienti();
}
