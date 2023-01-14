package com.scalar.design.lld.tinder;

import java.util.List;

/**
 * @author t0k02w6 on 04/01/23
 * @project scalar-ds
 */
public class User {
  private String id;
  private String name;
  private List<String> pictures;
  private double location;
  private int radius;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getPictures() {
    return pictures;
  }

  public void setPictures(List<String> pictures) {
    this.pictures = pictures;
  }

  public double getLocation() {
    return location;
  }

  public void setLocation(double location) {
    this.location = location;
  }

  public int getRadius() {
    return radius;
  }

  public void changeRadius(int radius) {
    this.radius = radius;
    return;
  }
}
