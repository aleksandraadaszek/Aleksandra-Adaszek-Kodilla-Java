package com.kodilla.patterns.builder.checkers;


public final class FigureFactory {

    public static final String PAWN = "PAWN";
    public static final String QUEEN = "QUEEN";

    public static Figure makeFigure(String figureType, String colour) {
        if(figureType.equals(PAWN)) {
            return new Pawn(colour);
        }else if (figureType.equals(QUEEN)) {
            return new Queen(colour);
        }else{
            throw new IllegalStateException("The type of a figure should be either a pawn or a queen.");
        }
    }
}
