package com.example.reubro.ghr;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.reubro.ghr.RoomDatabase.PatientDatabase;
import com.example.reubro.ghr.RoomDatabase.Patientadd;

public class Anthrofollowupview extends Fragment {
    TextView height,weight;
    TextView breasts,pubic,aux;
    TextView bmientry;
    Button bmicaalc,sumbitanthro;
    RadioGroup menarche;
    RadioButton menarcheyes,menarchno;
    int menarches;

    PatientDatabase patientDatabase;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_anthrofollowupview,container,false);

        height=(TextView) view.findViewById(R.id.heightentry);
        weight=(TextView) view.findViewById( R.id.weightentry);
        breasts=(TextView)view.findViewById(R.id.breastspinner);
        pubic=(TextView)view.findViewById(R.id.pubicspinner);
        aux=(TextView)view.findViewById(R.id.auxspinner);
        bmientry=(TextView)view.findViewById(R.id.bmientry);

        menarche=(RadioGroup)view.findViewById(R.id.menarche);
        menarcheyes=(RadioButton)view.findViewById(R.id.menarcheyes);
        menarchno=(RadioButton)view.findViewById(R.id.menarcheno);

        int posi=getArguments().getInt("position");
        long patinetno=getArguments().getLong("patientno");

        patientDatabase=PatientDatabase.getInstance(getContext());
Log.d("PUSITION",String.valueOf(posi));
        Log.d("Patientno",String.valueOf(patinetno));


            String heights = patientDatabase.followupDAO().getvalue("HEIGHT", (posi + 1), patinetno, 7);
            height.setText(heights);


            String weights = patientDatabase.followupDAO().getvalue("WEIGHT", (posi + 1), patinetno, 7);
            weight.setText(weights);

            String breastss = patientDatabase.followupDAO().getvalue("BREASTS", (posi + 1), patinetno, 7);
            breasts.setText(breastss);

            String pubics = patientDatabase.followupDAO().getvalue("PUBIC HAIR", (posi + 1), patinetno, 7);
            pubic.setText(pubics);

            String auxy = patientDatabase.followupDAO().getvalue("AUXILLARY HAIR", (posi + 1), patinetno, 7);
            aux.setText(auxy);


            String bmy = patientDatabase.followupDAO().getvalue("BMI", (posi + 1), patinetno, 7);
            bmientry.setText(bmy);


            String menarches = patientDatabase.followupDAO().getvalue("MENARCHE", (posi + 1), patinetno, 7);

            if (menarches == "1") {
                menarcheyes.setChecked(true);
                menarcheyes.setEnabled(false);
                menarchno.setEnabled(false);
            } else {
                menarchno.setEnabled(false);
                menarchno.setChecked(true);
                menarcheyes.setEnabled(false);
            }


    




        return view;
    }
}
