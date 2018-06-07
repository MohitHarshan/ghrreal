package com.example.reubro.ghr;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.reubro.ghr.RoomDatabase.PatientDatabase;

public class Anthropometrymalefollowview extends Fragment {
    TextView height,weight,testvolentry,pubic,aux;
    TextView bmientry;

    PatientDatabase patientDatabase;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_anthropometrymalefollowview,container,false);

        height=(TextView) view.findViewById(R.id.heightentry);
        weight=(TextView)view.findViewById( R.id.weightentry);
        testvolentry=(TextView) view.findViewById(R.id.testvolumeentry);
        pubic=(TextView)view.findViewById(R.id.pubic);
        aux=(TextView) view.findViewById(R.id.auxsdisplay);
        bmientry=(TextView)view.findViewById(R.id.bmientry);



        patientDatabase=PatientDatabase.getInstance(getContext());


        int posi=getArguments().getInt("position");
        long patinetno=getArguments().getLong("patientno");



        try {
            String heights = patientDatabase.followupDAO().getvalue("HEIGHT", (posi + 1), patinetno, 7);
            height.setText(heights);

            String weights = patientDatabase.followupDAO().getvalue("WEIGHT", (posi + 1), patinetno, 7);
            weight.setText(weights);

            String testi = patientDatabase.followupDAO().getvalue("TESTICULAR VOLUME", (posi + 1), patinetno, 7);
            testvolentry.setText(testi);


            String pubi = patientDatabase.followupDAO().getvalue("PUBIC HAIR", (posi + 1), patinetno, 7);
            pubic.setText(pubi);

            String auxx = patientDatabase.followupDAO().getvalue("AUXILLARY HAIR", (posi + 1), patinetno, 7);
            aux.setText(auxx);

            String bmy = patientDatabase.followupDAO().getvalue("BMI", (posi + 1), patinetno, 7);
            bmientry.setText(bmy);

        }

        catch (Exception e)
        {
            e.printStackTrace();
        }






        return view;
    }
}
