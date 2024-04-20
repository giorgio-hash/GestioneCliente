package com.example.GestioneCliente.Domain.services.impl;

import com.example.GestioneCliente.Domain.services.OrdineService;
import org.springframework.stereotype.Service;

@Service
public class OrdineServiceImpl implements OrdineService {

    /**
     * Salva l'entita' ordine all'interno del database
     *
     * @param ordineEntity entità ordine da salvare
     * @return entita' ordine salvata
     */
    @Override
    public OrdineEntity save(OrdineEntity ordineEntity) {
        return ordineEntity;
    }

}