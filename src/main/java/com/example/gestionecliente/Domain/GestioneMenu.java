package com.example.gestionecliente.Domain;

import com.example.gestionecliente.Domain.Entity.PiattoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.gestionecliente.Domain.MenuManagerIF;

import java.util.Optional;

@Service
public class GestioneMenu implements MenuManagerIF {

    private final DataMenuPort dataMenuPort;
    private Iterable<PiattoEntity> piatti;

    @Autowired
    public GestioneMenu(DataMenuPort dataMenuPort) {
        this.dataMenuPort = dataMenuPort;
        piatti = dataMenuPort.getMenu();
    }


    @Override
    public Optional<PiattoEntity> getPiatto(String idpiatto) {
        for(PiattoEntity o : piatti)
            if(o.getId().equals(idpiatto))
                return Optional.of(o);

        return Optional.empty();
    }

    @Override
    public Iterable<PiattoEntity> getMenu() {
        return piatti;
    }
}
