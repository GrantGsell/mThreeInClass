package com.mycompany.inclass;
import java.util.*;
import java.io.*;
/**
 *
 * @author Grant
 */
public class StateCapitalsApp {
    // HashMap field <State, Capital object>
    public static HashMap<String, Capital> stateMap;
    
    
    /*
     *
     */
    public void stateCapitalsApp(){
        // Initialize HashMap
        stateMap = new HashMap<>();
        
        // Read in State Capitals data from text file
        populate(stateMap);
        
        // Print out the number state/capital data entries were read
        System.out.format("\nThere were %d states/capital successfully read!", 
                stateMap.size());
        
        // Print out the data 
        printData(stateMap);
        
    }
    
    /*
     * Populates the state map with data from text file
     * 
     * @param map, a map whose key is a string, value is an object.
     */
    public void populate(HashMap<String, Capital> map){
        // Create variables to hold state data
        String stateName, capitalName;
        int population;
        double sqMileage;
        
        try{
            // Create a new scanner object to read from the file
            Scanner scan = new Scanner(new BufferedReader(new FileReader("MoreStateCapitals.txt")));
            
            // Go through the file line by line
            while(scan.hasNextLine()){
                // Extract the current line
                String curr = scan.nextLine();
                
                // Split the data based on the delimeters
                String[] currData = curr.split("::", 4);
                
                // Extract the states name, capital name
                stateName = currData[0];
                capitalName = currData[1];
                
                // Extract, convert population data
                population = Integer.parseInt(currData[2]);
                
                // Extract, convert square milage data
                sqMileage = Double.parseDouble(currData[3]);
                
                // Create a new Capital object with extracted data
                Capital currCapital = new Capital(capitalName, population, sqMileage);
                
                // Store the state name with its associated object in the map
                map.put(stateName, currCapital);
            }
            // Close the scanner object to prevent data leaks
            scan.close();
            
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    
    
    /*
     *
     */
    public void printData(HashMap<String, Capital> map){
        // Create array variable to hold map keys
        String[] sortedStates;
                
        // Create variables for Capital object(capital name , population, size)
        String capitalName;
        int population;
        double capitalSize;
        
        
        // Extract the keys
        sortedStates = map.keySet().toArray(new String[map.size()]);
        
        // Sort keys
        Arrays.sort(sortedStates);
        
        // Create a string format variable for output
        String msg = "\n%s\'s capital is %s which has a population of %d and a footprint of %.2f square miles.";
        
        // Print out each data entry
        for(String state : sortedStates){
            // Extract the object from the map based on the state name
            Capital capData = map.get(state);
            
            // Set capital variables
            capitalName = capData.name;
            population = capData.population;
            capitalSize = capData.squareMilage;
            
            // Print out the display message
            System.out.format(msg, state, capitalName, population, capitalSize);
        }
    }
    
    
    /*
     * Prompts the user for input based on the input text.
     * 
     * @param a String to promt the user for data
     * @return a String denoting the user input
     */
    public static int prompt(String text){
        // Create a new scanner object, input variable
        Scanner scan = new Scanner(System.in);
        int input;
        
        // Continuously prompt user until the correct input is given
        while(true){
            // Prompt the user based on text variable
            try{
                System.out.print("\n" + text);
                input = scan.nextInt();
                break;
            }catch(Exception e){
                System.out.println("\nERROR: Incorrect Input.");        
            }
        }
        return input;
    }
    
    
    // Main method, point of entry into java class
    public static void main(String[] args){
        // Create new object
        StateCapitalsApp app = new StateCapitalsApp();
        
        // Run top level method
        app.stateCapitalsApp();
    }
}
