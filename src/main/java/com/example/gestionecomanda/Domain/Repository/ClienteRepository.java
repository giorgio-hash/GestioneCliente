package com.example.GestioneCliente.Domain.Repository;

import com.example.GestioneCliente.Domain.Entity.ClienteEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<ClienteEntity, String> {
}
