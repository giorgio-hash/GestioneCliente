package com.example.gestionecliente.Infrastructure.Repository;

import com.example.gestionecliente.Domain.DataMenuPort;
import com.example.gestionecliente.Domain.Entity.PiattoEntity;
import com.example.gestionecliente.Domain.Repository.PiattoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JPAMenuAdapter implements DataMenuPort {

    private final PiattoRepository pirep;
    @Autowired
    public JPAMenuAdapter(PiattoRepository pirep) {
        this.pirep = pirep;
    }


    @Override
    public Iterable<PiattoEntity> getMenu() {
        return pirep.findAll();
    }
}