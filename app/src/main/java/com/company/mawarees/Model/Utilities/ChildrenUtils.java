package com.company.mawarees.Model.Utilities;

import com.company.mawarees.Model.Models.Fraction;
import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;

import java.util.ArrayList;

public class ChildrenUtils {

    private static int daughtersNumber;

    public static ArrayList<Person> calculateChildren(ArrayList<Person> data, OConstants oConstants) {

        daughtersNumber = getChildrenInDaughters(data);

        //يوجد فرع وارث
        if (oConstants.isHasChildren()) {
            int daughters = getChildrenInDaughters(data);

            if (daughters == 1) {

                // نصيب البنت 1/2
                setDaughtersSharePercent(data, OConstants.half);

            } else if (daughters == 2) {

                // نصيب البنتن = 14/24
                // نصيب البنت = نصيب البنتين/2 = 14/48
                if (OConstants.getDaughtersCount(data) == 2) {
                    setDaughtersSharePercent(data, OConstants.fourteenth_FourtyEighth);
                } else if (OConstants.getSonsCount(data) == 1) {
                    setSonsSharePercent(data, OConstants.fourteenth_TwentyFourth);
                }
            } else if (daughters > 2) {
                // نصيب البنات = 2/3
                // نصيب البنت = نصيب البنت / عدد البنات
                // نصيب الولد = نصيب البنت * 2
                Fraction daughterFraction = Fraction.divideFraction(OConstants.two_Thirds, new Fraction(daughters, 1));
                Fraction sonsFraction = Fraction.multiplyFraction(daughterFraction, new Fraction(2, 1));
                data = setSonsSharePercent(data, sonsFraction);
                data = setDaughtersSharePercent(data, daughterFraction);
            }
        }
        return data;
    }

    private static int getChildrenInDaughters(ArrayList<Person> data) {
        boolean isHasChildren = false;

        int sonsCount = 0, daughtersCount = 0, sonNephew = 0, sonNiece = 0, daughterNephew = 0, daughterNiece = 0;

        int sum = 0;

        for (Person mData : data) {

            if (mData.getRelation().matches(OConstants.PERSON_SON)) {
                isHasChildren = true;
                sonsCount = mData.getCount();
            } else if (mData.getRelation().matches(OConstants.PERSON_DAUGHTER)) {
                isHasChildren = true;
                daughtersCount = mData.getCount();
            }
        }

        if (isHasChildren) {

            if (sonsCount > 0) {

                sum += sonsCount * 2;

            }

            if (daughtersCount > 0) {

                sum += daughtersCount;

            }
        }

        return sum;
    }

    private static ArrayList<Person> setSonsSharePercent(ArrayList<Person> data, Fraction fraction) {

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getRelation().matches(OConstants.PERSON_SON)) {
                data.get(i).setSharePercent(fraction);
            }
        }
        return data;
    }

    private static ArrayList<Person> setDaughtersSharePercent(ArrayList<Person> data, Fraction fraction) {

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getRelation().matches(OConstants.PERSON_DAUGHTER)) {
                data.get(i).setSharePercent(fraction);
            }
        }
        return data;
    }
}
