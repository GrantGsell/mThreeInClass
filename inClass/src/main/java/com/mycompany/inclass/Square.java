package com.mycompany.inclass;

/**
 *
 * @author Grant
 */
public class Square extends Shape{
    // fields
    double sideA;
    
    // Square constructor
    public Square(double sideA){
        this.sideA = sideA;
    }
    
    // Area calcluation
    @Override
    public double getArea(){
        return sideA * sideA;
    }
    
    // Perimeter calculation
    @Override
    public double getPerimeter(){
        return sideA * 2 + sideA * 2;
    }
}
