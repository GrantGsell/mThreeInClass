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
        System.out.println("\nThe given " + name + " has- \nAn area of: " + area + 
                "\nAnd a perimeter of: " + perimeter + "\n");
        
        
    }
    
    
    public static void main(String[] args){
        // Create objects
        Square square = new Square(2, 2);
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
