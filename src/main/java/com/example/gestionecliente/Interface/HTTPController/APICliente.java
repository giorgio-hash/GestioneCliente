package com.example.gestionecliente.Interface.HTTPController;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

public interface APICliente {

    ResponseEntity submitOrder(String idcliente, String idpiatto);

    ResponseEntity getOrder(int id, int idcomanda);

    ResponseEntity getOrderStatus(int id, int idcomanda) throws JsonProcessingException;

    //TODO
    //Iterable<OrdineEntity> getOrdersFromComanda(int idcomanda);

    //TODO
    //Iterable<OrdineEntity> getActualOrdersOfCliente(String idcliente);

    ResponseEntity getComanda(String idcliente);

    ResponseEntity getMenu();

    @GetMapping(path = "/menu/{idpiatto}")
    @ResponseBody
    ResponseEntity getPiatto(@PathVariable String idpiatto);
}
