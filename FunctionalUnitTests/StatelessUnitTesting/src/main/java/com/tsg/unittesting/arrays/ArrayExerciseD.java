/*********************************
* The Software Guild
* Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
*********************************/
package com.tsg.unittesting.arrays;

/**
 *
 * @author ahill
 */
public class ArrayExerciseD {
    
    /**
     * Given an array of doubles, return the biggest number of the lot, as if the decimal had gone missing!
     *
     * 
     * pointFree( [1.1, .22]  ) ->  22
     * pointFree( [ .039 , 20 , .005005 ]  ) ->  5005
     * pointFree( [ -9.9 , -700 , -.5  ]  ) ->  -5
     * 
     * @param numbers
     * @return
     */
    public static int pointFree(double[] numbers){
        // Create result variable
        int result = Integer.MIN_VALUE;
        
        // Iterate through numbers and find the max value
        for(double elem : numbers)
            if(result < convertNumber(elem))
                result = convertNumber(elem);
        
        return result;
    }
    
    public static int convertNumber(double val){
        // Result variable
        int result = 0;
        
        // Convert double to string
        String valString = Double.toString(val);
        
        // Convert String to string witout deciaml
        valString = valString.replace(".", "");
        
        // Convert string to integer
        result = Integer.parseInt(valString);
        
        return result;
    }
    
}
