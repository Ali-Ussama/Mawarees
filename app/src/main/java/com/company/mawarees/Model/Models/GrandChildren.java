package com.company.mawarees.Model.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class GrandChildren implements Parcelable {

    private int id;

    private ArrayList<Person> children;

    private int boysCount;

    private int girlsCount;

    private String relation;

    private int problemOrigin;

    private Fraction sharePercent;

    private Fraction eachPersonSharePercent;

    private Fraction originalSharePercent;

    private double shareValue;

    private double eachPersonShareValue;

    private int numberOfShares;

    private int eachPersonNumberOfShares;

    private String explanation;

    private String proof;

    private String videoUrl;

    private int deadSonNumber;

    private boolean group;

    public GrandChildren() {
    }

    public GrandChildren(Parcel in) {
        id = in.readInt();
        children = in.createTypedArrayList(Person.CREATOR);
        boysCount = in.readInt();
        girlsCount = in.readInt();
        relation = in.readString();
        problemOrigin = in.readInt();
        sharePercent = in.readParcelable(Fraction.class.getClassLoader());
        eachPersonSharePercent = in.readParcelable(Fraction.class.getClassLoader());
        originalSharePercent = in.readParcelable(Fraction.class.getClassLoader());
        shareValue = in.readDouble();
        eachPersonShareValue = in.readDouble();
        numberOfShares = in.readInt();
        eachPersonNumberOfShares = in.readInt();
        explanation = in.readString();
        proof = in.readString();
        videoUrl = in.readString();
        deadSonNumber = in.readInt();
        group = in.readByte() != 0;
    }

    public static final Creator<GrandChildren> CREATOR = new Creator<GrandChildren>() {
        @Override
        public GrandChildren createFromParcel(Parcel in) {
            return new GrandChildren(in);
        }

        @Override
        public GrandChildren[] newArray(int size) {
            return new GrandChildren[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Person> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Person> children) {
        this.children = children;
    }

    public int getBoysCount() {
        return boysCount;
    }

    public void setBoysCount(int boysCount) {
        this.boysCount = boysCount;
    }

    public int getGirlsCount() {
        return girlsCount;
    }

    public void setGirlsCount(int girlsCount) {
        this.girlsCount = girlsCount;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public int getProblemOrigin() {
        return problemOrigin;
    }

    public void setProblemOrigin(int problemOrigin) {
        this.problemOrigin = problemOrigin;
    }

    public Fraction getSharePercent() {
        return sharePercent;
    }

    public void setSharePercent(Fraction sharePercent) {
        this.sharePercent = sharePercent;
    }

    public Fraction getEachPersonSharePercent() {
        return eachPersonSharePercent;
    }

    public void setEachPersonSharePercent(Fraction eachPersonSharePercent) {
        this.eachPersonSharePercent = eachPersonSharePercent;
    }

    public Fraction getOriginalSharePercent() {
        return originalSharePercent;
    }

    public void setOriginalSharePercent(Fraction originalSharePercent) {
        this.originalSharePercent = originalSharePercent;
    }

    public double getShareValue() {
        return shareValue;
    }

    public void setShareValue(double shareValue) {
        this.shareValue = shareValue;
    }

    public double getEachPersonShareValue() {
        return eachPersonShareValue;
    }

    public void setEachPersonShareValue(double eachPersonShareValue) {
        this.eachPersonShareValue = eachPersonShareValue;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(int numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    public int getEachPersonNumberOfShares() {
        return eachPersonNumberOfShares;
    }

    public void setEachPersonNumberOfShares(int eachPersonNumberOfShares) {
        this.eachPersonNumberOfShares = eachPersonNumberOfShares;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getProof() {
        return proof;
    }

    public void setProof(String proof) {
        this.proof = proof;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public int getDeadSonNumber() {
        return deadSonNumber;
    }

    public void setDeadSonNumber(int deadSonNumber) {
        this.deadSonNumber = deadSonNumber;
    }

    public boolean isGroup() {
        return group;
    }

    public void setGroup(boolean group) {
        this.group = group;
    }

    @Override
    public int describeContents() {
        return Parcelable.CONTENTS_FILE_DESCRIPTOR;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeTypedList(children);
        dest.writeInt(boysCount);
        dest.writeInt(girlsCount);
        dest.writeString(relation);
        dest.writeInt(problemOrigin);
        dest.writeParcelable(sharePercent, flags);
        dest.writeParcelable(eachPersonSharePercent, flags);
        dest.writeParcelable(originalSharePercent, flags);
        dest.writeDouble(shareValue);
        dest.writeDouble(eachPersonShareValue);
        dest.writeInt(numberOfShares);
        dest.writeInt(eachPersonNumberOfShares);
        dest.writeString(explanation);
        dest.writeString(proof);
        dest.writeString(videoUrl);
        dest.writeInt(deadSonNumber);
        dest.writeByte((byte) (group ? 1 : 0));
    }
}
