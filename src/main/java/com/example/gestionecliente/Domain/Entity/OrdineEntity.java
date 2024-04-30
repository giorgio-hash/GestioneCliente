package com.example.gestionecliente.Domain.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Oggetto Entity per la base dati Ordine
 */
@Data
@Builder
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

}
