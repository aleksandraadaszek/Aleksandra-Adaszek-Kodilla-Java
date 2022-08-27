package com.kodilla.stream.world;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public final class World {

        private List<Continent> continents = new ArrayList<>();
        private final String name;


        public World(String name) {
                this.name = name;
        }

        public void addContinent(Continent continent) {
                continents.add(continent);
        }

        public List<Continent> getContinents() {
                return continents;
        }

        BigDecimal getPeopleQuantity() {
                BigDecimal totalNumber = continents.stream()
                        .flatMap(continent -> continent.getCountries().stream())
                        .map(Country::getPeopleQuantity)
                        .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
                        return totalNumber;
        }
}
