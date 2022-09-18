package com.kodilla.good.patterns.challenges;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class MainClass {


    public static void main(String[] args)  {

        MovieStore movieStore = new MovieStore();
        String theResultStringOfMovies;
        theResultStringOfMovies = movieStore.getMovies().entrySet().stream()
                .flatMap(movie -> movie.getValue().stream())
                .collect(Collectors.joining(",\n", "", ""));

                System.out.println(theResultStringOfMovies);
    }
}

