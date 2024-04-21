package com.example.gestionecliente.Domain.Repository;

import com.example.gestionecliente.Domain.Entity.OrdineEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrdineRepository extends CrudRepository<OrdineEntity, Integer> {
}
