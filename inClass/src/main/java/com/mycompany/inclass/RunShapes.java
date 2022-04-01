package com.mycompany.inclass;

/**
 *
 * @author Grant
 */
public class RunShapes {
    public static void display(Shape shape, String name){
        // Get perimeter and area
        double area = shape.getArea();
        double perimeter = shape.getPerimeter();
        
        // Print the data
        System.out.format("\nThe given %s has- \nAn area of: %.3f\nAnd a "
                + "perimeter of: %.3f\n", name, area, perimeter);
        
        
    }
    
    
    public static void main(String[] args){
        // Create objects
        Square square = new Square(2);
        Rectangle rect = new Rectangle(3, 4);
        Triangle tri = new Triangle(3, 4, 5);
        Circle circ = new Circle(3);
    
        // Get, print area/perimeter for each object
        display(square, "square");
        display(rect, "rectangle");
        display(tri, "triangle");
        display(circ, "circle");
        
    }
}
