package org.example.vehiclemanagement;

public abstract class Vehicle {

    private String registrationNumber;
    private String brand;

    protected Vehicle(String registrationNumber, String brand) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public abstract void start();
}
