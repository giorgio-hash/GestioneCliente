package com.example.gestionecliente.Domain;

import com.example.gestionecliente.Domain.Entity.OrdineEntity;
import com.example.gestionecliente.Domain.Entity.PiattoEntity;

import java.util.Optional;

public interface FrontSignalPort {

    Iterable<PiattoEntity> getMenu();
    OrdineEntity newOrder(String idcliente, String nomepiatto);

    Optional<OrdineEntity> getOrder(int id, int idcomanda);
}
