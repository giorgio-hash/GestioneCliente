package com.example.gestionecliente.Interface.HTTPController;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Interfaccia per comunicazioni HTTP al server REST GestioneCliente
 */

@RequestMapping(path = "/cliente")
public interface APICliente {

    /**
     * API di Post con la quale si salva un ordine per un dato cliente all'interno del sistema
     *
     * @param idcliente identificativo del cliente
     * @param idpiatto identificativo del piatto
     * @param urgenzacliente Attributo urgenza del cliente
     *      * 0 : espresso non urgenza
     *      * 1 : espresso urgenza
     *      * 2 : default
     * @return entità risposta che contiene una risposta HTTP associata e l'oggetto OrdineDTO
     * @throws JsonProcessingException eccezione sollevata dalla serializzazione
     */
    @PostMapping(path = "/order/add")
    ResponseEntity submitOrder(@RequestParam String idcliente, @RequestParam String idpiatto, @RequestParam int urgenzacliente) throws JsonProcessingException;

    /**
     * API di Get con la quale si richiede un ordine specifico
     *
     * @param id identificativo dell'ordine
     * @return entità risposta che contiene l'oggetto richiesto e una risposta HTTP associata
     */
    @GetMapping(path = "/order")
    ResponseEntity getOrder(@RequestParam int id);

    /**
     * API di Get con la quale si richiede lo stato di un ordine specifico
     *
     * @param id identificativo dell'ordine
     * @return entità risposta che contiene l'oggetto richiesto e una risposta HTTP associata
     * @throws JsonProcessingException eccezione sollevata dalla serializzazione
     */
    @GetMapping(path = "/order/status")
    ResponseEntity getOrderStatus(@RequestParam int id) throws JsonProcessingException;

    /**
     * API di Get con la quale si richiede una lista di tutti gli ordini per un dato cliente
     *
     * @param idcliente identificativo del cliente
     * @return entità risposta che contiene l'oggetto richiesto e una risposta HTTP associata
     */
    @GetMapping(path = "{idcliente}/orders")
    ResponseEntity getOrdersOfCliente(@PathVariable String idcliente);

    /**
     * API di Get con la quale di richiede la comanda attiva per un dato cliente
     *
     * @param idcliente identificativo del cliente
     * @return entità risposta che contiene l'oggetto richiesto e una risposta HTTP associata
     */
    @GetMapping(path = "{idcliente}/comanda/attiva")
    ResponseEntity getComandaAttiva(@PathVariable String idcliente);

    /**
     * API di Get con la quale si richiede una nuova comanda per un determinato cliente
     *
     * @param idcliente identificativo del cliente
     * @return entità risposta che contiene l'oggetto richiesto e una risposta HTTP associata
     */
    @GetMapping(path = "{idcliente}/comanda/new")
    ResponseEntity newComanda(@PathVariable String idcliente);

    /**
     * API di Get con la quale si richiede il menù (lista di piatti disponibili)
     *
     * @return entità risposta che contiene l'oggetto richiesto e una risposta HTTP associata
     */
    @GetMapping(path = "/menu")
    ResponseEntity getMenu();

    /**
     * API di Get con la quale si richiede uno specifico piatto dal menù
     *
     * @param idpiatto identificativo del piatto
     * @return entità risposta che contiene l'oggetto richiesto e una risposta HTTP associata
     */
    @GetMapping(path = "/menu/{idpiatto}")
    ResponseEntity getPiatto(@PathVariable String idpiatto);
}
