package com.mycompany.inclass;
import java.util.*;
/**
 *
 * @author Grant
 */
public class StateCapitals {
    // HashMap field
    public static Map<String, String> states = new HashMap<>();
      
    // Populate hashmap
    public static void populate(){
        states.put("Pennsylvania", "Philadelphia");
        states.put("New Jersey", "Trenton");
        states.put("Delaware", "Dover");
        states.put("Virginia", "Richmond");
        states.put("New York", "Albany");
        states.put("Maryland", "Annapolis");
    }
    
    
    // Obtain all keys for a hashmap in order
    public static String[] keysInOrder(Map<String, String> map){
        // Obtain the array of keys
        String[] keys = map.keySet().toArray(new String[map.size()]);
        
        // Sort the keys array
        Arrays.sort(keys);
        
        return keys;
    }
    
    
    // Obtain all keys for a hashmap in order
    public static String[] valsInOrder(Map<String, String> map){
        // Obtain the array of keys
        String[] valArr = map.values().toArray(new String[map.size()]);
        
        // Sort the keys array
        Arrays.sort(valArr);
        
        return valArr;
    }
    
    
    public static void main(String[] args){
        // Populate the hashmap
        populate();
        
        // Obtain an array of all keys in order
        String[] keys = keysInOrder(states);
        
        // Obtain an array of all values in order
        String[] vals = valsInOrder(states);
        
        
        // Print keys
        System.out.print("\nStates\n==================\n");
        for(String elem : keys){
            System.out.println(elem);
        }
        System.out.print("=====================\n");
        
        
        // Print values
        System.out.print("\nCapitals\n==================\n");
        for(String elem : vals){
            System.out.println(elem);
        }
        System.out.print("=====================\n");
        
        
        // Print State capital pairs in order
        System.out.print("\nStates and Capitals\n==================");
        for(String elem : keys){
            // Get associated values
            String capital = states.get(elem);
            System.out.format("\n%s - %s", elem, capital);
        }
        System.out.print("\n=====================\n");
        
    }
}
