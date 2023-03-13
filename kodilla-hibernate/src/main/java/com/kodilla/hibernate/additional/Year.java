package com.kodilla.hibernate.additional;


public class Year {

    public Integer classNumber;
    public Integer numberOfStudents;


    public Year( Integer classNumber, Integer numberOfStudents) {
        this.classNumber=classNumber;
        this.numberOfStudents=numberOfStudents;
    }

    public String toString() {
        return "Class number " + classNumber + "Number of students " + numberOfStudents;
    }
}
