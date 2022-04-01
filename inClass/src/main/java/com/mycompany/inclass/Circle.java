package com.mycompany.inclass;

/**
 *
 * @author Grant
 */
public class Circle extends Shape{
    // Fields
    double radius;
    
    // Circle constructor
    public Circle(double radius){
        this.radius = radius;
    }
    
    // Area calcuation
    @Override
    public double getArea(){
        return Math.PI * (radius * radius);
    }
   
    // Perimeter calcuation
    @Override
    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }
}
