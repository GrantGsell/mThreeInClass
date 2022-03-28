/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inclass;
import java.util.*;
/**
 *
 * @author Grant
 */
public class InClass_3_25 {
    
    public static void miniMadLibs(){
        // Create scanner object
        Scanner input = new Scanner(System.in);
        
        // Create variables to hold user input
        String noun0, adj0, noun1, num0, adj1, pNoun0, pNoun1, pNoun2, pNoun3, 
                verb0, verb1;
        
        // Read in the user input
        noun0 = userInput("I need a noun: ", input);
        
        // Display the output
                
    }
    
    public static String userInput(String msg, Scanner scan){
        // Variable for user input, return value
        String input;
        
        while(true){
            try{
                System.out.print("\n" + msg);
                input = scan.nextLine();
                break;
            }catch(Exception e){
                System.out.println("Input ERROR!");
            }
        }
        return input;
    }
    
    
    
    public static void bestAdderEver(){
        // Create scanner object
        Scanner input = new Scanner(System.in);
        
        // Declare 3 variables to hold input, and one for sum
        int val0, val1, val2, total;
        
        // Prompt the user for the 3 numbers
        while(true){
            try{
                System.out.print("Please enter the first number: ");
                val0 = input.nextInt();
                System.out.print("\nPlease enter the first number: ");
                val1 = input.nextInt();
                System.out.print("\nPlease enter the first number: ");
                val2 = input.nextInt();                
                break;
            }catch(Exception e){
                System.out.println("Input ERROR");
            }
        }
        
        // Calculate the sum of the three variables
        total = val0 + val1 + val2;
        
        // Display the math formulat for the sumation
        System.out.print("\n" + val0 + " + " + val1 + " + " + val2 + " + " + " = " + total);
    }
    
    public static void main(String []args){
        bestAdderEver();
    }
}
