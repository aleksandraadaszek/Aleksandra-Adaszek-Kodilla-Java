package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast (Temperatures temperatures) {
        this.temperatures = temperatures;
    }
    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for(Map.Entry<String, Double> temperature: temperatures.getTemperatures().entrySet()) {

            resultMap.put(temperature.getKey(), temperature.getValue() +1.0);
        }
        return resultMap;

    }
    public Double calculateAverageTemperature() {
        Map<String, Double> collectedTemperatures = new HashMap<>();
        double sum = 0.00;

        for(Map.Entry<String, Double> knownTemperatures: temperatures.getTemperatures().entrySet()) {

            collectedTemperatures.put(knownTemperatures.getKey(), knownTemperatures.getValue());
            sum = sum + knownTemperatures.getValue();
        }
        Double average = sum/collectedTemperatures.size();
        System.out.println(average);
        return average;
    }

    public double medianFinder () {
        Map<String, Double> forecastData = new HashMap<>();
        List<Double> medianNumbers = new ArrayList<>();

        for(Map.Entry<String, Double> retrievedTemperatures: temperatures.getTemperatures().entrySet()) {

            forecastData.put(retrievedTemperatures.getKey(), retrievedTemperatures.getValue());
            medianNumbers.add(retrievedTemperatures.getValue());
        }
        Collections.sort(medianNumbers);
        double median;
        if(medianNumbers.size() % 2 == 0) {
            double sumOfMiddleElements = (double) (medianNumbers.get(medianNumbers.size() / 2) + medianNumbers.get(medianNumbers.size() / 2 - 1));
            median = (double) sumOfMiddleElements / 2;
        } else {
            median = (double) (medianNumbers.get(medianNumbers.size() + 1)/2);
        }
        return median;
    }
}

