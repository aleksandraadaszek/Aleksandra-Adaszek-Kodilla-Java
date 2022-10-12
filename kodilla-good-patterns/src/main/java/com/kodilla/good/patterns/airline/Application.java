package com.kodilla.good.patterns.airline;



public class Application {

    public static void main(String[] args) {
//        FlightFinder flightFinder = new FlightFinder();
//        flightFinder.findFlightsThrough("Warszawa", "Wrocław");
        UserDialogues userDialogues = new UserDialogues();
        userDialogues.choosingSearchingType();
        System.out.println("Searching for the right connection...");
    }
}
