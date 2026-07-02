package com.example; // Make sure it says exactly thisimport main.java.com.example.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        int result = calculator.add(5, 3);
        Assert.assertEquals(8, result);
    }

    @Test
    public void testSubtract() {
        int result = calculator.sub(5, 3);
        Assert.assertEquals(2, result);
    }
}