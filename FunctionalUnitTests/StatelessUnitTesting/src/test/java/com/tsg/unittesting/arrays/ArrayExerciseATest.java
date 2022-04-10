package com.tsg.unittesting.arrays;
import static com.tsg.unittesting.arrays.ArrayExerciseA.maxOfArray;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Grant
 */
public class ArrayExerciseATest {
    /* Test Plans:
    ** 
    ** Normal Array Tests:
    ** maxOfArray([0]) -> 0
    ** maxOfArray([-1, -2, -3]) -> -1
    ** maxOfArray([-1, 0, 1]) -> 1
    ** maxOfArray([-1, Integer.MAX_VALUE, 1000]) -> Integer.MAX_VALUE
    **
    */
    
    @Test
    public void testSingleElementArray(){
        // Create testing array
        int[] testArr = new int[]{0};
        
        // Call the function and store the result
        int result = maxOfArray(testArr);
        
        // Assert Equals 0
        assertEquals(result, 0);
    }
    
    @Test
    public void testAllNegativeElementsArray(){
        // Create testing array
        int[] testArr = new int[]{-1, -2, -3};
        
        // Call the function and store the result
        int result = maxOfArray(testArr);
        
        // Assert Equals -1
        assertEquals(result, -1);
    }
    
    @Test
    public void testMixedElementArray(){
        // Create testing array
        int[] testArr = new int[]{-1, 0, 1};
        
        // Call the function and store the result
        int result = maxOfArray(testArr);
        
        // Assert Equals 1
        assertEquals(result, 1);
    }
    
    @Test
    public void testMaxIntegerValueArray(){
        // Create testing array
        int[] testArr = new int[]{0, -1, -111, 1000000, Integer.MAX_VALUE};
        
        // Call the function and store the result
        int result = maxOfArray(testArr);
        
        // Assert Equals Integer.MAX_VALUE
        assertEquals(result, Integer.MAX_VALUE);
    }
}
