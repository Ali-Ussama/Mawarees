package com.company.mawarees.Model.Utilities;

import android.util.Log;

import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;

import java.util.ArrayList;

public class HusbandAndWifeUtils {

    private static final String TAG = "HusbandAndWifeUtils";

    public static void calculateHusbandAndWife(ArrayList<Person> data, OConstants oConstants) {

        // يوجد فرع وارث
        if (oConstants.isHasChildren()) {
            Log.i(TAG, "CalculateHusbandAndWife(): has children");

            //المتوفي ذكر
            if (oConstants.getGender().matches(OConstants.GENDER_MALE)) {
                Log.i(TAG, "CalculateHusbandAndWife(): dead person is male");

                //يوجد زوجة
                if (oConstants.isHasWife()) {
                    Log.i(TAG, "CalculateHusbandAndWife(): dead person has wife");

                    OConstants.setPersonSharePercent(data, OConstants.one_eighth, OConstants.PERSON_WIFE); // نصيب الزوجة 1/8
                    OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_WIFE, ProofsAndExplanations.WifeProofs.E1, ProofsAndExplanations.WifeProofs.p1);

                    if (OConstants.getPersonCount(data, OConstants.PERSON_WIFE) > 1) {
                        createAlivePerson(data, OConstants.getPersonCount(data, OConstants.PERSON_WIFE), OConstants.PERSON_WIVES, OConstants.GENDER_FEMALE, true);
                        OConstants.setPersonSharePercent(data, OConstants.one_eighth, OConstants.PERSON_WIVES);
                        OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_WIVES, ProofsAndExplanations.WifeProofs.E1, ProofsAndExplanations.WifeProofs.p1);
                    }

                    Log.i(TAG, "CalculateHusbandAndWife(): setting wife with 1/8");
                } else {

                    // لا يوجد زوجة
                    Log.i(TAG, "CalculateHusbandAndWife(): dead person has no wife");

                }

            } else { //المتوفي انثى
                Log.i(TAG, "CalculateHusbandAndWife(): dead person is female");

                // يوجد زوج
                if (oConstants.isHasHusband()) {
                    Log.i(TAG, "CalculateHusbandAndWife(): dead person has husband");

                    OConstants.setPersonSharePercent(data, OConstants.quarter, OConstants.PERSON_HUSBAND); // نصيب الزوج 1/4
                    OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_HUSBAND, ProofsAndExplanations.HusbandProofs.E1, ProofsAndExplanations.HusbandProofs.p1);

                    Log.i(TAG, "CalculateHusbandAndWife(): setting husband with 1/4");

                } else {

                    // لا يوجد زوج
                    Log.i(TAG, "CalculateHusbandAndWife(): Dead person han No Husband");

                }
            }
        } else { // لا يوجد فرع وارث

            Log.i(TAG, "CalculateHusbandAndWife(): dead person has No Children");

            //المتوفي ذكر
            if (oConstants.getGender().matches(OConstants.GENDER_MALE)) {
                Log.i(TAG, "CalculateHusbandAndWife(): dead person is male");

                //يوجد زوجة
                if (oConstants.isHasWife()) {
                    Log.i(TAG, "CalculateHusbandAndWife(): dead person has wife");

                    // نصيب الزوجة 1/4
                    OConstants.setPersonSharePercent(data, OConstants.quarter, OConstants.PERSON_WIFE);
                    OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_WIFE, ProofsAndExplanations.WifeProofs.E1, ProofsAndExplanations.WifeProofs.p1);

                    if (OConstants.getPersonCount(data, OConstants.PERSON_WIFE) > 1) {
                        createAlivePerson(data, OConstants.getPersonCount(data, OConstants.PERSON_WIFE), OConstants.PERSON_WIVES, OConstants.GENDER_FEMALE, true);
                        OConstants.setPersonSharePercent(data, OConstants.quarter, OConstants.PERSON_WIVES);
                        OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_WIVES, ProofsAndExplanations.WifeProofs.E1, ProofsAndExplanations.WifeProofs.p1);
                    }

                    Log.i(TAG, "CalculateHusbandAndWife(): setting wife with 1/4");

                } else {

                    // لا يوجد زوجة
                    Log.i(TAG, "CalculateHusbandAndWife(): dead person has no wife");

                }

            } else { //المتوفي انثى
                Log.i(TAG, "CalculateHusbandAndWife(): dead person is female");

                // يوجد زوج
                if (oConstants.isHasHusband()) {
                    Log.i(TAG, "CalculateHusbandAndWife(): dead person has husband");

                    OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_HUSBAND);// نصيب الزوج 1/2
                    OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_HUSBAND, ProofsAndExplanations.HusbandProofs.E1, ProofsAndExplanations.HusbandProofs.p1);

                } else {

                    // لا يوجد زوج
                    Log.i(TAG, "CalculateHusbandAndWife(): dead person has no husband");

                }
            }
        }
    }

    private static void createAlivePerson(ArrayList<Person> data, int size, String relation, String gender, boolean isAlive) {
        try {

            Person person = new Person();
            person.setAlive(isAlive);
            person.setCount(size);
            person.setRelation(relation);
            person.setGender(gender);
            person.setDeadChildNumber(-1);
            person.setGroup(true);
            data.add(person);

            Log.i(TAG, "createAlivePerson() person relation = " + relation + " & Alive = " + isAlive + " & gender = " + gender + " created");
            Log.i(TAG, "createAlivePerson() people size = " + data.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
