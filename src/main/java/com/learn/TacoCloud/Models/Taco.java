package com.learn.TacoCloud.Models;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Taco {

    private Long id;

    private Date createdAt = new Date();

    @Size(min = 5, message = "You must choose at least 5 characters long")
    private String name;

    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients = new ArrayList<>();

}
