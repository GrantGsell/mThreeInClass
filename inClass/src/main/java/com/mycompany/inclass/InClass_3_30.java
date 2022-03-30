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
    public static void factorizer(){
        // Create map to hold factors, promt
        int input;
        HashSet<Integer> set =  new HashSet<Integer>();
        
        // Prompt the user for input
        input = prompt();
        
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
    
    
    public static int prompt(){
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
    
    
    public static void main(String[] args){
        factorizer();
    }
}
