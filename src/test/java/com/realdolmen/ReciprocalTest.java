package com.realdolmen;


import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

@RunWith(Theories.class)
public class ReciprocalTest {
    private Fraction a, b;

    public ReciprocalTest(Fraction a, Fraction b) {
        this.a = a;
        this.b = b;
    }

    @DataPoints
    public static Fraction[] fractions = {
            new Fraction(5, 25),
            new Fraction(1, 5),
            new Fraction(4, 8),
            new Fraction(6, 8),
            new Fraction(5, 10)
    };
    @Theory
    public void shouldReverse(Fraction a) {
        assumeTrue((a.numerator()!=0) && (a.denominator()!=0));
        assertTrue(a.reciprocal().equals(new Fraction(a.denominator(), a.numerator())));
    }
}
