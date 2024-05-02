package com.example.gestionecliente.Domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Oggetto Entity per la base dati Comanda
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComandaDTO {

    /**
     * Identificativo della comanda
     */
    private int id;

    /**
     * Identificativo del cliente
     */
    private String idCliente;

    /**
     * Codice di pagamento
     */
    private String codicePagamento;

    /**
     * Costo totale dei piatti ordinati a scontrino
     */
    private Double totaleScontrino;

}