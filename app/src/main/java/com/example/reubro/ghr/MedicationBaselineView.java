package com.example.reubro.ghr;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.reubro.ghr.Retrofit.Retrofitinterface;
import com.example.reubro.ghr.Retrofit.SinglePatient.Example;
import com.example.reubro.ghr.Retrofit.SinglePatient.Patient;
import com.example.reubro.ghr.Retrofit.SinglePatient.Profile;
import com.example.reubro.ghr.RoomDatabase.PatientDatabase;
import com.example.reubro.ghr.RoomDatabase.Patientadd;

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

public class MedicationBaselineView extends Fragment {




PatientDatabase patientDatabase;
    RadioGroup treatedgrowth, ghbrand, supervisedornot, interornot, didprevios;
    RadioButton yes, no, innovator, biosimilar, yesprevious, noprevious;
    RadioButton supervised, nonsuper, intermittent, continuous;
    TextView startdate, stopdate;
    TextView ghdose, ifyes, longestgap, reason;


    final public String token = "cmV1YnJvOmQ2MzU2YWQ1ZGMwYTcyMGMxOGI1M2I4ZTUzZDRjMjc0";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.medicationbaselineviewfragment, container, false);
patientDatabase=PatientDatabase.getInstance(getContext());

        treatedgrowth = (RadioGroup) view.findViewById(R.id.treatedgrowth);
        yes = (RadioButton) view.findViewById(R.id.yes);
        no = (RadioButton) view.findViewById(R.id.no);
        ghbrand = (RadioGroup) view.findViewById(R.id.ghbrandradio);
        innovator = (RadioButton) view.findViewById(R.id.innovator);
        biosimilar = (RadioButton) view.findViewById(R.id.biosimilar);


        startdate = (TextView) view.findViewById(R.id.startdatedisplay);
        stopdate = (TextView) view.findViewById(R.id.stopdatedisplay);

        ghdose = (TextView) view.findViewById(R.id.ghdoseentry);
        supervisedornot = (RadioGroup) view.findViewById(R.id.suoervisedornot);
        supervised = (RadioButton) view.findViewById(R.id.supervised);
        nonsuper = (RadioButton) view.findViewById(R.id.nonsupervised);
        interornot = (RadioGroup) view.findViewById(R.id.interornot);

        intermittent = (RadioButton) view.findViewById(R.id.intermittent);
        continuous = (RadioButton) view.findViewById(R.id.continuous);

        didprevios = (RadioGroup) view.findViewById(R.id.didpreviosoccaion);
        yesprevious = (RadioButton) view.findViewById(R.id.yesprevious);
        noprevious = (RadioButton) view.findViewById(R.id.noprevious);

        ifyes = (TextView) view.findViewById(R.id.ifyesentry);

        longestgap = (TextView) view.findViewById(R.id.longestgapentry);
        reason = (TextView) view.findViewById(R.id.reasonentry);






        int posi=getArguments().getInt("position");
        Patientadd patientadd=patientDatabase.userDao().getAll().get(posi);
        long nos=patientadd.getId();
try {

    String treated = patientDatabase.patientdiagnosisDAO().getvalue("Treated with growth hormone", nos, 6);
   yes.setClickable(false);
   no.setClickable(false);
   innovator.setClickable(false);
   biosimilar.setClickable(false);
    if (treated == "1") {

        yes.setChecked(true);
      no.setChecked(false);
    } else {
        no.setChecked(true);
        yes.setChecked(false);

    }

    String innovators = patientDatabase.patientdiagnosisDAO().getvalue("GH BRAND INNOVATOR", nos, 6);

    if (innovators == "1") {

        innovator.setChecked(true);
       biosimilar.setChecked(false);

    } else {
        biosimilar.setChecked(true);
       innovator.setChecked(false);
    }

    String startday = patientDatabase.patientdiagnosisDAO().getvalue("START DATE", nos, 6);
    startdate.setText(startday);

    String stopday = patientDatabase.patientdiagnosisDAO().getvalue("STOP DATE", nos, 6);
    stopdate.setText(stopday);

    String ghdoses = patientDatabase.patientdiagnosisDAO().getvalue("GH DOSE", nos, 6);
    ghdose.setText(ghdoses);

    String supesr = patientDatabase.patientdiagnosisDAO().getvalue("SUPERVISED", nos, 6);
   supervised.setClickable(false);
   nonsuper.setClickable(false);
    if (supesr == "1") {

        nonsuper.setEnabled(false);
        supervised.setChecked(true);

    } else {
       supervised.setChecked(false);
        nonsuper.setChecked(true);
    }

yesprevious.setClickable(false);
    noprevious.setClickable(false);
    String previioo = patientDatabase.patientdiagnosisDAO().getvalue("Has the patient received GH on previous occcassion", nos, 6);
    if (previioo == "0") {
        yesprevious.setChecked(true);
     noprevious.setChecked(false);

    } else {
       yesprevious.setChecked(false);
        noprevious.setChecked(true);
    }

    String inter=patientDatabase.patientdiagnosisDAO().getvalue("INTERMITTENT",nos,6);
    intermittent.setClickable(false);
    continuous.setClickable(false);
    if(inter=="1"){
        intermittent.setChecked(true);
     continuous.setChecked(false);
        }else {

    continuous.setChecked(true);
  intermittent.setChecked(false);
    }


    String ifyess = patientDatabase.patientdiagnosisDAO().getvalue("IF YES,DETAILS", nos, 6);
    ifyes.setText(ifyess);

    String lonnn = patientDatabase.patientdiagnosisDAO().getvalue("LONGEST GAP", nos, 6);
    longestgap.setText(lonnn);

    String reas = patientDatabase.patientdiagnosisDAO().getvalue("REASON", nos, 6);
    reason.setText(reas);


}catch (Exception e){
    e.printStackTrace();
}









        return view;
    }
}