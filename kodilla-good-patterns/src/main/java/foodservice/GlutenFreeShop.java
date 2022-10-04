package com.kodilla.good.patterns.foodservice;




public class GlutenFreeShop  implements FoodProducer {

    FoodRequest foodRequest;

    public GlutenFreeShop (FoodRequest foodRequest ) {
        this.foodRequest = foodRequest;
    }

    public void process (FoodRequest foodRequest) {
        System.out.println("The order has been completed and dispatched.");
        FoodOrderService foodOrderService = new FoodOrderService();
        foodOrderService.soldFood("Gluten Free Shop",foodRequest.getFood(),foodRequest.getDateOfOrder());
    }

    public FoodRequest getFoodRequest () {
        return foodRequest;
    }
}



