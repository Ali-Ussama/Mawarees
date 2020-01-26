package com.company.mawarees.View.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.afollestad.materialdialogs.MaterialDialog;
import com.company.mawarees.Model.Models.ExplainPhase1;
import com.company.mawarees.Model.Models.ExplainPhase4;
import com.company.mawarees.Model.Models.Fraction;
import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;
import com.company.mawarees.Model.Utilities.AppUtils;
import com.company.mawarees.Model.Utilities.BrothersUtils;
import com.company.mawarees.Model.Utilities.ChildrenUtils;
import com.company.mawarees.Model.Utilities.FatherUtils2;
import com.company.mawarees.Model.Utilities.GrandPaAndGrandMaUtils;
import com.company.mawarees.Model.Utilities.HusbandAndWifeUtils;
import com.company.mawarees.Model.Utilities.MotherUtils2;
import com.company.mawarees.Model.Utilities.UnclesAndAuntsUtils;
import com.company.mawarees.PrefManager;
import com.company.mawarees.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProblemActivity2 extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private static final String TAG = "ProblemActivity2";

    @BindView(R.id.problem_activity_how_much_money_et_value)
    TextInputEditText mTotalMoneyET;

    @BindView(R.id.activity_problem_gender_layout)
    RadioGroup mGenderRadioGroup;

    @BindView(R.id.activity_problem_gender_female_radio_button)
    RadioButton mFemaleRB;

    @BindView(R.id.activity_problem_gender_male_radio_button)
    RadioButton mMaleRB;

    @BindView(R.id.problem_activity_solve_button_2)
    Button mSolveProblemBtn;

    //Wife
    @BindView(R.id.problem_activity_wife_container)
    ConstraintLayout mWivesContainer;

    @BindView(R.id.problem_activity_wife_et_value)
    TextInputEditText mWifeValueET;

    //Husband
    @BindView(R.id.problem_activity_husband_layout)
    ConstraintLayout mHusbandContainer;

    @BindView(R.id.husband_layout_radio_group)
    RadioGroup mHusbandRadioGroup;

    @BindView(R.id.husband_rb_yes)
    RadioButton mHusbandYesRB;

    @BindView(R.id.husband_rb_no)
    RadioButton mHusbandNoRB;

    //Alive Son
    @BindView(R.id.problem_activity_alive_son_et_value)
    TextInputEditText mAliveSonValueTV;

    //Alive Daughter
    @BindView(R.id.problem_activity_alive_daughter_et_value)
    TextInputEditText mAliveDaughterValueTV;

    //Mother
    @BindView(R.id.mother_layout_radio_group)
    RadioGroup mMotherRadioGroup;

    @BindView(R.id.mother_rb_yes)
    RadioButton mMotherYesRB;

    @BindView(R.id.mother_rb_no)
    RadioButton mMotherNoRB;

    //Father
    @BindView(R.id.father_layout_radio_group)
    RadioGroup mFatherRadioGroup;

    @BindView(R.id.father_rb_yes)
    RadioButton mFatherYesRB;

    @BindView(R.id.father_rb_no)
    RadioButton mFatherNoRB;

    // Father GrandPa
    @BindView(R.id.problem_activity_father_grandpa_layout)
    ConstraintLayout mFatherGrandPaContainer;

    @BindView(R.id.father_grandpa_layout_radio_group)
    RadioGroup mFatherGrandpaRadioGroup;

    @BindView(R.id.father_grandpa_rb_yes)
    RadioButton mFatherGrandpaYesRB;

    @BindView(R.id.father_grandpa_rb_no)
    RadioButton mFatherGrandpaNoRB;

    // Father GrandMa
    @BindView(R.id.problem_activity_father_grandma_layout)
    ConstraintLayout mFatherGrandMaContainer;

    @BindView(R.id.father_grandma_layout_radio_group)
    RadioGroup mFatherGrandmaRadioGroup;

    @BindView(R.id.father_grandma_rb_yes)
    RadioButton mFatherGrandmaYesRB;

    @BindView(R.id.father_grandma_rb_no)
    RadioButton mFatherGrandmaNoRB;

    // Mother GrandMa
    @BindView(R.id.problem_activity_mother_grandma_layout)
    ConstraintLayout mMotherGrandMaContainer;

    @BindView(R.id.mother_grandma_layout_radio_group)
    RadioGroup mMotherGrandmaRadioGroup;

    @BindView(R.id.mother_grandma_rb_yes)
    RadioButton mMotherGrandmaYesRB;

    @BindView(R.id.mother_grandma_rb_no)
    RadioButton mMotherGrandmaNoRB;

    // Mother GrandPa
    @BindView(R.id.problem_activity_mother_grandpa_layout)
    ConstraintLayout mMotherGrandPaContainer;

    @BindView(R.id.mother_grandpa_layout_radio_group)
    RadioGroup mMotherGrandpaRadioGroup;

    @BindView(R.id.mother_grandpa_rb_yes)
    RadioButton mMotherGrandpaYesRB;

    @BindView(R.id.mother_grandpa_rb_no)
    RadioButton mMotherGrandpaNoRB;

    //Brothers
    @BindView(R.id.problem_activity_brother_et_value)
    TextInputEditText mBrothersValueTV;

    //Sisters
    @BindView(R.id.problem_activity_sister_et_value)
    TextInputEditText mSistersValueTV;

    //Father Uncle
    @BindView(R.id.problem_activity_father_uncle_et_value)
    EditText mFatherUnclesValueTV;

    //Father Aunt
    @BindView(R.id.problem_activity_father_aunt_et_value)
    EditText mFatherAuntsValueTV;

    //Mother Uncle
    @BindView(R.id.problem_activity_mother_uncle_et_value)
    EditText mMotherUnclesValueTV;

    //Mother Aunt
    @BindView(R.id.problem_activity_mother_aunt_et_value)
    EditText mMotherAuntsValueTV;

    ProblemActivity2 mCurrent;
    public ArrayList<Person> mPeople;
    public OConstants oConstants;

    private Toolbar mToolbar;

    @Override
    protected void onResume() {
        super.onResume();
        try {
            resetViews();

            if (oConstants != null) {
                if (oConstants.mPrefManager != null) {
                    oConstants.mPrefManager.saveInt(PrefManager.KEY_HEADS, 0);
                    oConstants.mPrefManager.saveInt(PrefManager.KEY_NEW_PROBLEM_ORIGIN, 0);
                    oConstants.mPrefManager.saveInt(PrefManager.KEY_SAVED_NUMBER_1, 0);
                    oConstants.mPrefManager.saveInt(PrefManager.KEY_SAVED_NUMBER_2, 0);
                    oConstants.mPrefManager.saveBoolean(PrefManager.KEY_ONE_GROUP, false);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_main2);
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() {
        try {
            ButterKnife.bind(this);
            mCurrent = ProblemActivity2.this;

            mPeople = new ArrayList<>();
            oConstants = new OConstants(mCurrent);

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

            //Gender
            mMaleRB.setOnCheckedChangeListener(this);
            mFemaleRB.setOnCheckedChangeListener(this);

            //Husband
            mHusbandYesRB.setOnCheckedChangeListener(this);
            mHusbandNoRB.setOnCheckedChangeListener(this);

            //Father RB
            mFatherYesRB.setOnCheckedChangeListener(this);
            mFatherNoRB.setOnCheckedChangeListener(this);

            //Father GrandPa
            mFatherGrandpaYesRB.setOnCheckedChangeListener(this);
            mFatherGrandpaNoRB.setOnCheckedChangeListener(this);

            //Father GrandMa
            mFatherGrandmaYesRB.setOnCheckedChangeListener(this);
            mFatherGrandmaNoRB.setOnCheckedChangeListener(this);

            //Mother RB
            mMotherYesRB.setOnCheckedChangeListener(this);
            mMotherNoRB.setOnCheckedChangeListener(this);

            //Mother GrandPa
            mMotherGrandpaYesRB.setOnCheckedChangeListener(this);
            mMotherGrandpaNoRB.setOnCheckedChangeListener(this);

            //Mother GrandMa
            mMotherGrandmaYesRB.setOnCheckedChangeListener(this);
            mMotherGrandmaNoRB.setOnCheckedChangeListener(this);

            mWifeValueET.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    int value = 0;
                    if (!charSequence.toString().trim().isEmpty()) {
                        value = Integer.parseInt(charSequence.toString().trim());
                    }
                    handleWifeChecked(value);
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
                    try {
                        int value = 0;
                        if (!charSequence.toString().trim().isEmpty()) {
                            value = Integer.parseInt(charSequence.toString().trim());
                        }

                        if (OConstants.getChildrenInDaughters(mPeople) > 2) {
                            resetAlivePerson(OConstants.PERSON_More_Than_three_DAUGHTERS);
                        }

                        resetAlivePerson(OConstants.PERSON_SON);

                        if (value > 0) {
                            createAlivePerson(value, OConstants.PERSON_SON, OConstants.GENDER_MALE, true, false);

                            if (OConstants.getChildrenInDaughters(mPeople) > 2) {
                                createAlivePerson(1, OConstants.PERSON_More_Than_three_DAUGHTERS, OConstants.GENDER_MALE, true, true);
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
                        createAlivePerson(value, OConstants.PERSON_DAUGHTER, OConstants.GENDER_FEMALE, true, false);

                        if (OConstants.getChildrenInDaughters(mPeople) > 2) {
                            createAlivePerson(1, OConstants.PERSON_More_Than_three_DAUGHTERS, OConstants.GENDER_MALE, true, true);
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
                        createAlivePerson(value, OConstants.PERSON_BROTHER, OConstants.GENDER_MALE, true, false);
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
                            createAlivePerson(value, OConstants.PERSON_SISTER, OConstants.GENDER_FEMALE, true, false);
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
                            createAlivePerson(value, OConstants.PERSON_FATHER_UNCLE, OConstants.GENDER_MALE, true, false);

                            if (value + OConstants.getPersonCount(mPeople, OConstants.PERSON_FATHER_AUNT) > 1) {
                                // if no father aunts created then create
                                if (OConstants.getPersonCount(mPeople, OConstants.PERSON_FATHER_AUNT) < 1)
                                    createAlivePerson(1, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS, OConstants.GENDER_MALE, true, true);
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
                            createAlivePerson(value, OConstants.PERSON_FATHER_AUNT, OConstants.GENDER_FEMALE, true, false);

                            if (value + OConstants.getPersonCount(mPeople, OConstants.PERSON_FATHER_UNCLE) > 1) {

                                // if no father uncles created then create
                                if (OConstants.getPersonCount(mPeople, OConstants.PERSON_FATHER_UNCLE) < 1)
                                    createAlivePerson(1, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS, OConstants.GENDER_MALE, true, true);
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
                            createAlivePerson(value, OConstants.PERSON_MOTHER_UNCLE, OConstants.GENDER_MALE, true, false);
                            if (value + OConstants.getPersonCount(mPeople, OConstants.PERSON_MOTHER_AUNT) > 1) {

                                // if no mother aunts created then create
                                if (OConstants.getPersonCount(mPeople, OConstants.PERSON_MOTHER_AUNT) < 1)
                                    createAlivePerson(1, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS, OConstants.GENDER_MALE, true, true);
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
                            createAlivePerson(value, OConstants.PERSON_MOTHER_AUNT, OConstants.GENDER_FEMALE, true, false);
                            if (value + OConstants.getPersonCount(mPeople, OConstants.PERSON_MOTHER_UNCLE) > 1) {

                                // if no mother uncles created then create
                                if (OConstants.getPersonCount(mPeople, OConstants.PERSON_MOTHER_UNCLE) < 1)
                                    createAlivePerson(1, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS, OConstants.GENDER_MALE, true, true);
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

            mSolveProblemBtn.setOnClickListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        try {
            if (view.equals(mSolveProblemBtn)) {
//                Log.i(TAG,"")
                handleSolveProblem();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleSolveProblem() {
        try {
            // TODO handle dead gender ( Done )
            // TODO handle husband and wife (Done)
            // TODO handle has vars

            if (mTotalMoneyET.getText() == null || mTotalMoneyET.getText().toString().trim().isEmpty()) {
                mTotalMoneyET.setError(getString(R.string.required));
                mTotalMoneyET.setFocusable(true);
                mTotalMoneyET.requestFocus();

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

                MotherUtils2.calculateMother(mPeople, oConstants);
//                Log.i(TAG, "validatePeople(): moreThanThreeDaughters Count = " + OConstants.getPersonCount(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS) + " sharePercent = " + OConstants.getPerson(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS).getSharePercent().getNumerator() + "/" + OConstants.getPerson(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS).getSharePercent().getDenominator());

                FatherUtils2.calculateFather(mPeople, oConstants);
//                Log.i(TAG, "validatePeople(): moreThanThreeDaughters Count = " + OConstants.getPersonCount(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS) + " sharePercent = " + OConstants.getPerson(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS).getSharePercent().getNumerator() + "/" + OConstants.getPerson(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS).getSharePercent().getDenominator());

                GrandPaAndGrandMaUtils.calculateGrandPaAndGrandMa(mPeople, oConstants);

                BrothersUtils.calculateBrothers(mPeople, oConstants);
//                Log.i(TAG, "validatePeople(): moreThanThreeDaughters Count = " + OConstants.getPersonCount(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS) + " sharePercent = " + OConstants.getPerson(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS).getSharePercent().getNumerator() + "/" + OConstants.getPerson(mPeople, OConstants.PERSON_More_Than_three_DAUGHTERS).getSharePercent().getDenominator());

                UnclesAndAuntsUtils.calculate(mPeople, oConstants);


                validateBlockedPeople();

                setExplanationPhase1();

                OConstants.calculateShareValue(mPeople, oConstants);

                OConstants.handleMoreThanBrotherAndSisterResult(mPeople, oConstants);
                OConstants.handleMoreThanSonAndDaughterResult(mPeople, oConstants);
                OConstants.handleFatherUncleAndAuntsResult(mPeople);
                OConstants.handleMotherUncleAndAuntsResult(mPeople);
                OConstants.handleWivesResult(mPeople);

                setExplanationPhase4(mPeople, oConstants);

                mProgressDlg.dismiss();

                Log.i(TAG, "handleSolveProblem(): calculations are done");

                showResult(mPeople);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setExplanationPhase4(ArrayList<Person> mPeople, OConstants oConstants) {
        try {

            ExplainPhase4 phase4 = new ExplainPhase4();

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

            phase4.setPeople(data);
            oConstants.getmExplanation().setPhase4(phase4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setExplanationPhase1() {
        try {

            ExplainPhase1 mExplainPhase1 = new ExplainPhase1();
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

            mExplainPhase1.setPeople(data);
            oConstants.getmExplanation().setPhase1(mExplainPhase1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void validateBlockedPeople() {
        try {

            if (OConstants.getPersonCount(mPeople, OConstants.PERSON_BROTHER) == 1) {
                OConstants.blockPerson(mPeople, OConstants.PERSON_FATHER_UNCLE, OConstants.PERSON_BROTHER);
                OConstants.blockPerson(mPeople, OConstants.PERSON_FATHER_AUNT, OConstants.PERSON_BROTHER);
                OConstants.blockPerson(mPeople, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS, OConstants.PERSON_BROTHER);

                OConstants.blockPerson(mPeople, OConstants.PERSON_MOTHER_UNCLE, OConstants.PERSON_BROTHER);
                OConstants.blockPerson(mPeople, OConstants.PERSON_MOTHER_AUNT, OConstants.PERSON_BROTHER);
                OConstants.blockPerson(mPeople, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS, OConstants.PERSON_BROTHER);
            }

            if (oConstants.isHasWife() || oConstants.isHasHusband()) {
                if (oConstants.isHasWife()) {
                    OConstants.blockPerson(mPeople, OConstants.PERSON_FATHER_UNCLE, OConstants.PERSON_WIFE);
                    OConstants.blockPerson(mPeople, OConstants.PERSON_FATHER_AUNT, OConstants.PERSON_WIFE);
                    OConstants.blockPerson(mPeople, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS, OConstants.PERSON_WIFE);

                    OConstants.blockPerson(mPeople, OConstants.PERSON_MOTHER_UNCLE, OConstants.PERSON_WIFE);
                    OConstants.blockPerson(mPeople, OConstants.PERSON_MOTHER_AUNT, OConstants.PERSON_WIFE);
                    OConstants.blockPerson(mPeople, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS, OConstants.PERSON_WIFE);
                } else if (oConstants.isHasHusband()) {
                    OConstants.blockPerson(mPeople, OConstants.PERSON_FATHER_UNCLE, OConstants.PERSON_HUSBAND);
                    OConstants.blockPerson(mPeople, OConstants.PERSON_FATHER_AUNT, OConstants.PERSON_HUSBAND);
                    OConstants.blockPerson(mPeople, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS, OConstants.PERSON_HUSBAND);

                    OConstants.blockPerson(mPeople, OConstants.PERSON_MOTHER_UNCLE, OConstants.PERSON_HUSBAND);
                    OConstants.blockPerson(mPeople, OConstants.PERSON_MOTHER_AUNT, OConstants.PERSON_HUSBAND);
                    OConstants.blockPerson(mPeople, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS, OConstants.PERSON_HUSBAND);
                }
            }

            if (OConstants.getPerson(mPeople, OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER) != null) {

                OConstants.blockPerson(mPeople, OConstants.PERSON_FATHER_UNCLE, OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER);
                OConstants.blockPerson(mPeople, OConstants.PERSON_FATHER_AUNT, OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER);
                OConstants.blockPerson(mPeople, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS, OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER);

                OConstants.blockPerson(mPeople, OConstants.PERSON_MOTHER_UNCLE, OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER);
                OConstants.blockPerson(mPeople, OConstants.PERSON_MOTHER_AUNT, OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER);
                OConstants.blockPerson(mPeople, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS, OConstants.PERSON_MORE_THAN_THREE_BROTHER_AND_SISTER);
            }

            if (OConstants.getPerson(mPeople, OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER) != null) {

                OConstants.blockPerson(mPeople, OConstants.PERSON_FATHER_UNCLE, OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER);
                OConstants.blockPerson(mPeople, OConstants.PERSON_FATHER_AUNT, OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER);
                OConstants.blockPerson(mPeople, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS, OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER);

                OConstants.blockPerson(mPeople, OConstants.PERSON_MOTHER_UNCLE, OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER);
                OConstants.blockPerson(mPeople, OConstants.PERSON_MOTHER_AUNT, OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER);
                OConstants.blockPerson(mPeople, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS, OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER);
            }
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
            Intent intent = new Intent(mCurrent, ResultActivity.class);
            intent.putParcelableArrayListExtra(getString(R.string.intent_data_lbl), mPeople);
            intent.putExtra(getString(R.string.intent_total_money), oConstants.getTotalMoney());
            intent.putExtra(getString(R.string.explain_problem_result), oConstants.getmExplanation());
            intent.putExtra(getString(R.string.constants), oConstants);
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

    private void resetViews() {
        try {
            mTotalMoneyET.setText("");
            mWifeValueET.setText("");
            mAliveSonValueTV.setText("");
            mAliveDaughterValueTV.setText("");

//            mDeadSonValueET.setText("");
//            mDeadDaughterValueET.setText("");

            mBrothersValueTV.setText("");
            mSistersValueTV.setText("");
            mMotherUnclesValueTV.setText("");
            mMotherAuntsValueTV.setText("");
            mFatherUnclesValueTV.setText("");
            mFatherAuntsValueTV.setText("");

            mFatherRadioGroup.clearCheck();
            mFatherGrandPaContainer.setVisibility(View.GONE);
            mFatherGrandMaContainer.setVisibility(View.GONE);
            mFatherGrandpaRadioGroup.clearCheck();
            mMotherGrandpaRadioGroup.clearCheck();

            mMotherRadioGroup.clearCheck();
            mMotherGrandPaContainer.setVisibility(View.GONE);
            mMotherGrandMaContainer.setVisibility(View.GONE);
            mMotherGrandmaRadioGroup.clearCheck();
            mFatherGrandmaRadioGroup.clearCheck();

            mGenderRadioGroup.clearCheck();

            mMaleRB.setChecked(true);
            mFemaleRB.setChecked(false);

            mHusbandRadioGroup.clearCheck();
            mHusbandContainer.setVisibility(View.GONE);
            mWifeValueET.setText("");

            handleDeadGenderMale();

            mPeople.clear();
            oConstants = new OConstants(mCurrent);
            oConstants.setGender(OConstants.GENDER_MALE);
            oConstants.isHandleChildrenGroup = false;
            oConstants.isHandleWivesGroup = false;
            oConstants.isHandleUnclesGroup = false;
            oConstants.isHandleBrothersGroup = false;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleDeadGenderMale() {
        try {
            oConstants.setGender(OConstants.GENDER_MALE);

            mWifeValueET.setText("");
            mWivesContainer.setVisibility(View.VISIBLE);
            mHusbandContainer.setVisibility(View.GONE);
//            mHusbandRadioGroup.clearCheck();

//            mDeadGenderMale.setBackgroundColor(getResources().getColor(R.color.browLight));
//            mDeadGenderFemale.setBackground(getResources().getDrawable(R.drawable.custom_white_rect_with_brown_borders));

            resetAlivePerson(OConstants.PERSON_HUSBAND);
            resetAlivePerson(OConstants.PERSON_WIFE);

            setHasOptions(OConstants.PERSON_HUSBAND, false);
            setHasOptions(OConstants.PERSON_WIFE, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleDeadGenderFemale() {
        try {

            oConstants.setGender(OConstants.GENDER_FEMALE);
            mWifeValueET.setText("");
            mWivesContainer.setVisibility(View.GONE);
            mHusbandContainer.setVisibility(View.VISIBLE);
//            mHusbandRadioGroup.clearCheck();

            resetAlivePerson(OConstants.PERSON_WIFE);
            resetAlivePerson(OConstants.PERSON_HUSBAND);

            setHasOptions(OConstants.PERSON_HUSBAND, false);
            setHasOptions(OConstants.PERSON_WIFE, false);

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

    @Override
    public void onCheckedChanged(CompoundButton radioButton, boolean b) {
        try {
            Log.i(TAG, "onCheckedChanged(): is called");
            Log.i(TAG, "onCheckedChanged(): checked radioButton = " + radioButton.getText().toString());

            if (radioButton.equals(mMaleRB)) {//Male Gender
                if (mMaleRB.isChecked()) {
                    Log.i(TAG, "onCheckedChanged(): mMaleRB is checked");
                    handleDeadGenderMale();
                }
            } else if (radioButton.equals(mFemaleRB)) {//Female Gender
                if (mFemaleRB.isChecked()) {
                    Log.i(TAG, "onCheckedChanged(): mFemaleRB is checked");
                    handleDeadGenderFemale();
                }

            } else if (radioButton.equals(mHusbandYesRB)) {// Husband Yes
                if (mHusbandYesRB.isChecked()) {
                    Log.i(TAG, "onCheckedChanged(): mHusbandYesRB is checked");
                    handleHusbandChecked();
                }

            } else if (radioButton.equals(mHusbandNoRB)) {//Husband No
                if (mHusbandNoRB.isChecked()) {
                    Log.i(TAG, "onCheckedChanged(): mHusbandNoRB is checked");
                    resetAlivePerson(OConstants.PERSON_HUSBAND);
                    setHasOptions(OConstants.PERSON_HUSBAND, false);
                }
            } else if (radioButton.equals(mFatherYesRB)) {//Father Yes
                if (mFatherYesRB.isChecked()) {
                    Log.i(TAG, "onCheckedChanged(): mFatherYesRB is checked");
                    handleFatherChecked();
                }
            } else if (radioButton.equals(mFatherNoRB)) {//Father No
                if (mFatherNoRB.isChecked()) {
                    Log.i(TAG, "onCheckedChanged(): mFatherNoRB is checked");
                    handleDeadFather();
                }
            } else if (radioButton.equals(mMotherYesRB)) {//Mother Yes
                if (mMotherYesRB.isChecked()) {
                    Log.i(TAG, "onCheckedChanged(): mMotherYesRB is checked");
                    handleMotherChecked();
                }
            } else if (radioButton.equals(mMotherNoRB)) {//Mother No
                if (mMotherNoRB.isChecked()) {
                    Log.i(TAG, "onCheckedChanged(): mMotherNoRB is checked");
                    handleDeadMother();
                }
            } else if (radioButton.equals(mFatherGrandpaYesRB)) {//Father Grandpa Yes
                if (mFatherGrandpaYesRB.isChecked()) {
                    Log.i(TAG, "onCheckedChanged(): mFatherGrandpaYesRB is checked");
                    handleGrandMaAndGrandPa(true, OConstants.PERSON_FATHER_GRANDMOTHER, OConstants.GENDER_FEMALE);
                }
            } else if (radioButton.equals(mFatherGrandpaNoRB)) {//Father Grandpa No
                if (mFatherGrandpaNoRB.isChecked()) {
                    Log.i(TAG, "onCheckedChanged(): mFatherGrandpaNoRB is checked");
                    handleGrandMaAndGrandPa(false, OConstants.PERSON_FATHER_GRANDMOTHER, OConstants.GENDER_FEMALE);
                }
            } else if (radioButton.equals(mFatherGrandmaYesRB)) {//Father Grandma Yes
                if (mFatherGrandmaYesRB.isChecked()) {
                    Log.i(TAG, "onCheckedChanged(): mFatherGrandmaYesRB is checked");
                    handleGrandMaAndGrandPa(true, OConstants.PERSON_FATHER_GRANDFATHER, OConstants.GENDER_MALE);
                }
            } else if (radioButton.equals(mFatherGrandmaNoRB)) {//Father Grandma No
                if (mFatherGrandmaNoRB.isChecked()) {
                    Log.i(TAG, "onCheckedChanged(): mFatherGrandmaNoRB is checked");
                    handleGrandMaAndGrandPa(false, OConstants.PERSON_FATHER_GRANDFATHER, OConstants.GENDER_MALE);
                }
            } else if (radioButton.equals(mMotherGrandmaYesRB)) {//Mother Grandma Yes
                if (mMotherGrandmaYesRB.isChecked()) {
                    Log.i(TAG, "onCheckedChanged(): mMotherGrandmaYesRB is checked");
                    handleGrandMaAndGrandPa(true, OConstants.PERSON_MOTHER_GRANDMOTHER, OConstants.GENDER_FEMALE);
                }
            } else if (radioButton.equals(mMotherGrandmaNoRB)) {//Mother Grandma No
                if (mMotherGrandmaNoRB.isChecked()) {
                    Log.i(TAG, "onCheckedChanged(): mMotherGrandmaNoRB is checked");
                    handleGrandMaAndGrandPa(false, OConstants.PERSON_MOTHER_GRANDMOTHER, OConstants.GENDER_FEMALE);
                }
            } else if (radioButton.equals(mMotherGrandpaYesRB)) {//Mother Grandpa Yes
                if (mMotherGrandpaYesRB.isChecked()) {
                    Log.i(TAG, "onCheckedChanged(): mMotherGrandpaYesRB is checked");
                    handleGrandMaAndGrandPa(true, OConstants.PERSON_MOTHER_GRANDFATHER, OConstants.GENDER_MALE);
                }
            } else if (radioButton.equals(mMotherGrandpaNoRB)) {//Mother Grandpa No
                if (mMotherGrandpaNoRB.isChecked()) {
                    Log.i(TAG, "onCheckedChanged(): mMotherGrandpaYesRB is checked");
                    handleGrandMaAndGrandPa(false, OConstants.PERSON_MOTHER_GRANDFATHER, OConstants.GENDER_MALE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleGrandMaAndGrandPa(boolean alive, String relation, String gender) {

        resetAlivePerson(relation);
        setHasOptions(relation, alive);

        if (alive) {
            createAlivePerson(1, relation, gender, alive, false);
        }


    }

    private void handleDeadFather() {
        try {
            resetAlivePerson(OConstants.PERSON_FATHER);
            setHasOptions(OConstants.PERSON_FATHER, false);

            if (mFatherGrandMaContainer.getVisibility() == View.GONE) {
                mFatherGrandMaContainer.setVisibility(View.VISIBLE);
            }
            if (mFatherGrandPaContainer.getVisibility() == View.GONE) {
                mFatherGrandPaContainer.setVisibility(View.VISIBLE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleDeadMother() {
        try {
            resetAlivePerson(OConstants.PERSON_MOTHER);
            setHasOptions(OConstants.PERSON_MOTHER, false);
            if (mMotherGrandMaContainer.getVisibility() == View.GONE) {
                mMotherGrandMaContainer.setVisibility(View.VISIBLE);
            }
            if (mMotherGrandPaContainer.getVisibility() == View.GONE) {
                mMotherGrandPaContainer.setVisibility(View.VISIBLE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleMotherChecked() {
        try {
            resetAlivePerson(OConstants.PERSON_MOTHER);
            createAlivePerson(1, OConstants.PERSON_MOTHER, OConstants.GENDER_FEMALE, true, false);
            setHasOptions(OConstants.PERSON_MOTHER, true);

            if (mMotherGrandMaContainer.getVisibility() == View.VISIBLE) {
                mMotherGrandMaContainer.setVisibility(View.GONE);
            }
            if (mMotherGrandPaContainer.getVisibility() == View.VISIBLE) {
                mMotherGrandPaContainer.setVisibility(View.GONE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleFatherChecked() {
        try {
            resetAlivePerson(OConstants.PERSON_FATHER);
            createAlivePerson(1, OConstants.PERSON_FATHER, OConstants.GENDER_MALE, true, false);
            setHasOptions(OConstants.PERSON_FATHER, true);

            if (mFatherGrandMaContainer.getVisibility() == View.VISIBLE) {
                mFatherGrandMaContainer.setVisibility(View.GONE);
            }
            if (mFatherGrandPaContainer.getVisibility() == View.VISIBLE) {
                mFatherGrandPaContainer.setVisibility(View.GONE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleHusbandChecked() {
        try {
            Log.i(TAG, "handleHusbandChecked(): is called");

            setHasOptions(OConstants.PERSON_HUSBAND, true);

            resetAlivePerson(OConstants.PERSON_HUSBAND);
            resetAlivePerson(OConstants.PERSON_WIFE);
            resetAlivePerson(OConstants.PERSON_WIVES);
            resetAlivePerson(OConstants.PERSON_MORE_THAN_WIFE);

            createAlivePerson(1, OConstants.PERSON_HUSBAND, OConstants.GENDER_MALE, true, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleWifeChecked(int count) {
        try {
            Log.i(TAG, "handleWifeChecked(): is called");
            Log.i(TAG, "handleWifeChecked(): count = " + count);

            resetAlivePerson(OConstants.PERSON_HUSBAND);
            resetAlivePerson(OConstants.PERSON_WIFE);
            resetAlivePerson(OConstants.PERSON_WIVES);
            resetAlivePerson(OConstants.PERSON_MORE_THAN_WIFE);

            if (count > 0) {
                setHasOptions(OConstants.PERSON_WIFE, true);
                createAlivePerson(count, OConstants.PERSON_WIFE, OConstants.GENDER_FEMALE, true, false);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createAlivePerson(int size, String relation, String gender, boolean isAlive, boolean group) {
        try {
            ArrayList<Person> people = new ArrayList<>();

            for (int number = 0; number < size; number++) {

                Person person = new Person();
                person.setAlive(isAlive);
                person.setCount(size);
                person.setRelation(relation);
                person.setGender(gender);
                person.setDeadSonNumber(-1);
                person.setGroup(group);
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

}
