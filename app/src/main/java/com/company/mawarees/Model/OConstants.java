package com.company.mawarees.Model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.company.mawarees.Model.Models.ExplainPhase2;
import com.company.mawarees.Model.Models.ExplainPhase3;
import com.company.mawarees.Model.Models.ExplainPhase4;
import com.company.mawarees.Model.Models.ExplanationModel;
import com.company.mawarees.Model.Models.Fraction;
import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.Utilities.HandleTwoGroupsUtils;
import com.company.mawarees.PrefManager;

import java.util.ArrayList;
import java.util.Collections;

public class OConstants implements Parcelable {

    private static final String TAG = "OConstants";

    public boolean isHandleChildrenGroup = false;
    public boolean isHandleBrothersGroup = false;
    public boolean isHandleWivesGroup = false;
    public boolean isHandleUnclesGroup = false;
    public String handleGroupParent = "";
    public ExplanationModel mExplanation;
    public PrefManager mPrefManager;
    private Context mContext;

    public OConstants(Context context) {
        this.mContext = context;
        this.mPrefManager = new PrefManager(context);
        this.mExplanation = new ExplanationModel();
    }


    public static final int Children_ID = 1;
    public static final int SON_ID = 2;
    public static final int DAUGHTER_ID = 3;

    public static final int WIVES_ID = 4;
    public static final int WIFE_ID = 5;
    public static final int HUSBAND_ID = 6;

    public static final int FATHER_ID = 7;
    public static final int MOTHER_ID = 8;
    public static final int FATHER_GRANDFATHER_GRANDMOTHER_ID = 9;
    public static final int MOTHER_GRANDFATHER_GRANDMOTHER_ID = 10;

    public static final int BROTHERS_ID = 11;
    public static final int BROTHER_ID = 12;
    public static final int SISTER_ID = 13;

    public static final int FATHER_UNCLES_AND_AUNTS_ID = 14;
    public static final int FATHER_UNCLE_ID = 15;
    public static final int FATHER_AUNT_ID = 16;

    public static final int MOTHER_UNCLES_AND_AUNTS_ID = 17;
    public static final int MOTHER_UNCLE_ID = 18;
    public static final int MOTHER_AUNT_ID = 19;

    public static final int DEAD_SON_CHILDREN_ID = 20;
    public static final int DEAD_SON_BOY_ID = 21;
    public static final int DEAD_SON_GIRL_ID = 22;

    public static final int DEAD_DAUGHTER_CHILDREN_ID = 23;
    public static final int DEAD_DAUGHTER_BOY_ID = 24;
    public static final int DEAD_DAUGHTER_GIRL_ID = 25;

    public static final String BLOCKED = "Blocked";
    public static final String NOT_BLOCKED = "NotBlocked";
    public static final String CHILDREN = "الأولاد";

    public static final String PERSON_FATHER = "الوالد";
    public static final String PERSON_FATHER_GRANDFATHER = "الجد لوالد";
    public static final String PERSON_FATHER_GRANDMOTHER = "الجدة لوالد";
    public static final String PERSON_FATHER_UNCLE = "العم";
    public static final String PERSON_FATHER_UNCLES = "الأعمام";
    public static final String PERSON_FATHER_AUNT = "العمة";
    public static final String PERSON_FATHER_AUNTS = "العمات";
    public static final String PERSON_FATHER_UNCLES_AND_AUNTS = "الأعمام";

    public static final String PERSON_MOTHER = "الوالدة";
    public static final String PERSON_MOTHER_GRANDFATHER = "الجد لوالدة";
    public static final String PERSON_MOTHER_GRANDMOTHER = "الجدة لوالدة";
    public static final String PERSON_MOTHER_UNCLE = "الخال";
    public static final String PERSON_MOTHER_AUNT = "الخالة";
    public static final String PERSON_MOTHER_UNCLES = "الأخوال";
    public static final String PERSON_MOTHER_AUNTS = "الخالات";
    public static final String PERSON_MOTHER_UNCLES_AND_AUNTS = "الأخوال";

    public static final String PERSON_SON = "الولد الذكر";
    public static final String PERSON_SONS = "ابناء";
    public static final String PERSON_TWO_SONS = "الابنين";
    public static final String PERSON_SON_CHILDREN = "اولاد لولد ذكر";
    public static final String PERSON_SON_BOY = "ابن لولد ذكر";
    public static final String PERSON_SON_GIRL = "بنت لولد ذكر";


    public static final String PERSON_DAUGHTER = "الولد الانثى";
    public static final String PERSON_DAUGHTERS = "بنات";
    public static final String PERSON_TWO_DAUGHTERS = "البنتين";
    public static final String PERSON_DAUGHTER_CHILDREN = "اولاد لولد انثي";
    public static final String PERSON_DAUGHTER_BOY = "ابن لولد انثي";
    public static final String PERSON_DAUGHTER_GIRL = "بنت لود انثى";
    public static final String PERSON_CHILDREN = "الاولاد";

    public static final String PERSON_BROTHER = "الأخ";
    public static final String PERSON_BROTHERS = "الاخوة";
    public static final String PERSON_TWO_BROTHERS = "الأخين";
    public static final String PERSON_SISTER = "الأخت";
    public static final String PERSON_SISTERS = "الاخوات";
    public static final String PERSON_TWO_SISTERS = "الأختان";

    //    public static final String PERSON_More_Than_three_DAUGHTERS = "أكثر من ثلاثة بنات";
    public static final String PERSON_More_Than_three_DAUGHTERS = "الأولاد";
    //    public static final String PERSON_MORE_THAN_BROTHER_OR_SISTER = "أكثر من أخ";
    public static final String PERSON_MORE_THAN_BROTHER_OR_SISTER = "الأخوة";
    //    public static final String PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER = "جمع أخوة";
    public static final String PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER = "الاخوة";


    public static final String PERSON_HUSBAND = "الزوج";
    public static final String PERSON_WIFE = "الزوجة";
    public static final String PERSON_MORE_THAN_WIFE = "اكثر من زوجة";

    public static final String PERSON_TWO_WIVES = "الزوجتان";
    public static final String PERSON_WIVES = "زوجات";

    public static final String GENDER_MALE = "ذكر";
    public static final String GENDER_FEMALE = "أنثى";

    /*------------------------------------------------ النسب -------------------------------------*/

    public static final Fraction one = new Fraction(24, 24); // واحد صحيح

    public static final Fraction half = new Fraction(12, 24); // النصف

    public static final Fraction quarter = new Fraction(6, 24); // الربع

    public static final Fraction one_Third = new Fraction(8, 24); // الثلث

    public static final Fraction two_Thirds = new Fraction(16, 24); // الثلثين

    public static final Fraction one_Sixth = new Fraction(4, 24); // السدس

    public static final Fraction fifth_Sixth = new Fraction(20, 24); // خمسة أسداس

    public static final Fraction one_eighth = new Fraction(3, 24); // ثمن

    public static final Fraction fourteenth_TwentyFourth = new Fraction(14, 24); // 14/24

    public static final Fraction seventh_TwentyFourth = new Fraction(7, 24); // 7/24

    public static final Fraction one_Twelve = new Fraction(2, 24); // 1/12

    /*--------------------------------------------------------------------------------------------*/
    private static int validPeopleCount = 0;

    private double totalMoney;

    private static double remain;

    private String gender;

    private int wivesCount;

    private boolean hasChildren;

    private boolean hasWife;

    private boolean hasHusband;

    private boolean hasFather;

    private boolean hasMother;

    private boolean hasMother_GrandMother;

    private boolean hasMother_GrandFather;

    private boolean hasFather_GrandFather;

    private boolean hasFather_GrandMother;

    private boolean hasBrothersAndSisters;


    protected OConstants(Parcel in) {
        isHandleChildrenGroup = in.readByte() != 0;
        isHandleBrothersGroup = in.readByte() != 0;
        isHandleWivesGroup = in.readByte() != 0;
        isHandleUnclesGroup = in.readByte() != 0;
        handleGroupParent = in.readString();
        mExplanation = in.readParcelable(ExplanationModel.class.getClassLoader());
        totalMoney = in.readDouble();
        gender = in.readString();
        wivesCount = in.readInt();
        hasChildren = in.readByte() != 0;
        hasWife = in.readByte() != 0;
        hasHusband = in.readByte() != 0;
        hasFather = in.readByte() != 0;
        hasMother = in.readByte() != 0;
        hasMother_GrandMother = in.readByte() != 0;
        hasMother_GrandFather = in.readByte() != 0;
        hasFather_GrandFather = in.readByte() != 0;
        hasFather_GrandMother = in.readByte() != 0;
        hasBrothersAndSisters = in.readByte() != 0;
    }

    public static final Creator<OConstants> CREATOR = new Creator<OConstants>() {
        @Override
        public OConstants createFromParcel(Parcel in) {
            return new OConstants(in);
        }

        @Override
        public OConstants[] newArray(int size) {
            return new OConstants[size];
        }
    };

    public int getWivesCount() {
        return wivesCount;
    }

    public void setWivesCount(int wivesCount) {
        this.wivesCount = wivesCount;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public boolean isHasBrothersAndSisters() {
        return hasBrothersAndSisters;
    }

    public void setHasBrothersAndSisters(boolean hasBrothersAndSisters) {
        this.hasBrothersAndSisters = hasBrothersAndSisters;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public boolean isHasWife() {
        return hasWife;
    }

    public void setHasWife(boolean hasWife) {
        this.hasWife = hasWife;
    }

    public boolean isHasHusband() {
        return hasHusband;
    }

    public void setHasHusband(boolean hasHusband) {
        this.hasHusband = hasHusband;
    }

    public boolean isHasFather() {
        return hasFather;
    }

    public void setHasFather(boolean hasFather) {
        this.hasFather = hasFather;
    }

    public boolean isHasMother() {
        return hasMother;
    }

    public void setHasMother(boolean hasMother) {
        this.hasMother = hasMother;
    }

    public boolean isHasMother_GrandMother() {
        return hasMother_GrandMother;
    }

    public void setHasMother_GrandMother(boolean hasMother_GrandMother) {
        this.hasMother_GrandMother = hasMother_GrandMother;
    }

    public boolean isHasMother_GrandFather() {
        return hasMother_GrandFather;
    }

    public void setHasMother_GrandFather(boolean hasMother_GrandFather) {
        this.hasMother_GrandFather = hasMother_GrandFather;
    }

    public boolean isHasFather_GrandFather() {
        return hasFather_GrandFather;
    }

    public void setHasFather_GrandFather(boolean hasFather_GrandFather) {
        this.hasFather_GrandFather = hasFather_GrandFather;
    }

    public boolean isHasFather_GrandMother() {
        return hasFather_GrandMother;
    }

    public void setHasFather_GrandMother(boolean hasFather_GrandMother) {
        this.hasFather_GrandMother = hasFather_GrandMother;
    }

    public ExplanationModel getmExplanation() {
        return mExplanation;
    }

    public void setmExplanation(ExplanationModel mExplanation) {
        this.mExplanation = mExplanation;
    }

    /*--------------------------------------------------------------------------------------------*/

    public static boolean hasMoreThreeBrothersAndSisters(ArrayList<Person> data) {
        int brothers = 0, sisters = 0;

        try {
            for (Person mData : data) {
                if (mData.getRelation().matches(OConstants.PERSON_BROTHER)) {
                    brothers = mData.getCount();
                } else if (mData.getRelation().matches(OConstants.PERSON_SISTER)) {
                    sisters = mData.getCount();
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return (brothers + sisters) >= 3;
    }

    public static int getBrothersCount(ArrayList<Person> data) {
        int brothers = 0;

        try {
            for (Person mData : data) {
                if (mData.getRelation().matches(OConstants.PERSON_BROTHER)) {
                    brothers = mData.getCount();
                    break;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return brothers;
    }

    public static int getSistersCount(ArrayList<Person> data) {
        int sisters = 0;

        try {

            for (Person mData : data) {
                if (mData.getRelation().matches(OConstants.PERSON_SISTER)) {
                    sisters = mData.getCount();
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sisters;
    }

    public static int getSonsCount(ArrayList<Person> data) {
        int sons = 0;
        try {
            for (Person mData : data) {
                if (mData.getRelation().matches(OConstants.PERSON_SON)) {
                    sons++;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return sons;
    }

    public static int getDaughtersCount(ArrayList<Person> data) {
        int daughters = 0;
        try {
            for (Person mData : data) {
                if (mData.getRelation().matches(OConstants.PERSON_DAUGHTER)) {
                    daughters++;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return daughters;
    }

    public static int getPersonCount(ArrayList<Person> data, String relation) {
        int person = 0;
        try {
            for (Person mData : data) {
                if (mData.getRelation().matches(relation)) {
                    person++;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return person;
    }

    public static int getChildrenInDaughters(ArrayList<Person> data) {
        boolean isHasChildren = false;

        int sonsCount = 0, daughtersCount = 0;

        int sum = 0;

        for (Person mData : data) {

            if (mData.getRelation().matches(OConstants.PERSON_SON)) {
                isHasChildren = true;
                sonsCount++;
            } else if (mData.getRelation().matches(OConstants.PERSON_DAUGHTER)) {
                isHasChildren = true;
                daughtersCount++;
            }
        }
        if (isHasChildren) {

            if (sonsCount > 0) {

                sum += (sonsCount * 2);

            }

            if (daughtersCount > 0) {

                sum += daughtersCount;

            }
        }
        return sum;
    }

    public static void blockPerson(ArrayList<Person> data, String relation, String blockedBy) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getRelation().matches(relation)) {
                data.get(i).setBlocked(OConstants.BLOCKED);
                data.get(i).setBlockedBy(blockedBy);
            }
        }
    }

    /*----------------------------حالة الابن / البنت المتوفين و ابنائهم ---------------------------*/


    /*---------------------------- Uncles And Aunts ---------------------------*/

    public static Person getPerson(ArrayList<Person> data, String relation) {
        for (Person person : data) {
            if (person.getRelation().matches(relation))
                return person;
        }
        return null;
    }

    public static Person getNewPerson(ArrayList<Person> data, String relation) {
        for (Person person : data) {
            if (person.getRelation().contains(relation))
                return person;
        }
        return null;
    }
    /*----------------------------حالة الابن / البنت المتوفين و ابنائهم ---------------------------*/

    public static int getPersonsInGirlsCount(ArrayList<Person> data, String boys, String girls) {
        int boysCount = 0, girlsCount = 0;

        int sum = 0;

        for (Person mData : data) {

            if (mData.getRelation().matches(boys)) {
                boysCount++;
            } else if (mData.getRelation().matches(girls)) {
                girlsCount++;
            }
        }
        if (boysCount > 0) {

            sum += (boysCount * 2);

        }

        if (girlsCount > 0) {

            sum += girlsCount;

        }

        return sum;
    }

    public static int getDeadSonsCount(ArrayList<Person> data) {
        int sons = 0;
        try {
            for (Person mData : data) {
                if (mData.getRelation().matches(OConstants.PERSON_SON) && !mData.isAlive()) {
                    sons++;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return sons;
    }

    public static int getDeadDeadDaughtersCount(ArrayList<Person> data) {
        int daughters = 0;
        try {
            for (Person mData : data) {
                if (mData.getRelation().matches(OConstants.PERSON_DAUGHTER) && !mData.isAlive()) {
                    daughters++;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return daughters;
    }

    public static int getDeadSonBoysCount(ArrayList<Person> data, int deadSonNumber) {
        int sons = 0;
        try {
            for (Person mData : data) {
                if (mData.getRelation().matches(OConstants.PERSON_SON_BOY) && mData.getDeadSonNumber() == deadSonNumber) {
                    sons++;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return sons;
    }

    public static int getDeadSonGirlsCount(ArrayList<Person> data, int deadSonNumber) {
        int daughters = 0;
        try {
            for (Person mData : data) {
                if (mData.getRelation().matches(OConstants.PERSON_SON_GIRL) && mData.getDeadSonNumber() == deadSonNumber) {
                    daughters++;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return daughters;
    }

    public static int getDeadDaughterBoysCount(ArrayList<Person> data, int deadSonNumber) {
        int sons = 0;
        try {
            for (Person mData : data) {
                if (mData.getRelation().matches(OConstants.PERSON_DAUGHTER_BOY) && mData.getDeadSonNumber() == deadSonNumber) {
                    sons++;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return sons;
    }

    public static int getDeadDaughterGirlsCount(ArrayList<Person> data, int deadSonNumber) {
        int daughters = 0;
        try {
            for (Person mData : data) {
                if (mData.getRelation().matches(OConstants.PERSON_DAUGHTER_GIRL) && mData.getDeadSonNumber() == deadSonNumber) {
                    daughters++;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return daughters;
    }

    public static ArrayList<Person> sort(ArrayList<Person> data) {
        ArrayList<Person> result = new ArrayList<>();

        try {
            Person children = getPerson(data, OConstants.PERSON_More_Than_three_DAUGHTERS);
            Person children2 = getPerson(data, OConstants.PERSON_CHILDREN);

            Person son = getPerson(data, OConstants.PERSON_SON);
            Person daughter = getPerson(data, OConstants.PERSON_DAUGHTER);
            int sonCount = getPersonCount(data, OConstants.PERSON_SON);
            int daughterCount = getPersonCount(data, OConstants.PERSON_DAUGHTER);

            Person wife = getNewPerson(data, OConstants.PERSON_WIFE);
            Person wives = getNewPerson(data, OConstants.PERSON_WIVES);
            Person wives2 = getNewPerson(data, OConstants.PERSON_TWO_WIVES);
            int wivesCount = getPersonCount(data, OConstants.PERSON_WIFE);

            Person husband = getPerson(data, OConstants.PERSON_HUSBAND);

            Person father = getPerson(data, OConstants.PERSON_FATHER);
            Person mother = getPerson(data, OConstants.PERSON_MOTHER);
            Person fatherGrandPa = getPerson(data, OConstants.PERSON_FATHER_GRANDFATHER);
            Person fatherGrandMa = getPerson(data, OConstants.PERSON_FATHER_GRANDMOTHER);
            Person motherGrandPa = getPerson(data, OConstants.PERSON_MOTHER_GRANDFATHER);
            Person motherGrandMa = getPerson(data, OConstants.PERSON_MOTHER_GRANDMOTHER);

            Person moreThanThreeBrothersAndSisters = getPerson(data, OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER);
            Person moreThanBrotherAndSister = getPerson(data, OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER);
            Person brother = getPerson(data, OConstants.PERSON_BROTHER);
            Person sister = getPerson(data, OConstants.PERSON_SISTER);
            int brotherCount = getPersonCount(data, OConstants.PERSON_BROTHER);
            int sisterCount = getPersonCount(data, OConstants.PERSON_SISTER);


            Person fatherUnclesAndAunts = getPerson(data, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS);
            Person fatherUncles = getPerson(data, OConstants.PERSON_FATHER_UNCLE);
            Person fatherAunts = getPerson(data, OConstants.PERSON_FATHER_AUNT);
            int fatherUncleCount = getPersonCount(data, OConstants.PERSON_FATHER_UNCLE);
            int fatherAuntCount = getPersonCount(data, OConstants.PERSON_FATHER_AUNT);

            Person motherUnclesAndAunts = getPerson(data, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS);
            Person motherUncles = getPerson(data, OConstants.PERSON_MOTHER_UNCLE);
            Person motherAunts = getPerson(data, OConstants.PERSON_MOTHER_AUNT);
            int motherUncleCount = getPersonCount(data, OConstants.PERSON_MOTHER_UNCLE);
            int motherAuntCount = getPersonCount(data, OConstants.PERSON_MOTHER_AUNT);


            //Children
            if (children != null || children2 != null) {
                if (children != null) {
                    result.add(children);
                } else {
                    result.add(children2);
                }
            }

            for (int i = 0; i < sonCount; i++) {
                result.add(son);
            }

            for (int i = 0; i < daughterCount; i++) {
                result.add(daughter);
            }

            //Husband and wife
            if (husband != null) {
                result.add(husband);
            } else if (wives != null) {
                result.add(wives);

                if (wife != null) {
                    for (int i = 0; i < wivesCount; i++) {
                        result.add(wife);
                    }
                }
            } else if (wives2 != null) {
                result.add(wives2);
                if (wife != null) {
                    for (int i = 0; i < 2; i++) {
                        result.add(wife);
                    }
                }
            } else if (wife != null) {
                result.add(wife);
            }

            //Father
            if (father != null) {
                result.add(father);
            } else {
                if (fatherGrandPa != null && fatherGrandPa.getBlocked() == null) {
                    result.add(fatherGrandPa);
                }
                if (fatherGrandMa != null && fatherGrandMa.getBlocked() == null) {
                    result.add(fatherGrandMa);
                }
            }

            //Mothers
            if (mother != null) {
                result.add(mother);
            } else {
                if (motherGrandPa != null && motherGrandPa.getBlocked() == null) {
                    result.add(motherGrandPa);
                }
                if (motherGrandMa != null && motherGrandMa.getBlocked() == null) {
                    result.add(motherGrandMa);
                }
            }

            // Brothers and sisters
            if (moreThanBrotherAndSister != null || moreThanThreeBrothersAndSisters != null) {
                if (moreThanBrotherAndSister != null && moreThanBrotherAndSister.getBlocked() == null) {
                    result.add(moreThanBrotherAndSister);
                } else if (moreThanThreeBrothersAndSisters != null && moreThanThreeBrothersAndSisters.getBlocked() == null) {
                    result.add(moreThanThreeBrothersAndSisters);
                }
            }

            if (brother != null && brother.getBlocked() == null) {
                for (int i = 0; i < brotherCount; i++) {
                    result.add(brother);
                }
            }
            if (sister != null && sister.getBlocked() == null) {
                for (int i = 0; i < sisterCount; i++) {
                    result.add(sister);
                }
            }

            // Father Uncles And Aunts
            if (fatherUnclesAndAunts != null && fatherUnclesAndAunts.getBlocked() == null) {
                result.add(fatherUnclesAndAunts);
            }

            if (fatherUncles != null && fatherUncles.getBlocked() == null) {
                for (int i = 0; i < fatherUncleCount; i++) {
                    result.add(fatherUncles);
                }
            }
            if (fatherAunts != null && fatherAunts.getBlocked() == null) {
                for (int i = 0; i < fatherAuntCount; i++) {
                    result.add(fatherAunts);
                }
            }

            //Mother uncles and aunts
            if (motherUnclesAndAunts != null && motherUnclesAndAunts.getBlocked() == null) {
                result.add(motherUnclesAndAunts);
            }

            if (motherUncles != null && motherUncles.getBlocked() == null) {
                for (int i = 0; i < motherUncleCount; i++) {
                    result.add(motherUncles);
                }
            }
            if (motherAunts != null && motherAunts.getBlocked() == null) {
                for (int i = 0; i < motherAuntCount; i++) {
                    result.add(motherAunts);
                }
            }

            for (int i = 0; i < result.size(); i++) {
                Log.i(TAG, "sort(): " + result.get(i).getRelation());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /*---------------------------------------  حساب النصيب --------------------------------------*/

    public static int findGCD(int number1, int number2) {
        //base case
        if (number2 == 0) {
            return number1;
        }
        return findGCD(number2, number1 % number2);
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public static void setPersonSharePercent(ArrayList<Person> data, Fraction fraction, String relation) {

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getRelation().matches(relation)) {
                Fraction mNewFraction = new Fraction(fraction.getNumerator(), fraction.getDenominator());
                data.get(i).setSharePercent(mNewFraction);

                if (relation.matches(OConstants.PERSON_DAUGHTER) && getDaughtersCount(data) == 2 && fraction.getDenominator() == 24) {
                    Fraction fraction1 = new Fraction(mNewFraction.getNumerator() * 2, mNewFraction.getDenominator());
                    data.get(i).setOriginalSharePercent(fraction1);

                } else if (fraction.getDenominator() == 24) {
                    data.get(i).setOriginalSharePercent(fraction);
                }
            }
        }
    }

    public static void setPersonProblemOrigin(ArrayList<Person> data, int problemOrigin, String relation) {

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getRelation().matches(relation)) {
                data.get(i).setProblemOrigin(problemOrigin);
            }
        }
    }

    public static void setPersonProofAndExplanation(ArrayList<Person> data, String relation, String explanation, String proof) {
        try {
            for (Person person : data) {
                if (person.getRelation().matches(relation)) {
                    person.setExplanation(explanation);
                    person.setProof(proof);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void calculateShareValue(ArrayList<Person> data, OConstants oConstants) {
        validPeopleCount = 0;

        remain = oConstants.getTotalMoney();
        // ص = ن / س
        Fraction X, Y, N;
        X = new Fraction(0, 24);
        Y = new Fraction(0, 24);

        boolean specialRemainCase = false;

        ArrayList<Person> specialCaseRemainPeople = new ArrayList<>();
        ArrayList<Person> partners = new ArrayList<>();

        // Sum each person percent except
        // people with special cases
        for (int i = 0; i < data.size(); i++) {

            Person person = data.get(i);

            if (!isRemainPerson(data, person) && !isPartnerPerson(data, person) && !isBlocked(person)) {
                Log.i(TAG, "calculateShareValue(): person " + person.getRelation() + " is Valid");
                validPeopleCount++;

                Fraction.addFractions(X, person.getSharePercent());

                Log.i(TAG, "calculateShareValue(): X = " + X.getNumerator() + "/" + X.getDenominator());

            } else {
                Log.i(TAG, "calculateShareValue() : person " + person.getRelation() + " Has Special Case");

                if (isRemainPerson(data, person))
                    specialCaseRemainPeople.add(person);
                else if (isPartnerPerson(data, person)) {
                    partners.add(person);
                }
            }
        }

        // Calc each person
        // sharePercent & shareValue
        // problemOrigin
        // NumberOfShare
        for (Person person : data) {
            // ص = ن / س
            if (!isRemainPerson(data, person) && !isPartnerPerson(data, person) && !isBlocked(person)) {
                // No remain people
                if (specialCaseRemainPeople.isEmpty()) {
                    Log.i(TAG, "calculateShareValue(): No Remain People");
                    //only one person to take the money
                    if (Fraction.isEqual(X, person.getSharePercent())) {

                        Log.i(TAG, "calculateShareValue(): X == person SharePercent with value = " + X.getNumerator() + "/" + X.getDenominator());

                        Y = Fraction.finalCalculationDivideFraction(person.getSharePercent(), X);

                    } else if (!Fraction.isEqual(X, person.getSharePercent())) {
                        // More than on person to take the money

                        Log.i(TAG, "calculateShareValue(): X != person SharePercent with value = " + X.getNumerator() + "/" + X.getDenominator());
                        Y = Fraction.finalCalculationDivideFraction(person.getSharePercent(), X);
                    }
                } else { // Has remain people
                    Log.i(TAG, "calculateShareValue(): Has Remain People");

                    if (Fraction.isEqual(X, person.getSharePercent())) {

                        Log.i(TAG, "calculateShareValue(): X == person SharePercent with value = " + X.getNumerator() + "/" + X.getDenominator());

                        Y = person.getSharePercent();
                    } else {

                        Log.i(TAG, "calculateShareValue(): X != person SharePercent with value = " + X.getNumerator() + "/" + X.getDenominator());

//                        Y = Fraction.finalCalculationDivideFraction(person.getSharePercent(), X); //TODO undo if wrong 16/11/2019
                        Y = person.getSharePercent();//TODO REMOVE if wrong 16/11/2019
                    }
                }

                person.setSharePercent(Y); // Share Percent
                person.setProblemOrigin(person.getSharePercent().getDenominator()); // Problem Origin
                person.setNumberOfShares(person.getSharePercent().getNumerator()); // Number Of Shares

                Log.i(TAG, "calculateShareValue(): Person = " + person.getRelation() +
                        " & sharePercent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator() +
                        " & Problem Origin = " + person.getProblemOrigin() + " & Person Number of Shares = " + person.getNumberOfShares());

                calculatePersonShareValue(person, oConstants, !specialCaseRemainPeople.isEmpty(), X);

                if (person.getRelation().matches(OConstants.PERSON_FATHER_UNCLES_AND_AUNTS)) {
                    setPersonProblemOrigin(data, person.getProblemOrigin(), OConstants.PERSON_FATHER_UNCLE);
                    setPersonProblemOrigin(data, person.getProblemOrigin(), OConstants.PERSON_FATHER_AUNT);

                } else if (person.getRelation().matches(OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS)) {
                    setPersonProblemOrigin(data, person.getProblemOrigin(), OConstants.PERSON_MOTHER_UNCLE);
                    setPersonProblemOrigin(data, person.getProblemOrigin(), OConstants.PERSON_MOTHER_AUNT);
                }
            }
        }

        setExplanationPhase2(oConstants, X, data);
        setExplanationPhase3(data, oConstants);

        if (specialCaseRemainPeople != null) {
            Log.i(TAG, "calculateShareValue(): remain people size = " + specialCaseRemainPeople.size());
        }
        if (!specialCaseRemainPeople.isEmpty())
            handleRemainPerson(data, X, oConstants);
        if (!partners.isEmpty())
            handlePartnerPeople(data, oConstants, X);

//        setExplanationPhase4(data, oConstants);
        handleDeadSonsAndDaughters(data);

    }

    private static void calculatePersonShareValue(Person person, OConstants oConstants, boolean isHasRemainPeople, Fraction X) {

        try {

            double money = 0;
            if (isHasRemainPeople) {

                remain = oConstants.getTotalMoney() - (oConstants.getTotalMoney() * ((double) X.getNumerator() / (double) X.getDenominator()));

//                if (validPeopleCount > 1) {
//                    money = oConstants.getTotalMoney() - remain;
//                } else {
                money = oConstants.getTotalMoney(); // TODO I Don't Know if right or not
//                }
                Log.i(TAG, "calculatePersonShareValue(): Has Remain People And Money = " + money + " & remain = " + remain);

            } else {

                money = oConstants.getTotalMoney();
                remain = oConstants.getTotalMoney();

                Log.i(TAG, "calculatePersonShareValue(): Not Has Remain People And Money = " + money + " & remain = " + remain);

            }

            double sharePercent = ((double) person.getSharePercent().getNumerator()) / ((double) person.getSharePercent().getDenominator());
            double shareValue = round((money * sharePercent), 2);

            sharePercent = round(sharePercent, 2);

            Log.i(TAG, "calculatePersonShareValue(): Person = " + person.getRelation() + " & money = " + money + " & sharePercent = " + sharePercent + "% & ShareValue  = " + shareValue);

            person.setShareValue(shareValue);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static boolean isRemainPerson(ArrayList<Person> data, Person person) {
        Person fatherUnclesAndAunts = getPerson(data, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS);
        Person motherUnclesAndAunts = getPerson(data, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS);

        if ((person.getRelation().matches(OConstants.PERSON_MOTHER) && (person.getSharePercent() == null || Fraction.isEqual(person.getSharePercent(), one) || Fraction.isEqual(person.getSharePercent(), half)))) {
            //When mother has the rest of money || has half of the rest of money
            Log.i(TAG, "isRemainPerson(): When " + person.getRelation() + " has the rest of money || has half of the rest of money");
            if (person.getSharePercent() == null || Fraction.isEqual(person.getSharePercent(), one)) {
                Log.i(TAG, "isRemainPerson(): person " + person.getRelation() + " has null sharePercent");
            } else if (Fraction.isEqual(person.getSharePercent(), half)) {
                Log.i(TAG, "isRemainPerson(): person " + person.getRelation() + " has sharePercent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator());
            }
            return true;

        } else if (person.getRelation().matches(OConstants.PERSON_FATHER) && (person.getSharePercent() == null || Fraction.isEqual(person.getSharePercent(), one) || Fraction.isEqual(person.getSharePercent(), half))) {
            //When father has the rest of money || has half of the rest of money
            Log.i(TAG, "isRemainPerson(): When father has the rest of money || has half of the rest of money");

            if (person.getSharePercent() == null || Fraction.isEqual(person.getSharePercent(), one)) {
                Log.i(TAG, "isRemainPerson(): person " + person.getRelation() + " has null sharePercent");
            } else if (Fraction.isEqual(person.getSharePercent(), half)) {
                Log.i(TAG, "isRemainPerson(): person " + person.getRelation() + " has sharePercent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator());
            }
            return true;

        } else if ((person.getRelation().matches(OConstants.PERSON_FATHER_UNCLE) || person.getRelation().matches(OConstants.PERSON_FATHER_AUNT)) &&
                (/*fatherUnclesAndAunts != null && */person.getSharePercent() != null && (Fraction.isEqual(person.getSharePercent(), half) || Fraction.isEqual(person.getSharePercent(), quarter)))) {
            //When Father uncles and/or aunts has 1/2
            Log.i(TAG, "isRemainPerson(): When Father uncles and/or aunts has 1/2");
            return true;

        } else if ((person.getRelation().matches(OConstants.PERSON_MOTHER_UNCLE) || person.getRelation().matches(OConstants.PERSON_MOTHER_AUNT)) &&
                (/*motherUnclesAndAunts != null &&*/ person.getSharePercent() != null && (Fraction.isEqual(person.getSharePercent(), half) || Fraction.isEqual(person.getSharePercent(), quarter)))) {
            //When Mother uncles and/or aunts has 1/2
            Log.i(TAG, "isRemainPerson(): When Mother uncles and/or aunts has 1/2");
            return true;

        }
        if (person.getSharePercent() != null) {
            Log.i(TAG, "isRemainPerson(): person = " + person.getRelation() + " with sharePercent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator() + " is Not a remain person");
        } else {
            Log.i(TAG, "isRemainPerson(): person = " + person.getRelation() + " with sharePercent = null is Not a remain person");
        }
        return false;
    }

    private static boolean isPartnerPerson(ArrayList<Person> data, Person person) {
        try {
            Person fatherUnclesAndAunts = getPerson(data, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS);
            Person motherUnclesAndAunts = getPerson(data, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS);
            Person moreThanBrotherAndSister = getPerson(data, OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER);
            Person moreThanThreeBrotherAndSister = getPerson(data, OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER);
            Person moreThanThreeDaughters = getPerson(data, OConstants.PERSON_More_Than_three_DAUGHTERS);

            if (isMoreThanThreeDaughter(data, person, moreThanThreeDaughters)) {

                //When sons and daughters count >= 3
                Log.i(TAG, "isPartnerPerson(): person = " + person.getRelation() + " & Daughters >= 3 " + getChildrenInDaughters(data) + " is a special Case");
                return true;

            } else if (person.getRelation().matches(OConstants.PERSON_SON_BOY) || person.getRelation().matches(OConstants.PERSON_SON_GIRL)) {

                // When a dead son's boys or daughters
                Log.i(TAG, "isPartnerPerson():  When a dead son's boys or daughters");
                return true;

            } else if (person.getRelation().matches(OConstants.PERSON_DAUGHTER_BOY) || person.getRelation().matches(OConstants.PERSON_DAUGHTER_GIRL)) {

                // When a dead daughter's boys or daughters
                Log.i(TAG, "isPartnerPerson():  When a dead daughter's boys or daughters");
                return true;

            } else if (!isBlocked(person) && isMoreThanBrotherAndSister(data, person, moreThanBrotherAndSister)) {

                //When More than brother and sister and has 1/3
                Log.i(TAG, "isPartnerPerson(): When More than brother and sister and has 1/3");
                return true;

            } else if (!isBlocked(person) && isMoreThanThreeBrotherAndSister(data, person, moreThanThreeBrotherAndSister)) {

                //When More than three brother and sister and has 24/24
                Log.i(TAG, "isPartnerPerson(): When More than three brother and sister and has 1/3");
                return true;
            } else if (!isBlocked(person) && isTwoSisters(data, person)) {
                //When two sister and has 16/24
                Log.i(TAG, "isPartnerPerson(): When two sister and has 16/24");
                return true;
            } else if (isFatherUnclesAndAuntsPartnerConditions(data, person, fatherUnclesAndAunts)) {

                //When Father uncles and/or aunts has 2/3
                Log.i(TAG, "isPartnerPerson(): When Father uncles and/or aunts has 2/3");
                return true;

            } else if (isMotherUnclesAndAuntsPartnerConditions(data, person, motherUnclesAndAunts)) {

                //When Mother uncles and/or aunts has 1/3
                Log.i(TAG, "isPartnerPerson(): When Mother uncles and/or aunts has 1/3");
                return true;

            } else if (isMoreThanWife(data, person)) {

                //When More than wife
                Log.i(TAG, "isPartnerPerson(): When More than wife");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.i(TAG, "Not a partner person");
        return false;
    }

    private static void handleRemainPerson(ArrayList<Person> data, Fraction X, OConstants oConstants) {

        Person fatherUnclesAndAunts = getPerson(data, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS);
        Person motherUnclesAndAunts = getPerson(data, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS);

        for (Person person : data) {
            Log.i(TAG, "handleRemainPerson(): person " + person.getRelation());
            if (!isBlocked(person)) {
                Log.i(TAG, "handleRemainPerson(): person " + person.getRelation() + " sharePercent" + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator());

                if ((person.getRelation().matches(OConstants.PERSON_MOTHER) && (person.getSharePercent() == null || Fraction.isEqual(person.getSharePercent(), one) || Fraction.isEqual(person.getSharePercent(), half)))) {
                    //When mother has the rest of money || has half of the rest of money
                    Log.i(TAG, "handleRemainPerson(): When " + person.getRelation() + " has the rest of money || has half of the rest of money");
                    if (person.getSharePercent() == null || Fraction.isEqual(person.getSharePercent(), one)) {
                        //Mother Takes the rest
                        Fraction newFraction = new Fraction(X.getNumerator(), X.getDenominator());

                        Fraction.subtractFractions(newFraction, new Fraction(24, 24));

                        person.setProblemOrigin(newFraction.getDenominator());
                        person.setNumberOfShares(newFraction.getNumerator());
                        person.setShareValue(round(remain, 2));
                        person.setSharePercent(newFraction);
                        person.setOriginalSharePercent(newFraction);
                        Log.i(TAG, "handleRemainPerson(): Mother Takes the rest");

                    } else if (Fraction.isEqual(person.getSharePercent(), half)) {
                        person.setShareValue(round((remain / 2), 2));
                        Fraction newFraction = new Fraction(X.getNumerator(), X.getDenominator());

                        Fraction.subtractFractions(newFraction, new Fraction(24, 24));

                        newFraction = Fraction.divideFraction(newFraction, new Fraction(1, 2));

                        person.setSharePercent(newFraction);
                        person.setProblemOrigin(newFraction.getDenominator());
                        person.setNumberOfShares(newFraction.getNumerator());
                        person.setOriginalSharePercent(newFraction);
                        Log.i(TAG, "handleRemainPerson(): Mother Takes the half of the Rest");
                        Log.i(TAG, "handleRemainPerson(): person " + person.getRelation() + " has sharePercent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator());
                    }


                } else if (person.getRelation().matches(OConstants.PERSON_FATHER) && (person.getSharePercent() == null || Fraction.isEqual(person.getSharePercent(), one) || Fraction.isEqual(person.getSharePercent(), half))) {

                    //When father has the rest of money || has half of the rest of money
                    Log.i(TAG, "handleRemainPerson(): When father has the rest of money || has half of the rest of money");

                    if (person.getSharePercent() == null || Fraction.isEqual(person.getSharePercent(), one)) {
                        //Father Takes the rest

                        Fraction newFraction = new Fraction(X.getNumerator(), X.getDenominator());

                        Fraction.subtractFractions(newFraction, new Fraction(24, 24));

                        person.setProblemOrigin(newFraction.getDenominator());
                        person.setNumberOfShares(newFraction.getNumerator());
                        person.setSharePercent(newFraction);
                        person.setOriginalSharePercent(newFraction);
                        person.setShareValue(round(remain, 2));

                        Log.i(TAG, "handleRemainPerson(): Father Takes the rest");
                    } else if (Fraction.isEqual(person.getSharePercent(), half)) {
                        person.setShareValue(round((remain / 2), 2));
                        Fraction newFraction = new Fraction(X.getNumerator(), X.getDenominator());

                        Fraction.subtractFractions(newFraction, new Fraction(24, 24));
                        newFraction = Fraction.divideFraction(newFraction, new Fraction(1, 2));

                        person.setSharePercent(newFraction);
                        person.setProblemOrigin(newFraction.getDenominator());
                        person.setNumberOfShares(newFraction.getNumerator());
                        person.setOriginalSharePercent(newFraction);

                        Log.i(TAG, "handleRemainPerson(): Father Takes the half of the Rest");
                        Log.i(TAG, "handleRemainPerson(): person " + person.getRelation() + " has sharePercent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator());
                    }


                } else if ((person.getRelation().matches(OConstants.PERSON_FATHER_UNCLE) || person.getRelation().matches(OConstants.PERSON_FATHER_AUNT)) &&
                        (/*fatherUnclesAndAunts != null && */person.getSharePercent() != null && (Fraction.isEqual(person.getSharePercent(), half) || Fraction.isEqual(person.getSharePercent(), quarter)))) {
                    //When Father uncles and/or aunts has 1/2
                    Log.i(TAG, "handleRemainPerson(): When Father uncles and/or aunts has 1/2");

                    setFatherUnclesAndAunts(data, person, half, remain, oConstants);

                } else if ((person.getRelation().matches(OConstants.PERSON_MOTHER_UNCLE) || person.getRelation().matches(OConstants.PERSON_MOTHER_AUNT)) &&
                        (/*motherUnclesAndAunts != null && */person.getSharePercent() != null && (Fraction.isEqual(person.getSharePercent(), half) || Fraction.isEqual(person.getSharePercent(), quarter)))) {
                    //When Mother uncles and/or aunts has 1/2
                    Log.i(TAG, "handleRemainPerson(): When Mother uncles and/or aunts has 1/2");
                    setMotherUnclesAndAunts(data, person, half, oConstants);

                }
            }
        }
    }

    private static void handlePartnerPeople(ArrayList<Person> data, OConstants oConstants, Fraction X) {

        Log.i(TAG, "handlePartnerPeople(): is called");

        for (Person person : data) {
            try {
                Log.i(TAG, "handlePartnerPeople(): person = " + person.getRelation());

                if (!isBlocked(person)) {
                    Person fatherUnclesAndAunts = getPerson(data, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS);
                    Person motherUnclesAndAunts = getPerson(data, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS);
                    Person moreThanBrotherAndSister = getPerson(data, OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER);
                    Person moreThanThreeBrotherAndSister = getPerson(data, OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER);
                    Person moreThanThreeDaughters = getPerson(data, OConstants.PERSON_More_Than_three_DAUGHTERS);

                    if (isMoreThanThreeDaughter(data, person, moreThanThreeDaughters)) {

                        //When sons and daughters count >= 3
                        Log.i(TAG, "handlePartnerPeople(): person = " + person.getRelation() + " & Daughters >= 3 " + getChildrenInDaughters(data) + " is a special Case");
                        setMoreThanThreeDaughters(data, person, two_Thirds, moreThanThreeDaughters.getShareValue(), moreThanThreeDaughters, oConstants);

                    } else if (isFatherUnclesAndAuntsPartnerConditions(data, person, fatherUnclesAndAunts)) {

                        //When Father uncles and/or aunts has 2/3 or half or quarter or all
                        Log.i(TAG, "handlePartnerPeople(): When Father uncles and/or aunts has 2/3");
                        setFatherUnclesAndAunts(data, person, fatherUnclesAndAunts.getSharePercent(), fatherUnclesAndAunts.getShareValue(), oConstants);

                    } else if (isMotherUnclesAndAuntsPartnerConditions(data, person, motherUnclesAndAunts)) {

                        //When Mother uncles and/or aunts has 1/3
                        Log.i(TAG, "handlePartnerPeople(): When Mother uncles and/or aunts has 1/3");
                        setMotherUnclesAndAunts(data, person, motherUnclesAndAunts.getSharePercent(), oConstants);

                    } else if (!isBlocked(person) && isMoreThanBrotherAndSister(data, person, moreThanBrotherAndSister)) {

                        //When More than brother and sister and has 1/3
                        Log.i(TAG, "handlePartnerPeople(): When More than brother and sister and has 1/3");
                        setMoreThanBrotherAndSister(data, person, one_Third, oConstants.getTotalMoney(), X, oConstants);

                    } else if (!isBlocked(person) && isMoreThanThreeBrotherAndSister(data, person, moreThanThreeBrotherAndSister)) {

                        //When More than three brother and sister and has 1/3
                        Log.i(TAG, "handlePartnerPeople(): When More than three brother and sister and has 1/3");
                        setMoreThanThreeBrotherAndSister(data, person, one, oConstants.getTotalMoney(), oConstants);
                    } /*else if (!isBlocked(person) && isTwoSisters(data, person)) {
                        //TODO two Sisters partners in two_third
                        setTwoSistersPartners(person, oConstants.getTotalMoney());
                    }*/ else if (isMoreThanWife(data, person)) {

                        //When More than wife
                        Log.i(TAG, "isPartnerPerson(): When More than wife");
                        setMoreThanWife(data, person, oConstants);

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void setExplanationPhase4(ArrayList<Person> data, OConstants oConstants) {
        ExplainPhase4 phase4 = new ExplainPhase4();
        phase4.setPeople(data);
        oConstants.getmExplanation().setPhase4(phase4);
    }

    private static void setExplanationPhase3(ArrayList<Person> mPeople, OConstants oConstants) {
        try {
            ExplainPhase3 phase3 = new ExplainPhase3();
            ArrayList<Person> data = new ArrayList<>(mPeople);
            for (Person mPerson : mPeople) {
                Person person = new Person();
                int id = mPerson.getId();

                int count = mPerson.getCount();

                String relation = mPerson.getRelation();

                String gender = mPerson.getGender();

                String blocked = mPerson.getBlocked();

                int problemOrigin = mPerson.getProblemOrigin();

                Fraction sharePercent = mPerson.getSharePercent();

                Fraction eachPersonSharePercent = mPerson.getEachPersonSharePercent();

                Fraction originalSharePercent = mPerson.getOriginalSharePercent();

                double shareValue = mPerson.getShareValue();

                double eachPersonShareValue = mPerson.getEachPersonShareValue();

                int numberOfShares = mPerson.getNumberOfShares();

                int eachPersonNumberOfShares = mPerson.getEachPersonNumberOfShares();

                String explanation = mPerson.getExplanation();

                String proof = mPerson.getProof();

                String videoUrl = mPerson.getVideoUrl();

                int deadSonNumber = mPerson.getDeadSonNumber();

                boolean alive = mPerson.isAlive();

                String blockedBy = mPerson.getBlockedBy();

                boolean group = mPerson.isGroup();

                person.setSharePercent(sharePercent);
                person.setShareValue(shareValue);
                person.setNumberOfShares(numberOfShares);
                person.setProblemOrigin(problemOrigin);
                person.setAlive(alive);
                person.setBlocked(blocked);
                person.setBlockedBy(blockedBy);
                person.setCount(count);
                person.setDeadSonNumber(deadSonNumber);
                person.setEachPersonNumberOfShares(eachPersonNumberOfShares);
                person.setEachPersonSharePercent(eachPersonSharePercent);
                person.setEachPersonShareValue(eachPersonShareValue);
                person.setExplanation(explanation);
                person.setProof(proof);
                person.setGender(gender);
                person.setRelation(relation);
                person.setOriginalSharePercent(originalSharePercent);
                person.setId(id);
                person.setVideoUrl(videoUrl);
                person.setGroup(group);
                data.add(person);
            }
//            Collections.copy(data, mPeople);
            phase3.setPeople(data);

            Log.i(TAG, "setExplanationPhase3(): print data");
//            showResult(data);

            oConstants.getmExplanation().setPhase3(phase3);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setExplanationPhase2(OConstants oConstants, Fraction X, ArrayList<Person> mPeople) {
        try {
            ExplainPhase2 mPhase2 = new ExplainPhase2();
            mPhase2.setTotalFractionsSum(X);
            ArrayList<Person> data = new ArrayList<>(mPeople);
            for (Person mPerson : mPeople) {
                Person person = new Person();
                int id = mPerson.getId();

                int count = mPerson.getCount();

                String relation = mPerson.getRelation();

                String gender = mPerson.getGender();

                String blocked = mPerson.getBlocked();

                int problemOrigin = mPerson.getProblemOrigin();

                Fraction sharePercent = mPerson.getSharePercent();

                Fraction eachPersonSharePercent = mPerson.getEachPersonSharePercent();

                Fraction originalSharePercent = mPerson.getOriginalSharePercent();

                double shareValue = mPerson.getShareValue();

                double eachPersonShareValue = mPerson.getEachPersonShareValue();

                int numberOfShares = mPerson.getNumberOfShares();

                int eachPersonNumberOfShares = mPerson.getEachPersonNumberOfShares();

                String explanation = mPerson.getExplanation();

                String proof = mPerson.getProof();

                String videoUrl = mPerson.getVideoUrl();

                int deadSonNumber = mPerson.getDeadSonNumber();

                boolean alive = mPerson.isAlive();

                String blockedBy = mPerson.getBlockedBy();

                boolean group = mPerson.isGroup();

                person.setSharePercent(sharePercent);
                person.setShareValue(shareValue);
                person.setNumberOfShares(numberOfShares);
                person.setProblemOrigin(problemOrigin);
                person.setAlive(alive);
                person.setBlocked(blocked);
                person.setBlockedBy(blockedBy);
                person.setCount(count);
                person.setDeadSonNumber(deadSonNumber);
                person.setEachPersonNumberOfShares(eachPersonNumberOfShares);
                person.setEachPersonSharePercent(eachPersonSharePercent);
                person.setEachPersonShareValue(eachPersonShareValue);
                person.setExplanation(explanation);
                person.setProof(proof);
                person.setGender(gender);
                person.setRelation(relation);
                person.setOriginalSharePercent(originalSharePercent);
                person.setId(id);
                person.setVideoUrl(videoUrl);
                person.setGroup(group);
                data.add(person);
            }


//            Collections.copy(data, mPeople);

            Log.i(TAG, "setExplanationPhase2(): print data");
            showResult(data);

            mPhase2.setPeople(data);
            oConstants.getmExplanation().setPhase2(mPhase2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleDeadSonsAndDaughters(ArrayList<Person> data) {
        try {
            for (Person person : data) {
                if (person.getRelation().matches(OConstants.PERSON_SON_BOY) || person.getRelation().matches(OConstants.PERSON_SON_GIRL)) {
                    // When a dead son's boys or daughters
                    setSonOrDaughterBoysAndGirlsShareValue(data, person, OConstants.PERSON_SON, OConstants.PERSON_SON_BOY, OConstants.PERSON_SON_GIRL);

                } else if (person.getRelation().matches(OConstants.PERSON_DAUGHTER_BOY) || person.getRelation().matches(OConstants.PERSON_DAUGHTER_GIRL)) {
                    // When a dead daughter's boys or daughters
                    setSonOrDaughterBoysAndGirlsShareValue(data, person, OConstants.PERSON_DAUGHTER, OConstants.PERSON_DAUGHTER_BOY, OConstants.PERSON_DAUGHTER_GIRL);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setSonOrDaughterBoysAndGirlsShareValue(ArrayList<Person> data, Person person, String deadPersonRelation, String personBoyRelation, String personGirlRelation) {
        try {
            for (Person mDeadPerson : data) {
                if (!mDeadPerson.isAlive() &&
                        person.getDeadSonNumber() == mDeadPerson.getDeadSonNumber() &&
                        mDeadPerson.getRelation().matches(PERSON_SON)) {

                    int girlsCount = OConstants.getPersonsInGirlsCount(data, personBoyRelation, personGirlRelation);

                    double eachPersonValue;
                    double money = mDeadPerson.getShareValue();

                    eachPersonValue = money / girlsCount;

                    if (person.getRelation().matches(personGirlRelation)) {

                        person.setShareValue(eachPersonValue * 2);

                    } else if (person.getRelation().matches(personGirlRelation)) {

                        person.setShareValue(eachPersonValue);

                    }
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setMoreThanWife(ArrayList<Person> data, Person person, OConstants oConstants) {
        try {

            if (!oConstants.isHandleWivesGroup) {
                handleWivesGroup(data, oConstants);
            }

            Person moreThanWife = getPerson(data, OConstants.PERSON_WIVES);
            double totalMoney = moreThanWife.getShareValue();
            int wivesCount = getPersonCount(data, OConstants.PERSON_WIFE);

            Fraction eachPersonSharePercent = new Fraction((int) ((double) moreThanWife.getSharePercent().getNumerator() / wivesCount), moreThanWife.getSharePercent().getDenominator());
            double eachPersonValue = totalMoney / wivesCount;

            person.setShareValue(round(eachPersonValue, 2));
            person.setSharePercent(new Fraction(eachPersonSharePercent.getNumerator(), eachPersonSharePercent.getDenominator()));
            person.setProblemOrigin(moreThanWife.getProblemOrigin());
            person.setNumberOfShares(person.getSharePercent().getNumerator());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setMoreThanThreeDaughters(ArrayList<Person> data, Person person, Fraction sharePercents, double totalMoney, Person moreThanThreeDaughters, OConstants oConstants) {
        try {
            Log.i(TAG, "setMoreThanThreeDaughters(): is called");
            int girlsCount = OConstants.getChildrenInDaughters(data);

            Person wives = getNewPerson(data, OConstants.PERSON_WIVES);
            if (!oConstants.isHandleWivesGroup && wives != null && wives.getSharePercent() != null && wives.getSharePercent().getNumerator() != 0 && wives.getSharePercent().getDenominator() != 0) {
                handleWivesGroup(data, oConstants);
            }

            if (!oConstants.isHandleChildrenGroup)
                handleChildrenGroup(data, oConstants);

            if (moreThanThreeDaughters != null && moreThanThreeDaughters.getSharePercent() != null) {
                Log.i(TAG, "setMoreThanThreeDaughters(): children Share Percent = " + moreThanThreeDaughters.getSharePercent().getNumerator() + "/" + moreThanThreeDaughters.getSharePercent().getDenominator());
            }
            Fraction eachPersonSharePercent = new Fraction((int) ((double) moreThanThreeDaughters.getSharePercent().getNumerator() / girlsCount), moreThanThreeDaughters.getSharePercent().getDenominator());
            double eachPersonValue;
            if (sharePercents == OConstants.two_Thirds) {

//                double twoThirdMoney = (totalMoney * ((double) (2 / 3)));
                eachPersonValue = totalMoney / girlsCount;
                Log.i(TAG, "setMoreThanThreeDaughters(): eachPerson Value = " + eachPersonValue);

                if (person.getRelation().matches(OConstants.PERSON_SON)) {
                    person.setShareValue(round((eachPersonValue * 2), 2));
                    person.setSharePercent(new Fraction(eachPersonSharePercent.getNumerator() * 2, eachPersonSharePercent.getDenominator()));
                    person.setProblemOrigin(moreThanThreeDaughters.getProblemOrigin());
                    person.setNumberOfShares(person.getSharePercent().getNumerator());

                } else if (person.getRelation().matches(OConstants.PERSON_DAUGHTER)) {
                    person.setShareValue(round(eachPersonValue, 2));
                    person.setSharePercent(eachPersonSharePercent);
                    person.setProblemOrigin(moreThanThreeDaughters.getProblemOrigin());
                    person.setNumberOfShares(person.getSharePercent().getNumerator());
                }
            }
            String result = "";
            result = result.concat("--------------------------\n");
            result += person.getRelation() + "\nShareValue = " + person.getShareValue() + " \nShare Percent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator() +
                    "\nProblem Origin = " + person.getProblemOrigin() + "\nNumber Of Shares = " + person.getNumberOfShares() + "\n";

            result = result.concat("--------------------------\n");

            Log.i(TAG, "setMoreThanThreeDaughters(): result = " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setMoreThanBrotherAndSister(ArrayList<Person> data, Person person, Fraction sharePercents, double totalMoney, Fraction X, OConstants oConstants) {

        try {
            Log.i(TAG, "setMoreThanBrotherAndSister(): is called");
            Person person1 = getPerson(data, OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER);
            if (person1 == null)
                person1 = getPerson(data, OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER);

            if (!oConstants.isHandleBrothersGroup) {
                handleBrothersGroup(data, oConstants, person1);
            }
            int girlsCount = OConstants.getPersonsInGirlsCount(data, OConstants.PERSON_BROTHER, OConstants.PERSON_SISTER);
            if (person1 != null && person1.getSharePercent() != null) {
//            Fraction newFraction = new Fraction(person1.getSharePercent().getNumerator(), person1.getSharePercent().getDenominator());
                Fraction eachPersonSharePercent = new Fraction((int) ((double) person1.getSharePercent().getNumerator() / girlsCount), person1.getSharePercent().getDenominator());

//            person.setSharePercent(newFraction);
//            person.setProblemOrigin(newFraction.getDenominator());
//            person.setNumberOfShares(newFraction.getNumerator());

                double eachPersonValue;
                if (Fraction.isEqual(sharePercents, OConstants.one_Third)) {

//                double oneThirdMoney = (totalMoney * ((double) person1.getSharePercent().getNumerator() / (double) person1.getSharePercent().getDenominator())); // money * more than brother and sister sharePercnet
                    double oneThirdMoney = person1.getShareValue();

                    eachPersonValue = oneThirdMoney / girlsCount;

                    Log.i(TAG, "setMoreThanBrotherAndSister(): one Third Money = " + oneThirdMoney);
                    Log.i(TAG, "setMoreThanBrotherAndSister(): eachPerson Value " + eachPersonValue);
                    if (person.getRelation().matches(OConstants.PERSON_BROTHER)) {

                        person.setShareValue(round((eachPersonValue * 2), 2));
                        person.setSharePercent(new Fraction(eachPersonSharePercent.getNumerator() * 2, eachPersonSharePercent.getDenominator()));
                        person.setProblemOrigin(person1.getProblemOrigin());
                        person.setNumberOfShares(person.getSharePercent().getNumerator());

                    } else if (person.getRelation().matches(OConstants.PERSON_SISTER)) {

                        person.setShareValue(round(eachPersonValue, 2));

                        person.setShareValue(round(eachPersonValue, 2));
                        person.setSharePercent(eachPersonSharePercent);
                        person.setProblemOrigin(person1.getProblemOrigin());
                        person.setNumberOfShares(person.getSharePercent().getNumerator());

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setMoreThanThreeBrotherAndSister(ArrayList<Person> data, Person person, Fraction sharePercents, double totalMoney, OConstants oConstants) {
        try {
            Person person1 = getPerson(data, OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER);

            if (!oConstants.isHandleBrothersGroup)
                handleBrothersGroup(data, oConstants, person1);

            int girlsCount = OConstants.getPersonsInGirlsCount(data, OConstants.PERSON_BROTHER, OConstants.PERSON_SISTER);

            if (person1 != null && person1.getSharePercent() != null) {
//            Fraction newFraction = new Fraction(person1.getSharePercent().getNumerator(), person1.getSharePercent().getDenominator());
                Fraction eachPersonSharePercent = new Fraction((int) ((double) person1.getSharePercent().getNumerator() / girlsCount), person1.getSharePercent().getDenominator());

//            person.setSharePercent(newFraction);
//            person.setProblemOrigin(newFraction.getDenominator());
//            person.setNumberOfShares(newFraction.getNumerator());

                double eachPersonValue;
                if (Fraction.isEqual(sharePercents, OConstants.one)) {

//                double one = (totalMoney * ((double) person1.getSharePercent().getNumerator() / (double) person1.getSharePercent().getDenominator())); // money * more than brother and sister sharePercnet
                    double one = person1.getShareValue();

                    eachPersonValue = one / girlsCount;

                    Log.i(TAG, "setMoreThanBrotherAndSister(): one Third Money = " + one);
                    Log.i(TAG, "setMoreThanBrotherAndSister(): eachPerson Value " + eachPersonValue);
                    if (person.getRelation().matches(OConstants.PERSON_BROTHER)) {

                        person.setShareValue(round((eachPersonValue * 2), 2));
                        person.setSharePercent(new Fraction(eachPersonSharePercent.getNumerator() * 2, eachPersonSharePercent.getDenominator()));
                        person.setProblemOrigin(person1.getProblemOrigin());
                        person.setNumberOfShares(person.getSharePercent().getNumerator());

                    } else if (person.getRelation().matches(OConstants.PERSON_SISTER)) {

                        person.setShareValue(round(eachPersonValue, 2));
                        person.setSharePercent(eachPersonSharePercent);
                        person.setProblemOrigin(person1.getProblemOrigin());
                        person.setNumberOfShares(person.getSharePercent().getNumerator());

                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setFatherUnclesAndAunts(ArrayList<Person> data, Person person, Fraction sharePercents, double totalMoney, OConstants oConstants) {

        try {
            if (getPersonsInGirlsCount(data, OConstants.PERSON_FATHER_UNCLE, OConstants.PERSON_FATHER_AUNT) > 2)
                if (!oConstants.isHandleUnclesGroup)
                    handleUnclesGroup(data, oConstants);

            int girlsCount = OConstants.getPersonsInGirlsCount(data, OConstants.PERSON_FATHER_UNCLE, OConstants.PERSON_FATHER_AUNT);
            Person unclesAndAunts = getPerson(data, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS);

            Fraction eachPersonSharePercent = new Fraction((int) ((double) unclesAndAunts.getSharePercent().getNumerator() / girlsCount), unclesAndAunts.getSharePercent().getDenominator());

            totalMoney = unclesAndAunts.getShareValue();
            double eachPersonValue = 0;
            eachPersonValue = totalMoney / girlsCount;

            if (person.getRelation().matches(OConstants.PERSON_FATHER_UNCLE)) {
                person.setShareValue(round((eachPersonValue * 2), 2));
                person.setSharePercent(new Fraction(eachPersonSharePercent.getNumerator() * 2, eachPersonSharePercent.getDenominator()));
                person.setProblemOrigin(unclesAndAunts.getProblemOrigin());
                person.setNumberOfShares(person.getSharePercent().getNumerator());

            } else if (person.getRelation().matches(OConstants.PERSON_FATHER_AUNT)) {

                person.setShareValue(round(eachPersonValue, 2));
                person.setSharePercent(eachPersonSharePercent);
                person.setProblemOrigin(unclesAndAunts.getProblemOrigin());
                person.setNumberOfShares(person.getSharePercent().getNumerator());
            }

            Log.i(TAG, "setFatherUnclesAndAunts(): \ntotalMoney = " + totalMoney + " - \neachPersonValue = " + eachPersonValue + " - \nrelation = " + person.getRelation() + " - \nshareValue = " + person.getShareValue() +
                    " - \nsharePercent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator() + " - \nproblemOrigin = " + person.getProblemOrigin());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setMotherUnclesAndAunts(ArrayList<Person> data, Person person, Fraction sharePercents, OConstants oConstants) {

        try {
            Log.i(TAG, "setMotherUnclesAndAunts(): is called");
            Log.i(TAG, "setMotherUnclesAndAunts(): ");
            int unclesCount = getPersonCount(data, OConstants.PERSON_MOTHER_UNCLE);
            int auntsCount = getPersonCount(data, OConstants.PERSON_MOTHER_AUNT);
            Fraction eachPersonSharePercent = null;
            double eachPersonValue = 0;
            double totalMoney = 0;
            if (unclesCount + auntsCount > 1) {
                Log.i(TAG, "setMotherUnclesAndAunts(): uncles + aunts > 1");

                if (!oConstants.isHandleUnclesGroup)
                    handleUnclesGroup(data, oConstants);

                int girlsCount = OConstants.getPersonsInGirlsCount(data, OConstants.PERSON_MOTHER_UNCLE, OConstants.PERSON_MOTHER_AUNT);
                Person unclesAndAunts = getPerson(data, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS);
                totalMoney = unclesAndAunts.getShareValue();

                eachPersonSharePercent = new Fraction((int) ((double) unclesAndAunts.getSharePercent().getNumerator() / girlsCount), unclesAndAunts.getSharePercent().getDenominator());

                eachPersonValue = totalMoney / girlsCount;

                if (person.getRelation().matches(OConstants.PERSON_MOTHER_UNCLE)) {

                    person.setShareValue(round((eachPersonValue * 2), 2));
                    person.setSharePercent(new Fraction(eachPersonSharePercent.getNumerator() * 2, eachPersonSharePercent.getDenominator()));
                    person.setProblemOrigin(unclesAndAunts.getProblemOrigin());
                    person.setNumberOfShares(person.getSharePercent().getNumerator());

                } else if (person.getRelation().matches(OConstants.PERSON_MOTHER_AUNT)) {

                    person.setShareValue(round(eachPersonValue, 2));
                    person.setSharePercent(eachPersonSharePercent);
                    person.setProblemOrigin(unclesAndAunts.getProblemOrigin());
                    person.setNumberOfShares(person.getSharePercent().getNumerator());
                }
            } else if (unclesCount == 1) {
                Log.i(TAG, "setMotherUnclesAndAunts(): uncle = 1 && aunt = 0");
                Person uncle = getPerson(data, OConstants.PERSON_MOTHER_UNCLE);
                Person unclesAndAunts = getPerson(data, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS);

                totalMoney = unclesAndAunts.getShareValue();

                eachPersonSharePercent = unclesAndAunts.getSharePercent();
                eachPersonValue = totalMoney;

                person.setShareValue(round((eachPersonValue), 2));
                person.setSharePercent(new Fraction(eachPersonSharePercent.getNumerator(), eachPersonSharePercent.getDenominator()));
                person.setProblemOrigin(uncle.getProblemOrigin());
                person.setNumberOfShares(person.getSharePercent().getNumerator());


            } else if (auntsCount == 1) {
                Log.i(TAG, "setMotherUnclesAndAunts(): uncle = 0 && aunt = 1");
                Person unclesAndAunts = getPerson(data, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS);
                Person aunt = getPerson(data, OConstants.PERSON_MOTHER_AUNT);

                totalMoney = unclesAndAunts.getShareValue();

                eachPersonSharePercent = unclesAndAunts.getSharePercent();

                eachPersonValue = totalMoney;

                person.setShareValue(round((eachPersonValue), 2));
                person.setSharePercent(new Fraction(eachPersonSharePercent.getNumerator(), eachPersonSharePercent.getDenominator()));
                person.setProblemOrigin(aunt.getProblemOrigin());
                person.setNumberOfShares(person.getSharePercent().getNumerator());
            }
//            if (Fraction.isEqual(sharePercents, OConstants.half)) {
//
////                double halfOfRemain = (remain / 2);
//                eachPersonValue = totalMoney / girlsCount;
//
//
//            } else if (Fraction.isEqual(sharePercents, OConstants.one_Third)) {
//
////                double twoThirdRemain = (remain / 3);
//                eachPersonValue = totalMoney / girlsCount;
//
//            } else if (Fraction.isEqual(sharePercents, OConstants.quarter)) {
//
////                double twoThirdRemain = (remain / 4);
//                eachPersonValue = totalMoney / girlsCount;
//
//            } else if (Fraction.isEqual(sharePercents, OConstants.one)) {
//
////                double twoThirdRemain = (remain);
//                eachPersonValue = totalMoney / girlsCount;
//
//            }


            Log.i(TAG, "setMotherUnclesAndAunts(): \ntotalMoney = " + totalMoney + " - \neachPersonValue = " + eachPersonValue + " - \nrelation = " + person.getRelation() + " - \nshareValue = " + person.getShareValue() +
                    " - \nsharePercent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator() + " - \nproblemOrigin = " + person.getProblemOrigin());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isTwoSisters(ArrayList<Person> data, Person person) {

        return getPerson(data, OConstants.PERSON_TWO_SISTERS) != null && person.getRelation().matches(OConstants.PERSON_SISTER)
                && (getPersonCount(data, OConstants.PERSON_SISTER) == 2) && (getPersonCount(data, OConstants.PERSON_BROTHER) == 0);

    }

    private static boolean isBlocked(Person person) {
        if (person.getBlocked() != null)
            Log.i(TAG, "isBlocked(): " + person.getRelation() + " is " + person.getBlocked());

        return person.getBlocked() != null && person.getBlocked().matches(BLOCKED);
    }

    private static void setTwoSistersPartners(Person person, double totalMoney) {
        try {

            double eachPersonValue = (totalMoney * ((double) (6 / 24)));
            person.setShareValue(round(eachPersonValue, 2));


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

    public static void createAlivePerson(ArrayList<Person> data, int size, String relation, String gender, boolean isAlive, Fraction originalPercent, Fraction sharePercent,
                                         Fraction eachPersonSharePercent, double shareValue, double eachPersonShareValue, int numberOfShares,
                                         int eachPersonNumberOfShares, int problemOrigin, String explanation, String proof, String blocked, String blockedBy,
                                         boolean group, int id) {
        try {

            Person person = new Person();
            person.setAlive(isAlive);
            person.setCount(size);
            person.setRelation(relation);
            person.setGender(gender);
            person.setDeadSonNumber(-1);
            person.setProblemOrigin(problemOrigin);
            person.setOriginalSharePercent(originalPercent);
            person.setSharePercent(sharePercent);
            person.setEachPersonSharePercent(eachPersonSharePercent);
            person.setShareValue(shareValue);
            person.setEachPersonShareValue(eachPersonShareValue);
            person.setNumberOfShares(numberOfShares);
            person.setEachPersonNumberOfShares(eachPersonNumberOfShares);
            person.setExplanation(explanation);
            person.setProof(proof);
            person.setBlocked(blocked);
            person.setBlockedBy(blockedBy);
            person.setGroup(group);
            person.setId(id);
            data.add(person);


            Log.i(TAG, "createAlivePerson() person relation = " + relation + " & Alive = " + isAlive + " & gender = " + gender + " created");
            Log.i(TAG, "createAlivePerson() people size = " + data.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void handleMoreThanSonAndDaughterResult(ArrayList<Person> mPeople, OConstants oConstants) {

        try {

            Log.i(TAG, "handleMoreThanSonAndDaughterResult(): is called");

            Person moreThanThreeDaughters = getPerson(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS);

            String result = "";


            if (getPersonCount(mPeople, OConstants.PERSON_SON) > 1) {

                Person son = getPerson(mPeople, PERSON_SON);

                if (getPersonCount(mPeople, OConstants.PERSON_SON) == 2) {

                    if (moreThanThreeDaughters != null) {

                        Fraction sharePercent = new Fraction(son.getSharePercent().getNumerator() * 2, son.getSharePercent().getDenominator());
                        int numberOfShares = sharePercent.getNumerator();

                        createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_SON), OConstants.PERSON_TWO_SONS, OConstants.GENDER_MALE, true,
                                son.getOriginalSharePercent(), sharePercent, son.getSharePercent(), round((son.getShareValue() * 2), 2), son.getShareValue(),
                                numberOfShares, son.getNumberOfShares(), moreThanThreeDaughters.getProblemOrigin(), son.getExplanation(), son.getProof(),
                                son.getBlocked(), son.getBlockedBy(), false, OConstants.SON_ID);

                        Person person = getPerson(mPeople, OConstants.PERSON_TWO_SONS);

                        result = "";
                        result = result.concat("--------------------------\n");
                        result += person.getRelation() + "\nShareValue = " + person.getShareValue() + " \nShare Percent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator() +
                                "\nProblem Origin = " + person.getProblemOrigin() + "\nNumber Of Shares = " + person.getNumberOfShares() + "\n";

                        result = result.concat("--------------------------\n");

                        Log.i(TAG, "handleMoreThanSonAndDaughter(): result = " + result);

                        resetPerson(mPeople, OConstants.PERSON_SON);
                        resetPerson(mPeople, PERSON_More_Than_three_DAUGHTERS);

                    } else {

                        Fraction sharePercent = new Fraction(son.getSharePercent().getNumerator() * 2, son.getSharePercent().getDenominator());
                        int numberOfShares = sharePercent.getNumerator();

                        createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_SON), OConstants.PERSON_TWO_SONS, OConstants.GENDER_MALE, true,
                                son.getOriginalSharePercent(), sharePercent, son.getSharePercent(), round((son.getShareValue() * 2), 2), son.getShareValue(),
                                numberOfShares, son.getNumberOfShares(), moreThanThreeDaughters.getProblemOrigin(), son.getExplanation(),
                                son.getProof(), son.getBlocked(), son.getBlockedBy(), false, OConstants.SON_ID);

                        Person person = getPerson(mPeople, OConstants.PERSON_TWO_SONS);

                        result = "";
                        result = result.concat("--------------------------\n");
                        result += person.getRelation() + "\nShareValue = " + person.getShareValue() + " \nShare Percent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator() +
                                "\nProblem Origin = " + person.getProblemOrigin() + "\nNumber Of Shares = " + person.getNumberOfShares() + "\n";

                        result = result.concat("--------------------------\n");

                        Log.i(TAG, "handleMoreThanSonAndDaughter(): result = " + result);

                        resetPerson(mPeople, OConstants.PERSON_SON);
                    }
                } else {
                    String relation = getPersonCount(mPeople, OConstants.PERSON_SON) + " " + OConstants.PERSON_SONS;

                    Fraction sharePercent = new Fraction((son.getSharePercent().getNumerator() * getPersonCount(mPeople, OConstants.PERSON_SON)), son.getSharePercent().getDenominator());
                    double shareValue = round(son.getShareValue() * getPersonCount(mPeople, OConstants.PERSON_SON), 2);
                    int numberOfShares = sharePercent.getNumerator();

                    if (moreThanThreeDaughters != null) {
                        createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_SON), relation, OConstants.GENDER_MALE, true,
                                son.getOriginalSharePercent(), sharePercent, son.getSharePercent(), shareValue, son.getShareValue(),
                                numberOfShares, son.getNumberOfShares(), son.getProblemOrigin(), son.getExplanation(),
                                son.getProof(), son.getBlocked(), son.getBlockedBy(), false, OConstants.SON_ID);

                        Person person = getPerson(mPeople, relation);

                        result = "";
                        result = result.concat("--------------------------\n");
                        result += person.getRelation() + "\nShareValue = " + person.getShareValue() + " \nShare Percent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator() +
                                "\nProblem Origin = " + person.getProblemOrigin() + "\nNumber Of Shares = " + person.getNumberOfShares() + "\n";

                        result = result.concat("--------------------------\n");

                        Log.i(TAG, "handleMoreThanSonAndDaughter(): result = " + result);

                        resetPerson(mPeople, OConstants.PERSON_SON);
                        resetPerson(mPeople, PERSON_More_Than_three_DAUGHTERS);

                    }
                }
            }

            if (getPersonCount(mPeople, OConstants.PERSON_DAUGHTER) > 1) {
                Person daughter = getPerson(mPeople, PERSON_DAUGHTER);

                if (getPersonCount(mPeople, OConstants.PERSON_DAUGHTER) == 2) {

                    if (moreThanThreeDaughters != null) {

                        Fraction sharePercent = new Fraction(daughter.getSharePercent().getNumerator() * 2, daughter.getSharePercent().getDenominator());
                        double shareValue = round((daughter.getShareValue() * 2), 2);
                        int numberOfShares = sharePercent.getNumerator();

                        createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_DAUGHTER), OConstants.PERSON_TWO_DAUGHTERS, OConstants.GENDER_MALE, true,
                                daughter.getOriginalSharePercent(), sharePercent, daughter.getSharePercent(), shareValue, daughter.getShareValue(),
                                numberOfShares, daughter.getNumberOfShares(), moreThanThreeDaughters.getProblemOrigin(),
                                daughter.getExplanation(), daughter.getProof(), daughter.getBlocked(), daughter.getBlockedBy(), false, OConstants.DAUGHTER_ID);


                        Person person = getPerson(mPeople, PERSON_TWO_DAUGHTERS);

                        result = "";
                        result = result.concat("--------------------------\n");
                        result += person.getRelation() + "\nShareValue = " + person.getShareValue() + " \nShare Percent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator() +
                                "\nProblem Origin = " + person.getProblemOrigin() + "\nNumber Of Shares = " + person.getNumberOfShares() + "\n";

                        result = result.concat("--------------------------\n");

                        Log.i(TAG, "handleMoreThanSonAndDaughter(): result = " + result);
                        resetPerson(mPeople, OConstants.PERSON_DAUGHTER);
                        resetPerson(mPeople, PERSON_More_Than_three_DAUGHTERS);

                    } else {
                        Fraction sharePercent = new Fraction(daughter.getSharePercent().getNumerator() * 2, daughter.getSharePercent().getDenominator());
                        double shareValue = round((daughter.getShareValue() * 2), 2);
                        int numberOfShares = sharePercent.getNumerator();

                        createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_DAUGHTER), OConstants.PERSON_TWO_DAUGHTERS, OConstants.GENDER_FEMALE, true,
                                daughter.getOriginalSharePercent(), sharePercent, daughter.getSharePercent(), shareValue, daughter.getShareValue(),
                                numberOfShares, daughter.getNumberOfShares(), daughter.getProblemOrigin(), daughter.getExplanation(),
                                daughter.getProof(), daughter.getBlocked(), daughter.getBlockedBy(), false, OConstants.DAUGHTER_ID);


                        Person person = getPerson(mPeople, PERSON_TWO_DAUGHTERS);

                        result = "";
                        result = result.concat("--------------------------\n");
                        result += person.getRelation() + "\nShareValue = " + person.getShareValue() + " \nShare Percent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator() +
                                "\nProblem Origin = " + person.getProblemOrigin() + "\nNumber Of Shares = " + person.getNumberOfShares() + "\n";

                        result = result.concat("--------------------------\n");

                        Log.i(TAG, "handleMoreThanSonAndDaughter(): result = " + result);
                        resetPerson(mPeople, OConstants.PERSON_DAUGHTER);
                    }
                } else {
                    String relation = getPersonCount(mPeople, OConstants.PERSON_DAUGHTER) + " " + OConstants.PERSON_DAUGHTERS;

                    Fraction sharePercent = new Fraction((daughter.getSharePercent().getNumerator() * getPersonCount(mPeople, OConstants.PERSON_DAUGHTER)), daughter.getSharePercent().getDenominator());
                    double shareValue = round(daughter.getShareValue() * getPersonCount(mPeople, OConstants.PERSON_DAUGHTER), 2);
                    int numberOfShares = sharePercent.getNumerator();

                    if (moreThanThreeDaughters != null) {
                        createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_DAUGHTER), relation, OConstants.GENDER_FEMALE, true,
                                daughter.getOriginalSharePercent(), sharePercent, daughter.getSharePercent(), shareValue, daughter.getShareValue(),
                                numberOfShares, daughter.getNumberOfShares(), moreThanThreeDaughters.getProblemOrigin(),
                                daughter.getExplanation(), daughter.getProof(), daughter.getBlocked(), daughter.getBlockedBy(), false, OConstants.SISTER_ID);

                        Person person = getPerson(mPeople, relation);

                        result = "";
                        result = result.concat("--------------------------\n");
                        result += person.getRelation() + "\nShareValue = " + person.getShareValue() + " \nShare Percent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator() +
                                "\nProblem Origin = " + person.getProblemOrigin() + "\nNumber Of Shares = " + person.getNumberOfShares() + "\n";

                        result = result.concat("--------------------------\n");

                        Log.i(TAG, "handleMoreThanSonAndDaughter(): result = " + result);
                        resetPerson(mPeople, OConstants.PERSON_DAUGHTER);
                        resetPerson(mPeople, PERSON_More_Than_three_DAUGHTERS);

                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void handleMoreThanBrotherAndSisterResult(ArrayList<Person> mPeople, OConstants oConstants) {
        try {

            Person moreThanBrotherAndSister = getPerson(mPeople, OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER);
            Person moreThanThreeBrotherAndSister = getPerson(mPeople, OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER);

            if (getPersonCount(mPeople, OConstants.PERSON_BROTHER) > 1) {

                Person brother = getPerson(mPeople, OConstants.PERSON_BROTHER);
                Fraction sharePercent;
                double shareValue;
                int numberOfShares;

                if (brother.getBlocked() != null && brother.getBlocked().matches(BLOCKED)) {
                    sharePercent = new Fraction(0, 0);
                    shareValue = 0;
                    numberOfShares = 0;
                    brother.setSharePercent(sharePercent);
                    brother.setShareValue(shareValue);
                    brother.setNumberOfShares(numberOfShares);
                } else {
                    sharePercent = new Fraction((brother.getSharePercent().getNumerator() * getPersonCount(mPeople, OConstants.PERSON_BROTHER)), brother.getSharePercent().getDenominator());
                    shareValue = round(brother.getShareValue() * getPersonCount(mPeople, OConstants.PERSON_BROTHER), 2);
                    numberOfShares = sharePercent.getNumerator();
                }
                if (getPersonCount(mPeople, OConstants.PERSON_BROTHER) == 2) {

                    if (moreThanBrotherAndSister != null) {

                        createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_BROTHER), OConstants.PERSON_TWO_BROTHERS, OConstants.GENDER_MALE, true,
                                brother.getOriginalSharePercent(), sharePercent, brother.getSharePercent(), shareValue, brother.getShareValue(),
                                numberOfShares, brother.getNumberOfShares(), moreThanBrotherAndSister.getProblemOrigin(),
                                brother.getExplanation(), brother.getProof(), brother.getBlocked(), brother.getBlockedBy(), false, OConstants.BROTHER_ID);

                    } else if (moreThanThreeBrotherAndSister != null) {

                        createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_BROTHER), OConstants.PERSON_TWO_BROTHERS, OConstants.GENDER_MALE, true,
                                brother.getOriginalSharePercent(), sharePercent, brother.getSharePercent(), shareValue, brother.getShareValue(),
                                numberOfShares, brother.getNumberOfShares(), moreThanThreeBrotherAndSister.getProblemOrigin(),
                                brother.getExplanation(), brother.getProof(), brother.getBlocked(), brother.getBlockedBy(), false, OConstants.BROTHER_ID);

                    } else {
                        createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_BROTHER), OConstants.PERSON_TWO_BROTHERS, OConstants.GENDER_MALE, true,
                                brother.getOriginalSharePercent(), sharePercent, brother.getSharePercent(), shareValue, brother.getShareValue(),
                                numberOfShares, brother.getNumberOfShares(), brother.getProblemOrigin(),
                                brother.getExplanation(), brother.getProof(), brother.getBlocked(), brother.getBlockedBy(), false, OConstants.BROTHER_ID);

                    }
                } else {
                    String relation = getPersonCount(mPeople, OConstants.PERSON_BROTHER) + " " + OConstants.PERSON_BROTHERS;

                    if (moreThanBrotherAndSister != null) {

                        createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_BROTHER), relation, OConstants.GENDER_MALE, true,
                                brother.getOriginalSharePercent(), sharePercent, brother.getSharePercent(), shareValue, brother.getShareValue(),
                                numberOfShares, brother.getNumberOfShares(), moreThanBrotherAndSister.getProblemOrigin(),
                                brother.getExplanation(), brother.getProof(), brother.getBlocked(), brother.getBlockedBy(), false, OConstants.BROTHER_ID);

                    } else if (moreThanThreeBrotherAndSister != null) {

                        createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_BROTHER), relation, OConstants.GENDER_MALE, true,
                                brother.getOriginalSharePercent(), sharePercent, brother.getSharePercent(), shareValue, brother.getShareValue(),
                                numberOfShares, brother.getNumberOfShares(), moreThanThreeBrotherAndSister.getProblemOrigin(),
                                brother.getExplanation(), brother.getProof(), brother.getBlocked(), brother.getBlockedBy(), false, OConstants.BROTHER_ID);

                    }
                }
            }

            if (getPersonCount(mPeople, OConstants.PERSON_SISTER) > 1) {
                Person sister = getPerson(mPeople, OConstants.PERSON_SISTER);

                Fraction sharePercent;
                double shareValue;
                int numberOfShares;

                if ((sister.getBlocked() != null && sister.getBlocked().matches(BLOCKED)) || sister.getSharePercent() == null) {
                    sharePercent = new Fraction(0, 0);
                    shareValue = 0;
                    numberOfShares = 0;
                    sister.setSharePercent(sharePercent);
                    sister.setShareValue(shareValue);
                    sister.setNumberOfShares(numberOfShares);
                } else {
                    sharePercent = new Fraction((sister.getSharePercent().getNumerator() * getPersonCount(mPeople, OConstants.PERSON_SISTER)), sister.getSharePercent().getDenominator());
                    shareValue = round(sister.getShareValue() * getPersonCount(mPeople, OConstants.PERSON_SISTER), 2);
                    numberOfShares = sharePercent.getNumerator();

                }

                if (getPersonCount(mPeople, OConstants.PERSON_SISTER) == 2) {

                    if (getPerson(mPeople, OConstants.PERSON_TWO_SISTERS) != null && !isBlocked(getPerson(mPeople, OConstants.PERSON_TWO_SISTERS))) {
                        Person person = getPerson(mPeople, OConstants.PERSON_TWO_SISTERS);
                        Fraction eachSisterPercent = new Fraction(person.getSharePercent().getNumerator() / 2, person.getSharePercent().getDenominator());
                        double eachSisterValue = round(person.getShareValue() / 2, 2);
                        int eachSisterNumberOfShare = eachSisterPercent.getNumerator();
                        person.setEachPersonSharePercent(eachSisterPercent);
                        person.setEachPersonShareValue(eachSisterValue);
                        person.setEachPersonNumberOfShares(eachSisterNumberOfShare);

                    } else if (moreThanBrotherAndSister != null) {
                        createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_SISTER), OConstants.PERSON_TWO_SISTERS, OConstants.GENDER_MALE, true,
                                sister.getOriginalSharePercent(), sharePercent, sister.getSharePercent(), shareValue, sister.getShareValue(),
                                numberOfShares, sister.getNumberOfShares(), moreThanBrotherAndSister.getProblemOrigin(),
                                sister.getExplanation(), sister.getProof(), sister.getBlocked(), sister.getBlockedBy(), false, OConstants.SISTER_ID);

                    } else if (moreThanThreeBrotherAndSister != null) {

                        createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_SISTER), OConstants.PERSON_TWO_SISTERS, OConstants.GENDER_MALE, true,
                                sister.getOriginalSharePercent(), sharePercent, sister.getSharePercent(), shareValue, sister.getShareValue(),
                                numberOfShares, sister.getNumberOfShares(), moreThanThreeBrotherAndSister.getProblemOrigin(),
                                sister.getExplanation(), sister.getProof(), sister.getBlocked(), sister.getBlockedBy(), false, OConstants.SISTER_ID);

                    } else {

                        createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_SISTER), OConstants.PERSON_TWO_SISTERS, OConstants.GENDER_MALE, true,
                                sister.getOriginalSharePercent(), sharePercent, sister.getSharePercent(), shareValue, sister.getShareValue(),
                                numberOfShares, sister.getNumberOfShares(), sister.getProblemOrigin(),
                                sister.getExplanation(), sister.getProof(), sister.getBlocked(), sister.getBlockedBy(), false, OConstants.SISTER_ID);

                    }
                } else {
                    String relation = getPersonCount(mPeople, OConstants.PERSON_SISTER) + " " + OConstants.PERSON_SISTERS;

                    if (moreThanBrotherAndSister != null) {
                        createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_SISTER), relation, OConstants.GENDER_MALE, true,
                                sister.getOriginalSharePercent(), sharePercent, sister.getSharePercent(), shareValue, sister.getShareValue(),
                                numberOfShares, sister.getNumberOfShares(), moreThanBrotherAndSister.getProblemOrigin(),
                                sister.getExplanation(), sister.getProof(), sister.getBlocked(), sister.getBlockedBy(), false, OConstants.SISTER_ID);

                    } else if (moreThanThreeBrotherAndSister != null) {

                        createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_SISTER), relation, OConstants.GENDER_MALE, true,
                                sister.getOriginalSharePercent(), sharePercent, sister.getSharePercent(), shareValue, sister.getShareValue(),
                                numberOfShares, sister.getNumberOfShares(), moreThanThreeBrotherAndSister.getProblemOrigin(),
                                sister.getExplanation(), sister.getProof(), sister.getBlocked(), sister.getBlockedBy(), false, OConstants.SISTER_ID);

                    }
                }
            }


            if (getPersonCount(mPeople, OConstants.PERSON_BROTHER) > 1) {

                resetPerson(mPeople, PERSON_BROTHER);

            }

            if (getPersonCount(mPeople, OConstants.PERSON_SISTER) > 1) {

                resetPerson(mPeople, PERSON_SISTER);

            }


            resetPerson(mPeople, PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER);
            resetPerson(mPeople, PERSON_MORE_THAN_BROTHER_OR_SISTER);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void handleFatherUncleAndAuntsResult(ArrayList<Person> mPeople) {
        try {

            Log.i(TAG, "handleFatherUncleAndAuntsResult is called");

            Person fatherUnclesAndAunts = getPerson(mPeople, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS);

            String result = "";


            if (getPersonCount(mPeople, OConstants.PERSON_FATHER_UNCLE) > 1) {

                Person fatherUncle = getPerson(mPeople, PERSON_FATHER_UNCLE);

                String relation = getPersonCount(mPeople, OConstants.PERSON_FATHER_UNCLE) + " " + OConstants.PERSON_FATHER_UNCLES;

                Fraction sharePercent;
                double shareValue;
                int numberOfShares;

                if (fatherUncle.getBlocked() != null && fatherUncle.getBlocked().matches(BLOCKED)) {
                    sharePercent = new Fraction(0, 0);
                    shareValue = 0;
                    numberOfShares = 0;
                    fatherUncle.setSharePercent(sharePercent);
                    fatherUncle.setShareValue(shareValue);
                    fatherUncle.setNumberOfShares(numberOfShares);
                } else {
                    sharePercent = new Fraction((fatherUncle.getSharePercent().getNumerator() * getPersonCount(mPeople, OConstants.PERSON_FATHER_UNCLE)), fatherUncle.getSharePercent().getDenominator());
                    shareValue = round(fatherUncle.getShareValue() * getPersonCount(mPeople, OConstants.PERSON_FATHER_UNCLE), 2);
                    numberOfShares = sharePercent.getNumerator();

                }

                if (fatherUnclesAndAunts != null) {
                    createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_FATHER_UNCLE), relation, OConstants.GENDER_MALE, true,
                            fatherUncle.getOriginalSharePercent(), sharePercent, fatherUncle.getSharePercent(), shareValue, fatherUncle.getShareValue(),
                            numberOfShares, fatherUncle.getNumberOfShares(), fatherUnclesAndAunts.getProblemOrigin(),
                            fatherUncle.getExplanation(), fatherUncle.getProof(), fatherUncle.getBlocked(), fatherUncle.getBlockedBy(), false, OConstants.FATHER_UNCLES_AND_AUNTS_ID);

                    Person person = getPerson(mPeople, relation);

                    result = "";
                    result = result.concat("--------------------------\n");
                    result += person.getRelation() + "\nShareValue = " + person.getShareValue() + " \nShare Percent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator() +
                            "\nProblem Origin = " + person.getProblemOrigin() + "\nNumber Of Shares = " + person.getNumberOfShares() + "\n";

                    result = result.concat("--------------------------\n");

                    Log.i(TAG, "handleFatherUncleAndAuntsResult(): result = " + result);

                }
            }


            if (getPersonCount(mPeople, OConstants.PERSON_FATHER_AUNT) > 1) {
                Person fatherAunt = getPerson(mPeople, PERSON_FATHER_AUNT);


                String relation = getPersonCount(mPeople, OConstants.PERSON_FATHER_AUNT) + " " + OConstants.PERSON_FATHER_AUNTS;

                Fraction sharePercent;
                double shareValue;
                int numberOfShares;

                if (fatherAunt.getBlocked() != null && fatherAunt.getBlocked().matches(BLOCKED)) {
                    sharePercent = new Fraction(0, 0);
                    shareValue = 0;
                    numberOfShares = 0;
                    fatherAunt.setSharePercent(sharePercent);
                    fatherAunt.setShareValue(shareValue);
                    fatherAunt.setNumberOfShares(numberOfShares);
                } else {
                    sharePercent = new Fraction((fatherAunt.getSharePercent().getNumerator() * getPersonCount(mPeople, OConstants.PERSON_FATHER_AUNT)), fatherAunt.getSharePercent().getDenominator());
                    shareValue = round(fatherAunt.getShareValue() * getPersonCount(mPeople, OConstants.PERSON_FATHER_AUNT), 2);
                    numberOfShares = sharePercent.getNumerator();
                }


                if (fatherUnclesAndAunts != null) {
                    createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_FATHER_AUNT), relation, OConstants.GENDER_FEMALE, true,
                            fatherAunt.getOriginalSharePercent(), sharePercent, fatherAunt.getSharePercent(), shareValue, fatherAunt.getShareValue(),
                            numberOfShares, fatherAunt.getNumberOfShares(), fatherUnclesAndAunts.getProblemOrigin(),
                            fatherAunt.getExplanation(), fatherAunt.getProof(), fatherAunt.getBlocked(), fatherAunt.getBlockedBy(), false, OConstants.FATHER_UNCLES_AND_AUNTS_ID);

                    Person person = getPerson(mPeople, relation);

                    result = "";
                    result = result.concat("--------------------------\n");
                    result += person.getRelation() + "\nShareValue = " + person.getShareValue() + " \nShare Percent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator() +
                            "\nProblem Origin = " + person.getProblemOrigin() + "\nNumber Of Shares = " + person.getNumberOfShares() + "\n";

                    result = result.concat("--------------------------\n");

                    Log.i(TAG, "handleFatherUncleAndAuntsResult(): result = " + result);

                }
            }

            if (getPersonCount(mPeople, OConstants.PERSON_FATHER_UNCLE) > 1) {

                resetPerson(mPeople, OConstants.PERSON_FATHER_UNCLE);
            }

            if (getPersonCount(mPeople, OConstants.PERSON_FATHER_AUNT) > 1) {

                resetPerson(mPeople, OConstants.PERSON_FATHER_AUNT);

            }

            resetPerson(mPeople, PERSON_FATHER_UNCLES_AND_AUNTS);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void handleMotherUncleAndAuntsResult(ArrayList<Person> mPeople) {
        try {

            Log.i(TAG, "handleMotherUncleAndAuntsResult(): is called");

            Person motherUnclesAndAunts = getPerson(mPeople, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS);

            String result = "";


            if (getPersonCount(mPeople, OConstants.PERSON_MOTHER_UNCLE) > 1) {

                Person motherUncle = getPerson(mPeople, PERSON_MOTHER_UNCLE);

                String relation = getPersonCount(mPeople, OConstants.PERSON_MOTHER_UNCLE) + " " + OConstants.PERSON_MOTHER_UNCLES;

                Fraction sharePercent;
                double shareValue;
                int numberOfShares;

                if (motherUncle.getBlocked() != null && motherUncle.getBlocked().matches(BLOCKED)) {
                    sharePercent = new Fraction(0, 0);
                    shareValue = 0;
                    numberOfShares = 0;
                    motherUncle.setSharePercent(sharePercent);
                    motherUncle.setShareValue(shareValue);
                    motherUncle.setNumberOfShares(numberOfShares);
                } else {
                    sharePercent = new Fraction((motherUncle.getSharePercent().getNumerator() * getPersonCount(mPeople, OConstants.PERSON_MOTHER_UNCLE)), motherUncle.getSharePercent().getDenominator());
                    shareValue = round(motherUncle.getShareValue() * getPersonCount(mPeople, OConstants.PERSON_MOTHER_UNCLE), 2);
                    numberOfShares = sharePercent.getNumerator();

                }

                if (motherUnclesAndAunts != null) {
                    createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_MOTHER_UNCLE), relation, OConstants.GENDER_MALE, true,
                            motherUncle.getOriginalSharePercent(), sharePercent, motherUncle.getSharePercent(), shareValue, motherUncle.getShareValue(),
                            numberOfShares, motherUncle.getNumberOfShares(), motherUnclesAndAunts.getProblemOrigin(),
                            motherUncle.getExplanation(), motherUncle.getProof(), motherUncle.getBlocked(), motherUncle.getBlockedBy(), false, OConstants.MOTHER_UNCLES_AND_AUNTS_ID);

                    Person person = getPerson(mPeople, relation);

                    result = "";
                    result = result.concat("--------------------------\n");
                    result += person.getRelation() + "\nShareValue = " + person.getShareValue() + " \nShare Percent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator() +
                            "\nProblem Origin = " + person.getProblemOrigin() + "\nNumber Of Shares = " + person.getNumberOfShares() + "\n";

                    result = result.concat("--------------------------\n");

                    Log.i(TAG, "handleMotherUncleAndAuntsResult(): result = " + result);

                }
            }


            if (getPersonCount(mPeople, OConstants.PERSON_MOTHER_AUNT) > 1) {
                Person motherAunt = getPerson(mPeople, PERSON_MOTHER_AUNT);


                String relation = getPersonCount(mPeople, OConstants.PERSON_MOTHER_AUNT) + " " + OConstants.PERSON_MOTHER_AUNTS;

                Fraction sharePercent;
                double shareValue;
                int numberOfShares;

                if (motherAunt.getBlocked() != null && motherAunt.getBlocked().matches(BLOCKED)) {
                    sharePercent = new Fraction(0, 0);
                    shareValue = 0;
                    numberOfShares = 0;
                    motherAunt.setSharePercent(sharePercent);
                    motherAunt.setShareValue(shareValue);
                    motherAunt.setNumberOfShares(numberOfShares);
                } else {
                    sharePercent = new Fraction((motherAunt.getSharePercent().getNumerator() * getPersonCount(mPeople, OConstants.PERSON_MOTHER_AUNT)), motherAunt.getSharePercent().getDenominator());
                    shareValue = round(motherAunt.getShareValue() * getPersonCount(mPeople, OConstants.PERSON_MOTHER_AUNT), 2);
                    numberOfShares = sharePercent.getNumerator();
                }

                if (motherUnclesAndAunts != null) {
                    createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_MOTHER_AUNT), relation, OConstants.GENDER_FEMALE, true,
                            motherAunt.getOriginalSharePercent(), sharePercent, motherAunt.getSharePercent(), shareValue, motherAunt.getShareValue(),
                            numberOfShares, motherAunt.getNumberOfShares(), motherUnclesAndAunts.getProblemOrigin(),
                            motherAunt.getExplanation(), motherAunt.getProof(), motherAunt.getBlocked(), motherAunt.getBlockedBy(), false, OConstants.MOTHER_UNCLES_AND_AUNTS_ID);

                    Person person = getPerson(mPeople, relation);

                    result = "";
                    result = result.concat("--------------------------\n");
                    result += person.getRelation() + "\nShareValue = " + person.getShareValue() + " \nShare Percent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator() +
                            "\nProblem Origin = " + person.getProblemOrigin() + "\nNumber Of Shares = " + person.getNumberOfShares() + "\n";

                    result = result.concat("--------------------------\n");

                    Log.i(TAG, "handleMotherUncleAndAuntsResult(): result = " + result);

                }
            }

            if (getPersonCount(mPeople, OConstants.PERSON_MOTHER_UNCLE) > 1) {

                resetPerson(mPeople, OConstants.PERSON_MOTHER_UNCLE);
            }

            if (getPersonCount(mPeople, OConstants.PERSON_MOTHER_AUNT) > 1) {

                resetPerson(mPeople, OConstants.PERSON_MOTHER_AUNT);

            }

            resetPerson(mPeople, PERSON_MOTHER_UNCLES_AND_AUNTS);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void handleWivesResult(ArrayList<Person> mPeople) {
        try {

            Log.i(TAG, "handleWivesResult(): is called");


            String result = "";

            Person moreThanWife = getPerson(mPeople, OConstants.PERSON_WIVES);
            int wivesCount = getPersonCount(mPeople, OConstants.PERSON_WIFE);

            if (wivesCount > 1) {

                Person wife = getPerson(mPeople, PERSON_WIFE);

                if (moreThanWife != null) {
                    String relation = "";
                    if (getPersonCount(mPeople, OConstants.PERSON_WIFE) == 2) {

                        relation = OConstants.PERSON_TWO_WIVES;

                    } else {
                        relation = wivesCount + " " + OConstants.PERSON_WIVES;
                    }
                    Fraction sharePercent = new Fraction((wife.getSharePercent().getNumerator() * wivesCount), wife.getSharePercent().getDenominator());
                    double shareValue = round(wife.getShareValue() * wivesCount, 2);
                    int numberOfShares = sharePercent.getNumerator();

                    createAlivePerson(mPeople, wivesCount, relation, OConstants.GENDER_FEMALE, true, wife.getOriginalSharePercent(), sharePercent, wife.getSharePercent(),
                            shareValue, wife.getShareValue(), numberOfShares, wife.getNumberOfShares(), moreThanWife.getProblemOrigin(),
                            wife.getExplanation(), wife.getProof(), wife.getBlocked(), wife.getBlockedBy(), false, OConstants.WIVES_ID);

                    Person person = getPerson(mPeople, relation);

                    result = "";
                    result = result.concat("--------------------------\n");
                    result += person.getRelation() + "\nShareValue = " + person.getShareValue() + " \nShare Percent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator() +
                            "\nProblem Origin = " + person.getProblemOrigin() + "\nNumber Of Shares = " + person.getNumberOfShares() + "\n";

                    result = result.concat("--------------------------\n");

                    Log.i(TAG, "handleWivesResult(): result = " + result);
                }
            }

            if (getPersonCount(mPeople, OConstants.PERSON_WIFE) > 1) {

                resetPerson(mPeople, OConstants.PERSON_WIFE);

                resetPerson(mPeople, OConstants.PERSON_WIVES);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleChildrenGroup(ArrayList<Person> mPeople, OConstants oConstants) {

        oConstants.isHandleChildrenGroup = true;
        oConstants.handleGroupParent = PERSON_SONS;

        if (oConstants.mPrefManager != null) {
            oConstants.mPrefManager.saveString(PrefManager.KEY_GROUP_RELATION, PERSON_SONS);
        }
        Log.i(TAG, "handleChildrenGroup(): is called");
        Person moreThanThreeDaughters = getPerson(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS);

        int heads = getChildrenInDaughters(mPeople);
        int moreThanThreeDaughtersNumberOfShares = moreThanThreeDaughters.getNumberOfShares();

        if (heads % moreThanThreeDaughtersNumberOfShares != 0) {
            Log.i(TAG, "handleChildrenGroup(): head % children problem origin != 0");


            int numberOfSharesSum = 0;
            int newProblemOrigin = 0;

            for (Person mPerson : mPeople) {
                if (!mPerson.getRelation().matches(OConstants.PERSON_SON) && !mPerson.getRelation().matches(OConstants.PERSON_DAUGHTER) &&
                        !isBlocked(mPerson) &&
                        !mPerson.getRelation().matches(OConstants.PERSON_SON_BOY) && !mPerson.getRelation().matches(OConstants.PERSON_SON_GIRL) &&
                        !mPerson.getRelation().matches(OConstants.PERSON_DAUGHTER_BOY) && !mPerson.getRelation().matches(OConstants.PERSON_DAUGHTER_GIRL)) {

                    Log.i(TAG, "handleChildrenGroup(): person = " + mPerson.getRelation() + " problem origin = " + mPerson.getProblemOrigin());
                    numberOfSharesSum += mPerson.getNumberOfShares();

                }
            }
            if (findGCD(heads, moreThanThreeDaughtersNumberOfShares) == 1) {
                Log.i(TAG, "handleChildrenGroup(): findGCD(heads, groupProblemOrigin) = 1");

                if (oConstants.mPrefManager != null) {
                    oConstants.mPrefManager.saveBoolean(PrefManager.KEY_NEW_GCD, true);
                }

                newProblemOrigin = heads * numberOfSharesSum;

                Log.i(TAG, "handleChildrenGroup(): problem Origin Sum = " + numberOfSharesSum + " - heads = " + heads);
                Log.i(TAG, "handleChildrenGroup(): new problem Origin Sum = " + newProblemOrigin);

            } else {

                if (oConstants.mPrefManager != null) {
                    oConstants.mPrefManager.saveBoolean(PrefManager.KEY_NEW_GCD, false);
                }
                Log.i(TAG, "handleChildrenGroup(): findGCD(heads, groupProblemOrigin) = " + findGCD(heads, moreThanThreeDaughtersNumberOfShares));

                newProblemOrigin = numberOfSharesSum * (heads / findGCD(heads, moreThanThreeDaughtersNumberOfShares));

                Log.i(TAG, "handleChildrenGroup(): problem Origin Sum = " + numberOfSharesSum + " - heads = " + heads);
                Log.i(TAG, "handleChildrenGroup(): new problem Origin Sum = " + newProblemOrigin);

                heads = (heads / findGCD(heads, moreThanThreeDaughtersNumberOfShares));

            }

            cacheHeads(heads, newProblemOrigin, oConstants);

            for (Person mPerson : mPeople) {
                if (!mPerson.getRelation().matches(OConstants.PERSON_SON) && !mPerson.getRelation().matches(OConstants.PERSON_DAUGHTER) &&
                        !isBlocked(mPerson) && !mPerson.getRelation().matches(OConstants.PERSON_SON_BOY) && !mPerson.getRelation().matches(OConstants.PERSON_SON_GIRL) &&
                        !mPerson.getRelation().matches(OConstants.PERSON_DAUGHTER_BOY) && !mPerson.getRelation().matches(OConstants.PERSON_DAUGHTER_GIRL)) {

                    mPerson.setProblemOrigin(newProblemOrigin);
                    mPerson.setNumberOfShares(heads * mPerson.getNumberOfShares());

                    Fraction fraction = new Fraction(mPerson.getNumberOfShares(), newProblemOrigin);
                    setPersonSharePercent(mPeople, fraction, mPerson.getRelation());

                    Log.i(TAG, "handleChildrenGroup(): person = " + mPerson.getRelation() + " problem origin = " + mPerson.getProblemOrigin() + " sharePercent = " + mPerson.getSharePercent().getNumerator() +
                            "/" + mPerson.getSharePercent().getDenominator());
                }
            }
        }
    }

    private static int getPersonNumberOfShares(Person person) {
        return person.getNumberOfShares();
    }

    private static void handleBrothersGroup(ArrayList<Person> mPeople, OConstants oConstants, Person brothersGroupObject) {

        try {
            oConstants.isHandleBrothersGroup = true;

            //check if there is more than wife or not
            // if so, handle two groups, if not just handle brothers
            if (getPersonCount(mPeople, OConstants.PERSON_WIFE) > 1 && !oConstants.isHandleWivesGroup) {
                handleWivesGroup(mPeople, oConstants);

            } else {
                Log.i(TAG, "handleBrothersGroup(): is called");

                oConstants.handleGroupParent = PERSON_BROTHERS;

                if (oConstants.mPrefManager != null) {
                    oConstants.mPrefManager.saveString(PrefManager.KEY_GROUP_RELATION, PERSON_BROTHERS);
                }

                int heads = getPersonsInGirlsCount(mPeople, OConstants.PERSON_BROTHER, OConstants.PERSON_SISTER);
                int newProblemOrigin = 0;
                int numberOfSharesSum = 0;

                int brothersNumberOfShares = brothersGroupObject.getNumberOfShares();

                for (Person mPerson : mPeople) {
                    if (!mPerson.getRelation().matches(OConstants.PERSON_BROTHER) && !mPerson.getRelation().matches(OConstants.PERSON_SISTER) &&
                            !isBlocked(mPerson)) {

                        Log.i(TAG, "handleBrothersGroup(): person = " + mPerson.getRelation() + " problem origin = " + mPerson.getProblemOrigin());
                        numberOfSharesSum += mPerson.getNumberOfShares();

                    }
                }
                if (findGCD(heads, brothersNumberOfShares) == 1) {

                    Log.i(TAG, "handleBrothersGroup(): problem Origin Sum = " + numberOfSharesSum);
                    newProblemOrigin = heads * numberOfSharesSum;

                    if (oConstants.mPrefManager != null) {
                        oConstants.mPrefManager.saveBoolean(PrefManager.KEY_NEW_GCD, true);
                    }
                } else {

                    if (oConstants.mPrefManager != null) {
                        oConstants.mPrefManager.saveBoolean(PrefManager.KEY_NEW_GCD, false);
                    }
                    Log.i(TAG, "handleBrothersGroup(): findGCD(heads, groupProblemOrigin) = " + findGCD(heads, brothersNumberOfShares));

                    newProblemOrigin = numberOfSharesSum * (heads / findGCD(heads, brothersNumberOfShares));

                    Log.i(TAG, "handleBrothersGroup(): problem Origin Sum = " + numberOfSharesSum + " - heads = " + heads);
                    Log.i(TAG, "handleBrothersGroup(): new problem Origin Sum = " + newProblemOrigin);

                    heads = (heads / findGCD(heads, brothersNumberOfShares));

                }
                cacheHeads(heads, newProblemOrigin, oConstants);


                for (Person mPerson : mPeople) {
                    if (!mPerson.getRelation().matches(OConstants.PERSON_BROTHER) && !mPerson.getRelation().matches(OConstants.PERSON_SISTER) &&
                            !isBlocked(mPerson)) {

                        mPerson.setProblemOrigin(newProblemOrigin);
                        mPerson.setNumberOfShares(heads * mPerson.getNumberOfShares());

                        Fraction fraction = new Fraction(mPerson.getNumberOfShares(), newProblemOrigin);
                        setPersonSharePercent(mPeople, fraction, mPerson.getRelation());

                        Log.i(TAG, "handleBrothersGroup(): person = " + mPerson.getRelation() + " problem origin = " + mPerson.getProblemOrigin() + " sharePercent = " + mPerson.getSharePercent().getNumerator() +
                                "/" + mPerson.getSharePercent().getDenominator());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleWivesGroup(ArrayList<Person> mPeople, OConstants oConstants) {

        try {

            Log.i(TAG, "handleWivesGroup(): is called");

            oConstants.isHandleWivesGroup = true;
            oConstants.isHandleBrothersGroup = true;
            oConstants.handleGroupParent = PERSON_WIVES;

            if (oConstants.mPrefManager != null) {
                oConstants.mPrefManager.saveString(PrefManager.KEY_GROUP_RELATION, PERSON_WIVES);
            }

            int newProblemOrigin = 0;
            int numberOfSharesSum = 0;
            int heads = getPersonCount(mPeople, OConstants.PERSON_WIFE);

            Person wife = getPerson(mPeople, OConstants.PERSON_WIFE);
            Person moreThanWife = getPerson(mPeople, OConstants.PERSON_WIVES);

            int wivesNumberOfShares = moreThanWife.getNumberOfShares();

            if ((getPerson(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS) != null && !isBlocked(getPerson(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS)))) {

                if (oConstants.mPrefManager != null) {
                    oConstants.mPrefManager.saveBoolean(PrefManager.KEY_ONE_GROUP, false);
                }

                Log.i(TAG, "handleWivesGroup(): handling wives with more than three daughter \"Two groups\"");
                oConstants.isHandleChildrenGroup = true;

                Person moreThanBrotherAndSister = getPerson(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS);

                int savedNumberOfWives = HandleTwoGroupsUtils.getGroupSavedNumber(mPeople, moreThanWife, "", OConstants.PERSON_WIFE);
                int savedNumberOfChildren = HandleTwoGroupsUtils.getGroupSavedNumber(mPeople, moreThanBrotherAndSister, OConstants.PERSON_SON, OConstants.PERSON_DAUGHTER);

                cacheSavedNumbers(oConstants, savedNumberOfWives, savedNumberOfChildren);
                Log.i(TAG, "handleWivesGroup(): wives saved number = " + savedNumberOfWives);
                Log.i(TAG, "handleWivesGroup(): children saved number = " + savedNumberOfChildren);


                // Calculating Number of shares summation
                for (Person mPerson : mPeople) {
                    if (!isBlocked(mPerson) && !mPerson.getRelation().matches(OConstants.PERSON_SON) && !mPerson.getRelation().matches(OConstants.PERSON_DAUGHTER) &&
                            !mPerson.getRelation().matches(OConstants.PERSON_WIFE)) {
                        Log.i(TAG, "handleWivesGroup(): person = " + mPerson.getRelation() + " Number Of Shares = " + mPerson.getNumberOfShares());
                        numberOfSharesSum += mPerson.getNumberOfShares();
                    }
                }
//                numberOfSharesSum += wivesNumberOfShares;
                heads = HandleTwoGroupsUtils.getSimpleCommonMultiplier(savedNumberOfChildren, savedNumberOfWives);


                newProblemOrigin = heads * numberOfSharesSum;

                cacheHeads(heads, newProblemOrigin, oConstants);

                Log.i(TAG, "handleWivesGroup(): number Of shares = " + numberOfSharesSum + " heads = " + heads + " newProblem Origin = " + newProblemOrigin);

                for (Person mPerson : mPeople) {
                    if (!isBlocked(mPerson) && !mPerson.getRelation().matches(OConstants.PERSON_SON) && !mPerson.getRelation().matches(OConstants.PERSON_DAUGHTER)
                            && !mPerson.getRelation().matches(OConstants.PERSON_WIFE)) {

                        mPerson.setProblemOrigin(newProblemOrigin);
                        mPerson.setNumberOfShares(heads * mPerson.getNumberOfShares());

                        Fraction fraction = new Fraction(mPerson.getNumberOfShares(), newProblemOrigin);
                        setPersonSharePercent(mPeople, fraction, mPerson.getRelation());

                        Log.i(TAG, "handleWivesGroup(): person = " + mPerson.getRelation() + " problem origin = " + mPerson.getProblemOrigin() + " sharePercent = " + mPerson.getSharePercent().getNumerator() +
                                "/" + mPerson.getSharePercent().getDenominator());
                    }
                }
            } else if ((getPerson(mPeople, OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER) != null && !isBlocked(getPerson(mPeople, OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER)))) {
                Log.i(TAG, "handleWivesGroup(): handling wives with brothers \"Two groups\"");
                oConstants.mPrefManager.saveBoolean(PrefManager.KEY_ONE_GROUP, false);

                Person moreThanBrotherAndSister = getPerson(mPeople, OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER);

                int savedNumberOfWives = HandleTwoGroupsUtils.getGroupSavedNumber(mPeople, moreThanWife, "", OConstants.PERSON_WIFE);
                int savedNumberOfBrothers = HandleTwoGroupsUtils.getGroupSavedNumber(mPeople, moreThanBrotherAndSister, OConstants.PERSON_BROTHER, OConstants.PERSON_SISTER);

                cacheSavedNumbers(oConstants, savedNumberOfWives, savedNumberOfBrothers);

                Log.i(TAG, "handleWivesGroup(): wives saved number = " + savedNumberOfWives);
                Log.i(TAG, "handleWivesGroup(): brothers saved number = " + savedNumberOfBrothers);


                // Calculating Number of shares summation
                for (Person mPerson : mPeople) {
                    if (!isBlocked(mPerson) && !mPerson.getRelation().matches(OConstants.PERSON_BROTHER) && !mPerson.getRelation().matches(OConstants.PERSON_SISTER) &&
                            !mPerson.getRelation().matches(OConstants.PERSON_WIFE)) {
                        Log.i(TAG, "handleWivesGroup(): person = " + mPerson.getRelation() + " problem origin = " + mPerson.getNumberOfShares());
                        numberOfSharesSum += mPerson.getNumberOfShares();
                    }
                }
//                numberOfSharesSum += wivesNumberOfShares;
                heads = HandleTwoGroupsUtils.getSimpleCommonMultiplier(savedNumberOfBrothers, savedNumberOfWives);
                newProblemOrigin = heads * numberOfSharesSum;

                cacheHeads(heads, newProblemOrigin, oConstants);
                Log.i(TAG, "handleWivesGroup(): number Of shares = " + numberOfSharesSum + " heads = " + heads + " newProblem Origin = " + newProblemOrigin);

                for (Person mPerson : mPeople) {
                    if (!isBlocked(mPerson) && !mPerson.getRelation().matches(OConstants.PERSON_BROTHER) && !mPerson.getRelation().matches(OConstants.PERSON_SISTER)
                            && !mPerson.getRelation().matches(OConstants.PERSON_WIFE)) {

                        mPerson.setProblemOrigin(newProblemOrigin);
                        mPerson.setNumberOfShares(heads * mPerson.getNumberOfShares());

                        Fraction fraction = new Fraction(mPerson.getNumberOfShares(), newProblemOrigin);
                        setPersonSharePercent(mPeople, fraction, mPerson.getRelation());

                        Log.i(TAG, "handleWivesGroup(): person = " + mPerson.getRelation() + " problem origin = " + mPerson.getProblemOrigin() + " sharePercent = " + mPerson.getSharePercent().getNumerator() +
                                "/" + mPerson.getSharePercent().getDenominator());
                    }
                }
            } else {
                Log.i(TAG, "handleWivesGroup(): handling just wives");
                oConstants.mPrefManager.saveBoolean(PrefManager.KEY_ONE_GROUP, true);

                // Calculating Number of shares summation
                for (Person mPerson : mPeople) {
                    if (!isBlocked(mPerson) && !mPerson.getRelation().matches(OConstants.PERSON_WIFE)) {
                        Log.i(TAG, "handleWivesGroup(): person = " + mPerson.getRelation() + " Number Of Shares = " + mPerson.getNumberOfShares());
                        numberOfSharesSum += mPerson.getNumberOfShares();

                    }
                }
                if (findGCD(heads, wivesNumberOfShares) == 1) {

                    Log.i(TAG, "handleWivesGroup(): number of shares Sum = " + numberOfSharesSum);
                    newProblemOrigin = heads * numberOfSharesSum;
                } else {

                    Log.i(TAG, "handleWivesGroup(): findGCD(heads, NumberOfShares) = " + findGCD(heads, wivesNumberOfShares));

                    newProblemOrigin = numberOfSharesSum * (heads / findGCD(heads, wivesNumberOfShares));

                    heads = (heads / findGCD(heads, wivesNumberOfShares));

                    Log.i(TAG, "handleWivesGroup(): number of shares Sum = " + numberOfSharesSum + " & heads = " + heads + " & new problem Origin Sum = " + newProblemOrigin);

                }

                cacheHeads(heads, newProblemOrigin, oConstants);

                for (Person mPerson : mPeople) {
                    if (!isBlocked(mPerson) && !mPerson.getRelation().matches(OConstants.PERSON_WIFE)) {

                        mPerson.setProblemOrigin(newProblemOrigin);
                        mPerson.setNumberOfShares(heads * mPerson.getNumberOfShares());

                        Fraction fraction = new Fraction(mPerson.getNumberOfShares(), newProblemOrigin);
                        setPersonSharePercent(mPeople, fraction, mPerson.getRelation());

                        Log.i(TAG, "handleWivesGroup(): person = " + mPerson.getRelation() + " problem origin = " + mPerson.getProblemOrigin()
                                + " sharePercent = " + mPerson.getSharePercent().getNumerator() + "/" + mPerson.getSharePercent().getDenominator());
                    }
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void cacheHeads(int heads, int newProblemOrigin, OConstants oConstants) {
        if (oConstants.mPrefManager != null) {
            oConstants.mPrefManager.saveInt(PrefManager.KEY_HEADS, heads);
            oConstants.mPrefManager.saveInt(PrefManager.KEY_NEW_PROBLEM_ORIGIN, newProblemOrigin);
        }

    }

    private static void cacheSavedNumbers(OConstants oConstants, int savedNumberOfWives, int savedNumberOfBrothers) {
        try {
            if (oConstants.mPrefManager != null) {
                oConstants.mPrefManager.saveInt(PrefManager.KEY_SAVED_NUMBER_1, savedNumberOfWives);
                oConstants.mPrefManager.saveInt(PrefManager.KEY_SAVED_NUMBER_2, savedNumberOfBrothers);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleUnclesGroup(ArrayList<Person> mPeople, OConstants oConstants) {

        try {

            if (!oConstants.isHandleUnclesGroup) {
                Person fatherUncles = getPerson(mPeople, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS);
                Person motherUncles = getPerson(mPeople, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS);

                if (fatherUncles != null && !isBlocked(fatherUncles) && motherUncles != null && !isBlocked(motherUncles)) {
                    oConstants.isHandleUnclesGroup = true;
                    oConstants.handleGroupParent = PERSON_FATHER_UNCLES_AND_AUNTS + PERSON_MOTHER_UNCLES_AND_AUNTS;
                    handleFatherAndMotherUncles(oConstants, mPeople);
                } else if (fatherUncles != null && !isBlocked(fatherUncles) && motherUncles == null) {
                    oConstants.isHandleUnclesGroup = true;
                    handleFatherUncles(mPeople, oConstants);
                    oConstants.handleGroupParent = PERSON_FATHER_UNCLES_AND_AUNTS;
                } else if (motherUncles != null && !isBlocked(motherUncles) && fatherUncles == null) {
                    oConstants.isHandleUnclesGroup = true;
                    handleMotherUncles(mPeople, oConstants);
                    oConstants.handleGroupParent = PERSON_MOTHER_UNCLES_AND_AUNTS;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleFatherAndMotherUncles(OConstants oConstants, ArrayList<Person> mPeople) {
        try {

            int newProblemOrigin = 0;
            int numberOfSharesSum = 0;
            int heads = 0;

            Person fatherUncles = getPerson(mPeople, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS);
            Person motherUncles = getPerson(mPeople, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS);

            int savedNumberOfFUncles = HandleTwoGroupsUtils.getGroupSavedNumber(mPeople, fatherUncles, OConstants.PERSON_FATHER_UNCLE, OConstants.PERSON_FATHER_AUNT);
            int savedNumberOfMUncles = HandleTwoGroupsUtils.getGroupSavedNumber(mPeople, motherUncles, OConstants.PERSON_MOTHER_UNCLE, OConstants.PERSON_MOTHER_AUNT);

            Log.i(TAG, "handleFatherAndMotherUncles(): Father Uncles saved number = " + savedNumberOfFUncles + " & Mother Uncles saved number = " + savedNumberOfMUncles);

            cacheSavedNumbers(oConstants, savedNumberOfFUncles, savedNumberOfMUncles);

            // Calculating Number of shares summation
            for (Person mPerson : mPeople) {
                if (!isBlocked(mPerson) && !mPerson.getRelation().matches(OConstants.PERSON_FATHER_UNCLE) && !mPerson.getRelation().matches(OConstants.PERSON_FATHER_AUNT)
                        && !mPerson.getRelation().matches(OConstants.PERSON_MOTHER_UNCLE) && !mPerson.getRelation().matches(OConstants.PERSON_MOTHER_AUNT)) {
                    Log.i(TAG, "handleFatherAndMotherUncles(): person = " + mPerson.getRelation() + " Number Of Shares = " + mPerson.getProblemOrigin());
                    numberOfSharesSum += mPerson.getNumberOfShares();
                }
            }

            heads = HandleTwoGroupsUtils.getSimpleCommonMultiplier(savedNumberOfMUncles, savedNumberOfFUncles);

            newProblemOrigin = heads * numberOfSharesSum;

            cacheHeads(heads, newProblemOrigin, oConstants);

            Log.i(TAG, "handleFatherAndMotherUncles(): number Of shares = " + numberOfSharesSum + " heads = " + heads + " newProblem Origin = " + newProblemOrigin);

            for (Person mPerson : mPeople) {
                if (!isBlocked(mPerson) && !mPerson.getRelation().matches(OConstants.PERSON_FATHER_UNCLE) && !mPerson.getRelation().matches(OConstants.PERSON_FATHER_AUNT)
                        && !mPerson.getRelation().matches(OConstants.PERSON_MOTHER_UNCLE) && !mPerson.getRelation().matches(OConstants.PERSON_MOTHER_AUNT)) {

                    mPerson.setProblemOrigin(newProblemOrigin);
                    mPerson.setNumberOfShares(heads * mPerson.getNumberOfShares());

                    Fraction fraction = new Fraction(mPerson.getNumberOfShares(), newProblemOrigin);
                    setPersonSharePercent(mPeople, fraction, mPerson.getRelation());

                    Log.i(TAG, "handleFatherAndMotherUncles(): person = " + mPerson.getRelation() + " problem origin = " + mPerson.getProblemOrigin() + " sharePercent = " + mPerson.getSharePercent().getNumerator() +
                            "/" + mPerson.getSharePercent().getDenominator());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleMotherUncles(ArrayList<Person> mPeople, OConstants oConstants) {

        try {

            Log.i(TAG, "handleMotherUncles(): is called");

            Person motherUncles = getPerson(mPeople, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS);
            int heads = getPersonsInGirlsCount(mPeople, OConstants.PERSON_MOTHER_UNCLE, OConstants.PERSON_MOTHER_AUNT);
            int newProblemOrigin = 0;
            int numberOfSharesSum = 0;

            int unclesNumberOfShares = motherUncles.getNumberOfShares();

            for (Person mPerson : mPeople) {
                if (!isBlocked(mPerson) && !mPerson.getRelation().matches(OConstants.PERSON_MOTHER_UNCLE) && !mPerson.getRelation().matches(OConstants.PERSON_MOTHER_AUNT)) {

                    Log.i(TAG, "handleMotherUncles(): person = " + mPerson.getRelation() + " problem origin = " + mPerson.getProblemOrigin());
                    numberOfSharesSum += mPerson.getNumberOfShares();

                }
            }
            if (findGCD(heads, unclesNumberOfShares) == 1) {

                Log.i(TAG, "handleMotherUncles(): number Of Shares Sum = " + numberOfSharesSum);
                newProblemOrigin = heads * numberOfSharesSum;

            } else {

                Log.i(TAG, "handleMotherUncles(): findGCD(heads, numberOfSharesSum) = " + findGCD(heads, unclesNumberOfShares));

                newProblemOrigin = numberOfSharesSum * (heads / findGCD(heads, unclesNumberOfShares));

                Log.i(TAG, "handleMotherUncles(): number Of Shares Sum = " + numberOfSharesSum + " & heads = " + heads + " & new problem Origin Sum = " + newProblemOrigin);

                heads = (heads / findGCD(heads, unclesNumberOfShares));

            }

            cacheHeads(heads, newProblemOrigin, oConstants);

            for (Person mPerson : mPeople) {
                if (!isBlocked(mPerson) && !mPerson.getRelation().matches(OConstants.PERSON_MOTHER_UNCLE) && !mPerson.getRelation().matches(OConstants.PERSON_MOTHER_AUNT)) {

                    mPerson.setProblemOrigin(newProblemOrigin);

                    mPerson.setNumberOfShares(heads * mPerson.getNumberOfShares());

                    Fraction fraction = new Fraction(mPerson.getNumberOfShares(), newProblemOrigin);
                    setPersonSharePercent(mPeople, fraction, mPerson.getRelation());

                    Log.i(TAG, "handleMotherUncles(): person = " + mPerson.getRelation() + " problem origin = " + mPerson.getProblemOrigin() + " sharePercent = " + mPerson.getSharePercent().getNumerator() +
                            "/" + mPerson.getSharePercent().getDenominator());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleFatherUncles(ArrayList<Person> mPeople, OConstants oConstants) {
        try {

            Log.i(TAG, "handleFatherUncles(): is called");

            Person fatherUncles = getPerson(mPeople, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS);

            int heads = getPersonsInGirlsCount(mPeople, OConstants.PERSON_FATHER_UNCLE, OConstants.PERSON_FATHER_AUNT);
            int newProblemOrigin = 0;
            int numberOfSharesSum = 0;

            int unclesNumberOfShares = fatherUncles.getNumberOfShares();

            for (Person mPerson : mPeople) {
                if (!isBlocked(mPerson) && !mPerson.getRelation().matches(OConstants.PERSON_FATHER_UNCLE) && !mPerson.getRelation().matches(OConstants.PERSON_FATHER_AUNT)) {

                    Log.i(TAG, "handleFatherUncles(): person = " + mPerson.getRelation() + " problem origin = " + mPerson.getProblemOrigin());
                    numberOfSharesSum += mPerson.getNumberOfShares();

                }
            }
            if (findGCD(heads, unclesNumberOfShares) == 1) {

                Log.i(TAG, "handleFatherUncles(): number Of Shares Sum = " + numberOfSharesSum);
                newProblemOrigin = heads * numberOfSharesSum;

            } else {

                Log.i(TAG, "handleFatherUncles(): findGCD(heads, numberOfSharesSum) = " + findGCD(heads, unclesNumberOfShares));

                newProblemOrigin = numberOfSharesSum * (heads / findGCD(heads, unclesNumberOfShares));

                Log.i(TAG, "handleFatherUncles(): number Of Shares Sum = " + numberOfSharesSum + " & heads = " + heads + " & new problem Origin Sum = " + newProblemOrigin);

                heads = (heads / findGCD(heads, unclesNumberOfShares));

            }

            cacheHeads(heads, newProblemOrigin, oConstants);

            for (Person mPerson : mPeople) {
                if (!isBlocked(mPerson) && !mPerson.getRelation().matches(OConstants.PERSON_FATHER_UNCLE) && !mPerson.getRelation().matches(OConstants.PERSON_FATHER_AUNT)) {

                    mPerson.setProblemOrigin(newProblemOrigin);

                    mPerson.setNumberOfShares(heads * mPerson.getNumberOfShares());

                    Fraction fraction = new Fraction(mPerson.getNumberOfShares(), newProblemOrigin);
                    setPersonSharePercent(mPeople, fraction, mPerson.getRelation());

                    Log.i(TAG, "handleFatherUncles(): person = " + mPerson.getRelation() + " problem origin = " + mPerson.getProblemOrigin() + " sharePercent = " + mPerson.getSharePercent().getNumerator() +
                            "/" + mPerson.getSharePercent().getDenominator());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isMoreThanThreeBrotherAndSister(ArrayList<Person> data, Person person, Person moreThanThreeBrotherAndSister) {
        return (person.getRelation().matches(OConstants.PERSON_BROTHER) || person.getRelation().matches(OConstants.PERSON_SISTER)) && !isBlocked(person)
                && (getPersonsInGirlsCount(data, OConstants.PERSON_BROTHER, OConstants.PERSON_SISTER) >= 3) && moreThanThreeBrotherAndSister != null;
        /* && Fraction.isEqual(person.getSharePercent(), one)*/
    }

    private static boolean isMoreThanBrotherAndSister(ArrayList<Person> data, Person person, Person moreThanBrotherAndSister) {
        return (person.getRelation().matches(OConstants.PERSON_BROTHER) || person.getRelation().matches(OConstants.PERSON_SISTER)) && !isBlocked(person)
                && moreThanBrotherAndSister != null &&
                (getPersonsInGirlsCount(data, OConstants.PERSON_BROTHER, OConstants.PERSON_SISTER) > 1)/* && (Fraction.isEqual(person.getSharePercent(), one_Third))*/;
    }

    private static boolean isMotherUnclesAndAuntsPartnerConditions(ArrayList<Person> data, Person person, Person motherUnclesAndAunts) {
        return (person.getRelation().matches(OConstants.PERSON_MOTHER_UNCLE) || person.getRelation().matches(OConstants.PERSON_MOTHER_AUNT))
                && !isBlocked(person) && (getPersonCount(data, OConstants.PERSON_MOTHER_UNCLE) + getPersonCount(data, OConstants.PERSON_MOTHER_AUNT) >= 1);

                /*(motherUnclesAndAunts != null && motherUnclesAndAunts.getSharePercent() != null
                && (Fraction.isEqual(motherUnclesAndAunts.getSharePercent(), one_Third) ||
                Fraction.isEqual(motherUnclesAndAunts.getSharePercent(), one) ||
                Fraction.isEqual(motherUnclesAndAunts.getSharePercent(), half) ||
                Fraction.isEqual(motherUnclesAndAunts.getSharePercent(), quarter)));*/
    }

    private static boolean isFatherUnclesAndAuntsPartnerConditions(ArrayList<Person> data, Person person, Person fatherUnclesAndAunts) {
        return (person.getRelation().matches(OConstants.PERSON_FATHER_UNCLE) || person.getRelation().matches(OConstants.PERSON_FATHER_AUNT))
                && !isBlocked(person) && (getPersonCount(data, OConstants.PERSON_FATHER_UNCLE) + getPersonCount(data, OConstants.PERSON_FATHER_AUNT) >= 1);
        /*(fatherUnclesAndAunts != null && fatherUnclesAndAunts.getSharePercent() != null &&
                (Fraction.isEqual(fatherUnclesAndAunts.getSharePercent(), two_Thirds) ||
                        Fraction.isEqual(fatherUnclesAndAunts.getSharePercent(), one) ||
                        Fraction.isEqual(fatherUnclesAndAunts.getSharePercent(), half) ||
                        Fraction.isEqual(fatherUnclesAndAunts.getSharePercent(), quarter))) && !isBlocked(person);*/
    }

    private static boolean isMoreThanThreeDaughter(ArrayList<Person> data, Person person, Person moreThanThreeDaughters) {
        return (person.getRelation().matches(OConstants.PERSON_DAUGHTER) || person.getRelation().matches(OConstants.PERSON_SON)) &&
                getPersonsInGirlsCount(data, OConstants.PERSON_SON, OConstants.PERSON_DAUGHTER) >= 3
                /*(person != null && person.getSharePercent() != null &&
                        (Fraction.isEqual(person.getSharePercent(), two_Thirds)))*/;
    }

    private static boolean isMoreThanWife(ArrayList<Person> data, Person person) {
        return person.getRelation().matches(OConstants.PERSON_WIFE) && (getPersonCount(data, OConstants.PERSON_WIFE) > 1);
    }

    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (isHandleChildrenGroup ? 1 : 0));
        dest.writeByte((byte) (isHandleBrothersGroup ? 1 : 0));
        dest.writeByte((byte) (isHandleWivesGroup ? 1 : 0));
        dest.writeByte((byte) (isHandleUnclesGroup ? 1 : 0));
        dest.writeString(handleGroupParent);
        dest.writeParcelable(mExplanation, flags);
        dest.writeDouble(totalMoney);
        dest.writeString(gender);
        dest.writeInt(wivesCount);
        dest.writeByte((byte) (hasChildren ? 1 : 0));
        dest.writeByte((byte) (hasWife ? 1 : 0));
        dest.writeByte((byte) (hasHusband ? 1 : 0));
        dest.writeByte((byte) (hasFather ? 1 : 0));
        dest.writeByte((byte) (hasMother ? 1 : 0));
        dest.writeByte((byte) (hasMother_GrandMother ? 1 : 0));
        dest.writeByte((byte) (hasMother_GrandFather ? 1 : 0));
        dest.writeByte((byte) (hasFather_GrandFather ? 1 : 0));
        dest.writeByte((byte) (hasFather_GrandMother ? 1 : 0));
        dest.writeByte((byte) (hasBrothersAndSisters ? 1 : 0));
    }

    private static void showResult(ArrayList<Person> mPeople) {

        try {

            String result = "";

            for (Person person : mPeople) {
                try {
                    if (person.getBlocked() == null) {


                        Log.i(TAG, " printOutput(): person Relation " + person.getRelation() + " & person Share Value = " + person.getShareValue());
                        Log.i(TAG, " printOutput(): person Share Percent " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator());
                        Log.i(TAG, " printOutput(): person Problem Origin " + person.getProblemOrigin());

                        result = "--------------------------\n";
                        result += person.getRelation() + "\nShareValue = " + person.getShareValue() + " \nShare Percent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator() +
                                "\nProblem Origin = " + person.getProblemOrigin() + "\nNumber Of Shares = " + person.getNumberOfShares() + "\n";

                        result = result.concat("--------------------------\n");

                        Log.i(TAG, result);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}