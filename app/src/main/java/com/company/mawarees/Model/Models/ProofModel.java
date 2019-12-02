package com.company.mawarees.Model.Models;

public class ProofModel {


    private String id;

    private String relation;

    private String religion;

    private String key;

    private String value;

    public ProofModel() {
    }

    public ProofModel(String id, String relation, String religion, String key, String value) {
        this.id = id;
        this.relation = relation;
        this.religion = religion;
        this.key = key;
        this.value = value;
    }

    public ProofModel(String relation, String religion, String key, String value) {
        this.relation = relation;
        this.religion = religion;
        this.key = key;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
