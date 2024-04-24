package com.example.gestionecliente.Infrastructure.MessageBroker;

import com.example.gestionecliente.Domain.dto.NotificaOrdineDTO;
import com.example.gestionecliente.util.TestDataUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.java.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.text.SimpleDateFormat;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Questa è una classe di test per testare la serializzazione e deserializzazione via Jackson
 * con l'oggetto ObjectMapper
 */
@JsonTest
@Log
public class JacksonTests {

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup(){
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));
    }

    @Test
    public void testSerialization() throws JsonProcessingException {

        NotificaOrdineDTO notificaOrdineDto = TestDataUtil.createOrdineDtoB();

        // Serializzazione
        String json = objectMapper.writeValueAsString(notificaOrdineDto);

        log.info("from: " + notificaOrdineDto.toString());
        log.info("to:" + json);

        assertThat(json).isEqualTo("{\"id\":"  + notificaOrdineDto.getId()
                + ",\"idComanda\":" +  notificaOrdineDto.getIdComanda()
                + "}");
    }

}
