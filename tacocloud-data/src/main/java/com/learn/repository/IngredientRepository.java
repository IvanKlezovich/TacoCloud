package com.learn.repository;

import org.springframework.data.repository.CrudRepository;

import com.learn.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {}
