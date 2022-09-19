package com.kodilla.good.patterns.foodservice;


import com.kodilla.good.patterns.challenges.ProductOrderService;

import java.util.ArrayList;
import java.util.List;

public class Producers {

    private String producerName;
    private List<Producer> currentProducers = new ArrayList<>();


    public Producers(String producerName) {
        this.producerName = producerName;
    }

    public void addProducer (Producer producer) {
        currentProducers.add(producer);
    }

    public void processOrders (final FoodRequest foodRequest) {
        FoodOrderService foodOrderService = new FoodOrderService();
        foodOrderService.soldFood(foodRequest.getProducers(),foodRequest.getFood(), foodRequest.getDateOfOrder());
    }

    public boolean removeProducer (Producer producer) {
        boolean result = false;
        if(currentProducers.contains(producer)) {
            currentProducers.remove(producer);
            result = true;
        }
        return result;
    }

    public int numberOfProducers () {
        return currentProducers.size();
    }

    public String showProducers () {
        return currentProducers.toString();
    }

    public String getProducerName() {
        return producerName;
    }
}
