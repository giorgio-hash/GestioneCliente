package com.example.gestionecliente.Domain;

import com.example.gestionecliente.Domain.dto.NotificaOrdineDTO;

public interface MessagePort {
    void sendOrder(NotificaOrdineDTO notificaOrdineDTO);
}
