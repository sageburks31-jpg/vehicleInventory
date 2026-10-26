package com.pluralsight;

public class Vehicle {
    private long vehicleId = 0;
    private String makeModel = "";
    private String color = "";
    private int odometerReading = 0;
    private double price = 0.0;
    private boolean vehicleExist=false;

    public Vehicle(long vehicleId, String makeModel, String color, int odometerReading, double price, boolean VehicleExist) {
        this.vehicleId = vehicleId;
        this.makeModel = makeModel;
        this.color = color;
        this.odometerReading = odometerReading;
        this.price = price;
        this.vehicleExist=VehicleExist;
    }

    public boolean isVehicleExist() {
        return vehicleExist;
    }

    public void setVehicleExist(boolean vehicleExist) {
        this.vehicleExist = vehicleExist;
    }

    public Vehicle() {
    }
    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdometerReading() {
        return odometerReading;
    }

    public void setOdometerReading(int odometerReading) {
        this.odometerReading = odometerReading;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
