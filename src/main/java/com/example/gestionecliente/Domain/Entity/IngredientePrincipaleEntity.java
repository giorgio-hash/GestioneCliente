package com.example.gestionecliente.Domain.Entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Oggetto ingrediente principale
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "IngredientePrincipale", schema = "serveeasy", catalog = "")
public class IngredientePrincipaleEntity {

    /**
     * Identificativo dell'ingrediente principale
     */
    @Id
    @Column(name = "ID", nullable = false, length = 20)
    private String id;

    /**
     * Nome del piatto
     */
    @Basic
    @Column(name = "nome", nullable = false, length = 20)
    private String nome;

}