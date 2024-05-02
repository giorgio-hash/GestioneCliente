package com.example.gestionecliente.Domain.Entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Oggetto Entity per la base dati Piatto
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Piatto", schema = "serveeasy", catalog = "")
public class PiattoEntity {

    /**
     * Identificativo del piatto
     */
    @Id
    @Column(name = "ID", nullable = false, length = 20)
    private String id;

    /**
     * Identificativo dell'ingrediente principale
     */
    @Basic
    @Column(name = "ID_ingr_princ", nullable = false, length = 20)
    private String idIngrPrinc;

    /**
     * Descrizione del piatto
     */
    @Basic
    @Column(name = "descrizione", nullable = true, length = 50)
    private String descrizione;

    /**
     * Prezzo del piatto
     */
    @Basic
    @Column(name = "prezzo", nullable = false, precision = 0)
    private double prezzo;

    /**
     * Tempo medio di preparazione del piatto
     */
    @Basic
    @Column(name = "t_preparazione", nullable = false)
    private int tPreparazione;

}
