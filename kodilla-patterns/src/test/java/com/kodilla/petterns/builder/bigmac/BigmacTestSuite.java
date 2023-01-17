package com.kodilla.petterns.builder.bigmac;


import com.kodilla.patterns.builder.bigmac.Bigmac;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BigmacTestSuite {

    @Test
    void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .ingredient("peppers")
                .ingredient("mushrooms")
                .ingredient("cucumber")
                .ingredient("cheese")
                .bun("ciabatta")
                .burgers(3)
                .sauce("thousand islands")
                .build();
        System.out.println(bigmac);

        //When
        int howManyIngredients = bigmac.getIngredients().size();
        int howManyBurgers = bigmac.getBurgers();

        //Then
        assertEquals(4, howManyIngredients);
        assertEquals(3, howManyBurgers);
        assertTrue(bigmac.getIngredients().contains("cucumber"));
    }
}
