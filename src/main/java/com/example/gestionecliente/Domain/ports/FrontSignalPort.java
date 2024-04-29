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
     * Richiede che la comanda precedente venga chiusa prima di crearne una nuova.
     *
     * @param idcliente identificativo cliente di tipo <i>String<i/>
     * @return oggetto entità di tipo <i>ComandaEntity<i/>
     */
    Optional<ComandaEntity> newComanda(String idcliente);

    /**
     * Richiesta per ottenenere la comanda attualmente attiva per uno specifico cliente.
     * @param idcliente identificativo di tipo <i>String<i/>
     * @return container <i>Optional<i/> contenente un oggetto <i>ComandaEntity<i/> oppure <i>null<i/>
     */
    Optional<ComandaEntity> getComandaAttiva(String idcliente);

    /**
     * Richiesta per ottenere l'inserimento di un nuovo ordine per la specifica comanda.
     * @param idcomanda identificativo comanda, tipo intero
     * @param nomepiatto identificativo piatto, tipo {@code String}
     * @return oggetto inserito, di tipo {@code OrdineEntity}
     * @throws JsonProcessingException
     */
    OrdineEntity newOrder(int idcomanda, String nomepiatto) throws JsonProcessingException;

    /**
     * Richiesta per ottenere un ordine specifico.
     * @param id identificativo ordine di tipo intero
     * @return container <i>Optional<i/> contenente un oggetto <i>OrdineEntity<i/> oppure <i>null<i/>
     */
    Optional<OrdineEntity> getOrder(int id);

    /**
     * Richiesta per ottenere lo stato di un ordine specifico.
     * @param id identificativo ordine di tipo intero
     * @return un intero compreso tra 0(in attesa), 1=(in preparazione), 2(pronto) oppure -1 in caso di errore o id non valido
     */
    int getOrderStatus(int id);

    /**
     * Restituisce gli ordini di un certo cliente
     * @param idcliente identificativo di entità {@code OrdineEntity}
     * @return una container {@code Optional} contenente {@code null} oppure una collezione {@code Iterable} di oggetti {@code OrdineEntity}
     */
    Optional<Iterable<OrdineEntity>> getOrdersOfCliente(String idcliente);


}
