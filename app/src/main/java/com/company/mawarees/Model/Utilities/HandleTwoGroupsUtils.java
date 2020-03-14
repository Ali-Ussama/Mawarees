package com.company.mawarees.Model.Utilities;

import android.util.Log;

import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;

import java.util.ArrayList;

public class HandleTwoGroupsUtils {

    private static final String TAG = "HandleTwoGroupsUtils";

    public static int getGroupSavedNumber(ArrayList<Person> data, Person group, String boysRelation, String girlsRelation) {

        int savedNumber = 0;
        int heads = 0;
        try {
            if ((boysRelation.matches(OConstants.PERSON_FATHER_UNCLE) || girlsRelation.matches(OConstants.PERSON_FATHER_AUNT)) ||
                    (boysRelation.matches(OConstants.PERSON_MOTHER_UNCLE) || girlsRelation.matches(OConstants.PERSON_MOTHER_AUNT))) {
                Log.i(TAG, "getGroupSavedNumber(): (1) boys = " + boysRelation + " girls = " + girlsRelation);
                heads = (OConstants.getPersonCount(data, boysRelation) + OConstants.getPersonCount(data, girlsRelation));

            } else {
                Log.i(TAG, "getGroupSavedNumber(): (2) boys = " + boysRelation + " girls = " + girlsRelation);
                heads = (OConstants.getPersonsInGirlsCount(data, boysRelation, girlsRelation));
            }

            int shares = group.getNumberOfShares();

            if (OConstants.findGCD(shares, heads) == 1/* || OConstants.findGCD(shares, heads) == 2*/) {
                savedNumber = heads;
            } else {
                savedNumber = (heads / OConstants.findGCD(heads, shares));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return savedNumber;
    }


    public static int getGrandChildrenGroupSavedNumber(ArrayList<Person> data, Person group, String boysRelation, String girlsRelation) {

        int savedNumber = 0;
        int heads = 0;
        try {

            Log.i(TAG, "getGrandChildrenGroupSavedNumber(): (2) boys = " + boysRelation + " girls = " + girlsRelation);
            heads = group.getGirlsCount() + (group.getBoysCount() * 2);

            int shares = group.getSharePercent().getNumerator();

            if (OConstants.findGCD(shares, heads) == 1/* || OConstants.findGCD(shares, heads) == 2*/) {
                savedNumber = heads;
                Log.i(TAG, "getGrandChildrenGroupSavedNumber: OConstants.findGCD(" + shares + ", " + heads + ") = " + OConstants.findGCD(shares, heads) +
                        "saved Number = " + savedNumber);
            } else {
                savedNumber = (heads / OConstants.findGCD(heads, shares));
                Log.i(TAG, "getGrandChildrenGroupSavedNumber: OConstants.findGCD(" + shares + ", " + heads + ") = " + OConstants.findGCD(shares, heads) +
                        "saved Number = " + savedNumber);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return savedNumber;
    }

    public static int getSimpleCommonMultiplier(int number1, int number2) {
        return number1 * number2;
    }

    public static int getNewNumberOfShares(int simpleCommonMultiplier, int oldNumberOfShares) {
        return simpleCommonMultiplier * oldNumberOfShares;
    }

}
