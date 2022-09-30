package com.kodilla.good.patterns.foodservice;



public class Application {

    public static void main (String[] args) {

     FoodRequestRetriever foodRequestRetriever = new FoodRequestRetriever();
     FoodRequest foodRequest = foodRequestRetriever.retrieveFoodData();

     FoodOrderService foodOrderService = new FoodOrderService();
     foodOrderService.processOrders(foodRequest);
    }
}
