package com.company.mawarees.Model.Models;

import java.util.ArrayList;

public class DeadPersonModel {

    private ArrayList<Person> mSons;

    private ArrayList<Person> mDaughters;

    public DeadPersonModel() {
    }

    public ArrayList<Person> getmSons() {
        return mSons;
    }

    public void setmSons(ArrayList<Person> mSons) {
        this.mSons = mSons;
    }

    public ArrayList<Person> getmDaughters() {
        return mDaughters;
    }

    public void setmDaughters(ArrayList<Person> mDaughters) {
        this.mDaughters = mDaughters;
    }
}
