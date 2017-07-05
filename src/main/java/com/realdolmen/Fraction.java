package com.realdolmen;


import jdk.nashorn.internal.ir.annotations.Immutable;

import java.lang.annotation.Target;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    public int denominator() {
        return denominator;
    }

    public int numerator() {
        return numerator;
    }
    @Override
    public String toString() {
        return "" + numerator + "/" + denominator;
    }

    private void simplify() {
        int factor = Utilities.greatestCommonFactor(numerator, denominator);
        numerator /= factor;
        denominator /= factor;
        if (denominator < 0) {
            numerator = numerator * -1;
            denominator = denominator * -1;
        }
    }

    public Fraction add(Fraction other) {
        return new Fraction((numerator * (other.denominator())+ this.denominator * (other.numerator())), denominator * other.denominator());
    }

    public Fraction min(Fraction other) {
        return new Fraction((numerator * (other.denominator())- this.denominator * (other.numerator())), denominator * other.denominator());

    }

    public Fraction multiply(Fraction other) {
        return new Fraction((numerator * (other.numerator())), denominator * other.denominator());
    }

    public Fraction divide(Fraction other) {
        return this.multiply(other.reciprocal());

    }

    public Fraction reciprocal() {
        return new Fraction(denominator, numerator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (numerator != fraction.numerator) return false;
        return denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }



    //private void als je method in enkel in class oproept.


}
