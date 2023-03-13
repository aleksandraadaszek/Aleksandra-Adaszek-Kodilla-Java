package com.kodilla.hibernate.additional;



public class School {

    public String name;
    public int number;
    public Year[] years;


    public School(String name, int number, Year[] years) {
        this.name=name;
        this.number=number;
        this.years=years;
    }


    @Override
    public String toString() {
        String y = " ";
        for(Year x: years){
            y+=x + "\n";
        }
        return "Name: " + name + "number: " + number + "years " + y;
    }
}
