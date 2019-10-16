package com.company.mawarees.Model.Utilities;

import com.company.mawarees.Model.Models.Fraction;
import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;

import java.util.ArrayList;

public class MotherUtilis {

    public static ArrayList<Person> calculateMotherAndFather(ArrayList<Person> data, OConstants oConstants) {

        //توجد ام
        if (oConstants.isHasMother()) {

            // يوجد فرع وارث
            if (oConstants.isHasChildren()) {

                // نصيب الام = 1/6
                // نصيب الاب = 1/6
                data = setFatherSharePercent(data, OConstants.one_Sixth);
                data = setMotherSharePercent(data, OConstants.one_Sixth);

            } else { // لا يوجد فرع وارث

                // يوجد اب
                if (oConstants.isHasFather()) {
                    // الباقي مناصفة بين الاب و الام بعد استيفاء اصحاب الفروض ( زوج / زوجه )

                } else { // لا يوجد اب
                    // يوجد جدود لاب
                    if (oConstants.isHasFather_GrandFather() || oConstants.isHasFather_GrandMother()) {
                        // نصيب الام الباقي بعد استيفاء اصحاب الفروض
                    } else {
                        // لا يوجد جدود لاب
                        // يوجد جمع اخوة
                        if (oConstants.isHasBrothersAndSisters() && OConstants.hasMoreThreeBrothersAndSisters(data)) {
                            // نصيب الام = 1/3
                            // نصيب الاب = 2/3

                            data = setFatherSharePercent(data, OConstants.two_Thirds);
                            data = setMotherSharePercent(data, OConstants.one_Third);
                        } else {
                            // نصيب الام = 1/6
                            // نصيب الاب = 5/6
                            data = setFatherSharePercent(data, OConstants.one_Sixth);
                            data = setMotherSharePercent(data, OConstants.fifth_Sixth);
                        }
                    }
                }

            }

        } else { // لا توجد ام

            //يوجد جد او جدة لأم
            if (oConstants.isHasMother_GrandFather() || oConstants.isHasMother_GrandMother()) {
                // نصيب الجدين معا = 1/6
            } else {
                // لا يوجد جد او جدة لأم
            }
        }

        return data;
    }

    private static ArrayList<Person> setMotherSharePercent(ArrayList<Person> data, Fraction fraction) {

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getRelation().matches(OConstants.PERSON_MOTHER)) {
                data.get(i).setSharePercent(fraction);
            }
        }
        return data;
    }

    private static ArrayList<Person> setFatherSharePercent(ArrayList<Person> data, Fraction fraction) {

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getRelation().matches(OConstants.PERSON_FATHER)) {
                data.get(i).setSharePercent(fraction);
            }
        }
        return data;
    }


}
