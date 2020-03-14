package com.company.mawarees.Model.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Group implements Parcelable {

    private String groupName;

    private int boys_count;

    private int girls_count;

    private Fraction groupSharePercent;

    private String boys_relation;

    private String girls_relation;

    private String single_boy_relation;

    private String single_girl_relation;

    private Fraction boysLatestSharePercent;

    private Fraction girlsLatestSharePercent;

    private int originalDenominator;

    protected Group(Parcel in) {
        groupName = in.readString();
        boys_count = in.readInt();
        girls_count = in.readInt();
        groupSharePercent = in.readParcelable(Fraction.class.getClassLoader());
        boys_relation = in.readString();
        girls_relation = in.readString();
        single_boy_relation = in.readString();
        single_girl_relation = in.readString();
        boysLatestSharePercent = in.readParcelable(Fraction.class.getClassLoader());
        girlsLatestSharePercent = in.readParcelable(Fraction.class.getClassLoader());
        originalDenominator = in.readInt();
    }

    public Group() {
    }

    public static final Creator<Group> CREATOR = new Creator<Group>() {
        @Override
        public Group createFromParcel(Parcel in) {
            return new Group(in);
        }

        @Override
        public Group[] newArray(int size) {
            return new Group[size];
        }
    };

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getBoys_count() {
        return boys_count;
    }

    public void setBoys_count(int boys_count) {
        this.boys_count = boys_count;
    }

    public int getGirls_count() {
        return girls_count;
    }

    public void setGirls_count(int girls_count) {
        this.girls_count = girls_count;
    }

    public Fraction getGroupSharePercent() {
        return groupSharePercent;
    }

    public void setGroupSharePercent(Fraction groupSharePercent) {
        this.groupSharePercent = groupSharePercent;
    }

    public String getBoys_relation() {
        return boys_relation;
    }

    public void setBoys_relation(String boys_relation) {
        this.boys_relation = boys_relation;
    }

    public String getGirls_relation() {
        return girls_relation;
    }

    public void setGirls_relation(String girls_relation) {
        this.girls_relation = girls_relation;
    }

    public String getSingle_boy_relation() {
        return single_boy_relation;
    }

    public void setSingle_boy_relation(String single_boy_relation) {
        this.single_boy_relation = single_boy_relation;
    }

    public String getSingle_girl_relation() {
        return single_girl_relation;
    }

    public void setSingle_girl_relation(String single_girl_relation) {
        this.single_girl_relation = single_girl_relation;
    }

    public Fraction getBoysLatestSharePercent() {
        return boysLatestSharePercent;
    }

    public void setBoysLatestSharePercent(Fraction boysLatestSharePercent) {
        this.boysLatestSharePercent = boysLatestSharePercent;
    }

    public Fraction getGirlsLatestSharePercent() {
        return girlsLatestSharePercent;
    }

    public void setGirlsLatestSharePercent(Fraction girlsLatestSharePercent) {
        this.girlsLatestSharePercent = girlsLatestSharePercent;
    }

    public int getOriginalDenominator() {
        return originalDenominator;
    }

    public void setOriginalDenominator(int originalDenominator) {
        this.originalDenominator = originalDenominator;
    }

    @Override
    public int describeContents() {
        return Parcelable.CONTENTS_FILE_DESCRIPTOR;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(groupName);
        parcel.writeInt(boys_count);
        parcel.writeInt(girls_count);
        parcel.writeParcelable(groupSharePercent, i);
        parcel.writeString(boys_relation);
        parcel.writeString(girls_relation);
        parcel.writeString(single_boy_relation);
        parcel.writeString(single_girl_relation);
        parcel.writeParcelable(boysLatestSharePercent, i);
        parcel.writeParcelable(girlsLatestSharePercent, i);
        parcel.writeInt(originalDenominator);
    }
}
