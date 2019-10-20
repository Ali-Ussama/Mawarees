package com.company.mawarees.Model;

import android.util.Log;

import com.company.mawarees.Model.Models.Fraction;
import com.company.mawarees.Model.Models.Person;

import java.util.ArrayList;

public class OConstants {
    private static final String TAG = "OConstants";

    public static final String PERSON_FATHER = "Father";
    public static final String PERSON_FATHER_GRANDFATHER = "F_Grandfather";
    public static final String PERSON_FATHER_GRANDMOTHER = "F_Grandmother";
    public static final String PERSON_FATHER_UNCLE = "F_Uncle";
    public static final String PERSON_FATHER_AUNT = "F_Aunt";
    public static final String PERSON_FATHER_UNCLES_AND_AUNTS = "Father Uncles And Aunts";

    public static final String PERSON_MOTHER = "Mother";
    public static final String PERSON_MOTHER_GRANDFATHER = "M_Grandfather";
    public static final String PERSON_MOTHER_GRANDMOTHER = "M_Grandmother";
    public static final String PERSON_MOTHER_UNCLE = "M_Uncle";
    public static final String PERSON_MOTHER_AUNT = "M_Aunt";
    public static final String PERSON_MOTHER_UNCLES_AND_AUNTS = "Mother Uncles And Aunts";

    public static final String PERSON_SON = "Son";
    public static final String PERSON_SON_BOY = "SonNephew";
    public static final String PERSON_SON_GIRL = "SonNiece";

    public static final String PERSON_DAUGHTER = "Daughter";
    public static final String PERSON_DAUGHTER_BOY = "DaughterNephew";
    public static final String PERSON_DAUGHTER_GIRL = "DaughterNiece";

    public static final String PERSON_BROTHER = "Brother";
    public static final String PERSON_SISTER = "Sister";
    public static final String PERSON_More_Than_three_DAUGHTERS = "MoreThanThreeDaughters";
    public static final String PERSON_MORE_THAN_BROTHER_OR_SISTER = "MoreThanBrotherOrSister";
    public static final String PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER = "MoreThanThreeBrotherAndSister";

    public static final String PERSON_HUSBAND = "Husband";
    public static final String PERSON_WIFE = "Wife";

    public static final String GENDER_MALE = "Male";
    public static final String GENDER_FEMALE = "Female";

    public static final String BLOCKED = "Blocked";
    public static final String NOT_BLOCKED = "NotBlocked";

    /*------------------------------------------------ النسب -------------------------------------*/

    public static final Fraction one = new Fraction(24, 24); // واحد صحيح

    public static final Fraction half = new Fraction(12, 24); // النصف

    public static final Fraction quarter = new Fraction(3, 24); // الربع

    public static final Fraction one_Third = new Fraction(8, 24); // الثلث

    public static final Fraction two_Thirds = new Fraction(16, 24); // الثلثين

    public static final Fraction one_Sixth = new Fraction(4, 24); // السدس

    public static final Fraction fifth_Sixth = new Fraction(20, 24); // خمسة أسداس

    public static final Fraction one_eighth = new Fraction(3, 24); // ثمن

    public static final Fraction fourteenth_TwentyFourth = new Fraction(14, 24); // 14/24

    public static final Fraction fourteenth_FourtyEighth = new Fraction(7, 24); // 7/24

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

    public static ArrayList<Person> blockPerson(ArrayList<Person> data, String relation) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getRelation().matches(relation)) {
                data.get(i).setBlocked(OConstants.BLOCKED);
            }
        }
        return data;
    }

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
                data.get(i).setSharePercent(fraction);
            }
        }
    }

    public static void calculateShareValue(ArrayList<Person> data, OConstants oConstants) {

        remain = oConstants.getTotalMoney();
        // ص = ن / س
        Fraction X, Y, N;
        X = new Fraction(0, 24);
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
                Log.i(TAG, "calculateShareValue(): person " + person.getRelation() + " Has Special Case");

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
                if (X.getNumerator() != person.getSharePercent().getNumerator() && X.getDenominator() != person.getDeadSonNumber()) {
                    Log.i(TAG, "X != person SharePercent");
                    Y = Fraction.finalCalculationDivideFraction(person.getSharePercent(), X);
                } else{
                    Log.i(TAG, "X != person SharePercent");
                    Y = person.getSharePercent();
                }
                person.setSharePercent(Y); // Share Percent
                person.setProblemOrigin(person.getSharePercent().getDenominator()); // Problem Origin
                person.setNumberOfShares(person.getSharePercent().getNumerator()); // Number Of Shares

                Log.i(TAG, "calculateShareValue(): Person = " + person.getRelation() +
                        " & sharePercent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator() +
                        " & Problem Origin = " + person.getProblemOrigin() + " & Person Number of Shares = " + person.getNumberOfShares());

                calculatePersonShareValue(person, oConstants, specialCaseRemainPeople.isEmpty(), X);
            }
        }

        if (!specialCaseRemainPeople.isEmpty())
            handleRemainPerson(data);
        if (!partners.isEmpty())
            handlePartnerPeople(data, oConstants);

        handleDeadSonsAndDaughters(data);
    }

    private static void calculatePersonShareValue(Person person, OConstants oConstants, boolean isHasRemainPeople, Fraction X) {

        try {

            double money = 0;
            if (isHasRemainPeople) {

                money = oConstants.getTotalMoney() * ((double) X.getNumerator() / (double) X.getNumerator());
                remain = oConstants.getTotalMoney() - money;

            } else {
                money = oConstants.getTotalMoney();
                remain = oConstants.getTotalMoney();
            }

            double sharePercent = (((double) person.getSharePercent().getNumerator()) / ((double) person.getSharePercent().getDenominator()));
            double shareValue = round((money * sharePercent), 2);
            sharePercent = shareValue;
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

    private static void setMoreThanThreeDaughters(ArrayList<Person> data, Person person, Fraction sharePercents, double totalMoney) {
        int girlsCount = OConstants.getChildrenInDaughters(data);

        double eachPersonValue;
        if (sharePercents == OConstants.two_Thirds) {

            double twoThirdMoney = (totalMoney * ((double) (2 / 3)));
            eachPersonValue = twoThirdMoney / girlsCount;

            if (person.getRelation().matches(OConstants.PERSON_SON)) {
                person.setShareValue(round((eachPersonValue * 2), 2));
            } else if (person.getRelation().matches(OConstants.PERSON_DAUGHTER)) {
                person.setShareValue(round(eachPersonValue, 2));
            }
        }

    }

    private static void setMoreThanBrotherAndSister(ArrayList<Person> data, Person person, Fraction sharePercents, double totalMoney) {
        int girlsCount = OConstants.getPersonsInGirlsCount(data, OConstants.PERSON_BROTHER, OConstants.PERSON_SISTER);

        double eachPersonValue;
        if (sharePercents == OConstants.one_Third) {

            double oneThirdMoney = (totalMoney / 3); // money * 1/3
            eachPersonValue = oneThirdMoney / girlsCount;

            if (person.getRelation().matches(OConstants.PERSON_BROTHER)) {

                person.setShareValue(round((eachPersonValue * 2), 2));

            } else if (person.getRelation().matches(OConstants.PERSON_SISTER)) {

                person.setShareValue(round(eachPersonValue, 2));

            }
        }

    }

    private static void setMoreThanThreeBrotherAndSister(ArrayList<Person> data, Person person, Fraction sharePercents, double totalMoney) {
        try {
            int girlsCount = OConstants.getPersonsInGirlsCount(data, OConstants.PERSON_BROTHER, OConstants.PERSON_SISTER);

            double eachPersonValue;
            if (sharePercents == OConstants.one) {

                eachPersonValue = totalMoney / girlsCount;

                if (person.getRelation().matches(OConstants.PERSON_BROTHER)) {

                    person.setShareValue(round((eachPersonValue * 2), 2));

                } else if (person.getRelation().matches(OConstants.PERSON_SISTER)) {

                    person.setShareValue(round(eachPersonValue, 2));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setFatherUnclesAndAunts(ArrayList<Person> data, Person person, Fraction sharePercents) {
        int girlsCount = OConstants.getPersonsInGirlsCount(data, OConstants.PERSON_FATHER_UNCLE, OConstants.PERSON_FATHER_AUNT);

        double eachPersonValue;
        if (sharePercents == OConstants.half) {

            double halfOfRemain = (remain / 2);
            eachPersonValue = halfOfRemain / girlsCount;

            if (person.getRelation().matches(OConstants.PERSON_FATHER_UNCLE)) {
                person.setShareValue(round((eachPersonValue * 2), 2));
            } else if (person.getRelation().matches(OConstants.PERSON_FATHER_AUNT)) {
                person.setShareValue(round(eachPersonValue, 2));
            }
        } else if (sharePercents == OConstants.two_Thirds) {

            double twoThirdRemain = (remain * ((double) (2 / 3)));
            eachPersonValue = twoThirdRemain / girlsCount;

            if (person.getRelation().matches(OConstants.PERSON_FATHER_UNCLE)) {
                person.setShareValue(round((eachPersonValue * 2), 2));
            } else if (person.getRelation().matches(OConstants.PERSON_FATHER_AUNT)) {
                person.setShareValue(round(eachPersonValue, 2));
            }
        }
    }

    private static void setMotherUnclesAndAunts(ArrayList<Person> data, Person person, Fraction sharePercents) {
        int girlsCount = OConstants.getPersonsInGirlsCount(data, OConstants.PERSON_MOTHER_UNCLE, OConstants.PERSON_MOTHER_AUNT);

        double eachPersonValue;
        if (sharePercents == OConstants.half) {

            double halfOfRemain = (remain / 2);
            eachPersonValue = halfOfRemain / girlsCount;

            if (person.getRelation().matches(OConstants.PERSON_MOTHER_UNCLE)) {
                person.setShareValue((round((eachPersonValue * 2), 2)));
            } else if (person.getRelation().matches(OConstants.PERSON_MOTHER_AUNT)) {
                person.setShareValue((round(eachPersonValue, 2)));
            }
        } else if (sharePercents == OConstants.one_Third) {

            double twoThirdRemain = (remain / 3); // remain * 1/3
            eachPersonValue = twoThirdRemain / girlsCount;

            if (person.getRelation().matches(OConstants.PERSON_MOTHER_UNCLE)) {
                person.setShareValue((round((eachPersonValue * 2), 2)));
            } else if (person.getRelation().matches(OConstants.PERSON_MOTHER_AUNT)) {
                person.setShareValue(round(eachPersonValue, 2));
            }
        }
    }

    private static boolean isRemainPerson(ArrayList<Person> data, Person person) {
        Person fatherUnclesAndAunts = getPerson(data, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS);
        Person motherUnclesAndAunts = getPerson(data, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS);

        if ((person.getRelation().matches(OConstants.PERSON_MOTHER) && (person.getSharePercent() == null || person.getSharePercent() == OConstants.half))) {
            //When mother has the rest of money || has half of the rest of money
            Log.i(TAG, "isRemainPerson(): When " + person.getRelation() + " has the rest of money || has half of the rest of money");
            if (person.getSharePercent() == null) {
                Log.i(TAG, "isRemainPerson(): person " + person.getRelation() + " has null sharePercent");
            } else if (person.getSharePercent() == OConstants.half) {
                Log.i(TAG, "isRemainPerson(): person " + person.getRelation() + " has sharePercent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator());
            }
            return true;

        } else if (person.getRelation().matches(OConstants.PERSON_FATHER) && (person.getSharePercent() == null || person.getSharePercent() == OConstants.half)) {
            //When father has the rest of money || has half of the rest of money
            Log.i(TAG, "isRemainPerson(): When father has the rest of money || has half of the rest of money");
            return true;

        } else if (person.getRelation().matches(OConstants.PERSON_FATHER_UNCLE) || person.getRelation().matches(OConstants.PERSON_FATHER_AUNT) &&
                (fatherUnclesAndAunts != null && fatherUnclesAndAunts.getSharePercent() != null && fatherUnclesAndAunts.getSharePercent().equals(half))) {
            //When Father uncles and/or aunts has 1/2
            Log.i(TAG, "isRemainPerson(): When Father uncles and/or aunts has 1/2");
            return true;

        } else if (person.getRelation().matches(OConstants.PERSON_MOTHER_UNCLE) || person.getRelation().matches(OConstants.PERSON_MOTHER_AUNT) &&
                (motherUnclesAndAunts != null && motherUnclesAndAunts.getSharePercent() != null && motherUnclesAndAunts.getSharePercent().equals(half))) {
            //When Mother uncles and/or aunts has 1/2
            Log.i(TAG, "isRemainPerson(): When Mother uncles and/or aunts has 1/2");
            return true;

        }
        Log.i(TAG, "Not a remain person");
        return false;
    }

    private static boolean isPartnerPerson(ArrayList<Person> data, Person person) {
        try {
            Person fatherUnclesAndAunts = getPerson(data, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS);
            Person motherUnclesAndAunts = getPerson(data, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS);
            Person moreThanBrotherAndSister = getPerson(data, OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER);
            Person moreThanThreeBrotherAndSister = getPerson(data, OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER);
            Person moreThanThreeDaughters = getPerson(data, OConstants.PERSON_More_Than_three_DAUGHTERS);

            if ((person.getRelation().matches(OConstants.PERSON_DAUGHTER) || person.getRelation().matches(OConstants.PERSON_SON)) &&
                    (moreThanThreeDaughters != null && moreThanThreeDaughters.getSharePercent() != null && moreThanThreeDaughters.getSharePercent().equals(two_Thirds))) {

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

            } else if ((person.getRelation().matches(OConstants.PERSON_FATHER_UNCLE) || person.getRelation().matches(OConstants.PERSON_FATHER_AUNT)) &&
                    (fatherUnclesAndAunts != null && fatherUnclesAndAunts.getSharePercent() != null && fatherUnclesAndAunts.getSharePercent().equals(two_Thirds))) {

                //When Father uncles and/or aunts has 2/3
                Log.i(TAG, "isPartnerPerson(): When Father uncles and/or aunts has 2/3");
                return true;

            } else if ((person.getRelation().matches(OConstants.PERSON_MOTHER_UNCLE) || person.getRelation().matches(OConstants.PERSON_MOTHER_AUNT)) &&
                    (motherUnclesAndAunts != null && motherUnclesAndAunts.getSharePercent() != null && motherUnclesAndAunts.getSharePercent().equals(one_Third))) {

                //When Mother uncles and/or aunts has 1/3
                Log.i(TAG, "isPartnerPerson(): When Mother uncles and/or aunts has 1/3");
                return true;

            } else if ((person.getRelation().matches(OConstants.PERSON_BROTHER) || person.getRelation().matches(OConstants.PERSON_SISTER)) &&
                    (moreThanBrotherAndSister != null && moreThanBrotherAndSister.getSharePercent() != null && moreThanBrotherAndSister.getSharePercent().equals(one_Third))) {

                //When More than brother and sister and has 1/3
                Log.i(TAG, "isPartnerPerson(): When More than brother and sister and has 1/3");
                return true;

            } else if ((person.getRelation().matches(OConstants.PERSON_BROTHER) || person.getRelation().matches(OConstants.PERSON_SISTER)) &&
                    (moreThanThreeBrotherAndSister != null && moreThanThreeBrotherAndSister.getSharePercent() != null && moreThanThreeBrotherAndSister.getSharePercent().equals(one))) {

                //When More than three brother and sister and has 1/3
                Log.i(TAG, "isPartnerPerson(): When More than three brother and sister and has 1/3");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.i(TAG, "Not a partner person");
        return false;
    }

    private static void handleRemainPerson(ArrayList<Person> data) {

        Person fatherUnclesAndAunts = getPerson(data, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS);
        Person motherUnclesAndAunts = getPerson(data, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS);

        for (Person person : data) {
            if (!isBlocked(person)) {

                if ((person.getRelation().matches(OConstants.PERSON_MOTHER) && (person.getSharePercent() == null || person.getSharePercent() == OConstants.half))) {
                    //When mother has the rest of money || has half of the rest of money
                    Log.i(TAG, "handleRemainPerson(): When " + person.getRelation() + " has the rest of money || has half of the rest of money");
                    if (person.getSharePercent() == null) {
                        //Mother Takes the rest
                        person.setShareValue(round(remain, 2));
                        Log.i(TAG, "handleRemainPerson(): Mother Takes the rest");

                    } else if (person.getSharePercent() == OConstants.half) {
                        person.setShareValue(round((remain / 2), 2));
                        Log.i(TAG, "handleRemainPerson(): Mother Takes the half of the Rest");
                        Log.i(TAG, "handleRemainPerson(): person " + person.getRelation() + " has sharePercent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator());
                    }


                } else if (person.getRelation().matches(OConstants.PERSON_FATHER) && (person.getSharePercent() == null || person.getSharePercent() == OConstants.half)) {

                    //When father has the rest of money || has half of the rest of money
                    Log.i(TAG, "handleRemainPerson(): When father has the rest of money || has half of the rest of money");

                    if (person.getSharePercent() == null) {
                        //Father Takes the rest
                        person.setShareValue(round(remain, 2));
                        Log.i(TAG, "handleRemainPerson(): Father Takes the rest");
                    } else if (person.getSharePercent() == OConstants.half) {
                        person.setShareValue(round((remain / 2), 2));
                        Log.i(TAG, "handleRemainPerson(): Father Takes the half of the Rest");
                        Log.i(TAG, "handleRemainPerson(): person " + person.getRelation() + " has sharePercent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator());
                    }


                } else if (person.getRelation().matches(OConstants.PERSON_FATHER_UNCLE) || person.getRelation().matches(OConstants.PERSON_FATHER_AUNT) &&
                        (fatherUnclesAndAunts != null && fatherUnclesAndAunts.getSharePercent() != null && fatherUnclesAndAunts.getSharePercent().equals(half))) {
                    //When Father uncles and/or aunts has 1/2
                    Log.i(TAG, "isRemainPerson(): When Father uncles and/or aunts has 1/2");

                    setFatherUnclesAndAunts(data, person, half);

                } else if (person.getRelation().matches(OConstants.PERSON_MOTHER_UNCLE) || person.getRelation().matches(OConstants.PERSON_MOTHER_AUNT) &&
                        (motherUnclesAndAunts != null && motherUnclesAndAunts.getSharePercent() != null && motherUnclesAndAunts.getSharePercent().equals(half))) {
                    //When Mother uncles and/or aunts has 1/2
                    Log.i(TAG, "isRemainPerson(): When Mother uncles and/or aunts has 1/2");
                    setMotherUnclesAndAunts(data, person, half);

                }
            }
        }
    }

    private static void handlePartnerPeople(ArrayList<Person> data, OConstants oConstants) {
        for (Person person : data) {
            try {

                if (!isBlocked(person)) {
                    Person fatherUnclesAndAunts = getPerson(data, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS);
                    Person motherUnclesAndAunts = getPerson(data, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS);
                    Person moreThanBrotherAndSister = getPerson(data, OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER);
                    Person moreThanThreeBrotherAndSister = getPerson(data, OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER);
                    Person moreThanThreeDaughters = getPerson(data, OConstants.PERSON_More_Than_three_DAUGHTERS);

                    if ((person.getRelation().matches(OConstants.PERSON_DAUGHTER) || person.getRelation().matches(OConstants.PERSON_SON)) &&
                            (moreThanThreeDaughters != null && moreThanThreeDaughters.getSharePercent() != null && moreThanThreeDaughters.getSharePercent().equals(two_Thirds))) {

                        //When sons and daughters count >= 3
                        Log.i(TAG, "isPartnerPerson(): person = " + person.getRelation() + " & Daughters >= 3 " + getChildrenInDaughters(data) + " is a special Case");
                        setMoreThanThreeDaughters(data, person, two_Thirds, oConstants.getTotalMoney());

                    } else if (person.getRelation().matches(OConstants.PERSON_FATHER_UNCLE) || person.getRelation().matches(OConstants.PERSON_FATHER_AUNT) &&
                            (fatherUnclesAndAunts != null && fatherUnclesAndAunts.getSharePercent() != null && fatherUnclesAndAunts.getSharePercent().equals(two_Thirds))) {

                        //When Father uncles and/or aunts has 2/3
                        Log.i(TAG, "isValid(): When Father uncles and/or aunts has 2/3");
                        setFatherUnclesAndAunts(data, person, two_Thirds);

                    } else if (person.getRelation().matches(OConstants.PERSON_MOTHER_UNCLE) || person.getRelation().matches(OConstants.PERSON_MOTHER_AUNT) &&
                            (motherUnclesAndAunts != null && motherUnclesAndAunts.getSharePercent() != null && motherUnclesAndAunts.getSharePercent().equals(one_Third))) {

                        //When Mother uncles and/or aunts has 1/3
                        Log.i(TAG, "isPartnerPerson(): When Mother uncles and/or aunts has 1/3");
                        setMotherUnclesAndAunts(data, person, one_Third);

                    } else if (person.getRelation().matches(OConstants.PERSON_BROTHER) || person.getRelation().matches(OConstants.PERSON_SISTER) &&
                            (moreThanBrotherAndSister != null && moreThanBrotherAndSister.getSharePercent() != null && moreThanBrotherAndSister.getSharePercent().equals(one_Third))) {

                        //When More than brother and sister and has 1/3
                        Log.i(TAG, "isPartnerPerson(): When More than brother and sister and has 1/3");
                        setMoreThanBrotherAndSister(data, person, one_Third, oConstants.getTotalMoney());

                    } else if (person.getRelation().matches(OConstants.PERSON_BROTHER) || person.getRelation().matches(OConstants.PERSON_SISTER) &&
                            (moreThanThreeBrotherAndSister != null && moreThanThreeBrotherAndSister.getSharePercent() != null && moreThanThreeBrotherAndSister.getSharePercent().equals(one))) {

                        //When More than three brother and sister and has 1/3
                        Log.i(TAG, "isPartnerPerson(): When More than three brother and sister and has 1/3");
                        setMoreThanThreeBrotherAndSister(data, person, one, oConstants.getTotalMoney());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean isBlocked(Person person) {
        if (person.getBlocked() != null)
            Log.i(TAG, "isBlocked(): " + person.getRelation() + " is " + person.getBlocked());

        return person.getBlocked() != null && person.getBlocked().matches(BLOCKED);
    }
}
