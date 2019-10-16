package com.company.mawarees.Model.Utilities;

import android.util.Log;

import com.company.mawarees.Model.Models.Fraction;
import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;

import java.util.ArrayList;

public class HusbandAndWifeUtilis {

    private static final String TAG = "HusbandAndWifeUtilis";

    public static void calculateHusbandAndWife(ArrayList<Person> data, OConstants oConstants) {

        // يوجد فرع وارث
        if (oConstants.isHasChildren()) {
            //المتوفي ذكر
            if (oConstants.getGender().matches(OConstants.GENDER_MALE)) {

                //يوجد زوجة
                if (oConstants.isHasWife()) {
                    data = setWifeSharePercent(data, OConstants.one_eighth); // نصيب الزوجة 1/8
                    Log.i(TAG, "CalculateHusbandAndWife(): setting wife with 1/8");
                } else {

                    // لا يوجد زوجة
                    Log.i(TAG, "CalculateHusbandAndWife(): No Wives");

                }

            } else { //المتوفي انثى

                // يوجد زوج
                if (oConstants.isHasHusband()) {

                    data = setHusbandSharePercent(data, OConstants.quarter); // نصيب الزوج 1/4
                    Log.i(TAG, "CalculateHusbandAndWife(): setting husband with 1/4");

                } else {

                    // لا يوجد زوج
                    Log.i(TAG, "CalculateHusbandAndWife(): No Husband");

                }
            }
        } else { // لا يوجد فرع وارث

            //المتوفي ذكر
            if (oConstants.getGender().matches(OConstants.GENDER_MALE)) {

                //يوجد زوجة
                if (oConstants.isHasWife()) {

                    // نصيب الزوجة 1/4
                    data = setWifeSharePercent(data, OConstants.quarter);
                    Log.i(TAG, "CalculateHusbandAndWife(): setting wife with 1/4");

                } else {

                    // لا يوجد زوجة
                    Log.i(TAG, "CalculateHusbandAndWife(): No Wives");

                }

            } else { //المتوفي انثى

                // يوجد زوج
                if (oConstants.isHasHusband()) {

                    data = setHusbandSharePercent(data, OConstants.half);// نصيب الزوج 1/2

                } else {

                    // لا يوجد زوج
                    Log.i(TAG, "CalculateHusbandAndWife(): No Husband");

                }
            }
        }
    }

    private static ArrayList<Person> setWifeSharePercent(ArrayList<Person> data, Fraction fraction) {

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getRelation().matches(OConstants.PERSON_WIFE)) {
                data.get(i).setSharePercent(fraction);
            }
        }

        return data;
    }

    private static ArrayList<Person> setHusbandSharePercent(ArrayList<Person> data, Fraction fraction) {

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getRelation().matches(OConstants.PERSON_HUSBAND)) {
                data.get(i).setSharePercent(fraction);
                break;
            }
        }

        return data;
    }
}
