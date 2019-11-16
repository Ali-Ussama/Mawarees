package com.company.mawarees.Model.Utilities;

import android.util.Log;

import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;

import java.util.ArrayList;

public class MotherUtils2 {

    private static final String TAG = "MotherUtils";

    public static void calculateMother(ArrayList<Person> data, OConstants oConstants) {
        Log.i(TAG, "calculateMother(): is called");
        Log.i(TAG, "calculateMother(): ");

        if (oConstants.isHasMother()) {

            Log.i(TAG, "calculateMother(): has Father");

            if (oConstants.isHasChildren()) {
                Log.i(TAG, "calculateMother(): Has Children");

                // نصيب الام = 1/6
                // نصيب الاب = 1/6
                OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_FATHER);
                OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_MOTHER);

                OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER, ProofsAndExplanations.MotherProofs.ONE_SIX_WITH_CHILDREN_E, ProofsAndExplanations.MotherProofs.p1);
                OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER, ProofsAndExplanations.FatherProofs.ONE_SIX_WITH_CHILDREN_E, ProofsAndExplanations.FatherProofs.p1);

                Log.i(TAG, "calculateMother(): Father share = 1/6 ");
                Log.i(TAG, "calculateMother(): Mother share = 1/6 ");

            } else {
                Log.i(TAG, "calculateMother(): Has No Children");
                if (oConstants.isHasHusband() || oConstants.isHasWife() || oConstants.isHasFather_GrandMother() || oConstants.isHasFather_GrandFather()) {
                    Log.i(TAG, "calculateMother(): has Other Main People");

                    if (oConstants.isHasFather()) {
                        Log.i(TAG, "calculateMother(): has Father");

                        //الباقي مناصفة بين الاب و الام بعد استيفاء اصحاب الفروض ( زوج / زوجه )
                        OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_FATHER);
                        OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_MOTHER);


                        OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER, ProofsAndExplanations.MotherProofs.FIFTY_FIFTY_WITH_FATHER_E, ProofsAndExplanations.MotherProofs.p1);
                        OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER, ProofsAndExplanations.FatherProofs.FIFTY_FIFTY_WITH_FATHER_E, ProofsAndExplanations.FatherProofs.p1);

                        Log.i(TAG, "calculateMother(): Father and mother takes the rest 50/50");

                    } else {
                        Log.i(TAG, "calculateMother(): has No Father");
                        //نصيب الام الباقي بعد استيفاء اصحاب الفروض
                        OConstants.setPersonSharePercent(data, OConstants.one, OConstants.PERSON_MOTHER);
                        OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER, ProofsAndExplanations.MotherProofs.REST_E, ProofsAndExplanations.MotherProofs.p1);

                        Log.i(TAG, "calculateFather(): Mother takes the rest");

                    }
                } else {
                    Log.i(TAG, "calculateMother(): has No Other Main People");
                    if (oConstants.isHasFather()) {
                        Log.i(TAG, "calculateMother(): has Father");

                        // يوجد جمع اخوة
                        if (oConstants.isHasBrothersAndSisters() && OConstants.hasMoreThreeBrothersAndSisters(data)) {
                            Log.i(TAG, "calculateFather(): has  More Three Brothers And Sisters");

                            // نصيب الام = 1/6
                            // نصيب الاب = 5/6
                            OConstants.setPersonSharePercent(data, OConstants.fifth_Sixth, OConstants.PERSON_FATHER);
                            OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_MOTHER);

                            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER, ProofsAndExplanations.MotherProofs.ONE_SIX_WITH_NO_CHILDREN_E, ProofsAndExplanations.MotherProofs.p1);
                            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER, ProofsAndExplanations.FatherProofs.FIVE_SIX_WITH_NO_CHILDREN_E, ProofsAndExplanations.FatherProofs.p1);

                            Log.i(TAG, "calculateMother(): Mother Takes 1/6 & Father Takes 5/6");

                        } else {
                            Log.i(TAG, "calculateMother(): has No More Three Brothers And Sisters");


                            // نصيب الام = 1/3
                            // نصيب الاب = 2/3
                            OConstants.setPersonSharePercent(data, OConstants.two_Thirds, OConstants.PERSON_FATHER);
                            OConstants.setPersonSharePercent(data, OConstants.one_Third, OConstants.PERSON_MOTHER);

                            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER, ProofsAndExplanations.MotherProofs.ONE_THIRD_E, ProofsAndExplanations.MotherProofs.p1);
                            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER, ProofsAndExplanations.FatherProofs.TWO_THIRD_E, ProofsAndExplanations.FatherProofs.p1);

                            Log.i(TAG, "calculateMother(): Mother Takes 1/3 & Father Takes 2/3");

                        }
                    } else {
                        Log.i(TAG, "calculateMother(): has No Mother");
                        // TODO
                        //نصيب الام كل التركة
                        OConstants.setPersonSharePercent(data, OConstants.one, OConstants.PERSON_MOTHER);
                        OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER, ProofsAndExplanations.MotherProofs.REST_E, ProofsAndExplanations.MotherProofs.p1);
                        Log.i(TAG, "calculateFather(): Mother Takes all");
                    }
                }
            }
        }
    }
}
