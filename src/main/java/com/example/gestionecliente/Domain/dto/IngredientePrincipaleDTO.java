package com.example.gestionecliente.Domain.dto;

import jakarta.persistence.*;
import lombok.*;

/**
 * DTO della classe IngredientePrincipaleEntity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IngredientePrincipaleDTO {

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