package com.example.gestionecliente.Domain.mapper.impl;

import com.example.gestionecliente.Domain.Entity.PiattoEntity;
import com.example.gestionecliente.Domain.dto.PiattoDTO;
import com.example.gestionecliente.Domain.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * Implementazione del Mapper tra Entita' a DTO e viceversa
 */
@Component
public class PiattoMapper implements Mapper<PiattoEntity, PiattoDTO> {

    private ModelMapper modelMapper;

    public PiattoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PiattoDTO mapTo(PiattoEntity piattoEntity) {
        return modelMapper.map(piattoEntity,PiattoDTO.class);
    }

    @Override
    public PiattoEntity mapFrom(PiattoDTO piattoDTO) {
        return modelMapper.map(piattoDTO, PiattoEntity.class);
    }

}
