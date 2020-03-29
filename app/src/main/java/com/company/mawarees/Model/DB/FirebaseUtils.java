package com.company.mawarees.Model.DB;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.company.mawarees.Model.Callback.DatabaseListener;
import com.company.mawarees.Model.Models.ProofModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

public class FirebaseUtils {

    private FirebaseFirestore db;
    private Context context;
    private DBProcess mDBProcess;
    private DatabaseListener listener;

    private String collection = "people";

    public FirebaseUtils(Context context, DatabaseListener listener) {
        this.db = FirebaseFirestore.getInstance();
        this.context = context;
        this.mDBProcess = new DBProcess(this.context);
        this.listener = listener;
    }

    public void readDataFromFireStore(String religion) {
        try {
            db.collection(collection).addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                    if (e == null && queryDocumentSnapshots != null) {
                        ArrayList<ProofModel> result = new ArrayList<>();
                        for (QueryDocumentSnapshot queryDocumentSnapshot : queryDocumentSnapshots) {
                            Map<String, Object> data = queryDocumentSnapshot.getData();
                            for (String key : data.keySet()) {
                                ProofModel proof = new ProofModel();
                                proof.setId(queryDocumentSnapshot.getId());
                                proof.setRelation(queryDocumentSnapshot.getId());
                                proof.setReligion(religion);
                                proof.setKey(key);
                                proof.setValue(String.valueOf(data.get(key)));
                                result.add(proof);
                            }
                        }

                        if (!result.isEmpty()) {
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    mDBProcess.insert(result);
                                }
                            }).start();

                            if (listener != null) {
                                listener.onReadProofs(result);
                            }
                        }
                    } else {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
