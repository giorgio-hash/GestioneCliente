package com.example.gestionecliente.Interface.HTTPController;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@EnableKafka
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@EmbeddedKafka(partitions = 1,
        controlledShutdown = false,
        brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" },
        topics = {"${spring.kafka.producer.topic}"})
@AutoConfigureMockMvc
@Sql({"/db/schema.sql","/db/data-test.sql"})
public class RestControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private EmbeddedKafkaBroker embeddedKafka;
    @Value("${spring.kafka.producer.topic}")
    private String producerTopic;


    @Test
    @Order(1)
    public void testThatGetMenuGives200WhenNotEmpty() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.get("/cliente/menu")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }


    @Test
    @Order(2)
    public void testThatGetPiattoGives200WhenNotEmpty() throws Exception {

        String idpiatto = "ZUDICA";
        mockMvc.perform(
                MockMvcRequestBuilders.get("/cliente/menu/"+idpiatto)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }

    @Test
    @Order(3)
    public void testThatCreatingANewComandaWhenNoComandaExistsGives200() throws Exception {

        String idcliente = "tavolo1";
        mockMvc.perform(
                MockMvcRequestBuilders.get("/cliente/"+idcliente+"/comanda/new")
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }

    @Test
    @Order(4)
    public void testThatCreatingANewComandaWhenComandaExistsGives403() throws Exception {

        String idcliente = "tavolo1";
        mockMvc.perform(
                MockMvcRequestBuilders.get("/cliente/"+idcliente+"/comanda/new")
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );

        mockMvc.perform(
                MockMvcRequestBuilders.get("/cliente/"+idcliente+"/comanda/new")
        ).andExpect(
                MockMvcResultMatchers.status().isForbidden()
        );
    }

    @Test
    @Order(5)
    public void testThatRetrievingActiveComandaWhenExistsGives200() throws Exception {

        String idcliente = "tavolo1";
        mockMvc.perform(
                MockMvcRequestBuilders.get("/cliente/"+idcliente+"/comanda/new")
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );

        mockMvc.perform(
                MockMvcRequestBuilders.get("/cliente/"+idcliente+"/comanda/attiva")
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }

    @Test
    @Order(6)
    public void testPopulateActiveComandaAndRetrievingOrdersReturns200() throws Exception {

        String idcliente = "tavolo1";
        String idpiatto = "ZUDICA";
        mockMvc.perform(
                MockMvcRequestBuilders.get("/cliente/"+idcliente+"/comanda/new")
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );

        for(int i=0;i<3;i++)
            mockMvc.perform(
                    MockMvcRequestBuilders.post("/cliente/order/add")
                            .param("idcliente",idcliente)
                            .param("idpiatto",idpiatto)
            ).andExpect(
                    MockMvcResultMatchers.status().isOk()
            );

        mockMvc.perform(
                MockMvcRequestBuilders.get("/cliente/"+idcliente+"/orders")
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }

}
