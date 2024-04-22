package com.example.gestionecliente.Domain;

import com.example.gestionecliente.Domain.Entity.ComandaEntity;
import com.example.gestionecliente.Domain.Entity.OrdineEntity;
import com.example.gestionecliente.Domain.Entity.PiattoEntity;
import com.example.gestionecliente.Domain.mapper.impl.NotificaOrdineMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GestioneRichieste implements FrontSignalPort {

    private final MenuManagerIF gestioneMenu;
    private final OrderManagerIF gestioneOrdini;

    private final MessagePort messagePort;
    private final NotificaOrdineMapper notificaOrdineMapper;

    @Autowired
    public GestioneRichieste(MenuManagerIF gestioneMenu, OrderManagerIF gestioneOrdini, MessagePort messagePort, NotificaOrdineMapper notificaOrdineMapper) {
        this.gestioneMenu = gestioneMenu;
        this.gestioneOrdini = gestioneOrdini;
        this.messagePort = messagePort;
        this.notificaOrdineMapper = notificaOrdineMapper;
    }


    @Override
    public Iterable<PiattoEntity> getMenu() {
        return gestioneMenu.getMenu();
    }

    @Override
    public OrdineEntity newOrder(String idcliente, String nomepiatto) {
        OrdineEntity o = gestioneOrdini.addNewOrder(idcliente,nomepiatto);
        messagePort.sendOrder(notificaOrdineMapper.mapTo(o));
        //notifyOrder(o);
        return o;
    }

    //private void notifyOrder(OrdineEntity o){
    // messagePort.sendOrder(new NotificaOrdineDTO(o.getId(),o.getIdcomanda()));
    //}


    @Override
    public Optional<OrdineEntity> getOrder(int id) {
        return gestioneOrdini.getOrder(id);
    }

    @Override
    public int getOrderStatus(int id) {
        return gestioneOrdini.getOrderStatus(id);
    }

    @Override
    public Optional<ComandaEntity> getComanda(String idcliente) {
        return gestioneOrdini.getComanda(idcliente);
    }

    @Override
    public Optional<PiattoEntity> getPiatto(String idpiatto) {
        return gestioneMenu.getPiatto(idpiatto);
    }

}
