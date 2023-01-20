package com.kodilla.patterns2.builder.pizza;


import com.kodilla.patterns.builder.pizza.Pizza;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaTestSuite {

    @Test
    void testPizzaNew() {
        //Given
        Pizza pizza = new Pizza.PizzaBuilder()
                .ingredient("onion")
                .ingredient("ham")
                .ingredient("mushrooms")
                .bottom("thin")
                .sauce("spicy")
                .build();
        System.out.println(pizza);

        //When
        int howManyIngredients = pizza.getIngredients().size();

        //Then
        assertEquals(3, howManyIngredients);
    }
}
