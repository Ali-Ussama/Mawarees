package com.company.mawarees.Model.Utilities;

import android.util.Log;

import com.company.mawarees.Model.Models.Fraction;
import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;

import java.util.ArrayList;

public class BrothersUtils {


    private static final String TAG = "BrothersUtils";

    public static void calculateBrothers(ArrayList<Person> data, OConstants oConstants) {
        try {
            int sistersNumber = OConstants.getSistersCount(data) + (OConstants.getBrothersCount(data) * 2);

            Log.i(TAG, "calculateBrothers() is called");
            Log.i(TAG, "calculateBrothers() ");

            // has brothers or sisters or both
            if (OConstants.getPerson(data, OConstants.PERSON_BROTHER) != null || OConstants.getPerson(data, OConstants.PERSON_SISTER) != null) {

                Log.i(TAG, "calculateBrothers() has brothers or sisters or both");

                if (!oConstants.isHasChildren()) {
                    Log.i(TAG, "calculateBrothers() No Children");
                    // لا يوجد اب او ام
                    if (!oConstants.isHasMother() && !oConstants.isHasFather()) {
                        Log.i(TAG, "calculateBrothers() No Father or Mother");

                        //  لا يوجد جد او جدة لام و لاب و لا يوجد زوج او زوجة
                        if (!oConstants.isHasFather_GrandMother() && !oConstants.isHasFather_GrandFather() && !oConstants.isHasMother_GrandFather() && !oConstants.isHasMother_GrandMother()
                                && ((oConstants.getGender().matches(OConstants.GENDER_MALE) && !oConstants.isHasWife()) || (oConstants.getGender().matches(OConstants.GENDER_FEMALE) && !oConstants.isHasHusband()))) {

                            Log.i(TAG, "calculateBrothers() No GrandPa or GrandMa or Husband or Wife");

                            brothersConditions(data);
                        } else { // يوجد جدود او زوج/زوجة
                            Log.i(TAG, "calculateBrothers() Has GrandPa or GrandMa or Husband or Wife");

                            // اخ/اخت واحد
                            if (OConstants.getBrothersCount(data) + OConstants.getSistersCount(data) == 1) {
                                Log.i(TAG, "calculateBrothers() Has one sister or one brother");

                                // نصيب الاخ / الاخت = 1/6
                                if (OConstants.getBrothersCount(data) == 1) {

                                    Log.i(TAG, "calculateBrothers() Has one brother tales 1/6");

                                    OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_BROTHER);
                                    OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_BROTHER, ProofsAndExplanations.BotherAndSistersProofs.ONE_BROTHER_OR_SISTER_E, ProofsAndExplanations.BotherAndSistersProofs.p1);

                                } else if (OConstants.getSistersCount(data) == 1) {
                                    Log.i(TAG, "calculateBrothers() Has one sister takes 1/6");

                                    OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_SISTER);
                                    OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_SISTER, ProofsAndExplanations.BotherAndSistersProofs.ONE_BROTHER_OR_SISTER_E, ProofsAndExplanations.BotherAndSistersProofs.p1);
                                }
                            } else {// اكثر من اخ

                                Log.i(TAG, "calculateBothers(): More Than brother and sister");
                                Log.i(TAG, "calculateBrothers(): one third = " + OConstants.one_Third.getNumerator() + "/" + OConstants.one_Third.getDenominator());

                                // شركاء في الثلث
                                // كل على حسب النصيب ( ولد = 2 * البنت )
//                                Fraction sistersFraction = Fraction.divideFraction(OConstants.one_Third, new Fraction(sistersNumber, 1));
//                                Fraction brothersFraction = Fraction.multiplyFraction(sistersFraction, new Fraction(2, 1));
                                OConstants.setPersonSharePercent(data, OConstants.one_Third, OConstants.PERSON_BROTHER);
                                OConstants.setPersonSharePercent(data, OConstants.one_Third, OConstants.PERSON_SISTER);


                                //TODO
                                resetPerson(data, OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER);
                                createAlivePerson(data, (OConstants.getBrothersCount(data) + OConstants.getSistersCount(data)),
                                        OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER, OConstants.GENDER_MALE, true, true,OConstants.BROTHERS_ID);

                                OConstants.setPersonSharePercent(data, OConstants.one_Third, OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER); // اكثر من اخ

                                OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_BROTHER, ProofsAndExplanations.BotherAndSistersProofs.ONE_THIRD_MORE_THAN_BROTHER_AND_SISTER_E, ProofsAndExplanations.BotherAndSistersProofs.p1);
                                OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_SISTER, ProofsAndExplanations.BotherAndSistersProofs.ONE_THIRD_MORE_THAN_BROTHER_AND_SISTER_E, ProofsAndExplanations.BotherAndSistersProofs.p1);

                            }
                        }

                    } else {
                        // يوجد اب او ام
                        // الاخوة محجوبين لوجود اب او ام او كلاهما
                        if (oConstants.isHasFather()) {
                            OConstants.blockPerson(data, OConstants.PERSON_BROTHER, OConstants.PERSON_FATHER);
                            OConstants.blockPerson(data, OConstants.PERSON_SISTER, OConstants.PERSON_FATHER);

                        } else if (oConstants.isHasMother()) {
                            OConstants.blockPerson(data, OConstants.PERSON_BROTHER, OConstants.PERSON_MOTHER);
                            OConstants.blockPerson(data, OConstants.PERSON_SISTER, OConstants.PERSON_MOTHER);
                        }
                    }

                } else {
                    // يوجد اولاد
                    // الاخوة محجوبين لوجود فرع وارث
                    OConstants.blockPerson(data, OConstants.PERSON_BROTHER, "أبناء");
                    OConstants.blockPerson(data, OConstants.PERSON_SISTER, "أبناء");
                }
            } else {
                //لا يوجد اخوة

//                noBrothersCondition(data);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void resetPerson(ArrayList<Person> mPeople, String relation) {
        try {
            ArrayList<Person> index = new ArrayList<>();

            for (int i = 0; i < mPeople.size(); i++) {
                if (mPeople.get(i).getRelation().matches(relation) && mPeople.get(i).isAlive()) {
                    index.add(mPeople.get(i));
                }
            }

            if (!index.isEmpty()) {
                for (Person person : index) {
                    mPeople.remove(person);
                }
            }
            Log.i(TAG, "mPeople() people size = " + mPeople.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void brothersConditions(ArrayList<Person> data) {
        try {
            Log.i(TAG, "brothersConditions(): is called");
            Log.i(TAG, "brothersConditions(): ");

            if (OConstants.getBrothersCount(data) == 1 && OConstants.getSistersCount(data) == 0) { // اخ واحد
                Log.i(TAG, "brothersConditions(): one brother takes all");

                // نصيب الاخ = كل التركة
                OConstants.setPersonSharePercent(data, OConstants.one, OConstants.PERSON_BROTHER);
                OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_BROTHER, ProofsAndExplanations.BotherAndSistersProofs.TAKES_ALL_ONE_BROTHER_E, ProofsAndExplanations.BotherAndSistersProofs.p2);

            } else if (OConstants.getSistersCount(data) == 1 && OConstants.getBrothersCount(data) == 0) { // اخت واحدة
                Log.i(TAG, "brothersConditions(): one sister takes half");

                // نصيب الاخت = 1/2
                OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_SISTER);
                OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_SISTER, ProofsAndExplanations.BotherAndSistersProofs.ONE_SISTER_AND_TAKES_HALF_E, ProofsAndExplanations.BotherAndSistersProofs.p2);

                //حساب نصيب الاعمام و الاخوال

//                calculateUnclesAndAunts(data);

            } else if (OConstants.getSistersCount(data) == 2 && OConstants.getBrothersCount(data) == 0) { // اختين
                Log.i(TAG, "brothersConditions(): two sisters take 2/3");

                // نصيب الاختين = 2/3
                resetPerson(data, OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER);
                createAlivePerson(data, (OConstants.getBrothersCount(data) + OConstants.getSistersCount(data)),
                        OConstants.PERSON_TWO_SISTERS, OConstants.GENDER_MALE, true,false,OConstants.BROTHERS_ID);

                OConstants.setPersonSharePercent(data, OConstants.two_Thirds, OConstants.PERSON_TWO_SISTERS); // نصيب الاختين = 2/3
                OConstants.setPersonSharePercent(data, OConstants.two_Thirds, OConstants.PERSON_SISTER); // نصيب الاختين = 2/3
                OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_TWO_SISTERS, ProofsAndExplanations.BotherAndSistersProofs.TWO_THIRD_TWO_SISTERS_E, ProofsAndExplanations.BotherAndSistersProofs.p2);
                OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_SISTER, ProofsAndExplanations.BotherAndSistersProofs.TWO_THIRD_TWO_SISTERS_E, ProofsAndExplanations.BotherAndSistersProofs.p2);
//                OConstants.setPersonSharePercent(data, OConstants.two_Thirds, OConstants.PERSON_SISTER);

                //حساب نصيب الاعمام و الاخوال

//                calculateUnclesAndAunts(data);

            } else if (OConstants.getPersonsInGirlsCount(data, OConstants.PERSON_BROTHER, OConstants.PERSON_SISTER) >= 3) { // ثلاثة اخوة فأكثر
                Log.i(TAG, "brothersConditions(): more than three brother and sister takes all");

                // نصيب الاخوة = كل التركة
                int brotherAndSistersCount = OConstants.getSistersCount(data) + (OConstants.getBrothersCount(data) * 2);

                Fraction sistersFraction = Fraction.divideFraction(OConstants.one, new Fraction(brotherAndSistersCount, 1));
                Fraction brothersFraction = Fraction.multiplyFraction(sistersFraction, new Fraction(2, 1));

                OConstants.setPersonSharePercent(data, OConstants.one, OConstants.PERSON_BROTHER);
                OConstants.setPersonSharePercent(data, OConstants.one, OConstants.PERSON_SISTER);

                //TODO
                resetPerson(data, OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER);
                createAlivePerson(data, (OConstants.getBrothersCount(data) + OConstants.getSistersCount(data)),
                        OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER, OConstants.GENDER_MALE, true,true,OConstants.BROTHERS_ID);
                OConstants.setPersonSharePercent(data, OConstants.one, OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER);

                OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_BROTHER, ProofsAndExplanations.BotherAndSistersProofs.MORE_THAN_THREE_BROTHER_AND_SISTER_E, ProofsAndExplanations.BotherAndSistersProofs.p2);
                OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_SISTER, ProofsAndExplanations.BotherAndSistersProofs.MORE_THAN_THREE_BROTHER_AND_SISTER_E, ProofsAndExplanations.BotherAndSistersProofs.p2);
                OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER, ProofsAndExplanations.BotherAndSistersProofs.MORE_THAN_THREE_BROTHER_AND_SISTER_E, ProofsAndExplanations.BotherAndSistersProofs.p2);

                // نصيب الولد = 2 * نصيب البنت
            } else if (OConstants.getBrothersCount(data) + OConstants.getSistersCount(data) == 0) {
                //لا يوجد اخوة
//                noBrothersCondition(data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void calculateUnclesAndAunts(ArrayList<Person> data) {
        try {
            // TODO
            // نصيب الاعمام = 1/2 الباقي

            OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_FATHER_AUNT);
            OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_FATHER_UNCLE);
            OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS); // نصيب الاعمام = 2/3 التركة

            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER_AUNT, ProofsAndExplanations.FatherUnclesProofs.E1, ProofsAndExplanations.FatherUnclesProofs.p1);
            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER_UNCLE, ProofsAndExplanations.FatherUnclesProofs.E1, ProofsAndExplanations.FatherUnclesProofs.p1);
            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS, ProofsAndExplanations.FatherUnclesProofs.E1, ProofsAndExplanations.FatherUnclesProofs.p1);

            // TODO
            // نصيب الاخوال = 1/2 الباقي
            OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_MOTHER_AUNT);
            OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_MOTHER_UNCLE);
            OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS); // نصيب الاعمام = 2/3 التركة

            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER_AUNT, ProofsAndExplanations.MotherUnclesProofs.E1, ProofsAndExplanations.MotherUnclesProofs.p1);
            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER_UNCLE, ProofsAndExplanations.MotherUnclesProofs.E1, ProofsAndExplanations.MotherUnclesProofs.p1);
            OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS, ProofsAndExplanations.MotherUnclesProofs.E1, ProofsAndExplanations.MotherUnclesProofs.p1);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void noBrothersCondition(ArrayList<Person> data) {

        // نصيب الاعمام = 2/3 التركة

        OConstants.setPersonSharePercent(data, OConstants.two_Thirds, OConstants.PERSON_FATHER_AUNT);
        OConstants.setPersonSharePercent(data, OConstants.two_Thirds, OConstants.PERSON_FATHER_UNCLE);
        OConstants.setPersonSharePercent(data, OConstants.two_Thirds, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS); // نصيب الاعمام = 2/3 التركة

        OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER_AUNT, ProofsAndExplanations.FatherUnclesProofs.E1, ProofsAndExplanations.FatherUnclesProofs.p1);
        OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_FATHER_UNCLE, ProofsAndExplanations.FatherUnclesProofs.E1, ProofsAndExplanations.FatherUnclesProofs.p1);

        // نصيب الاخوال = 1/3 التركة

        OConstants.setPersonSharePercent(data, OConstants.one_Third, OConstants.PERSON_MOTHER_AUNT);
        OConstants.setPersonSharePercent(data, OConstants.one_Third, OConstants.PERSON_MOTHER_UNCLE);
        OConstants.setPersonSharePercent(data, OConstants.one_Third, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS);// نصيب الاخوال = 1/3 التركة

        OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER_AUNT, ProofsAndExplanations.MotherUnclesProofs.E1, ProofsAndExplanations.MotherUnclesProofs.p1);
        OConstants.setPersonProofAndExplanation(data, OConstants.PERSON_MOTHER_UNCLE, ProofsAndExplanations.MotherUnclesProofs.E1, ProofsAndExplanations.MotherUnclesProofs.p1);

    }

    private static void createAlivePerson(ArrayList<Person> data, int size, String relation, String gender, boolean isAlive, boolean group,int id) {
        try {

            Person person = new Person();
            person.setAlive(isAlive);
            person.setCount(size);
            person.setRelation(relation);
            person.setGender(gender);
            person.setDeadChildNumber(-1);
            person.setGroup(group);
            person.setId(id);
            data.add(person);


            Log.i(TAG, "createAlivePerson() person relation = " + relation + " & Alive = " + isAlive + " & gender = " + gender + " created");
            Log.i(TAG, "createAlivePerson() people size = " + data.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
