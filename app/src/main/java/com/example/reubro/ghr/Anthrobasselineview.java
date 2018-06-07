package com.example.reubro.ghr;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.reubro.ghr.RoomDatabase.PatientDatabase;
import com.example.reubro.ghr.RoomDatabase.Patientadd;

public class Anthrobasselineview extends Fragment {
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
        View view=inflater.inflate(R.layout.anthropometrybaselineviewfragmanet,container,false);



        patientDatabase=PatientDatabase.getInstance(getContext());


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
        Patientadd patientadd=patientDatabase.userDao().getAll().get(posi);
        long nos=patientadd.getId();


try {
    String heights = patientDatabase.patientdiagnosisDAO().getvalue("HEIGHT", nos, 7);
    height.setText(heights);

    String weights = patientDatabase.patientdiagnosisDAO().getvalue("WEIGHT", nos, 7);
    weight.setText(weights);

    String bmis = patientDatabase.patientdiagnosisDAO().getvalue("BMI", nos, 7);
    bmientry.setText(bmis);

    String bestt = patientDatabase.patientdiagnosisDAO().getvalue("BREASTS", nos, 7);
    breasts.setText(bestt);

    String pubics = patientDatabase.patientdiagnosisDAO().getvalue("PUBIC HAIR", nos, 7);
    pubic.setText(pubics);

    String auxxx = patientDatabase.patientdiagnosisDAO().getvalue("AUXILLARY HAIR", nos, 7);
    aux.setText(auxxx);

    String men = patientDatabase.patientdiagnosisDAO().getvalue("MENARCHE", nos, 7);
    if (men == "1") {

        menarcheyes.setChecked(true);
        menarcheyes.setEnabled(false);
    } else {

        menarchno.setChecked(true);
        menarchno.setEnabled(false);

    }

}catch (Exception e){
    e.printStackTrace();
}


        return view;
    }
}
