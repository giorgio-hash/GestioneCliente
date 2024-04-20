package com.example.gestionecliente.Domain.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Comanda", schema = "serveeasy", catalog = "")
public class ComandaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "ID_cliente", nullable = false, length = 10)
    private String idCliente;
    @Basic
    @Column(name = "codice_pagamento", nullable = true, length = 255)
    private String codicePagamento;
    @Basic
    @Column(name = "totale_scontrino", nullable = true, precision = 0)
    private Double totaleScontrino;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getCodicePagamento() {
        return codicePagamento;
    }

    public void setCodicePagamento(String codicePagamento) {
        this.codicePagamento = codicePagamento;
    }

    public Double getTotaleScontrino() {
        return totaleScontrino;
    }

    public void setTotaleScontrino(Double totaleScontrino) {
        this.totaleScontrino = totaleScontrino;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComandaEntity that = (ComandaEntity) o;

        if (id != that.id) return false;
        if (idCliente != null ? !idCliente.equals(that.idCliente) : that.idCliente != null) return false;
        if (codicePagamento != null ? !codicePagamento.equals(that.codicePagamento) : that.codicePagamento != null)
            return false;
        if (totaleScontrino != null ? !totaleScontrino.equals(that.totaleScontrino) : that.totaleScontrino != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idCliente != null ? idCliente.hashCode() : 0);
        result = 31 * result + (codicePagamento != null ? codicePagamento.hashCode() : 0);
        result = 31 * result + (totaleScontrino != null ? totaleScontrino.hashCode() : 0);
        return result;
    }
}