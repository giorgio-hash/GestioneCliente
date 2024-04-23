package com.example.gestionecliente.Domain;

import com.example.gestionecliente.Domain.Entity.PiattoEntity;

import java.util.Optional;

/**
 * Interfaccia per la gestione delle operazioni su Piatto, IngredientePrincipale
 */
public interface MenuManagerIF {

    /**
     * Restituisce uno specifico piatto del menu.
     * @param idpiatto identificativo del piatto di tipo <i>String<i/>
     * @return container <i>Optional<i/> che può contenere un <i>PiattoEntity<i/> oppure <i>null<i/>
     */
    Optional<PiattoEntity> getPiatto(String idpiatto);
    /**
     * Restituisce tutti i piatti del menu.
     * @return collezione <i>Iterable<i/> di <i>PiattoEntity<i/>
     */
    Iterable<PiattoEntity> getMenu();
}
