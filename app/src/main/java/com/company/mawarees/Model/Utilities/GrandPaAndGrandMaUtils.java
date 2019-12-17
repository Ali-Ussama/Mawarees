package com.company.mawarees.Model.Utilities;

import android.util.Log;

import com.company.mawarees.Model.Models.Fraction;
import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;

import java.util.ArrayList;

public class GrandPaAndGrandMaUtils {

    private static final String TAG = "GrandPaAndGrandMaUtils";

    public static void calculateGrandPaAndGrandMa(ArrayList<Person> data, OConstants oConstants) {


        if (oConstants.isHasChildren()) {
            //Has children
            Log.i(TAG, "calculateGrandPaAndGrandMa(): Has children ");

            if (oConstants.isHasFather_GrandFather() || oConstants.isHasFather_GrandMother()) {
                if (oConstants.isHasFather()) {
                    // Has Father
                    // block Father grandPa and grandMa
                    Log.i(TAG, "calculateGrandPaAndGrandMa(): Has Father");
                    Log.i(TAG, "calculateGrandPaAndGrandMa(): block Father grandPa and grandMa");

                    OConstants.blockPerson(data, OConstants.PERSON_FATHER_GRANDFATHER, OConstants.PERSON_FATHER);
                    OConstants.blockPerson(data, OConstants.PERSON_FATHER_GRANDMOTHER, OConstants.PERSON_FATHER);

                } else {
                    // Has No Father
                    // Father grandPa and grandMa both takes 1/6
                    Log.i(TAG, "calculateGrandPaAndGrandMa(): Has No Father");
                    Log.i(TAG, "calculateGrandPaAndGrandMa(): Father grandPa and grandMa both takes 1/6");

                    handleFatherGrandPaAndGrandMa(data, oConstants, OConstants.one_Sixth, OConstants.one_Twelve);
                }
            }
            if (oConstants.isHasMother_GrandFather() || oConstants.isHasMother_GrandMother()) {
                if (oConstants.isHasMother()) {
                    // Has Mother
                    // block Mother grandPa and grandMa
                    Log.i(TAG, "calculateGrandPaAndGrandMa():  Has Mother");
                    Log.i(TAG, "calculateGrandPaAndGrandMa():  block Mother grandPa and grandMa");

                    OConstants.blockPerson(data, OConstants.PERSON_MOTHER_GRANDFATHER, OConstants.PERSON_MOTHER);
                    OConstants.blockPerson(data, OConstants.PERSON_MOTHER_GRANDMOTHER, OConstants.PERSON_MOTHER);
                } else {
                    // Has No Mother
                    // Mother grandPa and grandMa both takes 1/6
                    Log.i(TAG, "calculateGrandPaAndGrandMa(): Has No Mother");
                    Log.i(TAG, "calculateGrandPaAndGrandMa(): Mother grandPa and grandMa both takes 1/6");
                    handleMotherGrandPaAndGrandMa(data, oConstants, OConstants.one_Sixth, OConstants.one_Twelve);

                }
            }
        } else {
            //Has No children
            Log.i(TAG, "calculateGrandPaAndGrandMa(): Has No children");


            if (oConstants.isHasHusband() || oConstants.isHasWife() || OConstants.getSistersCount(data) >= 1 || OConstants.getBrothersCount(data) >= 1) {
                // Has husband or wife
                Log.i(TAG, "calculateGrandPaAndGrandMa(): Has husband or wife");

                if (oConstants.isHasFather_GrandFather() || oConstants.isHasFather_GrandMother()) {
                    if (oConstants.isHasFather()) {
                        // Has Father
                        // block Father grandPa and grandMa
                        Log.i(TAG, "calculateGrandPaAndGrandMa(): Has Father");
                        Log.i(TAG, "calculateGrandPaAndGrandMa(): block Father grandPa and grandMa");

                        OConstants.blockPerson(data, OConstants.PERSON_FATHER_GRANDFATHER, OConstants.PERSON_FATHER);
                        OConstants.blockPerson(data, OConstants.PERSON_FATHER_GRANDMOTHER, OConstants.PERSON_FATHER);
                    } else {
                        // Has No Father
                        // Father grandPa and grandMa both takes 1/6
                        Log.i(TAG, "calculateGrandPaAndGrandMa(): Has No Father");
                        Log.i(TAG, "calculateGrandPaAndGrandMa(): Father grandPa and grandMa both takes 1/6");

                        handleFatherGrandPaAndGrandMa(data, oConstants, OConstants.one_Sixth, OConstants.one_Twelve);

                    }
                }

                if (oConstants.isHasMother_GrandFather() || oConstants.isHasMother_GrandMother()) {
                    if (oConstants.isHasMother()) {
                        // Has Mother
                        // block Mother grandPa and grandMa
                        Log.i(TAG, "calculateGrandPaAndGrandMa(): Has Mother");
                        Log.i(TAG, "calculateGrandPaAndGrandMa(): block Mother grandPa and grandMa");

                        OConstants.blockPerson(data, OConstants.PERSON_MOTHER_GRANDFATHER, OConstants.PERSON_MOTHER);
                        OConstants.blockPerson(data, OConstants.PERSON_MOTHER_GRANDMOTHER, OConstants.PERSON_MOTHER);
                    } else {
                        // Has No Mother
                        // Mother grandPa and grandMa both takes 1/6
                        Log.i(TAG, "calculateGrandPaAndGrandMa(): Has No Mother");
                        Log.i(TAG, "calculateGrandPaAndGrandMa(): Mother grandPa and grandMa both takes 1/6");
                        handleMotherGrandPaAndGrandMa(data, oConstants, OConstants.one_Sixth, OConstants.one_Twelve);

                    }
                }
            } else {
                // Has No husband or wife
                Log.i(TAG, "calculateGrandPaAndGrandMa(): Has No husband or wife");

                if (oConstants.isHasFather_GrandFather() || oConstants.isHasFather_GrandMother()) {
                    if (oConstants.isHasFather()) {
                        // Has Father
                        // block Father grandPa and grandMa
                        Log.i(TAG, "calculateGrandPaAndGrandMa(): Has Father");
                        Log.i(TAG, "calculateGrandPaAndGrandMa(): block Father grandPa and grandMa");

                        OConstants.blockPerson(data, OConstants.PERSON_FATHER_GRANDFATHER, OConstants.PERSON_FATHER);
                        OConstants.blockPerson(data, OConstants.PERSON_FATHER_GRANDMOTHER, OConstants.PERSON_FATHER);
                    } else {
                        // Has No Father
                        Log.i(TAG, "calculateGrandPaAndGrandMa(): Has No Father");

                        if(oConstants.isHasMother()) {
                            // Has Mother
                            // Father grandPa and grandMa both takes 1/6
                            Log.i(TAG, "calculateGrandPaAndGrandMa(): Has Mother");
                            Log.i(TAG, "calculateGrandPaAndGrandMa(): Father grandPa and grandMa both takes 1/6");
                            handleFatherGrandPaAndGrandMa(data, oConstants, OConstants.one_Sixth, OConstants.one_Twelve);

                        }else{
                            // Father grandPa and grandMa both takes 2/3
                            Log.i(TAG, "calculateGrandPaAndGrandMa(): Father grandPa and grandMa both takes 2/3");
                            handleFatherGrandPaAndGrandMa(data, oConstants, OConstants.two_Thirds, OConstants.one_Third);

                        }
                    }
                }

                if (oConstants.isHasMother_GrandFather() || oConstants.isHasMother_GrandMother()) {
                    if (oConstants.isHasMother()) {
                        // Has Mother
                        // block Mother grandPa and grandMa
                        Log.i(TAG, "calculateGrandPaAndGrandMa(): Has Mother");
                        Log.i(TAG, "calculateGrandPaAndGrandMa(): block Mother grandPa and grandMa");

                        OConstants.blockPerson(data, OConstants.PERSON_MOTHER_GRANDFATHER, OConstants.PERSON_MOTHER);
                        OConstants.blockPerson(data, OConstants.PERSON_MOTHER_GRANDMOTHER, OConstants.PERSON_MOTHER);
                    } else {
                        // Has No Mother
                        // Mother grandPa and grandMa both takes 1/3
                        Log.i(TAG, "calculateGrandPaAndGrandMa(): Has No Mother");

                        if(oConstants.isHasFather()) {
                            // Has Father
                            // Mother grandPa and grandMa both takes 1/6
                            Log.i(TAG, "calculateGrandPaAndGrandMa(): Has Father");
                            Log.i(TAG, "calculateGrandPaAndGrandMa(): Mother grandPa and grandMa both takes 1/6");
                            handleMotherGrandPaAndGrandMa(data, oConstants, OConstants.one_Sixth, OConstants.one_Twelve);

                        }else{
                            // Mother grandPa and grandMa both takes 1/3
                            Log.i(TAG, "calculateGrandPaAndGrandMa(): Mother grandPa and grandMa both takes 1/3");
                            handleMotherGrandPaAndGrandMa(data, oConstants, OConstants.one_Third, OConstants.one_Sixth);

                        }

                    }
                }
            }
        }
    }

    private static void handleMotherGrandPaAndGrandMa(ArrayList<Person> data, OConstants oConstants, Fraction allShare, Fraction onePersonShare) {

        Log.i(TAG, "handleMotherGrandPaAndGrandMa(): has Mother_GrandPa Or Mother_GrandMa");
        if (oConstants.isHasMother_GrandFather() && !oConstants.isHasMother_GrandMother()) {
            Log.i(TAG, "handleMotherGrandPaAndGrandMa(): has Mother_GrandPa And Not Mother_GrandMa");

            Fraction newFraction = new Fraction(allShare.getNumerator(), allShare.getDenominator());

            OConstants.setPersonSharePercent(data, newFraction, OConstants.PERSON_MOTHER_GRANDFATHER); // نصيب جد لأم = 1/6

            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER_GRANDFATHER, ProofsAndExplanations.MotherGrandPaOrGrandMaProofs.WITH_CHILDREN, ProofsAndExplanations.MotherGrandPaOrGrandMaProofs.p1);


            Log.i(TAG, "handleMotherGrandPaAndGrandMa(): Mother_GrandPa Takes 1/6");

        } else if (!oConstants.isHasMother_GrandFather() && oConstants.isHasMother_GrandMother()) {
            Log.i(TAG, "handleMotherGrandPaAndGrandMa(): has Mother_GrandMa And Not Mother_GrandPa");

            Fraction newFraction = new Fraction(allShare.getNumerator(), allShare.getDenominator());

            OConstants.setPersonSharePercent(data, newFraction, OConstants.PERSON_MOTHER_GRANDMOTHER);// نصيب جدة لأم = 1/6
            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER_GRANDMOTHER, ProofsAndExplanations.MotherGrandPaOrGrandMaProofs.WITH_CHILDREN, ProofsAndExplanations.MotherGrandPaOrGrandMaProofs.p1);


            Log.i(TAG, "handleMotherGrandPaAndGrandMa(): Mother_GrandMa Takes 1/6");

        } else {
            Log.i(TAG, "handleMotherGrandPaAndGrandMa(): has Mother_GrandMa And Mother_GrandPa");

            Fraction newFraction = new Fraction(onePersonShare.getNumerator(), onePersonShare.getDenominator());

            //TODO Share Person should be calculated as one person
            OConstants.setPersonSharePercent(data, newFraction, OConstants.PERSON_MOTHER_GRANDFATHER);
            OConstants.setPersonSharePercent(data, newFraction, OConstants.PERSON_MOTHER_GRANDMOTHER);

            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER_GRANDMOTHER, ProofsAndExplanations.MotherGrandPaOrGrandMaProofs.WITH_CHILDREN, ProofsAndExplanations.MotherGrandPaOrGrandMaProofs.p1);
            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER_GRANDFATHER, ProofsAndExplanations.MotherGrandPaOrGrandMaProofs.WITH_CHILDREN, ProofsAndExplanations.MotherGrandPaOrGrandMaProofs.p1);

        }
    }

    private static void handleFatherGrandPaAndGrandMa(ArrayList<Person> data, OConstants oConstants, Fraction allShare, Fraction onePersonShare) {
        try {
            Log.i(TAG, "handleFatherGrandPaAndGrandMa(): has Father_GrandPa Or Father_GrandMa");
            if (oConstants.isHasFather_GrandFather() && !oConstants.isHasFather_GrandMother()) {
                Log.i(TAG, "handleFatherGrandPaAndGrandMa(): has Father_GrandPa And Not Father_GrandMa");

                Fraction newFraction = new Fraction(allShare.getNumerator(), allShare.getDenominator());

                OConstants.setPersonSharePercent(data, newFraction, OConstants.PERSON_FATHER_GRANDFATHER); // نصيب جد لأم = 1/6

                OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER_GRANDFATHER, ProofsAndExplanations.FatherGrandPaOrGrandMaProofs.WITH_CHILDREN, ProofsAndExplanations.FatherGrandPaOrGrandMaProofs.p1);


                Log.i(TAG, "handleFatherGrandPaAndGrandMa(): Father_GrandPa Takes 1/6");

            } else if (!oConstants.isHasFather_GrandFather() && oConstants.isHasFather_GrandMother()) {
                Log.i(TAG, "handleFatherGrandPaAndGrandMa(): has Father_GrandMa And Not Father_GrandPa");

                Fraction newFraction = new Fraction(allShare.getNumerator(), allShare.getDenominator());

                OConstants.setPersonSharePercent(data, newFraction, OConstants.PERSON_FATHER_GRANDMOTHER);// نصيب جدة لأم = 1/6
                OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER_GRANDMOTHER, ProofsAndExplanations.FatherGrandPaOrGrandMaProofs.WITH_CHILDREN, ProofsAndExplanations.FatherGrandPaOrGrandMaProofs.p1);

                Log.i(TAG, "handleFatherGrandPaAndGrandMa(): Mother_GrandMa Takes 1/6");

            }else{
                Log.i(TAG, "handleFatherGrandPaAndGrandMa(): has Father_GrandMa And Father_GrandPa");

                //TODO Share Person should be calculated as one person
                Fraction newFraction = new Fraction(onePersonShare.getNumerator(), onePersonShare.getDenominator());

                OConstants.setPersonSharePercent(data, newFraction, OConstants.PERSON_FATHER_GRANDFATHER);
                OConstants.setPersonSharePercent(data, newFraction, OConstants.PERSON_FATHER_GRANDMOTHER);

                OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER_GRANDMOTHER, ProofsAndExplanations.FatherGrandPaOrGrandMaProofs.WITH_CHILDREN, ProofsAndExplanations.FatherGrandPaOrGrandMaProofs.p1);
                OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER_GRANDFATHER, ProofsAndExplanations.FatherGrandPaOrGrandMaProofs.WITH_CHILDREN, ProofsAndExplanations.FatherGrandPaOrGrandMaProofs.p1);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
