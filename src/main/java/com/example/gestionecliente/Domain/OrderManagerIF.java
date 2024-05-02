package com.example.gestionecliente.Domain;

import com.example.gestionecliente.Domain.Entity.ComandaEntity;
import com.example.gestionecliente.Domain.Entity.OrdineEntity;

import java.util.Optional;

/**
 * Interfaccia per la gestione delle operazioni su ordini, comande e clienti
 */
public interface OrderManagerIF {

    /**
     * Restituisce gli ordini di un certo cliente
     * @param idcliente identificativo di entità {@code OrdineEntity}
     * @return una container {@code Optional} contenente {@code null} oppure una collezione {@code Iterable} di oggetti {@code OrdineEntity}
     */
    Optional<Iterable<OrdineEntity>> getOrdersOfCliente(String idcliente);

    /**
     * Crea una nuova comanda per il cliente specificato
     * @param idcliente identificativo cliente di tipo {@code String}
     * @return oggetto entità di tipo {@code ComandaEntity}
     */
    ComandaEntity newComanda(String idcliente);

    /**
     * Restituisce la comanda attiva per lo specifico cliente
     * @param idcliente identificativo di tipo {@code String}
     * @return container {@code Optional} contenente oggetto {@code ComandaEntity} oppure {@code null}
     */
    Optional<ComandaEntity> getComandaAttiva(String idcliente);

    /**
     * Aggiunge un nuovo ordine alla comanda specificata
     * @param idcomanda identificativo della comanda, tipo intero
     * @param idpiatto identificativo del piatto di tipo {@code String}
     * @return oggetto inserito, di classe {@code OrdineEntity}
     */
    OrdineEntity addNewOrder(int idcomanda, String idpiatto, int urgenzacliente);

    /**
     * Restituisce l'ordine specificato.
     * @param id identificativo ordine di tipo intero
     * @return container {@code Optional} contentente oggetto {@code OrdineEntity} oppure {@code null}
     */
    Optional<OrdineEntity> getOrder(int id);

    /**
     * Restituisce lo stato di uno specifico ordine, se l'ordine esiste nella base dati.
     * @param id identificativo dell'ordine di tipo intero
     * @return un intero compreso tra 0(in attesa), 1=(in preparazione), 2(pronto) oppure -1 in caso di errore o id non valido
     */
    int getOrderStatus(int id);

}
