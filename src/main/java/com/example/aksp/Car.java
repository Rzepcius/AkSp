package com.example.aksp;

public class Car {

    private String mark;
    private String model;

    public Car() {
    }

    public Car(String mark, String model) {
        this.mark = mark;
        this.model = model;
    }

    public String getMark() {
        return mark;
    }

    public Car setMark(String mark) {
        this.mark = mark;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    @Override
    public String toString() {
        return "Car{" +
                "mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
