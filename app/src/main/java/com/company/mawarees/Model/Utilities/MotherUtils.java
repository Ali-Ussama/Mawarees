package com.company.mawarees.Model.Utilities;

import android.util.Log;

import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;

import java.util.ArrayList;

public class MotherUtils {

    private static final String TAG = "MotherUtils";

    public static void calculateMother(ArrayList<Person> data, OConstants oConstants) {

        //توجد ام
        if (oConstants.isHasMother()) {
            Log.i(TAG, "calculateMother(): has Mother");

            // يوجد فرع وارث
            if (oConstants.isHasChildren()) {
                Log.i(TAG, "calculateMother(): has Children");

                // نصيب الام = 1/6
                // نصيب الاب = 1/6
                OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_FATHER);
                OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_MOTHER);
                OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER, ProofsAndExplanations.MotherProofs.ONE_SIX_WITH_CHILDREN_E, ProofsAndExplanations.MotherProofs.p1);
                OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER, ProofsAndExplanations.FatherProofs.ONE_SIX_WITH_CHILDREN_E, ProofsAndExplanations.FatherProofs.p1);

                Log.i(TAG, "calculateMother(): Father share = 1/6 ");
                Log.i(TAG, "calculateMother(): Mother share = 1/6 ");


            } else { // لا يوجد فرع وارث
                Log.i(TAG, "calculateMother(): has No Children");

                // يوجد اب
                if (oConstants.isHasFather()) {
                    Log.i(TAG, "calculateMother(): has Father");

                    //TODO
                    //الباقي مناصفة بين الاب و الام بعد استيفاء اصحاب الفروض ( زوج / زوجه )
                    OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_FATHER);
                    OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_MOTHER);

                    OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER, ProofsAndExplanations.MotherProofs.FIFTY_FIFTY_WITH_FATHER_E, ProofsAndExplanations.MotherProofs.p1);
                    OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER, ProofsAndExplanations.FatherProofs.FIFTY_FIFTY_WITH_FATHER_E, ProofsAndExplanations.FatherProofs.p1);

                    Log.i(TAG, "calculateMother(): Father and mother takes the rest 50/50");

                } else { // لا يوجد اب

                    Log.i(TAG, "calculateMother(): has No Father");

                    // يوجد جدود لاب
                    if (oConstants.isHasFather_GrandFather() || oConstants.isHasFather_GrandMother()) {

                        Log.i(TAG, "calculateMother(): has Father_GrandPa Or Father_GrandMa");
                        if (oConstants.isHasMother_GrandFather() && !oConstants.isHasMother_GrandMother()) {
                            Log.i(TAG, "calculateMother(): has Father_GrandPa And Not Father_GrandMa");

                            OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_FATHER_GRANDFATHER); // نصيب جد لأم = 1/6

                            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER_GRANDFATHER, ProofsAndExplanations.FatherGrandPaOrGrandMaProofs.WITH_CHILDREN, ProofsAndExplanations.FatherGrandPaOrGrandMaProofs.p1);


                            Log.i(TAG, "calculateMother(): Father_GrandPa Takes 1/6");

                        } else if (!oConstants.isHasFather_GrandFather() && oConstants.isHasFather_GrandMother()) {
                            Log.i(TAG, "calculateMother(): has Father_GrandMa And Not Father_GrandPa");

                            OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_FATHER_GRANDMOTHER);// نصيب جدة لأم = 1/6
                            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER_GRANDMOTHER, ProofsAndExplanations.FatherGrandPaOrGrandMaProofs.WITH_CHILDREN, ProofsAndExplanations.FatherGrandPaOrGrandMaProofs.p1);

                            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER_GRANDMOTHER, ProofsAndExplanations.FatherGrandPaOrGrandMaProofs.WITH_CHILDREN, ProofsAndExplanations.FatherGrandPaOrGrandMaProofs.p1);
                            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER_GRANDFATHER, ProofsAndExplanations.FatherGrandPaOrGrandMaProofs.WITH_CHILDREN, ProofsAndExplanations.FatherGrandPaOrGrandMaProofs.p1);

                            Log.i(TAG, "calculateMother(): Mother_GrandMa Takes 1/6");

                        }else{
                            Log.i(TAG, "calculateMother(): has Father_GrandMa And Father_GrandPa");

                            //TODO Share Person should be calculated as one person
                            OConstants.setPersonSharePercent(data, OConstants.one_Twelve, OConstants.PERSON_FATHER_GRANDFATHER);
                            OConstants.setPersonSharePercent(data, OConstants.one_Twelve, OConstants.PERSON_FATHER_GRANDMOTHER);

                            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER_GRANDMOTHER, ProofsAndExplanations.FatherGrandPaOrGrandMaProofs.WITH_CHILDREN, ProofsAndExplanations.FatherGrandPaOrGrandMaProofs.p1);
                            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER_GRANDFATHER, ProofsAndExplanations.FatherGrandPaOrGrandMaProofs.WITH_CHILDREN, ProofsAndExplanations.FatherGrandPaOrGrandMaProofs.p1);

                        }
                        // TODO
                        //نصيب الام الباقي بعد استيفاء اصحاب الفروض
                        OConstants.setPersonSharePercent(data, OConstants.one, OConstants.PERSON_MOTHER);
                        OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER, ProofsAndExplanations.MotherProofs.REST_E, ProofsAndExplanations.MotherProofs.p1);

                        Log.i(TAG, "calculateMother(): Mother takes the rest");

                    } else {
                        // لا يوجد جدود لاب
                        Log.i(TAG, "calculateMother(): has No Father_GrandPa And Father_GrandMa");


                        // يوجد جمع اخوة
                        if (oConstants.isHasBrothersAndSisters() && OConstants.hasMoreThreeBrothersAndSisters(data)) {
                            Log.i(TAG, "calculateMother(): has  More Three Brothers And Sisters");

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
                    }
                }
            }

        } else { // لا توجد ام
            Log.i(TAG, "calculateMother(): No has Mother");

            //يوجد جد او جدة لأم
            if (oConstants.isHasMother_GrandFather() || oConstants.isHasMother_GrandMother()) {
                Log.i(TAG, "calculateMother(): has Mother_GrandPa Or Mother_GrandMa");


                // نصيب الجدين معا = 1/6
                if (oConstants.isHasMother_GrandFather() && oConstants.isHasMother_GrandMother()) {
                    Log.i(TAG, "calculateMother(): has Mother_GrandPa And Mother_GrandMa");

                    //TODO Share Person should be calculated as one person
                    OConstants.setPersonSharePercent(data, OConstants.one_Twelve, OConstants.PERSON_MOTHER_GRANDFATHER);
                    OConstants.setPersonSharePercent(data, OConstants.one_Twelve, OConstants.PERSON_MOTHER_GRANDMOTHER);

                    OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER_GRANDMOTHER, ProofsAndExplanations.MotherGrandPaOrGrandMaProofs.WITH_CHILDREN, ProofsAndExplanations.MotherGrandPaOrGrandMaProofs.p1);
                    OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER_GRANDFATHER, ProofsAndExplanations.MotherGrandPaOrGrandMaProofs.WITH_CHILDREN, ProofsAndExplanations.MotherGrandPaOrGrandMaProofs.p1);

                    Log.i(TAG, "calculateMother(): Mother_GrandPa Takes 1/12 And Mother_GrandMa Takes 1/12");

                } else if (oConstants.isHasMother_GrandFather() && !oConstants.isHasMother_GrandMother()) {
                    Log.i(TAG, "calculateMother(): has Mother_GrandPa And Mother_GrandMa");

                    OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_MOTHER_GRANDFATHER); // نصيب جد لأم = 1/6
                    OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER_GRANDFATHER, ProofsAndExplanations.MotherGrandPaOrGrandMaProofs.WITH_CHILDREN, ProofsAndExplanations.MotherGrandPaOrGrandMaProofs.p1);


                    Log.i(TAG, "calculateMother(): Mother_GrandPa Takes 1/6");

                } else if (!oConstants.isHasMother_GrandFather() && oConstants.isHasMother_GrandMother()) {
                    Log.i(TAG, "calculateMother(): has Mother_GrandMa");

                    OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_MOTHER_GRANDMOTHER);// نصيب جدة لأم = 1/6
                    OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER_GRANDMOTHER, ProofsAndExplanations.MotherGrandPaOrGrandMaProofs.WITH_CHILDREN, ProofsAndExplanations.MotherGrandPaOrGrandMaProofs.p1);

                    Log.i(TAG, "calculateMother(): Mother_GrandMa Takes 1/6");

                }

            }
        }
    }

}
