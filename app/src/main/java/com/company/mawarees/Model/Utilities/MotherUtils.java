package com.company.mawarees.Model.Utilities;

import android.util.Log;

import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;

import java.util.ArrayList;

public class MotherUtils {

    private static final String TAG = "MotherUtils";

    public static void calculateMother(ArrayList<Person> data, OConstants oConstants) {

        //توجد ام
        if (oConstants.isHasMother()) {
            Log.i(TAG, "calculateMother(): has Mother");

            // يوجد فرع وارث
            if (oConstants.isHasChildren()) {
                Log.i(TAG, "calculateMother(): has Children");

                // نصيب الام = 1/6
                // نصيب الاب = 1/6
                OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_FATHER);
                OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_MOTHER);

                Log.i(TAG, "calculateMother(): Father share = 1/6 ");
                Log.i(TAG, "calculateMother(): Mother share = 1/6 ");


            } else { // لا يوجد فرع وارث
                Log.i(TAG, "calculateMother(): has No Children");

                // يوجد اب
                if (oConstants.isHasFather()) {
                    Log.i(TAG, "calculateMother(): has Father");

                    //TODO
                    //الباقي مناصفة بين الاب و الام بعد استيفاء اصحاب الفروض ( زوج / زوجه )
                    OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_FATHER);
                    OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_MOTHER);

                    Log.i(TAG, "calculateMother(): Father and mother takes the rest 50/50");

                } else { // لا يوجد اب

                    Log.i(TAG, "calculateMother(): has No Father");

                    // يوجد جدود لاب
                    if (oConstants.isHasFather_GrandFather() || oConstants.isHasFather_GrandMother()) {

                        Log.i(TAG, "calculateMother(): has Father_GrandPa Or Father_GrandMa");

                        // TODO
                        //نصيب الام الباقي بعد استيفاء اصحاب الفروض
                        OConstants.setPersonSharePercent(data, null, OConstants.PERSON_MOTHER);

                        Log.i(TAG, "calculateMother(): Mother takes the rest");

                    } else {
                        // لا يوجد جدود لاب
                        Log.i(TAG, "calculateMother(): has No Father_GrandPa And Father_GrandMa");


                        // يوجد جمع اخوة
                        if (oConstants.isHasBrothersAndSisters() && OConstants.hasMoreThreeBrothersAndSisters(data)) {
                            Log.i(TAG, "calculateMother(): has  More Three Brothers And Sisters");

                            // نصيب الام = 1/6
                            // نصيب الاب = 5/6
                            OConstants.setPersonSharePercent(data, OConstants.fifth_Sixth, OConstants.PERSON_FATHER);
                            OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_MOTHER);

                            Log.i(TAG, "calculateMother(): Mother Takes 1/6 & Father Takes 5/6");
                        } else {
                            Log.i(TAG, "calculateMother(): has No More Three Brothers And Sisters");

                            // نصيب الام = 1/3
                            // نصيب الاب = 2/3
                            OConstants.setPersonSharePercent(data, OConstants.two_Thirds, OConstants.PERSON_FATHER);
                            OConstants.setPersonSharePercent(data, OConstants.one_Third, OConstants.PERSON_MOTHER);

                            Log.i(TAG, "calculateMother(): Mother Takes 1/3 & Father Takes 2/3");

                        }
                    }
                }
            }

        } else { // لا توجد ام
            Log.i(TAG, "calculateMother(): No has Mother");

            //يوجد جد او جدة لأم
            if (oConstants.isHasMother_GrandFather() || oConstants.isHasMother_GrandMother()) {
                Log.i(TAG, "calculateMother(): has Mother_GrandPa Or Mother_GrandMa");


                // نصيب الجدين معا = 1/6
                if (oConstants.isHasMother_GrandFather() && oConstants.isHasMother_GrandMother()) {
                    Log.i(TAG, "calculateMother(): has Mother_GrandPa And Mother_GrandMa");

                    OConstants.setPersonSharePercent(data, OConstants.one_Twelve, OConstants.PERSON_MOTHER_GRANDFATHER);
                    OConstants.setPersonSharePercent(data, OConstants.one_Twelve, OConstants.PERSON_MOTHER_GRANDMOTHER);
                    Log.i(TAG, "calculateMother(): Mother_GrandPa Takes 1/12 And Mother_GrandMa Takes 1/12");

                } else if (oConstants.isHasMother_GrandFather() && !oConstants.isHasMother_GrandMother()) {
                    Log.i(TAG, "calculateMother(): has Mother_GrandPa And Mother_GrandMa");

                    OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_MOTHER_GRANDFATHER); // نصيب جد لأم = 1/6
                    Log.i(TAG, "calculateMother(): Mother_GrandPa Takes 1/6");

                } else if (!oConstants.isHasMother_GrandFather() && oConstants.isHasMother_GrandMother()) {
                    Log.i(TAG, "calculateMother(): has Mother_GrandMa");

                    OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_MOTHER_GRANDMOTHER);// نصيب جدة لأم = 1/6
                    Log.i(TAG, "calculateMother(): Mother_GrandMa Takes 1/6");

                }

            }
        }
    }

}
