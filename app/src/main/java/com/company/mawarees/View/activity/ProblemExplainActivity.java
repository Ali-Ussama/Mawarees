package com.company.mawarees.View.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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

            Toolbar mToolbar = AppUtils.setupToolbar(mCurrent, 1);
            AppUtils.setToolbarTitle(mToolbar, getString(R.string.explain_problem_result));

            people = getIntent().getParcelableArrayListExtra(getString(R.string.intent_data_lbl));
            explanation = getIntent().getParcelableExtra(getString(R.string.explain_problem_result));

            removeBlockedPeople();

            sumPeopleFractions();
            initFirstRV();
            initThirdStepRV();
            initFourthStepRV();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sumPeopleFractions() {
        try {
            StringBuilder summation = new StringBuilder("= س");

            originalValue = 0;
            for (int i = 0; i < people.size(); i++) {
//                if (i < people.size() - 1) {
//                    summation.append(" ").append(people.get(i).getOriginalSharePercent().getDenominator()).append("/").append(people.get(i).getOriginalSharePercent().getNumerator()).append(" +");
//                } else {
//                    summation.append(" ").append(people.get(i).getOriginalSharePercent().getDenominator()).append("/").append(people.get(i).getOriginalSharePercent().getNumerator());
//                }
                originalValue += people.get(i).getOriginalSharePercent().getNumerator();
            }

//            summation.append(" ").append(" = ").append(originalValue).append("/").append("24");

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

            for (Integer integer : index) {
                try {
                    people.remove((int) integer);
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
            removeDuplicatedPeople();
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
            groups = new ArrayList<>();
            createGroups(groups);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            mFourthAdapter = new ExplanationFourthStepAdapter(groups, mCurrent);
            mFourthStepRV.setLayoutManager(layoutManager);
            mFourthStepRV.setAdapter(mFourthAdapter);

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

            Person oldSon = OConstants.getPerson(phase1, OConstants.PERSON_SON);
            Person newSon = null;

            if (sonsCount > 2) {
                newSon = OConstants.getNewPerson(phase4, OConstants.PERSON_SONS);
            } else if (daughtersCount == 2) {
                newSon = OConstants.getNewPerson(phase4, OConstants.PERSON_TWO_SONS);
            } else if (daughtersCount == 1) {
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
                group.setSingle_boy_relation(OConstants.PERSON_DAUGHTER);
                group.setGroupSharePercent(oldSon.getSharePercent());
                group.setBoysLatestSharePercent(newSon.getSharePercent());
                group.setGirlsLatestSharePercent(newDaughter.getSharePercent());

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
}
