package com.example.gestionecliente.Domain.Entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Oggetto Entity per la base dati Piatto
 */
@Data
@Builder
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

}
