package com.kodilla.good.patterns.airline;

import java.util.Scanner;

public class UserDialogues {

    public void choosingSearchingType () {
        FlightFinder flightFinder = new FlightFinder();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Jak chcesz wyszukiwać loty?");
        System.out.println("Naciśnij \"a , żeby wyszukać po lotnisku.");
        System.out.println("Naciśnij \"b , żeby wyszukać po lotnisku i wyświetlić godziny lotów.");
        String userChoice = scanner.nextLine();
        if ("Aa".contains(userChoice)) {
            System.out.println("Podaj miasto wylotu.");
            String cityFrom = scanner.nextLine();
            System.out.println("Podaj miasto przylotu.");
            String cityTo = scanner.nextLine();
           flightFinder.findFlightFromAndTo(cityFrom, cityTo);
        flightFinder.findFlightThrough(cityFrom, cityTo);
        } else if ("Bb".contains(userChoice)) {
            System.out.println("Podaj miasto wylotu.");
            String cityFrom = scanner.nextLine();
            System.out.println("Podaj miasto przylotu.");
            String cityTo = scanner.nextLine();
            flightFinder.findFlightsFrom(cityFrom);
            flightFinder.findFlightsTo(cityTo);
            flightFinder.findFlightsThrough(cityFrom, cityTo);
        } else {
            System.out.println("Wybrano złą opcję.");
    }
    }
}
