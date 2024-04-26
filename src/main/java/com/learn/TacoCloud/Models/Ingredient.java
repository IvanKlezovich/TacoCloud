package com.learn.TacoCloud.Models;

import lombok.Data;

@Data
public class Ingredient {

    private final String id;

    private final String name;

    private final Type type;

    public enum Type {
        CHEESE, PROTEIN, SAUCE, VEGGIES, WRAP
    }

    public Object getIngredient() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIngredient'");
    }
}
