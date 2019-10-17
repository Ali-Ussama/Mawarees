package com.company.mawarees.Model.Utilities;

import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;

import java.util.ArrayList;

public class MotherUtilis {

    public static ArrayList<Person> calculateMother(ArrayList<Person> data, OConstants oConstants) {

        //توجد ام
        if (oConstants.isHasMother()) {

            // يوجد فرع وارث
            if (oConstants.isHasChildren()) {

                // نصيب الام = 1/6
                // نصيب الاب = 1/6
                OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_FATHER);
                OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_MOTHER);

            } else { // لا يوجد فرع وارث

                // يوجد اب
                if (oConstants.isHasFather()) {
                    //TODO
                    //الباقي مناصفة بين الاب و الام بعد استيفاء اصحاب الفروض ( زوج / زوجه )
                    OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_FATHER);
                    OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_MOTHER);
                } else { // لا يوجد اب
                    // يوجد جدود لاب
                    if (oConstants.isHasFather_GrandFather() || oConstants.isHasFather_GrandMother()) {
                        // TODO
                        //نصيب الام الباقي بعد استيفاء اصحاب الفروض

                    } else {
                        // لا يوجد جدود لاب
                        // يوجد جمع اخوة
                        if (oConstants.isHasBrothersAndSisters() && OConstants.hasMoreThreeBrothersAndSisters(data)) {

                            // نصيب الام = 1/6
                            // نصيب الاب = 5/6
                            OConstants.setPersonSharePercent(data, OConstants.fifth_Sixth, OConstants.PERSON_FATHER);
                            OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_MOTHER);

                        } else {

                            // نصيب الام = 1/3
                            // نصيب الاب = 2/3
                            OConstants.setPersonSharePercent(data, OConstants.two_Thirds, OConstants.PERSON_FATHER);
                            OConstants.setPersonSharePercent(data, OConstants.one_Third, OConstants.PERSON_MOTHER);
                        }
                    }
                }
            }

        } else { // لا توجد ام

            //يوجد جد او جدة لأم
            if (oConstants.isHasMother_GrandFather() || oConstants.isHasMother_GrandMother()) {
                // نصيب الجدين معا = 1/6
                if (oConstants.isHasMother_GrandFather() && oConstants.isHasMother_GrandMother()) {
                    OConstants.setPersonSharePercent(data, OConstants.one_Twelve, OConstants.PERSON_MOTHER_GRANDFATHER);
                    OConstants.setPersonSharePercent(data, OConstants.one_Twelve, OConstants.PERSON_MOTHER_GRANDMOTHER);

                } else if (oConstants.isHasMother_GrandFather() && !oConstants.isHasMother_GrandMother()) {
                    OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_MOTHER_GRANDFATHER); // نصيب جد لاب = 1/6

                } else if (!oConstants.isHasMother_GrandFather() && oConstants.isHasMother_GrandMother()) {
                    OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_MOTHER_GRANDMOTHER);// نصيب جدة لاب = 1/6
                }

            } else {
                // لا يوجد جد او جدة لأم

                // حساب نصيب الاب
                FatherUtils.calculateFather(data, oConstants);
            }
        }

        return data;
    }

}