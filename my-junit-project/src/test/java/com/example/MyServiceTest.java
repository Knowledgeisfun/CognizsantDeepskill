package com.example; // Make sure it says exactly this

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class MyServiceTest { 
    
    @Test 
    public void testExternalApi() { 
        // STEP 1: Create a mock object for the external API.
        ExternalApi mockApi  = mock(ExternalApi.class); 
        
        // STEP 2: Stub the methods to return predefined values.
        when(mockApi.getData()).thenReturn("Mock Data"); 
        
        // Setup the service with the mock
        MyService service = new MyService(mockApi); 
        
        // STEP 3: Write a test case that uses the mock object.
        String result = service.fetchData(); 
        
        // Assert the outcome
        assertEquals("Mock Data", result); 
    }
}