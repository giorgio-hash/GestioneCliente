package com.example.gestionecliente.Domain;

import com.example.gestionecliente.Domain.Entity.PiattoEntity;

import java.util.Optional;

public interface DataMenuPort {
    Iterable<PiattoEntity> getMenu();

    Optional<PiattoEntity> getPiatto(String idpiatto);
}
