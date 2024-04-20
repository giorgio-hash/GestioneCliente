package com.example.gestionecliente.Domain.Repository;

import com.example.gestionecliente.Domain.Entity.ClienteEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<ClienteEntity, Integer> {
}

