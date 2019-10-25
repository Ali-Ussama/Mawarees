package com.company.mawarees.View.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.company.mawarees.Model.Callback.DeadPersonListener;
import com.company.mawarees.Model.Models.DeadPersonModel;
import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;
import com.company.mawarees.Model.Utilities.AppUtils;
import com.company.mawarees.Model.Utilities.BrothersUtils;
import com.company.mawarees.Model.Utilities.ChildrenUtils;
import com.company.mawarees.Model.Utilities.FatherUtils;
import com.company.mawarees.Model.Utilities.HusbandAndWifeUtils;
import com.company.mawarees.Model.Utilities.MotherUtils;
import com.company.mawarees.R;
import com.company.mawarees.View.adpters.DeadDaughterRVAdapter;
import com.company.mawarees.View.adpters.DeadSonRVAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProblemActivity extends AppCompatActivity implements DeadPersonListener, View.OnClickListener {

    private static final String TAG = "ProblemActivity";

    @BindView(R.id.problem_activity_how_much_money_et_value)
    EditText mTotalMoneyET;

    @BindView(R.id.problem_activity_dead_gender_male_btn)
    Button mDeadGenderMale;

    @BindView(R.id.problem_activity_dead_gender_female_btn)
    Button mDeadGenderFemale;

    @BindView(R.id.problem_activity_wife_layout_container)
    LinearLayout mWifeLayout;

    @BindView(R.id.problem_activity_wife_value)
    EditText mWifeValueET;

    @BindView(R.id.problem_activity_husband_value)
    TextView mHusbandValueTV;

    @BindView(R.id.problem_activity_husband_layout_container)
    LinearLayout mHusbandLayout;

    @BindView(R.id.problem_activity_alive_son_value)
    EditText mAliveSonValueTV;

    @BindView(R.id.problem_activity_alive_daughter_value)
    EditText mAliveDaughterValueTV;

    @BindView(R.id.problem_activity_dead_son_value)
    EditText mDeadSonValueET;

    @BindView(R.id.problem_activity_dead_daughter_value)
    EditText mDeadDaughterValueET;

    @BindView(R.id.problem_activity_father_value)
    TextView mFatherValueTV;

    @BindView(R.id.problem_activity_mother_value)
    TextView mMotherValueTV;

    @BindView(R.id.problem_activity_father_grandpa_value)
    TextView mFatherGrandPaValueTV;

    @BindView(R.id.problem_activity_father_grandma_value)
    TextView mFatherGrandMaValueTV;

    @BindView(R.id.problem_activity_mother_grandpa_value)
    TextView mMotherGrandPaValueTV;

    @BindView(R.id.problem_activity_mother_grandma_value)
    TextView mMotherGrandMaValueTV;

    @BindView(R.id.problem_activity_brothers_value)
    EditText mBrothersValueTV;

    @BindView(R.id.problem_activity_sisters_value)
    EditText mSistersValueTV;

    @BindView(R.id.problem_activity_father_uncles_value)
    EditText mFatherUnclesValueTV;

    @BindView(R.id.problem_activity_father_aunts_value)
    EditText mFatherAuntsValueTV;

    @BindView(R.id.problem_activity_mother_uncles_value)
    EditText mMotherUnclesValueTV;

    @BindView(R.id.problem_activity_mother_aunts_value)
    EditText mMotherAuntsValueTV;

    @BindView(R.id.problem_activity_solve_button)
    Button mSolveProblemBtn;

    @BindView(R.id.problem_activity_new_problem_button)
    Button mNewProblemBtn;

    ProblemActivity mCurrent;
    public ArrayList<Person> mPeople;
    public OConstants oConstants;

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            ButterKnife.bind(this);
            init();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void init() {
        try {

            mCurrent = ProblemActivity.this;
            mPeople = new ArrayList<>();
            oConstants = new OConstants();

            try {

                mToolbar = AppUtils.setupToolbar(mCurrent, 1);
                AppUtils.setToolbarTitle(mToolbar, getString(R.string.problem));

            } catch (Exception e) {
                e.printStackTrace();
            }
            //default values
            oConstants.setGender(OConstants.GENDER_MALE);
            oConstants.setHasWife(false);
            oConstants.setWivesCount(0);

            mDeadGenderMale.setOnClickListener(this);
            mDeadGenderFemale.setOnClickListener(this);
            mHusbandValueTV.setOnClickListener(this);

            mFatherValueTV.setOnClickListener(this);
            mMotherValueTV.setOnClickListener(this);
            mFatherGrandPaValueTV.setOnClickListener(this);
            mFatherGrandMaValueTV.setOnClickListener(this);
            mMotherGrandPaValueTV.setOnClickListener(this);
            mMotherGrandMaValueTV.setOnClickListener(this);
            mSolveProblemBtn.setOnClickListener(this);

            mWifeValueET.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    try {
                        int value = 0;
                        if (!charSequence.toString().trim().isEmpty()) {
                            value = Integer.parseInt(charSequence.toString().trim());
                        }

                        resetAlivePerson(OConstants.PERSON_WIFE);

                        if (value > 0) {
                            createAlivePerson(value, OConstants.PERSON_WIFE, OConstants.GENDER_FEMALE, true);

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
            mDeadSonValueET.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    try {

                        resetDeadSonsOrDaughter(OConstants.PERSON_SON);
                        resetDeadSonsOrDaughterBoyAndGirl(OConstants.PERSON_SON_BOY);
                        resetDeadSonsOrDaughterBoyAndGirl(OConstants.PERSON_SON_GIRL);

                        int value = 0;
                        if (!charSequence.toString().trim().isEmpty())
                            value = Integer.parseInt(String.valueOf(charSequence).trim());

                        createDeadSonOrDaughter(value, OConstants.PERSON_SON, OConstants.GENDER_MALE);

                        if (value > 0) {

                            try {
                                MaterialDialog mAlertDlg = AppUtils.showAlertDialogWithCustomView(mCurrent, R.layout.dead_son_dlg);
                                View view = mAlertDlg.getCustomView();

                                if (view != null) {
                                    RecyclerView mRecyclerView = view.findViewById(R.id.dead_son_dlg_RV);
                                    mRecyclerView.setLayoutManager(new LinearLayoutManager(mCurrent));
                                    ArrayList<DeadPersonModel> mDeadPersonModels = new ArrayList<>();
                                    for (int x = 0; x < value; x++) {
                                        mDeadPersonModels.add(new DeadPersonModel());
                                    }

                                    DeadSonRVAdapter mDeadSonRVAdapter = new DeadSonRVAdapter(mDeadPersonModels, mCurrent, mCurrent);
                                    mRecyclerView.setAdapter(mDeadSonRVAdapter);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
            mDeadDaughterValueET.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    try {
                        resetDeadSonsOrDaughter(OConstants.PERSON_DAUGHTER);
                        resetDeadSonsOrDaughterBoyAndGirl(OConstants.PERSON_DAUGHTER_BOY);
                        resetDeadSonsOrDaughterBoyAndGirl(OConstants.PERSON_DAUGHTER_GIRL);

                        int value = 0;
                        if (!charSequence.toString().trim().isEmpty())
                            value = Integer.parseInt(String.valueOf(charSequence).trim());

                        createDeadSonOrDaughter(value, OConstants.PERSON_DAUGHTER, OConstants.GENDER_FEMALE);

                        if (value > 0) {
                            MaterialDialog mAlertDlg = AppUtils.showAlertDialogWithCustomView(mCurrent, R.layout.dead_daughter_dlg);
                            View view = mAlertDlg.getCustomView();

                            if (view != null) {
                                RecyclerView mRecyclerView = view.findViewById(R.id.dead_daughter_dlg_RV);
                                mRecyclerView.setLayoutManager(new LinearLayoutManager(mCurrent));
                                ArrayList<DeadPersonModel> mDeadPersonModels = new ArrayList<>();
                                for (int x = 0; x < value; x++) {
                                    mDeadPersonModels.add(new DeadPersonModel());
                                }

                                DeadDaughterRVAdapter mDeadSonRVAdapter = new DeadDaughterRVAdapter(mDeadPersonModels, mCurrent, mCurrent);
                                mRecyclerView.setAdapter(mDeadSonRVAdapter);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

            mAliveSonValueTV.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    int value = 0;
                    if (!charSequence.toString().trim().isEmpty()) {
                        value = Integer.parseInt(charSequence.toString().trim());
                    }

                    if (OConstants.getChildrenInDaughters(mPeople) > 2) {
                        resetAlivePerson(OConstants.PERSON_More_Than_three_DAUGHTERS);
                    }

                    resetAlivePerson(OConstants.PERSON_SON);

                    if (value > 0) {
                        createAlivePerson(value, OConstants.PERSON_SON, OConstants.GENDER_MALE, true);

                        if (OConstants.getChildrenInDaughters(mPeople) > 2) {
                            createAlivePerson(1, OConstants.PERSON_More_Than_three_DAUGHTERS, OConstants.GENDER_MALE, true);
                        }
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
            mAliveDaughterValueTV.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    int value = 0;
                    if (!charSequence.toString().trim().isEmpty()) {
                        value = Integer.parseInt(charSequence.toString().trim());
                    }

                    if (OConstants.getChildrenInDaughters(mPeople) > 2) {
                        resetAlivePerson(OConstants.PERSON_More_Than_three_DAUGHTERS);
                    }

                    resetAlivePerson(OConstants.PERSON_DAUGHTER);

                    if (value > 0) {
                        createAlivePerson(value, OConstants.PERSON_DAUGHTER, OConstants.GENDER_FEMALE, true);

                        if (OConstants.getChildrenInDaughters(mPeople) > 2) {
                            createAlivePerson(1, OConstants.PERSON_More_Than_three_DAUGHTERS, OConstants.GENDER_MALE, true);

                        }
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

            mBrothersValueTV.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    int value = 0;
                    if (!charSequence.toString().trim().isEmpty()) {
                        value = Integer.parseInt(charSequence.toString().trim());
                    }

                    resetAlivePerson(OConstants.PERSON_BROTHER);
                    if (value > 0) {
                        createAlivePerson(value, OConstants.PERSON_BROTHER, OConstants.GENDER_MALE, true);
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
            mSistersValueTV.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    try {
                        int value = 0;
                        if (!charSequence.toString().trim().isEmpty()) {
                            value = Integer.parseInt(charSequence.toString().trim());
                        }

                        resetAlivePerson(OConstants.PERSON_SISTER);
                        if (value > 0) {
                            createAlivePerson(value, OConstants.PERSON_SISTER, OConstants.GENDER_FEMALE, true);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

            mFatherUnclesValueTV.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    try {
                        int value = 0;
                        if (!charSequence.toString().trim().isEmpty()) {
                            value = Integer.parseInt(charSequence.toString().trim());
                        }

                        // if no father aunts created then reset
                        if (OConstants.getPersonCount(mPeople, OConstants.PERSON_FATHER_AUNT) < 1)
                            resetAlivePerson(OConstants.PERSON_FATHER_UNCLES_AND_AUNTS);

                        resetAlivePerson(OConstants.PERSON_FATHER_UNCLE);

                        if (value > 0) {
                            createAlivePerson(value, OConstants.PERSON_FATHER_UNCLE, OConstants.GENDER_MALE, true);

                            // if no father aunts created then create
                            if (OConstants.getPersonCount(mPeople, OConstants.PERSON_FATHER_AUNT) < 1)
                                createAlivePerson(1, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS, OConstants.GENDER_MALE, true);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
            mFatherAuntsValueTV.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    try {
                        int value = 0;
                        if (!charSequence.toString().trim().isEmpty()) {
                            value = Integer.parseInt(charSequence.toString().trim());
                        }

                        // if no father uncles created then reset
                        if (OConstants.getPersonCount(mPeople, OConstants.PERSON_FATHER_UNCLE) < 1)
                            resetAlivePerson(OConstants.PERSON_FATHER_UNCLES_AND_AUNTS);

                        resetAlivePerson(OConstants.PERSON_FATHER_AUNT);

                        if (value > 0) {
                            createAlivePerson(value, OConstants.PERSON_FATHER_AUNT, OConstants.GENDER_FEMALE, true);

                            // if no father uncles created then create
                            if (OConstants.getPersonCount(mPeople, OConstants.PERSON_FATHER_UNCLE) < 1)
                                createAlivePerson(1, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS, OConstants.GENDER_MALE, true);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
            mMotherUnclesValueTV.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    try {
                        int value = 0;
                        if (!charSequence.toString().trim().isEmpty()) {
                            value = Integer.parseInt(charSequence.toString().trim());
                        }

                        resetAlivePerson(OConstants.PERSON_MOTHER_UNCLE);

                        // if no mother aunts created then reset
                        if (OConstants.getPersonCount(mPeople, OConstants.PERSON_MOTHER_AUNT) < 1)
                            resetAlivePerson(OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS);

                        if (value > 0) {
                            createAlivePerson(value, OConstants.PERSON_MOTHER_UNCLE, OConstants.GENDER_MALE, true);

                            // if no mother aunts created then create
                            if (OConstants.getPersonCount(mPeople, OConstants.PERSON_MOTHER_AUNT) < 1)
                                createAlivePerson(1, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS, OConstants.GENDER_MALE, true);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
            mMotherAuntsValueTV.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    try {
                        int value = 0;
                        if (!charSequence.toString().trim().isEmpty()) {
                            value = Integer.parseInt(charSequence.toString().trim());
                        }

                        // if no mother uncles created then reset
                        if (OConstants.getPersonCount(mPeople, OConstants.PERSON_MOTHER_UNCLE) < 1)
                            resetAlivePerson(OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS);

                        resetAlivePerson(OConstants.PERSON_MOTHER_AUNT);

                        if (value > 0) {
                            createAlivePerson(value, OConstants.PERSON_MOTHER_AUNT, OConstants.GENDER_FEMALE, true);

                            // if no mother uncles created then create
                            if (OConstants.getPersonCount(mPeople, OConstants.PERSON_MOTHER_UNCLE) < 1)
                                createAlivePerson(1, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS, OConstants.GENDER_MALE, true);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void resetAlivePerson(String relation) {
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
            Log.i(TAG, "resetAlivePerson() people size = " + mPeople.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createAlivePerson(int size, String relation, String gender, boolean isAlive) {
        try {
            ArrayList<Person> people = new ArrayList<>();

            for (int number = 0; number < size; number++) {

                Person person = new Person();
                person.setAlive(isAlive);
                person.setCount(size);
                person.setRelation(relation);
                person.setGender(gender);
                person.setDeadSonNumber(-1);
                people.add(person);
            }

            if (!people.isEmpty()) {
                mPeople.addAll(people);
            }

            Log.i(TAG, "createAlivePerson() person relation = " + relation + " & Alive = " + isAlive + " & gender = " + gender + " created");
            Log.i(TAG, "createAlivePerson() people size = " + mPeople.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void resetDeadSonsOrDaughter(String relation) {
        try {

            ArrayList<Person> index = new ArrayList<>();

            for (int i = 0; i < mPeople.size(); i++) {
                if (mPeople.get(i).getRelation().matches(relation) && !mPeople.get(i).isAlive()) {
                    index.add(mPeople.get(i));
                }
            }

            for (Person person : index) {
                mPeople.remove(person);
            }

            Log.i(TAG, "resetDeadSonsOrDaughter() people size = " + mPeople.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void resetDeadSonsOrDaughterBoyAndGirl(String relation) {
        try {

            ArrayList<Person> index = new ArrayList<>();

            for (int i = 0; i < mPeople.size(); i++) {
                if (mPeople.get(i).getRelation().matches(relation)) {
                    index.add(mPeople.get(i));
                }
            }

            for (Person person : index) {
                mPeople.remove(person);
            }

            Log.i(TAG, "resetDeadSonsOrDaughterBoyAndGirl() people size = " + mPeople.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createDeadSonOrDaughter(int size, String relation, String gender) {

        ArrayList<Person> children = new ArrayList<>();

        for (int number = 0; number < size; number++) {

            Person person = new Person();
            person.setAlive(false);
            person.setCount(size);
            person.setDeadSonNumber(number + 1);
            person.setRelation(relation);
            person.setGender(gender);
            children.add(person);
        }

        if (!children.isEmpty()) {
            mPeople.addAll(children);
        }

        Log.i(TAG, "createDeadSonOrDaughter() people size = " + mPeople.size());
    }

    @Override
    public void addChildListener(ArrayList<Person> children, String relation, int deadChildNumber) {
        try {
            ArrayList<Person> index = new ArrayList<>();

            for (int i = 0; i < mPeople.size(); i++) {
                if (mPeople.get(i).getRelation().matches(relation) && mPeople.get(i).getDeadSonNumber() == deadChildNumber) {
                    index.add(mPeople.get(i));
                }
            }
            if (!index.isEmpty()) {
                for (Person person : index) {
                    mPeople.remove(person);
                }
            }

            if (children != null && !children.isEmpty()) {
                mPeople.addAll(children);
            }
            if (mPeople != null)
                Log.i(TAG, "Created People size = " + mPeople.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        if (view.equals(mDeadGenderMale)) {
            handleDeadGenderMale();

        } else if (view.equals(mDeadGenderFemale)) {
            handleDeadGenderFemale();

        } else if (view.equals(mHusbandValueTV)) {
            handleHusbandTV();

        } else if (view.equals(mFatherValueTV)) {
            handleDeadPersonTV(mFatherValueTV, OConstants.PERSON_FATHER, getString(R.string.man_dead));

        } else if (view.equals(mFatherGrandPaValueTV)) {
            handleDeadPersonTV(mFatherGrandPaValueTV, OConstants.PERSON_FATHER_GRANDFATHER, getString(R.string.man_dead));

        } else if (view.equals(mFatherGrandMaValueTV)) {
            handleDeadPersonTV(mFatherGrandMaValueTV, OConstants.PERSON_FATHER_GRANDMOTHER, getString(R.string.woman_dead));

        } else if (view.equals(mMotherValueTV)) {
            handleDeadPersonTV(mMotherValueTV, OConstants.PERSON_MOTHER, getString(R.string.woman_dead));

        } else if (view.equals(mMotherGrandPaValueTV)) {
            handleDeadPersonTV(mMotherGrandPaValueTV, OConstants.PERSON_MOTHER_GRANDFATHER, getString(R.string.man_dead));

        } else if (view.equals(mMotherGrandMaValueTV)) {
            handleDeadPersonTV(mMotherGrandMaValueTV, OConstants.PERSON_MOTHER_GRANDMOTHER, getString(R.string.woman_dead));
        } else if (view.equals(mSolveProblemBtn)) {
            handleSolveProblem();
        }

    }

    private void handleSolveProblem() {
        try {
            // TODO handle dead gender ( Done )
            // TODO handle husband and wife (Done)
            // TODO handle has vars

            if (mTotalMoneyET.getText() == null || mTotalMoneyET.getText().toString().trim().isEmpty()) {
                mTotalMoneyET.setError(getString(R.string.required));
            } else if (mPeople.isEmpty()) {
                AppUtils.showAlertDialog(mCurrent, getString(R.string.please_enter_people));
            } else {

                MaterialDialog mProgressDlg = AppUtils.showProgressDialog(mCurrent, getString(R.string.solving_the_problem));

                double totalMoney = Double.parseDouble(mTotalMoneyET.getText().toString().trim());
                oConstants.setTotalMoney(totalMoney);

//                handleDeadManHasWifeOrNot();
                handleHasPersonOrNot();

                validatePeople();

                ChildrenUtils.calculateChildren(mPeople, oConstants);
//                Log.i(TAG, "validatePeople(): moreThanThreeDaughters Count = " + OConstants.getPersonCount(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS) + " sharePercent = " + OConstants.getPerson(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS).getSharePercent().getNumerator() + "/" + OConstants.getPerson(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS).getSharePercent().getDenominator());

                HusbandAndWifeUtils.calculateHusbandAndWife(mPeople, oConstants);
//                Log.i(TAG, "validatePeople(): moreThanThreeDaughters Count = " + OConstants.getPersonCount(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS) + " sharePercent = " + OConstants.getPerson(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS).getSharePercent().getNumerator() + "/" + OConstants.getPerson(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS).getSharePercent().getDenominator());

                MotherUtils.calculateMother(mPeople, oConstants);
//                Log.i(TAG, "validatePeople(): moreThanThreeDaughters Count = " + OConstants.getPersonCount(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS) + " sharePercent = " + OConstants.getPerson(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS).getSharePercent().getNumerator() + "/" + OConstants.getPerson(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS).getSharePercent().getDenominator());

                FatherUtils.calculateFather(mPeople, oConstants);
//                Log.i(TAG, "validatePeople(): moreThanThreeDaughters Count = " + OConstants.getPersonCount(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS) + " sharePercent = " + OConstants.getPerson(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS).getSharePercent().getNumerator() + "/" + OConstants.getPerson(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS).getSharePercent().getDenominator());

                BrothersUtils.calculateBrothers(mPeople, oConstants);
//                Log.i(TAG, "validatePeople(): moreThanThreeDaughters Count = " + OConstants.getPersonCount(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS) + " sharePercent = " + OConstants.getPerson(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS).getSharePercent().getNumerator() + "/" + OConstants.getPerson(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS).getSharePercent().getDenominator());

                validateBlockedPeople();
                OConstants.calculateShareValue(mPeople, oConstants);

                mProgressDlg.dismiss();

                Log.i(TAG, "handleSolveProblem(): calculations are done");

                showResult(mPeople);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void validateBlockedPeople() {
        try {

            if (oConstants.isHasFather()) {
                OConstants.blockPerson(mPeople, OConstants.PERSON_FATHER_GRANDFATHER, OConstants.PERSON_FATHER);
                OConstants.blockPerson(mPeople, OConstants.PERSON_FATHER_GRANDMOTHER, OConstants.PERSON_FATHER);

                OConstants.blockPerson(mPeople, OConstants.PERSON_BROTHER, OConstants.PERSON_FATHER);
                OConstants.blockPerson(mPeople, OConstants.PERSON_SISTER, OConstants.PERSON_FATHER);

                OConstants.blockPerson(mPeople, OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER, OConstants.PERSON_FATHER);
                OConstants.blockPerson(mPeople, OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER, OConstants.PERSON_FATHER);

                OConstants.blockPerson(mPeople, OConstants.PERSON_FATHER_UNCLE, OConstants.PERSON_FATHER);
                OConstants.blockPerson(mPeople, OConstants.PERSON_FATHER_AUNT, OConstants.PERSON_FATHER);
                OConstants.blockPerson(mPeople, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS, OConstants.PERSON_FATHER);

                OConstants.blockPerson(mPeople, OConstants.PERSON_MOTHER_UNCLE, OConstants.PERSON_FATHER);
                OConstants.blockPerson(mPeople, OConstants.PERSON_MOTHER_AUNT, OConstants.PERSON_FATHER);
                OConstants.blockPerson(mPeople, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS, OConstants.PERSON_FATHER);
            }

            if (oConstants.isHasMother()) {
                OConstants.blockPerson(mPeople, OConstants.PERSON_MOTHER_GRANDFATHER, OConstants.PERSON_MOTHER);
                OConstants.blockPerson(mPeople, OConstants.PERSON_MOTHER_GRANDMOTHER, OConstants.PERSON_MOTHER);

                OConstants.blockPerson(mPeople, OConstants.PERSON_BROTHER, OConstants.PERSON_MOTHER);
                OConstants.blockPerson(mPeople, OConstants.PERSON_SISTER, OConstants.PERSON_MOTHER);

                OConstants.blockPerson(mPeople, OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER, OConstants.PERSON_MOTHER);
                OConstants.blockPerson(mPeople, OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER, OConstants.PERSON_MOTHER);

                OConstants.blockPerson(mPeople, OConstants.PERSON_FATHER_UNCLE, OConstants.PERSON_MOTHER);
                OConstants.blockPerson(mPeople, OConstants.PERSON_FATHER_AUNT, OConstants.PERSON_MOTHER);
                OConstants.blockPerson(mPeople, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS, OConstants.PERSON_MOTHER);

                OConstants.blockPerson(mPeople, OConstants.PERSON_MOTHER_UNCLE, OConstants.PERSON_MOTHER);
                OConstants.blockPerson(mPeople, OConstants.PERSON_MOTHER_AUNT, OConstants.PERSON_MOTHER);
                OConstants.blockPerson(mPeople, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS, OConstants.PERSON_MOTHER);
            }

            if (oConstants.isHasChildren()) {

                OConstants.blockPerson(mPeople, OConstants.PERSON_BROTHER, "أبناء");
                OConstants.blockPerson(mPeople, OConstants.PERSON_SISTER, "أبناء");

                OConstants.blockPerson(mPeople, OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER, "أبناء");
                OConstants.blockPerson(mPeople, OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER, "أبناء");

                OConstants.blockPerson(mPeople, OConstants.PERSON_FATHER_UNCLE, "أبناء");
                OConstants.blockPerson(mPeople, OConstants.PERSON_FATHER_AUNT, "أبناء");
                OConstants.blockPerson(mPeople, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS, "أبناء");

                OConstants.blockPerson(mPeople, OConstants.PERSON_MOTHER_UNCLE, "أبناء");
                OConstants.blockPerson(mPeople, OConstants.PERSON_MOTHER_AUNT, "أبناء");
                OConstants.blockPerson(mPeople, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS, "أبناء");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void validatePeople() {

        if (OConstants.getPersonCount(mPeople, OConstants.PERSON_WIFE) < 1) {
            oConstants.setHasWife(false);
            oConstants.setWivesCount(0);
        } else if (OConstants.getPersonCount(mPeople, OConstants.PERSON_WIFE) > 0) {
            oConstants.setHasWife(true);
            oConstants.setWivesCount(Integer.parseInt(mWifeValueET.getText().toString()));
        }

        if (OConstants.getPersonCount(mPeople, OConstants.PERSON_SON) + OConstants.getPersonCount(mPeople, OConstants.PERSON_DAUGHTER) < 1) {
            oConstants.setHasChildren(false);
        } else if (OConstants.getPersonCount(mPeople, OConstants.PERSON_SON) + OConstants.getPersonCount(mPeople, OConstants.PERSON_DAUGHTER) > 0) {
            oConstants.setHasChildren(true);
        }


        if (OConstants.getSistersCount(mPeople) + OConstants.getBrothersCount(mPeople) >= 3) {
            oConstants.setHasBrothersAndSisters(true);
        } else {
            oConstants.setHasBrothersAndSisters(false);
        }


        if (OConstants.getPersonCount(mPeople, OConstants.PERSON_FATHER) == 1) {
            oConstants.setHasFather(true);
        } else {
            oConstants.setHasFather(false);
        }

        if (OConstants.getPersonCount(mPeople, OConstants.PERSON_MOTHER) == 1) {
            oConstants.setHasMother(true);
        } else {
            oConstants.setHasMother(false);
        }

        if (OConstants.getPersonCount(mPeople, OConstants.PERSON_FATHER_GRANDFATHER) == 1) {
            oConstants.setHasFather_GrandFather(true);
        } else {
            oConstants.setHasFather_GrandFather(false);
        }

        if (OConstants.getPersonCount(mPeople, OConstants.PERSON_FATHER_GRANDMOTHER) == 1) {
            oConstants.setHasFather_GrandMother(true);
        } else {
            oConstants.setHasFather_GrandMother(false);
        }

        if (OConstants.getPersonCount(mPeople, OConstants.PERSON_MOTHER_GRANDFATHER) == 1) {
            oConstants.setHasMother_GrandFather(true);
        } else {
            oConstants.setHasMother_GrandFather(false);
        }

        if (OConstants.getPersonCount(mPeople, OConstants.PERSON_MOTHER_GRANDMOTHER) == 1) {
            oConstants.setHasMother_GrandMother(true);
        } else {
            oConstants.setHasMother_GrandMother(false);
        }

        Log.i(TAG, "validatePeople(): isHasChildren " + oConstants.isHasChildren());
        Log.i(TAG, "validatePeople(): isHasFather " + oConstants.isHasFather());
        Log.i(TAG, "validatePeople(): isHasMother " + oConstants.isHasMother());
        Log.i(TAG, "validatePeople(): isHasFather_GrandFather " + oConstants.isHasFather_GrandFather());
        Log.i(TAG, "validatePeople(): isHasFather_GrandMother " + oConstants.isHasFather_GrandMother());
        Log.i(TAG, "validatePeople(): isHasMother_GrandFather " + oConstants.isHasMother_GrandFather());
        Log.i(TAG, "validatePeople(): isHasMother_GrandMother " + oConstants.isHasMother_GrandMother());
        Log.i(TAG, "validatePeople(): isHasBrothersAndSisters " + oConstants.isHasBrothersAndSisters());
        Log.i(TAG, "validatePeople(): isHasWife " + oConstants.isHasWife());
        Log.i(TAG, "validatePeople(): isHasHusband " + oConstants.isHasHusband());

    }

    private void showResult(ArrayList<Person> mPeople) {

        try {

            String result = "";

            for (Person person : mPeople) {
                try {
                    if (person.getBlocked() == null) {


                        Log.i(TAG, " printOutput(): person Relation " + person.getRelation() + " & person Share Value = " + person.getShareValue());
                        Log.i(TAG, " printOutput(): person Share Percent " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator());
                        Log.i(TAG, " printOutput(): person Problem Origin " + person.getProblemOrigin());

                        result = result.concat("--------------------------\n");
                        result = person.getRelation() + "\nShareValue = " + person.getShareValue() + " \nShare Percent = " + person.getSharePercent().getNumerator() + "/" + person.getSharePercent().getDenominator() +
                                "\nProblem Origin = " + person.getProblemOrigin() + "\nNumber Of Shares = " + person.getNumberOfShares() + "\n";

                        result = result.concat("--------------------------\n");

                        Log.i(TAG, result);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Intent intent = new Intent(mCurrent, ResultActivity.class);
            intent.putParcelableArrayListExtra("data", mPeople);
            intent.putExtra(getString(R.string.intent_total_money), oConstants.getTotalMoney());
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleHasPersonOrNot() {
        try {

            if (OConstants.getSonsCount(mPeople) > 0) {
                setHasOptions(OConstants.PERSON_SON, true);
            } else {
                setHasOptions(OConstants.PERSON_SON, false);
            }

            if (OConstants.getDaughtersCount(mPeople) > 0) {
                setHasOptions(OConstants.PERSON_DAUGHTER, true);
            } else {
                setHasOptions(OConstants.PERSON_DAUGHTER, false);
            }

            if (OConstants.getBrothersCount(mPeople) > 0) {
                setHasOptions(OConstants.PERSON_BROTHER, true);
            } else {
                setHasOptions(OConstants.PERSON_BROTHER, false);

            }

            if (OConstants.getSistersCount(mPeople) > 0) {
                setHasOptions(OConstants.PERSON_SISTER, true);
            } else {
                setHasOptions(OConstants.PERSON_SISTER, false);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleDeadPersonTV(TextView view, String relation, String gender) {
        try {
            if (view.getText().toString().matches(gender)) {
                view.setText(getString(R.string.alive));

                setHasOptions(relation, true);

                // create alive person
                if (gender.matches(getString(R.string.man_dead))) {
                    createAlivePerson(1, relation, OConstants.GENDER_MALE, true);

                } else if (gender.matches(getString(R.string.woman_dead))) {
                    createAlivePerson(1, relation, OConstants.GENDER_FEMALE, true);
                }//end of create alive person

            } else if (gender.matches(getString(R.string.man_dead))) {
                view.setText(getString(R.string.man_dead));
                resetAlivePerson(relation);
                setHasOptions(relation, false);
            } else {
                view.setText(getString(R.string.woman_dead));
                resetAlivePerson(relation);
                setHasOptions(relation, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setHasOptions(String relation, boolean hasPerson) {
        try {

            Log.i(TAG, "setHasOptions(): setting has person " + relation + " = " + hasPerson);

            switch (relation) {
                case OConstants.PERSON_HUSBAND:
                    oConstants.setHasHusband(hasPerson);
                    break;
                case OConstants.PERSON_WIFE:
                    oConstants.setHasWife(hasPerson);

                case OConstants.PERSON_FATHER:
                    oConstants.setHasFather(hasPerson);
                    break;
                case OConstants.PERSON_MOTHER:
                    oConstants.setHasMother(hasPerson);
                    break;
                case OConstants.PERSON_FATHER_GRANDFATHER:
                    oConstants.setHasFather_GrandFather(hasPerson);
                    break;
                case OConstants.PERSON_FATHER_GRANDMOTHER:
                    oConstants.setHasFather_GrandMother(hasPerson);
                    break;
                case OConstants.PERSON_MOTHER_GRANDFATHER:
                    oConstants.setHasMother_GrandFather(hasPerson);
                    break;
                case OConstants.PERSON_MOTHER_GRANDMOTHER:
                    oConstants.setHasMother_GrandMother(hasPerson);
                    break;
                case OConstants.PERSON_SON:
                    oConstants.setHasChildren(hasPerson);
                    Log.i(TAG, "isHasChildren = " + oConstants.isHasChildren());
                    break;
                case OConstants.PERSON_DAUGHTER:
                    oConstants.setHasChildren(hasPerson);
                    Log.i(TAG, "isHasChildren = " + oConstants.isHasChildren());
                    break;
                case OConstants.PERSON_BROTHER:
                    if (OConstants.getSistersCount(mPeople) + OConstants.getBrothersCount(mPeople) >= 3) {
                        oConstants.setHasBrothersAndSisters(hasPerson);
                    } else {
                        oConstants.setHasBrothersAndSisters(!hasPerson);
                    }
                    break;
                case OConstants.PERSON_SISTER:
                    if (OConstants.getSistersCount(mPeople) + OConstants.getBrothersCount(mPeople) >= 3) {
                        oConstants.setHasBrothersAndSisters(hasPerson);
                    } else {
                        oConstants.setHasBrothersAndSisters(!hasPerson);
                    }
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleHusbandTV() {
        try {
            if (mHusbandValueTV.getText().toString().matches(getString(R.string.man_dead))) {
                mHusbandValueTV.setText(getString(R.string.alive));

                setHasOptions(OConstants.PERSON_HUSBAND, true);

                createAlivePerson(1, OConstants.PERSON_HUSBAND, OConstants.GENDER_MALE, true);
            } else {
                mHusbandValueTV.setText(getString(R.string.man_dead));

                setHasOptions(OConstants.PERSON_HUSBAND, false);

                resetAlivePerson(OConstants.PERSON_HUSBAND);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleDeadGenderFemale() {
        try {

            oConstants.setGender(OConstants.GENDER_FEMALE);

            mWifeLayout.setVisibility(View.GONE);
            mHusbandLayout.setVisibility(View.VISIBLE);
            mHusbandValueTV.setText(getString(R.string.man_dead));

            mDeadGenderFemale.setBackgroundColor(getResources().getColor(R.color.browLight));
            mDeadGenderMale.setBackground(getResources().getDrawable(R.drawable.custom_white_rect_with_brown_borders));

            resetAlivePerson(OConstants.PERSON_WIFE);
            resetAlivePerson(OConstants.PERSON_HUSBAND);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleDeadGenderMale() {
        try {
            oConstants.setGender(OConstants.GENDER_MALE);

            mWifeValueET.setText("");
            mWifeLayout.setVisibility(View.VISIBLE);
            mHusbandLayout.setVisibility(View.GONE);

            mDeadGenderMale.setBackgroundColor(getResources().getColor(R.color.browLight));
            mDeadGenderFemale.setBackground(getResources().getDrawable(R.drawable.custom_white_rect_with_brown_borders));

            mHusbandValueTV.setText(getString(R.string.man_dead));
            resetAlivePerson(OConstants.PERSON_HUSBAND);
            resetAlivePerson(OConstants.PERSON_WIFE);

            setHasOptions(OConstants.PERSON_HUSBAND, false);
            setHasOptions(OConstants.PERSON_WIFE, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
