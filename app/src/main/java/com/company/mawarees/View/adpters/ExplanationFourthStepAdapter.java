package com.company.mawarees.View.adpters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.company.mawarees.Model.Models.Group;
import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;
import com.company.mawarees.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExplanationFourthStepAdapter extends RecyclerView.Adapter<ExplanationFourthStepAdapter.viewHolder> {

    private ArrayList<Group> people;
    private Context context;
    private ArrayList<Person> data;
    private int correctionValue;

    public ExplanationFourthStepAdapter(ArrayList<Group> people, ArrayList<Person> data, int correctionValue, Context context) {
        this.people = people;
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
//            Group group = people.get(position);

            holder.mGroupName.setText(data.get(position).getRelation());

            if (data.get(position).getRelation().matches(OConstants.PERSON_More_Than_three_DAUGHTERS) || data.get(position).getRelation().matches(OConstants.PERSON_MORE_THAN_BROTHER_OR_SISTER)) {
                holder.mTogether.setVisibility(View.VISIBLE);
            } else {
                holder.mTogether.setVisibility(View.GONE);
            }

            if (data.get(position).getRelation().matches(OConstants.PERSON_SON) ||  data.get(position).getRelation().matches(OConstants.PERSON_BROTHER)
            ||  data.get(position).getRelation().matches(OConstants.PERSON_FATHER_UNCLE) ||  data.get(position).getRelation().matches(OConstants.PERSON_MOTHER_UNCLE) ){
                int mCorrectionValue = 2;
                holder.mCorrectionValue.setText(String.valueOf(mCorrectionValue));
                holder.mShareValue.setText(String.valueOf(data.get(position).getSharePercent().getNumerator()));
                holder.mMultiply.setText(String.valueOf((mCorrectionValue * data.get(position).getSharePercent().getNumerator())));

            }else if (data.get(position).getRelation().matches(OConstants.PERSON_DAUGHTER) || data.get(position).getRelation().matches(OConstants.PERSON_SISTER) || data.get(position).getRelation().matches(OConstants.PERSON_FATHER_AUNT)
                    || data.get(position).getRelation().matches(OConstants.PERSON_MOTHER_AUNT)){
                int mCorrectionValue = 1;
                holder.mCorrectionValue.setText(String.valueOf(mCorrectionValue));
                holder.mShareValue.setText(String.valueOf(data.get(position).getSharePercent().getNumerator()));
                holder.mMultiply.setText(String.valueOf((mCorrectionValue * data.get(position).getSharePercent().getNumerator())));

            }else{
                holder.mCorrectionValue.setText(String.valueOf(correctionValue));
                holder.mShareValue.setText(String.valueOf(data.get(position).getSharePercent().getNumerator()));
                holder.mMultiply.setText(String.valueOf((correctionValue * data.get(position).getSharePercent().getNumerator())));

            }

//            holder.mBoysTitle.setText(group.getBoys_relation());
//            holder.mGirlsTitle.setText(group.getGirls_relation());
//
//            String boysCount = group.getBoys_count() + " X 2";
//            String girlsCount = String.valueOf(group.getGirls_count());
//            String headsCount = String.valueOf((group.getBoys_count() * 2) + group.getGirls_count());
//
//            holder.mBoysCount.setText(boysCount);
//            holder.mGirlsCount.setText(girlsCount);
//            holder.mHeadsCount.setText(headsCount);
//
//            holder.mBoysRelation.setText(group.getSingle_boy_relation());
//
//            //Boy
//            holder.mBoysPercentNumerator.setText(String.valueOf(group.getGroupSharePercent().getNumerator()));
//            holder.mBoysPercentDenominator.setText(String.valueOf(group.getOriginalDenominator()));
//
//            holder.mBoysMultiplyPercentNumerator.setText("2");
//            holder.mBoysMultiplyPercentDenominator.setText(headsCount);
//
//            holder.mBoysMultiplyPercentResultNumerator.setText(String.valueOf(group.getBoysLatestSharePercent().getNumerator()));
//            holder.mBoysMultiplyPercentResultDenominator.setText(String.valueOf(group.getBoysLatestSharePercent().getDenominator()));
//
//            //Girl
//            holder.mGirlsRelation.setText(group.getSingle_girl_relation());
//
//            holder.mGirlsPercentNumerator.setText(String.valueOf(group.getGroupSharePercent().getNumerator()));
//            holder.mGirlsPercentDenominator.setText(String.valueOf(group.getOriginalDenominator()));
//
//            holder.mGirlsMultiplyPercentNumerator.setText("1");
//            holder.mGirlsMultiplyPercentDenominator.setText(headsCount);
//
//            holder.mGirlsMultiplyPercentResultNumerator.setText(String.valueOf(group.getGirlsLatestSharePercent().getNumerator()));
//            holder.mGirlsMultiplyPercentResultDenominator.setText(String.valueOf(group.getGirlsLatestSharePercent().getDenominator()));


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

//        @BindView(R.id.AEFSRI_boys_title)
//        TextView mBoysTitle;
//
//        @BindView(R.id.AEFSRI_girls_title)
//        TextView mGirlsTitle;
//
//
//        @BindView(R.id.AEFSRI_boys_count)
//        TextView mBoysCount;
//
//        @BindView(R.id.AEFSRI_girls_count)
//        TextView mGirlsCount;
//
//        @BindView(R.id.AEFSRI_group_total_count_result)
//        TextView mHeadsCount;
//
//        @BindView(R.id.AEFSRI_boy_relation_share_lbl)
//        TextView mBoysRelation;
//
//        @BindView(R.id.AEFSRI_boy_percent_numerator)
//        TextView mBoysPercentNumerator;
//
//        @BindView(R.id.AEFSRI_boy_percent_denominator)
//        TextView mBoysPercentDenominator;
//
//        @BindView(R.id.AEFSRI_boys_multiply_percent_numerator)
//        TextView mBoysMultiplyPercentNumerator;
//
//        @BindView(R.id.AEFSRI_boys_multiply_percent_denominator)
//        TextView mBoysMultiplyPercentDenominator;
//
//        @BindView(R.id.AEFSRI_boys_multiply_percent_result_numerator)
//        TextView mBoysMultiplyPercentResultNumerator;
//
//        @BindView(R.id.AEFSRI_boys_multiply_percent_result_denominator)
//        TextView mBoysMultiplyPercentResultDenominator;
//
//        @BindView(R.id.AEFSRI_girls_relation_share_lbl)
//        TextView mGirlsRelation;
//
//        @BindView(R.id.AEFSRI_girl_percent_numerator)
//        TextView mGirlsPercentNumerator;
//
//        @BindView(R.id.AEFSRI_girl_percent_denominator)
//        TextView mGirlsPercentDenominator;
//
//        @BindView(R.id.AEFSRI_girls_multiply_percent_numerator)
//        TextView mGirlsMultiplyPercentNumerator;
//
//        @BindView(R.id.AEFSRI_girls_multiply_percent_denominator)
//        TextView mGirlsMultiplyPercentDenominator;
//
//        @BindView(R.id.AEFSRI_girls_multiply_percent_result_numerator)
//        TextView mGirlsMultiplyPercentResultNumerator;
//
//        @BindView(R.id.AEFSRI_girls_multiply_percent_result_denominator)
//        TextView mGirlsMultiplyPercentResultDenominator;

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