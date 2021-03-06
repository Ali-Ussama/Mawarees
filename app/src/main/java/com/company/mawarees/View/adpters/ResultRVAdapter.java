package com.company.mawarees.View.adpters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.company.mawarees.Model.Callback.ItemSelectedListener;
import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultRVAdapter extends RecyclerView.Adapter<ResultRVAdapter.viewHolder> {

    private static final String TAG = "ResultRVAdapter";
    private ArrayList<Person> data;
    private Context mContext;
    private ItemSelectedListener mListener;

    private Person selectedPerson;

    public ResultRVAdapter(ArrayList<Person> data, Context mContext, ItemSelectedListener mListener) {
        this.data = data;
        this.mContext = mContext;
        this.mListener = mListener;
        selectedPerson = data.get(0);
    }

    @NonNull
    @Override
    public ResultRVAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        try {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_result_people_row_item, parent, false);
            if (view == null)
                Log.i(TAG, "onCreateViewHolder(): view is null");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultRVAdapter.viewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_result_people_row_item, parent, false));
    }

    public void setSelectedPerson(Person mSelectedPerson) {
        this.selectedPerson = mSelectedPerson;
    }

    @Override
    public void onBindViewHolder(@NonNull ResultRVAdapter.viewHolder holder, int position) {
        try {

            Log.i(TAG, "onBindViewHolder is Called");

            if (selectedPerson != null) {
                if (!data.get(position).getRelation().matches(selectedPerson.getRelation())) {
//
                    holder.mPersonNameTV.setBackgroundColor(mContext.getResources().getColor(R.color.orange));
                    holder.mPersonNameTV.setTextColor(mContext.getResources().getColor(R.color.white));
                    holder.mPersonNameTV.setText(data.get(position).getRelation());

                } else {
                    holder.mPersonNameTV.setBackgroundColor(mContext.getResources().getColor(R.color.grey));
                    holder.mPersonNameTV.setTextColor(mContext.getResources().getColor(R.color.orange));
                    holder.mPersonNameTV.setText(data.get(position).getRelation());
                }
            } else {
                holder.mPersonNameTV.setText(data.get(position).getRelation());
            }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.rv_result_people_row_item_person_name_lbl)
        TextView mPersonNameTV;

        viewHolder(@NonNull View itemView) {
            super(itemView);

            try {
                Log.i(TAG, "viewHolder is Called");

                ButterKnife.bind(this, itemView);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Log.i(TAG, "itemView onClickListener is called");
                            mListener.onItemSelected(data.get(getAdapterPosition()), getAdapterPosition());
                            notifyDataSetChanged();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Log.i(TAG, "mPersonNameTV onClickListener is called");


                            mPersonNameTV.setBackgroundColor(mContext.getResources().getColor(R.color.grey));
                            selectedPerson = data.get(getAdapterPosition());
                            mListener.onItemSelected(data.get(getAdapterPosition()), getAdapterPosition());
                            notifyDataSetChanged();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
