package com.kodilla.good.patterns.airline;


import java.time.LocalTime;
import java.util.Objects;

public class Time {

    private LocalTime departureTime;

    private LocalTime arrivalTime;


    public Time(LocalTime departureTime, LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }


    @Override
    public String toString() {
        return "Dostępne godziny{" +
                "godzina odlotu=" + departureTime +
                ", godzina przylotu=" + arrivalTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return Objects.equals(arrivalTime, time.arrivalTime) && Objects.equals(departureTime, time.departureTime);
    }

    @Override
    public int hashCode() {
        int result = arrivalTime != null ? arrivalTime.hashCode() : 0;
        result = 31 * result + (departureTime != null ? departureTime.hashCode() : 0);
        return result;
    }
}
