package org.example;

public class TimeOfDay implements Comparable<TimeOfDay> {

    //часы (от 0 до 23)
    private int hours;
    //минуты (от 0 до 59)
    private int minutes;

    public TimeOfDay(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    @Override
    public int compareTo(TimeOfDay o) {
        if (this.hours < o.hours) {
            return -1;
        }
        return 0;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }
}