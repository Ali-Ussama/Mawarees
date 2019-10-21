package com.company.mawarees.Model.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Person implements Parcelable {

    private int id;

    private int count;

    private String relation;

    private String gender;

    private String blocked;

    private int problemOrigin;

    private Fraction sharePercent;

    private double shareValue;

    private int numberOfShares;

    private String explanation;

    private String forensicEvidence;

    private String videoUrl;

    private int deadSonNumber;

    private boolean alive;

    protected Person(Parcel in) {
        id = in.readInt();
        count = in.readInt();
        relation = in.readString();
        gender = in.readString();
        blocked = in.readString();
        problemOrigin = in.readInt();
        shareValue = in.readDouble();
        numberOfShares = in.readInt();
        explanation = in.readString();
        forensicEvidence = in.readString();
        videoUrl = in.readString();
        deadSonNumber = in.readInt();
        alive = in.readByte() != 0;
    }

    public Person() {
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public int getDeadSonNumber() {
        return deadSonNumber;
    }

    public void setDeadSonNumber(int deadSonNumber) {
        this.deadSonNumber = deadSonNumber;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBlocked() {
        return blocked;
    }

    public void setBlocked(String blocked) {
        this.blocked = blocked;
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


    public double getShareValue() {
        return shareValue;
    }

    public void setShareValue(double shareValue) {
        this.shareValue = shareValue;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(int numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getForensicEvidence() {
        return forensicEvidence;
    }

    public void setForensicEvidence(String forensicEvidence) {
        this.forensicEvidence = forensicEvidence;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(count);
        dest.writeString(relation);
        dest.writeString(gender);
        dest.writeString(blocked);
        dest.writeInt(problemOrigin);
        dest.writeDouble(shareValue);
        dest.writeInt(numberOfShares);
        dest.writeString(explanation);
        dest.writeString(forensicEvidence);
        dest.writeString(videoUrl);
        dest.writeInt(deadSonNumber);
        dest.writeByte((byte) (alive ? 1 : 0));
    }
}
