package com.mycompany.inclass;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.*;
/**
 *
 * @author Grant
 */
public class InClass_3_30 {
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public static void factorizer(){
        // Create map to hold factors, promt
        int input;
        HashSet<Integer> set =  new HashSet<Integer>();
        
        // Prompt the user for input
        input = promptFactorizer();
        
        // Obtain all factors
        set = factors(input);
        
        // Print the results
        printResults(set, input);
    }
    
    
    //
    public static HashSet<Integer> factors(int num){
        // Create a results set
        HashSet<Integer> results = new HashSet<>();
        
        // Iterate through all numbers up to num / 2
        for(int i = 1; i <= num / 2; i++){
            if(num % i == 0){
                results.add(i);
                results.add(num / i);
            }
        }
        
        return results;
    }
    
    
    public static boolean isPerfect(HashSet<Integer> set, int target){
        // Create a variable to hold the sum
        int sum = target * -1;
        
        // Use a foreach loop to add all numbers
        for(int elem : set){
            sum += elem;
        }
        
        // Check to see if sum is equal to the target
        return sum == target;
    }
    
    public static boolean isPrime(HashSet<Integer> set, int target){
        // Initial size check for validity
        if(set.size() > 2)
            return false;
        
        // Check the two numbrs in the set
        return set.contains(1) && set.contains(target);
    }
    
    
    public static int promptFactorizer(){
        // Create a scanner object
        Scanner scan = new Scanner(System.in);
        
        // Create variable to hold input
        int input;
        
        // Continuously prompt user until input is valid
        while(true){
            try{
                // Propmt the user for an integer
                System.out.print("Please enter an interger value: ");
                input = scan.nextInt();
                break;
            }catch(Exception e){
                System.out.println("INPUT ERROR!");
            }
        }
        
        return input;        
    }
    
    
    public static void printResults(HashSet<Integer> set, int target){
        // Print out the original number
        System.out.print("\nGiven the number: " + target);
        
        // Print the factors of the target number
        System.out.print("\nIt has a total of " + set.size()+ " factors which "
                + "are: \n");
        
        for(int elem : set){
            if(elem != target)
                System.out.print(elem + "\n");
        }
        
        // Print if target is a perfect number
        String perfectStatus = isPerfect(set, target) ? " is " : " is not ";
        System.out.print( target + perfectStatus + "a perfect number.\n");
        
        // Print if target is a prime number
        String primeStatus = isPrime(set, target) ? " is " : " is not ";
        System.out.print(target + primeStatus + "a prime number.\n");
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public static void interestCalculator(){
        // Prompt user for values
        double[] initial = promptInterest();
        
        // Print out results on a yearly basis
        for(int i = 0; i < initial[2]; i++){
            // Obtain yearly results
            double[] yearly = calculations(initial);
            
            // Print out yearly values
            System.out.print("\n\nYear " + (i + 1) + ":");
            System.out.format("\nBegan with: $%.2f", initial[1]);
            System.out.format("\nEarned: $%.2f", yearly[0]);
            System.out.format("\nEnded with: $%.2f",yearly[1]);
            
            // Re-assign inital values
            initial[1] = yearly[1];
        }
        
    }
    
    
    public static double[] promptInterest(){
        // Create a scanner object to read in user input
        Scanner scan = new Scanner(System.in);
        
        // Create array to hold user input
        double[] input = new double[3];
        
        // Continuously prompt user until the correct input is provided
        while(true){
            try{
                System.out.print("What is the annual interest rate: ");
                input[0] = scan.nextDouble();
                System.out.print("\nWhat is the principal ammout: ");
                input[1] = scan.nextDouble();
                System.out.print("\nHow many years will this money stay in the fund: ");
                input[2] = scan.nextDouble();
                break;
            }catch(Exception e){
                System.out.print("\nINPUT ERROR!");
            }
        }
        
        // return array containing inputs
        return input;
    }
    
    
    
    public static double[] calculations(double[] arr){
        // Create variable to hold earned ammout, ending ammount
        double earned = 0, ammount = arr[1];
        
        // Create array to hold results
        double[] results = new double[2];
               
        // Calculate the ending ammount over four quarters
        double qRate = arr[0] / 4;
        for(int i = 0; i < 4; i++){
            ammount = ammount * (1 + (qRate / 100));
        }
        
        // Subtract inital from ending to obtain earned
        earned = ammount - arr[1];
        
        // Set array values
        results[0] = earned;
        results[1] = ammount;
        
        return results;
    }
    
    
    //
    
    
    
    
    
    
    public static void main(String[] args){
        interestCalculator();
        //factorizer();
    }
}
