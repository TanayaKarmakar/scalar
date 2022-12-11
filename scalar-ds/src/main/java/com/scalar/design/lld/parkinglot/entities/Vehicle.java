package com.scalar.design.lld.parkinglot.entities;

/**
 * @author t0k02w6 on 11/12/22
 * @project scalar-ds
 */
public class Vehicle {
  private String regNumber;
  private VehicleType vehicleType;
  private VehicleColor color;
  private String brand;
  private String model;

  public String getRegNumber() {
    return regNumber;
  }

  public void setRegNumber(String regNumber) {
    this.regNumber = regNumber;
  }

  public VehicleType getVehicleType() {
    return vehicleType;
  }

  public void setVehicleType(VehicleType vehicleType) {
    this.vehicleType = vehicleType;
  }

  public VehicleColor getColor() {
    return color;
  }

  public void setColor(VehicleColor color) {
    this.color = color;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }
}
