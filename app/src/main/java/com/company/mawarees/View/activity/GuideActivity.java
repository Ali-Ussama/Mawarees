package com.company.mawarees.View.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;

import com.company.mawarees.PrefManager;
import com.company.mawarees.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;
import uk.co.deanwild.materialshowcaseview.shape.RectangleShape;

public class GuideActivity extends AppCompatActivity {

    private static final String TAG = "GuideActivity";


    @BindView(R.id.instruction_activity_how_much_money_layout)
    TextInputLayout mTotalMoneyContainer;

    @BindView(R.id.instruction_activity_how_much_money_et_value)
    TextInputEditText mTotalMoneyET;

    @BindView(R.id.gender_container)
    ConstraintLayout mGenderContainer;

    @BindView(R.id.activity_instruction_gender_layout)
    RadioGroup mGenderRadioGroup;

    @BindView(R.id.activity_instruction_gender_female_radio_button)
    RadioButton mFemaleRB;

    @BindView(R.id.activity_instruction_gender_male_radio_button)
    RadioButton mMaleRB;

    @BindView(R.id.instruction_activity_solve_button_2)
    Button mSolveProblemBtn;

    //Wife
    @BindView(R.id.instruction_activity_wife_container)
    ConstraintLayout mWivesContainer;

    @BindView(R.id.instruction_activity_wife_et_value)
    TextInputEditText mWifeValueET;

    //Husband
    @BindView(R.id.instruction_activity_husband_layout)
    ConstraintLayout mHusbandContainer;

    @BindView(R.id.husband_layout_radio_group)
    RadioGroup mHusbandRadioGroup;

    @BindView(R.id.husband_rb_yes)
    RadioButton mHusbandYesRB;

    @BindView(R.id.husband_rb_no)
    RadioButton mHusbandNoRB;

    //Alive Son
    @BindView(R.id.instruction_activity_alive_son_container)
    ConstraintLayout mAliveSonContainer;

    @BindView(R.id.instruction_activity_alive_son_et_value)
    TextInputEditText mAliveSonValueTV;

    //Alive Daughter
    @BindView(R.id.instruction_activity_alive_daughter_container)
    ConstraintLayout mAliveDaughterContainer;

    @BindView(R.id.instruction_activity_alive_daughter_et_value)
    TextInputEditText mAliveDaughterValueTV;

    //dead Son
    @BindView(R.id.instruction_activity_dead_son_container)
    ConstraintLayout mDeadSonContainer;

    @BindView(R.id.instruction_activity_dead_son_et_value)
    TextInputEditText mDeadSonValueET;

    //dead Daughter
    @BindView(R.id.instruction_activity_dead_daughter_container)
    ConstraintLayout mDeadDaughterContainer;

    @BindView(R.id.instruction_activity_dead_daughter_et_value)
    TextInputEditText mDeadDaughterValueET;

    //Mother
    @BindView(R.id.instruction_activity_mother_layout)
    ConstraintLayout mMotherContainer;

    @BindView(R.id.mother_layout_radio_group)
    RadioGroup mMotherRadioGroup;

    @BindView(R.id.mother_rb_yes)
    RadioButton mMotherYesRB;

    @BindView(R.id.mother_rb_no)
    RadioButton mMotherNoRB;

    //Father
    @BindView(R.id.instruction_activity_father_layout)
    ConstraintLayout mFatherContainer;

    @BindView(R.id.father_layout_radio_group)
    RadioGroup mFatherRadioGroup;

    @BindView(R.id.father_rb_yes)
    RadioButton mFatherYesRB;

    @BindView(R.id.father_rb_no)
    RadioButton mFatherNoRB;

    // Father GrandPa
    @BindView(R.id.instruction_activity_father_grandpa_layout)
    ConstraintLayout mFatherGrandPaContainer;

    @BindView(R.id.father_grandpa_layout_radio_group)
    RadioGroup mFatherGrandpaRadioGroup;

    @BindView(R.id.father_grandpa_rb_yes)
    RadioButton mFatherGrandpaYesRB;

    @BindView(R.id.father_grandpa_rb_no)
    RadioButton mFatherGrandpaNoRB;

    // Father GrandMa
    @BindView(R.id.instruction_activity_father_grandma_layout)
    ConstraintLayout mFatherGrandMaContainer;

    @BindView(R.id.father_grandma_layout_radio_group)
    RadioGroup mFatherGrandmaRadioGroup;

    @BindView(R.id.father_grandma_rb_yes)
    RadioButton mFatherGrandmaYesRB;

    @BindView(R.id.father_grandma_rb_no)
    RadioButton mFatherGrandmaNoRB;

    // Mother GrandMa
    @BindView(R.id.instruction_activity_mother_grandma_layout)
    ConstraintLayout mMotherGrandMaContainer;

    @BindView(R.id.mother_grandma_layout_radio_group)
    RadioGroup mMotherGrandmaRadioGroup;

    @BindView(R.id.mother_grandma_rb_yes)
    RadioButton mMotherGrandmaYesRB;

    @BindView(R.id.mother_grandma_rb_no)
    RadioButton mMotherGrandmaNoRB;

    // Mother GrandPa
    @BindView(R.id.instruction_activity_mother_grandpa_layout)
    ConstraintLayout mMotherGrandPaContainer;

    @BindView(R.id.mother_grandpa_layout_radio_group)
    RadioGroup mMotherGrandpaRadioGroup;

    @BindView(R.id.mother_grandpa_rb_yes)
    RadioButton mMotherGrandpaYesRB;

    @BindView(R.id.mother_grandpa_rb_no)
    RadioButton mMotherGrandpaNoRB;

    //Brothers Question
    @BindView(R.id.instruction_activity_brothers_question_layout)
    ConstraintLayout mBrotherQuestionContainer;

    @BindView(R.id.brothers_question_layout_radio_group)
    RadioGroup mBrotherQuestionRadioGroup;

    @BindView(R.id.brothers_question_rb_yes)
    RadioButton mBrotherQuestionYesRB;

    @BindView(R.id.brothers_question_rb_no)
    RadioButton mBrotherQuestionNoRB;

    //Brothers
    @BindView(R.id.instruction_activity_brother_container)
    ConstraintLayout mBrothersContainer;

    @BindView(R.id.instruction_activity_brother_et_value)
    TextInputEditText mBrothersValueTV;

    //Sisters
    @BindView(R.id.instruction_activity_sister_container)
    ConstraintLayout mSistersContainer;

    @BindView(R.id.instruction_activity_sister_et_value)
    TextInputEditText mSistersValueTV;

    //Father Uncle
    @BindView(R.id.instruction_activity_father_uncle_container)
    ConstraintLayout mFatherUnclesContainer;

    @BindView(R.id.instruction_activity_father_uncle_et_value)
    EditText mFatherUnclesValueTV;

    //Father Aunt
    @BindView(R.id.instruction_activity_father_aunt_container)
    ConstraintLayout mFatherAuntsContainer;

    @BindView(R.id.instruction_activity_father_aunt_et_value)
    EditText mFatherAuntsValueTV;

    //Mother Uncle
    @BindView(R.id.instruction_activity_mother_uncle_container)
    ConstraintLayout mMotherUnclesContainer;

    @BindView(R.id.instruction_activity_mother_uncle_et_value)
    EditText mMotherUnclesValueTV;

    //Mother Aunt
    @BindView(R.id.instruction_activity_mother_aunt_container)
    ConstraintLayout mMotherAuntsContainer;

    @BindView(R.id.instruction_activity_mother_aunt_et_value)
    EditText mMotherAuntsValueTV;

    @BindView(R.id.instruction_activity_scroll_view)
    ScrollView scrollView;

    @BindView(R.id.instruction_activity_new_instruction)
    Button mNewProblem;

    GuideActivity mCurrent;

    PrefManager mPrefManager;

    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() {
        try {

            ButterKnife.bind(this);
            mCurrent = GuideActivity.this;

            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setTitle(getString(R.string.instructions));
                actionBar.setDisplayHomeAsUpEnabled(true);
            }

            mPrefManager = new PrefManager(mCurrent);

            showInstructions();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showInstructions() {
        try {
            mTotalMoneyContainer.setFocusable(false);

            counter = mPrefManager.readInt("instructions");
            counter++;
            mPrefManager.saveInt("instructions", counter);

            ShowcaseConfig config = new ShowcaseConfig();
            config.setDelay(100); // .1 second between each showcase view.
            config.setShape(new RectangleShape(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            config.setMaskColor(getResources().getColor(R.color.colorAccent));
            config.setContentTextColor(getResources().getColor(R.color.white));
            config.setDismissTextColor(getResources().getColor(R.color.white));

            MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(mCurrent, (String.valueOf(counter)));
            sequence.setConfig(config);
            sequence.singleUse(String.valueOf(counter));

            sequence.addSequenceItem(mTotalMoneyContainer,
                    getString(R.string.money_instructions), getString(R.string.str_next_lbl));

            sequence.addSequenceItem(mGenderContainer,
                    getString(R.string.gender_instructions), getString(R.string.str_next_lbl));

            sequence.addSequenceItem(mWivesContainer,
                    getString(R.string.wives_instructions), getString(R.string.str_next_lbl));

            sequence.addSequenceItem(mHusbandContainer,
                    getString(R.string.husband_instructions), getString(R.string.str_next_lbl));

            sequence.addSequenceItem(mAliveSonContainer,
                    getString(R.string.alive_sons_instructions), getString(R.string.str_next_lbl));

            sequence.addSequenceItem(mAliveDaughterContainer,
                    getString(R.string.alive_daughter_instructions), getString(R.string.str_next_lbl));

            sequence.addSequenceItem(mDeadSonContainer,
                    getString(R.string.dead_son_instructions), getString(R.string.str_next_lbl));

            sequence.addSequenceItem(mDeadDaughterContainer,
                    getString(R.string.dead_daughter_instructions), getString(R.string.str_next_lbl));

            sequence.addSequenceItem(mMotherContainer,
                    getString(R.string.mother_instructions), getString(R.string.str_next_lbl));

            sequence.addSequenceItem(mMotherGrandPaContainer,
                    getString(R.string.mother_grandpa_instructions), getString(R.string.str_next_lbl));

            sequence.addSequenceItem(mMotherGrandMaContainer,
                    getString(R.string.mother_grandma_instructions), getString(R.string.str_next_lbl));

            sequence.addSequenceItem(mFatherContainer,
                    getString(R.string.father_instructions), getString(R.string.str_next_lbl));

            sequence.addSequenceItem(mFatherGrandPaContainer,
                    getString(R.string.father_grandpa_instructions), getString(R.string.str_next_lbl));

            sequence.addSequenceItem(mFatherGrandMaContainer,
                    getString(R.string.father_grandma_instructions), getString(R.string.str_next_lbl));

            sequence.addSequenceItem(mBrotherQuestionContainer,
                    getString(R.string.brothers_question_instructions), getString(R.string.str_next_lbl));

            sequence.addSequenceItem(mBrothersContainer,
                    getString(R.string.brothers_instructions), getString(R.string.str_next_lbl));

            sequence.addSequenceItem(mSistersContainer,
                    getString(R.string.sister_instructions), getString(R.string.str_next_lbl));

            sequence.addSequenceItem(mMotherUnclesContainer,
                    getString(R.string.mother_uncle_instructions), getString(R.string.str_next_lbl));

            sequence.addSequenceItem(mMotherAuntsContainer,
                    getString(R.string.mother_aunt_instructions), getString(R.string.str_next_lbl));

            sequence.addSequenceItem(mFatherUnclesContainer,
                    getString(R.string.father_uncle_instructions), getString(R.string.str_next_lbl));

            sequence.addSequenceItem(mFatherAuntsContainer,
                    getString(R.string.father_aunt_instructions), getString(R.string.str_next_lbl));

            sequence.addSequenceItem(mSolveProblemBtn,
                    getString(R.string.solve_problem_instructions), getString(R.string.str_ok_lbl));

            sequence.addSequenceItem(mNewProblem,
                    getString(R.string.new_problem_instructions), getString(R.string.str_ok_lbl));

            scrollView.scrollTo((int) mTotalMoneyContainer.getX(), (int) mTotalMoneyContainer.getY());
            scrollView.fullScroll(View.FOCUS_UP);
            sequence.start();

            sequence.setOnItemShownListener((itemView, position) -> {
                Log.d(TAG, "onShow: position = " + position);
                if (position == 1) {
                    scrollView.scrollTo((int) mGenderContainer.getX(), (int) mGenderContainer.getY());

                } else if (position == 2) {
                    scrollView.scrollTo((int) mWivesContainer.getX(), (int) mWivesContainer.getY());

                } else if (position == 3) {
                    scrollView.scrollTo((int) mHusbandContainer.getX(), (int) mHusbandContainer.getY());

                } else if (position == 4) {
                    scrollView.scrollTo((int) mAliveSonContainer.getX(), (int) mAliveSonContainer.getY());

                } else if (position == 5) {
                    scrollView.scrollTo((int) mAliveDaughterContainer.getX(), (int) mAliveDaughterContainer.getY());

                } else if (position == 6) {
                    scrollView.scrollTo((int) mDeadSonContainer.getX(), (int) mDeadSonContainer.getY());

                } else if (position == 7) {
                    scrollView.scrollTo((int) mDeadDaughterContainer.getX(), (int) mDeadDaughterContainer.getY());

                } else if (position == 8) {
                    scrollView.scrollTo((int) mMotherContainer.getX(), (int) mMotherContainer.getY());

                } else if (position == 9) {
                    scrollView.scrollTo((int) mMotherGrandPaContainer.getX(), (int) mMotherGrandPaContainer.getY());

                } else if (position == 10) {
                    scrollView.scrollTo((int) mMotherGrandMaContainer.getX(), (int) mMotherGrandMaContainer.getY());

                } else if (position == 11) {
                    scrollView.scrollTo((int) mFatherContainer.getX(), (int) mFatherContainer.getY());

                } else if (position == 12) {
                    scrollView.scrollTo((int) mFatherGrandPaContainer.getX(), (int) mFatherGrandPaContainer.getY());

                } else if (position == 13) {
                    scrollView.scrollTo((int) mFatherGrandMaContainer.getX(), (int) mFatherGrandMaContainer.getY());

                } else if (position == 14) {
                    scrollView.scrollTo((int) mBrotherQuestionContainer.getX(), (int) mBrotherQuestionContainer.getY());

                } else if (position == 15) {
                    scrollView.scrollTo((int) mBrothersContainer.getX(), (int) mBrothersContainer.getY());

                } else if (position == 16) {
                    scrollView.scrollTo((int) mSistersContainer.getX(), (int) mSistersContainer.getY());

                } else if (position == 17) {
                    scrollView.scrollTo((int) mMotherUnclesContainer.getX(), (int) mMotherUnclesContainer.getY());

                } else if (position == 18) {
                    scrollView.scrollTo((int) mMotherAuntsContainer.getX(), (int) mMotherAuntsContainer.getY());

                } else if (position == 19) {
                    scrollView.scrollTo((int) mFatherUnclesContainer.getX(), (int) mFatherUnclesContainer.getY());

                } else if (position == 20) {
                    scrollView.scrollTo((int) mFatherAuntsContainer.getX(), (int) mFatherAuntsContainer.getY());

                } else if (position == 21) {
                    scrollView.scrollTo((int) mNewProblem.getX(), (int) mNewProblem.getY());
                    scrollView.fullScroll(View.FOCUS_DOWN);

                } else if (position == 22) {
                    scrollView.scrollTo((int) mSolveProblemBtn.getX(), (int) mSolveProblemBtn.getY());
                    scrollView.fullScroll(View.FOCUS_DOWN);
                }

            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.guide_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        else if (item.getItemId() == R.id.guide_renew) {
            showInstructions();
        }
        return super.onOptionsItemSelected(item);
    }

}
