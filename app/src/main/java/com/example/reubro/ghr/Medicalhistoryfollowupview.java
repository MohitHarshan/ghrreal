package com.example.reubro.ghr;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.reubro.ghr.Retrofit.SinglePatient.Patient;
import com.example.reubro.ghr.Retrofit.SinglePatient.Profile;
import com.example.reubro.ghr.RoomDatabase.PatientDatabase;

import java.util.List;

public class Medicalhistoryfollowupview extends Fragment {
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
        View view=inflater.inflate(R.layout.activity_medicalhistoryfollowupview,container,false);
        patientDatabase = PatientDatabase.getInstance(getContext());
        pubertyradio = (RadioGroup) view.findViewById(R.id.pubertyradio);
        checkyes = (RadioButton) view.findViewById(R.id.checkyes);
        checkno = (RadioButton) view.findViewById(R.id.checkno);
        relevant = (TextView) view.findViewById(R.id.relevantentry);
        previous = (TextView) view.findViewById(R.id.previoussurgeryentry);
        clinical = (TextView) view.findViewById(R.id.clinicalfeaturesentry);






        int posi=getArguments().getInt("position");
        long patinetno=getArguments().getLong("patientno");

        Log.d("GETTING POSITION",String.valueOf(posi));
        Log.d("GETTING PATIENTNO",String.valueOf(patinetno));


try {
    String pubeentry = patientDatabase.followupDAO().getvalue("PUBERTAL STATUS", (posi + 1), patinetno, 4);
checkyes.setClickable(false);
checkno.setClickable(false);

    if (pubeentry == "1") {

        checkyes.setChecked(true);
        checkno.setChecked(false);

    } else {

        checkyes.setChecked(false);
        checkno.setChecked(true);

    }

    String relevants=patientDatabase.followupDAO().getvalue("ANY OTHER RELEVANT MEDICAL HISTORY",(posi+1),patinetno,4);
    relevant.setText(relevants);


    String pre=patientDatabase.followupDAO().getvalue("ANY PREVIOUS SURGERIES",(posi+1),patinetno,4);
    previous.setText(pre);



    String clinicals=patientDatabase.followupDAO().getvalue("CLINICAL FEATURES",(posi+1),patinetno,4);
    clinical.setText(clinicals);



}catch (Exception e) {
e.printStackTrace();

}


        return view;
    }
}
