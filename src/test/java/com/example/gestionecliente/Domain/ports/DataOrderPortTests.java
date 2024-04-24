package com.example.gestionecliente.Domain.ports;

import com.example.gestionecliente.Domain.Entity.ComandaEntity;
import com.example.gestionecliente.Domain.Entity.OrdineEntity;
import com.example.gestionecliente.Domain.Repository.ComandaRepository;
import com.example.gestionecliente.util.TestDataUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Classe di test di integrazione della DataOrderPort con operazioni CRUD sul database
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class DataOrderPortTests {

    private final DataOrderPort dataOrderPort;
    private final ComandaRepository crep;

    @Autowired
    public DataOrderPortTests(DataOrderPort dataOrderPort, ComandaRepository crep) {
        this.dataOrderPort = dataOrderPort;
        this.crep = crep;
    }

    @Test
    public void testInsertNewComandaForCliente(){

        ComandaEntity insert = TestDataUtil.createComandaEntityC();

        ComandaEntity res = dataOrderPort.insertComanda(insert);
        Optional<ComandaEntity> obtained = dataOrderPort.getComandaAttiva(res.getIdCliente());

        assertThat(obtained.isPresent()).isTrue();

        assertThat(obtained.get().getIdCliente()).isEqualTo(insert.getIdCliente());

        assertThat(obtained.get().getIdCliente()).isEqualTo(res.getIdCliente());
        assertThat(obtained.get().getId()).isEqualTo(res.getId());
        assertThat(obtained.get().getCodicePagamento()).isEqualTo(res.getCodicePagamento());
        assertThat(obtained.get().getTotaleScontrino()).isEqualTo(res.getTotaleScontrino());

    }

    @Test
    public void testInsertOrderAndFindById(){

        ComandaEntity existingComanda = TestDataUtil.createComandaEntityC();
        crep.save(existingComanda);
        OrdineEntity insertOrdine = TestDataUtil.createOrdineEntityC();

        OrdineEntity res = dataOrderPort.insertOrder(insertOrdine);
        Optional<OrdineEntity> obtained = dataOrderPort.getOrder(res.getId());

        assertThat(obtained.isPresent()).isTrue();
        assertThat(obtained.get().getId()).isEqualTo(res.getId());
        assertThat(obtained.get().getIdComanda()).isEqualTo(res.getIdComanda()).isEqualTo(existingComanda.getId());
    }


    @Test
    public void testInsertNewComandaAttiva(){

        ComandaEntity existingComanda = TestDataUtil.createComandaEntityC();
        existingComanda.setCodicePagamento("COD34958");
        existingComanda.setTotaleScontrino(23.0);
        crep.save(existingComanda);
        ComandaEntity insertComanda = TestDataUtil.createComandaEntityD();

        ComandaEntity res = dataOrderPort.insertComanda(insertComanda);
        Optional<ComandaEntity> obtained = dataOrderPort.getComandaAttiva("tavolo1");

        assertThat(obtained.isPresent()).isTrue();
        assertThat(obtained.get().getId()).isEqualTo(res.getId());
        assertThat(obtained.get().getIdCliente()).isEqualTo(res.getIdCliente());
    }
}