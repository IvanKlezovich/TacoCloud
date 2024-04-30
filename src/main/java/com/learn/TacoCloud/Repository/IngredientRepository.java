package com.learn.TacoCloud.Repository;

import org.springframework.data.repository.CrudRepository;

import com.learn.TacoCloud.Models.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {}
