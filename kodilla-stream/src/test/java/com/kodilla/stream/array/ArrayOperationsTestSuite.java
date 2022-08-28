package com.kodilla.stream.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayOperationsTestSuite {


    @Test
    public void testGetAverage() {
        //Given
        int theListOfNumbers[] = new int[] {2, 44, 876, 33, 99, 134, 11, 9, 66, 59, 23, 28, 876, 195, 77, 19, 17, 49, 101, 222 };

        //When
        double average = ArrayOperations.getAverage(theListOfNumbers);

        //Then
        Assertions.assertEquals(147, average);
    }
}
