package com.example.gestionecliente.Domain;

import java.util.Optional;

/**
 * interfaccia per velocizzare la gestione delle sessioni attive dei clienti
 */
public interface SessioneIF {

    /**
     * Restituisce la comanda attiva attualmente assegnata al cliente
     * @param idcliente identificativo del cliente
     * @return container <i>Optional<i/> che può restituire un oggetto <i>Integer<i/> oppure <i>null<i/>
     */
    Optional<Integer> getComanda(String idcliente);

    /**
     * Restituisce la comanda attiva a cui l'ordine è attualmente assegnato
     * @param idordine identificativo del ordine
     * @return container <i>Optional<i/> che può restituire un oggetto <i>Integer<i/> oppure <i>null<i/>
     */
    Optional<Integer> getComanda(int idordine);

    /**
     * Assegna una nuova comanda al cliente
     * @param idcliente identificativo del cliente
     * @param idcomanda identificativo della nuova comanda da assegmare
     */
    void newComanda(String idcliente, int idcomanda);

    /**
     * Assegna un ordine ad una comanda
     * @param idordine identificativo del ordine
     * @param idcomanda identificativo della comanda esistente
     */
    void assignToComanda(int idordine,int idcomanda);

    /**
     * Restituisce tutti gli id degli ordini assegnati alla comanda
     * @param idcomanda identificativo della comanda
     * @return collezione <i>Iterable<i/> di oggetti <i>Integer<i/>
     */
    Iterable<Integer> getOrdinersFromComanda(int idcomanda);

    /**
     * rimuove la comanda attiva assegnata al cliente
     * @param idcliente identificativo del cliente
     */
    void deleteComanda(int idcliente);

    /**
     * Aggiunge cliente alla matrice
     * @param idcliente identificativo del cliente
     */
    void addCliente(String idcliente);

    /**Rimuove cliente dalla matrice
     * @param idcliente identificativo del cliente
     */
    void deleteCliente(String idcliente);
}
