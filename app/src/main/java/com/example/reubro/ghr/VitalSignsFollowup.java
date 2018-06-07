package com.example.reubro.ghr;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.reubro.ghr.RoomDatabase.*;

public class VitalSignsFollowup extends Fragment {


    PatientDatabase patientDatabase;

    EditText pulse,bpsystolic,bpdiastolic;
    Button submitvital;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_vital_signs_followup, container, false);

      patientDatabase=PatientDatabase.getInstance(getContext());


final ViewPager viewPager=getActivity().findViewById(R.id.container);

        pulse=(EditText)view.findViewById(R.id.pulseeentry);
        bpsystolic=(EditText)view.findViewById(R.id.systolicentry);
        bpdiastolic=(EditText)view.findViewById(R.id.diastolicentry);


        submitvital=(Button)view.findViewById(R.id.submitvital);


     submitvital.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
              new Store().execute();
              viewPager.setCurrentItem(2);
         }
     });



        return view;




    }

    private class Store extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void... voids) {

            com.example.reubro.ghr.RoomDatabase.Patientadd patientadd=patientDatabase.userDao().getlast();


            int count=getArguments().getInt("followupcount");

String pulses=pulse.getText().toString();
String bpsysy=bpsystolic.getText().toString();
String dias=bpdiastolic.getText().toString();

            int posi=getArguments().getInt("position");
            int counts=patientDatabase.followupDAO().counts(patientDatabase.userDao().getAll().get(posi).getId());
            Log.d("CONTSS",String.valueOf(count+counts));

            String patientid=getArguments().getString("patientid");
            Followup followup=new Followup();
            followup.setCategoryid(3);
            followup.setCount(count);
            followup.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup.setSubcategorytitle("PULSE");
            followup.setSubcategoryvalue(pulses);
            patientDatabase.followupDAO().insertsingle(followup);

            Followup followup1=new Followup();
            followup1.setCategoryid(3);
            followup1.setCount(count);
            followup1.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup1.setSubcategorytitle("BP SYSTOLIC");
            followup1.setSubcategoryvalue(bpsysy);
            patientDatabase.followupDAO().insertsingle(followup1);

            Followup followup2=new Followup();
            followup2.setCategoryid(3);
            followup2.setCount(count);
            followup2.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup2.setSubcategorytitle("BP DIASTOLIC");
            followup2.setSubcategoryvalue(dias);
            patientDatabase.followupDAO().insertsingle(followup2);






            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(getContext(),"Successfully submitted",Toast.LENGTH_SHORT).show();

            submitvital.setEnabled(false);
        }
    }
}