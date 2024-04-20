package com.example.gestionecliente.Domain.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Cliente", schema = "serveeasy", catalog = "")
public class ClienteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false, length = 10)
    private String id;
    @Basic
    @Column(name = "t_o_a", nullable = false)
    private byte tOA;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public byte gettOA() {
        return tOA;
    }

    public void settOA(byte tOA) {
        this.tOA = tOA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClienteEntity that = (ClienteEntity) o;

        if (tOA != that.tOA) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (int) tOA;
        return result;
    }
}
