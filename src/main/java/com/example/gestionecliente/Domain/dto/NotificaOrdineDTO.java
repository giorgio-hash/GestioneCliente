package com.example.gestionecliente.Domain.dto;

import lombok.*;

/**
 * Data Transfer Object che notifica un aggiornamento della base dati Ordine
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class NotificaOrdineDTO {

        private int id;

        private int idComanda;

}
