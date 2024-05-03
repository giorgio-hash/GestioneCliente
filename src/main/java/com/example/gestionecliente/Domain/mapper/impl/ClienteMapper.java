package com.example.gestionecliente.Domain.mapper.impl;

import com.example.gestionecliente.Domain.Entity.ClienteEntity;
import com.example.gestionecliente.Domain.dto.ClienteDTO;
import com.example.gestionecliente.Domain.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * Implementazione del Mapper tra Entita' a DTO e viceversa
 */
@Component
public class ClienteMapper implements Mapper<ClienteEntity, ClienteDTO> {

    private ModelMapper modelMapper;

    public ClienteMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ClienteDTO mapTo(ClienteEntity clienteEntity) {
        return modelMapper.map(clienteEntity,ClienteDTO.class);
    }

    @Override
    public ClienteEntity mapFrom(ClienteDTO clienteDTO) {
        return modelMapper.map(clienteDTO, ClienteEntity.class);
    }

}
