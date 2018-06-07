package com.example.reubro.ghr;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

/**
 * Created by reubro on 4/5/18.
 */

public class Medicalhistorbaseline extends Fragment {

    RadioGroup pubertyradio;
    RadioButton checkyes, checkno;

    Profile profile = new Profile();
    String status, message;
    String patientid;
    PatientDatabase patientDatabase;
    List<Patient> patient;
    TextView relevant, previous, clinical;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.medicalhistorybaselineview, container, false);


        patientDatabase = PatientDatabase.getInstance(getContext());
        pubertyradio = (RadioGroup) view.findViewById(R.id.pubertyradio);
        checkyes = (RadioButton) view.findViewById(R.id.checkyes);
        checkno = (RadioButton) view.findViewById(R.id.checkno);
        relevant = (TextView) view.findViewById(R.id.relevantentry);
        previous = (TextView) view.findViewById(R.id.previoussurgeryentry);
        clinical = (TextView) view.findViewById(R.id.clinicalfeaturesentry);


        int posi = getArguments().getInt("position");

        Log.d("positions", String.valueOf(posi));
        List<com.example.reubro.ghr.RoomDatabase.Patientadd> patientadd = patientDatabase.userDao().getAll();

try {


    String checkyes1 = patientDatabase.patientdiagnosisDAO().getvalue("PUBERTAL STATUS", patientadd.get(posi).getId(), 4);
checkyes.setClickable(false);
checkyes.setClickable(false);
    if (checkyes1.equals("1")) {
        checkyes.setChecked(true);
      checkno.setChecked(false);
    } else {
        checkyes.setChecked(false);
    checkno.setChecked(true);
    }


    String relevants = patientDatabase.patientdiagnosisDAO().getvalue("ANY OTHER RELEVANT MEDICAL HISTORY", patientadd.get(posi).getId(), 4);
    relevant.setText(relevants);

    String previo = patientDatabase.patientdiagnosisDAO().getvalue("ANY PREVIOUS SURGERIES", patientadd.get(posi).getId(), 4);
    previous.setText(previo);


    String clinicals = patientDatabase.patientdiagnosisDAO().getvalue("CLINICAL FEATURES", patientadd.get(posi).getId(), 4);
    clinical.setText(clinicals);
}catch (Exception e){
    e.printStackTrace();
}

        return view;
    }


}