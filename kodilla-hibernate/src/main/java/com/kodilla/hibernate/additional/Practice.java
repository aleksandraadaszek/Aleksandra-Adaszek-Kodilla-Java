package com.kodilla.hibernate.additional;


import java.util.Random;

public class Practice {

    public static void main (String[] args) {

          Random generator = new Random();
//        int numberOfSchools = generator.nextInt(11);
        School[]schools = new School[10];


        for(int n =0;n<10;n++) {
            int numberOfYears = generator.nextInt(11);
            Year[] years = new Year[10];
            for(int i=0; i<10; i++) {
                years[i] = new Year(i + 1, i + 1);
            }
                schools[n] = new School("school" + n, 1, years);
            }

        for(int n=0; n<10; n++) {
            System.out.println(schools[n]);
        }
    }
}
