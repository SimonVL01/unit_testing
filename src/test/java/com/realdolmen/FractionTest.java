package com.realdolmen;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class FractionTest {

    private Fraction testFrac;
    private Fraction testFrac2;

    @Before
    public void init() {
        testFrac = new Fraction(25, 5);
        testFrac2 = new Fraction(1, 2);
    }



    @Test
    public void shouldSimplify() {

       init();
        assertEquals(5, testFrac.numerator());
        assertEquals(1, testFrac.denominator());
    }
    @Test
    public void notSimplified() {
        assertEquals(1, testFrac2.numerator());
        assertEquals(2, testFrac2.denominator());
    }

    @Test
    public void shouldToString() {
        assertEquals("1/2", testFrac2.toString());
    }

    @Test
    public void isNotNull() {
        Fraction testFrac = new Fraction(1, 3);
        assertNotNull(testFrac);
    }

    @Test
    public void isAdded() {
        assertEquals(new Fraction(11,2), testFrac.add(testFrac2));
    }
}
