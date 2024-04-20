package com.example.GestioneCliente.Domain.services;

public interface OrdineService {

    /**
     * Salva l'entita' ordine all'interno del database
     *
     * @param ordineEntity entità ordine da salvare
     * @return entita' ordine salvata
     */
    OrdineEntity save(OrdineEntity ordineEntity);

}
