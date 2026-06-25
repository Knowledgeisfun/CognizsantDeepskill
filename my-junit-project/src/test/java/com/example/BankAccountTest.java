package test.java.com.example;

import main.java.com.example.BankAccount;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BankAccountTest {

    private BankAccount account;

    // STEP 2: Setup Method
    // Runs automatically BEFORE every single @Test method
    @Before
    public void setUp() {
        // Initializes a fresh, predictable state for each test
        account = new BankAccount(100.0);
        System.out.println("Setup: Created new BankAccount with balance 100.0");
    }

    
    // Runs automatically AFTER every single @Test method
    @After
    public void tearDown() {
        // Cleans up resources (not strictly necessary for simple objects in Java due to GC, 
        // but crucial for closing database connections, files, or network sockets)
        account = null;
        System.out.println("Teardown: Cleaned up BankAccount instance\n");
    }

    // STEP 1: Write tests using the AAA pattern
    
    @Test
    public void testDepositMoney() {
        // ARRANGE: Set up the specific data needed for this test
        double depositAmount = 50.0;
        double expectedBalance = 150.0;

        // ACT: Execute the specific method we are testing
        account.deposit(depositAmount);

        // ASSERT: Verify that the action produced the expected result
        // Note: The third parameter (0.001) is the delta for comparing floating-point numbers
        assertEquals(expectedBalance, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawMoney() {
        // ARRANGE: Set up the specific data needed for this test
        double withdrawAmount = 30.0;
        double expectedBalance = 70.0;

        // ACT: Execute the specific method we are testing
        account.withdraw(withdrawAmount);

        // ASSERT: Verify that the action produced the expected result
        assertEquals(expectedBalance, account.getBalance(), 0.001);
    }
}
