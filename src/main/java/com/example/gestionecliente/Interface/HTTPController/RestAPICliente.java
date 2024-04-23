package com.example.gestionecliente.Interface.HTTPController;

import com.example.gestionecliente.Domain.Entity.ComandaEntity;
import com.example.gestionecliente.Domain.Entity.OrdineEntity;
import com.example.gestionecliente.Domain.Entity.PiattoEntity;
import com.example.gestionecliente.Domain.ports.FrontSignalPort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.internal.util.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity submitOrder(@RequestParam String idcliente, @RequestParam String idpiatto) throws JsonProcessingException {

        Optional<ComandaEntity> cres = frontSignalPort.getComandaAttiva(idcliente);

        if(cres.isEmpty())
            return new ResponseEntity<String>("il cliente non ha comande attive assegnate",HttpStatus.NOT_FOUND);

        OrdineEntity res = frontSignalPort.newOrder(cres.get().getId(), idpiatto);

        if (res == null) return new ResponseEntity<String>("comanda o piatto non trovato",HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(res);
    }

    @Override
    @GetMapping(path = "/order")
    public ResponseEntity getOrder(@RequestParam int id) {

        Optional<OrdineEntity> res = frontSignalPort.getOrder(id);

        if(res.isEmpty()) return new ResponseEntity<String>("ordine non trovato",HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(res.get());
    }

    @Override
    @GetMapping(path = "/order/status")
    public ResponseEntity getOrderStatus(@RequestParam int id) throws JsonProcessingException {

        int res = frontSignalPort.getOrderStatus(id);

        if(res == -1) return new ResponseEntity<String>("ordine non trovato",HttpStatus.NOT_FOUND);


        Map<String,Integer> data = new HashMap();
        data.put("ordine", id);
        data.put("stato",res);

        String data_json = objectMapper.writeValueAsString(data);

        return ResponseEntity.ok(data_json);
    }

    @Override
    @GetMapping(path = "{idcliente}/comanda")
    public ResponseEntity getComandaAttiva(@PathVariable String idcliente) {

        Optional<ComandaEntity> res = frontSignalPort.getComandaAttiva(idcliente);

        if(res.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(res.get());
    }

    @Override
    @GetMapping(path = "{idcliente}/comanda/new")
    public ResponseEntity newComanda(@PathVariable String idcliente) {
        Optional<ComandaEntity> res = frontSignalPort.newComanda(idcliente);

        if(res.isEmpty()) return new ResponseEntity<String>("cliente ha una comanda già attiva oppure cliente non esiste", HttpStatus.FORBIDDEN);
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
