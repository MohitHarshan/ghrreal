package com.example.reubro.ghr;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reubro.ghr.Retrofit.Retrofitinterface;
import com.example.reubro.ghr.Retrofit.SinglePatient.Example;
import com.example.reubro.ghr.Retrofit.SinglePatient.MedicationTakenInPast;
import com.example.reubro.ghr.Retrofit.SinglePatient.Patient;
import com.example.reubro.ghr.Retrofit.SinglePatient.Profile;
import com.example.reubro.ghr.RoomDatabase.Medicationdetailsmedicine;
import com.example.reubro.ghr.RoomDatabase.PatientDatabase;
import com.example.reubro.ghr.RoomDatabase.Patientadd;
import com.example.reubro.ghr.Utils.MedList;
import com.example.reubro.ghr.Utils.MedicineRecycler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by reubro on 8/5/18.
 */

public class Medicationdetailsbaseline extends Fragment {
RecyclerView recyclerView;
List<Patient> patient;

PatientDatabase patientDatabase;
    List<Medicationdetailsmedicine> medLists=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.miedicationdetailsbaselineview,container,false);
patientDatabase=PatientDatabase.getInstance(getContext());

        recyclerView=(RecyclerView)view.findViewById(R.id.medicinebaselinerecycler);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);



int posi=getArguments().getInt("position");
Patientadd patientadd=patientDatabase.userDao().getAll().get(posi);
                long no=patientadd.getId();
medLists=patientDatabase.medicineDAO().findByid(no);
        final MedicineviewRecycler adapter=new MedicineviewRecycler(medLists,getContext());
                recyclerView.setAdapter(adapter);





        return view;
    }
}
