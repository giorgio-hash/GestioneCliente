package com.example.gestionecliente.Domain.mapper.impl;

import com.example.gestionecliente.Domain.Entity.IngredientePrincipaleEntity;
import com.example.gestionecliente.Domain.dto.IngredientePrincipaleDTO;
import com.example.gestionecliente.Domain.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * Implementazione del Mapper tra Entita' a DTO e viceversa
 */
@Component
public class IngredientePrincipaleMapper implements Mapper<IngredientePrincipaleEntity, IngredientePrincipaleDTO> {

    private ModelMapper modelMapper;

    public IngredientePrincipaleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public IngredientePrincipaleDTO mapTo(IngredientePrincipaleEntity ingredientePrincipaleEntity) {
        return modelMapper.map(ingredientePrincipaleEntity,IngredientePrincipaleDTO.class);
    }

    @Override
    public IngredientePrincipaleEntity mapFrom(IngredientePrincipaleDTO ingredientePrincipaleDTO) {
        return modelMapper.map(ingredientePrincipaleDTO, IngredientePrincipaleEntity.class);
    }

}
