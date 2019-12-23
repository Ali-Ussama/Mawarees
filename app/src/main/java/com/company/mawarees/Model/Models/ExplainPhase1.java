package com.company.mawarees.Model.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class ExplainPhase1 implements Parcelable {

    private ArrayList<Person> people;

    public ExplainPhase1() {
    }

    public ExplainPhase1(Parcel in) {
        people = in.createTypedArrayList(Person.CREATOR);
    }


    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    public static final Creator<ExplainPhase1> CREATOR = new Creator<ExplainPhase1>() {
        @Override
        public ExplainPhase1 createFromParcel(Parcel in) {
            return new ExplainPhase1(in);
        }

        @Override
        public ExplainPhase1[] newArray(int size) {
            return new ExplainPhase1[size];
        }
    };

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
        return 0;
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
        dest.writeTypedList(people);
    }
}
