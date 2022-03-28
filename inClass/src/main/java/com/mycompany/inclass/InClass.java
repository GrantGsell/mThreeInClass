/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.inclass;
import java.util.Scanner;

/**
 *
 * @author Grant
 */
public class InClass {
    
    public static void scannerTest(){
        // Create scanner object
        Scanner myScanner = new Scanner(System.in);
        
        
        // Create strings to hold input
        String firstName = "";
        String lastName = "";
        
        // Prompt the user for input
        System.out.println("Please enter your first name: ");
        firstName = myScanner.nextLine();
        
        System.out.println("Please eneter your last name: ");
        lastName = myScanner.nextLine();
                
        // Display the user input
        System.out.println("Your name is: " + firstName + " " + lastName);
        
    }
    
    
    /*
     * Purpose: Wrapper that runs the program.
     * Params : None.
     * Return : None.
     */
    public static void topWindowMaster(){
        // Obtain the dimensions of the users window
        double[] dims = obtainDimensions();
        
        // Obtain the area of the users window
        double area = calculateArea(dims);
        
        // Obtain the perimeter of the users window
        double perimeter = calculatePerimeter(dims);
        
        // Calculate the cost of the project
        double cost = calculateCost(area, perimeter);
        
        // Display the data on screen
        displayData(area, perimeter, cost);
    }
    
    
    /*
     * Purpose: To obtain the heigh and width of a window based on user input.
     * Params : None.
     * Return : A two element double array, whose values map to width, height.
     */
    public static double[] obtainDimensions(){
        // Create scanner object
        Scanner input = new Scanner(System.in);
        
        // Create variables to hold input
        String width;
        String height;
        
        // Create array to hold results
        double[] results = new double[2];
        
        // Create variables to hold converted values
        double valWidth;
        double valHeight;
        
        // Prompt user for input
        while(true){
            try{
                System.out.println("Please enter the width of the window: ");
                width = input.nextLine();
                System.out.println("Please enter the width of the window: ");
                height = input.nextLine();
                
                // Typecast to floats
                valWidth = Double.parseDouble(width);
                valHeight = Double.parseDouble(height);
                break;
            }catch(Exception e){
                System.out.println("Input ERROR!, Please Try again");
            }
        }
                
        // Type cast variables to int, inside int array
        results[0] = valWidth;
        results[1] = valHeight;
        
        return results;        
    }
    
    
    /*
     * Purpose: Calculates the area of a rectangle.
     * Params : One double array containing width, height in that order.
     * Return : One double, denoting height.
     */
    public static double calculateArea(double[] arr){
        // Check size of array
        if(arr.length < 2)
            return -1;
        
        // Calculate the area of a square
        double area = arr[0] * arr[1];
        return area;
    }

    
    /*
     * Purpose: Calculates the perimeter of a rectangle.
     * Params : One double array containing width, height in that order.
     * Return : One double, denoting perimeter.
     */
    public static double calculatePerimeter(double[] arr){
        // Check the size of the array
        if(arr.length < 2)
            return -1;
        
        // Calculate the perimeter of the square
        double perim = arr[0] * 2 + arr[1] * 2;
        return perim;
    }
    
    
    /*
     * Purpose: Calculate the cost of the project.
     * Params : Two doubles, one denoting area, the other perimeter.
     * Return : One double, denoting the total cost.
     */
    public static double calculateCost(double area, double perimeter){
        // Create cost constants
        final double glassCost = 3.50;
        final double trimCost = 2.25;

        // Create total cost variable
        double totalCost = 0.0;
        
        // Calculate cost of materials
        totalCost += area * glassCost;
        totalCost += perimeter * trimCost;
        
        return totalCost;
    }
    
    
    /*
     * Purpose: To display the area, perimeter, cost of the project.
     * Params : Three doubles denoting, area, perimeter and cost.
     * Return : None.
     */
    public static void displayData(double area, double perimeter, double cost){
        System.out.println("A window of area: " + area);
        System.out.println("With a perimeter of: " + perimeter);
        System.out.println("Will cost: " + cost);
    }
        
    
    public static void main(String[] args) {
        topWindowMaster();
    }
}
