package com.learn.TacoCloud.Converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.learn.TacoCloud.Models.Ingredient;
import com.learn.TacoCloud.Repositories.IngredientRepository;

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
