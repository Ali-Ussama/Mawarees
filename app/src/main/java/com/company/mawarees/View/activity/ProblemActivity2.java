package com.company.mawarees.View.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.company.mawarees.Model.Callback.DeadPersonListener;
import com.company.mawarees.Model.Callback.MainProcessCallback;
import com.company.mawarees.Model.Models.DeadPersonModel;
import com.company.mawarees.Model.Models.ExplainPhase1;
import com.company.mawarees.Model.Models.ExplainPhase4;
import com.company.mawarees.Model.Models.Fraction;
import com.company.mawarees.Model.Models.GrandChildren;
import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;
import com.company.mawarees.Model.Utilities.AppUtils;
import com.company.mawarees.Model.Utilities.BrothersUtils;
import com.company.mawarees.Model.Utilities.ChildrenUtils;
import com.company.mawarees.Model.Utilities.FatherUtils2;
import com.company.mawarees.Model.Utilities.GrandPaAndGrandMaUtils;
import com.company.mawarees.Model.Utilities.HusbandAndWifeUtils;
import com.company.mawarees.Model.Utilities.InputFilterMinMax;
import com.company.mawarees.Model.Utilities.MotherUtils2;
import com.company.mawarees.Model.Utilities.UnclesAndAuntsUtils;
import com.company.mawarees.PrefManager;
import com.company.mawarees.R;
import com.company.mawarees.View.adpters.DeadDaughterRVAdapter;
import com.company.mawarees.View.adpters.DeadSonRVAdapter;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProblemActivity2 extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, DeadPersonListener, MainProcessCallback {

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

    //dead Son
    @BindView(R.id.problem_activity_dead_son_et_value)
    TextInputEditText mDeadSonValueET;

    //dead Daughter
    @BindView(R.id.problem_activity_dead_daughter_et_value)
    TextInputEditText mDeadDaughterValueET;

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

    //Brothers Question
    @BindView(R.id.problem_activity_brothers_question_layout)
    ConstraintLayout mBrotherQuestionContainer;

    @BindView(R.id.brothers_question_layout_radio_group)
    RadioGroup mBrotherQuestionRadioGroup;

    @BindView(R.id.brothers_question_rb_yes)
    RadioButton mBrotherQuestionYesRB;

    @BindView(R.id.brothers_question_rb_no)
    RadioButton mBrotherQuestionNoRB;

    //Brothers
    @BindView(R.id.problem_activity_brother_container)
    ConstraintLayout mBrothersContainer;

    @BindView(R.id.problem_activity_brother_et_value)
    TextInputEditText mBrothersValueTV;

    //Sisters
    @BindView(R.id.problem_activity_sister_container)
    ConstraintLayout mSistersContainer;

    @BindView(R.id.problem_activity_sister_et_value)
    TextInputEditText mSistersValueTV;

    //Father Uncle
    @BindView(R.id.problem_activity_father_uncle_container)
    ConstraintLayout mFatherUnclesContainer;

    @BindView(R.id.problem_activity_father_uncle_et_value)
    EditText mFatherUnclesValueTV;

    //Father Aunt
    @BindView(R.id.problem_activity_father_aunt_container)
    ConstraintLayout mFatherAuntsContainer;

    @BindView(R.id.problem_activity_father_aunt_et_value)
    EditText mFatherAuntsValueTV;

    //Mother Uncle
    @BindView(R.id.problem_activity_mother_uncle_container)
    ConstraintLayout mMotherUnclesContainer;

    @BindView(R.id.problem_activity_mother_uncle_et_value)
    EditText mMotherUnclesValueTV;

    //Mother Aunt
    @BindView(R.id.problem_activity_mother_aunt_container)
    ConstraintLayout mMotherAuntsContainer;

    @BindView(R.id.problem_activity_mother_aunt_et_value)
    EditText mMotherAuntsValueTV;

    ProblemActivity2 mCurrent;
    public ArrayList<Person> mPeople;
    public ArrayList<GrandChildren> mGrandChildren;

    public OConstants oConstants;

    private Toolbar mToolbar;
    MaterialDialog mProgressDlg;

    MainProcessCallback mainProcessCallback;

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
            mGrandChildren = new ArrayList<>();
            oConstants = new OConstants(mCurrent);
            mainProcessCallback = mCurrent;

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

            mBrotherQuestionYesRB.setOnCheckedChangeListener(this);
            mBrotherQuestionNoRB.setOnCheckedChangeListener(this);

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
            mWifeValueET.setFilters(new InputFilter[]{new InputFilterMinMax(1, 4)});

            //Alive son
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

                            createAlivePerson(value, OConstants.PERSON_SON, OConstants.GENDER_MALE, true, false, OConstants.SON_ID);

                            if (OConstants.getChildrenInDaughters(mPeople) > 2) {
                                createAlivePerson(1, OConstants.PERSON_More_Than_three_DAUGHTERS, OConstants.GENDER_MALE, true, true, OConstants.Children_ID);
                            }
                        }
                        if (OConstants.getChildrenInDaughters(mPeople) < 1) {
                            show(mBrotherQuestionContainer);

                        } else {
                            mBrotherQuestionRadioGroup.clearCheck();
                            hide(mBrotherQuestionContainer);
                            hide(mBrothersContainer);
                            hide(mSistersContainer);
                            hide(mFatherUnclesContainer);
                            hide(mFatherAuntsContainer);
                            hide(mMotherUnclesContainer);
                            hide(mMotherAuntsContainer);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

            //Alive daughter
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
                        createAlivePerson(value, OConstants.PERSON_DAUGHTER, OConstants.GENDER_FEMALE, true, false, OConstants.DAUGHTER_ID);

                        if (OConstants.getChildrenInDaughters(mPeople) > 2) {
                            createAlivePerson(1, OConstants.PERSON_More_Than_three_DAUGHTERS, OConstants.GENDER_MALE, true, true, OConstants.Children_ID);
                        }
                    }

                    if (OConstants.getChildrenInDaughters(mPeople) < 1) {
                        show(mBrotherQuestionContainer);
                    } else {
                        mBrotherQuestionRadioGroup.clearCheck();
                        hide(mBrotherQuestionContainer);
                        hide(mBrothersContainer);
                        hide(mSistersContainer);
                        hide(mFatherUnclesContainer);
                        hide(mFatherAuntsContainer);
                        hide(mMotherUnclesContainer);
                        hide(mMotherAuntsContainer);
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

            //dead son
            mDeadSonValueET.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    try {

                        resetDeadSonsOrDaughter(OConstants.PERSON_SON);
                        resetDeadSonsOrDaughterBoyAndGirl(OConstants.PERSON_SON_CHILDREN);

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

            //dead daughter
            mDeadDaughterValueET.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    try {
                        resetDeadSonsOrDaughter(OConstants.PERSON_DAUGHTER);
                        resetDeadSonsOrDaughterBoyAndGirl(OConstants.PERSON_DAUGHTER_CHILDREN);

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

            //Brother
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
                        createAlivePerson(value, OConstants.PERSON_BROTHER, OConstants.GENDER_MALE, true, false, OConstants.BROTHER_ID);

                        hide(mFatherUnclesContainer);
                        hide(mFatherAuntsContainer);
                        hide(mMotherUnclesContainer);
                        hide(mMotherAuntsContainer);
                    } else {
                        if (OConstants.getPersonCount(mPeople, OConstants.PERSON_SISTER) < 3 && (mBrotherQuestionNoRB.isChecked() || mBrotherQuestionYesRB.isChecked())) {
                            show(mFatherUnclesContainer);
                            show(mFatherAuntsContainer);
                            show(mMotherUnclesContainer);
                            show(mMotherAuntsContainer);
                        }
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

            //Sister
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
                            createAlivePerson(value, OConstants.PERSON_SISTER, OConstants.GENDER_FEMALE, true, false, OConstants.SISTER_ID);

                            Log.i(TAG, "SisterTextChanged(): count = " + value);

                            if (OConstants.getPersonCount(mPeople, OConstants.PERSON_BROTHER) < 1 && value < 3 && (mBrotherQuestionNoRB.isChecked() || mBrotherQuestionYesRB.isChecked())) {
                                show(mFatherUnclesContainer);
                                show(mFatherAuntsContainer);
                                show(mMotherUnclesContainer);
                                show(mMotherAuntsContainer);
                            } else {
                                hide(mFatherUnclesContainer);
                                hide(mFatherAuntsContainer);
                                hide(mMotherUnclesContainer);
                                hide(mMotherAuntsContainer);
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

            //Father Uncles
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
                            createAlivePerson(value, OConstants.PERSON_FATHER_UNCLE, OConstants.GENDER_MALE, true, false, OConstants.FATHER_UNCLE_ID);

//                            if (value + OConstants.getPersonCount(mPeople, OConstants.PERSON_FATHER_AUNT) > 1) {
//                                // if no father aunts created then create
//                                if (OConstants.getPersonCount(mPeople, OConstants.PERSON_FATHER_AUNT) < 1)
                            if (OConstants.getPerson(mPeople, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS) == null) {
                                createAlivePerson(1, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS, OConstants.GENDER_MALE, true, true, OConstants.FATHER_UNCLES_AND_AUNTS_ID);
                            }
//                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

            //Father Aunts
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
                            createAlivePerson(value, OConstants.PERSON_FATHER_AUNT, OConstants.GENDER_FEMALE, true, false, OConstants.FATHER_AUNT_ID);

//                            if (value + OConstants.getPersonCount(mPeople, OConstants.PERSON_FATHER_UNCLE) > 1) {
//
//                                // if no father uncles created then create
//                                if (OConstants.getPersonCount(mPeople, OConstants.PERSON_FATHER_UNCLE) < 1)
                            if (OConstants.getPerson(mPeople, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS) == null) {
                                createAlivePerson(1, OConstants.PERSON_FATHER_UNCLES_AND_AUNTS, OConstants.GENDER_MALE, true, true, OConstants.FATHER_UNCLES_AND_AUNTS_ID);
                            }
//                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

            //Mother Uncles
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
                            createAlivePerson(value, OConstants.PERSON_MOTHER_UNCLE, OConstants.GENDER_MALE, true, false, OConstants.MOTHER_UNCLE_ID);
//                            if (value + OConstants.getPersonCount(mPeople, OConstants.PERSON_MOTHER_AUNT) > 1) {
//
//                                // if no mother aunts created then create
//                                if (OConstants.getPersonCount(mPeople, OConstants.PERSON_MOTHER_AUNT) < 1)
                            if (OConstants.getPerson(mPeople, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS) == null) {
                                createAlivePerson(1, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS, OConstants.GENDER_MALE, true, true, OConstants.MOTHER_UNCLES_AND_AUNTS_ID);
                            }
//                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

            //Mother Aunts
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
                            createAlivePerson(value, OConstants.PERSON_MOTHER_AUNT, OConstants.GENDER_FEMALE, true, false, OConstants.MOTHER_AUNT_ID);
//                            if (value + OConstants.getPersonCount(mPeople, OConstants.PERSON_MOTHER_UNCLE) > 1) {
//
//                                // if no mother uncles created then create
//                                if (OConstants.getPersonCount(mPeople, OConstants.PERSON_MOTHER_UNCLE) < 1)
                            if (OConstants.getPerson(mPeople, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS) == null) {
                                createAlivePerson(1, OConstants.PERSON_MOTHER_UNCLES_AND_AUNTS, OConstants.GENDER_MALE, true, true, OConstants.MOTHER_UNCLES_AND_AUNTS_ID);
                            }
//                            }
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

    private void hide(View container) {
        if (container != null) {
            container.setVisibility(View.GONE);
        }
    }

    private void show(View container) {
        if (container != null) {
            container.setVisibility(View.VISIBLE);
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
            person.setAlive(true); //TODO Change it to false if needed
            person.setCount(size);
            person.setDeadChildNumber(number + 1);
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
    public void addChildListener(ArrayList<Person> children, String relation, int deadChildNumber, int id) {
        try {

            Log.i(TAG, "addChildListener(): is called");

            if (relation.matches(OConstants.PERSON_DAUGHTER_BOY) || relation.matches(OConstants.PERSON_DAUGHTER_GIRL)) {
                Person grandChildren = OConstants.getDeadSonChildrenGroup(mPeople, OConstants.PERSON_DAUGHTER_CHILDREN, deadChildNumber);

                if (grandChildren == null) {
                    Log.i(TAG, "addChildListener(): PERSON_DAUGHTER_CHILDREN not found");
                    if (relation.matches(OConstants.PERSON_DAUGHTER_BOY)) {
                        Log.i(TAG, "addChildListener(): Create new GrandChildren with DAUGHTER_BOY count = " + children.size());
                        createGrandChildrenGroup(children.size(), 0, OConstants.PERSON_DAUGHTER_CHILDREN, OConstants.GENDER_MALE, true, true, deadChildNumber, id, null, children);
                    } else {
                        Log.i(TAG, "addChildListener(): Create new GrandChildren with DAUGHTER_GIRL count = " + children.size());
                        createGrandChildrenGroup(0, children.size(), OConstants.PERSON_DAUGHTER_CHILDREN, OConstants.GENDER_MALE, true, true, deadChildNumber, id, children, null);
                    }
                } else {
                    Log.i(TAG, "addChildListener(): PERSON_DAUGHTER_CHILDREN founded");
                    if (relation.matches(OConstants.PERSON_DAUGHTER_BOY)) {
                        Log.i(TAG, "addChildListener(): updating GrandChildren with with DAUGHTER_BOY count = " + children.size());
                        updateGrandChildren(grandChildren, children.size(), 0);
                    } else {
                        Log.i(TAG, "addChildListener(): updating GrandChildren with DAUGHTER_GIRL count = " + children.size());
                        updateGrandChildren(grandChildren, 0, children.size());
                    }
                }
            } else if (relation.matches(OConstants.PERSON_SON_BOY) || relation.matches(OConstants.PERSON_SON_GIRL)) {
                Person grandChildren = OConstants.getDeadSonChildrenGroup(mPeople, OConstants.PERSON_SON_CHILDREN, deadChildNumber);

                if (grandChildren == null) {
                    Log.i(TAG, "addChildListener(): PERSON_SON_CHILDREN not found");
                    if (relation.matches(OConstants.PERSON_SON_BOY)) {
                        Log.i(TAG, "addChildListener(): Create new GrandChildren with SON_BOY count = " + children.size());
                        createGrandChildrenGroup(children.size(), 0, OConstants.PERSON_SON_CHILDREN, OConstants.GENDER_MALE, true, true, deadChildNumber, id, null, children);
                    } else {
                        Log.i(TAG, "addChildListener(): Create new GrandChildren with SON_GIRL count = " + children.size());
                        createGrandChildrenGroup(0, children.size(), OConstants.PERSON_SON_CHILDREN, OConstants.GENDER_MALE, true, true, deadChildNumber, id, children, null);
                    }
                } else {
                    Log.i(TAG, "addChildListener(): PERSON_SON_CHILDREN founded");
                    if (relation.matches(OConstants.PERSON_SON_BOY)) {
                        Log.i(TAG, "addChildListener(): updating GrandChildren with with SON_BOY count = " + children.size());
                        updateGrandChildren(grandChildren, children.size(), 0);
                    } else {
                        Log.i(TAG, "addChildListener(): updating GrandChildren with SON_GIRL count = " + children.size());
                        updateGrandChildren(grandChildren, 0, children.size());
                    }
                }
            }


//            }

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
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

                mProgressDlg = AppUtils.showProgressDialog(mCurrent, getString(R.string.solving_the_problem));

                double totalMoney = Double.parseDouble(mTotalMoneyET.getText().toString().trim());
                oConstants.setTotalMoney(totalMoney);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //                handleDeadManHasWifeOrNot();
                            handleHasPersonOrNot();

                            validatePeople();

                            validateDeadDaughterChildren();
                            validateDeadSonsChildren();

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

                            Collections.sort(mPeople);

                            validateBlockedPeople();

                            setExplanationPhase1();

                            OConstants.calculateShareValue(mPeople, oConstants);

                            Collections.sort(mPeople);

                            OConstants.handleMoreThanBrotherAndSisterResult(mPeople, oConstants);
                            OConstants.handleMoreThanSonAndDaughterResult(mPeople, oConstants);
                            OConstants.handleFatherUncleAndAuntsResult(mPeople);
                            OConstants.handleMotherUncleAndAuntsResult(mPeople);
                            OConstants.handleWivesResult(mPeople);

                            setExplanationPhase4(mPeople, oConstants);

                            mainProcessCallback.onCalculateSuccess();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

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
                person.setDeadChildNumber(deadSonNumber);
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
//            Collections.copy(data, mPeople);
            Log.i(TAG, "setExplainPhase4(): print phase 4");
//            showResult(data);

            phase4.setPeople(data);
            oConstants.getExplanation().setPhase4(phase4);
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
                person.setDeadChildNumber(deadSonNumber);
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
//            Collections.copy(data, mPeople);
            mExplainPhase1.setPeople(data);
            oConstants.getExplanation().setPhase1(mExplainPhase1);

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

        //Check if dead son
        // doesn't have children
        //then remove his object

        //Check if dead daughter
        // doesn't have children
        //then remove her object

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

    private void validateDeadSonsChildren() {
        try {
            Log.i(TAG, "validateDeadSonsChildren(): is called");
            int deadSonsCount = OConstants.getDeadSonsCount(mPeople);
            ArrayList<Person> sonsWhoDoNotHaveChildren = new ArrayList<>();
            int[] deadSonsMemoization = new int[deadSonsCount];

            Log.i(TAG, "validateDeadSonsChildren(): dead son count = " + deadSonsCount);

            for (int i = 0; i < deadSonsCount; i++) {

                Log.i(TAG, "validateDeadSonsChildren(): dead son number = " + (i + 1));
                for (Person person : mPeople) {
                    if ((person.getRelation().contains(OConstants.PERSON_SON_CHILDREN)) && person.getDeadSonNumber() == (i + 1)) {
                        Log.i(TAG, "validateDeadSonsChildren(): dead son number = " + (i + 1) + " has children");
                        deadSonsMemoization[i] = 1;
                    }
                }

                if (deadSonsMemoization[i] == 1) {
                    incrementDeadSonCount();
                    oConstants.setHasDeadChildren(true);
                }
            }

            for (int i = 0; i < deadSonsMemoization.length; i++) {
                if (deadSonsMemoization[i] == 0) {
                    Log.i(TAG, "validateDeadSonsChildren(): dead son number = " + (i + 1) + " hasn't children");
                    for (Person person : mPeople) {
                        if (person.getRelation().contains(OConstants.PERSON_SON) && person.getDeadSonNumber() == (i + 1)) {
                            sonsWhoDoNotHaveChildren.add(person);
                            break;
                        }
                    }
                }
            }

            for (Person sonsWhoDoNotHaveChild : sonsWhoDoNotHaveChildren) {
                mPeople.remove(sonsWhoDoNotHaveChild);
            }

            Log.i(TAG, "validateDeadSonsChildren(): people size = " + mPeople.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     **/
    private void validateDeadDaughterChildren() {
        try {
            int deadDaughtersCount = OConstants.getDeadDeadDaughtersCount(mPeople);
            ArrayList<Person> daughtersWhoDoNotHaveChildren = new ArrayList<>();

            int[] deadDaughtersMemoization = new int[deadDaughtersCount];

            Log.i(TAG, "validateDeadDaughterChildren(): dead daughter count = " + deadDaughtersCount);

            for (int i = 0; i < deadDaughtersCount; i++) {

                Log.i(TAG, "validateDeadDaughterChildren(): dead daughter number = " + (i + 1));
                for (Person person : mPeople) {
                    if ((person.getRelation().contains(OConstants.PERSON_DAUGHTER_CHILDREN)) && person.getDeadSonNumber() == (i + 1)) {
                        Log.i(TAG, "validateDeadDaughterChildren(): dead daughter number = " + (i + 1) + " has children");
                        deadDaughtersMemoization[i] = 1;
                    }
                }

                if (deadDaughtersMemoization[i] == 1) {
                    incrementDeadDaughterCount();
                    oConstants.setHasDeadChildren(true);
                }
            }

            for (int i = 0; i < deadDaughtersMemoization.length; i++) {
                if (deadDaughtersMemoization[i] == 0) {
                    for (Person person : mPeople) {
                        if (person.getRelation().contains(OConstants.PERSON_DAUGHTER) && person.getDeadSonNumber() == (i + 1)) {
                            Log.i(TAG, "validateDeadDaughterChildren(): dead daughter number = " + (i + 1) + " hasn't children");
                            daughtersWhoDoNotHaveChildren.add(person);
                            break;
                        }
                    }
                }
            }

            for (Person sonsWhoDoNotHaveChild : daughtersWhoDoNotHaveChildren) {
                mPeople.remove(sonsWhoDoNotHaveChild);
            }

            Log.i(TAG, "validateDeadDaughterChildren(): people size = " + mPeople.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void incrementDeadSonCount() {
        try {
            oConstants.setDeadSonCount(oConstants.getDeadSonCount() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void incrementDeadDaughterCount() {
        try {
            oConstants.setDeadDaughterCount(oConstants.getDeadDaughterCount() + 1);
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startResultActivity() {
        try {
            Log.i(TAG, "startResultActivity(): is Called");

            if (oConstants.getExplanation() == null) {
                Log.i(TAG, "startResultActivity(): Explanation == null");
            } else if (oConstants.getExplanation().getPhase2() == null) {
                Log.i(TAG, "startResultActivity(): phase 2 == null");
            } else if (oConstants.getExplanation().getPhase2().getPeople() == null) {
                Log.i(TAG, "startResultActivity(): phase 2 people  == null");
            }

            Collections.sort(mPeople);
            Intent intent = new Intent(mCurrent, ResultActivity.class);
            if (mPeople != null)
                intent.putParcelableArrayListExtra(getString(R.string.intent_data_lbl), mPeople);
            if (oConstants != null) {
                intent.putExtra(getString(R.string.intent_total_money), oConstants.getTotalMoney());
                intent.putExtra(getString(R.string.constants), oConstants);
            }
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
            mDeadSonValueET.setText("");
            mDeadDaughterValueET.setText("");

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
                    handleGrandMaAndGrandPa(true, OConstants.PERSON_FATHER_GRANDMOTHER, OConstants.GENDER_MALE, OConstants.FATHER_GRANDFATHER_GRANDMOTHER_ID);
                }
            } else if (radioButton.equals(mFatherGrandpaNoRB)) {//Father Grandpa No
                if (mFatherGrandpaNoRB.isChecked()) {
                    Log.i(TAG, "onCheckedChanged(): mFatherGrandpaNoRB is checked");
                    handleGrandMaAndGrandPa(false, OConstants.PERSON_FATHER_GRANDMOTHER, OConstants.GENDER_MALE, OConstants.FATHER_GRANDFATHER_GRANDMOTHER_ID);
                }
            } else if (radioButton.equals(mFatherGrandmaYesRB)) {//Father Grandma Yes
                if (mFatherGrandmaYesRB.isChecked()) {
                    Log.i(TAG, "onCheckedChanged(): mFatherGrandmaYesRB is checked");
                    handleGrandMaAndGrandPa(true, OConstants.PERSON_FATHER_GRANDFATHER, OConstants.GENDER_FEMALE, OConstants.FATHER_GRANDFATHER_GRANDMOTHER_ID);
                }
            } else if (radioButton.equals(mFatherGrandmaNoRB)) {//Father Grandma No
                if (mFatherGrandmaNoRB.isChecked()) {
                    Log.i(TAG, "onCheckedChanged(): mFatherGrandmaNoRB is checked");
                    handleGrandMaAndGrandPa(false, OConstants.PERSON_FATHER_GRANDFATHER, OConstants.GENDER_FEMALE, OConstants.FATHER_GRANDFATHER_GRANDMOTHER_ID);
                }
            } else if (radioButton.equals(mMotherGrandmaYesRB)) {//Mother Grandma Yes
                if (mMotherGrandmaYesRB.isChecked()) {
                    Log.i(TAG, "onCheckedChanged(): mMotherGrandmaYesRB is checked");
                    handleGrandMaAndGrandPa(true, OConstants.PERSON_MOTHER_GRANDMOTHER, OConstants.GENDER_FEMALE, OConstants.MOTHER_GRANDFATHER_GRANDMOTHER_ID);
                }
            } else if (radioButton.equals(mMotherGrandmaNoRB)) {//Mother Grandma No
                if (mMotherGrandmaNoRB.isChecked()) {
                    Log.i(TAG, "onCheckedChanged(): mMotherGrandmaNoRB is checked");
                    handleGrandMaAndGrandPa(false, OConstants.PERSON_MOTHER_GRANDMOTHER, OConstants.GENDER_FEMALE, OConstants.MOTHER_GRANDFATHER_GRANDMOTHER_ID);
                }
            } else if (radioButton.equals(mMotherGrandpaYesRB)) {//Mother Grandpa Yes
                if (mMotherGrandpaYesRB.isChecked()) {
                    Log.i(TAG, "onCheckedChanged(): mMotherGrandpaYesRB is checked");
                    handleGrandMaAndGrandPa(true, OConstants.PERSON_MOTHER_GRANDFATHER, OConstants.GENDER_MALE, OConstants.MOTHER_GRANDFATHER_GRANDMOTHER_ID);
                }
            } else if (radioButton.equals(mMotherGrandpaNoRB)) {//Mother Grandpa No
                if (mMotherGrandpaNoRB.isChecked()) {
                    Log.i(TAG, "onCheckedChanged(): mMotherGrandpaYesRB is checked");
                    handleGrandMaAndGrandPa(false, OConstants.PERSON_MOTHER_GRANDFATHER, OConstants.GENDER_MALE, OConstants.MOTHER_GRANDFATHER_GRANDMOTHER_ID);
                }
            } else if (radioButton.equals(mBrotherQuestionYesRB)) {
                if (mBrotherQuestionYesRB.isChecked()) {
                    Log.i(TAG, "onCheckedChanged(): mBrotherQuestionYesRB is checked");
                    handleBrothersChecked(true);
                }
            } else if (radioButton.equals(mBrotherQuestionNoRB)) {
                if (mBrotherQuestionNoRB.isChecked()) {
                    Log.i(TAG, "onCheckedChanged(): mBrotherQuestionNoRB is checked");
                    handleBrothersChecked(false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleBrothersChecked(boolean status) {
        try {
            if (status) {
                mBrothersContainer.setVisibility(View.VISIBLE);
                mSistersContainer.setVisibility(View.VISIBLE);
                mFatherUnclesContainer.setVisibility(View.GONE);
                mFatherAuntsContainer.setVisibility(View.GONE);
                mMotherUnclesContainer.setVisibility(View.GONE);
                mMotherAuntsContainer.setVisibility(View.GONE);
            } else {
                mBrothersContainer.setVisibility(View.GONE);
                mSistersContainer.setVisibility(View.GONE);
                mFatherUnclesContainer.setVisibility(View.VISIBLE);
                mFatherAuntsContainer.setVisibility(View.VISIBLE);
                mMotherUnclesContainer.setVisibility(View.VISIBLE);
                mMotherAuntsContainer.setVisibility(View.VISIBLE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleGrandMaAndGrandPa(boolean alive, String relation, String gender, int id) {

        resetAlivePerson(relation);
        setHasOptions(relation, alive);

        if (alive) {
            createAlivePerson(1, relation, gender, alive, false, id);
        }
    }

    private void handleDeadFather() {
        try {
            resetAlivePerson(OConstants.PERSON_FATHER);
            setHasOptions(OConstants.PERSON_FATHER, false);

            if (mFatherGrandMaContainer.getVisibility() == View.GONE) {
                show(mFatherGrandMaContainer);
            }
            if (mFatherGrandPaContainer.getVisibility() == View.GONE) {
                show(mFatherGrandPaContainer);
            }

            if (!oConstants.isHasMother()) {
                show(mBrotherQuestionContainer);
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
                show(mMotherGrandMaContainer);
            }
            if (mMotherGrandPaContainer.getVisibility() == View.GONE) {
                show(mMotherGrandPaContainer);
            }

            if (!oConstants.isHasFather()) {
                show(mBrotherQuestionContainer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleMotherChecked() {
        try {
            resetAlivePerson(OConstants.PERSON_MOTHER);
            createAlivePerson(1, OConstants.PERSON_MOTHER, OConstants.GENDER_FEMALE, true, false, OConstants.MOTHER_ID);
            setHasOptions(OConstants.PERSON_MOTHER, true);

            if (mMotherGrandMaContainer.getVisibility() == View.VISIBLE) {
                hide(mMotherGrandMaContainer);
            }
            if (mMotherGrandPaContainer.getVisibility() == View.VISIBLE) {
                hide(mMotherGrandPaContainer);
            }
            mBrotherQuestionRadioGroup.clearCheck();
            hide(mBrotherQuestionContainer);
            hide(mBrothersContainer);
            hide(mSistersContainer);
            hide(mFatherUnclesContainer);
            hide(mFatherAuntsContainer);
            hide(mMotherUnclesContainer);
            hide(mMotherAuntsContainer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleFatherChecked() {
        try {
            resetAlivePerson(OConstants.PERSON_FATHER);
            createAlivePerson(1, OConstants.PERSON_FATHER, OConstants.GENDER_MALE, true, false, OConstants.FATHER_ID);
            setHasOptions(OConstants.PERSON_FATHER, true);

            if (mFatherGrandMaContainer.getVisibility() == View.VISIBLE) {
                hide(mFatherGrandMaContainer);
            }
            if (mFatherGrandPaContainer.getVisibility() == View.VISIBLE) {
                hide(mFatherGrandPaContainer);
            }

            mBrotherQuestionRadioGroup.clearCheck();
            hide(mBrotherQuestionContainer);
            hide(mBrothersContainer);
            hide(mSistersContainer);
            hide(mFatherUnclesContainer);
            hide(mFatherAuntsContainer);
            hide(mMotherUnclesContainer);
            hide(mMotherAuntsContainer);
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

            createAlivePerson(1, OConstants.PERSON_HUSBAND, OConstants.GENDER_MALE, true, false, OConstants.HUSBAND_ID);

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
                createAlivePerson(count, OConstants.PERSON_WIFE, OConstants.GENDER_FEMALE, true, false, OConstants.WIFE_ID);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createAlivePerson(int size, String relation, String gender, boolean isAlive,
                                   boolean group, int id) {
        try {
            ArrayList<Person> people = new ArrayList<>();

            for (int number = 0; number < size; number++) {

                Person person = new Person();
                person.setAlive(isAlive);
                person.setCount(size);
                person.setRelation(relation);
                person.setGender(gender);
                person.setDeadChildNumber(-1);
                person.setGroup(group);
                person.setId(id);
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

    private void createGrandChildrenGroup(int boysCount, int girlsCount, String relation, String gender, boolean isAlive, boolean group, int deadChildNumber, int id, ArrayList<Person> girlObject, ArrayList<Person> boyObject) {
        try {
            Log.i(TAG, "createGrandChildrenGroup(): is called");
            ArrayList<Person> grandChildren = new ArrayList<>();

            Person person = new Person();
            person.setAlive(isAlive);
            person.setCount(boysCount + girlsCount);
            person.setRelation(relation);
            person.setGender(gender);
            person.setGroup(group);
            person.setId(id);
            person.setDeadChildNumber(deadChildNumber);
            person.setBoysCount(boysCount);
            person.setGirlsCount(girlsCount);

//            if (girlObject != null) {
//                grandChildren.addAll(girlObject);
//            } else if (boyObject != null) {
//                grandChildren.addAll(boyObject);
//            }
            person.setGrandChildren(grandChildren);
            mPeople.add(person);

            Log.i(TAG, "createGrandChildrenGroup() person relation = " + relation + " & Alive = " + isAlive + " & dead Child No = " + deadChildNumber + " created");
            Log.i(TAG, "createGrandChildrenGroup() dead child boysCount = " + boysCount);
            Log.i(TAG, "createGrandChildrenGroup() dead child girlsCount = " + girlsCount);
            Log.i(TAG, "createGrandChildrenGroup() people size = " + mPeople.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateGrandChildren(Person grandChildren, int boysCount, int girlsCount) {
        try {
            Log.i(TAG, "updateGrandChildren(): is called");
            if (girlsCount > 0) {
                grandChildren.setGirlsCount(girlsCount);
            } else {
                grandChildren.setBoysCount(boysCount);
            }
            Log.i(TAG, "updateGrandChildren(): grandChildren is updated");
            Log.i(TAG, "updateGrandChildren() people size = " + mPeople.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCalculateSuccess() {
        try {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log.i(TAG, "handleSolveProblem(): calculations are done");
                        if (mProgressDlg != null) {
                            mProgressDlg.dismiss();
                        }
                        startResultActivity();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}