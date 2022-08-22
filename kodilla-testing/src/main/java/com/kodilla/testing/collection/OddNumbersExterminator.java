package com.kodilla.testing.collection;


import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {


    public List<Integer> exterminate(List<Integer> numbers) {
        List<Integer> resultList = new ArrayList<>();
        for (Integer finalNumbers : numbers)
            if (finalNumbers % 2 == 0) {
                resultList.add(finalNumbers);
            }
        return resultList;
    }
}





