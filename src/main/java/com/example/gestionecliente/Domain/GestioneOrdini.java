package com.example.GestioneCliente.Domain;

import com.example.GestioneCliente.Domain.Entity.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestioneOrdini{
    private final DataOrderPort DataOrderPort;

    @Autowired
    public GestioneOrdini(DataOrderPort DataOrderPort) {
        this.DataOrderPort = DataOrderPort;
    }

}
