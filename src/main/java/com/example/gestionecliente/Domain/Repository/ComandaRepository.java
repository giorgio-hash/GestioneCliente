package com.example.gestionecliente.Domain.Repository;

import com.example.gestionecliente.Domain.Entity.ComandaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ComandaRepository extends CrudRepository<ComandaEntity, Integer> {

    Optional<ComandaEntity> findByCodicePagamentoIsNullAndIdClienteIs(String idcliente);

}
