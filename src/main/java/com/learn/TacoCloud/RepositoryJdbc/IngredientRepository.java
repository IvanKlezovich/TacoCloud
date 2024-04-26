 package com.learn.TacoCloud.RepositoryJdbc;

 import java.util.List;
 import java.util.Optional;

 import com.learn.TacoCloud.Models.Ingredient;

 public interface IngredientRepository {
     List<Ingredient> findAll();
     Optional<Ingredient> findById(String id);
     Ingredient save(Ingredient ingredient);
 }
