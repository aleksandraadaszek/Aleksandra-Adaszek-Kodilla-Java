package com.kodilla.exception.test;



public class ExceptionHandling {

    public static int tryCounter = 0;

    public static void main(String[] args) {

        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            String result = secondChallenge.probablyWillThrowException(7, 2);
            System.out.println (result);
        }catch (Exception e) {
            System.out.println ("There is a problem and this is " + e);
        }finally{
        System.out.println("That was the # " + tryCounter + "attempt to calculate.");
    }
    }
}
