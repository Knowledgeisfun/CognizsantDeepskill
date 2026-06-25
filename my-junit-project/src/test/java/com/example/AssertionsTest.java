package test.java.com.example;

import org.junit.Test;
import static org.junit.Assert.*; 

public class AssertionsTest { 

    @Test 
    public void testAssertions() { 
        // 1. Assert equals: Checks if two values match perfectly
        assertEquals(5, 2 + 3); 
 
        // 2. Assert true: Checks if a boolean condition evaluates to true
        assertTrue(5 > 3); 
 
        // 3. Assert false: Checks if a boolean condition evaluates to false
        assertFalse(5 < 3); 
 
        // 4. Assert null: Checks if a variable is entirely empty/null
        assertNull(null); 
 
        // 5. Assert not null: Checks if an object actually exists in memory
        assertNotNull(new Object()); 
    } 
}
