package com.learn.tacocloud.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.learn.tacocloud.models.Ingredient;
import com.learn.tacocloud.repositories.IngredientRepository;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient>{
    
    private IngredientRepository repository;

    public IngredientByIdConverter(IngredientRepository ingredientRepository) {
        this.repository = ingredientRepository;
    }

    @Override
    public Ingredient convert(String id){
        return repository.findById(id).orElse(null);
    }
}
