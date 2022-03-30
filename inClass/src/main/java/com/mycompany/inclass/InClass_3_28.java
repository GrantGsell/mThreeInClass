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
        
        String color =  getRandomFromArray(colors);// call color method here
        String animal = getRandomFromArray(animals); // call animal method again here
        String colorAgain = getRandomFromArray(colors); // call color method again here
        
        
        int weight = getRandomInt(5, 200); // call number method,
            // with a range between 5 - 200
        int distance = getRandomInt(10, 20); // call number method,
            // with a range between 10 - 20
        int number = getRandomInt(10000, 20000); // call number method,
            // with a range between 10000 - 20000
        int time = getRandomInt(2, 6); // call number method,
            // with a range between 2 - 6
            
         System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
            + weight + "lb " + " miniature " + animal
            + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over "
            + number + " " + colorAgain + " poppies for nearly "
            + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, "
            + "let me tell you!");
        
    }
    
    /*
     *
     */
    public static String getRandomFromArray(String[] arr){
        // Obtain size of the input array
        int s = arr.length;
        
        // Generate random number between [0, s)
        int index = getRandomInt(s) - 1;
        
        // return value at given index
        return arr[index];
    }
    
    
    /*
     *
     */
    public static int getRandomInt(int hi){
        // Create random object
        Random rng = new Random();
        
        // Generate random int in range [lo, hi)
        int rand = rng.nextInt(hi);
        
        // Offset random number by 1 to generate a num in range [lo, hi]
        rand += 1;
        
        return rand;
    }
    
    
    /*
     *
     */
    public static int getRandomInt(int lo, int hi){
        // Create random object
        Random rng = new Random();
        
        // Generate random int in range [lo, hi)
        int rand = rng.nextInt(hi) + lo;
        
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
