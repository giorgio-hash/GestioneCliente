package com.example.gestionecliente.Domain;

import com.example.gestionecliente.Domain.Entity.ComandaEntity;
import com.example.gestionecliente.Domain.Entity.OrdineEntity;
import com.example.gestionecliente.Domain.Entity.PiattoEntity;
import com.example.gestionecliente.Domain.dto.NotificaOrdineDTO;
import com.example.gestionecliente.Domain.mapper.impl.NotificaOrdineMapper;
import com.example.gestionecliente.Domain.ports.FrontSignalPort;
import com.example.gestionecliente.Domain.ports.MessagePort;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Componente Bean GestioneRichieste: gestisce le richieste del cliente per risolvere le richieste dati relative al menu
 * e l'inserimento/l'aggiornamento/l'eliminazione dati relative alle ordinazioni
 */
@Service
public class GestioneRichieste implements FrontSignalPort {

    private final MenuManagerIF gestioneMenu;
    private final OrderManagerIF gestioneOrdini;

    private final MessagePort<NotificaOrdineDTO> messagePort;
    private final NotificaOrdineMapper notificaOrdineMapper;

    /**
     * Costruttore componente GestioneRichieste
     *
     * @param gestioneMenu interfaccia del Bean per la gestione dati menu
     * @param gestioneOrdini interfaccia del Bean per la gestione dati ordini
     * @param messagePort porta per comunicazione unidirezionale verso i servizi collegati
     * @param notificaOrdineMapper Bean di conversione da OrdineEntity a NotificaOrdineDTO
     */
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
    public Optional<PiattoEntity> getPiatto(String idpiatto) {
        return gestioneMenu.getPiatto(idpiatto);
    }

    @Override
    public Optional<ComandaEntity> newComanda(String idcliente) {

        Optional<ComandaEntity> comandaAttiva = gestioneOrdini.getComandaAttiva(idcliente);

        if (comandaAttiva.isEmpty())
            return Optional.of(gestioneOrdini.newComanda(idcliente));
        else
            return Optional.empty();
    }

    @Override
    public Optional<ComandaEntity> getComandaAttiva(String idcliente) {
        return gestioneOrdini.getComandaAttiva(idcliente);
    }

    @Override
    public OrdineEntity newOrder(int idcomanda, String nomepiatto) throws JsonProcessingException {
        OrdineEntity o = gestioneOrdini.addNewOrder(idcomanda,nomepiatto);
        messagePort.send(notificaOrdineMapper.mapTo(o));
        return o;
    }

    @Override
    public Optional<OrdineEntity> getOrder(int id) {
        return gestioneOrdini.getOrder(id);
    }

    @Override
    public int getOrderStatus(int id) {
        return gestioneOrdini.getOrderStatus(id);
    }

}
