package com.kodilla.good.patterns.foodservice;

public class BusinessPartners {



    public void processOrders (final FoodRequest foodRequest) {
        FoodOrderService foodOrderService = new FoodOrderService();
        foodOrderService.soldFood(foodRequest.getProducers(),foodRequest.getFood(), foodRequest.getDateOfOrder());

    }
}
