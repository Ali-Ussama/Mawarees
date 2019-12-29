package com.company.mawarees.Model.Models;

public class Group {

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
}
