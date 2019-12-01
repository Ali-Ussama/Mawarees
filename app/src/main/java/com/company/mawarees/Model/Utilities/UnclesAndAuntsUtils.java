package com.company.mawarees.Model.Utilities;

import android.util.Log;

import com.company.mawarees.Model.Models.Fraction;
import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;

import java.util.ArrayList;

public class UnclesAndAuntsUtils {

    private static final String TAG = "UnclesAndAuntsUtils";

    public static void calculate(ArrayList<Person> data, OConstants oConstants) {

        if (OConstants.getPersonCount(data, OConstants.PERSON_FATHER_UNCLE) > 0 || OConstants.getPersonCount(data, OConstants.PERSON_FATHER_AUNT) > 0 ||
                OConstants.getPersonCount(data, OConstants.PERSON_MOTHER_UNCLE) > 0 || OConstants.getPersonCount(data, OConstants.PERSON_MOTHER_UNCLE) > 0) {

            if (oConstants.isHasChildren()) {
                //Has Children
                // block Father Uncles And Aunts
                // block Mother Uncles And Aunts
                Log.i(TAG, "calculate(): Has Children");

            } else {
                //Has No Children
                Log.i(TAG, "calculate(): Has No Children");

                if (oConstants.isHasFather_GrandFather() || oConstants.isHasFather_GrandMother() || oConstants.isHasMother_GrandFather() || oConstants.isHasMother_GrandMother()) {
                    // Has Grand Mother or Grand Father
                    // block Father Uncles And Aunts
                    // block Mother Uncles And Aunts

                } else {
                    // Has No Grand Mother or Grand Father
                    Log.i(TAG, "calculate(): Has No Grand Mother or Grand Father");

                    if (oConstants.isHasHusband() || oConstants.isHasWife()) {
                        // Has Husband or Wife
                        // block Father Uncles And Aunts
                        // block Mother Uncles And Aunts
                        Log.i(TAG, "calculate(): Has Husband or Wife");

                    } else {
                        // Has No Husband or Wife
                        Log.i(TAG, "calculate(): Has No Husband or Wife");

                        if (oConstants.isHasFather() || oConstants.isHasMother()) {
                            // Has Father os Mother
                            Log.i(TAG, "calculate(): Has Father os Mother");

                        } else {
                            // Has No Father os Mother
                            Log.i(TAG, "calculate(): Has No Father os Mother");

                            int brotherAndSistersCountInGirls = OConstants.getSistersCount(data) + (OConstants.getBrothersCount(data) * 2);

                            if (brotherAndSistersCountInGirls == 1) {
                                Log.i(TAG, "calculate(): Has one sister");

                                handleFatherUnclesAndAunts(data, OConstants.half, OConstants.quarter);
                                handleMotherUnclesAndAunts(data, OConstants.half, OConstants.quarter);

                            } else if (brotherAndSistersCountInGirls == 2) {
                                Log.i(TAG, "calculate():  Has two sisters");

                                handleFatherUnclesAndAunts(data, OConstants.half, OConstants.quarter);
                                handleMotherUnclesAndAunts(data, OConstants.half, OConstants.quarter);

                            } else if (brotherAndSistersCountInGirls == 0) {
                                Log.i(TAG, "calculate(): Has No sisters");

                                handleFatherUnclesAndAunts(data, OConstants.one, OConstants.two_Thirds);
                                handleMotherUnclesAndAunts(data, OConstants.one, OConstants.one_Third);
                            } else if (brotherAndSistersCountInGirls >= 3) {

                                OConstants.blockPerson(data, OConstants.PERSON_FATHER_UNCLE, OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER);
                                OConstants.blockPerson(data, OConstants.PERSON_FATHER_AUNT, OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER);
                                OConstants.blockPerson(data, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS, OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER);

                                OConstants.blockPerson(data, OConstants.PERSON_MOTHER_UNCLE, OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER);
                                OConstants.blockPerson(data, OConstants.PERSON_MOTHER_AUNT, OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER);
                                OConstants.blockPerson(data, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS, OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER);
                            }
                        }
                    }
                }
            }
        }
    }

    private static void handleFatherUnclesAndAunts(ArrayList<Person> data, Fraction allShare, Fraction eachGroupShare) {

        try {

            //TODO
            int fatherUnclesAndAuntsCount = OConstants.getPersonCount(data, OConstants.PERSON_FATHER_AUNT) + (OConstants.getPersonCount(data, OConstants.PERSON_FATHER_UNCLE));
            int fatherUnclesCount = OConstants.getPersonCount(data, OConstants.PERSON_FATHER_UNCLE);
            int fatherAuntsCount = OConstants.getPersonCount(data, OConstants.PERSON_FATHER_AUNT);

            int motherUnclesAndAuntsCount = OConstants.getPersonCount(data, OConstants.PERSON_MOTHER_AUNT) + (OConstants.getPersonCount(data, OConstants.PERSON_MOTHER_UNCLE));
            int motherUnclesCount = OConstants.getPersonCount(data, OConstants.PERSON_MOTHER_UNCLE);
            int motherAuntsCount = OConstants.getPersonCount(data, OConstants.PERSON_MOTHER_AUNT);

            if (motherUnclesAndAuntsCount == 0 && fatherUnclesAndAuntsCount > 0) {

                Fraction fraction = new Fraction(allShare.getNumerator(), allShare.getDenominator());

                OConstants.setPersonSharePercent(data, fraction, OConstants.PERSON_FATHER_AUNT);
                OConstants.setPersonSharePercent(data, fraction, OConstants.PERSON_FATHER_UNCLE);
                OConstants.setPersonSharePercent(data, fraction, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS);


            } else if (motherUnclesAndAuntsCount > 0 && fatherUnclesAndAuntsCount > 0) {

                Fraction fraction = new Fraction(eachGroupShare.getNumerator(), eachGroupShare.getDenominator());

                OConstants.setPersonSharePercent(data, fraction, OConstants.PERSON_FATHER_AUNT);
                OConstants.setPersonSharePercent(data, fraction, OConstants.PERSON_FATHER_UNCLE);
                OConstants.setPersonSharePercent(data, fraction, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS);
            }

            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER_AUNT, ProofsAndExplanations.FatherUnclesProofs.E1, ProofsAndExplanations.FatherUnclesProofs.p1);
            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER_UNCLE, ProofsAndExplanations.FatherUnclesProofs.E1, ProofsAndExplanations.FatherUnclesProofs.p1);
            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS, ProofsAndExplanations.FatherUnclesProofs.E1, ProofsAndExplanations.FatherUnclesProofs.p1);


            try {
                Person fatherUncles = OConstants.getPerson(data, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS);

                if (fatherUncles != null) {
                    Log.i(TAG, "handleFatherUnclesAndAunts(): father uncles and aunts!= null");

                    if (fatherUncles.getSharePercent() != null) {
                        Log.i(TAG, "handleFatherUnclesAndAunts(): father uncles and aunts share percent = " + fatherUncles.getSharePercent().getNumerator() + "/" + fatherUncles.getSharePercent().getDenominator());

                    } else {
                        Log.i(TAG, "handleFatherUnclesAndAunts(): father uncles and aunts share percent = null");

                    }
                } else {
                    Log.i(TAG, "handleFatherUnclesAndAunts(): father uncles and aunts = null");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void handleMotherUnclesAndAunts(ArrayList<Person> data, Fraction allShare, Fraction eachGroupShare) {
        try {

            int fatherUnclesAndAuntsCount = OConstants.getPersonCount(data, OConstants.PERSON_FATHER_AUNT) + (OConstants.getPersonCount(data, OConstants.PERSON_FATHER_UNCLE));
            int fatherUnclesCount = OConstants.getPersonCount(data, OConstants.PERSON_FATHER_UNCLE);
            int fatherAuntsCount = OConstants.getPersonCount(data, OConstants.PERSON_FATHER_AUNT);

            int motherUnclesAndAuntsCount = OConstants.getPersonCount(data, OConstants.PERSON_MOTHER_AUNT) + (OConstants.getPersonCount(data, OConstants.PERSON_MOTHER_UNCLE));
            int motherUnclesCount = OConstants.getPersonCount(data, OConstants.PERSON_MOTHER_UNCLE);
            int motherAuntsCount = OConstants.getPersonCount(data, OConstants.PERSON_MOTHER_AUNT);

            if (motherUnclesAndAuntsCount > 0 && fatherUnclesAndAuntsCount == 0) {

                Fraction fraction = new Fraction(allShare.getNumerator(), allShare.getDenominator());

                OConstants.setPersonSharePercent(data, fraction, OConstants.PERSON_MOTHER_AUNT);
                OConstants.setPersonSharePercent(data, fraction, OConstants.PERSON_MOTHER_UNCLE);
                OConstants.setPersonSharePercent(data, fraction, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS);

            } else if (motherUnclesAndAuntsCount > 0 && fatherUnclesAndAuntsCount > 0) {

                Fraction fraction = new Fraction(eachGroupShare.getNumerator(), eachGroupShare.getDenominator());

                OConstants.setPersonSharePercent(data, fraction, OConstants.PERSON_MOTHER_AUNT);
                OConstants.setPersonSharePercent(data, fraction, OConstants.PERSON_MOTHER_UNCLE);
                OConstants.setPersonSharePercent(data, fraction, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS);

            }


            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER_AUNT, ProofsAndExplanations.MotherUnclesProofs.E1, ProofsAndExplanations.MotherUnclesProofs.p1);
            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER_UNCLE, ProofsAndExplanations.MotherUnclesProofs.E1, ProofsAndExplanations.MotherUnclesProofs.p1);
            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS, ProofsAndExplanations.MotherUnclesProofs.E1, ProofsAndExplanations.MotherUnclesProofs.p1);

            Person motherUncles = OConstants.getPerson(data, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS);

            if (motherUncles != null) {
                Log.i(TAG, "handleFatherUnclesAndAunts(): mother uncles and aunts != null");

                if (motherUncles.getSharePercent() != null) {
                    Log.i(TAG, "handleFatherUnclesAndAunts(): mother uncles and aunts share percent = " + motherUncles.getSharePercent().getNumerator() + "/" + motherUncles.getSharePercent().getDenominator());

                } else {
                    Log.i(TAG, "handleFatherUnclesAndAunts(): mother uncles and aunts share percent = null");

                }
            } else {
                Log.i(TAG, "handleFatherUnclesAndAunts(): mother uncles and aunts = null");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
