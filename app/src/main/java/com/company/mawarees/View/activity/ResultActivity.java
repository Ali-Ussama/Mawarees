package com.company.mawarees.View.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

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

    ArrayList<Person> mPeople;

    private Toolbar mToolbar;

    private ResultActivity mCurrent;
    private ResultRVAdapter mResultRVAdapter;

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
            mToolbar = AppUtils.setupToolbar(mCurrent, 1);
            AppUtils.setToolbarTitle(mToolbar, getString(R.string.problem_result));
            Log.i(TAG, "init() is Called 2");

            mPeople = getIntent().getParcelableArrayListExtra("data");

            LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(mCurrent, LinearLayoutManager.HORIZONTAL, false);
            mResultRVAdapter = new ResultRVAdapter(mPeople, mCurrent, this);

            Log.i(TAG, "init() is Called 3");

            mRecyclerView.setLayoutManager(mLinearLayoutManager);
            mRecyclerView.setNestedScrollingEnabled(true);
            mRecyclerView.setAdapter(mResultRVAdapter);
            Log.i(TAG, "init() is Called 4");
            mResultRVAdapter.setSelectedPerson(mPeople.get(0));

            Log.i(TAG, "init() people size = " + mPeople.size());

            Log.i(TAG, "init() is Called 5");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onItemSelected(Person person, int position) {
        try {
            mResultRVAdapter.setSelectedPerson(person);
            mResultRVAdapter.notifyDataSetChanged();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
