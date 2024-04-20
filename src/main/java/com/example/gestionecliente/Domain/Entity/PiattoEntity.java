package com.example.gestionecliente.Domain.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@Entity
@Table(name = "Piatto", schema = "serveeasy", catalog = "")
public class PiattoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false, length = 20)
    private String id;
    @Basic
    @Column(name = "ID_ingr_princ", nullable = false, length = 20)
    private String idIngrPrinc;
    @Basic
    @Column(name = "descrizione", nullable = true, length = 50)
    private String descrizione;
    @Basic
    @Column(name = "prezzo", nullable = false, precision = 0)
    private double prezzo;
    @Basic
    @Column(name = "t_preparazione", nullable = true)
    private Timestamp tPreparazione;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PiattoEntity that = (PiattoEntity) o;

        return this.id.equals(that.id);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (idIngrPrinc != null ? idIngrPrinc.hashCode() : 0);
        result = 31 * result + (descrizione != null ? descrizione.hashCode() : 0);
        temp = Double.doubleToLongBits(prezzo);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (tPreparazione != null ? tPreparazione.hashCode() : 0);
        return result;
    }
}
