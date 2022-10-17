package com.kodilla.good.patterns.airline;


import java.sql.SQLOutput;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class FlightFinder {

    final List<Flight> availableConnections = new ArrayList<>();
    final Map<Flight, Time> currentlyAvailableFlights = new HashMap<>();

    public FlightFinder() {

        availableConnections.add(new Flight("Kraków", "Wroclaw"));
        availableConnections.add(new Flight("Łódź", "Wrocław"));
        availableConnections.add(new Flight("Szczecin", "Gdańsk"));
        availableConnections.add(new Flight("Łódź", "Gdańsk"));
        availableConnections.add(new Flight("Warszawa", "Kraków"));
        availableConnections.add(new Flight("Poznań", "Warszawa"));
        availableConnections.add(new Flight("Toruń", "Kraków"));
        availableConnections.add(new Flight("Kraków", "Warszawa"));

        currentlyAvailableFlights.put(new Flight("Kraków", "Wroclaw"), new Time(LocalTime.of(16, 30), LocalTime.of(17, 30)));
        currentlyAvailableFlights.put(new Flight("Łódź", "Wrocław"), new Time(LocalTime.of(11, 30), LocalTime.of(12, 15)));
        currentlyAvailableFlights.put(new Flight("Szczecin", "Gdańsk"), new Time(LocalTime.of(11, 15), LocalTime.of(11, 30)));
        currentlyAvailableFlights.put(new Flight("Łódź", "Gdańsk"), new Time(LocalTime.of(10, 00), LocalTime.of(10, 40)));
        currentlyAvailableFlights.put(new Flight("Warszawa", "Kraków"), new Time(LocalTime.of(14, 30), LocalTime.of(15, 15)));
        currentlyAvailableFlights.put(new Flight("Poznań", "Warszawa"), new Time(LocalTime.of(17, 20), LocalTime.of(18, 00)));
        currentlyAvailableFlights.put(new Flight("Toruń", "Kraków"), new Time(LocalTime.of(16, 10), LocalTime.of(17, 05)));
        currentlyAvailableFlights.put(new Flight("Kraków", "Warszawa"), new Time(LocalTime.of(19, 05), LocalTime.of(19, 55)));

    }

    public Map<Flight, Time> getCurrentlyAvailableFlights() {
        return new HashMap<>(currentlyAvailableFlights);
    }

    public void findFlightsFrom(String connection) {
        FlightFinder flightFinder = new FlightFinder();
        System.out.println("Dostępne są następujące wyloty z: " + connection);
        Map<Flight, Time> foundFlights = flightFinder.getCurrentlyAvailableFlights().entrySet().stream()
                .filter(flight -> flight.getKey().getDepartureAirport().equals(connection))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        for (Map.Entry<Flight, Time> finalFlights : foundFlights.entrySet()) {
            System.out.println(finalFlights);

        }
    }

    public void findFlightsTo(String connection2) {
        FlightFinder flightFinder = new FlightFinder();
        System.out.println("Dostępne są następujące przyloty do: " + connection2);
        Map<Flight, Time> foundFlights = flightFinder.getCurrentlyAvailableFlights().entrySet().stream()
                .filter(flight -> flight.getKey().getArrivalAirport().equals(connection2))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        for (Map.Entry<Flight, Time> finalFlights : foundFlights.entrySet()) {
            System.out.println(finalFlights);
        }
    }

    public Map<Flight, Time> findFlightsThrough(String connection, String connection2) {
        FlightFinder flightFinder = new FlightFinder();
        Map<Flight, Time> foundFlights = flightFinder.getCurrentlyAvailableFlights().entrySet().stream()
                .filter(flight -> flight.getKey().getDepartureAirport().equals(connection))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        Map<Flight, Time> foundFlights2 = flightFinder.getCurrentlyAvailableFlights().entrySet().stream()
                .filter(flight -> flight.getKey().getArrivalAirport().equals(connection2))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Map<Flight, Time> finalFlights = new HashMap<>();
        for (Map.Entry<Flight, Time> finalFlights2 : foundFlights.entrySet()) {
            for (Map.Entry<Flight, Time> finalFlights3 : foundFlights2.entrySet()) {
                if (finalFlights2.getKey().getArrivalAirport().equals(finalFlights3.getKey().getDepartureAirport())
                        && finalFlights2.getValue().getArrivalTime().isBefore(finalFlights3.getValue().getDepartureTime())) {
                    finalFlights.put(finalFlights2.getKey(), finalFlights2.getValue());
                    finalFlights.put(finalFlights3.getKey(), finalFlights3.getValue());
                    System.out.println("Lot z " + finalFlights2.getKey().getDepartureAirport() + " o godzinie "
                            + finalFlights2.getValue().getDepartureTime() + " przez " + finalFlights2.getKey().getArrivalAirport()
                            + " o godzinie " + finalFlights2.getValue().getArrivalTime() + " do " + finalFlights3.getKey().getArrivalAirport()
                            + " o godzinie " + finalFlights3.getValue().getArrivalTime());
                }
            }
        }
        return finalFlights;

    }

    public void findFlightFromAndTo(String connection, String connection2) {
        FlightFinder flightFinder = new FlightFinder();
        System.out.println("Dostępne są następujące wyloty z: " + connection);
        flightFinder.getAvailableConnections().stream()
                .filter(flight -> flight.getDepartureAirport().equals(connection))
                .forEach(System.out::println);

        System.out.println("\nDostępne są następujące przyloty do: " + connection2);
        flightFinder.getAvailableConnections().stream()
                .filter(flight -> flight.getArrivalAirport().equals(connection2))
                .forEach(System.out::println);

    }

    public void findFlightThrough(String from, String to) {
        FlightFinder flightFinder = new FlightFinder();
        List<Flight> flightsThrough = flightFinder.getAvailableConnections().stream()
                .filter(flight -> flight.getDepartureAirport().equals(from))
                .collect(Collectors.toList());

        List<Flight> flightsThrough2 = flightFinder.getAvailableConnections().stream()
                .filter(flight -> flight.getArrivalAirport().equals(to))
                .collect(Collectors.toList());


        for (Flight flight : flightsThrough) {
            for (Flight flight1 : flightsThrough2) {
                if (flight.getArrivalAirport().equals(flight1.getDepartureAirport())) {
                    System.out.println("Wylot z " + flight.getDepartureAirport() + " przez: " + flight.getArrivalAirport() + " do " + flight1.getArrivalAirport());
                }

            }

        }

        }
        public List<Flight> getAvailableConnections() {
            return new ArrayList<>(availableConnections);
    }
}







