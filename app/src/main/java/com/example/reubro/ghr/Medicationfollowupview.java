package com.example.reubro.ghr;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.reubro.ghr.RoomDatabase.PatientDatabase;

public class Medicationfollowupview extends Fragment {


    PatientDatabase patientDatabase;
    RadioGroup treatedgrowth, ghbrand, supervisedornot, interornot, didprevios;
    RadioButton yes, no, innovator, biosimilar, yesprevious, noprevious;
    RadioButton supervised, nonsuper, intermittent, continuous;
    TextView startdate, stopdate;
    TextView ghdose, ifyes, longestgap, reason;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_medicationfollowupview,container,false);

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
        long patinetno=getArguments().getLong("patientno");


try {

    String treats = patientDatabase.followupDAO().getvalue("Treated with growth hormone", (posi + 1), patinetno, 6);
   yes.setClickable(false);
   no.setClickable(false);

    if (treats == "1") {

        yes.setChecked(true);
     no.setChecked(false);
    } else {
        no.setChecked(true);
       yes.setChecked(false);
    }


    String inno = patientDatabase.followupDAO().getvalue("INNOVATOR", (posi + 1), patinetno, 6);
innovator.setClickable(false);
biosimilar.setClickable(false);
    if (inno == "1") {

        innovator.setChecked(true);
biosimilar.setChecked(false);
    } else {

        biosimilar.setChecked(true);
       innovator.setChecked(false);
    }


    String starts = patientDatabase.followupDAO().getvalue("START DATE", (posi + 1), patinetno, 6);
    startdate.setText(starts);

    String stops = patientDatabase.followupDAO().getvalue("STOP DATE", (posi + 1), patinetno, 6);
    startdate.setText(stops);


    String ghdoses = patientDatabase.followupDAO().getvalue("GH DOSE", (posi + 1), patinetno, 6);
    ghdose.setText(ghdoses);

    String sper = patientDatabase.followupDAO().getvalue("SUPERVISED", (posi + 1), patinetno, 6);
nonsuper.setClickable(false);
supervised.setClickable(false);
    if (sper == "1") {

     nonsuper.setChecked(false);
        supervised.setChecked(true);
    } else {

        supervised.setChecked(false);
        nonsuper.setChecked(true);
    }


    String inter = patientDatabase.followupDAO().getvalue("INTERMITTENT", (posi + 1), patinetno, 6);

   continuous.setClickable(false);
   intermittent.setClickable(false);
    if (inter == "1") {

       continuous.setChecked(false);
        intermittent.setChecked(true);

    } else {
       intermittent.setChecked(false);
        continuous.setChecked(true);

    }


    String previo = patientDatabase.followupDAO().getvalue("Has the patient received GH on previous occcassion", (posi + 1), patinetno, 6);
   yesprevious.setClickable(false);
   noprevious.setClickable(false);

    if (previo == "1") {
noprevious.setChecked(false);
        yesprevious.setChecked(true);

    } else {
     yesprevious.setChecked(false);
        noprevious.setChecked(true);
    }


    String ifyeses = patientDatabase.followupDAO().getvalue("IF YES,DETAILS", (posi + 1), patinetno, 6);

    ifyes.setText(ifyeses);


    String longs = patientDatabase.followupDAO().getvalue("LONGEST GAP", (posi + 1), patinetno, 6);
    longestgap.setText(longs);

    String reas = patientDatabase.followupDAO().getvalue("REASON", (posi + 1), patinetno, 6);
    reason.setText(reas);


}catch (Exception e){

    e.printStackTrace();
}
        return  view;
    }
}
