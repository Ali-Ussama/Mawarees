package com.company.mawarees.Model.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class ExplainPhase4 implements Parcelable {

    private ArrayList<Person> people;

    public ExplainPhase4(Parcel in) {
        people = in.createTypedArrayList(Person.CREATOR);
    }

    public ExplainPhase4() {
    }

    public static final Creator<ExplainPhase4> CREATOR = new Creator<ExplainPhase4>() {
        @Override
        public ExplainPhase4 createFromParcel(Parcel in) {
            return new ExplainPhase4(in);
        }

        @Override
        public ExplainPhase4[] newArray(int size) {
            return new ExplainPhase4[size];
        }
    };

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(people);
    }

}
