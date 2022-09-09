package com.kodilla.exception.main;


import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import com.kodilla.exception.io.FileReaderWithoutHandling;

public class ExceptionModuleRunner {

    public static void main(String[] args) throws FileReaderException {
        FileReader fileReader = new FileReader();
        fileReader.readFileModified("fileName");

        try {
            fileReader.readFile();
        } catch (FileReaderException e)  {
          System.out.println("There is a problem while reading a file!");
        }
    }
}
