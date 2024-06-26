package com.example.gestionecliente.Domain.Entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Oggetto Entity per la base dati Cliente
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Cliente", schema = "serveeasy", catalog = "")
public class ClienteEntity {

    /**
     * Identificativo del Cliente
     */
    @Id
    @Column(name = "ID", nullable = false, length = 10)
    private String id;

    /**
     * Campo che specifica se il cliente è da tavolo o da asporto:
     * 0: il cliente è d'asporto,
     * 1: il cliente è da tavolo
     */
    @Basic
    @Column(name = "t_o_a", nullable = false)
    private byte tOA;

}
