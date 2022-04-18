package com.mycompany.inclass;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 *
 * @author Grant
 */
public class InterestCalculatorUsingBigDecimal {
    public static void interestCalculator(){
        // Prompt user for values
        BigDecimal[] initial = promptInterest();
        
        // Print out results on a yearly basis
        
        for(int i = 0; i < initial[2].intValue(); i++){
            // Obtain yearly results
            BigDecimal[] yearly = calculations(initial);
            
            // Print out yearly values
            System.out.print("\n\nYear " + (i + 1) + ":");
            System.out.format("\nBegan with: $" + initial[1].setScale(2, RoundingMode.HALF_UP));
            System.out.format("\nEarned: $" + yearly[0].setScale(2, RoundingMode.HALF_UP));
            System.out.format("\nEnded with: $" + yearly[1].setScale(2, RoundingMode.HALF_UP));
            
            // Re-assign inital values
            initial[1] = yearly[1];
        }
        
    }
    
    
    public static BigDecimal[] promptInterest(){
        // Create a scanner object to read in user input
        Scanner scan = new Scanner(System.in);
        
        // Create array to hold user input
        BigDecimal[] input = new BigDecimal[3];
        
        // Continuously prompt user until the correct input is provided
        while(true){
            try{
                System.out.print("What is the annual interest rate: ");
                input[0] = scan.nextBigDecimal();
                System.out.print("\nWhat is the principal ammout: ");
                input[1] = scan.nextBigDecimal();
                System.out.print("\nHow many years will this money stay in the fund: ");
                input[2] = scan.nextBigDecimal();
                break;
            }catch(Exception e){
                System.out.print("\nINPUT ERROR!");
            }
        }
        
        // return array containing inputs
        return input;
    }
    
    
    
    public static BigDecimal[] calculations(BigDecimal[] arr){
        // Create variable to hold earned ammout, ending ammount
        BigDecimal earned = new BigDecimal("0");
        BigDecimal ammount = arr[1];
        
        // Create array to hold results
        BigDecimal[] results = new BigDecimal[2];
               
        // Calculate the ending ammount over four quarters
        BigDecimal qRate = arr[0].divide(new BigDecimal("4"));
        for(int i = 0; i < 4; i++){
            BigDecimal one = new BigDecimal("1");
            BigDecimal oneHundred = new BigDecimal("100");
            BigDecimal inner = qRate.divide(oneHundred);
            BigDecimal innerPlusOne = inner.add(one);
            ammount = ammount.multiply(innerPlusOne);
        }
        
        // Subtract inital from ending to obtain earned
        BigDecimal principalBD = arr[1];
        earned = ammount.subtract(principalBD);
        
        // Set array values
        results[0] = earned;
        results[1] = ammount;
        
        return results;
    }
    
    public static void main(String[] args){
        interestCalculator();
    }
}
