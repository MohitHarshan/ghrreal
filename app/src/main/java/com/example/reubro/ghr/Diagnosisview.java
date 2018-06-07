package com.example.reubro.ghr;

import android.icu.text.LocaleDisplayNames;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

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
 * Created by reubro on 2/5/18.
 */

public class Diagnosisview extends Fragment {

    CheckBox check1, check2, check3, check4, check5, check6, check7, check8, check9;

    List<Patient> patient;
    PatientDatabase patientDatabase;
    String patientid;
    String check1s, check2s, check3s, check4s, check5s, check6s, check7s, check8s, check9s;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.diagnosisviewfragment, container, false);

        check1 = (CheckBox) view.findViewById(R.id.check1);
        check2 = (CheckBox) view.findViewById(R.id.check2);
        check3 = (CheckBox) view.findViewById(R.id.check3);
        check4 = (CheckBox) view.findViewById(R.id.check4);
        check5 = (CheckBox) view.findViewById(R.id.check5);
        check6 = (CheckBox) view.findViewById(R.id.check6);
        check7 = (CheckBox) view.findViewById(R.id.check7);
        check8 = (CheckBox) view.findViewById(R.id.check8);
        check9 = (CheckBox) view.findViewById(R.id.check9);


        patientDatabase = PatientDatabase.getInstance(getContext());

        int posi = getArguments().getInt("position");
        List<com.example.reubro.ghr.RoomDatabase.Patientadd> patientadd = patientDatabase.userDao().getAll();
        Log.d("pos", String.valueOf(posi));


        check1s = patientDatabase.patientdiagnosisDAO().getvalue("Paediatric growth hormone deficiency", patientadd.get(posi).getId(), 2);

        check2s = patientDatabase.patientdiagnosisDAO().getvalue("Adult growth hormone deficiency", patientadd.get(posi).getId(), 2);
        Log.d("Check12", check2s);


        check3s = patientDatabase.patientdiagnosisDAO().getvalue("Turner syndrome", patientadd.get(posi).getId(), 2);
        Log.d("Check3", check3s);



        check4s = patientDatabase.patientdiagnosisDAO().getvalue("Prader-Willi syndrome", patientadd.get(posi).getId(), 2);
        Log.d("Check4", check4s);

        check5s = patientDatabase.patientdiagnosisDAO().getvalue("Small for gestational age", patientadd.get(posi).getId(), 2);
        Log.d("Check5", check5s);

        check6s = patientDatabase.patientdiagnosisDAO().getvalue("Chronic renal insufficiency", patientadd.get(posi).getId(), 2);


        check7s = patientDatabase.patientdiagnosisDAO().getvalue("SHOX syndrome", patientadd.get(posi).getId(), 2);
        Log.d("Check7", check7s);



        check8s = patientDatabase.patientdiagnosisDAO().getvalue("Idiopathic short stature", patientadd.get(posi).getId(), 2);
        Log.d("Check8", check8s);

        check9s = patientDatabase.patientdiagnosisDAO().getvalue("Others", patientadd.get(posi).getId(), 2);
        Log.d("Check9", check9s);


        checkboxvalueset(check1,check1s);
        checkboxvalueset(check2,check2s);
        checkboxvalueset(check3,check3s);
        checkboxvalueset(check4,check4s);
        checkboxvalueset(check5,check5s);
        checkboxvalueset(check6,check6s);
        checkboxvalueset(check7,check7s);
        checkboxvalueset(check8,check8s);
        checkboxvalueset(check9,check9s);





        return view;
    }






    private void checkboxvalueset(CheckBox checkbox,String dbvalue){

        if(dbvalue.equals("1")){
            checkbox.setChecked(true);

        }else {checkbox.setChecked(false);

        }checkbox.setClickable(false);
    }
}
