package com.example.gestionecliente.Domain.ports;

import com.example.gestionecliente.Domain.Entity.PiattoEntity;
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
 * Classe di test di integrazione della DataMenuPort con operazioni CRUD sul database
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Sql({"/db/schema.sql","/db/data-test.sql"})
public class DataMenuPortTests {


    private DataMenuPort dataMenuPort;
    //private PiattoRepository pR;
    //private IngredientePrincipaleRepository iPR;

    @Autowired
    public DataMenuPortTests(DataMenuPort dataMenuPort) {
        this.dataMenuPort = dataMenuPort;
    }

    @Test
    @Order(1)
    public void testFindPiattoByID() {

        PiattoEntity expected = TestDataUtil.createPiattoEntityA();
        Optional<PiattoEntity> obtained = dataMenuPort.getPiatto("ZUDICA");


        assertThat(obtained.get().getId()).isEqualTo(expected.getId());
        assertThat(obtained.get().getIdIngrPrinc()).isEqualTo(expected.getIdIngrPrinc());
        assertThat(obtained.get().getPrezzo()).isEqualTo(expected.getPrezzo());
        assertThat(obtained.get().getDescrizione()).isEqualTo(expected.getDescrizione());
        assertThat(obtained.get().getTPreparazione()).isEqualTo(expected.getTPreparazione());
    }


    @Test
    @Order(2)
    public void testFindAllPiatto(){

        PiattoEntity existingA = TestDataUtil.createPiattoEntityA();
        PiattoEntity existingB = TestDataUtil.createPiattoEntityB();

        Iterable<PiattoEntity> obtained = dataMenuPort.getMenu();

        assertThat(Iterables.getLength(obtained)).isGreaterThan(0);
        assertThat(Iterables.getLength(obtained)).isEqualTo(2);

        for(PiattoEntity p : obtained){
            if(p.getId().equals("ZUCCVE"))
                assertThat(p).isEqualTo(existingB);
            if(p.getId().equals("ZUDICA"))
                assertThat(p).isEqualTo(existingA);
        }
    }
}