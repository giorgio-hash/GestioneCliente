package com.example.gestionecliente.Interface.HTTPController;

import com.example.gestionecliente.Domain.Entity.ComandaEntity;
import com.example.gestionecliente.Domain.Entity.OrdineEntity;
import com.example.gestionecliente.Domain.Entity.PiattoEntity;
import com.example.gestionecliente.Domain.FrontSignalPort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.internal.util.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping(path = "/cliente")
public class RestAPICliente implements APICliente {

    private final FrontSignalPort frontSignalPort;
    private final ObjectMapper objectMapper;


    @Autowired
    public RestAPICliente(FrontSignalPort frontSignalPort, ObjectMapper objectMapper) {
        this.frontSignalPort = frontSignalPort;
        this.objectMapper = objectMapper;
    }

    @Override
    @PostMapping(path = "/order/add")
    public ResponseEntity submitOrder(@RequestParam String idcliente, @RequestParam String idpiatto) {

        OrdineEntity res = frontSignalPort.newOrder(idcliente, idpiatto);

        if (res == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(res);
    }

    @Override
    @GetMapping(path = "/order")
    public ResponseEntity getOrder(@RequestParam int id) {

        Optional<OrdineEntity> res = frontSignalPort.getOrder(id);

        if(res.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(res.get());
    }

    @Override
    @GetMapping(path = "/order/status")
    public ResponseEntity getOrderStatus(int id) throws JsonProcessingException {

        int res = frontSignalPort.getOrderStatus(id);

        if(res == -1) return ResponseEntity.notFound().build();


        Map<String,String> data = new HashMap();
        data.put("ordine", String.valueOf(id));
        data.put("stato",String.valueOf(res));

        String data_json = objectMapper.writeValueAsString(data);

        return ResponseEntity.ok(data_json);
    }

    @Override
    @GetMapping(path = "/comanda")
    public ResponseEntity getComanda(@RequestParam String idcliente) {

        Optional<ComandaEntity> res = frontSignalPort.getComanda(idcliente);

        if(res.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(res.get());
    }

    @Override
    @GetMapping(path = "/menu")
    public ResponseEntity getMenu() {

        Iterable<PiattoEntity> res = frontSignalPort.getMenu();

        if(Iterables.getLength(res) == 0) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(res);
    }

    @Override
    @GetMapping(path = "/menu/{idpiatto}")
    public ResponseEntity getPiatto(@PathVariable String idpiatto) {

        Optional<PiattoEntity> res = frontSignalPort.getPiatto(idpiatto);

        if(res.isPresent())
            return ResponseEntity.ok(res.get());
        else
            return ResponseEntity.notFound().build();
    }
}
