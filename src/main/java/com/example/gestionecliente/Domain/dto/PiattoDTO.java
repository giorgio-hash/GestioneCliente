package com.example.gestionecliente.Domain.dto;

import lombok.*;

/**
 * Oggetto DTO per la classe PiattoEntity
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PiattoDTO {

    /**
     * Identificativo del piatto
     */
    private String id;

    /**
     * Identificativo dell'ingrediente principale
     */
    private String idIngrPrinc;

    /**
     * Descrizione del piatto
     */
    private String descrizione;

    /**
     * Prezzo del piatto
     */
    private double prezzo;

    /**
     * Tempo medio di preparazione del piatto
     */
    private int tPreparazione;

}
