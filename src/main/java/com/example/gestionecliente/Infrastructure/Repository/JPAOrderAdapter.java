package com.example.gestionecliente.Infrastructure.Repository;

import com.example.gestionecliente.Domain.DataOrderPort;
import com.example.gestionecliente.Domain.Entity.ClienteEntity;
import com.example.gestionecliente.Domain.Entity.ComandaEntity;
import com.example.gestionecliente.Domain.Entity.OrdineEntity;
import com.example.gestionecliente.Domain.Repository.ClienteRepository;
import com.example.gestionecliente.Domain.Repository.ComandaRepository;
import com.example.gestionecliente.Domain.Repository.OrdineRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JPAOrderAdapter implements DataOrderPort {

    private final ClienteRepository clrep;
    private final ComandaRepository corep;
    private final OrdineRepository orrep;

    public JPAOrderAdapter(ClienteRepository clrep, ComandaRepository corep, OrdineRepository orrep) {
        this.clrep = clrep;
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
    public Optional<ComandaEntity> getComanda(String idcliente) {
        return corep.findByCodicePagamentoIsNullAndIdClienteIs(idcliente);
    }

    @Override
    public void insertTakeoutPhoneNum(ClienteEntity c) {
        clrep.save(c);
    }

    @Override
    public Iterable<ClienteEntity> getClienti() {
        return clrep.findAll();
    }

    @Override
    public void deleteTakeoutPhoneNum(ClienteEntity c) {
            clrep.delete(c);
    }
}
