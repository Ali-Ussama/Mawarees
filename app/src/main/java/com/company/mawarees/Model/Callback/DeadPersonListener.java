package com.company.mawarees.Model.Callback;

import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;

import java.util.ArrayList;

public interface DeadPersonListener {
    void addChildListener(ArrayList<Person> children, String relation, int deadChildNumber,int id);

}
