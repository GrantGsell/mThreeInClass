package com.mycompany.inclass;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.io.*;

/**
 *
 * @author Grant
 */
public class StateCapitals2 {
    // HashMap field
    public static Map<String, String> states = new HashMap<>();
    
    // Wrapper method for StateCapitals2
    public static void stateCapitals2() throws FileNotFoundException{
        // Populate the states hashmap
        populateHashMap();
        
        // Print out the number of states
        System.out.format("%d states & capitals have been loaded.", states.size());
        
        // Print out all of the states in alphabetical order
        String[] keys = keysInOrder(states);
        for(String key : keys){
            System.out.format("\n%s", key);
        }
        
        // Play the State capital guessing game
        playStateGame();
    }
    
    
    /*
     * Populate hashmap via local text file.
     */
    public static void populateHashMap() throws FileNotFoundException {
       Scanner scan = new Scanner(new BufferedReader(new FileReader("StateCapitals.txt")));
       
       // Go through the file line by line
       while(scan.hasNextLine()){
           // Obtian the current line
           String curr = scan.nextLine();
           
           // Split the string by the delimeter
           String[] stateData = curr.split("::", 2);
           
           // Write data to hashmap
           states.put(stateData[0], stateData[1]);
       }
       // Close the file scanner
       scan.close();
    }
    
    
    /*
     * Plays the state capital guessing game. The user is shown a state and has
     *   to guess the capital for that state.
     */
    public static void playStateGame(){
        // Create variable to hold point total, number of rounds
        int points = 0, rounds;
        
        // Create HashSet to hold already guesses states
        HashSet<String> seenStates = new HashSet<>(states.size());
        
        // Generate Array of state names
        String[] stateNames = states.keySet().toArray(new String[states.size()]);
        
        // Display knowledge test welcome message
        System.out.println("Welcome to the State Capital knowledge test! (Note: remember capitalization)");
        
        // Ask user for the number of rounds they want to play
        rounds = prompt("How rounds of this test would you like to play? ", 1, 50);
        
        // Execute the game for count number of turns
        while(rounds > 0){
            // Create temporary variable for user input, message
            String input, msg;
            
            // Create temporary variable for guess check
            boolean isCorrect;
            
            // Select a random state, not already in the hashmap
            String nextState = getRandomState(seenStates, stateNames);
            
            // Show user State, prompt for guess
            msg = String.format("\nWhat is the capital of %s: ", nextState);
            input = prompt(msg);
            
            // Compare user answer against map value
            isCorrect = input.equals(states.get(nextState));
            
            // Display correct/incorrect
            String disp = (isCorrect) ? "Correct!" : "Incorrect!";
            System.out.format("The capital of %s is %s, you guessed %s. That "
                    + "is: %s", nextState, states.get(nextState), input, disp);
            
            // Tally points
            points = (isCorrect) ? points + 1 : points - 1;
            
            // Decrement the number of rounds
            rounds--;
        }
        // Show final score of the game
        System.out.format("\nYou scored a total of %d points", points);
    }
    
    
    /*
     * Obtains a random sate from the states array that has not been seen yet.
     * 
     * @param seenStates, a map of states that have already been displayed.
     * @param stateArray, an array of all possible states
     * @return a string denoting the next state to be guessed.
     */
    public static String getRandomState(HashSet<String> seenStates, String[] stateArray){
        // Create variable for state result        
        String result = "";
        
        // Create variable for random number
        int rand;
        
        // Seen State size check for exhaustive
        if(seenStates.size() == 50)
            return result;
        
        while(result.equals("")){
            // Generate a random integer from 1 - 50
            rand = generateRandomInt(1, 50);
            
            // Extract state via index from stateArray
            String potentialState = stateArray[rand];
            
            // Check to see if the state has already been seen
            if(!seenStates.contains(potentialState)){
                seenStates.add(potentialState);
                result = potentialState;
            }
        }
        return result;
    }
    
    
    /*
     * Obtain all keys for a hashmap in order.
     * 
     * @param map, the map to pull the keys from.
     * @return a String array denoting all of the keys from the map, sorted.
     */
    public static String[] keysInOrder(Map<String, String> map){
        // Obtain the array of keys
        String[] keys = map.keySet().toArray(new String[map.size()]);
        
        // Sort the keys array
        Arrays.sort(keys);
        
        return keys;
    }
    
    
    /*
     * Prompts the user for input based on the input text.
     * 
     * @param a String to promt the user for data
     * @return a String denoting the user input
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
    
    /*
     * Prompts the user for an integer based on the text parameter, and ensures
     *   that the provided number is within a valid range.
     * 
     * @param text, A string that will be displayed to the user.
     * @param lower, the lower bound of the possible range of user inputs.
     * @param upper, the upper bound of the possible range of user inputs.
     * @return an int denoting the user input that is in the given range.
     */
    public static int prompt(String text, int lower, int upper){
        // Create a new scanner object, input variable
        Scanner scan = new Scanner(System.in);
        int input;
        
        while(true){
            // Prompt the user based on text variable
            try{
                System.out.print("\n" + text);
                input = scan.nextInt();
                
                // Check if input is within range, if not throw exception
                if(input >= lower && input <= upper)
                    return input;
                
                // Error message, repromt
                System.out.println("Input out of bounds, please try again.");
            }catch(Exception e){
                System.out.println("\nERROR: Incorrect Input.");
                return -1;
            }
        }
    }
    
    /*
     * Generates a random integer in the inclusive range [lo, hi]
     *
     * @param lo, the lower bound for the inclusive range.
     * @param hi, the upper bound for the inclusive range.
     * @reutrn an int denoting a random value within the range [lo, hi]
     */
    public static int generateRandomInt(int lo, int hi){
        // Create a random object, seed based on computer time
        Random rand = new Random(System.currentTimeMillis());
        
        // Generate a random number between [0, hi - lo + 1]
        int number = rand.nextInt(hi - lo + 1);
        
        // Offset the random number by lo to change range to [lo, hi]
        number += lo;
        
        return number;
    }
    
    
    
    public static void main(String[] args){
        try{
            stateCapitals2();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

