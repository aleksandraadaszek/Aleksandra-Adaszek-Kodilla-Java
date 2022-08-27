package com.kodilla.stream.world;


import java.math.BigDecimal;

public final class Country {

    private final String name;
    BigDecimal numberOfPeople;


    public Country(String name, BigDecimal numberOfPeople) {
        this.name = name;
        this.numberOfPeople = numberOfPeople;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getNumberOfPeople() {
        return numberOfPeople;
}

    public BigDecimal getPeopleQuantity() {
        return numberOfPeople;
    }

}
