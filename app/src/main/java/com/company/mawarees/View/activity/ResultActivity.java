package com.company.mawarees.View.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.company.mawarees.Model.Callback.ItemSelectedListener;
import com.company.mawarees.Model.Models.ExplanationModel;
import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;
import com.company.mawarees.Model.Utilities.AppUtils;
import com.company.mawarees.PrefManager;
import com.company.mawarees.R;
import com.company.mawarees.View.adpters.ResultRVAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultActivity extends AppCompatActivity implements ItemSelectedListener, View.OnClickListener {

    private static final String TAG = "ResultActivity";
    @BindView(R.id.act_result_rv)
    RecyclerView mRecyclerView;

    @BindView(R.id.result_act_total_money)
    TextView mTotalMoneyTV;

    @BindView(R.id.result_act_problem_origin)
    TextView mProblemOriginTV;

    @BindView(R.id.result_act_share_percent)
    TextView mSharePercentTV;

    @BindView(R.id.result_act_share_percent_per_person)
    TextView mSharePercentPerPersonTV;

    @BindView(R.id.result_act_share_value)
    TextView mShareValueTV;

    @BindView(R.id.result_act_share_value_per_person)
    TextView mShareValuePerPersonTV;

    @BindView(R.id.result_act_shares)
    TextView mSharesTV;

    @BindView(R.id.result_act_shares_per_person)
    TextView mSharesPerPersonTV;

    @BindView(R.id.result_act_explanation)
    TextView mExplanationTV;

    @BindView(R.id.result_act_proof)
    TextView mProofTV;

    @BindView(R.id.explain_problem_fab)
    Button mExplainProblemFab;

    @BindView(R.id.activity_result_correction_value)
    TextView mCorrectionValueTV;

    ArrayList<Person> mPeople;

    private ResultActivity mCurrent;
    private ResultRVAdapter mResultRVAdapter;
    private double totalMoney;

    ArrayList<String> mRelation;
    private OConstants oConstants;

    private ExplanationModel explanation;
    private PrefManager mPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            setContentView(R.layout.activity_result);

            ButterKnife.bind(this);

            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() {
        try {
            Log.i(TAG, "init is called");
            mCurrent = ResultActivity.this;
            mPrefManager = new PrefManager(mCurrent);

            Toolbar mToolbar = AppUtils.setupToolbar(mCurrent, 1);
            AppUtils.setToolbarTitle(mToolbar, getString(R.string.problem_result));

            Log.i(TAG, "init() is Called 2");

            mPeople = getIntent().getParcelableArrayListExtra(getString(R.string.intent_data_lbl));

            totalMoney = getIntent().getDoubleExtra(getString(R.string.intent_total_money), 0.0);


            Log.i(TAG, "init() is Called 3");
            mRecyclerView.setLayoutManager(new LinearLayoutManager(mCurrent, LinearLayoutManager.HORIZONTAL, false));
//            mRecyclerView.setNestedScrollingEnabled(true);
            mResultRVAdapter = new ResultRVAdapter(mPeople, mCurrent, this);
            mResultRVAdapter.setSelectedPerson(mPeople.get(0));
            mRecyclerView.setAdapter(mResultRVAdapter);
            setViewsWithResult(mPeople.get(0));

            Log.i(TAG, "init() is Called 4");

            Log.i(TAG, "init() people size = " + mPeople.size());

            Log.i(TAG, "init() is Called 5");

            mExplainProblemFab.setOnClickListener(this);

            oConstants = getIntent().getParcelableExtra(getString(R.string.constants));
            explanation = oConstants.getExplanation();

            setCorrectionNumber();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setCorrectionNumber() {
        try {
            int heads = mPrefManager.readInt(PrefManager.KEY_HEADS);
            int newProblemOrigin = mPrefManager.readInt(PrefManager.KEY_NEW_PROBLEM_ORIGIN);

            if (heads != 0 && newProblemOrigin != 0) {
                mCorrectionValueTV.setText(String.valueOf(heads));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initRelationsInArabic() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onItemSelected(Person person, int position) {
        try {
            resetResultViews();
            setViewsWithResult(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void resetResultViews() {
        try {
            mTotalMoneyTV.setText(getString(R.string.default_value));
            mProblemOriginTV.setText(getString(R.string.default_value));
            mSharePercentTV.setText(getString(R.string.default_value));
            mSharePercentPerPersonTV.setText(getString(R.string.default_value));
            mShareValueTV.setText(getString(R.string.default_value));
            mShareValuePerPersonTV.setText(getString(R.string.default_value));
            mSharesTV.setText(getString(R.string.default_value));
            mSharesPerPersonTV.setText(getString(R.string.default_value));
//            mExplanationTV.setText(getString(R.string.default_value));
//            mProofTV.setText(getString(R.string.default_value));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setViewsWithResult(Person person) {
        try {
            if (person.getBlocked() == null) {
                mTotalMoneyTV.setText(String.valueOf(totalMoney));
                mProblemOriginTV.setText(String.valueOf(person.getProblemOrigin()));

                if (person.getSharePercent() != null) {
                    mSharePercentTV.setText(String.valueOf(person.getSharePercent().getNumerator()).concat("/").concat(String.valueOf(person.getSharePercent().getDenominator())));
                } else {
                    mSharePercentTV.setText(String.valueOf(getString(R.string.default_value)));
                }

                if (person.getShareValue() > 0) {

                    mShareValueTV.setText(String.valueOf(person.getShareValue()));

                } else {

                    mShareValueTV.setText(String.valueOf(getString(R.string.default_value)));

                }

                if (person.getEachPersonSharePercent() != null) {
                    mSharePercentPerPersonTV.setText(String.valueOf(person.getEachPersonSharePercent().getNumerator()).concat("/").concat(String.valueOf(person.getEachPersonSharePercent().getDenominator())));
                } else {
                    mSharePercentPerPersonTV.setText(String.valueOf(getString(R.string.default_value)));
                }

                if (person.getEachPersonShareValue() > 0) {
                    mShareValuePerPersonTV.setText(String.valueOf(person.getEachPersonShareValue()));
                } else {
                    mShareValuePerPersonTV.setText(String.valueOf(getString(R.string.default_value)));
                }

                if (person.getEachPersonNumberOfShares() > 0) {
                    mSharesPerPersonTV.setText(String.valueOf(person.getEachPersonNumberOfShares()));
                } else {
                    mSharesPerPersonTV.setText(String.valueOf(getString(R.string.default_value)));

                }
                mSharesTV.setText(String.valueOf(person.getNumberOfShares()));

                if (person.getExplanation() != null) {
                    mExplanationTV.setText(person.getExplanation());
                } else {
                    mExplanationTV.setText(String.valueOf(getString(R.string.default_value)));
                }

                if (person.getProof() != null) {
                    mProofTV.setText(person.getProof());
                } else {
                    mProofTV.setText(String.valueOf(getString(R.string.default_value)));
                }
            } else {
                mTotalMoneyTV.setText(String.valueOf(totalMoney));
                mProblemOriginTV.setText(String.valueOf(person.getProblemOrigin()));
                mSharePercentTV.setText(String.valueOf(0));
                mSharePercentPerPersonTV.setText(String.valueOf(getString(R.string.default_value)));
                mShareValueTV.setText(String.valueOf(0));
                mShareValuePerPersonTV.setText(String.valueOf(getString(R.string.default_value)));
                mSharesTV.setText(String.valueOf(0));
                mSharesPerPersonTV.setText(String.valueOf(getString(R.string.default_value)));
                mExplanationTV.setText("الحجب بال".concat(person.getBlockedBy()));
                mProofTV.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        try {
            if (view.getId() == R.id.explain_problem_fab) {
                Intent intent = new Intent(mCurrent, ProblemExplainActivity.class);
                intent.putParcelableArrayListExtra(getString(R.string.intent_data_lbl), mPeople);
//                intent.putExtra(getString(R.string.explain_problem_result), explanation);
                intent.putExtra(getString(R.string.constants), oConstants);
                startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void displayResult(OConstants oConstants) {
        try {
            ExplanationModel explainModel = oConstants.getExplanation();
            ArrayList<Person> mPeople;
            Log.i(TAG, "displayResult(): is called");
            if (explainModel.getPhase1() != null && explainModel.getPhase1().getPeople() != null && !explainModel.getPhase1().getPeople().isEmpty()) {
                mPeople = explainModel.getPhase1().getPeople();
                Log.i(TAG, "displayResult(): phase 1 != null");

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        mPrefManager.saveInt(PrefManager.KEY_HEADS, 0);
        mPrefManager.saveInt(PrefManager.KEY_NEW_PROBLEM_ORIGIN, 0);
        mPrefManager.saveInt(PrefManager.KEY_SAVED_NUMBER_1, 0);
        mPrefManager.saveInt(PrefManager.KEY_SAVED_NUMBER_2, 0);
        mPrefManager.saveBoolean(PrefManager.KEY_ONE_GROUP, false);
    }
}
