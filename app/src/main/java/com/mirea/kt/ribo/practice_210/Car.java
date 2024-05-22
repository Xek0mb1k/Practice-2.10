package com.mirea.kt.ribo.practice_210;

public class Car {
    String model;
    String number;
    int yearOfIssue;

    public Car(String model, String number, int yearOfIssue) {
        this.model = model;
        this.number = number;
        this.yearOfIssue = yearOfIssue;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }
}
