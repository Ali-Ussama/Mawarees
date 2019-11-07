package com.company.mawarees.Model.Utilities;

import android.util.Log;

import com.company.mawarees.Model.Models.Fraction;
import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;

import java.util.ArrayList;

public class ChildrenUtils {



    private static final String TAG = "ChildrenUtils";

    public static void calculateChildren(ArrayList<Person> data, OConstants oConstants) {


        //يوجد فرع وارث
        if (oConstants.isHasChildren()) {

            Log.i(TAG, "calculateChildren(): has children");

            int daughters = OConstants.getChildrenInDaughters(data);

            if (daughters == 1) {
                Log.i(TAG, "calculateChildren(): has 1 daughter");

                // نصيب البنت 1/2
                OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_DAUGHTER); // نصيب البنت
                OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_DAUGHTER, ProofsAndExplanations.DaughterProofs.E1, ProofsAndExplanations.DaughterProofs.p1);

            } else if (daughters == 2) {

                Log.i(TAG, "calculateChildren(): has 2 daughters");

                // نصيب البنتن = 14/24
                // نصيب البنت = نصيب البنتين/2 = 14/48
                if (OConstants.getDaughtersCount(data) == 2) {

                    Log.i(TAG, "calculateChildren(): has 2 daughters");

                    OConstants.setPersonSharePercent(data, OConstants.seventh_TwentyFourth, OConstants.PERSON_DAUGHTER); // نصيب البنتين = 14/24
                    OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_DAUGHTER, ProofsAndExplanations.DaughterProofs.E1, ProofsAndExplanations.DaughterProofs.p1);

                } else if (OConstants.getSonsCount(data) == 1) {
                    Log.i(TAG, "calculateChildren(): has 1 son");

                    OConstants.setPersonSharePercent(data, OConstants.fourteenth_TwentyFourth, OConstants.PERSON_SON); // نصيب الولد = 14/24
                    OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_SON, ProofsAndExplanations.SonProofs.E1, ProofsAndExplanations.SonProofs.p1);

                }
            } else if (daughters > 2) {
                Log.i(TAG, "calculateChildren(): has >= 3 daughters");


                // نصيب البنات = 2/3
                // نصيب البنت = نصيب البنت / عدد البنات
                // نصيب الولد = نصيب البنت * 2
               OConstants.setPersonSharePercent(data, OConstants.two_Thirds, OConstants.PERSON_SON); // نصيب الولد
                OConstants.setPersonSharePercent(data, OConstants.two_Thirds, OConstants.PERSON_DAUGHTER); // نصيب البنت

                OConstants.setPersonSharePercent(data, OConstants.two_Thirds, OConstants.PERSON_More_Than_three_DAUGHTERS); //نصيب البنات = 2/3

                OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_DAUGHTER, ProofsAndExplanations.DaughterProofs.E1, ProofsAndExplanations.DaughterProofs.p1);
                OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_SON, ProofsAndExplanations.SonProofs.E1, ProofsAndExplanations.SonProofs.p1);
            }
        } else {
            Log.i(TAG, "calculateChildren(): has No children");
        }
    }
}
