package com.mycompany.inclass;

/**
 *
 * @author Grant
 */
public class Rectangle extends Shape{
    // Fields
    double sideA, sideB;
    
    // Rectangle constructor
    public Rectangle(double sideA, double sideB){
        this.sideA = sideA;
        this.sideB = sideB;
    }
    
    // Area calculation
    @Override
    public double getArea(){
        return sideA * sideB;
    }
    
    // Perimeter calculation
    @Override
    public double getPerimeter(){
        return sideA * 2 + sideB * 2;
    }
}
