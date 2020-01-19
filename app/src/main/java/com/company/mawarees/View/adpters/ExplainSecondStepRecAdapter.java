package com.company.mawarees.View.adpters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExplainSecondStepRecAdapter extends RecyclerView.Adapter<ExplainSecondStepRecAdapter.viewHolder> {

    private ArrayList<Person> people;
    private Context context;
    private int originalValue ;
    public ExplainSecondStepRecAdapter(int originalValue,ArrayList<Person> people, Context context) {
        this.people = people;
        this.context = context;
        this.originalValue = originalValue;
    }

    @NonNull
    @Override
    public ExplainSecondStepRecAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        try {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_explain_thrid_step_rv_row_item, parent, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ExplainSecondStepRecAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExplainSecondStepRecAdapter.viewHolder holder, int position) {
        try {
            if (people.get(position).getRelation().contains("ال")) {
                holder.relationTV.setText(people.get(position).getRelation());
            } else {
                holder.relationTV.setText("ال".concat(people.get(position).getRelation()));
            }

            holder.oldNumeratorTV.setText(String.valueOf(people.get(position).getOriginalSharePercent().getNumerator()));

            holder.sumNumeratorTV.setText(String.valueOf(originalValue));

            holder.resultNumeratorTV.setText(String.valueOf(people.get(position).getOriginalSharePercent().getNumerator()));
            holder.resultDenominatorTV.setText(String.valueOf(originalValue));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.step_two_rv_ri_person_relation)
        TextView relationTV;

        @BindView(R.id.step_two_rv_ri_old_percent_numerator)
        TextView oldNumeratorTV;

        @BindView(R.id.step_two_rv_ri_old_percent_denominator)
        TextView oldDenominatorTV;


        @BindView(R.id.step_two_rv_ri_old_sum_percent_numerator)
        TextView sumNumeratorTV;

        @BindView(R.id.step_two_rv_ri_old_sum_percent_denominator)
        TextView sumDenominatorTV;

        @BindView(R.id.step_two_rv_ri_percent_numerator)
        TextView resultNumeratorTV;

        @BindView(R.id.step_two_rv_ri_percent_denominator)
        TextView resultDenominatorTV;

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