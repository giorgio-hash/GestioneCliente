package com.example.gestionecliente.Domain.Repository;

import com.example.gestionecliente.Domain.Entity.ComandaEntity;
import org.springframework.data.repository.CrudRepository;

public interface ComandaRepository extends CrudRepository<ComandaEntity, Integer> {
}
