package com.example.gestionecliente.Domain.mapper.impl;

import com.example.gestionecliente.Domain.Entity.OrdineEntity;
import com.example.gestionecliente.Domain.dto.NotificaOrdineDTO;
import com.example.gestionecliente.Domain.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class NotificaOrdineMapper implements Mapper<OrdineEntity, NotificaOrdineDTO> {

    private ModelMapper modelMapper;


    public NotificaOrdineMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public NotificaOrdineDTO mapTo(OrdineEntity ordineEntity) {
        return modelMapper.map(ordineEntity,NotificaOrdineDTO.class);
    }

    @Override
    public OrdineEntity mapFrom(NotificaOrdineDTO notificaOrdineDTO) {
        return modelMapper.map(notificaOrdineDTO, OrdineEntity.class);
    }
}
