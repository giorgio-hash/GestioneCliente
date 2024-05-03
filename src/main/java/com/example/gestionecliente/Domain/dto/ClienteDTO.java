package com.example.gestionecliente.Domain.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Oggetto DTO per la classe ClienteEntity
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    /**
     * Identificativo del Cliente
     */
    private String id;

    /**
     * Campo che specifica se il cliente è da tavolo o da asporto:
     * 0: il cliente è d'asporto,
     * 1: il cliente è da tavolo
     */
    private byte tOA;

}
