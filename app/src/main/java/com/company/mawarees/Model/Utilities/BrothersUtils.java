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

            // has brothers or sisters or both
            if (OConstants.getPerson(data, OConstants.PERSON_BROTHER) != null || OConstants.getPerson(data, OConstants.PERSON_SISTER) != null) {
                if (!oConstants.isHasChildren()) {
                    // لا يوجد اب او ام
                    if (!oConstants.isHasMother() && !oConstants.isHasFather()) {

                        //  لا يوجد جد او جدة لام و لاب و لا يوجد زوج او زوجة
                        if (!oConstants.isHasFather_GrandMother() && !oConstants.isHasFather_GrandFather() && !oConstants.isHasMother_GrandFather() && !oConstants.isHasMother_GrandMother()
                                && (oConstants.getGender().matches(OConstants.GENDER_MALE) && !oConstants.isHasWife()) && (oConstants.getGender().matches(OConstants.GENDER_FEMALE) && !oConstants.isHasHusband())) {

                            brothersConditions(data);
                        } else { // يوجد جدود او زوج/زوجة

                            // اخ/اخت واحد
                            if (OConstants.getBrothersCount(data) + OConstants.getSistersCount(data) == 1) {
                                // نصيب الاخ / الاخت = 1/6
                                if (OConstants.getBrothersCount(data) == 1) {
                                    OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_BROTHER);

                                } else if (OConstants.getSistersCount(data) == 1) {
                                    OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_SISTER);
                                }
                            } else {// اكثر من اخ

                                Log.i(TAG, "calculateBothers(): More Than brother and sister");
                                Log.i(TAG, "calculateBrothers(): one third = " + OConstants.one_Third.getNumerator() + "/" + OConstants.one_Third.getDenominator());

                                // شركاء في الثلث
                                // كل على حسب النصيب ( ولد = 2 * البنت )
                                Fraction sistersFraction = Fraction.divideFraction(OConstants.one_Third, new Fraction(sistersNumber, 1));
                                Fraction brothersFraction = Fraction.multiplyFraction(sistersFraction, new Fraction(2, 1));
                                OConstants.setPersonSharePercent(data, brothersFraction, OConstants.PERSON_BROTHER);
                                OConstants.setPersonSharePercent(data, sistersFraction, OConstants.PERSON_SISTER);


                                //TODO
                                resetPerson(data, OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER);
                                createAlivePerson(data, (OConstants.getBrothersCount(data) + OConstants.getSistersCount(data)), OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER, OConstants.GENDER_MALE, true);
                                OConstants.setPersonSharePercent(data, OConstants.one_Third, OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER); // اكثر من اخ
                            }
                        }

                    } else {
                        // يوجد اب او ام
                        // الاخوة محجوبين لوجود اب او ام او كلاهما
                        OConstants.blockPerson(data, OConstants.PERSON_BROTHER);
                        OConstants.blockPerson(data, OConstants.PERSON_SISTER);
                    }

                } else {
                    // يوجد اولاد
                    // الاخوة محجوبين لوجود فرع وارث
                    OConstants.blockPerson(data, OConstants.PERSON_BROTHER);
                    OConstants.blockPerson(data, OConstants.PERSON_SISTER);
                }
            } else {
                //لا يوجد اخوة

                noBrothersCondition(data);

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

            if (OConstants.getBrothersCount(data) == 1 && OConstants.getSistersCount(data) == 0) { // اخ واحد
                // نصيب الاخ = كل التركة
                OConstants.setPersonSharePercent(data, OConstants.one, OConstants.PERSON_BROTHER);

            } else if (OConstants.getSistersCount(data) == 1 && OConstants.getBrothersCount(data) == 0) { // اخت واحدة
                // نصيب الاخت = 1/2
                OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_SISTER);

                //حساب نصيب الاعمام و الاخوال

                calculateUnclesAndAunts(data);

            } else if (OConstants.getSistersCount(data) == 2 && OConstants.getBrothersCount(data) == 0) { // اختين
                // نصيب الاختين = 2/3
                Fraction oneSisterSharePercent = Fraction.divideFraction(OConstants.two_Thirds, new Fraction(2, 1));
                OConstants.setPersonSharePercent(data, oneSisterSharePercent, OConstants.PERSON_SISTER);

                //حساب نصيب الاعمام و الاخوال

                calculateUnclesAndAunts(data);

            } else if (OConstants.getBrothersCount(data) + OConstants.getSistersCount(data) >= 3) { // ثلاثة اخوة فأكثر
                // نصيب الاخوة = كل التركة
                int brotherAndSistersCount = OConstants.getSistersCount(data) + (OConstants.getBrothersCount(data) * 2);

                Fraction sistersFraction = Fraction.divideFraction(OConstants.one, new Fraction(brotherAndSistersCount, 1));
                Fraction brothersFraction = Fraction.multiplyFraction(sistersFraction, new Fraction(2, 1));

                OConstants.setPersonSharePercent(data, brothersFraction, OConstants.PERSON_BROTHER);
                OConstants.setPersonSharePercent(data, sistersFraction, OConstants.PERSON_SISTER);


                //TODO
                resetPerson(data, OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER);
                createAlivePerson(data, (OConstants.getBrothersCount(data) + OConstants.getSistersCount(data)), OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER, OConstants.GENDER_MALE, true);
                OConstants.setPersonSharePercent(data, OConstants.one, OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER);

                // نصيب الولد = 2 * نصيب البنت
            } else if (OConstants.getBrothersCount(data) + OConstants.getSistersCount(data) == 0) {
                //لا يوجد اخوة
                noBrothersCondition(data);
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

            // TODO
            // نصيب الاخوال = 1/2 الباقي
            OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_MOTHER_AUNT);
            OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_MOTHER_UNCLE);
            OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS); // نصيب الاعمام = 2/3 التركة

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void noBrothersCondition(ArrayList<Person> data) {

        // نصيب الاعمام = 2/3 التركة

        OConstants.setPersonSharePercent(data, OConstants.two_Thirds, OConstants.PERSON_FATHER_AUNT);
        OConstants.setPersonSharePercent(data, OConstants.two_Thirds, OConstants.PERSON_FATHER_UNCLE);
        OConstants.setPersonSharePercent(data, OConstants.two_Thirds, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS); // نصيب الاعمام = 2/3 التركة

        // نصيب الاخوال = 1/3 التركة

        OConstants.setPersonSharePercent(data, OConstants.one_Third, OConstants.PERSON_MOTHER_AUNT);
        OConstants.setPersonSharePercent(data, OConstants.one_Third, OConstants.PERSON_MOTHER_UNCLE);
        OConstants.setPersonSharePercent(data, OConstants.one_Third, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS);// نصيب الاخوال = 1/3 التركة

    }

    private static void createAlivePerson(ArrayList<Person> data, int size, String relation, String gender, boolean isAlive) {
        try {

            Person person = new Person();
            person.setAlive(isAlive);
            person.setCount(size);
            person.setRelation(relation);
            person.setGender(gender);
            person.setDeadSonNumber(-1);

            data.add(person);


            Log.i(TAG, "createAlivePerson() person relation = " + relation + " & Alive = " + isAlive + " & gender = " + gender + " created");
            Log.i(TAG, "createAlivePerson() people size = " + data.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
