package com.kodilla.testing.collection;


import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {


    public List<Integer> exterminate(List<Integer> numbers) {
        List<Integer> resultList = new ArrayList<>();
        for (Integer finalNumber : numbers)
            if (finalNumber % 2 == 0) {
                resultList.add(finalNumber);
            }
        return resultList;
    }
}





