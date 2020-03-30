package com.company.mawarees.View.adpters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;
import com.company.mawarees.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExplanationFourthStepAdapter extends RecyclerView.Adapter<ExplanationFourthStepAdapter.viewHolder> {

    private static final String TAG = "ExplainFourthAdapter";
    private Context context;
    private ArrayList<Person> data, dataWithDeadPeople;
    private int correctionValue;
    private OConstants oConstants;
    private boolean isHasGrandChildren;
    public ExplanationFourthStepAdapter(ArrayList<Person> data, ArrayList<Person> dataWithDeadPeople, int correctionValue, Context context, OConstants oConstants,boolean isHasGrandChildren) {
        this.context = context;
        this.data = data;
        this.correctionValue = correctionValue;
        this.dataWithDeadPeople = dataWithDeadPeople;
        this.oConstants = oConstants;
        this.isHasGrandChildren = isHasGrandChildren;
    }

    @NonNull
    @Override
    public ExplanationFourthStepAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        try {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_explain_fourth_step_rv_row_item2, parent, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ExplanationFourthStepAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExplanationFourthStepAdapter.viewHolder holder, int position) {
        try {

            Person person = data.get(position);
            String the = "ال";
            if (person.getRelation().substring(0, 2).contains(the)) {
                Log.i(TAG, "onBindViewHolder(): person relation" + person.getRelation() + " contains the");
                holder.mGroupName.setText(person.getRelation());
            } else {
                Log.i(TAG, "onBindViewHolder(): person relation" + person.getRelation() + " not contains the");
                holder.mGroupName.setText(the.concat(person.getRelation()));
            }

            if (person.isGroup()) {
                holder.mTogether.setVisibility(View.VISIBLE);
            } else {
                holder.mTogether.setVisibility(View.GONE);
            }


            if (person.getRelation().matches(OConstants.PERSON_SON) || person.getRelation().matches(OConstants.PERSON_BROTHER)
                    || person.getRelation().matches(OConstants.PERSON_FATHER_UNCLE) || person.getRelation().matches(OConstants.PERSON_MOTHER_UNCLE)) {

                if (person.getRelation().matches(OConstants.PERSON_SON)) {
                    displayManValue(holder, position, OConstants.PERSON_SON, OConstants.PERSON_DAUGHTER);

                } else if (person.getRelation().matches(OConstants.PERSON_BROTHER)) {
                    displayManValue(holder, position, OConstants.PERSON_BROTHER, OConstants.PERSON_SISTER);

                } else if (person.getRelation().matches(OConstants.PERSON_FATHER_UNCLE)) {
                    displayManValue(holder, position, OConstants.PERSON_FATHER_UNCLE, OConstants.PERSON_FATHER_AUNT);

                } else if (person.getRelation().matches(OConstants.PERSON_MOTHER_UNCLE)) {
                    displayManValue(holder, position, OConstants.PERSON_MOTHER_UNCLE, OConstants.PERSON_MOTHER_AUNT);
                }

            } else if (person.getRelation().matches(OConstants.PERSON_DAUGHTER) || person.getRelation().matches(OConstants.PERSON_SISTER) || person.getRelation().matches(OConstants.PERSON_FATHER_AUNT)
                    || person.getRelation().matches(OConstants.PERSON_MOTHER_AUNT)) {

                if (person.getRelation().matches(OConstants.PERSON_DAUGHTER)) {
                    displayWomanValue(holder, position, OConstants.PERSON_SON, OConstants.PERSON_DAUGHTER);

                } else if (person.getRelation().matches(OConstants.PERSON_SISTER)) {
                    displayWomanValue(holder, position, OConstants.PERSON_BROTHER, OConstants.PERSON_SISTER);

                } else if (person.getRelation().matches(OConstants.PERSON_FATHER_AUNT)) {
                    displayWomanValue(holder, position, OConstants.PERSON_FATHER_UNCLE, OConstants.PERSON_FATHER_AUNT);

                } else if (person.getRelation().matches(OConstants.PERSON_MOTHER_AUNT)) {
                    displayWomanValue(holder, position, OConstants.PERSON_MOTHER_UNCLE, OConstants.PERSON_MOTHER_AUNT);
                }
            } else if (person.getRelation().matches(OConstants.PERSON_WIFE)) {
                displayWomanValue(holder, position, "", OConstants.PERSON_WIFE);
            } else {
                holder.mCorrectionValue.setText(String.valueOf(correctionValue));
//                holder.mShareValue.setText(String.valueOf(person.getSharePercent().getNumerator()));
                holder.mShareValue.setText(String.valueOf(person.getSharePercent().getNumerator()));
                holder.mMultiply.setText(String.valueOf((correctionValue * person.getSharePercent().getNumerator())));

                holder.mBrackets_1.setVisibility(View.GONE);
                holder.mBrackets_2.setVisibility(View.GONE);
                holder.mDivide.setVisibility(View.GONE);
                holder.mGroupShareValue.setVisibility(View.GONE);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void displayManValue(ExplanationFourthStepAdapter.viewHolder holder, int position, String boysRelation, String girlsRelation) {
        try {
            Person person = data.get(position);
            holder.mBrackets_1.setVisibility(View.VISIBLE);
            holder.mBrackets_2.setVisibility(View.VISIBLE);
            holder.mDivide.setVisibility(View.VISIBLE);
            holder.mGroupShareValue.setVisibility(View.VISIBLE);

            int count = 0;
            /*if ((boysRelation.matches(OConstants.PERSON_MOTHER_UNCLE) &&
                    ((OConstants.getPersonCount(dataWithDeadPeople, OConstants.PERSON_FATHER_AUNT) + OConstants.getPersonCount(dataWithDeadPeople, OConstants.PERSON_FATHER_UNCLE) > 0)
                            || (OConstants.getPersonCount(dataWithDeadPeople, OConstants.PERSON_BROTHER) + OConstants.getPersonCount(dataWithDeadPeople, OConstants.PERSON_SISTER) > 0)))
                    || (boysRelation.matches(OConstants.PERSON_FATHER_UNCLE) &&
                    ((OConstants.getPersonCount(dataWithDeadPeople, OConstants.PERSON_MOTHER_AUNT) + OConstants.getPersonCount(dataWithDeadPeople, OConstants.PERSON_MOTHER_UNCLE) > 0)
                            || (OConstants.getPersonCount(dataWithDeadPeople, OConstants.PERSON_BROTHER) + OConstants.getPersonCount(dataWithDeadPeople, OConstants.PERSON_SISTER) > 0)))) {

                count = OConstants.getPersonCount(dataWithDeadPeople, boysRelation) + OConstants.getPersonCount(dataWithDeadPeople, girlsRelation);

            } else */if (OConstants.isBrotherPartCase(oConstants) && person.getRelation().equals(OConstants.PERSON_BROTHER)) {
                count = OConstants.getPersonCount(dataWithDeadPeople, boysRelation) + OConstants.getPersonCount(dataWithDeadPeople, girlsRelation);
            } else {
                count = OConstants.getPersonsInGirlsCount(dataWithDeadPeople, boysRelation, girlsRelation);
            }

            Log.i(TAG, "displayManValue: person = " + person.getRelation() + " - correctionValue = " + correctionValue + " group number of shares = " + person.getSharePercent().getNumerator());
//            double groupShare = (correctionValue * (person.getSharePercent().getNumerator() / 2)) * count; //Commented 28/3/2020
            double groupShare;
            if (isHasGrandChildren){
                groupShare = (correctionValue * (person.getSharePercent().getNumerator()) / 2) * count;//Created 28/3/2020
            }else{
                groupShare = (correctionValue * (person.getSharePercent().getNumerator()));//Created 28/3/2020
            }

            int mCorrectionValue;
           /* if ((boysRelation.matches(OConstants.PERSON_MOTHER_UNCLE) &&
                    ((OConstants.getPersonCount(dataWithDeadPeople, OConstants.PERSON_FATHER_AUNT) + OConstants.getPersonCount(dataWithDeadPeople, OConstants.PERSON_FATHER_UNCLE) > 0)
                            || (OConstants.getPersonCount(dataWithDeadPeople, OConstants.PERSON_BROTHER) + OConstants.getPersonCount(dataWithDeadPeople, OConstants.PERSON_SISTER) > 0)))
                    || (boysRelation.matches(OConstants.PERSON_FATHER_UNCLE) &&
                    ((OConstants.getPersonCount(dataWithDeadPeople, OConstants.PERSON_MOTHER_AUNT) + OConstants.getPersonCount(dataWithDeadPeople, OConstants.PERSON_MOTHER_UNCLE) > 0)
                            || (OConstants.getPersonCount(dataWithDeadPeople, OConstants.PERSON_BROTHER) + OConstants.getPersonCount(dataWithDeadPeople, OConstants.PERSON_SISTER) > 0)))) {

                mCorrectionValue = 1;
            }else */if (OConstants.isBrotherPartCase(oConstants) && person.getRelation().equals(OConstants.PERSON_BROTHER)){
                mCorrectionValue = 1;

            }else {
                mCorrectionValue = 2;
            }
            holder.mGroupShareValue.setText(String.valueOf(groupShare));

            holder.mShareValue.setText(String.valueOf(mCorrectionValue));
//            holder.mCorrectionValue.setText(String.valueOf(person.getSharePercent().getNumerator()));
            holder.mCorrectionValue.setText(String.valueOf(count));

            holder.mMultiply.setText(String.valueOf(((groupShare / count) * mCorrectionValue)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void displayWomanValue(ExplanationFourthStepAdapter.viewHolder holder, int position, String boysRelation, String girlsRelation) {
        try {
            Person person = data.get(position);

            holder.mBrackets_1.setVisibility(View.VISIBLE);
            holder.mBrackets_2.setVisibility(View.VISIBLE);
            holder.mDivide.setVisibility(View.VISIBLE);
            holder.mGroupShareValue.setVisibility(View.VISIBLE);

            int count = 0;

          /*  if ((girlsRelation.matches(OConstants.PERSON_MOTHER_AUNT) &&
                    ((OConstants.getPersonCount(dataWithDeadPeople, OConstants.PERSON_FATHER_AUNT) + OConstants.getPersonCount(dataWithDeadPeople, OConstants.PERSON_FATHER_UNCLE) > 0)
                            || (OConstants.getPersonCount(dataWithDeadPeople, OConstants.PERSON_BROTHER) + OConstants.getPersonCount(dataWithDeadPeople, OConstants.PERSON_SISTER) > 0)))
                    || (girlsRelation.matches(OConstants.PERSON_FATHER_AUNT) &&
                    ((OConstants.getPersonCount(dataWithDeadPeople, OConstants.PERSON_MOTHER_AUNT) + OConstants.getPersonCount(dataWithDeadPeople, OConstants.PERSON_MOTHER_UNCLE) > 0)
                            || (OConstants.getPersonCount(dataWithDeadPeople, OConstants.PERSON_BROTHER) + OConstants.getPersonCount(dataWithDeadPeople, OConstants.PERSON_SISTER) > 0)))) {

                count = OConstants.getPersonCount(dataWithDeadPeople, boysRelation) + OConstants.getPersonCount(dataWithDeadPeople, girlsRelation);

            } else */if (OConstants.isBrotherPartCase(oConstants) && person.getRelation().equals(OConstants.PERSON_SISTER)) {
                count = OConstants.getPersonCount(dataWithDeadPeople, boysRelation) + OConstants.getPersonCount(dataWithDeadPeople, girlsRelation);
            } else {
                count = OConstants.getPersonsInGirlsCount(dataWithDeadPeople, boysRelation, girlsRelation);
            }

//            double groupShare = (correctionValue * person.getSharePercent().getNumerator()) * count; //Commented 28/3/2020
            double groupShare;
            if (isHasGrandChildren){
                groupShare = (correctionValue * (person.getSharePercent().getNumerator())) * count;//Created 28/3/2020
            }else{
                groupShare = (correctionValue * (person.getSharePercent().getNumerator()));//Created 28/3/2020
            }
            Log.i(TAG, "displayWomanValue: person = " + person.getRelation() + " - correctionValue = " + correctionValue + " group number of shares = " + person.getSharePercent().getNumerator());

            int mCorrectionValue = 1;
            holder.mGroupShareValue.setText(String.valueOf(groupShare));

            holder.mShareValue.setText(String.valueOf(mCorrectionValue));
//            holder.mCorrectionValue.setText(String.valueOf(person.getSharePercent().getNumerator()));
            holder.mCorrectionValue.setText(String.valueOf(count));

            holder.mMultiply.setText(String.valueOf(((groupShare / count) * mCorrectionValue)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.step_fourth_rv_ri_person_relation)
        TextView mGroupName;

        @BindView(R.id.step_fourth_rv_ri_lbl_4)
        TextView mTogether;

        @BindView(R.id.step_fourth_rv_ri_correction_value)
        TextView mCorrectionValue;

        @BindView(R.id.step_fourth_rv_ri_share_value)
        TextView mShareValue;

        @BindView(R.id.step_fourth_rv_ri_multiply_value)
        TextView mMultiply;

        @BindView(R.id.step_fourth_rv_ri_all_share_value)
        TextView mGroupShareValue;

        @BindView(R.id.step_fourth_rv_ri_brackets_1)
        TextView mBrackets_1;

        @BindView(R.id.step_fourth_rv_ri_brackets_2)
        TextView mBrackets_2;

        @BindView(R.id.step_fourth_rv_ri_divide)
        TextView mDivide;

        viewHolder(@NonNull View itemView) {
            super(itemView);

            try {
                ButterKnife.bind(this, itemView);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}