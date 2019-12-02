package com.company.mawarees.Model.Callback;

import com.company.mawarees.Model.Models.ProofModel;

import java.util.ArrayList;

public interface DatabaseListener {

    void onReadProofs(ArrayList<ProofModel> proof);

}
