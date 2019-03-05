package com.orestonatsko.tacos.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
public class Ingredient {
    private final String id;
    private final String name;
    private final IngredientType type;

    public  enum IngredientType {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE;

       public static List<Ingredient> filterByType(List<Ingredient> ingredients, IngredientType type){
            return ingredients.stream().filter(i->i.getType().equals(type)).collect(Collectors.toList());
        }

        }
}
