package com.learn.TacoCloud.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.learn.TacoCloud.Models.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {}
