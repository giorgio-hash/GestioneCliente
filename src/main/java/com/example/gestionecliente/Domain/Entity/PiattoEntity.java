package com.example.gestionecliente.Domain.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Oggetto Entity per la base dati Piatto
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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
    @Column(name = "t_preparazione", nullable = false)
    private int tPreparazione;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PiattoEntity that = (PiattoEntity) o;

        if (Double.compare(prezzo, that.prezzo) != 0) return false;
        if (tPreparazione != that.tPreparazione) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (idIngrPrinc != null ? !idIngrPrinc.equals(that.idIngrPrinc) : that.idIngrPrinc != null) return false;
        if (descrizione != null ? !descrizione.equals(that.descrizione) : that.descrizione != null) return false;

        return true;
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
        result = 31 * result + tPreparazione;
        return result;
    }
}
