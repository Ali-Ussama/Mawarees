package com.company.mawarees.Model.Models;

public class Fraction {

    private int numerator; // البسط
    private int denominator; // المقام

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public static Fraction divideFraction(Fraction f1, Fraction f2) {
        f1.setNumerator(f1.getNumerator() * f2.getDenominator());
        f1.setDenominator(f1.getDenominator() * f2.getNumerator());

        return f1;
    }

    public static Fraction multiplyFraction(Fraction f1, Fraction f2) {
        f1.setNumerator(f1.getNumerator() * f2.getNumerator());
        f1.setDenominator(f1.getDenominator() * f2.getDenominator());

        return f1;
    }

    public static Fraction addFractions(Fraction f1, Fraction f2) {
            f1.setNumerator(f1.getNumerator() + f2.getNumerator());
        return f1;
    }
}
