package com.example.gestionecliente.Domain.mapper.impl;

import com.example.gestionecliente.Domain.Entity.ComandaEntity;
import com.example.gestionecliente.Domain.dto.ComandaDTO;
import com.example.gestionecliente.Domain.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * Implementazione del Mapper tra Entita' a DTO e viceversa
 */
@Component
public class ComandaMapper implements Mapper<ComandaEntity, ComandaDTO> {

    private ModelMapper modelMapper;

    public ComandaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ComandaDTO mapTo(ComandaEntity comandaEntity) {
        return modelMapper.map(comandaEntity,ComandaDTO.class);
    }

    @Override
    public ComandaEntity mapFrom(ComandaDTO comandaDTO) {
        return modelMapper.map(comandaDTO, ComandaEntity.class);
    }

}
