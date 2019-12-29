package com.company.mawarees.View.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.company.mawarees.Model.Models.Fraction;
import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;
import com.company.mawarees.Model.Utilities.AppUtils;
import com.company.mawarees.PrefManager;
import com.company.mawarees.R;
import com.company.mawarees.View.adpters.ExplainFirstStepRecAdapter;
import com.company.mawarees.View.adpters.ExplainSecondStepRecAdapter;

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

    @BindView(R.id.activity_explain_second_step_layout_percent_numerator)
    TextView summationOfFractionsNumerator;

    @BindView(R.id.activity_explain_second_step_layout_percent_denominator)
    TextView summationOfFractionsDenominator;


    private ExplainFirstStepRecAdapter mFirstAdapter;
    private ExplainSecondStepRecAdapter mSecondAdapter;
    private ArrayList<Person> mFirstStepData;
    private ArrayList<Person> mSecondStepData;
    private ArrayList<Person> people;
    private ProblemExplainActivity mCurrent;
    private boolean brothers = false;
    private boolean children = false;
    private boolean fatherUncles = false;
    private boolean motherUncles = false;

    int originalValue = 0;

    PrefManager mPrefManager;

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

            removeBlockedPeople();

            sumPeopleFractions();
            initFirstRV();
            initThirdStepRV();
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

    private void initThirdStepRV() {
        try {
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            mSecondAdapter = new ExplainSecondStepRecAdapter(originalValue, people, mCurrent);
            mThirdStepRV.setLayoutManager(layoutManager);
            mThirdStepRV.setAdapter(mSecondAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initFirstRV() {
        try {
//            removeDuplicatedPeople();
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            mFirstAdapter = new ExplainFirstStepRecAdapter(people, mCurrent);
            mFirstStepRV.setLayoutManager(layoutManager);
            mFirstStepRV.setAdapter(mFirstAdapter);

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

    void handleGroupsExplanation(){

    }
    private void removeDuplicatedPeople() {
        mFirstStepData = new ArrayList<>();

        ArrayList<Integer> index = new ArrayList<>();
        Set<Person> da = new HashSet<>();

        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getRelation().contains(OConstants.PERSON_DAUGHTERS) || people.get(i).getRelation().contains(OConstants.PERSON_SONS) ||
                    people.get(i).getRelation().contains(OConstants.PERSON_TWO_DAUGHTERS) || people.get(i).getRelation().contains(OConstants.PERSON_TWO_SONS) ||
                    people.get(i).getRelation().contains(OConstants.PERSON_DAUGHTER) || people.get(i).getRelation().contains(OConstants.PERSON_SON)) {
                index.add(i);
            } else if (people.get(i).getRelation().contains(OConstants.PERSON_BROTHERS) || people.get(i).getRelation().contains(OConstants.PERSON_BROTHER) ||
                    people.get(i).getRelation().contains(OConstants.PERSON_TWO_BROTHERS) || people.get(i).getRelation().contains(OConstants.PERSON_SISTER) ||
                    people.get(i).getRelation().contains(OConstants.PERSON_SISTERS) || people.get(i).getRelation().contains(OConstants.PERSON_TWO_SISTERS)) {
                index.add(i);
            } else if (people.get(i).getRelation().contains(OConstants.PERSON_MOTHER_UNCLE) || people.get(i).getRelation().contains(OConstants.PERSON_MOTHER_UNCLES) ||
                    people.get(i).getRelation().contains(OConstants.PERSON_MOTHER_AUNT) || people.get(i).getRelation().contains(OConstants.PERSON_MOTHER_AUNTS)) {
                Person person = people.get(i);

//                createAlivePerson(mFirstStepData, person.getCount(), OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS, OConstants.GENDER_MALE, true, );
            }
        }

    }

    public static void createAlivePerson(ArrayList<Person> data, int size, String relation, String gender, boolean isAlive, Fraction originalPercent, Fraction sharePercent,
                                         Fraction eachPersonSharePercent, double shareValue, double eachPersonShareValue, int numberOfShares,
                                         int eachPersonNumberOfShares, int problemOrigin, String explanation, String proof, String blocked, String blockedBy) {
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
            data.add(person);


            Log.i(TAG, "createAlivePerson() person relation = " + relation + " & Alive = " + isAlive + " & gender = " + gender + " created");
            Log.i(TAG, "createAlivePerson() people size = " + data.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
