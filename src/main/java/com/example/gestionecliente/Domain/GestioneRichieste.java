package com.example.gestionecliente.Domain;

import com.example.gestionecliente.Domain.Entity.OrdineEntity;
import com.example.gestionecliente.Domain.Entity.PiattoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GestioneRichieste implements FrontSignalPort {

    private final GestioneMenu gestioneMenu;
    private final GestioneOrdini gestioneOrdini;

    @Autowired
    public GestioneRichieste(GestioneMenu gestioneMenu, GestioneOrdini gestioneOrdini) {
        this.gestioneMenu = gestioneMenu;
        this.gestioneOrdini = gestioneOrdini;
    }


    @Override
    public Iterable<PiattoEntity> getMenu() {
        return gestioneMenu.getMenu();
    }

    @Override
    public OrdineEntity newOrder(String idcliente, String nomepiatto) {
        return gestioneOrdini.addNewOrder(idcliente,nomepiatto);
    }

    @Override
    public Optional<OrdineEntity> getOrder(int id, int idcomanda) {
        return gestioneOrdini.getOrder(id,idcomanda);
    }

}
