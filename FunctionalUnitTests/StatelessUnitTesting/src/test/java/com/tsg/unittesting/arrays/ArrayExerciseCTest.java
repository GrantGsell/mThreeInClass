/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.tsg.unittesting.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static com.tsg.unittesting.arrays.ArrayExerciseC.*;

/**
 *
 * @author Grant
 */
public class ArrayExerciseCTest {@Test
    public void testEmptyArray() {
        // Create test array
        int[] test = new int[]{};
        
        // Call the method and return the result
        String result = stringThemTogether(test);
        
        // Assert equals 
        assertEquals(result, "");
    }
    
    @Test
    public void testSingleElement(){
        // Create test array
        int[] test = new int[]{1};
        
        // Call the method and return the result
        String result = stringThemTogether(test);
        
        // Assert equals 
        assertEquals("1", result);
    }
    
    @Test
    public void testMultipleElements(){
        // Create test array
        int[] test = new int[]{1, 2, 3, 423, 12};
        
        // Call the method and return the result
        String result = stringThemTogether(test);
        
        // Assert equals 
        assertEquals(result, "12342312");
    }
    
    @Test 
    public void testNegativeValues(){
        // Create test array
        int[] test = new int[]{-1, 2, 3, -4};
        
        // Call the method and return the result
        String result = stringThemTogether(test);
        
        // Assert equals 
        assertEquals(result, "-123-4");
    }
    
}
