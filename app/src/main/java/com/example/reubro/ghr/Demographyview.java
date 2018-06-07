package com.example.reubro.ghr;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.reubro.ghr.Retrofit.Retrofitinterface;
import com.example.reubro.ghr.Retrofit.SinglePatient.Profile;
import com.example.reubro.ghr.RoomDatabase.*;

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
 * Created by reubro on 2/5/18.
 */

public class Demographyview extends android.support.v4.app.Fragment {
    TextView gender, dob, bmi;
    TextView gestational, currentheight, currentweight, fathersheight, mothersheight, birthlenght, birthweight, midparentalheight;
    final public String token = "cmV1YnJvOmQ2MzU2YWQ1ZGMwYTcyMGMxOGI1M2I4ZTUzZDRjMjc0";
   List<com.example.reubro.ghr.Retrofit.SinglePatient.Patient> patient;
   PatientDatabase patientDatabase;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.demographybaselineview, container, false);
        String patientid=getArguments().getString("patientid");
           Log.d("Patient id",patientid.toString());
        gender = (TextView) view.findViewById(R.id.genderdisplay);
        dob = (TextView) view.findViewById(R.id.dobdatedisplay);
        bmi = (TextView) view.findViewById(R.id.bmidisplay);
        gestational = (TextView) view.findViewById(R.id.gestationalageentry);
        currentheight = (TextView) view.findViewById(R.id.currentheightentry);
        currentweight = (TextView) view.findViewById(R.id.currentweighteentry);
        fathersheight = (TextView) view.findViewById(R.id.fathersheightentry);
        mothersheight = (TextView) view.findViewById(R.id.mothersheightentry);



        birthlenght = (TextView) view.findViewById(R.id.birthlengthentry);
        birthweight = (TextView) view.findViewById(R.id.birthweightentry);
        midparentalheight = (TextView) view.findViewById(R.id.midparentalentry);

        patientDatabase=PatientDatabase.getInstance(getContext());

        List<com.example.reubro.ghr.RoomDatabase.Patientadd> patientadd=patientDatabase.userDao().getAll();





        int posi=getArguments().getInt("position");

        int counts=patientDatabase.userDao().countpatients();


        Log.d("COUNTS PF PATIENTS",String.valueOf(counts));


        Log.d("POSITION IS########",String.valueOf(posi));




        String genders=patientDatabase.patientdiagnosisDAO().getvalue("GENDER",patientadd.get(posi).getId(),1);

        gender.setText(genders);

        String dobs=patientDatabase.patientdiagnosisDAO().getvalue("DOB",patientadd.get(posi).getId(),1);
        dob.setText(dobs);

        String bmis=patientDatabase.patientdiagnosisDAO().getvalue("BMI",patientadd.get(posi).getId(),1);
        bmi.setText(bmis);


        String gestationals=patientDatabase.patientdiagnosisDAO().getvalue("GESTATIONAL AGE",patientadd.get(posi).getId(),1);
        gestational.setText(gestationals);

        String currentheights=patientDatabase.patientdiagnosisDAO().getvalue("CURRENT HEIGHT",patientadd.get(posi).getId(),1);
        currentheight.setText(currentheights);

        String currentweights=patientDatabase.patientdiagnosisDAO().getvalue("CURRENT WEIGHT",patientadd.get(posi).getId(),1);
        currentweight.setText(currentweights);

        String fathersheights=patientDatabase.patientdiagnosisDAO().getvalue("FATHER'S HEIGHT",patientadd.get(posi).getId(),1);
        fathersheight.setText(fathersheights);

        String motherhrights=patientDatabase.patientdiagnosisDAO().getvalue("MOTHER'S HEIGHT",patientadd.get(posi).getId(),1);
        mothersheight.setText(motherhrights);


        String birthlenghts=patientDatabase.patientdiagnosisDAO().getvalue("BIRTH LENGHT",patientadd.get(posi).getId(),1);
        birthlenght.setText(birthlenghts);

        String birthweights=patientDatabase.patientdiagnosisDAO().getvalue("BIRTH WEIGHT",patientadd.get(posi).getId(),1);
        birthweight.setText(birthweights);

        String mids=patientDatabase.patientdiagnosisDAO().getvalue("MIDPARENTAL HEIGHT",patientadd.get(posi).getId(),1);
        midparentalheight.setText(mids);


        return view;
    }





}



