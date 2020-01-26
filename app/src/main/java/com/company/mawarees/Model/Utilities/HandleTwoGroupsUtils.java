package com.company.mawarees.Model.Utilities;

import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;

import java.util.ArrayList;

public class HandleTwoGroupsUtils {

    public static int getGroupSavedNumber(ArrayList<Person> data, Person group, String boysRelation, String girlsRelation) {

        int savedNumber = 0;
        try {

            int heads = OConstants.getPersonsInGirlsCount(data, boysRelation, girlsRelation);
            int shares = group.getNumberOfShares();

            if (OConstants.findGCD(shares, heads) == 1 || OConstants.findGCD(shares, heads) == 2) {
                savedNumber = heads;
            } else {
                savedNumber = OConstants.findGCD(heads, shares);
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
