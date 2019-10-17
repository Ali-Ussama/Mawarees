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
                    OConstants.setPersonSharePercent(data, OConstants.one_eighth, OConstants.PERSON_WIFE); // نصيب الزوجة 1/8
                    Log.i(TAG, "CalculateHusbandAndWife(): setting wife with 1/8");
                } else {

                    // لا يوجد زوجة
                    Log.i(TAG, "CalculateHusbandAndWife(): No Wives");

                }

            } else { //المتوفي انثى

                // يوجد زوج
                if (oConstants.isHasHusband()) {

                    OConstants.setPersonSharePercent(data, OConstants.quarter, OConstants.PERSON_HUSBAND); // نصيب الزوج 1/4

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
                    OConstants.setPersonSharePercent(data, OConstants.quarter, OConstants.PERSON_WIFE);
                    Log.i(TAG, "CalculateHusbandAndWife(): setting wife with 1/4");

                } else {

                    // لا يوجد زوجة
                    Log.i(TAG, "CalculateHusbandAndWife(): No Wives");

                }

            } else { //المتوفي انثى

                // يوجد زوج
                if (oConstants.isHasHusband()) {

                    OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_HUSBAND);// نصيب الزوج 1/2

                } else {

                    // لا يوجد زوج
                    Log.i(TAG, "CalculateHusbandAndWife(): No Husband");

                }
            }
        }
    }
}
