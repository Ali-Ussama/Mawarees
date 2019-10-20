package com.company.mawarees.Model.Models;

public class Person {

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

}
