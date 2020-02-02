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

import static com.company.mawarees.Model.OConstants.PERSON_SON_BOY;
import static com.company.mawarees.Model.OConstants.PERSON_SON_GIRL;

public class DeadSonRVAdapter extends RecyclerView.Adapter<DeadSonRVAdapter.DeadSonViewHolder> {

    private static final String TAG = "DeadSonRVAdapter";
    private ArrayList<DeadPersonModel> data;
    private Context context;
    private DeadPersonListener mCallback;

    public DeadSonRVAdapter(ArrayList<DeadPersonModel> data, Context context, DeadPersonListener mCallback) {
        this.data = data;
        this.context = context;
        this.mCallback = mCallback;
    }

    @NonNull
    @Override
    public DeadSonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        try {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dead_son_dialog_row_item, parent, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DeadSonViewHolder(Objects.requireNonNull(view));
    }

    @Override
    public void onBindViewHolder(@NonNull DeadSonViewHolder holder, int position) {
        try {
            holder.mHeader.setText(context.getString(R.string.dead_child_number).concat(" " + (position + 1)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class DeadSonViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.dead_son_header_value_tv)
        TextView mHeader;

        @BindView(R.id.dead_son_boy_value_et)
        EditText mSonsET;

        @BindView(R.id.dead_son_girl_value_et)
        EditText mDaughtersET;

        DeadSonViewHolder(@NonNull View itemView) {
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

                            Log.i(TAG, " son#" + (getAdapterPosition() + 1) + " boys = " + mValue);
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
                            int mValue = 0;
                            if (!charSequence.toString().trim().isEmpty())
                                mValue = Integer.parseInt(charSequence.toString().trim());
                            Log.i(TAG, " son#" + (getAdapterPosition() + 1) + " girls = " + mValue);
                            createDaughters(mValue);
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
            String relation = PERSON_SON_BOY;

            ArrayList<Person> mSons = new ArrayList<>();

            for (int i = 0; i < mValue; i++) {
                Person person = new Person();
                person.setAlive(true);
                person.setCount(mValue);
                person.setDeadSonNumber(childNumber);
                person.setRelation(relation);
                person.setGender(OConstants.GENDER_MALE);
                person.setGroup(false);
                mSons.add(person);
            }

            mCallback.addChildListener(mSons, relation, childNumber,OConstants.DEAD_SON_BOY_ID);
        }

        private void createDaughters(int mValue) {
            int childNumber = getAdapterPosition() + 1;
            String relation = PERSON_SON_GIRL;

            ArrayList<Person> mSons = new ArrayList<>();

            for (int i = 0; i < mValue; i++) {
                Person person = new Person();
                person.setAlive(true);
                person.setCount(mValue);
                person.setDeadSonNumber(childNumber);
                person.setRelation(relation);
                person.setGender(OConstants.GENDER_FEMALE);
                person.setGroup(false);
                person.setId(OConstants.DEAD_SON_BOY_ID);
                mSons.add(person);
            }

            mCallback.addChildListener(mSons, relation, childNumber,OConstants.DEAD_SON_GIRL_ID);
        }
    }
}
