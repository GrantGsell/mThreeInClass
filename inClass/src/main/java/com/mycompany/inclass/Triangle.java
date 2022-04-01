package com.mycompany.inclass;
import java.util.*;
/**
 *
 * @author Grant
 */
public class Triangle extends Shape {
    double sideA, sideB, sideC;
    
    public Triangle(double sideA, double sideB, double sideC){
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }
    
    
    @Override
    public double getArea(){
        // Calcuate semi perimieter
        double semi = (sideA + sideB + sideC ) / 2;
        
        // Calculate area using Herons Formula
        double area = Math.sqrt(semi * (semi - sideA) * (semi - sideB) * 
                (semi - sideC));
        
        return area;
    }
    
    @Override
    public double getPerimeter(){       
        return sideA + sideB + sideC;
    }
    
}
