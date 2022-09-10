package com.kodilla.exception.test;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTest() {
        System.out.println("This is the beginning of all tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("This is the end of all tests.");
    }

    @BeforeEach
    public void beforeEachTest() {
        testCounter++;
        System.out.println("Preparing to execute test number " + testCounter);
    }

    @Test
    void testSecondChallengeAssertDoesNotThrow() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        //When & Then
        assertDoesNotThrow(() -> secondChallenge.probablyWillThrowException(1.5, 3));
    }

    @Test
    void testSecondChallengeBoundaryValues() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        //When & Then
        assertAll(
                () ->assertDoesNotThrow(() ->secondChallenge.probablyWillThrowException(1,1.4)),
                () ->assertThrows(Exception.class, () -> secondChallenge.probablyWillThrowException(2, 1.5))
        );
}

    @Test
    void testSecondChallengeAssertionThrows() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        //When & Then
        assertThrows(Exception.class, ()-> secondChallenge.probablyWillThrowException(4, 1.5));
    }
}
