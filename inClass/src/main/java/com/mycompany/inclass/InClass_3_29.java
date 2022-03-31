/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.inclass;

/**
 *
 * @author Grant
 */
public class InClass_3_29 {
    // Problem 1
    public static void MethodToTheMadness(){
        eatMe();
        drinkMe();
        System.out.println("\n - Lewis Carroll, Alice in Wonderland");
    }
    static void eatMe(){
        System.out.println(" 'But I don’t want to go among mad people,' Alice remarked.");
        System.out.println(" 'Oh, you can’t help that,' said the Cat.");
        System.out.print(" 'We’re all mad here. I’m mad. You’re mad.'");
    }

    static void drinkMe(){
        System.out.println(" 'How do you know I’m mad?' said Alice.");
        System.out.println(" 'You must be,' said the Cat, 'or you wouldn’t have come here.' ");
    }
    
    /*
      Problem 3
    */
    public static void matchWork(){
        System.out.println(" The word Cart should come before Horse alphabetically : " + comesBefore("Horse", "Cart"));
        System.out.println(" Half of 42 = " + halfOf(42));
        System.out.println(" (short) Pi = " + pi());
        System.out.println(" The first letter of the word Llama is: " + firstLetter("Llama"));
        System.out.println(" 1337 x 1337 = " + times1337(1337));
    }
    
    public static double pi(){
        return 3.14;
    }

    public static int times1337(int x){
        return x * 1337;
    }

    public static double halfOf(double y){
        return y / 2;
    }

    public static String firstLetter(String word){
        return word.substring(0, 1);
    }

    public static boolean comesBefore(String a, String b){
        return a.compareToIgnoreCase(b) < 0;
    }
    
    public static void main(String[] args) {
        matchWork();
    }
}
