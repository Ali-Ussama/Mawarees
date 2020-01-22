package com.company.mawarees.View.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
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

    @BindView(R.id.activity_explain_fifth_step_value_lbl_1)
    TextView mConclusionTV;

    @BindView(R.id.activity_explain_fifth_step_layout)
    ConstraintLayout mFifthStepLayout;

    @BindView(R.id.activity_explain_fifth_step_container_layout)
    LinearLayout mFifthStepContainerLayout;

    @BindView(R.id.activity_explain_fifth_step_lbl)
    TextView mFifthStepLbl;


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

            if (people.get(0) != null) {
                problemOrigin = people.get(0).getProblemOrigin();
            }
            explanation = getIntent().getParcelableExtra(getString(R.string.explain_problem_result));
            oConstants = getIntent().getParcelableExtra(getString(R.string.constants));

            removeBlockedPeople();

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
            if (correctionValue != 0) {
                String result = "أصل المسألة ( ".concat(String.valueOf((problemOrigin / correctionValue))).concat(")") + "ومعامل تصحيح الأسهم ".concat("(").concat(String.valueOf(correctionValue)).concat(")").concat("\n")
                        .concat("و أصبح أصل المسالة الجديد = ").concat(String.valueOf(problemOrigin)).concat(" x ").concat(String.valueOf(correctionValue)).concat(" = ").concat(String.valueOf(problemOrigin * correctionValue))
                        .concat(" سهم").concat("\n").concat("تم توزيعها بدون زيادة او نقصان");

                mConclusionTV.setText(result);

                mFifthStepContainerLayout.setVisibility(View.VISIBLE);
                mFifthStepLayout.setVisibility(View.VISIBLE);
                mFifthStepLbl.setVisibility(View.VISIBLE);
                mConclusionTV.setVisibility(View.VISIBLE);
            } else {
                mFifthStepContainerLayout.setVisibility(View.GONE);
                mFifthStepLayout.setVisibility(View.GONE);
                mFifthStepLbl.setVisibility(View.GONE);
                mConclusionTV.setVisibility(View.GONE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sumPeopleFractions() {
        try {
            StringBuilder summation = new StringBuilder("= س");
            removeDuplicatedPeople();
            originalValue = 0;

            for (int i = 0; i < mFirstStepData.size(); i++) {
                originalValue += mFirstStepData.get(i).getOriginalSharePercent().getNumerator();
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
                    if ((people.get(i).getBlocked() != null && people.get(i).getBlockedBy() != null) || (people.get(i).getSharePercent() == null ||
                            (people.get(i).getSharePercent().getNumerator() == 0) && people.get(i).getSharePercent().getDenominator() == 0) ||
                            (people.get(i).getRelation().contains(OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER) ||
                                    (people.get(i).getRelation().contains(OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER)) ||
                                    (people.get(i).getRelation().contains(OConstants.PERSON_MORE_THAN_WIFE)) ||
                                    (people.get(i).getRelation().contains(OConstants.PERSON_More_Than_three_DAUGHTERS)) ||
                                    (people.get(i).getRelation().contains(OConstants.PERSON_FATHER_UNCLES_AND_AUNTS)) ||
                                    (people.get(i).getRelation().contains(OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS)))) {
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

            if (correctionValue != 0) {
                viewAnimator.setDisplayedChild(1);
                ArrayList<Person> data = createFourthStepData(oConstants.getmExplanation().getPhase2().getPeople());
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
        ArrayList<Person> result = new ArrayList<>();

        for (Person person : people) {
            if (person.getProblemOrigin() != problemOrigin) {
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

    private void createGroups(ArrayList<Group> groups) {
        try {
            ArrayList<Person> phase1 = explanation.getPhase1().getPeople();
            ArrayList<Person> phase4 = explanation.getPhase4().getPeople();

            for (Person person : phase1) {
                Log.i(TAG, "phase1: person relation = " + person.getRelation());
            }

            for (Person person : phase4) {
                Log.i(TAG, "phase4: person relation = " + person.getRelation());
            }

            int sonsCount = OConstants.getPersonCount(phase1, OConstants.PERSON_SON);
            int daughtersCount = OConstants.getPersonCount(phase1, OConstants.PERSON_DAUGHTER);

            int wivesCount = OConstants.getPersonCount(phase1, OConstants.PERSON_WIFE);

            if (wivesCount > 0) {

            }

            if (sonsCount > 0 && daughtersCount > 0) {
                createSonsGroup(phase1, phase4, groups);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createSonsGroup(ArrayList<Person> phase1, ArrayList<Person> phase4, ArrayList<Group> groups) {
        try {
            int sonsCount = OConstants.getPersonCount(phase1, OConstants.PERSON_SON);
            int daughtersCount = OConstants.getPersonCount(phase1, OConstants.PERSON_DAUGHTER);

            Person oldSon = OConstants.getPerson(phase1, OConstants.PERSON_SON);
            Person newSon = null;

            if (sonsCount > 2) {
                newSon = OConstants.getNewPerson(phase4, OConstants.PERSON_SONS);
            } else if (sonsCount == 2) {
                newSon = OConstants.getNewPerson(phase4, OConstants.PERSON_TWO_SONS);
            } else if (sonsCount == 1) {
                newSon = OConstants.getPerson(phase4, OConstants.PERSON_SON);
            }

            Person newDaughter = null;
            if (daughtersCount > 2) {
                newDaughter = OConstants.getNewPerson(phase4, OConstants.PERSON_DAUGHTERS);
            } else if (daughtersCount == 2) {
                newDaughter = OConstants.getNewPerson(phase4, OConstants.PERSON_TWO_DAUGHTERS);
            } else if (daughtersCount == 1) {
                newDaughter = OConstants.getPerson(phase4, OConstants.PERSON_DAUGHTER);
            }

            if (sonsCount != 0 && daughtersCount != 0) {
                Group group = new Group();
                group.setGroupName(OConstants.CHILDREN);
                group.setBoys_count(sonsCount);
                group.setGirls_count(daughtersCount);
                group.setBoys_relation(newSon.getRelation());
                group.setGirls_relation(newDaughter.getRelation());
                group.setSingle_boy_relation(OConstants.PERSON_SON);
                group.setSingle_girl_relation(OConstants.PERSON_DAUGHTER);
                group.setGroupSharePercent(oldSon.getOriginalSharePercent());

                if (newSon.getEachPersonSharePercent() != null) {
                    group.setBoysLatestSharePercent(newSon.getEachPersonSharePercent());
                } else {
                    group.setBoysLatestSharePercent(newSon.getSharePercent());
                }

                if (newDaughter.getEachPersonSharePercent() != null) {
                    group.setGirlsLatestSharePercent(newDaughter.getEachPersonSharePercent());
                } else {
                    group.setGirlsLatestSharePercent(newDaughter.getSharePercent());
                }
                group.setOriginalDenominator(originalValue);
                groups.add(group);
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

    void handleGroupsExplanation() {

    }

    private void removeDuplicatedPeople() {
        mFirstStepData = new ArrayList<>();
        boolean children = false, brothers = false, motherUncles = false, fatherUncles = false;
        Set<Person> data = new HashSet<>();

        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getRelation().contains(OConstants.PERSON_DAUGHTERS) || people.get(i).getRelation().contains(OConstants.PERSON_SONS) ||
                    people.get(i).getRelation().contains(OConstants.PERSON_TWO_DAUGHTERS) || people.get(i).getRelation().contains(OConstants.PERSON_TWO_SONS) ||
                    people.get(i).getRelation().contains(OConstants.PERSON_DAUGHTER) || people.get(i).getRelation().contains(OConstants.PERSON_SON)) {
                if (!children) {
                    children = true;
                    Person person = people.get(i);

                    createAlivePerson(mFirstStepData, person.getCount(), OConstants.PERSON_CHILDREN, OConstants.GENDER_MALE, true,
                            person.getOriginalSharePercent(), person.getShareValue(), person.getNumberOfShares(), person.getProblemOrigin(),
                            person.getExplanation(), person.getProof(), person.getBlocked(), person.getBlockedBy());
                }
            } else if (people.get(i).getRelation().contains(OConstants.PERSON_BROTHERS) || people.get(i).getRelation().contains(OConstants.PERSON_BROTHER) ||
                    people.get(i).getRelation().contains(OConstants.PERSON_TWO_BROTHERS) || people.get(i).getRelation().contains(OConstants.PERSON_SISTER) ||
                    people.get(i).getRelation().contains(OConstants.PERSON_SISTERS) || people.get(i).getRelation().contains(OConstants.PERSON_TWO_SISTERS)) {
                if (!brothers) {
                    brothers = true;
                    Person person = people.get(i);

                    createAlivePerson(mFirstStepData, person.getCount(), OConstants.PERSON_BROTHERS, OConstants.GENDER_MALE, true,
                            person.getOriginalSharePercent(), person.getShareValue(), person.getNumberOfShares(), person.getProblemOrigin(),
                            person.getExplanation(), person.getProof(), person.getBlocked(), person.getBlockedBy());
                }
            } else if (people.get(i).getRelation().contains(OConstants.PERSON_MOTHER_UNCLE) || people.get(i).getRelation().contains(OConstants.PERSON_MOTHER_UNCLES) ||
                    people.get(i).getRelation().contains(OConstants.PERSON_MOTHER_AUNT) || people.get(i).getRelation().contains(OConstants.PERSON_MOTHER_AUNTS)) {

                if (!motherUncles) {
                    motherUncles = true;
                    Person person = people.get(i);

                    createAlivePerson(mFirstStepData, person.getCount(), OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS, OConstants.GENDER_MALE, true,
                            person.getOriginalSharePercent(), person.getShareValue(), person.getNumberOfShares(), person.getProblemOrigin(),
                            person.getExplanation(), person.getProof(), person.getBlocked(), person.getBlockedBy());
                }
            } else if (people.get(i).getRelation().contains(OConstants.PERSON_FATHER_UNCLE) || people.get(i).getRelation().contains(OConstants.PERSON_FATHER_UNCLES) ||
                    people.get(i).getRelation().contains(OConstants.PERSON_FATHER_AUNT) || people.get(i).getRelation().contains(OConstants.PERSON_FATHER_AUNTS)) {

                if (!fatherUncles) {
                    fatherUncles = true;
                    Person person = people.get(i);

                    createAlivePerson(mFirstStepData, person.getCount(), OConstants.PERSON_FATHER_UNCLES_AND_AUNTS, OConstants.GENDER_MALE, true,
                            person.getOriginalSharePercent(), person.getShareValue(), person.getNumberOfShares(), person.getProblemOrigin(),
                            person.getExplanation(), person.getProof(), person.getBlocked(), person.getBlockedBy());
                }
            } else {
                mFirstStepData.add(people.get(i));
            }
        }
    }

    public static void createAlivePerson(ArrayList<Person> data, int size, String relation, String gender,
                                         boolean isAlive, Fraction originalPercent, double shareValue,
                                         int numberOfShares, int problemOrigin, String explanation,
                                         String proof, String blocked, String blockedBy) {
        try {

            Person person = new Person();
            person.setAlive(isAlive);
            person.setCount(size);
            person.setRelation(relation);
            person.setGender(gender);
            person.setDeadSonNumber(-1);
            person.setProblemOrigin(problemOrigin);
            person.setOriginalSharePercent(originalPercent);
            person.setShareValue(shareValue);
            person.setNumberOfShares(numberOfShares);
            person.setExplanation(explanation);
            person.setProof(proof);
            person.setBlocked(blocked);
            person.setBlockedBy(blockedBy);
            data.add(person);


            Log.i(TAG, "createAlivePerson() person relation = " + relation + " & Alive = " + isAlive + " & gender = " + gender + " created");
            Log.i(TAG, "createAlivePerson() people size = " + data.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void displayResult(OConstants oConstants) {
        ExplanationModel explainModel = oConstants.getmExplanation();
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
