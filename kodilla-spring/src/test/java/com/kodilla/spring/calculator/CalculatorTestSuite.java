package com.kodilla.spring.calculator;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    Calculator calculator;

    @Test

    void testCalculations () {
        //Given & When
        double adding = calculator.adding(10.00, 5.00);
        double subtracting = calculator.subtracting(10.00, 5.00);
        double multiplying = calculator.multiplying(10.00, 5.00);
        double dividing = calculator.dividing(10.00, 5.00);

        //Then
        assertEquals(15.00, adding);
        assertEquals(subtracting,5.00);
        assertEquals(50.00, multiplying);
        assertEquals(2.00, dividing);
    }
}
