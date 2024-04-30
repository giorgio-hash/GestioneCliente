package com.example.gestionecliente.Domain.Entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Oggetto Entity per la base dati Cliente
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Cliente", schema = "serveeasy", catalog = "")
public class ClienteEntity {

    @Id
    @Column(name = "ID", nullable = false, length = 10)
    private String id;
    @Basic
    @Column(name = "t_o_a", nullable = false)
    private byte tOA;

}
