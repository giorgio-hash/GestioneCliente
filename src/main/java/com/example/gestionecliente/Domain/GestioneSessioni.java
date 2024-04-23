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
    public Optional<Integer> getComanda(int idordine) {
        return Optional.empty();
    }

    @Override
    public void newComanda(String idcliente, int idcomanda) {

    }

    @Override
    public Iterable<Integer> getOrdinersFromComanda(int idcomanda) {
        return null;
    }

    @Override
    public void assignToComanda(int idordine, int idcomanda) {

    }

    @Override
    public void deleteComanda(int idcomanda) {

    }

    @Override
    public void addCliente(String idcliente) {

    }

    @Override
    public void deleteCliente(String idcliente) {

    }
}
