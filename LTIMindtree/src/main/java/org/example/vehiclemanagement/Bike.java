package org.example.vehiclemanagement;

public class Bike extends Vehicle{

    private int seats;

    @Override
    public void start() {
        System.out.println("Bike started with button/ Kick Ignition " + seats);
    }
    public Bike(String number, String brand, int seats){
        super(number,brand);
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }
}
