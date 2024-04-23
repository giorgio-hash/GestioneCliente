package com.example.gestionecliente.Interface.HTTPController;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Interfaccia per comunicazioni HTTP al server REST GestioneCliente
 */
public interface APICliente {

    @PostMapping(path = "/order/add")
    ResponseEntity submitOrder(@RequestParam String idcliente, @RequestParam String idpiatto) throws JsonProcessingException;

    @GetMapping(path = "/order")
    ResponseEntity getOrder(@RequestParam int id);

    @GetMapping(path = "/order/status")
    ResponseEntity getOrderStatus(@RequestParam int id) throws JsonProcessingException;

    //TODO
    //Iterable<OrdineEntity> getOrdersOfCliente(String cliente);

    @GetMapping(path = "{idcliente}/comanda/attiva")
    ResponseEntity getComandaAttiva(@PathVariable String idcliente);

    @GetMapping(path = "{idcliente}/comanda/new")
    ResponseEntity newComanda(@PathVariable String idcliente);

    @GetMapping(path = "/menu")
    ResponseEntity getMenu();

    @GetMapping(path = "/menu/{idpiatto}")
    ResponseEntity getPiatto(@PathVariable String idpiatto);
}
