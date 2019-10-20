package com.company.mawarees.Model.Utilities;

import android.util.Log;

import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;

import java.util.ArrayList;


public class FatherUtils {
    private static final String TAG = "FatherUtils";

    public static void calculateFather(ArrayList<Person> data, OConstants oConstants) {

        //توجد اب
        if (oConstants.isHasFather()) {
            Log.i(TAG, "calculateFather(): has Father");

            // يوجد فرع وارث
            if (oConstants.isHasChildren()) {
                Log.i(TAG, "calculateFather(): has Children");

                // نصيب الام = 1/6
                // نصيب الاب = 1/6
                OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_FATHER);
                OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_MOTHER);

                Log.i(TAG, "calculateFather(): Father share = 1/6 ");
                Log.i(TAG, "calculateFather(): Mother share = 1/6 ");

            } else { // لا يوجد فرع وارث

                // يوجد ام
                if (oConstants.isHasMother()) {

                    Log.i(TAG, "calculateFather(): has No Children");

                    //TODO
                    //الباقي مناصفة بين الاب و الام بعد استيفاء اصحاب الفروض ( زوج / زوجه )
                    OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_FATHER);
                    OConstants.setPersonSharePercent(data, OConstants.half, OConstants.PERSON_MOTHER);

                    Log.i(TAG, "calculateFather(): Father and mother takes the rest 50/50");

                } else { // لا يوجد ام
                    Log.i(TAG, "calculateFather(): has No Mother");


                    // يوجد جدود لام
                    if (oConstants.isHasMother_GrandFather() || oConstants.isHasMother_GrandMother()) {

                        Log.i(TAG, "calculateFather(): has Mother_GrandPa Or Mother_GrandMa");

                        // TODO
                        //نصيب الاب الباقي بعد استيفاء اصحاب الفروض
                        OConstants.setPersonSharePercent(data, null, OConstants.PERSON_FATHER);
                        Log.i(TAG, "calculateFather(): Father takes the rest");

                    } else {
                        // لا يوجد جدود لام
                        Log.i(TAG, "calculateFather(): has No Mother_GrandPa And Mother_GrandMa");


                        // يوجد جمع اخوة
                        if (oConstants.isHasBrothersAndSisters() && OConstants.hasMoreThreeBrothersAndSisters(data)) {
                            Log.i(TAG, "calculateFather(): has  More Three Brothers And Sisters");

                            // نصيب الام = 1/6
                            // نصيب الاب = 5/6
                            OConstants.setPersonSharePercent(data, OConstants.fifth_Sixth, OConstants.PERSON_FATHER);
                            OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_MOTHER);

                            Log.i(TAG, "calculateFather(): Mother Takes 1/6 & Father Takes 5/6");

                        } else {
                            Log.i(TAG, "calculateFather(): has No More Three Brothers And Sisters");


                            // نصيب الام = 1/3
                            // نصيب الاب = 2/3
                            OConstants.setPersonSharePercent(data, OConstants.two_Thirds, OConstants.PERSON_FATHER);
                            OConstants.setPersonSharePercent(data, OConstants.one_Third, OConstants.PERSON_MOTHER);


                            Log.i(TAG, "calculateFather(): Mother Takes 1/3 & Father Takes 2/3");

                        }
                    }
                }
            }

        } else { // لا يوجد اب

            Log.i(TAG, "calculateFather(): has No Father");

            //يوجد جد او جدة لأب
            if (oConstants.isHasFather_GrandFather() || oConstants.isHasFather_GrandMother()) {
                Log.i(TAG, "calculateFather(): has Father_GrandPa Or Father_GrandMa");

                // نصيب الجدين معا = 1/6
                if (oConstants.isHasFather_GrandFather() && oConstants.isHasFather_GrandMother()) {
                    Log.i(TAG, "calculateFather(): has Father_GrandPa And Father_GrandMa");

                    OConstants.setPersonSharePercent(data, OConstants.one_Twelve, OConstants.PERSON_FATHER_GRANDFATHER); // نصيب جد لاب = 1/12
                    OConstants.setPersonSharePercent(data, OConstants.one_Twelve, OConstants.PERSON_FATHER_GRANDMOTHER);// نصيب جدة لاب = 1/12
                    Log.i(TAG, "calculateFather(): Father_GrandPa Takes 1/12 And Father_GrandMa Takes 1/12");

                } else if (oConstants.isHasFather_GrandFather() && !oConstants.isHasFather_GrandMother()) {
                    Log.i(TAG, "calculateFather(): has Father_GrandPa And Father_GrandMa");

                    OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_FATHER_GRANDFATHER); // نصيب جد لاب = 1/6
                    Log.i(TAG, "calculateFather(): Father_GrandPa Takes 1/6");

                } else if (!oConstants.isHasFather_GrandFather() && oConstants.isHasFather_GrandMother()) {
                    Log.i(TAG, "calculateFather(): has Father_GrandMa");

                    OConstants.setPersonSharePercent(data, OConstants.one_Sixth, OConstants.PERSON_FATHER_GRANDMOTHER);// نصيب جدة لاب = 1/6
                    Log.i(TAG, "calculateFather(): Father_GrandMa Takes 1/6");

                }
            }
        }

    }


}
