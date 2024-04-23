package com.example.gestionecliente.Domain.ports;

import com.example.gestionecliente.Domain.Entity.ComandaEntity;
import com.example.gestionecliente.Domain.Entity.OrdineEntity;
import com.example.gestionecliente.Domain.Entity.PiattoEntity;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Optional;

/**
 * Porta tra l'area <i>Interface<i/> e l'area <i>Domain<i/> per
 * distinguere e risolvere in macro-aree funzionali la logica di business legata
 * alle richieste in arrivo verso GestioneCliente
 */
public interface FrontSignalPort {

    /**
     * Richiesta per ottenere tutti gli oggetti dalla base dati Piatto.
     * @return collezione <i>Iterable<i/> di <i>PiattoEntity<i/>
     */
    Iterable<PiattoEntity> getMenu();

    /**
     * Richiesta per ottenere una specifica tupla dalla base dati Piatto.
     * @param idpiatto identificativo del piatto di tipo <i>String<i/>
     * @return un oggetto container di tipo Optional che potrebbe contenere <i>PiattoEntity<i/> oppure <i>null<i/>
     */
    Optional<PiattoEntity> getPiatto(String idpiatto);

    /**
     * Richiesta per ottenere l'assegnazione di una nuova comanda al cliente.
     * Richiede che la comanda precedente venga chiusa.
     *
     * @param idcliente
     * @return oggetto entità di tipo <i>ComandaEntity<i/>
     */
    Optional<ComandaEntity> newComanda(String idcliente);

    Optional<ComandaEntity> getComandaAttiva(String idcliente);

    /**
     * Richiesta per ottenere l'inserimento di un nuovo ordine
     * @param idcomanda
     * @param nomepiatto
     * @return
     * @throws JsonProcessingException
     */
    OrdineEntity newOrder(int idcomanda, String nomepiatto) throws JsonProcessingException;

    Optional<OrdineEntity> getOrder(int id);

    int getOrderStatus(int id);

    //TODO
    //Iterable<OrdineEntity> getOrdersFromComanda(int idcomanda);


}
