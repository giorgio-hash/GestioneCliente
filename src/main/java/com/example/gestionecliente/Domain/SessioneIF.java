package com.example.gestionecliente.Domain;

import java.util.Optional;

public interface SessioneIF {

    Optional<Integer> getComanda(String cliente);
    void newComanda(String cliente, int idcomanda);
    void assignToComanda(int idordine,int idcomanda);
    void deleteComanda(int idcomanda);
}
