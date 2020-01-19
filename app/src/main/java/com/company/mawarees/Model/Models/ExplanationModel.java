package com.company.mawarees.Model.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class ExplanationModel implements Parcelable {

    private ExplainPhase1 mPhase1;

    private ExplainPhase2 mPhase2;

    private ExplainPhase3 mPhase3;

    private ExplainPhase4 mPhase4;


    public ExplanationModel(Parcel in) {
        mPhase1 = in.readParcelable(ExplainPhase1.class.getClassLoader());
        mPhase2 = in.readParcelable(ExplainPhase2.class.getClassLoader());
        mPhase3 = in.readParcelable(ExplainPhase3.class.getClassLoader());
        mPhase4 = in.readParcelable(ExplainPhase4.class.getClassLoader());
    }

    public ExplanationModel() {
    }

    public static final Creator<ExplanationModel> CREATOR = new Creator<ExplanationModel>() {
        @Override
        public ExplanationModel createFromParcel(Parcel in) {
            return new ExplanationModel(in);
        }

        @Override
        public ExplanationModel[] newArray(int size) {
            return new ExplanationModel[size];
        }
    };

    public ExplainPhase1 getPhase1() {
        return mPhase1;
    }

    public void setPhase1(ExplainPhase1 mPhase1) {
        this.mPhase1 = mPhase1;
    }

    public ExplainPhase2 getPhase2() {
        return mPhase2;
    }

    public void setPhase2(ExplainPhase2 mPhase2) {
        this.mPhase2 = mPhase2;
    }

    public ExplainPhase3 getPhase3() {
        return mPhase3;
    }

    public void setPhase3(ExplainPhase3 mPhase3) {
        this.mPhase3 = mPhase3;
    }

    public ExplainPhase4 getPhase4() {
        return mPhase4;
    }

    public void setPhase4(ExplainPhase4 mPhase4) {
        this.mPhase4 = mPhase4;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(mPhase1, flags);
        dest.writeParcelable(mPhase2, flags);
        dest.writeParcelable(mPhase3, flags);
        dest.writeParcelable(mPhase4, flags);
    }
}
