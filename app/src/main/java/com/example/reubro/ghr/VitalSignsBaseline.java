package com.example.reubro.ghr;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.TextView;

import com.example.reubro.ghr.Retrofit.Retrofitinterface;
import com.example.reubro.ghr.Retrofit.SinglePatient.Example;
import com.example.reubro.ghr.Retrofit.SinglePatient.Patient;
import com.example.reubro.ghr.Retrofit.SinglePatient.Profile;
import com.example.reubro.ghr.RoomDatabase.PatientDatabase;

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

public class VitalSignsBaseline extends android.support.v4.app.Fragment {
TextView pulse,systolic,diastolic;
    List<Patient> patient;
    Profile profile=new Profile();
    String status,message;
    String patientid;
    PatientDatabase patientDatabase;
    final public String token = "cmV1YnJvOmQ2MzU2YWQ1ZGMwYTcyMGMxOGI1M2I4ZTUzZDRjMjc0";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.vitalsignsbaselineviewfragment,container,false);

       pulse=(TextView)view.findViewById(R.id.pulseeentry);
       systolic=(TextView)view.findViewById(R.id.systolicentry);
        diastolic=(TextView)view.findViewById(R.id.diastolicentry);

patientDatabase=PatientDatabase.getInstance(getContext());


        List<com.example.reubro.ghr.RoomDatabase.Patientadd> patientadd=patientDatabase.userDao().getAll();


        int posi=getArguments().getInt("position");

        int counts=patientDatabase.userDao().countpatients();


        String pulses=patientDatabase.patientdiagnosisDAO().getvalue("PULSE",patientadd.get(posi).getId(),3);
        pulse.setText(pulses);

        String systolics=patientDatabase.patientdiagnosisDAO().getvalue("BP SYSTOLIC",patientadd.get(posi).getId(),3);
        systolic.setText(systolics);

        String diastolics=patientDatabase.patientdiagnosisDAO().getvalue("BP SYSTOLIC",patientadd.get(posi).getId(),3);
        diastolic.setText(diastolics);








        return view;
    }

    private class display extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... voids) {


            List<com.example.reubro.ghr.RoomDatabase.Patientadd> patientadd=patientDatabase.userDao().getAll();


            int posi=getArguments().getInt("position");

            int counts=patientDatabase.userDao().countpatients();


            Log.d("COUNTS PF PATIENTS",String.valueOf(counts));


            Log.d("POSITION IS########",String.valueOf(posi));




            String pulses=patientDatabase.patientdiagnosisDAO().getvalue("PULSE",patientadd.get(posi).getId(),3);
            pulse.setText(pulses);

            String systolics=patientDatabase.patientdiagnosisDAO().getvalue("BP SYSTOLIC",patientadd.get(posi).getId(),3);
            systolic.setText(systolics);

            String diastolics=patientDatabase.patientdiagnosisDAO().getvalue("BP SYSTOLIC",patientadd.get(posi).getId(),3);
            diastolic.setText(diastolics);


            return null;


        }
    }
}
