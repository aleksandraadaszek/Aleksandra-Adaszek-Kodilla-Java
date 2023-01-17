package com.kodilla.patterns.builder.checkers;



public class Figure {

    public static final String BLACK = "BLACK";
    public static final String WHITE = "WHITE";
    private final String colour;

    public Figure (String colour) {
        if(colour.equals(BLACK) || colour.equals(WHITE)) {
            this.colour=colour;
        }else{
            throw new IllegalStateException("Figures of checkers should be BLACK or WHITE.");
        }
    }

    public String getColour() {
        return colour;
    }
}
