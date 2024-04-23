package com.example.gestionecliente.Domain.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Oggetto Entity per la base dati Ordine
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Ordine", schema = "serveeasy", catalog = "")
public class OrdineEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false, insertable = false, updatable = false)
    private int id;

    @Column(name = "ID_COMANDA", nullable = false, updatable = false)
    private int idcomanda;

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
        if (!(o instanceof OrdineEntity that)) return false;
        return getId() == that.getId() && getIdcomanda() == that.getIdcomanda() && Objects.equals(getIdPiatto(), that.getIdPiatto()) && Objects.equals(getStato(), that.getStato()) && Objects.equals(tOrdinazione, that.tOrdinazione) && Objects.equals(getUrgenzaCliente(), that.getUrgenzaCliente());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIdcomanda(), getIdPiatto(), getStato(), tOrdinazione, getUrgenzaCliente());
    }
}
