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
                                    data = setBrothersSharePercent(data, OConstants.one_Sixth);
                                } else if (OConstants.getSistersCount(data) == 1) {
                                    data = setSistersSharePercent(data, OConstants.one_Sixth);
                                }
                            } else {
                                // شركاء في الثلث
                                // كل على حسب النصيب ( ولد = 2 * البنت )
                                Fraction sistersFraction = Fraction.divideFraction(OConstants.one_Third, new Fraction(sistersNumber, 1));
                                Fraction brothersFraction = Fraction.multiplyFraction(sistersFraction, new Fraction(2, 1));
                                data = setBrothersSharePercent(data, brothersFraction);
                                data = setSistersSharePercent(data, sistersFraction);
                            }
                        }

                    } else {
                        // يوجد اب او ام
                        // محجوبين لوجود اب او ام او كلاهما
                    }

                } else {
                    // يوجد اولاد
                    // محجوبين ل وجود فرع وارث
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
            } else if (OConstants.getSistersCount(data) == 1 && OConstants.getBrothersCount(data) == 0) { // اخت واحدة
                // نصيب الاخت = 1/2
                //حساب نصيب الاعمام و الاخوال
                calculateUnclesAndAunts(data, oConstants);
            } else if (OConstants.getSistersCount(data) == 2 && OConstants.getBrothersCount(data) == 0) { // اختين
                // نصيب الاختين = 2/3
                //حساب نصيب الاعمام و الاخوال
                calculateUnclesAndAunts(data, oConstants);

            } else if (OConstants.getBrothersCount(data) + OConstants.getSistersCount(data) >= 3) { // ثلاثة اخوة فأكثر
                // نصيب الاخوة = كل التركة
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
            // نصيب الاعمام = 1/2 الباقي
            // نصيب الاخوال = 1/2 الباقي
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void noBrothersCondition(ArrayList<Person> data, OConstants oConstants) {

        // نصيب الاعمام = 2/3 التركة
        // نصيب الاخوال = 1/3 التركة

    }

    private static ArrayList<Person> setBrothersSharePercent(ArrayList<Person> data, Fraction fraction) {

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getRelation().matches(OConstants.PERSON_BROTHER)) {
                data.get(i).setSharePercent(fraction);
            }
        }
        return data;
    }

    private static ArrayList<Person> setSistersSharePercent(ArrayList<Person> data, Fraction fraction) {

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getRelation().matches(OConstants.PERSON_SISTER)) {
                data.get(i).setSharePercent(fraction);
            }
        }
        return data;
    }
}
