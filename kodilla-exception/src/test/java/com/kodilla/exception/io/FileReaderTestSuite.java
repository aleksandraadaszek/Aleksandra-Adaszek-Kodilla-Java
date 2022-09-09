package com.kodilla.exception.io;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTestSuite {

    @Test
    void testReadFile() {
        //Given
        FileReader fileReader = new FileReader();
        //When & Then
        assertDoesNotThrow( () -> fileReader.readFile());
    }

    @Test
    void whenFileDoesntExistReadFileShouldThrowException () {
            //Given
        FileReader fileReader = new FileReader();
        String fileName = "nie_ma_takiego_pliku.txt";

            //When & Then
        assertThrows(FileReaderException.class, () -> fileReader.readFileModified(fileName));
    }

    @Test
    void testReadFileWithName () {
        //Given
        FileReader fileReader = new FileReader();

        //When & Then
        assertAll(
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFileModified("nie_ma_takiego_pliku.txt")),
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFileModified(null)),
                () -> assertDoesNotThrow( () -> fileReader.readFileModified("names.txt"))
        );
    }
}
