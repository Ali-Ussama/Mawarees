package com.company.mawarees.Model.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class Fraction implements Parcelable {

    private static final String TAG = "Fraction";

    private int numerator; // البسط
    private int denominator; // المقام

    public Fraction() {
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    protected Fraction(Parcel in) {
        numerator = in.readInt();
        denominator = in.readInt();
    }

    public static final Creator<Fraction> CREATOR = new Creator<Fraction>() {
        @Override
        public Fraction createFromParcel(Parcel in) {
            return new Fraction(in);
        }

        @Override
        public Fraction[] newArray(int size) {
            return new Fraction[size];
        }
    };

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

        Log.i(TAG, "divideFraction(): f1 = " + f1.getNumerator() + "/" + f1.getDenominator());
        Log.i(TAG, "divideFraction(): f2 = " + f2.getNumerator() + "/" + f2.getDenominator());

        Fraction mFraction = new Fraction(0, 0);
        mFraction.setNumerator(f1.getNumerator() / f2.getDenominator());
        mFraction.setDenominator(f1.getDenominator());

        Log.i(TAG, "divideFraction(): mFraction = " + mFraction.getNumerator() + "/" + mFraction.getDenominator());

        return mFraction;
    }

    public static Fraction multiplyFraction(Fraction f1, Fraction f2) {
        f1.setNumerator(f1.getNumerator() * f2.getNumerator());
        f1.setDenominator(f1.getDenominator() * f2.getDenominator());

        return f1;
    }

    public static void subtractFractions(Fraction f1, Fraction f2) {
        Log.i(TAG, "addFractions(): f1 = " + f1.getNumerator() + "/" + f1.getDenominator());
        Log.i(TAG, "addFractions(): f2 = " + f2.getNumerator() + "/" + f2.getDenominator());

        f1.setNumerator((f1.getNumerator() * -1) + f2.getNumerator());
    }

    public static void addFractions(Fraction f1, Fraction f2) {
        Log.i(TAG, "addFractions(): f1 = " + f1.getNumerator() + "/" + f1.getDenominator());
        Log.i(TAG, "addFractions(): f2 = " + f2.getNumerator() + "/" + f2.getDenominator());

        f1.setNumerator(f1.getNumerator() + f2.getNumerator());
    }

    public static Fraction finalCalculationDivideFraction(Fraction f1, Fraction f2) {
        Log.i(TAG, "finalCalculationDivideFraction(): f1 = " + f1.getNumerator() + "/" + f1.getDenominator());
        Log.i(TAG, "finalCalculationDivideFraction(): f2 = " + f2.getNumerator() + "/" + f2.getDenominator());

        f1.setDenominator(f2.getNumerator());
        return f1;
    }

    @Override
    public int describeContents() {
        return Parcelable.CONTENTS_FILE_DESCRIPTOR;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(numerator);
        parcel.writeInt(denominator);
    }

    public static boolean isEqual(Fraction f1, Fraction f2) {

        return (f1.getNumerator() == f2.getNumerator() && f1.getDenominator() == f2.getDenominator());

    }
}
