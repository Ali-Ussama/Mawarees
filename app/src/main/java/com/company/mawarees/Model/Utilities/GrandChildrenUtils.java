package com.company.mawarees.Model.Utilities;

import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;

import java.util.ArrayList;

public class GrandChildrenUtils {

    private static ArrayList<Person> people;
    private static OConstants oConstants;

    public static void handleGrandChildren(ArrayList<Person> mPeople, OConstants mOConstants) {
        people = mPeople;
        oConstants = mOConstants;

        handleDeadSonsChildren();

        handleDeadDaughtersChildren();

    }

    private static void handleDeadSonsChildren() {
        try {
            int deadSonsCount = oConstants.getDeadSonCount();
            for (int i = 1; i < (deadSonsCount + 1); i++) {
                try {
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleDeadDaughtersChildren() {
        try {
            int deadDaughtersCount = oConstants.getDeadDaughterCount();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
