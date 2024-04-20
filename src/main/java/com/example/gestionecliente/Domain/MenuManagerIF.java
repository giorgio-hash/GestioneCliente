package com.example.gestionecliente.Domain;

import com.example.gestionecliente.Domain.Entity.PiattoEntity;

import java.util.Optional;

public interface MenuManagerIF {

    Optional<PiattoEntity> getPiatto(String idpiatto);
    Iterable<PiattoEntity> getMenu();
}
