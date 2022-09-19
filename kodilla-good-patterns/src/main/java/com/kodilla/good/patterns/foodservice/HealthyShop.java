package com.kodilla.good.patterns.foodservice;



public class HealthyShop implements Producer {

    Producer producer;
    FoodRequest foodRequest;

    public HealthyShop (FoodRequest foodRequest) {
        this.foodRequest = foodRequest;
    }

    public void process () {
        BusinessPartners businessPartners= new BusinessPartners();
        businessPartners.processOrders(foodRequest);
    }

    public FoodRequest getFoodRequest() {
        return foodRequest;
    }
}

