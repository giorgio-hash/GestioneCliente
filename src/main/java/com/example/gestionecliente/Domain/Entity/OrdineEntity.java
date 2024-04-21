package com.example.gestionecliente.Domain.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@Entity
@Table(name = "Ordine", schema = "serveeasy", catalog = "")
@IdClass(com.example.gestionecliente.Domain.Entity.OrdineEntityPK.class)
public class OrdineEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false, insertable = false, updatable = false)
    private transient int id;


    @Id
    @Column(name = "ID_comanda", nullable = false)
    private int idComanda;

    @Basic
    @Column(name = "ID_piatto", nullable = false, length = 20)
    private String idPiatto;

    @Basic
    @Column(name = "stato", insertable = false, updatable = true)
    private Integer stato;

    @Basic
    @Column(name = "t_ordinazione", insertable = false, updatable = false)
    private Timestamp tOrdinazione;

    @Basic
    @Column(name = "urgenza_cliente", insertable = false, updatable = true)
    private Integer urgenzaCliente;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdineEntity that = (OrdineEntity) o;

        if (id != that.id) return false;
        if (idComanda != that.idComanda) return false;
        if (idPiatto != null ? !idPiatto.equals(that.idPiatto) : that.idPiatto != null) return false;
        if (stato != null ? !stato.equals(that.stato) : that.stato != null) return false;
        if (tOrdinazione != null ? !tOrdinazione.equals(that.tOrdinazione) : that.tOrdinazione != null) return false;
        if (urgenzaCliente != null ? !urgenzaCliente.equals(that.urgenzaCliente) : that.urgenzaCliente != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idComanda;
        result = 31 * result + (idPiatto != null ? idPiatto.hashCode() : 0);
        result = 31 * result + (stato != null ? stato.hashCode() : 0);
        result = 31 * result + (tOrdinazione != null ? tOrdinazione.hashCode() : 0);
        result = 31 * result + (urgenzaCliente != null ? urgenzaCliente.hashCode() : 0);
        return result;
    }
}
