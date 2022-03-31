package com.mycompany.inclass;

import java.util.Scanner;

/**
 *
 * @author Grant
 */
public class App {
    
    /*
     * Wrapper for the App class
     */
    public static void app(){
        // Create string for operation selection
        String selectOp = "\nWelcome!\nPlease select which operation you would "
                + "like to perform:\n0 - Addition\n1 - Subtraction\n2 - "
                + "Multiplication\n3 - Division\n4 - Exit the program.\n"
                + "Selection: ";
        
        // Create string for value input
        String inputVal0Str = "\nPlease enter the first operand value: ";
        String inputVal1Str = "\nPlease enter the second operand value: ";
        
        // Create array of operations to select from
        String[] possibleOperations = new String[]{"+", "-", "*", "/"};
        
        // Create variables to hold operand values, result
        double val0 = 0, val1 = 0, result = 0;
        
        // Execute the program at least once
        do{
            // Prompt the user for which operation to perform
            int operation = (int) prompt(selectOp);
            
            // Check operation for exit status
            if(operation == 4)
                System.exit(0);
            
            // Prompt and obtain the first value
            val0 = prompt(inputVal0Str);
            val1 = prompt(inputVal1Str);
            
            // Perform the operation
            result = performOp(val0, val1, operation);
            
            // Display output if exit not chosen
            System.out.format("\n%.2f %s %.2f = %.2f", val0, 
                    possibleOperations[operation], val1, result);
            
        }while(true);
        
    }
    
    
    
    /*
     * Selects, performs the given operation
     */
    public static double performOp(double firstVal, double secondVal, int op){
        double result;
        
        switch(op){
            case 0:
                result = SimpleCalculator.addition(firstVal, secondVal);
                break;   
            case 1:
                result = SimpleCalculator.subtraction(firstVal, secondVal);
                break;
            case 2:
                result = SimpleCalculator.multiply(firstVal, secondVal);
                break;
            case 3:
                result = SimpleCalculator.divide(firstVal, secondVal);
                break;
            default:
                result = -1;
        }
        
        return result;
    }
    
    
    /*
     * Prompts the user for input based on input text.
     */
    public static double prompt(String text){
        // Create a new scanner object, input variable
        Scanner scan = new Scanner(System.in);
        double input;
        
        // Continuously prompt user until the correct input is given
        while(true){
            // Prompt the user based on text variable
            try{
                System.out.print("\n" + text);
                input = scan.nextDouble();
                break;
            }catch(Exception e){
                System.out.println("\nERROR: Incorrect Input.");        
            }
        }
        return input;
    }
    
    public static void main(String []args){
        app();
    }
}
