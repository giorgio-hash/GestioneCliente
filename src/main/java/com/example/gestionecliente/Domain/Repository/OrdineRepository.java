package com.example.gestionecliente.Domain.Repository;

import com.example.gestionecliente.Domain.Entity.OrdineEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OrdineRepository extends CrudRepository<OrdineEntity, Integer> {

    @Query(value = "SELECT ID FROM Ordine WHERE ID_comanda = :idcomanda", nativeQuery = true)
    public Iterable<OrdineEntity> getAllOrdersOfComanda(int idcomanda);
}
