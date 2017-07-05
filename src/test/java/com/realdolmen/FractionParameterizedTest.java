package com.realdolmen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class FractionParameterizedTest {
    private Fraction a, b, expected, expectedMin, expectedMul, expectedDiv;

    public FractionParameterizedTest(Fraction a, Fraction b, Fraction expected, Fraction expectedMin, Fraction expectedMul, Fraction expectedDiv) {
        this.a = a;
        this.b = b;
        this.expected = expected;
        this.expectedMin = expectedMin;
        this.expectedMul = expectedMul;
        this.expectedDiv = expectedDiv;
    }

    @Parameters (name = "addFractions{0}, {1}, {2}, {3}")
    public static Collection<Fraction[]> parameters() {
        return Arrays.asList(new Fraction[][] {
                {
                new Fraction(1, 3),
                new Fraction(1, 3),
                new Fraction(2, 3),
                new Fraction(0, 9),
                new Fraction(1, 9),
                new Fraction(1, 1)
                },
                {
                new Fraction(1, 2),
                new Fraction(1, 2),
                new Fraction(1, 1),
                new Fraction(0, 4),
                new Fraction(1, 4),
                new Fraction(1, 1)
                },
                {
                new Fraction(-1, 2),
                new Fraction(-1, 2),
                new Fraction(-1, 1),
                new Fraction(0, -4),
                new Fraction(1, 4),
                new Fraction(1, 1)

                }
        });
    }



    @Test
    public void shouldAdd() {
        assertEquals(this.expected, (this.a.add(this.b)));
    }

    @Test
    public void shouldSubstr() {
        assertEquals(this.expectedMin, (this.a.min(this.b)));
    }

    @Test
    public void shouldMultiply() {
        assertEquals(this.expectedMul, this.a.multiply(this.b));
    }

    @Test
    public void shouldDivide() {
        assertEquals(this.expectedDiv, this.a.divide(this.b));
    }
}
