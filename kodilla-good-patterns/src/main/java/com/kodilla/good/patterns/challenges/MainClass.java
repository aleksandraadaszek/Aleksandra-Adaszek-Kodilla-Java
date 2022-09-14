package com.kodilla.good.patterns.challenges;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainClass {


    public static void Main(String[] args)  {

        MovieStore movieStore = new MovieStore();
        Map<String, List<String>> theResultStringOfMovies;
        theResultStringOfMovies = movieStore.getMovies().stream()
                .collect(Collectors.toMap());

        theResultStringOfMovies.entrySet().stream()
                .map(entry -> getValue())
                .collect(Collectors.joining(",\n", "", ""));

                System.out.println(theResultStringOfMovies);
    }
}

