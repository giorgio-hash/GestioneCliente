package com.example.gestionecliente.Domain.Entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class OrdineEntityPK implements Serializable {

    int id;
    int idComanda;

    public OrdineEntityPK(int id, int idComanda) {
        this.id = id;
        this.idComanda = idComanda;
    }

}
