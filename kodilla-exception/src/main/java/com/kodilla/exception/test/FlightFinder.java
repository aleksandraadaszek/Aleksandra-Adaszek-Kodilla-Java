package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightFinder {

    public static void main(String[] args) {

        try {
            FlightFinder flightFinder = new FlightFinder();
            flightFinder.findFlight(new Flight("Okęcie", "Haneda"));
        } catch (RouteNotFoundException e) {
            System.out.println("We apologize for the inconvenience as this flight is not currently available.");
        }
    }


    public Map<String, Boolean> findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> allFlights = new HashMap<>();
        allFlights.put("Okęcie", true);
        allFlights.put("Heathrow", false);
        allFlights.put("O'Hare", false);
        allFlights.put("Charles de Gaulle", true);
        allFlights.put("Haneda", true);
        allFlights.put("Sao Paulo-Guarulhos", false);


        Map<String, Boolean> availableFlights = new HashMap<>();

        for (Map.Entry<String, Boolean> flights : allFlights.entrySet()) {
            if (flights.getValue() == true) {
                availableFlights.put(flights.getKey(), flights.getValue());
            } else {
                throw new RouteNotFoundException();
            }
        }
        return availableFlights;
    }
}

