package com.example.gestionecliente.Domain.Entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Oggetto Entity per la base dati Comanda
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Comanda", schema = "serveeasy", catalog = "")
public class ComandaEntity {

    /**
     * Identificativo della comanda
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;

    /**
     * Identificativo del cliente
     */
    @Basic
    @Column(name = "ID_cliente", nullable = false, length = 10)
    private String idCliente;

    /**
     * Codice di pagamento
     */
    @Basic
    @Column(name = "codice_pagamento", nullable = true, length = 255)
    private String codicePagamento;

    /**
     * Costo totale dei piatti ordinati a scontrino
     */
    @Basic
    @Column(name = "totale_scontrino", nullable = true, precision = 0)
    private Double totaleScontrino;

}
