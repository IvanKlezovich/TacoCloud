package com.learn.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.learn.model.Ingredient;
import com.learn.model.Ingredient.Type;
import com.learn.model.Taco;
import com.learn.model.TacoOrder;
import com.learn.repository.IngredientRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    private final IngredientRepository repository;

    public DesignTacoController(IngredientRepository ingredientRepository) {
        this.repository = ingredientRepository;
        List<Ingredient> list =
        new ArrayList<>(List.of(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
            new Ingredient ("COTO", "Corn Tortilla", Type.WRAP),
            new Ingredient ("GRBF", "Ground Beef", Type.PROTEIN),
            new Ingredient ("CARN", "Carnitas", Type.PROTEIN),
            new Ingredient ("TMTO", "Diced Tomatoes", Type.VEGGIES),
            new Ingredient ("LETC", "Lettuce", Type.VEGGIES),
            new Ingredient ("CHED", "Cheddar", Type.CHEESE),
            new Ingredient ("JACK", "Monterrey Jack", Type.CHEESE),
            new Ingredient ("SLSA", "Salsa", Type.SAUCE),
            new Ingredient ("SRCR", "Sour Cream", Type.SAUCE)));
        repository.saveAll(list);
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model){
        Iterable<Ingredient> ingredients = repository.findAll();
        Type[] types = Ingredient.Type.values();
        for(Type type: types){
            model.addAttribute(type.toString().toLowerCase(), 
            filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order(){
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco(){
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(){
        return "design";
    }

    @PostMapping()
    public String processTaco( @Valid Taco taco, 
        Errors errors, @ModelAttribute TacoOrder tacoOrder,
        SessionStatus sessionStatus) {
        if(errors.hasErrors()){
            errors.toString();
            return "home";
        }
        tacoOrder.addTaco(taco);
        
        sessionStatus.setComplete();

        log.info("Processing taco: {}", taco);
        
        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(
            Iterable<Ingredient> ingredients, Type type) { 
        List<Ingredient> forStream = new ArrayList<>();
        ingredients.forEach(forStream::add);
        return forStream
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
