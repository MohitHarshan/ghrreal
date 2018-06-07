package com.example.reubro.ghr;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.reubro.ghr.RoomDatabase.Followup;
import com.example.reubro.ghr.RoomDatabase.PatientDatabase;

public class MedicalhistoryFollowup extends Fragment {
    RadioGroup pubertyradio;
    RadioButton checkyes,checknp;
    EditText relevant,previous,clinical;
    Button submit;
    PatientDatabase patientDatabase;
    public String puberty,relevants,previosse,clinicals;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_medicalhistory_followup, container, false);
final ViewPager viewPager=getActivity().findViewById(R.id.container);

        pubertyradio=(RadioGroup)view.findViewById(R.id.pubertyradio);
        checkyes=(RadioButton)view.findViewById(R.id.checkyes);
        checknp=(RadioButton)view.findViewById(R.id.checkno);
        relevant=(EditText)view.findViewById(R.id.relevantentry);
        previous=(EditText)view.findViewById(R.id.previoussurgeryentry);
        clinical=(EditText)view.findViewById(R.id.clinicalfeaturesentry);
        submit=(Button)view.findViewById(R.id.submitmedicalhistory);

        patientDatabase=PatientDatabase.getInstance(getContext());

submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        new store().execute();
        viewPager.setCurrentItem(3);

    }
});
        if(checkyes.isChecked()){
            puberty="1";

        }else puberty="0";








        return view;
    }

    private class store extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... voids) {




            relevants=relevant.getText().toString();
            previosse=previous.getText().toString();
            clinicals=clinical.getText().toString();




            int count=getArguments().getInt("followupcount");



            int posi=getArguments().getInt("position");
int counts=patientDatabase.followupDAO().counts(patientDatabase.userDao().getAll().get(posi).getId());



            Followup followup=new Followup();
            followup.setCategoryid(4);
            followup.setCount(count);
            followup.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup.setSubcategorytitle("PUBERTAL STATUS");
            followup.setSubcategoryvalue(puberty);
            patientDatabase.followupDAO().insertsingle(followup);

            Followup followup1=new Followup();
            followup1.setCategoryid(4);
            followup1.setCount(count);
            followup1.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup1.setSubcategorytitle("CLINICAL FEATURES");
            followup1.setSubcategoryvalue(clinicals);
            patientDatabase.followupDAO().insertsingle(followup1);

            Followup followup2=new Followup();
            followup2.setCategoryid(4);
            followup2.setCount(count);
            followup2.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup2.setSubcategorytitle("ANY PREVIOUS SURGERIES");
            followup2.setSubcategoryvalue(previosse);
            patientDatabase.followupDAO().insertsingle(followup2);

            Followup followup3=new Followup();
            followup3.setCategoryid(4);
            followup3.setCount(count);
            followup3.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup3.setSubcategorytitle("ANY OTHER RELEVANT MEDICAL HISTORY");
            followup3.setSubcategoryvalue(relevants);
            patientDatabase.followupDAO().insertsingle(followup3);










            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(getContext(),"Successfully submitted",Toast.LENGTH_LONG).show();
            submit.setEnabled(false);
        }
    }
}
