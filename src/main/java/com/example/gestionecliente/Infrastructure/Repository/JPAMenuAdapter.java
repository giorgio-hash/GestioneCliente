package com.example.GestioneCliente.Infrastructure.Repository;

import com.example.GestioneCliente.Domain.DataOrderPort;
import com.example.GestioneCliente.Domain.Entity.ClienteEntity;
import com.example.GestioneCliente.Domain.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JPAMenuAdapter implements DataOrderPort {

    private final ClienteRepository clrep;

    @Autowired
    public JPAMenuAdapter(ClienteRepository clrep) {
        this.clrep = clrep;
    }

    @Override
    public void getOrderData() {

    }

    @Override
    public void setOrderStatus() {

    }

    @Override
    public Iterable<ClienteEntity> getClienti() {
        return clrep.findAll();
    }
}