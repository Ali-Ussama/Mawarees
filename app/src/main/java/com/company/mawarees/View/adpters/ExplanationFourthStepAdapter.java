package com.company.mawarees.View.adpters;

import android.content.Context;
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

    private Context context;
    private ArrayList<Person> data;
    private int correctionValue;

    public ExplanationFourthStepAdapter(ArrayList<Person> data, int correctionValue, Context context) {
        this.context = context;
        this.data = data;
        this.correctionValue = correctionValue;
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

            holder.mGroupName.setText(data.get(position).getRelation());

            if (data.get(position).getRelation().matches(OConstants.PERSON_More_Than_three_DAUGHTERS) || data.get(position).getRelation().matches(OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER)) {
                holder.mTogether.setVisibility(View.VISIBLE);
            } else {
                holder.mTogether.setVisibility(View.GONE);
            }


            if (data.get(position).getRelation().matches(OConstants.PERSON_SON) || data.get(position).getRelation().matches(OConstants.PERSON_BROTHER)
                    || data.get(position).getRelation().matches(OConstants.PERSON_FATHER_UNCLE) || data.get(position).getRelation().matches(OConstants.PERSON_MOTHER_UNCLE)) {

                if (data.get(position).getRelation().matches(OConstants.PERSON_SON)) {
                    displayManValue(holder, position, OConstants.PERSON_SON, OConstants.PERSON_DAUGHTER);

                } else if (data.get(position).getRelation().matches(OConstants.PERSON_BROTHER)) {
                    displayManValue(holder, position, OConstants.PERSON_BROTHER, OConstants.PERSON_SISTER);

                } else if (data.get(position).getRelation().matches(OConstants.PERSON_FATHER_UNCLE)) {
                    displayManValue(holder, position, OConstants.PERSON_FATHER_UNCLE, OConstants.PERSON_FATHER_AUNT);

                } else if (data.get(position).getRelation().matches(OConstants.PERSON_MOTHER_UNCLE)) {
                    displayManValue(holder, position, OConstants.PERSON_MOTHER_UNCLE, OConstants.PERSON_MOTHER_AUNT);
                }

            } else if (data.get(position).getRelation().matches(OConstants.PERSON_DAUGHTER) || data.get(position).getRelation().matches(OConstants.PERSON_SISTER) || data.get(position).getRelation().matches(OConstants.PERSON_FATHER_AUNT)
                    || data.get(position).getRelation().matches(OConstants.PERSON_MOTHER_AUNT)) {

                if (data.get(position).getRelation().matches(OConstants.PERSON_DAUGHTER)) {
                    displayWomanValue(holder, position, OConstants.PERSON_SON, OConstants.PERSON_DAUGHTER);

                } else if (data.get(position).getRelation().matches(OConstants.PERSON_SISTER)) {
                    displayWomanValue(holder, position, OConstants.PERSON_BROTHER, OConstants.PERSON_SISTER);

                } else if (data.get(position).getRelation().matches(OConstants.PERSON_FATHER_AUNT)) {
                    displayWomanValue(holder, position, OConstants.PERSON_FATHER_UNCLE, OConstants.PERSON_FATHER_AUNT);

                } else if (data.get(position).getRelation().matches(OConstants.PERSON_MOTHER_AUNT)) {
                    displayWomanValue(holder, position, OConstants.PERSON_MOTHER_UNCLE, OConstants.PERSON_MOTHER_AUNT);
                }

            } else {
                holder.mCorrectionValue.setText(String.valueOf(correctionValue));
                holder.mShareValue.setText(String.valueOf(data.get(position).getSharePercent().getNumerator()));
                holder.mMultiply.setText(String.valueOf((correctionValue * data.get(position).getSharePercent().getNumerator())));

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

            holder.mBrackets_1.setVisibility(View.VISIBLE);
            holder.mBrackets_2.setVisibility(View.VISIBLE);
            holder.mDivide.setVisibility(View.VISIBLE);
            holder.mGroupShareValue.setVisibility(View.VISIBLE);

            int count = OConstants.getPersonsInGirlsCount(data, boysRelation, girlsRelation);
            double groupShare = (correctionValue * data.get(position).getSharePercent().getNumerator());

            int mCorrectionValue = 2;
            holder.mGroupShareValue.setText(String.valueOf(groupShare));

            holder.mShareValue.setText(String.valueOf(mCorrectionValue));
            holder.mCorrectionValue.setText(String.valueOf(data.get(position).getSharePercent().getNumerator()));

            holder.mMultiply.setText(String.valueOf(((groupShare / count) * mCorrectionValue)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void displayWomanValue(ExplanationFourthStepAdapter.viewHolder holder, int position, String boysRelation, String girlsRelation) {
        try {
            holder.mBrackets_1.setVisibility(View.VISIBLE);
            holder.mBrackets_2.setVisibility(View.VISIBLE);
            holder.mDivide.setVisibility(View.VISIBLE);
            holder.mGroupShareValue.setVisibility(View.VISIBLE);

            int count = OConstants.getPersonsInGirlsCount(data, boysRelation, girlsRelation);
            double groupShare = (correctionValue * data.get(position).getSharePercent().getNumerator());

            int mCorrectionValue = 1;
            holder.mGroupShareValue.setText(String.valueOf(groupShare));

            holder.mShareValue.setText(String.valueOf(mCorrectionValue));
            holder.mCorrectionValue.setText(String.valueOf(data.get(position).getSharePercent().getNumerator()));

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