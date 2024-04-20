package com.example.gestionecliente.Domain;

import com.example.gestionecliente.Domain.Entity.PiattoEntity;

public interface DataMenuPort {
    Iterable<PiattoEntity> getMenu();
}
