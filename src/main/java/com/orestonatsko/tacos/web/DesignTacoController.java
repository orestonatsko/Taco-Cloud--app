package com.orestonatsko.tacos.web;

import com.orestonatsko.tacos.data.Ingredient;
import com.orestonatsko.tacos.data.Taco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

import static com.orestonatsko.tacos.data.Ingredient.IngredientType;
import static com.orestonatsko.tacos.data.Ingredient.IngredientType.filterByType;

@Controller
@Slf4j
@RequestMapping("/design")
public class DesignTacoController {
    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = Arrays.asList(new Ingredient("FLTO", "Flour Tortilla", IngredientType.WRAP),
                new Ingredient("COTO", "Corn Tortilla", IngredientType.WRAP),
                new Ingredient("GRBF", "Ground Beef", IngredientType.PROTEIN),
                new Ingredient("CARN", "Carnitas", IngredientType.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", IngredientType.VEGGIES),
                new Ingredient("LETC", "Lettuce", IngredientType.VEGGIES),
                new Ingredient("CHED", "Cheddar", IngredientType.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", IngredientType.CHEESE),
                new Ingredient("SLSA", "Salsa", IngredientType.SAUCE),
                new Ingredient("SRCR", "Sour Cream", IngredientType.SAUCE)
        );
        IngredientType[] types = IngredientType.values();
        for (IngredientType type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
        model.addAttribute("design", new Taco());

        return "design";
    }
}
