package com.example.gestionecliente.Domain.mappers;

import com.example.gestionecliente.Domain.Entity.OrdineEntity;
import com.example.gestionecliente.Domain.dto.NotificaOrdineDTO;
import com.example.gestionecliente.Domain.mapper.impl.NotificaOrdineMapper;
import com.example.gestionecliente.util.TestDataUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * In questa classe di test si verifica il corretto funzionamento dei mapper per la classe OrdineEntity e OrdineDTO
 */
@SpringBootTest
public class NotificaOrdineMapperTests {

    @Autowired
    private NotificaOrdineMapper notificaOrdineMapper;

    @Test
    public void testMapTo(){

        OrdineEntity ordineEntity = TestDataUtil.createOrdineEntityB();
        NotificaOrdineDTO notificaOrdineDTO = notificaOrdineMapper.mapTo(ordineEntity);

        assertThat(notificaOrdineDTO.getId()).isEqualTo(ordineEntity.getId());
        assertThat(notificaOrdineDTO.getIdComanda()).isEqualTo(ordineEntity.getIdComanda());

    }

    @Test
    public void testMapFrom(){

        NotificaOrdineDTO ordineDTO = TestDataUtil.createOrdineDtoB();
        OrdineEntity ordineEntity = notificaOrdineMapper.mapFrom(ordineDTO);
        assertThat(ordineEntity.getId()).isEqualTo(ordineDTO.getId());
        assertThat(ordineEntity.getIdComanda()).isEqualTo(ordineDTO.getIdComanda());

    }

}
