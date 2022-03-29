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
public class InClass_3_28 {
    public static void barelyControlledChaos(){
        // Create two lists, one for animals, one for colors
        String[] animals = new String[]{"Cat", "Dog", "Fish", "Bird", "Ant"};
        String[] colors = new String[]{"Red", "Green", "Blue", "Pink", "Green"};
        
        // Print out random animal, color, generate random integer
        System.out.println(getRandomFromArray(animals));
        System.out.println(getRandomFromArray(colors));
        System.out.println(getRandomInt(20));
        
    }
    
    public static String getRandomFromArray(String[] arr){
        // Obtain size of the input array
        int s = arr.length;
        
        // Generate random number between [1, s]
        int index = getRandomInt(s);
        
        // return value at given index
        return arr[index];
    }
    
    public static int getRandomInt(int hi){
        // Create random object
        Random rng = new Random();
        
        // Generate random int in range [lo, hi)
        int rand = rng.nextInt(hi);
        
        // Offset random number by 1 to generate a num in range [lo, hi]
        rand += 1;
        
        return rand;
    }
    
    
    public static void main(String []args){
        // Run the method 3 times
        barelyControlledChaos();
        barelyControlledChaos();
        barelyControlledChaos();
    }
}
