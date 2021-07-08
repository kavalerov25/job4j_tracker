package ru.job4j.stream;

import ru.job4j.tracker.StubOutput;

public class Car {
    private String brand;
    private String model;
    private byte age;
    private double maxSpeed;
    private double rateFuel;
    private double fuel;

    static class Builder {
        private String brand;
        private String model;
        private byte age;
        private double maxSpeed;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildAge(byte age) {
            this.age = age;
            return this;
        }

        Builder buildMaxSpeed(double maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.brand = brand;
            car.model = model;
            car.age = age;
            car.maxSpeed = maxSpeed;
            return car;
        }
    }

    @Override
    public String toString() {
        return "Builder{"
               + "brand='" + brand + '\''
               + ", model='" + model + '\''
               + ", age=" + age
               + ", maxSpeed=" + maxSpeed
               + '}';
    }

    public static void main(String[] args) {
        Car car = new Builder().buildBrand("Nissan")
                .buildModel("Qashqai")
                .buildAge((byte) 3)
                .buildMaxSpeed(194)
                .build();
        System.out.println(car);
    }
}
