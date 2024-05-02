package com.example.gestionecliente.Interface.HTTPController;

import com.example.gestionecliente.Domain.Entity.ComandaEntity;
import com.example.gestionecliente.Domain.Entity.OrdineEntity;
import com.example.gestionecliente.Domain.Entity.PiattoEntity;
import com.example.gestionecliente.Domain.dto.ComandaDTO;
import com.example.gestionecliente.Domain.dto.OrdineDTO;
import com.example.gestionecliente.Domain.dto.PiattoDTO;
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
public class RestAPICliente implements APICliente {

    private final FrontSignalPort frontSignalPort;
    private final ObjectMapper objectMapper; //utile per convertire strutture semplici in dizionari


    @Autowired
    public RestAPICliente(FrontSignalPort frontSignalPort, ObjectMapper objectMapper) {
        this.frontSignalPort = frontSignalPort;
        this.objectMapper = objectMapper;
    }

    @Override
    public ResponseEntity submitOrder(@RequestParam String idcliente, @RequestParam String idpiatto, @RequestParam int urgenzacliente) throws JsonProcessingException {

        Optional<ComandaDTO> cres = frontSignalPort.getComandaAttiva(idcliente);

        if(cres.isEmpty())
            return new ResponseEntity<String>("il cliente non ha comande attive assegnate",HttpStatus.NOT_FOUND);

        Optional<OrdineDTO> res = frontSignalPort.newOrder(cres.get().getId(), idpiatto, urgenzacliente);

        if (res.isEmpty()) return new ResponseEntity<String>("comanda o piatto non trovato",HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(res.get());
    }

    @Override
    public ResponseEntity getOrder(@RequestParam int id) {

        Optional<OrdineDTO> res = frontSignalPort.getOrder(id);

        if(res.isEmpty()) return new ResponseEntity<String>("ordine non trovato",HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(res.get());
    }

    @Override
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
    public ResponseEntity getOrdersOfCliente(String idcliente) {

        Optional<Iterable<OrdineDTO>> res = frontSignalPort.getOrdersOfCliente(idcliente);
        if(res.isEmpty())
            return new ResponseEntity<String>("comanda cliente non trovata",HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(res.get());
    }

    @Override
    public ResponseEntity getComandaAttiva(@PathVariable String idcliente) {

        Optional<ComandaDTO> res = frontSignalPort.getComandaAttiva(idcliente);

        if(res.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(res.get());
    }

    @Override
    public ResponseEntity newComanda(@PathVariable String idcliente) {
        Optional<ComandaDTO> res = frontSignalPort.newComanda(idcliente);

        if(res.isEmpty()) return new ResponseEntity<String>("cliente ha una comanda già attiva oppure cliente non esiste", HttpStatus.FORBIDDEN);
        return ResponseEntity.ok(res.get());
    }

    @Override
    public ResponseEntity getMenu() {

        Optional<Iterable<PiattoDTO>> res = frontSignalPort.getMenu();

        if(Iterables.getLength(res.get()) == 0) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(res.get());
    }

    @Override
    public ResponseEntity getPiatto(String idpiatto) {

        Optional<PiattoDTO> res = frontSignalPort.getPiatto(idpiatto.toUpperCase());

        if(res.isPresent())
            return ResponseEntity.ok(res.get());
        else
            return ResponseEntity.notFound().build();
    }
}
