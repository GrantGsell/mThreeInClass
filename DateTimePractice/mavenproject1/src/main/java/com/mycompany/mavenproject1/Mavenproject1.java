package com.mycompany.mavenproject1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 *
 * @author Grant
 */
public class Mavenproject1 {

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
        // Prompt the user for their birthday
        String birthdayString = "01/01/2001";// prompt("What is your birthday? ");
        
        // Convert string to dateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate birthdayDate = LocalDate.parse(birthdayString, formatter);
        
        // Obtain day of the week for day born
        DayOfWeek dayBorn = birthdayDate.getDayOfWeek();
        
        // Create local date for birthday this year
        LocalDate birthdayThisYear = birthdayDate.withYear(LocalDate.now().getYear());
        
        // Obtain day of the week for this years birthday
        DayOfWeek dayThisYear = birthdayThisYear.getDayOfWeek();
        
        // Obtain days until next birthday
        long daysUntil = LocalDate.now().until(birthdayThisYear, ChronoUnit.DAYS);
        if(daysUntil < 0)
            daysUntil += 365;
        
        // Obtain years alive
        long yearsOld = birthdayDate.until(birthdayThisYear, ChronoUnit.YEARS);
        
        // Create output string
        String output = String.format("You were born on a %s\nThis year your"
                + " birthday will be on %s\nWith today being %s there are %d "
                + "days until your next birthday\nThis year you will be %d\n", 
                dayBorn, dayThisYear, LocalDate.now(), daysUntil, yearsOld);
        
        System.out.format(output);
    }
}
