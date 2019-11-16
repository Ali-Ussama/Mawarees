package com.company.mawarees.Model.Utilities;

import android.util.Log;

import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;

import java.util.ArrayList;

public class FatherUtils2 {

    private static final String TAG = "FatherUtils2";

    public static void calculateFather(ArrayList<Person> data, OConstants oConstants) {
        Log.i(TAG, "calculateFather(): is called");
        Log.i(TAG, "calculateFather(): ");

        if (oConstants.isHasFather()) {

            Log.i(TAG, "calculateFather(): has Father");

            if (oConstants.isHasChildren()) {
                Log.i(TAG, "calculateFather(): Has Children");

                // نصيب الام = 1/6
                // نصيب الاب = 1/6
                OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_FATHER);
                OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_MOTHER);

                OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER, ProofsAndExplanations.MotherProofs.ONE_SIX_WITH_CHILDREN_E, ProofsAndExplanations.MotherProofs.p1);
                OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER, ProofsAndExplanations.FatherProofs.ONE_SIX_WITH_CHILDREN_E, ProofsAndExplanations.FatherProofs.p1);

                Log.i(TAG, "calculateFather(): Father share = 1/6 ");
                Log.i(TAG, "calculateFather(): Mother share = 1/6 ");

            } else {
                Log.i(TAG, "calculateFather(): Has No Children");
                if (oConstants.isHasHusband() || oConstants.isHasWife() || oConstants.isHasMother_GrandMother() || oConstants.isHasMother_GrandFather()) {
                    Log.i(TAG, "calculateFather(): has Other Main People");

                    if (oConstants.isHasMother()) {
                        Log.i(TAG, "calculateFather(): has Mother");

                        //الباقي مناصفة بين الاب و الام بعد استيفاء اصحاب الفروض ( زوج / زوجه )
                        OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_FATHER);
                        OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_MOTHER);


                        OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER, ProofsAndExplanations.MotherProofs.FIFTY_FIFTY_WITH_FATHER_E, ProofsAndExplanations.MotherProofs.p1);
                        OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER, ProofsAndExplanations.FatherProofs.FIFTY_FIFTY_WITH_FATHER_E, ProofsAndExplanations.FatherProofs.p1);

                        Log.i(TAG, "calculateFather(): Father and mother takes the rest 50/50");

                    } else {
                        Log.i(TAG, "calculateFather(): has No Mother");
                        //نصيب الاب الباقي بعد استيفاء اصحاب الفروض
                        OConstants.setPersonSharePercent(data, OConstants.one, OConstants.PERSON_FATHER);
                        OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER, ProofsAndExplanations.FatherProofs.REST_E, ProofsAndExplanations.FatherProofs.p1);

                        Log.i(TAG, "calculateFather(): Father takes the rest");

                    }
                } else {
                    Log.i(TAG, "calculateFather(): has No Other Main People");
                    if (oConstants.isHasMother()) {
                        Log.i(TAG, "calculateFather(): has Mother");

                        // يوجد جمع اخوة
                        if (oConstants.isHasBrothersAndSisters() && OConstants.hasMoreThreeBrothersAndSisters(data)) {
                            Log.i(TAG, "calculateFather(): has  More Three Brothers And Sisters");

                            // نصيب الام = 1/6
                            // نصيب الاب = 5/6
                            OConstants.setPersonSharePercent(data, OConstants.fifth_Sixth, OConstants.PERSON_FATHER);
                            OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_MOTHER);

                            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER, ProofsAndExplanations.MotherProofs.ONE_SIX_WITH_NO_CHILDREN_E, ProofsAndExplanations.MotherProofs.p1);
                            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER, ProofsAndExplanations.FatherProofs.FIVE_SIX_WITH_NO_CHILDREN_E, ProofsAndExplanations.FatherProofs.p1);

                            Log.i(TAG, "calculateFather(): Mother Takes 1/6 & Father Takes 5/6");

                        } else {
                            Log.i(TAG, "calculateFather(): has No More Three Brothers And Sisters");


                            // نصيب الام = 1/3
                            // نصيب الاب = 2/3
                            OConstants.setPersonSharePercent(data, OConstants.two_Thirds, OConstants.PERSON_FATHER);
                            OConstants.setPersonSharePercent(data, OConstants.one_Third, OConstants.PERSON_MOTHER);

                            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER, ProofsAndExplanations.MotherProofs.ONE_THIRD_E, ProofsAndExplanations.MotherProofs.p1);
                            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER, ProofsAndExplanations.FatherProofs.TWO_THIRD_E, ProofsAndExplanations.FatherProofs.p1);

                            Log.i(TAG, "calculateFather(): Mother Takes 1/3 & Father Takes 2/3");

                        }
                    } else {
                        Log.i(TAG, "calculateFather(): has No Mother");
                        // TODO
                        //نصيب الاب كل التركة
                        OConstants.setPersonSharePercent(data, OConstants.one, OConstants.PERSON_FATHER);
                        OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER, ProofsAndExplanations.FatherProofs.REST_E, ProofsAndExplanations.FatherProofs.p1);
                        Log.i(TAG, "calculateFather(): Father Takes all");
                    }
                }
            }
        }
    }
}
