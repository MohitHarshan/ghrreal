package com.example.reubro.ghr;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.reubro.ghr.Retrofit.SinglePatient.Patient;
import com.example.reubro.ghr.Retrofit.SinglePatient.Profile;
import com.example.reubro.ghr.RoomDatabase.PatientDatabase;

import java.util.List;

public class Vitalsignsfollowupview extends Fragment {
    TextView pulse,systolic,diastolic;
    List<Patient> patient;
    Profile profile=new Profile();
    String status,message;
    String patientid;
    PatientDatabase patientDatabase;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_vitalsignsfollowupview,container,false);

        pulse=(TextView)view.findViewById(R.id.pulseeentry);
        systolic=(TextView)view.findViewById(R.id.systolicentry);
        diastolic=(TextView)view.findViewById(R.id.diastolicentry);

        patientDatabase=PatientDatabase.getInstance(getContext());
        List<com.example.reubro.ghr.RoomDatabase.Patientadd> patientadd=patientDatabase.userDao().getAll();


        int posi=getArguments().getInt("position");
        long patinetno=getArguments().getLong("patientno");

        Log.d("GETTING POSITION",String.valueOf(posi));
        Log.d("GETTING PATIENTNO",String.valueOf(patinetno));

        String pulses=patientDatabase.followupDAO().getvalue("PULSE",(posi+1),patinetno,3);
        pulse.setText(pulses);

        String bpsystolics=patientDatabase.followupDAO().getvalue("BP SYSTOLIC",(posi+1),patinetno,3);
        systolic.setText(bpsystolics);

        String bpdiastolics=patientDatabase.followupDAO().getvalue("BP DIASTOLIC",(posi+1),patinetno,3);
        diastolic.setText(bpdiastolics);








        return view;
    }


}
