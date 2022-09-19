package com.kodilla.good.patterns.foodservice;



public class Application {

    public static void main (String[] args) {

     FoodRequestRetriever foodRequestRetriever = new FoodRequestRetriever();
     FoodRequest foodRequest = foodRequestRetriever.retrieveFoodData();

     BusinessPartners businessPartners = new BusinessPartners();
     businessPartners.processOrders(foodRequest);
    }
}
