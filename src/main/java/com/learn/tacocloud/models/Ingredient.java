package com.learn.tacocloud.models;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Ingredient implements Serializable{

    @Serial
    private static final long serialVersionUID = 1;

    @Id
    private String id;

    private String name;

    private Type type;

    public enum Type {
        CHEESE, PROTEIN, SAUCE, VEGGIES, WRAP
    }
}
