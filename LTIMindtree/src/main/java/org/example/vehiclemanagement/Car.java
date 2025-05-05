package org.example.vehiclemanagement;

public class Car extends Vehicle {

    private int seats;

    @Override
    public void start() {
        System.out.println("Car started with key ignition");
    }

    public int getSeats() {
        return seats;
    }

    public Car(String number, String brand, int seats) {
        super(number, brand);
        this.seats = seats;
    }
}