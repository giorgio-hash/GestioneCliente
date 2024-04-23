package com.example.gestionecliente.Domain.ports;

import com.example.gestionecliente.Domain.Entity.PiattoEntity;

import java.util.Optional;

/**
 * Porta per gli adattatori verso la base dati Piatto e IngredientePrincipale
 */
public interface DataMenuPort {
    /**
     * Restituisce tutti i piatti del menu.
     * @return collezione <i>Iterable<i/> di <i>PiattoEntity<i/>
     */
    Iterable<PiattoEntity> getMenu();

    /**
     * Restituisce uno specifico piatto del menu.
     * @param idpiatto identificativo del piatto di tipo <i>String<i/>
     * @return container <i>Optional<i/> che può contenere un <i>PiattoEntity<i/> oppure <i>null<i/>
     */
    Optional<PiattoEntity> getPiatto(String idpiatto);
}
