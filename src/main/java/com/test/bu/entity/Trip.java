package com.test.bu.entity;

import javax.persistence.*;

@Entity
@Table
public class Trip{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String pointA;
    private String pointB;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Driver.class)
    private Driver driver;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Vehicle.class)
    private Vehicle vehicle;
    private double distance;
    private double price;
    private boolean status;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPointA() {
        return pointA;
    }

    public void setPointA(String pointA) {
        this.pointA = pointA;
    }

    public String getPointB() {
        return pointB;
    }

    public void setPointB(String pointB) {
        this.pointB = pointB;
    }
}

