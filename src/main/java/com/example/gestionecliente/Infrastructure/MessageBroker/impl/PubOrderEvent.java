package com.example.gestionecliente.Infrastructure.MessageBroker.impl;

import com.example.gestionecliente.Domain.MessagePort;
import com.example.gestionecliente.Domain.dto.NotificaOrdineDTO;
import com.example.gestionecliente.Infrastructure.MessageBroker.NotifyOrderEvent;
import com.example.gestionecliente.Infrastructure.MessageBroker.PubOrderProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PubOrderEvent implements MessagePort, NotifyOrderEvent {

    private PubOrderProducer pubOrderProducer;

    @Autowired
    public PubOrderEvent(PubOrderProducer pubOrderProducer) {
        this.pubOrderProducer = pubOrderProducer;
    }

    @Override
    public void sendOrder(NotificaOrdineDTO notificaOrdineDTO) {
        try {
            sendMessageToTopic(notificaOrdineDTO);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void sendMessageToTopic(NotificaOrdineDTO notificaOrdineDTO) throws JsonProcessingException {
        pubOrderProducer.send(notificaOrdineDTO);
    }
}
