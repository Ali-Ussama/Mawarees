package com.company.mawarees.View.adpters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExplainFirstStepRecAdapter extends RecyclerView.Adapter<ExplainFirstStepRecAdapter.viewHolder> {

    private ArrayList<Person> people;
    private Context context;

    public ExplainFirstStepRecAdapter(ArrayList<Person> people, Context context) {
        this.people = people;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        try {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_explain_first_step_rv_row_item, parent, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        try {

            if (people.get(position).getRelation().contains("ال")){
                holder.relationTV.setText(people.get(position).getRelation());
            }else {
                holder.relationTV.setText("ال".concat(people.get(position).getRelation()));
            }
            holder.numeratorTV.setText(String.valueOf(people.get(position).getOriginalSharePercent().getNumerator()));
            holder.denominatorTV.setText(String.valueOf(people.get(position).getOriginalSharePercent().getDenominator()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.step_one_rv_ri_person_relation)
        TextView relationTV;

        @BindView(R.id.step_one_rv_ri_original_percent_numerator)
        TextView numeratorTV;

        @BindView(R.id.step_one_rv_ri_original_percent_denominator)
        TextView denominatorTV;

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
