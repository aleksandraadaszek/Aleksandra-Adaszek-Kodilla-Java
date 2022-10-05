package com.kodilla.good.patterns.foodservice;


import java.time.LocalDateTime;

public class FoodOrderService {


    public void processOrders(FoodRequest foodRequest) {
        FoodProducer foodProducer = null;
        if (foodRequest.getProducerName().equals("Healthy Shop")) {
            foodProducer = new HealthyShop(foodRequest);
        } else if (foodRequest.getProducerName().equals("Gluten Free Shop")) {
            foodProducer = new GlutenFreeShop(foodRequest);
        } else {
            foodProducer = new ExtraFoodShop(foodRequest);
        }
        foodProducer.process(foodRequest);
    }

    public boolean soldFood(String name, Food food, LocalDateTime dateOfOrder) {
        System.out.println("On " + dateOfOrder.toString() + " " + name + " " + "sold: " +
                food.getAmount() + " " + "of " + food.getName() + " " + "for " +
                food.getPrice() + " " + "each, and so the total price is: " + food.calculateFinalPrice());
        return true;
    }
}
