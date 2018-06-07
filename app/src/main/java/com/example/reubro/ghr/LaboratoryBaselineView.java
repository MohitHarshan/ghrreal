package com.example.reubro.ghr;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.reubro.ghr.RoomDatabase.PatientDatabase;
import com.example.reubro.ghr.RoomDatabase.Patientadd;

import java.util.List;

public class LaboratoryBaselineView extends Fragment{
    TextView test1,test2,test3,test4,test5,test6,test7,test8,test9,test10,test11,test12,test13,test14,test15,test16,test17,test18,test19,test20,test21,test22,test23,test24;
    TextView datedisplay;

    PatientDatabase patientDatabase;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.laboratorybaselineview,container,false);

        patientDatabase=PatientDatabase.getInstance(getContext());



        test1=(TextView) view.findViewById(R.id.freet3entry);
        test2=(TextView)view.findViewById(R.id.freet4entry);
        test3=(TextView)view.findViewById(R.id.t3entry);
        test4=(TextView)view.findViewById(R.id.t4entry);
        test5=(TextView)view.findViewById(R.id.tbhentry);
        test6=(TextView)view.findViewById(R.id.cortisolentry);
        test7=(TextView)view.findViewById(R.id.ghbaselineentry);
        test8=(TextView)view.findViewById(R.id.ghmaximumstimulatedentry);
        test9 =(TextView)view.findViewById(R.id.bunentry);
        test10=(TextView)view.findViewById(R.id.creatinineentry);
        test11=(TextView)view.findViewById(R.id.NAentry);
        test12=(TextView)view.findViewById(R.id.Kentry);
        test13=(TextView)view.findViewById(R.id.HCO3entry);
        test14=(TextView)view.findViewById(R.id.HBentry);
        test15=(TextView)view.findViewById(R.id.waterentry);
        test16=(TextView)view.findViewById(R.id.sgptentry);
        test17=(TextView)view.findViewById(R.id.IGF1entry);
        test18=(TextView)view.findViewById(R.id.IGP3entry);
        test19=(TextView)view.findViewById(R.id.estradiolentry);
        test20=(TextView)view.findViewById(R.id.testosteroneentry);
        test21=(TextView)view.findViewById(R.id.prolactinentry);
        test22=(TextView)view.findViewById(R.id.tissueentry);
        test23=(TextView)view.findViewById(R.id.LHentry);
        test24=(TextView)view.findViewById(R.id.fshentry);
        datedisplay=(TextView)view.findViewById(R.id.datedisplayed);


        int posi = getArguments().getInt("position");

        Log.d("positions", String.valueOf(posi));
        List<Patientadd> patientadd = patientDatabase.userDao().getAll();


        String test100s=patientDatabase.patientdiagnosisDAO().getvalue("DATE",patientadd.get(posi).getId(),8);
        datedisplay.setText(test100s);



        String test1s=patientDatabase.patientdiagnosisDAO().getvalue("FREE T3",patientadd.get(posi).getId(),8);
        test1.setText(test1s);

        String test2s=patientDatabase.patientdiagnosisDAO().getvalue("FREE T4",patientadd.get(posi).getId(),8);
        test2.setText(test2s);

        String test3s=patientDatabase.patientdiagnosisDAO().getvalue("T3",patientadd.get(posi).getId(),8);
        test3.setText(test3s);

        String test4s=patientDatabase.patientdiagnosisDAO().getvalue("T4",patientadd.get(posi).getId(),8);
        test4.setText(test4s);

        String test5s=patientDatabase.patientdiagnosisDAO().getvalue("TSH",patientadd.get(posi).getId(),8);
        test5.setText(test5s);

        String test6s=patientDatabase.patientdiagnosisDAO().getvalue("CORTISOL LEVEL",patientadd.get(posi).getId(),8);
        test6.setText(test6s);

        String test7s=patientDatabase.patientdiagnosisDAO().getvalue("GH BASELINE",patientadd.get(posi).getId(),8);
        test7.setText(test7s);

        String test8s=patientDatabase.patientdiagnosisDAO().getvalue("GH MAXIMUM STIMULATED",patientadd.get(posi).getId(),8);
        test8.setText(test8s);

        String test9s=patientDatabase.patientdiagnosisDAO().getvalue("BUN",patientadd.get(posi).getId(),8);
        test9.setText(test9s);

        String test10s=patientDatabase.patientdiagnosisDAO().getvalue("CREATININE",patientadd.get(posi).getId(),8);
        test10.setText(test10s);

        String test11s=patientDatabase.patientdiagnosisDAO().getvalue("NA+",patientadd.get(posi).getId(),8);
        test11.setText(test11s);

        String test12s=patientDatabase.patientdiagnosisDAO().getvalue("K+",patientadd.get(posi).getId(),8);
        test12.setText(test12s);

        String test13s=patientDatabase.patientdiagnosisDAO().getvalue("HCO3-",patientadd.get(posi).getId(),8);
        test13.setText(test13s);

        String test14s=patientDatabase.patientdiagnosisDAO().getvalue("HB",patientadd.get(posi).getId(),8);
        test14.setText(test14s);

        String test15s=patientDatabase.patientdiagnosisDAO().getvalue("WATER DEPRIVATION TEST",patientadd.get(posi).getId(),8);
        test15.setText(test15s);

        String test16s=patientDatabase.patientdiagnosisDAO().getvalue("SGPT",patientadd.get(posi).getId(),8);
        test16.setText(test16s);

        String test17s=patientDatabase.patientdiagnosisDAO().getvalue("IGF-1",patientadd.get(posi).getId(),8);
        test17.setText(test17s);

        String test18s=patientDatabase.patientdiagnosisDAO().getvalue("IGBP3",patientadd.get(posi).getId(),8);
        test18.setText(test18s);

        String test19s=patientDatabase.patientdiagnosisDAO().getvalue("Estradiol",patientadd.get(posi).getId(),8);
        test19.setText(test19s);

        String test20s=patientDatabase.patientdiagnosisDAO().getvalue("Testosterone",patientadd.get(posi).getId(),8);
        test20.setText(test20s);

        String test21s=patientDatabase.patientdiagnosisDAO().getvalue("Prolactin",patientadd.get(posi).getId(),8);
        test21.setText(test21s);

        String test22s=patientDatabase.patientdiagnosisDAO().getvalue("Tissue Transglutaminase",patientadd.get(posi).getId(),8);
        test22.setText(test22s);

        String test23s=patientDatabase.patientdiagnosisDAO().getvalue("LH",patientadd.get(posi).getId(),8);
        test23.setText(test23s);

        String test24s=patientDatabase.patientdiagnosisDAO().getvalue("FSH",patientadd.get(posi).getId(),8);
        test24.setText(test24s);





        return view;
    }
}
