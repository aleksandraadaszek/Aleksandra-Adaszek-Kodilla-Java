package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@DisplayName("Collection Test Suite")
public class CollectionTestSuite {
    

        private static int testCounter = 0;

        @BeforeAll
        public static void beforeAllTests() {
            System.out.println("This is the beginning of tests.");
        }

        @AfterAll
        public void afterAllTests() {
            System.out.println("All tests are finished.");
        }

        @BeforeEach
        public void beforeEveryTest() {
            testCounter++;
            System.out.println("Preparing to execute test #" + testCounter);
        }


        @Test
        void testEmptyList() {
            //Given
            OddNumbersExterminator exterminator = new OddNumbersExterminator();
            List<Integer> emptyList = new ArrayList<>();
            List<Integer> expectedList = new ArrayList<>();


            //When
            List<Integer> retrievedList = exterminator.exterminate(emptyList);

            //Then
            Assertions.assertEquals(expectedList, retrievedList);
        }

        @Test
        void testEvenNumbersList() {
            //Given
            OddNumbersExterminator exterminator = new OddNumbersExterminator();
            List<Integer> initialList = List.of(3, 7, 8, 10, 11, 14, 22, 23);
            exterminator.exterminate(initialList);
            List<Integer> expectedList = List.of(8, 10, 14, 22);

            //When
            List<Integer> retrievedList = exterminator.exterminate(initialList);

            //Then
            Assertions.assertEquals(expectedList, retrievedList);


        }
    }

