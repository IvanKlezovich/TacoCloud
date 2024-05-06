package com.learn.tacocloud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.learn.tacocloud.models.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {}
