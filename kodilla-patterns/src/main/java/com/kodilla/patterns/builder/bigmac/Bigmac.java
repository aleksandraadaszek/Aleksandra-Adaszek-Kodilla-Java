package com.kodilla.patterns.builder.bigmac;


import java.util.ArrayList;
import java.util.List;

public final class Bigmac {

    private final String bun;
    private final int burgers;
    private final String sauce;
    private List<String> ingredients = new ArrayList<>();


    public static class BigmacBuilder {

        private String bun;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder bun(String bun) {
            this.bun = bun;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(String ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            return new Bigmac(bun, burgers, sauce, ingredients);
        }
    }

        private Bigmac(String bun, int burgers, String sauce, List<String> ingredients) {
            this.bun = bun;
            this.burgers = burgers;
            this.sauce = sauce;
            this.ingredients = new ArrayList<>(ingredients);
        }

        public String getBun() {
            return bun;
        }

        public int getBurgers() {
            return burgers;
        }

        public String getSauce() {
            return sauce;
        }

        public List<String> getIngredients() {
            return ingredients;
        }

        public String toString() {
            return "Bigmac{ " + "Bun: " + bun + ", the number of burgers: " + burgers + ", Sauce: " + sauce + ", Ingredients: " + ingredients + " }.";
    }
}
