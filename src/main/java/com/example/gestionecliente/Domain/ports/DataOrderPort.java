package com.example.gestionecliente.Domain.ports;

import com.example.gestionecliente.Domain.Entity.ClienteEntity;
import com.example.gestionecliente.Domain.Entity.ComandaEntity;
import com.example.gestionecliente.Domain.Entity.OrdineEntity;

import java.util.Optional;

/**
 * Porta per gli adattatori verso la base dati Ordine, Comanda, Cliente
 */
public interface DataOrderPort {
    /**
     * Consente l'inserimento di un ordine nella base dati.
     * @param o oggetto entità di classe <i>OrdineEntity<i/>
     * @return oggetto entità di classe <i>OrdineEntity<i/>
     */
    OrdineEntity insertOrder(OrdineEntity o);

    /**
     * Restituisce uno specifico ordine, se esistente nella base dati.
     * @param id identificativo dell'ordine di tipo intero
     * @return container <i>Optional<i/> contenente oggetto <i>OrdineEntity<i/> oppure null
     */
    Optional<OrdineEntity> getOrder(int id);

    /**
     * Restituisce lo stato di uno specifico ordine, se l'ordine esiste nella base dati.
     * @param id identificativo dell'ordine di tipo intero
     * @return un intero compreso tra 0(in attesa), 1=(in preparazione), 2(pronto) oppure -1 in caso di errore o id non valido
     */
    int getOrderStatus(int id);

    /**
     * Inserisce una nuova comanda nel database.
     * @param c oggetto entità di classe ComandaEntity
     * @return oggetto entità di classe ComandaEntity
     */
    ComandaEntity insertComanda(ComandaEntity c);

    /**
     * Ritorna la comanda attualmente aperta per lo specifico cliente (campo {@code codice_pagamento con valore {@code null} }).
     * @param idcliente identificativo del cliente di classe {@code idcliente}
     * @return oggetto container {@code Optional} contenente {@code ComandaEntity} oppure {@code null}
     */
    Optional<ComandaEntity> getComandaAttiva(String idcliente);

    //TODO
    void insertTakeoutPhoneNum(ClienteEntity c);
    //TODO
    Iterable<ClienteEntity> getClienti();
    //TODO
    void deleteTakeoutPhoneNum(ClienteEntity c);
}
