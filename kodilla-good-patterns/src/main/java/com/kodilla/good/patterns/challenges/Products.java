package com.kodilla.good.patterns.challenges;

public class Products {

    private String name;
    private int amount;
    private int price;

    public Products(String name, int amount, int price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public int calculateFinalPrice() {
        return amount * price;

    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }
}
