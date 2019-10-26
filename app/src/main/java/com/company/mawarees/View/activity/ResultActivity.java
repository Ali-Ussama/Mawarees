package com.company.mawarees.View.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.company.mawarees.Model.Callback.ItemSelectedListener;
import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.Utilities.AppUtils;
import com.company.mawarees.R;
import com.company.mawarees.View.adpters.ResultRVAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultActivity extends AppCompatActivity implements ItemSelectedListener {

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

    ArrayList<Person> mPeople;

    private ResultActivity mCurrent;
    private ResultRVAdapter mResultRVAdapter;
    private double totalMoney;

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
            Toolbar mToolbar = AppUtils.setupToolbar(mCurrent, 1);
            AppUtils.setToolbarTitle(mToolbar, getString(R.string.problem_result));

            Log.i(TAG, "init() is Called 2");

            mPeople = getIntent().getParcelableArrayListExtra("data");
            totalMoney = getIntent().getDoubleExtra(getString(R.string.intent_total_money), 0.0);

            LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(mCurrent, LinearLayoutManager.HORIZONTAL, false);
            mResultRVAdapter = new ResultRVAdapter(mPeople, mCurrent, this);

            Log.i(TAG, "init() is Called 3");

            mRecyclerView.setLayoutManager(mLinearLayoutManager);
            mRecyclerView.setNestedScrollingEnabled(true);
            mResultRVAdapter.setSelectedPerson(mPeople.get(0));
            mRecyclerView.setAdapter(mResultRVAdapter);
            setViewsWithResult(mPeople.get(0));

            Log.i(TAG, "init() is Called 4");

            Log.i(TAG, "init() people size = " + mPeople.size());

            Log.i(TAG, "init() is Called 5");

        } catch (Exception e) {
            e.printStackTrace();
        }
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
                }
                mSharePercentPerPersonTV.setText(String.valueOf(getString(R.string.default_value)));
                mShareValueTV.setText(String.valueOf(person.getShareValue()));
                mShareValuePerPersonTV.setText(String.valueOf(getString(R.string.default_value)));
                mSharesTV.setText(String.valueOf(person.getNumberOfShares()));
                mSharesPerPersonTV.setText(String.valueOf(getString(R.string.default_value)));
                if (person.getExplanation() != null) {
                    mExplanationTV.setText(person.getExplanation());
                } else {
                    mExplanationTV.setText(String.valueOf(getString(R.string.bla_bla)));
                }

                if (person.getProof() != null) {
                    mProofTV.setText(person.getProof());
                } else {
                    mProofTV.setText(String.valueOf(getString(R.string.bla_bla)));
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
}
