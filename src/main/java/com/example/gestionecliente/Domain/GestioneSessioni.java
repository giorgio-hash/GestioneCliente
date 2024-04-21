package com.example.gestionecliente.Domain;

import java.util.*;

public class GestioneSessioni implements SessioneIF{

    private HashMap<String, Integer> clienti_comande;
    private HashMap<Integer,Integer> comande_ordini;

    public GestioneSessioni() {
        this.clienti_comande = new HashMap<>();
        this.comande_ordini = new HashMap<>();
    }


    @Override
    public Optional<Integer> getComanda(String cliente) {
        return Optional.empty();
    }

    @Override
    public void newComanda(String cliente, int idcomanda) {

    }

    @Override
    public void assignToComanda(int idordine, int idcomanda) {

    }

    @Override
    public void deleteComanda(int idcomanda) {

    }
}
