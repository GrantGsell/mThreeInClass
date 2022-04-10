package com.mycompany.enumpractice;

import java.util.Scanner;

/**
 *
 * @author Grant
 */
public class EnumPractice {
    // ENUMS
    public enum DaysOfTheWeek{
         SATURDAY, SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY;
    }
    
    public enum MathOperator {
        PLUS, MINUS, MULTIPLY, DIVIDE;
        
        @Override
        public String toString(){
            switch(this){
                case PLUS:
                    return "+";
                case MINUS:
                    return "-";
                case MULTIPLY:
                    return "*";
                case DIVIDE:
                    return "/";
                default: return "ERROR";
            }
        }
    }

    
    // Exercise 1: How Many Days Until Friday
    public void daysUntilFriday(){
        DaysOfTheWeek dayEnum;
        while(true){
            try{
                // Prompt the user for the current day of the week
                String userInput = prompt("What is the current day of the week? ");
                
                // Convert input to enum
                dayEnum = DaysOfTheWeek.valueOf(userInput.toUpperCase());
                break;
            } catch(IllegalArgumentException e){
                System.out.println("Incorrect Day of the week. Please try again.");
            }
        }
        
        int daysLeft =  DaysOfTheWeek.FRIDAY.ordinal() - dayEnum.ordinal();
        System.out.format("There are %d days left until Friday!\n", daysLeft);
    }
    
        
    // Exercise 2: Math Operators
    public void mathOperations(){
        // Prompt the user for two integers
        int val0 = Integer.parseInt(prompt("Please enter the first integer: "));
        int val1 = 0;
        while(val1 == 0){           
            val1 = Integer.parseInt(prompt("Please enter the second integer (non zero): "));
        }
        // Perform the calcualtions and output results
        for(MathOperator op : MathOperator.values())
            System.out.format("%d %s %d = %d\n", val0, op, val1, calculate(op, val0, val1));
    }
    
    public int calculate(MathOperator operator, int operand1, int operand2) {
        switch(operator) {
            case PLUS:
                return operand1 + operand2;
            case MINUS:
                return operand1 - operand2;
            case MULTIPLY:
                return operand1 * operand2;
            case DIVIDE:
                return operand1 / operand2;
            default:
                throw new UnsupportedOperationException();     
        }
    }
    
    /*
     * Prompts the user for input based on the input text.
     */
    public static String prompt(String text){
        // Create a new scanner object, input variable
        Scanner scan = new Scanner(System.in);
        String input;
        
        // Continuously prompt user until the correct input is given
        while(true){
            // Prompt the user based on text variable
            try{
                System.out.print("\n" + text);
                input = scan.nextLine();
                break;
            }catch(Exception e){
                System.out.println("\nERROR: Incorrect Input.");        
            }
        }
        return input;
    }
    
    
        
    public static void main(String[] args) {
        EnumPractice test  = new EnumPractice();
        test.daysUntilFriday();
        System.out.println("======================================");
        test.mathOperations();
    }
}
