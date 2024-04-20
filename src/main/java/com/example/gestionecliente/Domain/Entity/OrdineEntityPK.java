package com.example.gestionecliente.Domain.Entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class OrdineEntityPK implements Serializable {

    int id;
    int idcomanda;

    public OrdineEntityPK(int id, int idcomanda) {
        this.id = id;
        this.idcomanda = idcomanda;
    }

}
