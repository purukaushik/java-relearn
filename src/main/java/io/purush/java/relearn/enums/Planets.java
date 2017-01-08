package io.purush.java.relearn.enums;

// Adding member properties to enums
public enum Planets{
  MERCURY(3.303e23, 2.4397e6);
  private final double mass, radius;
  Planets(double mass, double radius){
    this.mass = mass;
    this.radius = radius;
  }
  private double mass(){return mass;}
  private double radius(){ return radius;}
}
