package com.example.gestionecliente.Infrastructure.Repository;

import com.example.gestionecliente.Domain.Entity.ComandaEntity;
import com.example.gestionecliente.Domain.Entity.OrdineEntity;
import com.example.gestionecliente.Domain.Repository.ComandaRepository;
import com.example.gestionecliente.Domain.Repository.OrdineRepository;
import com.example.gestionecliente.Domain.ports.DataOrderPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Bean per usare il framework JPA su datasource MariaDB.
 * Costituisce l'adattatore per la porta DataOrderPort
 */
@Repository
public class JPAOrderAdapter implements DataOrderPort {

    //private final ClienteRepository clrep;
    private final ComandaRepository corep;
    private final OrdineRepository orrep;

    /**
     * Costruttore JPAOrderAdapter
     *
     * @param corep bean interfaccia {@code CrudRepository<ComandaEntity, Integer>}
     * @param orrep bean interfaccia {@code CrudRepository<OrdineEntity, Integer>}
     */
    @Autowired
    public JPAOrderAdapter(ComandaRepository corep, OrdineRepository orrep) {
        this.corep = corep;
        this.orrep = orrep;
    }


    @Override
    public OrdineEntity insertOrder(OrdineEntity o) {
        return orrep.save(o);
    }

    @Override
    public Optional<OrdineEntity> getOrder(int id) {
        return orrep.findById(id);
    }

    @Override
    public int getOrderStatus(int id) {
        Optional<OrdineEntity> res = orrep.findById(id);
        return res.isPresent()? res.get().getStato():-1;
    }

    @Override
    public ComandaEntity insertComanda(ComandaEntity c) {
        return corep.save(c);
    }

    @Override
    public Optional<ComandaEntity> getComandaAttiva(String idcliente) {
        return corep.findByCodicePagamentoIsNullAndIdClienteIs(idcliente);
    }

    @Override
    public Iterable<OrdineEntity> getOrdersOfComanda(int idcomanda) {
        return orrep.findAllByIdComanda(idcomanda);
    }

}
