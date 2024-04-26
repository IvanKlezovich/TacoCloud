package com.learn.TacoCloud.Converters;

import com.learn.TacoCloud.RepositoryJdbc.IngredientRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.learn.TacoCloud.Models.Ingredient;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient>{
    
    private IngredientRepository ingredientRepo;

    public IngredientByIdConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepo = ingredientRepository;
    }

    @Override
    public Ingredient convert(String id){
        return ingredientRepo.findById(id).orElse(null);
    }
}
