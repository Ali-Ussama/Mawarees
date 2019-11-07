package com.company.mawarees.Model.Utilities;

import android.util.Log;

import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;

import java.util.ArrayList;


public class FatherUtils {
    private static final String TAG = "FatherUtils";

    public static void calculateFather(ArrayList<Person> data, OConstants oConstants) {

        //توجد اب
        if (oConstants.isHasFather()) {
            Log.i(TAG, "calculateFather(): has Father");

            // يوجد فرع وارث
            if (oConstants.isHasChildren()) {
                Log.i(TAG, "calculateFather(): has Children");

                // نصيب الام = 1/6
                // نصيب الاب = 1/6
                OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_FATHER);
                OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_MOTHER);

                OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER, ProofsAndExplanations.MotherProofs.ONE_SIX_WITH_CHILDREN_E, ProofsAndExplanations.MotherProofs.p1);
                OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER, ProofsAndExplanations.FatherProofs.ONE_SIX_WITH_CHILDREN_E, ProofsAndExplanations.FatherProofs.p1);

                Log.i(TAG, "calculateFather(): Father share = 1/6 ");
                Log.i(TAG, "calculateFather(): Mother share = 1/6 ");

            } else { // لا يوجد فرع وارث

                // يوجد ام
                if (oConstants.isHasMother()) {

                    Log.i(TAG, "calculateFather(): has No Children");

                    //TODO
                    //الباقي مناصفة بين الاب و الام بعد استيفاء اصحاب الفروض ( زوج / زوجه )
                    OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_FATHER);
                    OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_MOTHER);


                    OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER, ProofsAndExplanations.MotherProofs.FIFTY_FIFTY_WITH_FATHER_E, ProofsAndExplanations.MotherProofs.p1);
                    OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER, ProofsAndExplanations.FatherProofs.FIFTY_FIFTY_WITH_FATHER_E, ProofsAndExplanations.FatherProofs.p1);

                    Log.i(TAG, "calculateFather(): Father and mother takes the rest 50/50");

                } else { // لا يوجد ام
                    Log.i(TAG, "calculateFather(): has No Mother");


                    // يوجد جدود لام
                    if (oConstants.isHasMother_GrandFather() || oConstants.isHasMother_GrandMother()) {

                        Log.i(TAG, "calculateFather(): has Mother_GrandPa Or Mother_GrandMa");
                        if (oConstants.isHasMother_GrandFather() && !oConstants.isHasMother_GrandMother()) {
                            Log.i(TAG, "calculateFather(): has Mother_GrandPa And Not Mother_GrandMa");

                            OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_MOTHER_GRANDFATHER); // نصيب جد لأم = 1/6

                            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER_GRANDFATHER, ProofsAndExplanations.MotherGrandPaOrGrandMaProofs.WITH_CHILDREN, ProofsAndExplanations.MotherGrandPaOrGrandMaProofs.p1);


                            Log.i(TAG, "calculateFather(): Mother_GrandPa Takes 1/6");

                        } else if (!oConstants.isHasMother_GrandFather() && oConstants.isHasMother_GrandMother()) {
                            Log.i(TAG, "calculateFather(): has Mother_GrandMa And Not Mother_GrandPa");

                            OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_MOTHER_GRANDMOTHER);// نصيب جدة لأم = 1/6
                            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER_GRANDMOTHER, ProofsAndExplanations.MotherGrandPaOrGrandMaProofs.WITH_CHILDREN, ProofsAndExplanations.MotherGrandPaOrGrandMaProofs.p1);

                            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER_GRANDMOTHER, ProofsAndExplanations.MotherGrandPaOrGrandMaProofs.WITH_CHILDREN, ProofsAndExplanations.MotherGrandPaOrGrandMaProofs.p1);
                            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER_GRANDFATHER, ProofsAndExplanations.MotherGrandPaOrGrandMaProofs.WITH_CHILDREN, ProofsAndExplanations.MotherGrandPaOrGrandMaProofs.p1);

                            Log.i(TAG, "calculateFather(): Mother_GrandMa Takes 1/6");

                        } else {
                            Log.i(TAG, "calculateFather(): has Mother_GrandMa And Mother_GrandPa");

                            //TODO Share Person should be calculated as one person
                            OConstants.setPersonSharePercent(data, OConstants.one_Twelve, OConstants.PERSON_MOTHER_GRANDFATHER);
                            OConstants.setPersonSharePercent(data, OConstants.one_Twelve, OConstants.PERSON_MOTHER_GRANDMOTHER);

                            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER_GRANDMOTHER, ProofsAndExplanations.MotherGrandPaOrGrandMaProofs.WITH_CHILDREN, ProofsAndExplanations.MotherGrandPaOrGrandMaProofs.p1);
                            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER_GRANDFATHER, ProofsAndExplanations.MotherGrandPaOrGrandMaProofs.WITH_CHILDREN, ProofsAndExplanations.MotherGrandPaOrGrandMaProofs.p1);

                        }
                        // TODO
                        //نصيب الاب الباقي بعد استيفاء اصحاب الفروض
                        OConstants.setPersonSharePercent(data, OConstants.one, OConstants.PERSON_FATHER);
                        OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER, ProofsAndExplanations.FatherProofs.REST_E, ProofsAndExplanations.FatherProofs.p1);

                        Log.i(TAG, "calculateFather(): Father takes the rest");

                    } else {
                        // لا يوجد جدود لام
                        Log.i(TAG, "calculateFather(): has No Mother_GrandPa And Mother_GrandMa");


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
                    }
                }
            }

        } else { // لا يوجد اب

            Log.i(TAG, "calculateFather(): has No Father");

            //يوجد جد او جدة لأب
            if (oConstants.isHasFather_GrandFather() || oConstants.isHasFather_GrandMother()) {
                Log.i(TAG, "calculateFather(): has Father_GrandPa Or Father_GrandMa");

                // نصيب الجدين معا = 1/6
                if (oConstants.isHasFather_GrandFather() && oConstants.isHasFather_GrandMother()) {
                    Log.i(TAG, "calculateFather(): has Father_GrandPa And Father_GrandMa");

                    //TODO Share Person should be calculated as one person
                    OConstants.setPersonSharePercent(data, OConstants.one_Twelve, OConstants.PERSON_FATHER_GRANDFATHER); // نصيب جد لاب = 1/12
                    OConstants.setPersonSharePercent(data, OConstants.one_Twelve, OConstants.PERSON_FATHER_GRANDMOTHER);// نصيب جدة لاب = 1/12

                    OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER_GRANDMOTHER, ProofsAndExplanations.FatherGrandPaOrGrandMaProofs.WITH_CHILDREN, ProofsAndExplanations.FatherGrandPaOrGrandMaProofs.p1);
                    OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER_GRANDFATHER, ProofsAndExplanations.FatherGrandPaOrGrandMaProofs.WITH_CHILDREN, ProofsAndExplanations.FatherGrandPaOrGrandMaProofs.p1);

                    Log.i(TAG, "calculateFather(): Father_GrandPa Takes 1/12 And Father_GrandMa Takes 1/12");

                } else if (oConstants.isHasFather_GrandFather() && !oConstants.isHasFather_GrandMother()) {
                    Log.i(TAG, "calculateFather(): has Father_GrandPa And Father_GrandMa");

                    OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_FATHER_GRANDFATHER); // نصيب جد لاب = 1/6
                    OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER_GRANDFATHER, ProofsAndExplanations.FatherGrandPaOrGrandMaProofs.WITH_CHILDREN, ProofsAndExplanations.FatherGrandPaOrGrandMaProofs.p1);

                    Log.i(TAG, "calculateFather(): Father_GrandPa Takes 1/6");

                } else if (!oConstants.isHasFather_GrandFather() && oConstants.isHasFather_GrandMother()) {
                    Log.i(TAG, "calculateFather(): has Father_GrandMa");

                    OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_FATHER_GRANDMOTHER);// نصيب جدة لاب = 1/6
                    OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER_GRANDMOTHER, ProofsAndExplanations.FatherGrandPaOrGrandMaProofs.WITH_CHILDREN, ProofsAndExplanations.FatherGrandPaOrGrandMaProofs.p1);

                    Log.i(TAG, "calculateFather(): Father_GrandMa Takes 1/6");

                }
            }
        }

    }


}
