package com.company.mawarees.Model;

import com.company.mawarees.Model.Models.Fraction;
import com.company.mawarees.Model.Models.Person;

import java.util.ArrayList;

public class OConstants {

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
    public static final String PERSON_More_Than_three_SISTERS = "MoreThanThreeSisters";
    public static final String PERSON_MORE_THAN_BROTHER_AND_SISTER = "MoreThanBrotherAndSister";

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
    /*----------------------------حالة الابن / البنت المتوفين و ابنائهم ---------------------------*/

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

    public static ArrayList<Person> setPersonSharePercent(ArrayList<Person> data, Fraction fraction, String relation) {

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getRelation().matches(relation)) {
                data.get(i).setSharePercent(fraction);
            }
        }
        return data;
    }

    public static ArrayList<Person> calculateShareValue(ArrayList<Person> data, OConstants oConstants) {

        // ص = ن / س
        Fraction X, Y, N;
        X = new Fraction(0, 0);

        // حساب (س) و هو مجموع النسب التى يستحقها الورثة
        for (Person person : data) {
            //عدم جمع نسب الاشخاص الذين لهم نصيب باقي التركة
            if ((person.getRelation().matches(OConstants.PERSON_MOTHER) && person.getSharePercent() != null && person.getSharePercent() != OConstants.half) &&
                    (person.getRelation().matches(OConstants.PERSON_FATHER) && person.getSharePercent() != null && person.getSharePercent() != OConstants.half) &&
                    (!person.getRelation().matches(OConstants.PERSON_FATHER_UNCLE) && !person.getRelation().matches(OConstants.PERSON_FATHER_AUNT) &&
                            !person.getRelation().matches(OConstants.PERSON_MOTHER_UNCLE) && !person.getRelation().matches(OConstants.PERSON_MOTHER_AUNT))) {

                X = Fraction.addFractions(X, person.getSharePercent());
            }
        }


        //حساب (ص) نسبة نصيب كل شخص
        // مع مراعاة الاشخاص الشركاء يعاملوا معاملة الشخص الواحد
        // و عدم حساب الاشخاص الذين لهم نصيب باقي التركة
        for (Person person : data) {
            // ص = ن / س
            Y = Fraction.divideFraction(person.getSharePercent(), X);
            person.setSharePercent(Y);
        }

        return data;
    }

}
