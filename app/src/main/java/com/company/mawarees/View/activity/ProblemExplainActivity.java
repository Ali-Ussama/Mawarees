package com.company.mawarees.View.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.Utilities.AppUtils;
import com.company.mawarees.R;
import com.company.mawarees.View.adpters.ExplainFirstStepRecAdapter;
import com.company.mawarees.View.adpters.ExplainSecondStepRecAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProblemExplainActivity extends AppCompatActivity {

    @BindView(R.id.activity_explain_first_step_rv)
    RecyclerView mFirstStepRV;

    @BindView(R.id.activity_explain_third_step_rv)
    RecyclerView mThirdStepRV;

    @BindView(R.id.activity_explain_second_step_value)
    TextView summationOfFractions;

    private ExplainFirstStepRecAdapter mFirstAdapter;
    private ExplainSecondStepRecAdapter mSecondAdapter;

    private ArrayList<Person> people;
    private ProblemExplainActivity mCurrent;

    int originalValue = 0;

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
                if (i < people.size() - 1) {
                    summation.append(" ").append(people.get(i).getOriginalSharePercent().getDenominator()).append("/").append(people.get(i).getOriginalSharePercent().getNumerator()).append(" +");
                } else {
                    summation.append(" ").append(people.get(i).getOriginalSharePercent().getDenominator()).append("/").append(people.get(i).getOriginalSharePercent().getNumerator());
                }
                originalValue += people.get(i).getOriginalSharePercent().getNumerator();
            }

            summation.append(" ").append(" = ").append(originalValue).append("/").append("24");

            summationOfFractions.setText(summation.toString());

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
                            (people.get(i).getSharePercent().getNumerator() == 0) && people.get(i).getSharePercent().getDenominator() == 0)) {
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
            mSecondAdapter = new ExplainSecondStepRecAdapter(originalValue,people, mCurrent);
            mThirdStepRV.setLayoutManager(layoutManager);
            mThirdStepRV.setAdapter(mSecondAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initFirstRV() {
        try {
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            mFirstAdapter = new ExplainFirstStepRecAdapter(people, mCurrent);
            mFirstStepRV.setLayoutManager(layoutManager);
            mFirstStepRV.setAdapter(mFirstAdapter);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
