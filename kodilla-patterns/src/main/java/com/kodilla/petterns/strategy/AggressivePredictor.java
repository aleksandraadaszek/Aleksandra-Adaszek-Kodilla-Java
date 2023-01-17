package com.kodilla.petterns.strategy;


public class AggressivePredictor implements BuyPredictor{

    @Override
    public String predictWhatToBuy() {
        return "[AggressivePredictor] Buy stock of XYZ";
    }
}
