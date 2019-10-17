package com.company.mawarees.Model.Utilities;

import com.company.mawarees.Model.Models.Fraction;
import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;

import java.util.ArrayList;

public class BrothersUtils {

    private static int sistersNumber;

    public static void calculateBorthers(ArrayList<Person> data, OConstants oConstants) {
        try {
            sistersNumber = OConstants.getSistersCount(data) + (OConstants.getBrothersCount(data) * 2);

            //
            if (oConstants.isHasBrothersAndSisters()) {
                if (!oConstants.isHasChildren()) {
                    // لا يوجد اب او ام
                    if (!oConstants.isHasMother() && !oConstants.isHasFather()) {

                        //  لا يوجد جد او جدة لام و لاب و لا يوجد زوج او زوجة
                        if (!oConstants.isHasFather_GrandMother() && !oConstants.isHasFather_GrandFather() && !oConstants.isHasMother_GrandFather() && !oConstants.isHasMother_GrandMother()
                                && (oConstants.getGender().matches(OConstants.GENDER_MALE) && !oConstants.isHasWife()) && (oConstants.getGender().matches(OConstants.GENDER_FEMALE) && !oConstants.isHasHusband())) {

                            brothersConditions(data, oConstants);
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

                                // شركاء في الثلث
                                // كل على حسب النصيب ( ولد = 2 * البنت )
                                Fraction sistersFraction = Fraction.divideFraction(OConstants.one_Third, new Fraction(sistersNumber, 1));
                                Fraction brothersFraction = Fraction.multiplyFraction(sistersFraction, new Fraction(2, 1));
                                OConstants.setPersonSharePercent(data, brothersFraction, OConstants.PERSON_BROTHER);
                                OConstants.setPersonSharePercent(data, sistersFraction, OConstants.PERSON_SISTER);

                                OConstants.setPersonSharePercent(data, OConstants.one_Third, OConstants.PERSON_MORE_THAN_BROTHER_AND_SISTER); // اكثر من اخ
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
                noBrothersCondition(data, oConstants);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void brothersConditions(ArrayList<Person> data, OConstants oConstants) {
        try {

            if (OConstants.getBrothersCount(data) == 1 && OConstants.getSistersCount(data) == 0) { // اخ واحد
                // نصيب الاخ = كل التركة
                OConstants.setPersonSharePercent(data, OConstants.one, OConstants.PERSON_BROTHER);

            } else if (OConstants.getSistersCount(data) == 1 && OConstants.getBrothersCount(data) == 0) { // اخت واحدة
                // نصيب الاخت = 1/2
                OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_SISTER);

                //حساب نصيب الاعمام و الاخوال
                calculateUnclesAndAunts(data, oConstants);

            } else if (OConstants.getSistersCount(data) == 2 && OConstants.getBrothersCount(data) == 0) { // اختين
                // نصيب الاختين = 2/3
                Fraction oneSisterSharePercent = Fraction.divideFraction(OConstants.two_Thirds, new Fraction(2, 1));
                OConstants.setPersonSharePercent(data, oneSisterSharePercent, OConstants.PERSON_SISTER);

                //حساب نصيب الاعمام و الاخوال
                calculateUnclesAndAunts(data, oConstants);

            } else if (OConstants.getBrothersCount(data) + OConstants.getSistersCount(data) >= 3) { // ثلاثة اخوة فأكثر
                // نصيب الاخوة = كل التركة
                int brotherAndSistersCount = OConstants.getSistersCount(data) + (OConstants.getBrothersCount(data) * 2);

                Fraction sistersFraction = Fraction.divideFraction(OConstants.one, new Fraction(brotherAndSistersCount, 1));
                Fraction brothersFraction = Fraction.multiplyFraction(sistersFraction, new Fraction(2, 1));

                OConstants.setPersonSharePercent(data, brothersFraction, OConstants.PERSON_BROTHER);
                OConstants.setPersonSharePercent(data, sistersFraction, OConstants.PERSON_SISTER);

                // نصيب الولد = 2 * نصيب البنت
            } else if (OConstants.getBrothersCount(data) + OConstants.getSistersCount(data) == 0) {
                //لا يوجد اخوة
                noBrothersCondition(data, oConstants);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void calculateUnclesAndAunts(ArrayList<Person> data, OConstants oConstants) {
        try {
            // TODO
            // نصيب الاعمام = 1/2 الباقي
            int fatherUnclesAndAuntsCount = OConstants.getPersonCount(data, OConstants.PERSON_FATHER_AUNT) + (OConstants.getPersonCount(data, OConstants.PERSON_FATHER_UNCLE) * 2);

            Fraction auntsFraction = Fraction.divideFraction(OConstants.half, new Fraction(fatherUnclesAndAuntsCount, 1));
            Fraction unclesFraction = Fraction.multiplyFraction(auntsFraction, new Fraction(2, 1));

            OConstants.setPersonSharePercent(data, auntsFraction, OConstants.PERSON_FATHER_AUNT);
            OConstants.setPersonSharePercent(data, unclesFraction, OConstants.PERSON_FATHER_UNCLE);

            // TODO
            // نصيب الاخوال = 1/2 الباقي
            int motherUnclesAndAuntsCount = OConstants.getSistersCount(data) + (OConstants.getBrothersCount(data) * 2);

            auntsFraction = Fraction.divideFraction(OConstants.half, new Fraction(motherUnclesAndAuntsCount, 1));
            unclesFraction = Fraction.multiplyFraction(auntsFraction, new Fraction(2, 1));

            OConstants.setPersonSharePercent(data, auntsFraction, OConstants.PERSON_MOTHER_AUNT);
            OConstants.setPersonSharePercent(data, unclesFraction, OConstants.PERSON_MOTHER_UNCLE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void noBrothersCondition(ArrayList<Person> data, OConstants oConstants) {

        // نصيب الاعمام = 2/3 التركة

        int fatherUnclesAndAuntsCount = OConstants.getPersonCount(data, OConstants.PERSON_FATHER_AUNT) + (OConstants.getPersonCount(data, OConstants.PERSON_FATHER_UNCLE) * 2);

        Fraction auntsFraction = Fraction.divideFraction(OConstants.two_Thirds, new Fraction(fatherUnclesAndAuntsCount, 1));
        Fraction unclesFraction = Fraction.multiplyFraction(auntsFraction, new Fraction(2, 1));

        OConstants.setPersonSharePercent(data, auntsFraction, OConstants.PERSON_FATHER_AUNT);
        OConstants.setPersonSharePercent(data, unclesFraction, OConstants.PERSON_FATHER_UNCLE);
        OConstants.setPersonSharePercent(data, OConstants.two_Thirds, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS); // نصيب الاعمام = 2/3 التركة

        // نصيب الاخوال = 1/3 التركة
        int motherUnclesAndAuntsCount = OConstants.getSistersCount(data) + (OConstants.getBrothersCount(data) * 2);

        auntsFraction = Fraction.divideFraction(OConstants.one_Third, new Fraction(motherUnclesAndAuntsCount, 1));
        unclesFraction = Fraction.multiplyFraction(auntsFraction, new Fraction(2, 1));

        OConstants.setPersonSharePercent(data, auntsFraction, OConstants.PERSON_MOTHER_AUNT);
        OConstants.setPersonSharePercent(data, unclesFraction, OConstants.PERSON_MOTHER_UNCLE);

        OConstants.setPersonSharePercent(data, OConstants.one_Third, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS);// نصيب الاخوال = 1/3 التركة

    }
}
