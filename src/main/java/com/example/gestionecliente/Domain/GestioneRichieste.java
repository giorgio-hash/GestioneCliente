package com.example.gestionecliente.Domain;

import com.example.gestionecliente.Domain.Entity.ComandaEntity;
import com.example.gestionecliente.Domain.Entity.OrdineEntity;
import com.example.gestionecliente.Domain.Entity.PiattoEntity;
import com.example.gestionecliente.Domain.dto.ComandaDTO;
import com.example.gestionecliente.Domain.dto.NotificaOrdineDTO;
import com.example.gestionecliente.Domain.dto.OrdineDTO;
import com.example.gestionecliente.Domain.dto.PiattoDTO;
import com.example.gestionecliente.Domain.mapper.impl.ComandaMapper;
import com.example.gestionecliente.Domain.mapper.impl.NotificaOrdineMapper;
import com.example.gestionecliente.Domain.mapper.impl.OrdineMapper;
import com.example.gestionecliente.Domain.mapper.impl.PiattoMapper;
import com.example.gestionecliente.Domain.ports.FrontSignalPort;
import com.example.gestionecliente.Domain.ports.MessagePort;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
    private PiattoMapper piattoMapper;
    private ComandaMapper comandaMapper;
    private OrdineMapper ordineMapper;

    /**
     * Costruttore componente GestioneRichieste
     *
     * @param gestioneMenu interfaccia del Bean per la gestione dati menu
     * @param gestioneOrdini interfaccia del Bean per la gestione dati ordini
     * @param messagePort porta per comunicazione unidirezionale verso i servizi collegati
     * @param notificaOrdineMapper Bean di conversione da OrdineEntity a NotificaOrdineDTO
     */
    @Autowired
    public GestioneRichieste(MenuManagerIF gestioneMenu,
                             OrderManagerIF gestioneOrdini,
                             MessagePort messagePort,
                             NotificaOrdineMapper notificaOrdineMapper,
                             PiattoMapper piattoMapper,
                             ComandaMapper comandaMapper,
                             OrdineMapper ordineMapper) {
        this.gestioneMenu = gestioneMenu;
        this.gestioneOrdini = gestioneOrdini;
        this.messagePort = messagePort;
        this.notificaOrdineMapper = notificaOrdineMapper;
        this.piattoMapper = piattoMapper;
        this.comandaMapper = comandaMapper;
        this.ordineMapper=ordineMapper;
    }

    @Override
    public Optional<Iterable<PiattoDTO>> getMenu() {

        Optional<Iterable<PiattoEntity>> piattoEntities = Optional.ofNullable(gestioneMenu.getMenu());

        if (piattoEntities.isEmpty()) {
            return Optional.empty();
        }

        Iterable<PiattoDTO> piattoDTOIterable = StreamSupport.stream(piattoEntities.get().spliterator(), false)
                .map(piattoMapper::mapTo)
                .collect(Collectors.toList());

        return Optional.ofNullable(piattoDTOIterable);
    }

    @Override
    public Optional<PiattoDTO> getPiatto(String idpiatto) {
        Optional<PiattoEntity> piattoEntity = gestioneMenu.getPiatto(idpiatto);
        if(piattoEntity.isEmpty())
            return Optional.empty();
        PiattoDTO piattoDTO = piattoMapper.mapTo(piattoEntity.get());
        return Optional.ofNullable(piattoDTO);
    }

    @Override
    public Optional<ComandaDTO> newComanda(String idcliente) {

        Optional<ComandaEntity> comandaAttiva = gestioneOrdini.getComandaAttiva(idcliente);

        if (comandaAttiva.isEmpty()) {

            Optional<ComandaEntity> comandaEntity = Optional.of(gestioneOrdini.newComanda(idcliente));
            if(comandaEntity.isEmpty())
                return Optional.empty();
            ComandaDTO comandaDTO = comandaMapper.mapTo(comandaEntity.get());
            return Optional.ofNullable(comandaDTO);
        }
        else
            return Optional.empty();
    }

    @Override
    public Optional<ComandaDTO> getComandaAttiva(String idcliente) {

        Optional<ComandaEntity> comandaEntity = gestioneOrdini.getComandaAttiva(idcliente);

        if(comandaEntity.isEmpty())
            return Optional.empty();

        ComandaDTO comandaDTO = comandaMapper.mapTo(comandaEntity.get());

        return Optional.ofNullable(comandaDTO);
    }

    @Override
    public Optional<OrdineDTO> newOrder(int idcomanda, String nomepiatto, int urgenzacliente) throws JsonProcessingException {
        Optional<OrdineEntity> ordineEntity = Optional.ofNullable(gestioneOrdini.addNewOrder(idcomanda,nomepiatto,urgenzacliente));
        messagePort.send(notificaOrdineMapper.mapTo(ordineEntity.get()));
        if(ordineEntity.isEmpty())
            return Optional.empty();
        OrdineDTO ordineDTO = ordineMapper.mapTo(ordineEntity.get());
        return Optional.ofNullable(ordineDTO);
    }

    @Override
    public Optional<OrdineDTO> getOrder(int id) {
        Optional<OrdineEntity> ordineEntity = gestioneOrdini.getOrder(id);
        if(ordineEntity.isEmpty())
            return Optional.empty();
        OrdineDTO ordineDTO = ordineMapper.mapTo(ordineEntity.get());
        return Optional.ofNullable(ordineDTO);
    }

    @Override
    public int getOrderStatus(int id) {
        return gestioneOrdini.getOrderStatus(id);
    }

    @Override
    public Optional<Iterable<OrdineDTO>> getOrdersOfCliente(String idcliente) {

        Optional<Iterable<OrdineEntity>> ordersOfCliente = gestioneOrdini.getOrdersOfCliente(idcliente);

        if (ordersOfCliente.isEmpty()) {
            return Optional.empty();
        }

        Iterable<OrdineDTO> ordineDTOIterable = StreamSupport.stream(ordersOfCliente.get().spliterator(), false)
                .map(ordineMapper::mapTo)
                .collect(Collectors.toList());

        return Optional.ofNullable(ordineDTOIterable);
    }

}
