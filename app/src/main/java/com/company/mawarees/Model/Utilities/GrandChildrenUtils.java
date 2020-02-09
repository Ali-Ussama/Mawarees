package com.company.mawarees.Model.Utilities;

import android.util.Log;

import com.company.mawarees.Model.Models.Fraction;
import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;

import java.util.ArrayList;

public class GrandChildrenUtils {

    private static final String TAG = "GrandChildrenUtils";
    private static ArrayList<Person> people;
    private static OConstants oConstants;

    public static void handleGrandChildren(ArrayList<Person> mPeople, OConstants mOConstants) {
        people = mPeople;
        oConstants = mOConstants;

        handleDeadSonsChildren();

        handleDeadDaughtersChildren();

    }

    private static void handleDeadSonsChildren() {
        try {
            int deadSonsCount = oConstants.getDeadSonCount();

            ArrayList<Person> grandChildren = new ArrayList<>();
            for (int i = 1; i < (deadSonsCount + 1); i++) {
                try {
                    Person son = OConstants.getDeadChild(people, OConstants.PERSON_SON, i);

                    if (son != null) {
                        Person childBoy = OConstants.getGrandChild(people, OConstants.PERSON_SON_BOY, i);
                        Person childGirl = OConstants.getGrandChild(people, OConstants.PERSON_SON_GIRL, i);
                        int childBoyCount = OConstants.getDeadSonBoysCount(people, i);
                        int childGirlCount = OConstants.getDeadSonBoysCount(people, i);
                        Person children = OConstants.getGrandChild(people, OConstants.PERSON_SON_CHILDREN, i);

                        if (children != null) {
                            Fraction fraction = new Fraction(son.getSharePercent().getNumerator(), son.getSharePercent().getDenominator());
                            OConstants.setPersonSharePercent(people, fraction, OConstants.PERSON_SON_CHILDREN);

                            children.setProblemOrigin(son.getProblemOrigin());
                            children.setNumberOfShares(son.getSharePercent().getNumerator());
                            children.setProof(ProofsAndExplanations.SonBoyOrGirlProofs.p1);
                            children.setExplanation(ProofsAndExplanations.SonBoyOrGirlProofs.E1);

                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleDeadDaughtersChildren() {
        try {
            int deadDaughtersCount = oConstants.getDeadDaughterCount();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setGrandChildValues(ArrayList<Person> data, int size, String relation, String gender, boolean isAlive, Fraction originalPercent, Fraction sharePercent,
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

    private static void resetDeadChild(ArrayList<Person> mPeople, String relation, int number) {
        try {
            ArrayList<Person> index = new ArrayList<>();

            for (int i = 0; i < mPeople.size(); i++) {
                if (mPeople.get(i).getRelation().matches(relation) && !mPeople.get(i).isAlive() && number == mPeople.get(i).getDeadSonNumber()) {
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
}
