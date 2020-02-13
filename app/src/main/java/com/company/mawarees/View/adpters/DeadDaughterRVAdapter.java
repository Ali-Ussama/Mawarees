package com.company.mawarees.View.adpters;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.company.mawarees.Model.Callback.DeadPersonListener;
import com.company.mawarees.Model.Models.DeadPersonModel;
import com.company.mawarees.Model.Models.Person;
import com.company.mawarees.Model.OConstants;
import com.company.mawarees.R;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.company.mawarees.Model.OConstants.PERSON_DAUGHTER_BOY;
import static com.company.mawarees.Model.OConstants.PERSON_DAUGHTER_GIRL;

public class DeadDaughterRVAdapter extends RecyclerView.Adapter<DeadDaughterRVAdapter.DeadDaughterViewHolder> {


    private static final String TAG = "DeadSonRVAdapter";
    private ArrayList<DeadPersonModel> data;
    private Context context;
    private DeadPersonListener mCallback;

    public DeadDaughterRVAdapter(ArrayList<DeadPersonModel> data, Context context, DeadPersonListener mCallback) {
        this.data = data;
        this.context = context;
        this.mCallback = mCallback;
    }

    @NonNull
    @Override
    public DeadDaughterRVAdapter.DeadDaughterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        try {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dead_daughter_row_item, parent, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DeadDaughterRVAdapter.DeadDaughterViewHolder(Objects.requireNonNull(view));
    }

    @Override
    public void onBindViewHolder(@NonNull DeadDaughterRVAdapter.DeadDaughterViewHolder holder, int position) {
        try {
            holder.mHeader.setText(context.getString(R.string.dead_daughter_number).concat(" " + (position + 1)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class DeadDaughterViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.dead_daughter_header_value_tv)
        TextView mHeader;

        @BindView(R.id.dead_daughter_boy_value_et)
        EditText mSonsET;

        @BindView(R.id.dead_daughter_girl_value_et)
        EditText mDaughtersET;

        DeadDaughterViewHolder(@NonNull View itemView) {
            super(itemView);

            try {
                ButterKnife.bind(this, itemView);

                mSonsET.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        try {
                            int mValue = 0;
                            if (!charSequence.toString().trim().isEmpty())
                                mValue = Integer.parseInt(charSequence.toString().trim());
                            Log.i(TAG, "daughter#" + (getAdapterPosition() + 1) + " boys = " + mValue);
                            createSons(mValue);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });
                mDaughtersET.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        try {
                            int value = 0;
                            if (!charSequence.toString().trim().isEmpty())
                                value = Integer.parseInt(String.valueOf(charSequence).trim());

                            Log.i(TAG, "daughter#" + (getAdapterPosition() + 1) + " girls = " + value);
                            createDaughters(value);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void createSons(int mValue) {
            int childNumber = getAdapterPosition() + 1;
            String relation = PERSON_DAUGHTER_BOY;

            ArrayList<Person> mSons = new ArrayList<>();

            for (int i = 0; i < mValue; i++) {
                Person person = new Person();
                person.setAlive(true);
                person.setCount(mValue);
                person.setDeadChildNumber(childNumber);
                person.setRelation(relation);
                person.setGender(OConstants.GENDER_MALE);
                person.setGroup(false);
                person.setId(OConstants.DEAD_DAUGHTER_BOY_ID);
                mSons.add(person);
            }

            mCallback.addChildListener(mSons, relation, childNumber,OConstants.DEAD_DAUGHTER_BOY_ID);
        }

        private void createDaughters(int mValue) {
            int childNumber = getAdapterPosition() + 1;
            String relation = PERSON_DAUGHTER_GIRL;

            ArrayList<Person> mSons = new ArrayList<>();

            for (int i = 0; i < mValue; i++) {
                Person person = new Person();
                person.setAlive(true);
                person.setCount(mValue);
                person.setDeadChildNumber(childNumber);
                person.setRelation(relation);
                person.setGender(OConstants.GENDER_FEMALE);
                person.setGroup(false);
                person.setId(OConstants.DEAD_DAUGHTER_GIRL_ID);
                mSons.add(person);
            }

            mCallback.addChildListener(mSons, relation, childNumber,OConstants.DEAD_DAUGHTER_GIRL_ID);
        }
    }
}
