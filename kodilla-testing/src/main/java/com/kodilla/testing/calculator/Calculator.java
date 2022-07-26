package com.kodilla.testing.calculator;

public class Calculator {
    public static void main (String[] args) {
    }

    private int a;
    private int b;

    public Calculator(int a, int b) {
        this.a = a;
        this. b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int add(){
        return a + b;
    }

    public int subtract(){
        return b - a;
    }
}
