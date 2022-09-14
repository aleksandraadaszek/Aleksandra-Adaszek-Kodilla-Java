package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.get;

public class FlightFinder {

    public static void main(String[] args) {

        try {
            FlightFinder flightFinder = new FlightFinder();
            flightFinder.findFlight(new Flight("Okęcie", "Haneda"));
        } catch (RouteNotFoundException e) {
            System.out.println("We apologize for the inconvenience as this flight is not currently available.");
        }
    }


    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> allFlights = new HashMap<>();
        allFlights.put("Okęcie", true);
        allFlights.put("Heathrow", false);
        allFlights.put("O'Hare", false);
        allFlights.put("Charles de Gaulle", true);
        allFlights.put("Haneda", true);
        allFlights.put("Sao Paulo-Guarulhos", false);

            String city = flight.getArrivalAirport();
            if (allFlights.containsKey(city)) {
                return allFlights.get(city);
            } else {
                throw new RouteNotFoundException();
            }
        }

    }





