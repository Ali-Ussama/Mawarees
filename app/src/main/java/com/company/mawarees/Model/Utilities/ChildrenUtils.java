package com.company.mawarees.Model.Utilities;

import com.company.mawarees.Model.Models.Fraction;
import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;

import java.util.ArrayList;

public class ChildrenUtils {

    public static ArrayList<Person> calculateChildren(ArrayList<Person> data, OConstants oConstants) {


        //يوجد فرع وارث
        if (oConstants.isHasChildren()) {
            int daughters = OConstants.getChildrenInDaughters(data);

            if (daughters == 1) {

                // نصيب البنت 1/2
                OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_DAUGHTER); // نصيب البنت

            } else if (daughters == 2) {

                // نصيب البنتن = 14/24
                // نصيب البنت = نصيب البنتين/2 = 14/48
                if (OConstants.getDaughtersCount(data) == 2) {
                    OConstants.setPersonSharePercent(data, OConstants.fourteenth_FourtyEighth, OConstants.PERSON_DAUGHTER); // نصيب البنتين = 14/48

                } else if (OConstants.getSonsCount(data) == 1) {
                    OConstants.setPersonSharePercent(data, OConstants.fourteenth_TwentyFourth, OConstants.PERSON_SON); // نصيب الولد = 14/24
                }
            } else if (daughters > 2) {
                // نصيب البنات = 2/3
                // نصيب البنت = نصيب البنت / عدد البنات
                // نصيب الولد = نصيب البنت * 2
                Fraction daughterFraction = Fraction.divideFraction(OConstants.two_Thirds, new Fraction(daughters, 1));
                Fraction sonsFraction = Fraction.multiplyFraction(daughterFraction, new Fraction(2, 1));
                OConstants.setPersonSharePercent(data, sonsFraction, OConstants.PERSON_SON); // نصيب الولد
                OConstants.setPersonSharePercent(data, daughterFraction, OConstants.PERSON_DAUGHTER); // نصيب البنت

                OConstants.setPersonSharePercent(data, OConstants.two_Thirds, OConstants.PERSON_More_Than_three_SISTERS); //نصيب البنات = 2/3
            }
        }
        return data;
    }
}
