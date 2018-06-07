package com.example.reubro.ghr;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;

import com.example.reubro.ghr.RoomDatabase.PatientDatabase;
import com.example.reubro.ghr.RoomDatabase.Patientadd;

import java.util.List;

public class Anthropometrymalebaseline extends Fragment{
    TextView height,weight,testvolentry,pubic,aux;
    TextView bmientry;

    PatientDatabase patientDatabase;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.anthropometrymaleview,container,false);

        height=(TextView) view.findViewById(R.id.heightentry);
        weight=(TextView)view.findViewById( R.id.weightentry);
        testvolentry=(TextView) view.findViewById(R.id.testvolumeentry);
        pubic=(TextView)view.findViewById(R.id.pubic);
        aux=(TextView) view.findViewById(R.id.auxsdisplay);
        bmientry=(TextView)view.findViewById(R.id.bmientry);



        patientDatabase=PatientDatabase.getInstance(getContext());


        List<Patientadd> patientadd=patientDatabase.userDao().getAll();


        int posi=getArguments().getInt("position");
try {
    String heights = patientDatabase.patientdiagnosisDAO().getvalue("HEIGHT", patientadd.get(posi).getId(), 7);
    height.setText(heights);

    String weights = patientDatabase.patientdiagnosisDAO().getvalue("WEIGHT", patientadd.get(posi).getId(), 7);
    weight.setText(heights);


    String bmis = patientDatabase.patientdiagnosisDAO().getvalue("BMI", patientadd.get(posi).getId(), 7);
    bmientry.setText(bmis);

    String test = patientDatabase.patientdiagnosisDAO().getvalue("TESTICULAR VOLUME", patientadd.get(posi).getId(), 7);
    testvolentry.setText(test);

    String pube = patientDatabase.patientdiagnosisDAO().getvalue("PUBIC HAIR", patientadd.get(posi).getId(), 7);
    pubic.setText(pube);


    String auxy = patientDatabase.patientdiagnosisDAO().getvalue("AUXILLARY HAIR", patientadd.get(posi).getId(), 7);
    aux.setText(auxy);

}catch (Exception e){
    e.printStackTrace();
}




        return view;
    }
}
