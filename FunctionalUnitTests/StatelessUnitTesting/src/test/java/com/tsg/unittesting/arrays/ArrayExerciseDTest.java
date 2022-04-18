/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.tsg.unittesting.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static com.tsg.unittesting.arrays.ArrayExerciseD.pointFree;

/**
 *
 * @author Grant
 */
public class ArrayExerciseDTest {
        
    @Test
    public void testNoElements() {
        // Create test array, answer variable
        double[] test = new double[]{};
        int expected = Integer.MIN_VALUE;
        
        // Call method and store results
        int result = pointFree(test);
        
        // Assert equals 
        assertEquals(result, expected);
    }
    
    @Test
    public void testNoDecimals(){
        // Create test array, answer variable
        double[] test = new double[]{123, 123234, 5232, 0};
        int expected = 1232340;
        
        // Call method and store results
        int result = pointFree(test);
        
        // Assert equals 
        assertEquals(result, expected);
    }
    
    @Test
    public void testLeadingZeros(){
        // Create test array, answer variable
        double[] test = new double[]{1.1, 23.342, 0.500001};
        int expected = 500001;
        
        // Call method and store results
        int result = pointFree(test);
        
        // Assert equals 
        assertEquals(result, expected);
    }
    
    @Test
    public void testSameNumberDifferentDeciaml(){
        // Create test array, answer variable
        double[] test = new double[]{1.01, 00.101, .101, 00010.1};
        int expected = 101;
        
        // Call method and store results
        int result = pointFree(test);
        
        // Assert equals 
        assertEquals(result, expected);
    }
    
    @Test
    public void testNegativeNumbers(){
        // Create test array, answer variable
        double[] test = new double[]{-1.23, -0.65618, -0.001};
        int expected = -1;
        
        // Call method and store results
        int result = pointFree(test);
        
        // Assert equals 
        assertEquals(result, expected);
    }
}
