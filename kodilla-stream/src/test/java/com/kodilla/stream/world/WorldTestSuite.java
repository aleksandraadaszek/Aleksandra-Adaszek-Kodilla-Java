package com.kodilla.stream.world;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class WorldTestSuite {


    @Test
    void testCalculateTotalNumberOfPeople() {
        //Given
        //Countries in North America
        Country theUsa = new Country("The USA", new BigDecimal(335162837));
        Country canada = new Country("Canada", new BigDecimal(38452393));
        Country mexico = new Country("Mexico", new BigDecimal(131840286));
        Continent northAmerica = new Continent("North America");
        northAmerica.addCountry(theUsa);
        northAmerica.addCountry(canada);
        northAmerica.addCountry(mexico);

        //Countries in South America
        Country brazil = new Country("Brazil", new BigDecimal(215802191));
        Country argentina = new Country("Argentina", new BigDecimal(45513090));
        Country uruguay = new Country("Uruguay", new BigDecimal(3499530));
        Continent southAmerica = new Continent("South America");
        southAmerica.addCountry(brazil);
        southAmerica.addCountry(argentina);
        southAmerica.addCountry(uruguay);

        //Countries in Africa
        Country egypt = new Country("Egypt", new BigDecimal(106477664));
        Country nigeria = new Country("Nigeria", new BigDecimal(217107604));
        Country madagascar = new Country("Madagascar", new BigDecimal(29215331));
        Continent africa = new Continent("Africa");
        africa.addCountry(egypt);
        africa.addCountry(nigeria);
        africa.addCountry(madagascar);

        //Countries in Europe
        Country poland = new Country("Poland", new BigDecimal(37757912));
        Country theUK = new Country("The UK", new BigDecimal(68651290));
        Country france = new Country("France", new BigDecimal(65583425));
        Continent europe = new Continent("Europe");
        europe.addCountry(poland);
        europe.addCountry(theUK);
        europe.addCountry(france);

        //Countries in Asia
        Country japan = new Country("Japan", new BigDecimal(125647007));
        Country india = new Country("India", new BigDecimal(1417173173));
        Country china = new Country("China", new BigDecimal(1451235518));
        Continent asia = new Continent("Asia");
        asia.addCountry(japan);
        asia.addCountry(india);
        asia.addCountry(china);

        //Countries in Australia and Oceania
        Country australia = new Country("Australia", new BigDecimal(26132518));
        Country newZealand = new Country("New Zealand", new BigDecimal(4906295));
        Country fiji = new Country("Fiji", new BigDecimal(910369));
        Continent australiaAndOceania = new Continent("Australia and Oceania");
        australiaAndOceania.addCountry(australia);
        australiaAndOceania.addCountry(newZealand);
        australiaAndOceania.addCountry(fiji);

        //Continents in the world
        World theWorld = new World("The world");
        theWorld.addContinent(northAmerica);
        theWorld.addContinent(southAmerica);
        theWorld.addContinent(africa);
        theWorld.addContinent(europe);
        theWorld.addContinent(asia);
        theWorld.addContinent(australiaAndOceania);

        //When
        BigDecimal result = theWorld.getPeopleQuantity();

        //Then
        Assertions.assertEquals(new BigDecimal("4321068433"), result);
    }
}
