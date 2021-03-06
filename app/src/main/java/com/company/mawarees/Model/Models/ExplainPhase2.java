package com.company.mawarees.Model.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class ExplainPhase2 implements Parcelable {

    private Fraction totalFractionsSum;
    private ArrayList<Person> people;
    private final int contentDescriptor = 3;

    public ExplainPhase2() {
    }

    public ExplainPhase2(Parcel in) {
        totalFractionsSum = in.readParcelable(Fraction.class.getClassLoader());
        people = in.createTypedArrayList(Person.CREATOR);
    }

    public static final Creator<ExplainPhase2> CREATOR = new Creator<ExplainPhase2>() {
        @Override
        public ExplainPhase2 createFromParcel(Parcel in) {
            return new ExplainPhase2(in);
        }

        @Override
        public ExplainPhase2[] newArray(int size) {
            return new ExplainPhase2[size];
        }
    };

    public Fraction getTotalFractionsSum() {
        return totalFractionsSum;
    }

    public void setTotalFractionsSum(Fraction totalFractionsSum) {
        this.totalFractionsSum = totalFractionsSum;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     */
    @Override
    public int describeContents() {
        return Parcelable.CONTENTS_FILE_DESCRIPTOR;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(totalFractionsSum, flags);
        dest.writeTypedList(people);
    }
}
