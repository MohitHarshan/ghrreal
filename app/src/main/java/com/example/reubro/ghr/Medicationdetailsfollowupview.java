package com.example.reubro.ghr;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reubro.ghr.Retrofit.SinglePatient.Patient;
import com.example.reubro.ghr.RoomDatabase.Medicationdetailsmedicine;
import com.example.reubro.ghr.RoomDatabase.Medicinesfollowup;
import com.example.reubro.ghr.RoomDatabase.PatientDatabase;

import java.util.ArrayList;
import java.util.List;

public class Medicationdetailsfollowupview extends Fragment {
    RecyclerView recyclerView;
    PatientDatabase patientDatabase;
    List<Medicinesfollowup> medLists=new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_medicationdetailsfollowupview,container,false);



        patientDatabase=PatientDatabase.getInstance(getContext());

        recyclerView=(RecyclerView)view.findViewById(R.id.medicinebaselinerecycler);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);



        int posi=getArguments().getInt("position");
        long patinetno=getArguments().getLong("patientno");




        medLists=patientDatabase.medicinesfollowupDAO().getmeds(patinetno,(posi+1));
            Log.d("SIZE OF MEDICINE LIST",String.valueOf(medLists.size()));

         MedicineviewfollowRecycler adapter=new MedicineviewfollowRecycler(medLists,getContext());

        recyclerView.setAdapter(adapter);
adapter.notifyDataSetChanged();







        return view;

    }
}
