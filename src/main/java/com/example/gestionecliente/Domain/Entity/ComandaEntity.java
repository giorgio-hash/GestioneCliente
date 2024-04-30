package com.example.gestionecliente.Domain.Entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Oggetto Entity per la base dati Comanda
 */
@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Comanda", schema = "serveeasy", catalog = "")
public class ComandaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "ID_cliente", nullable = false, length = 10)
    private String idCliente;
    @Basic
    @Column(name = "codice_pagamento", nullable = true, length = 255)
    private String codicePagamento;
    @Basic
    @Column(name = "totale_scontrino", nullable = true, precision = 0)
    private Double totaleScontrino;

}
