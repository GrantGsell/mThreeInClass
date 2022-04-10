/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tsg.unittesting.arrays;
import static com.tsg.unittesting.arrays.ArrayExerciseB.multiplyAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Grant
 */
public class ArrayExerciesBTest {
        
    
    @Test
    public void test0(){
        // Create array 
        int[] testArr = {1000, 1, 234123, 3214231, 45 ,-123, 0};
        
        // Test the array against a multiplier of 0
        int[] result = multiplyAll(0, testArr);
        
        // Assert equals zero
        assertArrayEquals(result, new int[]{0, 0, 0, 0, 0, 0, 0});
    }    
    
    @Test
    public void testNegative1(){
        // Create array 
        int[] testArr = {1234231, 123423, -123423, 0, -1, 123412};
        
        // Test array against a multiplier of -1
        int[] result = multiplyAll(-1, testArr);
        
        // Set result array
        int[] expectedResult = {-1234231, -123423, 123423, 0, 1, -123412};
        
        // Asser equals expected
        assertArrayEquals(result, expectedResult);
    }
    
    
}
