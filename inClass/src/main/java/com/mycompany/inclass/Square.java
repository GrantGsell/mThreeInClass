package com.mycompany.inclass;

/**
 *
 * @author Grant
 */
public class Square extends Shape{
    double sideA, sideB;
    
    public Square(double sideA, double sideB){
        this.sideA = sideA;
        this.sideB = sideB;
    }
    
    @Override
    public double getArea(){
        return sideA * sideB;
    }
    
    @Override
    public double getPerimeter(){
        return sideA * 2 + sideB * 2;
    }
}
