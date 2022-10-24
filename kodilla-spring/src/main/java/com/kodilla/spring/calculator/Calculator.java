package com.kodilla.spring.calculator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Calculator {

    @Autowired
    Display display;

    double a;
    double b;

//    public Calculator () {
//        a = 10.00;
//        b = 5.00;
//    }


    public double adding (double a, double b) {
        double value = a + b;
        display.displayValue(value);
        return value;
    }

    public double subtracting (double a, double b) {
        double value = a - b;
        display.displayValue(value);
        return value;
    }

    public double multiplying (double a, double b) {
        double value = a * b;
        display.displayValue(value);
        return value;
    }

    public double dividing (double a, double b) {
        double value = a/b;
        display.displayValue(value);
        return value;
    }
}
