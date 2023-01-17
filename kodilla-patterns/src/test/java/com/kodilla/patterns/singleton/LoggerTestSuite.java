package com.kodilla.patterns.singleton;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    private static Logger logger = Logger.INSTANCE;




    @Test
    void testGetLastLog() {
        //Given
        logger.log("This is logging number: ");

        //When
        String lastLog = logger.getLastLog();
        System.out.println("Retrieved datum: " + lastLog);

        //Then
        assertEquals("This is logging number: ", lastLog);
    }

}
