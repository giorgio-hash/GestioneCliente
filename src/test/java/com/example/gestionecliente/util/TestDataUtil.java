package com.example.gestionecliente.util;

import com.example.gestionecliente.Domain.Entity.ComandaEntity;
import com.example.gestionecliente.Domain.Entity.OrdineEntity;
import com.example.gestionecliente.Domain.Entity.PiattoEntity;
import com.example.gestionecliente.Domain.dto.NotificaOrdineDTO;

public class TestDataUtil {

    public static PiattoEntity createPiattoEntityA(){
        return PiattoEntity.builder()
                .id("ZUDICA")
                .idIngrPrinc("CAARA")
                .descrizione("zuppa di carote arancioni con panna")
                .prezzo(10)
                .tPreparazione(300)
                .build();
    }
    public static PiattoEntity createPiattoEntityB(){
        return PiattoEntity.builder()
                .id("ZUCCLES")
                .idIngrPrinc("ZUCCVE")
                .descrizione("Zucchine lesse")
                .prezzo(10)
                .tPreparazione(400)
                .build();
    }

    public static OrdineEntity createOrdineEntityB(){
        return OrdineEntity.builder()
                .idComanda(1)
                .idPiatto("SPA279")
                .stato(1)
                .urgenzaCliente(1)
                .build();
    }

    public static NotificaOrdineDTO createOrdineDtoB(){
        return NotificaOrdineDTO.builder()
                .idComanda(1)
                .build();
    }

    public static OrdineEntity createOrdineEntityC(){
        return OrdineEntity.builder()
                .idComanda(1)
                .idPiatto("ZUDICA")
                .build();
    }

    public static ComandaEntity createComandaEntityC(){
        return ComandaEntity.builder()
                .idCliente("tavolo1")
                .build();
    }

    public static ComandaEntity createComandaEntityD(){
        return ComandaEntity.builder()
                .idCliente("tavolo1")
                .build();
    }

}
