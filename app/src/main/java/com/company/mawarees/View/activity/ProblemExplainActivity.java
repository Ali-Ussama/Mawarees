package com.company.mawarees.View.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewAnimator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.company.mawarees.Model.Models.ExplanationModel;
import com.company.mawarees.Model.Models.Fraction;
import com.company.mawarees.Model.Models.Group;
import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;
import com.company.mawarees.Model.Utilities.AppUtils;
import com.company.mawarees.PrefManager;
import com.company.mawarees.R;
import com.company.mawarees.View.adpters.ExplainFirstStepRecAdapter;
import com.company.mawarees.View.adpters.ExplainSecondStepRecAdapter;
import com.company.mawarees.View.adpters.ExplanationFourthStepAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProblemExplainActivity extends AppCompatActivity {

    private static final String TAG = "ProblemExplainActivity";

    @BindView(R.id.activity_explain_first_step_rv)
    RecyclerView mFirstStepRV;

    @BindView(R.id.activity_explain_third_step_rv)
    RecyclerView mThirdStepRV;

    @BindView(R.id.activity_explain_fourth_step_rv)
    RecyclerView mFourthStepRV;

    @BindView(R.id.activity_explain_second_step_layout_percent_numerator)
    TextView summationOfFractionsNumerator;

    @BindView(R.id.activity_explain_second_step_layout_percent_denominator)
    TextView summationOfFractionsDenominator;

    @BindView(R.id.activity_explain_fourth_step_correction_number_value)
    TextView mCorrectionNumberValueTV;

    @BindView(R.id.activity_explain_fourth_step_correction_number_layout)
    ConstraintLayout mCorrectionNumberLayout;

    @BindView(R.id.step_fourth_view_animator)
    ViewAnimator viewAnimator;

//    @BindView(R.id.activity_explain_fifth_step_value_lbl_1)
//    TextView mConclusionTV;
//
//    @BindView(R.id.activity_explain_fifth_step_layout)
//    ConstraintLayout mFifthStepLayout;
//
//    @BindView(R.id.activity_explain_fifth_step_container_layout)
//    LinearLayout mFifthStepContainerLayout;

    @BindView(R.id.activity_explain_fifth_step_value_correction_value)
    TextView mFifthStepCorrectionValue;

    @BindView(R.id.activity_explain_fifth_step_value_problem_origin)
    TextView mFifthStepOldProblemOrigin;

    @BindView(R.id.activity_explain_fifth_step_value_correction_value_2)
    TextView mFifthStepCorrectionValue2;

    @BindView(R.id.activity_explain_fifth_step_value_problem_origin_2)
    TextView mFifthStepOldProblemOrigin2;

    @BindView(R.id.activity_explain_fifth_step_value_new_problem_origin)
    TextView mFifthStepNewProblemOrigin;

    @BindView(R.id.activity_explain_fifth_step_value_problem_origin_2_2)
    TextView mFifthStepOldProblemOrigin_2;

    @BindView(R.id.activity_explain_fifth_step_value_view_animator)
    ViewAnimator mFifthStepViewAnimator;

    private ExplainFirstStepRecAdapter mFirstAdapter;
    private ExplainSecondStepRecAdapter mSecondAdapter;
    private ExplanationFourthStepAdapter mFourthAdapter;

    private ArrayList<Person> mFirstStepData;
    private ArrayList<Person> mSecondStepData;
    private ArrayList<Person> people;
    private ProblemExplainActivity mCurrent;
    ArrayList<Group> groups;
    private boolean brothers = false;
    private boolean children = false;
    private boolean fatherUncles = false;
    private boolean motherUncles = false;

    int originalValue = 0;

    private PrefManager mPrefManager;
    private ExplanationModel explanation;
    private OConstants oConstants;
    private int correctionValue;
    private int problemOrigin;
    private int oldProblemOrigin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_problem_explain);

            init();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() {
        try {
            ButterKnife.bind(this);
            mCurrent = ProblemExplainActivity.this;
            mPrefManager = new PrefManager(mCurrent);

            Toolbar mToolbar = AppUtils.setupToolbar(mCurrent, 1);
            AppUtils.setToolbarTitle(mToolbar, getString(R.string.explain_problem_result));

            people = getIntent().getParcelableArrayListExtra(getString(R.string.intent_data_lbl));


            oConstants = getIntent().getParcelableExtra(getString(R.string.constants));
            explanation = oConstants.getExplanation();

            removeBlockedPeople();
            if (people.get(0) != null) {
                Log.i(TAG, "init(): people.get(0) + " + people.get(0).getRelation());
                problemOrigin = people.get(0).getSharePercent().getDenominator();
            }
            Log.i(TAG, "init(): display People after removing blocked people.");
            showResult(people);

            sumPeopleFractions();
            initFirstRV();
            initThirdStepRV();
            initFourthStepRV();

            handleFifthStep(correctionValue);
//            displayResult(oConstants);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleFifthStep(int correctionValue) {
        try {
            if (correctionValue > 1) {
                mFifthStepViewAnimator.setDisplayedChild(0);
                mFifthStepCorrectionValue.setText(String.valueOf(correctionValue));

                mFifthStepOldProblemOrigin.setText(String.valueOf((problemOrigin / correctionValue)));

                mFifthStepOldProblemOrigin2.setText(String.valueOf((problemOrigin / correctionValue)));

                mFifthStepCorrectionValue2.setText(String.valueOf(correctionValue));

                mFifthStepOldProblemOrigin_2.setText(String.valueOf((problemOrigin / correctionValue)));

                mFifthStepNewProblemOrigin.setText(String.valueOf(problemOrigin));

            } else {
                mFifthStepViewAnimator.setDisplayedChild(1);
                mFifthStepOldProblemOrigin_2.setText(String.valueOf((problemOrigin)));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sumPeopleFractions() {
        try {
            StringBuilder summation = new StringBuilder("= س");
            collapsePeopleInGroups();
            originalValue = 0;

            for (int i = 0; i < mFirstStepData.size(); i++) {
                originalValue += mFirstStepData.get(i).getOriginalSharePercent().getNumerator();
//                if (mFirstStepData.get(i).getProblemOrigin() != problemOrigin) {
//                    originalValue += mFirstStepData.get(i).getSharePercent().getNumerator();
//                }
            }

            summationOfFractionsNumerator.setText(String.valueOf(originalValue));
            summationOfFractionsDenominator.setText(R.string.twenty_four);

        } catch (
                Exception e) {
            e.printStackTrace();
        }

    }

    private void removeBlockedPeople() {
        try {
            ArrayList<Integer> index = new ArrayList<>();

            for (int i = 0; i < people.size(); i++) {
                try {
//                    if ((people.get(i).getBlocked() != null && people.get(i).getBlockedBy() != null) || (people.get(i).getSharePercent() == null ||
//                            (people.get(i).getSharePercent().getNumerator() == 0) && people.get(i).getSharePercent().getDenominator() == 0) ||
//                            (people.get(i).getRelation().contains(OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER) ||
//                                    (people.get(i).getRelation().contains(OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER)) ||
//                                    (people.get(i).getRelation().contains(OConstants.PERSON_WIVES)) ||
//                                    (people.get(i).getRelation().contains(OConstants.PERSON_More_Than_three_DAUGHTERS)) ||
//                                    (people.get(i).getRelation().contains(OConstants.PERSON_FATHER_UNCLES_AND_AUNTS)) ||
//                                    (people.get(i).getRelation().contains(OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS)))) {
                    if ((people.get(i).getBlocked() != null && people.get(i).getBlockedBy() != null)) {
                        index.add(i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            for (int i = index.size() - 1; i >= 0; i--) {

                try {
                    people.remove((int) index.get(i));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initFirstRV() {
        try {
//            removeDuplicatedPeople();
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            mFirstStepData = OConstants.sort(mFirstStepData);
            mFirstAdapter = new ExplainFirstStepRecAdapter(mFirstStepData, mCurrent);
            mFirstStepRV.setLayoutManager(layoutManager);
            mFirstStepRV.setAdapter(mFirstAdapter);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initThirdStepRV() {
        try {
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            mSecondAdapter = new ExplainSecondStepRecAdapter(originalValue, mFirstStepData, mCurrent);
            mThirdStepRV.setLayoutManager(layoutManager);
            mThirdStepRV.setAdapter(mSecondAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initFourthStepRV() {
        try {
            setCorrectionNumber();
            groups = new ArrayList<>();

            if (correctionValue > 1) {
                viewAnimator.setDisplayedChild(1);
                ArrayList<Person> data = createFourthStepData(oConstants.getExplanation().getPhase2().getPeople());

//                data = OConstants.sort(data);
                Collections.sort(data);
                showResult(data);

                LinearLayoutManager layoutManager = new LinearLayoutManager(this);
                mFourthAdapter = new ExplanationFourthStepAdapter(data, correctionValue, mCurrent);
                mFourthStepRV.setLayoutManager(layoutManager);
                mFourthStepRV.setAdapter(mFourthAdapter);
            } else {
                viewAnimator.setDisplayedChild(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Person> createFourthStepData(ArrayList<Person> people) {
        Log.i(TAG, "createFourthStepData(): is called");
        ArrayList<Person> result = new ArrayList<>();


        for (Person person : people) {
            Log.i(TAG, "createFourthStepData(): person = " + person.getRelation() + " - problem Origin = " + person.getProblemOrigin());
            if (person.getProblemOrigin() != problemOrigin && person.getBlockedBy() == null && person.getBlocked() == null) {
                Log.i(TAG, "createFourthStepData(): person = " + person.getRelation() + " - problem Origin = " + person.getProblemOrigin() + " is Added");
                result.add(person);
            }
        }

        return result;
    }

    private void setCorrectionNumber() {
        try {
            Log.i(TAG, "setCorrectionNumber(): is called");
            if (mPrefManager != null) {
                int heads = mPrefManager.readInt(PrefManager.KEY_HEADS);
                int newProblemOrigin = mPrefManager.readInt(PrefManager.KEY_NEW_PROBLEM_ORIGIN);

                Log.i(TAG, "setCorrectionNumber(): heads = " + heads);
                Log.i(TAG, "setCorrectionNumber(): newProblemOrigin = " + newProblemOrigin);

                correctionValue = heads;

                if (heads != 0 && newProblemOrigin != 0) {
                    mCorrectionNumberLayout.setVisibility(View.VISIBLE);
                    mCorrectionNumberValueTV.setText(String.valueOf(heads));
                } else {
                    mCorrectionNumberLayout.setVisibility(View.GONE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void collapsePeopleInGroups() {
        mFirstStepData = new ArrayList<>();
        boolean children = false;
        boolean brothers = false;
        boolean motherUncles = false;
        boolean fatherUncles = false;

        Set<Person> data = new HashSet<>();

        for (int i = 0; i < people.size(); i++) {

            String personRelation = "";
            String[] relationSplit = people.get(i).getRelation().split(" ");
//            if (relationSplit.length == 0) {
                personRelation = people.get(i).getRelation();
//            } else if (relationSplit.length == 1) {
//                personRelation = relationSplit[0];
//            } else if (relationSplit.length > 1) {
//                personRelation = relationSplit[1];
//            }

            Log.i(TAG, "collapsePeopleInGroup(): person = " + personRelation);


            if (personRelation.contains(OConstants.PERSON_DAUGHTERS)
                    || personRelation.contains(OConstants.PERSON_SONS)
                    || personRelation.contains(OConstants.PERSON_TWO_DAUGHTERS)
                    || personRelation.contains(OConstants.PERSON_TWO_SONS)
                    || personRelation.contains(OConstants.PERSON_DAUGHTER)
                    || personRelation.contains(OConstants.PERSON_SON)) {

                Log.i(TAG, "collapsePeopleInGroup(): case = " + personRelation);

                if (!children) {
                    children = true;
                    Person person = people.get(i);

                    createAlivePerson(mFirstStepData, person.getCount(), OConstants.PERSON_CHILDREN, OConstants.GENDER_MALE, true,
                            person.getOriginalSharePercent(), person.getShareValue(), person.getNumberOfShares(), person.getProblemOrigin(),
                            person.getExplanation(), person.getProof(), person.getBlocked(), person.getBlockedBy(), true);
                }
            } else if (personRelation.contains(OConstants.PERSON_BROTHERS)
                    || personRelation.matches(OConstants.PERSON_BROTHER)
                    || personRelation.contains(OConstants.PERSON_TWO_BROTHERS)
                    || personRelation.contains(OConstants.PERSON_SISTER)
                    || personRelation.contains(OConstants.PERSON_SISTERS)
                    || personRelation.contains(OConstants.PERSON_TWO_SISTERS)) {

                Log.i(TAG, "collapsePeopleInGroup(): case brothers = " + personRelation);

                if (!brothers) {
                    brothers = true;
                    Person person = people.get(i);

                    createAlivePerson(mFirstStepData, person.getCount(), OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER, OConstants.GENDER_MALE, true,
                            person.getOriginalSharePercent(), person.getShareValue(), person.getNumberOfShares(), person.getProblemOrigin(),
                            person.getExplanation(), person.getProof(), person.getBlocked(), person.getBlockedBy(), true);
                }
            } else if (personRelation.contains(OConstants.PERSON_MOTHER_UNCLE)
                    || personRelation.contains(OConstants.PERSON_MOTHER_UNCLES)
                    || personRelation.contains(OConstants.PERSON_MOTHER_AUNT)
                    || personRelation.contains(OConstants.PERSON_MOTHER_AUNTS)) {

                Log.i(TAG, "collapsePeopleInGroup(): case = " + personRelation);

                if (!motherUncles) {
                    motherUncles = true;
                    Person person = people.get(i);

                    createAlivePerson(mFirstStepData, person.getCount(), OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS, OConstants.GENDER_MALE, true,
                            person.getOriginalSharePercent(), person.getShareValue(), person.getNumberOfShares(), person.getProblemOrigin(),
                            person.getExplanation(), person.getProof(), person.getBlocked(), person.getBlockedBy(), true);
                }
            } else if (personRelation.contains(OConstants.PERSON_FATHER_UNCLE)
                    || personRelation.contains(OConstants.PERSON_FATHER_UNCLES)
                    || personRelation.contains(OConstants.PERSON_FATHER_AUNT)
                    || personRelation.contains(OConstants.PERSON_FATHER_AUNTS)) {
                Log.i(TAG, "collapsePeopleInGroup(): case = " + personRelation);

                if (!fatherUncles) {
                    fatherUncles = true;
                    Person person = people.get(i);

                    createAlivePerson(mFirstStepData, person.getCount(), OConstants.PERSON_FATHER_UNCLES_AND_AUNTS, OConstants.GENDER_MALE, true,
                            person.getOriginalSharePercent(), person.getShareValue(), person.getNumberOfShares(), person.getProblemOrigin(),
                            person.getExplanation(), person.getProof(), person.getBlocked(), person.getBlockedBy(), true);
                }
            } else {

                Log.i(TAG, "collapsePeopleInGroup(): else is called");
                mFirstStepData.add(people.get(i));
            }
        }
    }

    public static void createAlivePerson(ArrayList<Person> data, int size, String relation, String gender,
                                         boolean isAlive, Fraction originalPercent, double shareValue,
                                         int numberOfShares, int problemOrigin, String explanation,
                                         String proof, String blocked, String blockedBy, boolean group) {
        try {

            Person person = new Person();
            person.setAlive(isAlive);
            person.setCount(size);
            person.setRelation(relation);
            person.setGender(gender);
            person.setDeadChildNumber(-1);
            person.setProblemOrigin(problemOrigin);
            person.setOriginalSharePercent(originalPercent);
            person.setShareValue(shareValue);
            person.setNumberOfShares(numberOfShares);
            person.setExplanation(explanation);
            person.setProof(proof);
            person.setBlocked(blocked);
            person.setBlockedBy(blockedBy);
            person.setGroup(group);
            data.add(person);


            Log.i(TAG, "createAlivePerson() person relation = " + relation + " & Alive = " + isAlive + " & gender = " + gender + " created");
            Log.i(TAG, "createAlivePerson() people size = " + data.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void showResult(ArrayList<Person> mPeople) {

        try {

            String result = "";

            for (Person person : mPeople) {
                try {
                    if (person.getBlocked() == null) {


                        Log.i(TAG, " showResult(): person Relation " + person.getRelation() + " & person Share Value = " + person.getShareValue());
                        Log.i(TAG, " showResult(): person Share Percent " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator());
                        Log.i(TAG, " showResult(): person Problem Origin " + person.getProblemOrigin());

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

    void displayResult(OConstants oConstants) {
        ExplanationModel explainModel = oConstants.getExplanation();
        ArrayList<Person> mPeople;
        Log.i(TAG, "displayResult(): is called");
        if (explainModel.getPhase1() != null && explainModel.getPhase1().getPeople() != null && !explainModel.getPhase1().getPeople().isEmpty()) {
            mPeople = explainModel.getPhase1().getPeople();
            Log.i(TAG, "displayResult(): phase 1 != null");
            Log.i(TAG, "displayResult(): mPeople size = " + mPeople.size());

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
        }
        if (explainModel.getPhase2() != null && explainModel.getPhase2().getPeople() != null && !explainModel.getPhase2().getPeople().isEmpty()) {
            mPeople = explainModel.getPhase2().getPeople();
            Log.i(TAG, "displayResult(): phase 2 != null");
            Log.i(TAG, "displayResult(): mPeople size = " + mPeople.size());

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
        }
        if (explainModel.getPhase3() != null && explainModel.getPhase3().getPeople() != null && !explainModel.getPhase3().getPeople().isEmpty()) {
            mPeople = explainModel.getPhase3().getPeople();
            Log.i(TAG, "displayResult(): phase 3 != null");
            Log.i(TAG, "displayResult(): mPeople size = " + mPeople.size());

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
        }
        if (explainModel.getPhase4() != null && explainModel.getPhase4().getPeople() != null && !explainModel.getPhase4().getPeople().isEmpty()) {
            mPeople = explainModel.getPhase4().getPeople();
            Log.i(TAG, "displayResult(): phase 4 != null");
            Log.i(TAG, "displayResult(): mPeople size = " + mPeople.size());

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
        }
    }
}
