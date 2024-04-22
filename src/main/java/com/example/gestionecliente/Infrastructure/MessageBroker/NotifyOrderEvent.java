package com.example.gestionecliente.Infrastructure.MessageBroker;

import com.example.gestionecliente.Domain.dto.NotificaOrdineDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface NotifyOrderEvent {
    void sendMessageToTopic(NotificaOrdineDTO notificaOrdineDTO) throws     JsonProcessingException;
}
