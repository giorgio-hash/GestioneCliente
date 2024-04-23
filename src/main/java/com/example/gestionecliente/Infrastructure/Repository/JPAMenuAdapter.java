package com.example.gestionecliente.Infrastructure.Repository;

import com.example.gestionecliente.Domain.ports.DataMenuPort;
import com.example.gestionecliente.Domain.Entity.PiattoEntity;
import com.example.gestionecliente.Domain.Repository.PiattoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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

    @Override
    public Optional<PiattoEntity> getPiatto(String idpiatto) {
        return pirep.findById(idpiatto);
    }
}