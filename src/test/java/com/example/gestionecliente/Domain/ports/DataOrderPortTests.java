package com.example.gestionecliente.Domain.ports;

import com.example.gestionecliente.Domain.Entity.ComandaEntity;
import com.example.gestionecliente.Domain.Entity.OrdineEntity;
import com.example.gestionecliente.Domain.Repository.ComandaRepository;
import com.example.gestionecliente.util.TestDataUtil;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.internal.util.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Classe di test di integrazione della DataOrderPort con operazioni CRUD sul database
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Sql({"/db/schema.sql","/db/data-test.sql"})
public class DataOrderPortTests {

    private final DataOrderPort dataOrderPort;
    private final ComandaRepository crep;

    @Autowired
    public DataOrderPortTests(DataOrderPort dataOrderPort, ComandaRepository crep) {
        this.dataOrderPort = dataOrderPort;
        this.crep = crep;
    }

    @Test
    @Order(1)
    public void testInsertNewComandaForCliente(){

        ComandaEntity insert = TestDataUtil.createComandaEntityC();

        ComandaEntity res = dataOrderPort.insertComanda(insert);
        Optional<ComandaEntity> obtained = dataOrderPort.getComandaAttiva("tavolo1");

        assertThat(obtained.isPresent()).isTrue();

        assertThat(obtained.get().getIdCliente()).isEqualTo(insert.getIdCliente());

        assertThat(obtained.get().getIdCliente()).isEqualTo(res.getIdCliente());
        assertThat(obtained.get().getId()).isEqualTo(res.getId());
        assertThat(obtained.get().getCodicePagamento()).isEqualTo(res.getCodicePagamento());
        assertThat(obtained.get().getTotaleScontrino()).isEqualTo(res.getTotaleScontrino());

    }

    @Test
    @Order(2)
    public void testInsertOrderAndFindById(){

        ComandaEntity existingComanda = TestDataUtil.createComandaEntityC();
        crep.save(existingComanda);
        OrdineEntity insertOrdine = TestDataUtil.createOrdineEntityC();

        OrdineEntity res = dataOrderPort.insertOrder(insertOrdine);
        Optional<OrdineEntity> obtained = dataOrderPort.getOrder(1);

        assertThat(obtained.isPresent()).isTrue();
        assertThat(obtained.get().getId()).isEqualTo(res.getId());
        assertThat(obtained.get().getIdComanda()).isEqualTo(res.getIdComanda()).isEqualTo(existingComanda.getId());
    }


    @Test
    @Order(3)
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

    @Test
    @Order(4)
    public void testFetchAllOrdersOfComanda(){
        ComandaEntity existingComanda = TestDataUtil.createComandaEntityC();
        ComandaEntity insert = dataOrderPort.insertComanda(existingComanda);

        for(int i=0;i<3;i++)
            dataOrderPort.insertOrder(TestDataUtil.createOrdineEntityC());

        Iterable<OrdineEntity> oe = dataOrderPort.getOrdersOfComanda(insert.getId());
        assertThat(Iterables.getLength(oe)).isEqualTo(3);
        for(OrdineEntity o : oe)
            assertThat(o).isInstanceOf(OrdineEntity.class);
    }
}