package com.company.mawarees.Model;

import android.util.Log;

import com.company.mawarees.Model.Models.Fraction;
import com.company.mawarees.Model.Models.Person;

import java.util.ArrayList;

public class OConstants {

    private static final String TAG = "OConstants";

    public boolean isHandleChildrenGroup = false;
    public boolean isHandleBrothersGroup = false;

//    public static final String PERSON_FATHER = "Father";
//    public static final String PERSON_FATHER_GRANDFATHER = "F_Grandfather";
//    public static final String PERSON_FATHER_GRANDMOTHER = "F_Grandmother";
//    public static final String PERSON_FATHER_UNCLE = "F_Uncle";
//    public static final String PERSON_FATHER_AUNT = "F_Aunt";
//    public static final String PERSON_FATHER_UNCLES_AND_AUNTS = "Father Uncles And Aunts";
//
//    public static final String PERSON_MOTHER = "Mother";
//    public static final String PERSON_MOTHER_GRANDFATHER = "M_Grandfather";
//    public static final String PERSON_MOTHER_GRANDMOTHER = "M_Grandmother";
//    public static final String PERSON_MOTHER_UNCLE = "M_Uncle";
//    public static final String PERSON_MOTHER_AUNT = "M_Aunt";
//    public static final String PERSON_MOTHER_UNCLES_AND_AUNTS = "Mother Uncles And Aunts";
//
//    public static final String PERSON_SON = "Son";
//    public static final String PERSON_SON_BOY = "SonNephew";
//    public static final String PERSON_SON_GIRL = "SonNiece";
//
//    public static final String PERSON_DAUGHTER = "Daughter";
//    public static final String PERSON_DAUGHTER_BOY = "DaughterNephew";
//    public static final String PERSON_DAUGHTER_GIRL = "DaughterNiece";
//
//    public static final String PERSON_BROTHER = "Brother";
//    public static final String PERSON_SISTER = "Sister";
//
//    public static final String PERSON_More_Than_three_DAUGHTERS = "MoreThanThreeDaughters";
//    public static final String PERSON_MORE_THAN_BROTHER_OR_SISTER = "MoreThanBrotherOrSister";
//    public static final String PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER = "MoreThanThreeBrotherAndSister";
//
//
//    public static final String PERSON_HUSBAND = "Husband";
//    public static final String PERSON_WIFE = "Wife";
//
//    public static final String GENDER_MALE = "Male";
//    public static final String GENDER_FEMALE = "Female";

    public static final String BLOCKED = "Blocked";
    public static final String NOT_BLOCKED = "NotBlocked";


    public static final String PERSON_FATHER = "أب";
    public static final String PERSON_FATHER_GRANDFATHER = "جد لأب";
    public static final String PERSON_FATHER_GRANDMOTHER = "جدة لأب";
    public static final String PERSON_FATHER_UNCLE = "عم";
    public static final String PERSON_FATHER_AUNT = "عمة";
    public static final String PERSON_FATHER_UNCLES_AND_AUNTS = "الأعمام";

    public static final String PERSON_MOTHER = "أم";
    public static final String PERSON_MOTHER_GRANDFATHER = "جد لأم";
    public static final String PERSON_MOTHER_GRANDMOTHER = "جدة لأم";
    public static final String PERSON_MOTHER_UNCLE = "خال";
    public static final String PERSON_MOTHER_AUNT = "خالة";
    public static final String PERSON_MOTHER_UNCLES_AND_AUNTS = "الأخوال";

    public static final String PERSON_SON = "ابن";
    public static final String PERSON_SONS = "ابناء";
    public static final String PERSON_TWO_SONS = "ابنان";
    public static final String PERSON_SON_BOY = "ابن الإبن";
    public static final String PERSON_SON_GIRL = "بنت الإبن";


    public static final String PERSON_DAUGHTER = "بنت";
    public static final String PERSON_DAUGHTERS = "بنات";
    public static final String PERSON_TWO_DAUGHTERS = "بنتان";
    public static final String PERSON_DAUGHTER_BOY = "ابن البنت";
    public static final String PERSON_DAUGHTER_GIRL = "بنت البنت";

    public static final String PERSON_BROTHER = "أخ";
    public static final String PERSON_BROTHERS = "اخوة";
    public static final String PERSON_TWO_BROTHERS = "أخين";
    public static final String PERSON_SISTER = "أخت";
    public static final String PERSON_SISTERS = "اخوات";
    public static final String PERSON_TWO_SISTERS = "أختان";

    public static final String PERSON_More_Than_three_DAUGHTERS = "أكثر من ثلاثة بنات";
    public static final String PERSON_MORE_THAN_BROTHER_OR_SISTER = "أكثر من أخ";
    public static final String PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER = "جمع أخوة";


    public static final String PERSON_HUSBAND = "الزوج";
    public static final String PERSON_WIFE = "الزوجة";

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

    /*--------------------------------------------------------------------------------------------*/

    public static boolean hasMoreThreeBrothersAndSisters(ArrayList<Person> data) {
        int brothers = 0, sisters = 0;

        try {
            for (Person mData : data) {
                if (mData.getRelation().matches(OConstants.PERSON_BROTHER)) {
                    brothers = mData.getCount();
                } else if (mData.getRelation().matches(OConstants.PERSON_BROTHER)) {
                    sisters = mData.getCount();
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return (brothers + sisters) > 3;
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

    /*---------------------------------------  حساب النصيب --------------------------------------*/

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

                        Y = Fraction.finalCalculationDivideFraction(person.getSharePercent(), X);
                    }
                }

                person.setSharePercent(Y); // Share Percent
                person.setProblemOrigin(person.getSharePercent().getDenominator()); // Problem Origin
                person.setNumberOfShares(person.getSharePercent().getNumerator()); // Number Of Shares

                Log.i(TAG, "calculateShareValue(): Person = " + person.getRelation() +
                        " & sharePercent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator() +
                        " & Problem Origin = " + person.getProblemOrigin() + " & Person Number of Shares = " + person.getNumberOfShares());

                calculatePersonShareValue(person, oConstants, !specialCaseRemainPeople.isEmpty(), X);
            } else {
                if (isRemainPerson(data, person))
                    handleRemainPerson(data, X);
            }
        }

//        if (!specialCaseRemainPeople.isEmpty())
//            handleRemainPerson(data, X);
        if (!partners.isEmpty())
            handlePartnerPeople(data, oConstants, X);

        handleDeadSonsAndDaughters(data);
    }

    private static void calculatePersonShareValue(Person person, OConstants oConstants, boolean isHasRemainPeople, Fraction X) {

        try {

            double money = 0;
            if (isHasRemainPeople) {

                money = oConstants.getTotalMoney() * ((double) X.getNumerator() / (double) X.getDenominator());
                remain = oConstants.getTotalMoney() - money;
                //money = oConstants.getTotalMoney(); // TODO I Don't Know if right or not

                Log.i(TAG, "calculatePersonShareValue(): Has Remain People And Money =  = " + money + " & remain = " + remain);

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

    private static void setMoreThanThreeDaughters(ArrayList<Person> data, Person person, Fraction sharePercents, double totalMoney, Person moreThanThreeDaughters, OConstants oConstants) {
        try {
            Log.i(TAG, "setMoreThanThreeDaughters(): is called");
            int girlsCount = OConstants.getChildrenInDaughters(data);

            if (!oConstants.isHandleChildrenGroup)
                handleChildrenGroup(data, oConstants);

            int girlsCountInEvenNum = girlsCount % 2 != 0 ? girlsCount - 1 : girlsCount;

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

            if (!oConstants.isHandleBrothersGroup)
                handleBrothersGroup(data, oConstants);

            int girlsCount = OConstants.getPersonsInGirlsCount(data, OConstants.PERSON_BROTHER, OConstants.PERSON_SISTER);
            Person person1 = getPerson(data, OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER);
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

            if (!oConstants.isHandleBrothersGroup)
                handleBrothersGroup(data, oConstants);

            int girlsCount = OConstants.getPersonsInGirlsCount(data, OConstants.PERSON_BROTHER, OConstants.PERSON_SISTER);

            Person person1 = getPerson(data, OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER);
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

    private static void setFatherUnclesAndAunts(ArrayList<Person> data, Person person, Fraction sharePercents) {
        int girlsCount = OConstants.getPersonsInGirlsCount(data, OConstants.PERSON_FATHER_UNCLE, OConstants.PERSON_FATHER_AUNT);

        double eachPersonValue = 0;
        if (Fraction.isEqual(sharePercents, OConstants.half)) {

            double halfOfRemain = (remain / 2);
            eachPersonValue = halfOfRemain / girlsCount;


        } else if (Fraction.isEqual(sharePercents, OConstants.two_Thirds)) {

            double twoThirdRemain = (remain / 3);
            eachPersonValue = twoThirdRemain / girlsCount;

        } else if (Fraction.isEqual(sharePercents, OConstants.quarter)) {

            double twoThirdRemain = (remain / 4);
            eachPersonValue = twoThirdRemain / girlsCount;

        } else if (Fraction.isEqual(sharePercents, OConstants.one)) {

            double twoThirdRemain = (remain);
            eachPersonValue = twoThirdRemain / girlsCount;

        }

        if (person.getRelation().matches(OConstants.PERSON_FATHER_UNCLE)) {
            person.setShareValue(round((eachPersonValue * 2), 2));
        } else if (person.getRelation().matches(OConstants.PERSON_FATHER_AUNT)) {
            person.setShareValue(round(eachPersonValue, 2));
        }
    }

    private static void setMotherUnclesAndAunts(ArrayList<Person> data, Person person, Fraction sharePercents) {
        int girlsCount = OConstants.getPersonsInGirlsCount(data, OConstants.PERSON_MOTHER_UNCLE, OConstants.PERSON_MOTHER_AUNT);

        double eachPersonValue = 0;
        if (Fraction.isEqual(sharePercents, OConstants.half)) {

            double halfOfRemain = (remain / 2);
            eachPersonValue = halfOfRemain / girlsCount;


        } else if (Fraction.isEqual(sharePercents, OConstants.one_Third)) {

            double twoThirdRemain = (remain / 3);
            eachPersonValue = twoThirdRemain / girlsCount;

        } else if (Fraction.isEqual(sharePercents, OConstants.quarter)) {

            double twoThirdRemain = (remain / 4);
            eachPersonValue = twoThirdRemain / girlsCount;

        } else if (Fraction.isEqual(sharePercents, OConstants.one)) {

            double twoThirdRemain = (remain);
            eachPersonValue = twoThirdRemain / girlsCount;

        }

        if (person.getRelation().matches(OConstants.PERSON_MOTHER_UNCLE)) {
            person.setShareValue((round((eachPersonValue * 2), 2)));
        } else if (person.getRelation().matches(OConstants.PERSON_MOTHER_AUNT)) {
            person.setShareValue((round(eachPersonValue, 2)));
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

        }/* else if (person.getRelation().matches(OConstants.PERSON_FATHER_UNCLE) || person.getRelation().matches(OConstants.PERSON_FATHER_AUNT) &&
                (fatherUnclesAndAunts != null && fatherUnclesAndAunts.getSharePercent() != null && Fraction.isEqual(fatherUnclesAndAunts.getSharePercent(), half))) {
            //When Father uncles and/or aunts has 1/2
            Log.i(TAG, "isRemainPerson(): When Father uncles and/or aunts has 1/2");
            return true;

        } else if (person.getRelation().matches(OConstants.PERSON_MOTHER_UNCLE) || person.getRelation().matches(OConstants.PERSON_MOTHER_AUNT) &&
                (motherUnclesAndAunts != null && motherUnclesAndAunts.getSharePercent() != null && Fraction.isEqual(motherUnclesAndAunts.getSharePercent(), half))) {
            //When Mother uncles and/or aunts has 1/2
            Log.i(TAG, "isRemainPerson(): When Mother uncles and/or aunts has 1/2");
            return true;

        }*/
        if (person.getSharePercent() != null) {
            Log.i(TAG, "person = " + person.getRelation() + " with sharePercent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator() + " is Not a remain person");
        } else {
            Log.i(TAG, "person = " + person.getRelation() + " with sharePercent = null is Not a remain person");
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

            if (isMoreThanThreeDaughter(person, moreThanThreeDaughters)) {

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

            } else if (isFatherUnclesAndAuntsPartnerConditions(person, fatherUnclesAndAunts)) {

                //When Father uncles and/or aunts has 2/3
                Log.i(TAG, "isPartnerPerson(): When Father uncles and/or aunts has 2/3");
                return true;

            } else if (isMotherUnclesAndAuntsPartnerConditions(person, motherUnclesAndAunts)) {

                //When Mother uncles and/or aunts has 1/3
                Log.i(TAG, "isPartnerPerson(): When Mother uncles and/or aunts has 1/3");
                return true;

            } else if (isMoreThanBrotherAndSister(person, moreThanBrotherAndSister)) {

                //When More than brother and sister and has 1/3
                Log.i(TAG, "isPartnerPerson(): When More than brother and sister and has 1/3");
                return true;

            } else if (isMoreThanThreeBrotherAndSister(person, moreThanThreeBrotherAndSister)) {

                //When More than three brother and sister and has 24/24
                Log.i(TAG, "isPartnerPerson(): When More than three brother and sister and has 1/3");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.i(TAG, "Not a partner person");
        return false;
    }

    private static boolean isBlocked(Person person) {
        if (person.getBlocked() != null)
            Log.i(TAG, "isBlocked(): " + person.getRelation() + " is " + person.getBlocked());

        return person.getBlocked() != null && person.getBlocked().matches(BLOCKED);
    }

    private static void handleRemainPerson(ArrayList<Person> data, Fraction X) {

        Person fatherUnclesAndAunts = getPerson(data, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS);
        Person motherUnclesAndAunts = getPerson(data, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS);

        for (Person person : data) {
            if (!isBlocked(person)) {

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
                        Log.i(TAG, "handleRemainPerson(): Mother Takes the rest");

                    } else if (Fraction.isEqual(person.getSharePercent(), half)) {
                        person.setShareValue(round((remain / 2), 2));
                        Fraction newFraction = new Fraction(X.getNumerator(), X.getDenominator());

                        Fraction.subtractFractions(newFraction, new Fraction(24, 24));

                        newFraction = Fraction.divideFraction(newFraction, new Fraction(1, 2));

                        person.setSharePercent(newFraction);
                        person.setProblemOrigin(newFraction.getDenominator());
                        person.setNumberOfShares(newFraction.getNumerator());

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
                        Log.i(TAG, "handleRemainPerson(): Father Takes the half of the Rest");
                        Log.i(TAG, "handleRemainPerson(): person " + person.getRelation() + " has sharePercent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator());
                    }


                }/* else if (person.getRelation().matches(OConstants.PERSON_FATHER_UNCLE) || person.getRelation().matches(OConstants.PERSON_FATHER_AUNT) &&
                        (fatherUnclesAndAunts != null && fatherUnclesAndAunts.getSharePercent() != null && Fraction.isEqual(fatherUnclesAndAunts.getSharePercent(), half))) {
                    //When Father uncles and/or aunts has 1/2
                    Log.i(TAG, "handleRemainPerson(): When Father uncles and/or aunts has 1/2");

                    setFatherUnclesAndAunts(data, person, half);

                } else if (person.getRelation().matches(OConstants.PERSON_MOTHER_UNCLE) || person.getRelation().matches(OConstants.PERSON_MOTHER_AUNT) &&
                        (motherUnclesAndAunts != null && motherUnclesAndAunts.getSharePercent() != null && Fraction.isEqual(motherUnclesAndAunts.getSharePercent(), half))) {
                    //When Mother uncles and/or aunts has 1/2
                    Log.i(TAG, "handleRemainPerson(): When Mother uncles and/or aunts has 1/2");
                    setMotherUnclesAndAunts(data, person, half);

                }*/
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

                    if (isMoreThanThreeDaughter(person, moreThanThreeDaughters)) {

                        //When sons and daughters count >= 3
                        Log.i(TAG, "handlePartnerPeople(): person = " + person.getRelation() + " & Daughters >= 3 " + getChildrenInDaughters(data) + " is a special Case");
                        setMoreThanThreeDaughters(data, person, two_Thirds, moreThanThreeDaughters.getShareValue(), moreThanThreeDaughters, oConstants);

                    } else if (isFatherUnclesAndAuntsPartnerConditions(person, fatherUnclesAndAunts)) {

                        //When Father uncles and/or aunts has 2/3 or half or quarter or all
                        Log.i(TAG, "handlePartnerPeople(): When Father uncles and/or aunts has 2/3");
                        setFatherUnclesAndAunts(data, person, fatherUnclesAndAunts.getSharePercent());

                    } else if (isMotherUnclesAndAuntsPartnerConditions(person, motherUnclesAndAunts)) {

                        //When Mother uncles and/or aunts has 1/3
                        Log.i(TAG, "handlePartnerPeople(): When Mother uncles and/or aunts has 1/3");
                        setMotherUnclesAndAunts(data, person, motherUnclesAndAunts.getSharePercent());

                    } else if (isMoreThanBrotherAndSister(person, moreThanBrotherAndSister)) {

                        //When More than brother and sister and has 1/3
                        Log.i(TAG, "handlePartnerPeople(): When More than brother and sister and has 1/3");
                        setMoreThanBrotherAndSister(data, person, one_Third, oConstants.getTotalMoney(), X, oConstants);

                    } else if (isMoreThanThreeBrotherAndSister(person, moreThanThreeBrotherAndSister)) {

                        //When More than three brother and sister and has 1/3
                        Log.i(TAG, "handlePartnerPeople(): When More than three brother and sister and has 1/3");
                        setMoreThanThreeBrotherAndSister(data, person, one, oConstants.getTotalMoney(), oConstants);
                    }/* else if (person.getRelation().matches(OConstants.PERSON_SISTER) && getPersonCount(data, OConstants.PERSON_SISTER) == 2 && getPersonCount(data, OConstants.PERSON_SON) == 0) {
                        //TODO two Sisters partners in two_third
                        setTwoSistersPartners(person, oConstants.getTotalMoney());
                    }*/
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void setTwoSistersPartners(Person person, double totalMoney) {
        try {

            double eachPersonValue = (totalMoney * ((double) (7 / 24)));
            person.setShareValue(round(eachPersonValue, 2));


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

                if (getPersonCount(mPeople, OConstants.PERSON_BROTHER) == 2) {

                    if (moreThanBrotherAndSister != null) {
                        createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_BROTHER), OConstants.PERSON_TWO_BROTHERS, OConstants.GENDER_MALE, true,
                                moreThanBrotherAndSister.getSharePercent(), brother.getSharePercent(), moreThanBrotherAndSister.getShareValue(), brother.getShareValue(),
                                moreThanBrotherAndSister.getNumberOfShares(), brother.getNumberOfShares(), moreThanBrotherAndSister.getProblemOrigin(), brother.getExplanation(), brother.getProof());

                    } else if (moreThanThreeBrotherAndSister != null) {

                        createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_BROTHER), OConstants.PERSON_TWO_BROTHERS, OConstants.GENDER_MALE, true,
                                moreThanThreeBrotherAndSister.getSharePercent(), brother.getSharePercent(), moreThanThreeBrotherAndSister.getShareValue(), brother.getShareValue(),
                                moreThanThreeBrotherAndSister.getNumberOfShares(), brother.getNumberOfShares(), moreThanThreeBrotherAndSister.getProblemOrigin(), brother.getExplanation(), brother.getProof());

                    }
                } else {
                    String relation = getPersonCount(mPeople, OConstants.PERSON_BROTHER) + " " + OConstants.PERSON_BROTHERS;

                    if (moreThanBrotherAndSister != null) {

                        createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_BROTHER), relation, OConstants.GENDER_MALE, true,
                                moreThanBrotherAndSister.getSharePercent(), brother.getSharePercent(), moreThanBrotherAndSister.getShareValue(), brother.getShareValue(),
                                moreThanBrotherAndSister.getNumberOfShares(), brother.getNumberOfShares(), moreThanBrotherAndSister.getProblemOrigin(), brother.getExplanation(), brother.getProof());

                    } else if (moreThanThreeBrotherAndSister != null) {

                        createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_BROTHER), relation, OConstants.GENDER_MALE, true,
                                moreThanThreeBrotherAndSister.getSharePercent(), brother.getSharePercent(), moreThanThreeBrotherAndSister.getShareValue(), brother.getShareValue(),
                                moreThanThreeBrotherAndSister.getNumberOfShares(), brother.getNumberOfShares(), moreThanThreeBrotherAndSister.getProblemOrigin(), brother.getExplanation(), brother.getProof());

                    }
                }
            }

            if (getPersonCount(mPeople, OConstants.PERSON_SISTER) > 1) {
                Person sister = getPerson(mPeople, OConstants.PERSON_SISTER);

                if (getPersonCount(mPeople, OConstants.PERSON_SISTER) == 2) {
                    if (moreThanBrotherAndSister != null) {
                        createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_SISTER), OConstants.PERSON_TWO_SISTERS, OConstants.GENDER_MALE, true,
                                moreThanBrotherAndSister.getSharePercent(), sister.getSharePercent(), moreThanBrotherAndSister.getShareValue(), sister.getShareValue(),
                                moreThanBrotherAndSister.getNumberOfShares(), sister.getNumberOfShares(), moreThanBrotherAndSister.getProblemOrigin(), sister.getExplanation(), sister.getProof());

                    } else if (moreThanThreeBrotherAndSister != null) {

                        createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_SISTER), OConstants.PERSON_TWO_SISTERS, OConstants.GENDER_MALE, true,
                                moreThanThreeBrotherAndSister.getSharePercent(), sister.getSharePercent(), moreThanThreeBrotherAndSister.getShareValue(), sister.getShareValue(),
                                moreThanThreeBrotherAndSister.getNumberOfShares(), sister.getNumberOfShares(), moreThanThreeBrotherAndSister.getProblemOrigin(), sister.getExplanation(), sister.getProof());

                    }
                } else {
                    String relation = getPersonCount(mPeople, OConstants.PERSON_SISTER) + " " + OConstants.PERSON_SISTERS;

                    if (moreThanBrotherAndSister != null) {
                        createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_SISTER), relation, OConstants.GENDER_MALE, true,
                                moreThanBrotherAndSister.getSharePercent(), sister.getSharePercent(), moreThanBrotherAndSister.getShareValue(), sister.getShareValue(),
                                moreThanBrotherAndSister.getNumberOfShares(), sister.getNumberOfShares(), moreThanBrotherAndSister.getProblemOrigin(), sister.getExplanation(), sister.getProof());

                    } else if (moreThanThreeBrotherAndSister != null) {

                        createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_SISTER), relation, OConstants.GENDER_MALE, true,
                                moreThanThreeBrotherAndSister.getSharePercent(), sister.getSharePercent(), moreThanThreeBrotherAndSister.getShareValue(), sister.getShareValue(),
                                moreThanThreeBrotherAndSister.getNumberOfShares(), sister.getNumberOfShares(), moreThanThreeBrotherAndSister.getProblemOrigin(), sister.getExplanation(), sister.getProof());

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


    private static void createAlivePerson(ArrayList<Person> data, int size, String relation, String gender, boolean isAlive, Fraction sharePercent,
                                          Fraction eachPersonSharePercent, double shareValue, double eachPersonShareValue, int numberOfShares,
                                          int eachPersonNumberOfShares, int problemOrigin, String explanation, String proof) {
        try {

            Person person = new Person();
            person.setAlive(isAlive);
            person.setCount(size);
            person.setRelation(relation);
            person.setGender(gender);
            person.setDeadSonNumber(-1);
            person.setProblemOrigin(problemOrigin);
            person.setSharePercent(sharePercent);
            person.setEachPersonSharePercent(eachPersonSharePercent);
            person.setShareValue(shareValue);
            person.setEachPersonShareValue(eachPersonShareValue);
            person.setNumberOfShares(numberOfShares);
            person.setEachPersonNumberOfShares(eachPersonNumberOfShares);
            person.setExplanation(explanation);
            person.setProof(proof);

            data.add(person);


            Log.i(TAG, "createAlivePerson() person relation = " + relation + " & Alive = " + isAlive + " & gender = " + gender + " created");
            Log.i(TAG, "createAlivePerson() people size = " + data.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void handleMoreThanSonAndDaughter(ArrayList<Person> mPeople, OConstants oConstants) {

        try {

            Log.i(TAG, "handleMoreThanSonAndDaughter is called");

            Person moreThanThreeDaughters = getPerson(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS);

            String result = "";


            if (getPersonCount(mPeople, OConstants.PERSON_SON) > 1) {

                Person son = getPerson(mPeople, PERSON_SON);

                if (getPersonCount(mPeople, OConstants.PERSON_SON) == 2) {

                    if (moreThanThreeDaughters != null) {
                        createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_SISTER), OConstants.PERSON_TWO_SONS, OConstants.GENDER_MALE, true,
                                moreThanThreeDaughters.getSharePercent(), son.getSharePercent(), moreThanThreeDaughters.getShareValue(), son.getShareValue(),
                                moreThanThreeDaughters.getNumberOfShares(), son.getNumberOfShares(), moreThanThreeDaughters.getProblemOrigin(), son.getExplanation(), son.getProof());

                        Person person = getPerson(mPeople, OConstants.PERSON_TWO_SONS);

                        result = "";
                        result = result.concat("--------------------------\n");
                        result += person.getRelation() + "\nShareValue = " + person.getShareValue() + " \nShare Percent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator() +
                                "\nProblem Origin = " + person.getProblemOrigin() + "\nNumber Of Shares = " + person.getNumberOfShares() + "\n";

                        result = result.concat("--------------------------\n");

                        Log.i(TAG, "handleMoreThanSonAndDaughter(): result = " + result);

                    }
                } else {
                    String relation = getPersonCount(mPeople, OConstants.PERSON_SON) + " " + OConstants.PERSON_SONS;

                    if (moreThanThreeDaughters != null) {
                        createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_SON), relation, OConstants.GENDER_MALE, true,
                                moreThanThreeDaughters.getSharePercent(), son.getSharePercent(), moreThanThreeDaughters.getShareValue(), son.getShareValue(),
                                moreThanThreeDaughters.getNumberOfShares(), son.getNumberOfShares(), moreThanThreeDaughters.getProblemOrigin(), son.getExplanation(), son.getProof());

                        Person person = getPerson(mPeople, relation);

                        result = "";
                        result = result.concat("--------------------------\n");
                        result += person.getRelation() + "\nShareValue = " + person.getShareValue() + " \nShare Percent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator() +
                                "\nProblem Origin = " + person.getProblemOrigin() + "\nNumber Of Shares = " + person.getNumberOfShares() + "\n";

                        result = result.concat("--------------------------\n");

                        Log.i(TAG, "handleMoreThanSonAndDaughter(): result = " + result);

                    }
                }
            }

            if (getPersonCount(mPeople, OConstants.PERSON_DAUGHTER) > 1) {
                Person daughter = getPerson(mPeople, PERSON_DAUGHTER);

                if (getPersonCount(mPeople, OConstants.PERSON_DAUGHTER) == 2) {

                    if (moreThanThreeDaughters != null) {
                        createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_SON), OConstants.PERSON_TWO_DAUGHTERS, OConstants.GENDER_MALE, true,
                                moreThanThreeDaughters.getSharePercent(), daughter.getSharePercent(), moreThanThreeDaughters.getShareValue(), daughter.getShareValue(),
                                moreThanThreeDaughters.getNumberOfShares(), daughter.getNumberOfShares(), moreThanThreeDaughters.getProblemOrigin(), daughter.getExplanation(), daughter.getProof());


                        Person person = getPerson(mPeople, PERSON_TWO_DAUGHTERS);

                        result = "";
                        result = result.concat("--------------------------\n");
                        result += person.getRelation() + "\nShareValue = " + person.getShareValue() + " \nShare Percent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator() +
                                "\nProblem Origin = " + person.getProblemOrigin() + "\nNumber Of Shares = " + person.getNumberOfShares() + "\n";

                        result = result.concat("--------------------------\n");

                        Log.i(TAG, "handleMoreThanSonAndDaughter(): result = " + result);

                    }
                } else {
                    String relation = getPersonCount(mPeople, OConstants.PERSON_DAUGHTER) + " " + OConstants.PERSON_DAUGHTERS;

                    if (moreThanThreeDaughters != null) {
                        createAlivePerson(mPeople, getPersonCount(mPeople, OConstants.PERSON_DAUGHTER), relation, OConstants.GENDER_FEMALE, true,
                                moreThanThreeDaughters.getSharePercent(), daughter.getSharePercent(), moreThanThreeDaughters.getShareValue(), daughter.getShareValue(),
                                moreThanThreeDaughters.getNumberOfShares(), daughter.getNumberOfShares(), moreThanThreeDaughters.getProblemOrigin(), daughter.getExplanation(), daughter.getProof());

                        Person person = getPerson(mPeople, relation);

                        result = "";
                        result = result.concat("--------------------------\n");
                        result += person.getRelation() + "\nShareValue = " + person.getShareValue() + " \nShare Percent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator() +
                                "\nProblem Origin = " + person.getProblemOrigin() + "\nNumber Of Shares = " + person.getNumberOfShares() + "\n";

                        result = result.concat("--------------------------\n");

                        Log.i(TAG, "handleMoreThanSonAndDaughter(): result = " + result);

                    }
                }
            }

            if (getPersonCount(mPeople, OConstants.PERSON_SON) > 1) {

                resetPerson(mPeople, OConstants.PERSON_SON);
            }

            if (getPersonCount(mPeople, OConstants.PERSON_DAUGHTER) > 1) {

                resetPerson(mPeople, OConstants.PERSON_DAUGHTER);

            }

            resetPerson(mPeople, PERSON_More_Than_three_DAUGHTERS);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleChildrenGroup(ArrayList<Person> mPeople, OConstants oConstants) {

        oConstants.isHandleChildrenGroup = true;

        Log.i(TAG, "handleChildrenGroup(): is called");
        Person moreThanThreeDaughters = getPerson(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS);

        int heads = getChildrenInDaughters(mPeople);

        int problemOriginSum = 0;
        for (Person mPerson : mPeople) {
            if (!mPerson.getRelation().matches(OConstants.PERSON_SON) && !mPerson.getRelation().matches(OConstants.PERSON_DAUGHTER) &&
                    !isBlocked(mPerson) &&
                    !mPerson.getRelation().matches(OConstants.PERSON_SON_BOY) && !mPerson.getRelation().matches(OConstants.PERSON_SON_GIRL) &&
                    !mPerson.getRelation().matches(OConstants.PERSON_DAUGHTER_BOY) && !mPerson.getRelation().matches(OConstants.PERSON_DAUGHTER_GIRL)) {

                Log.i(TAG, "handleChildrenGroup(): person = " + mPerson.getRelation() + " problem origin = " + mPerson.getProblemOrigin());
                problemOriginSum += mPerson.getNumberOfShares();

            }
        }

        Log.i(TAG, "handleChildrenGroup(): problem Origin Sum = " + problemOriginSum);
        int newProblemOrigin = heads * problemOriginSum;

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

    private static void handleBrothersGroup(ArrayList<Person> mPeople, OConstants oConstants) {

        try {
            oConstants.isHandleBrothersGroup = true;

            Log.i(TAG, "handleBrothersGroup(): is called");

            int heads = getPersonsInGirlsCount(mPeople, OConstants.PERSON_BROTHER, OConstants.PERSON_SISTER);

            int problemOriginSum = 0;
            for (Person mPerson : mPeople) {
                if (!mPerson.getRelation().matches(OConstants.PERSON_BROTHER) && !mPerson.getRelation().matches(OConstants.PERSON_SISTER) &&
                        !isBlocked(mPerson)) {

                    Log.i(TAG, "handleBrothersGroup(): person = " + mPerson.getRelation() + " problem origin = " + mPerson.getProblemOrigin());
                    problemOriginSum += mPerson.getNumberOfShares();

                }
            }

            Log.i(TAG, "handleBrothersGroup(): problem Origin Sum = " + problemOriginSum);
            int newProblemOrigin = heads * problemOriginSum;

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isMoreThanThreeBrotherAndSister(Person person, Person moreThanThreeBrotherAndSister) {
        return (person.getRelation().matches(OConstants.PERSON_BROTHER) || person.getRelation().matches(OConstants.PERSON_SISTER)) &&
                Fraction.isEqual(person.getSharePercent(), one);
    }

    private static boolean isMoreThanBrotherAndSister(Person person, Person moreThanBrotherAndSister) {
        return (person.getRelation().matches(OConstants.PERSON_BROTHER) || person.getRelation().matches(OConstants.PERSON_SISTER)) &&
                (Fraction.isEqual(person.getSharePercent(), one_Third));
    }

    private static boolean isMotherUnclesAndAuntsPartnerConditions(Person person, Person motherUnclesAndAunts) {
        return (person.getRelation().matches(OConstants.PERSON_MOTHER_UNCLE) || person.getRelation().matches(OConstants.PERSON_MOTHER_AUNT)) &&
                (motherUnclesAndAunts != null && motherUnclesAndAunts.getSharePercent() != null
                        && (Fraction.isEqual(motherUnclesAndAunts.getSharePercent(), one_Third) ||
                        Fraction.isEqual(motherUnclesAndAunts.getSharePercent(), one) ||
                        Fraction.isEqual(motherUnclesAndAunts.getSharePercent(), half) ||
                        Fraction.isEqual(motherUnclesAndAunts.getSharePercent(), quarter)));
    }

    private static boolean isFatherUnclesAndAuntsPartnerConditions(Person person, Person fatherUnclesAndAunts) {
        return (person.getRelation().matches(OConstants.PERSON_FATHER_UNCLE) || person.getRelation().matches(OConstants.PERSON_FATHER_AUNT)) &&
                (fatherUnclesAndAunts != null && fatherUnclesAndAunts.getSharePercent() != null &&
                        (Fraction.isEqual(fatherUnclesAndAunts.getSharePercent(), two_Thirds) ||
                                Fraction.isEqual(fatherUnclesAndAunts.getSharePercent(), one) ||
                                Fraction.isEqual(fatherUnclesAndAunts.getSharePercent(), half) ||
                                Fraction.isEqual(fatherUnclesAndAunts.getSharePercent(), quarter)));
    }

    private static boolean isMoreThanThreeDaughter(Person person, Person moreThanThreeDaughters) {
        return (person.getRelation().matches(OConstants.PERSON_DAUGHTER) || person.getRelation().matches(OConstants.PERSON_SON)) &&
                (person != null && person.getSharePercent() != null &&
                        (Fraction.isEqual(person.getSharePercent(), two_Thirds)));
    }


}
