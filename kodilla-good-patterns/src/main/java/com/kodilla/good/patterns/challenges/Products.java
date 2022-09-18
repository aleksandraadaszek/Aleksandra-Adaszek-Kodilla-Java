package com.kodilla.good.patterns.challenges;

public class Products {

    private String name;
    private int amount;
    private double price;

    public Products(String name, int amount, double price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public double calculateFinalPrice() {
        return amount * price;

    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }
}
