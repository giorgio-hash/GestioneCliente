package com.example.gestionecliente.Domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object che notifica un aggiornamento della base dati Ordine
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificaOrdineDTO {

        private int id;

        private int idComanda;

}
