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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reubro.ghr.RoomDatabase.Followup;
import com.example.reubro.ghr.RoomDatabase.PatientDatabase;

public class AnthropometrymaleFollowup extends Fragment {
    EditText height,weight,testvolentry;
    Spinner pubic,aux;
    TextView bmientry;
    Button bmicaalc,sumbit;
    PatientDatabase patientDatabase;
    String[] pubics={"Stage 1","Stage 2","Stage 3","Stage 4","Stage 5"};
    String[] auxs={"Stage 1","Stage 2","Stage 3"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_anthropometrymale_followup, container, false);
final ViewPager viewPager=getActivity().findViewById(R.id.container);


        height=(EditText)view.findViewById(R.id.heightentry);
        weight=(EditText)view.findViewById( R.id.weightentry);
        testvolentry=(EditText) view.findViewById(R.id.testvolumeentry);
        pubic=(Spinner)view.findViewById(R.id.pubicspinner);
        aux=(Spinner)view.findViewById(R.id.auxspinner);
        bmientry=(TextView)view.findViewById(R.id.bmientry);
        bmicaalc=(Button)view.findViewById(R.id.calcbmi);
        sumbit=(Button)view.findViewById(R.id.submit);

        patientDatabase=PatientDatabase.getInstance(getContext());
        ArrayAdapter<String> adabrepub=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,pubics);
        adabrepub.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        pubic.setAdapter(adabrepub);

        ArrayAdapter<String> adaux=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,auxs);
        adabrepub.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        aux.setAdapter(adaux);


        bmicaalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    final String heightt = height.getText().toString();
                    final String weightt = weight.getText().toString();

                    Float heights = Float.parseFloat(heightt);
                    Float weights = Float.parseFloat(weightt);
                    Float bmi;

                    bmi = ((weights / (heights * heights)));

                    bmientry.setText(String.valueOf(bmi));

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


        sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new insert().execute();
                viewPager.setCurrentItem(6);
            }
        });













        return view;
    }

    private class insert extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void... voids) {

            String heights=height.getText().toString();
            String weights=weight.getText().toString();
            String bmiss=bmientry.getText().toString();
            String testicular=testvolentry.getText().toString();



            int count=getArguments().getInt("followupcount");



            int posi=getArguments().getInt("position");


            Followup followup=new Followup();
            followup.setCategoryid(7);
            followup.setCount(count);
            followup.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup.setSubcategorytitle("HEIGHT");
            followup.setSubcategoryvalue(heights);
            patientDatabase.followupDAO().insertsingle(followup);

            Followup followup1=new Followup();
            followup1.setCategoryid(7);
            followup1.setCount(count);
            followup1.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup1.setSubcategorytitle("WEIGHT");
            followup1.setSubcategoryvalue(weights);
            patientDatabase.followupDAO().insertsingle(followup1);

            Followup followup2=new Followup();
            followup2.setCategoryid(7);
            followup2.setCount(count);
            followup2.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup2.setSubcategorytitle("BMI");
            followup2.setSubcategoryvalue(bmiss);
            patientDatabase.followupDAO().insertsingle(followup2);

            Followup followup3=new Followup();
            followup3.setCategoryid(7);
            followup3.setCount(count);
            followup3.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup3.setSubcategorytitle("TESTICULAR VOLUME");
            followup3.setSubcategoryvalue(String.valueOf(testicular));
            patientDatabase.followupDAO().insertsingle(followup3);

            Followup followup4=new Followup();
            followup4.setCategoryid(7);
            followup4.setCount(count);
            followup4.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup4.setSubcategorytitle("PUBIC HAIR");
            followup4.setSubcategoryvalue(pubic.getSelectedItem().toString());
            patientDatabase.followupDAO().insertsingle(followup4);

            Followup followup5=new Followup();
            followup5.setCategoryid(7);
            followup5.setCount(count);
            followup5.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup5.setSubcategorytitle("AUXILLARY HAIR");
            followup5.setSubcategoryvalue(aux.getSelectedItem().toString());
            patientDatabase.followupDAO().insertsingle(followup5);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(getContext(),"Succcessfully submitted",Toast.LENGTH_SHORT).show();
            sumbit.setEnabled(false);
        }
    }
}
