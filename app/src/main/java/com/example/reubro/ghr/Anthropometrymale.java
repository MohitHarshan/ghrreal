package com.example.reubro.ghr;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
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
import android.widget.Toast;

import com.example.reubro.ghr.RoomDatabase.PatientDatabase;
import com.example.reubro.ghr.RoomDatabase.PatientDiagnosis;

/**
 * Created by reubro on 30/4/18.
 */

public class Anthropometrymale  extends android.support.v4.app.Fragment {
    EditText height,weight,testvolentry;
    Spinner pubic,aux;
    TextView bmientry;
    Button bmicaalc,sumbit;
PatientDatabase patientDatabase;
    String[] pubics={"Stage 1","Stage 2","Stage 3","Stage 4","Stage 5"};
    String[] auxs={"Stage 1","Stage 2","Stage 3"};

    public Anthropometrymale() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.anthropometrymalefragment,container,false);
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
                  viewPager.setCurrentItem(7);
            }
        });






        return view;
    }

    private class insert extends AsyncTask<Void,Void,Void>{



        String heights=height.getText().toString();
        String weights=weight.getText().toString();
        String bmiss=bmientry.getText().toString();
        String testicular=testvolentry.getText().toString();
        String patientid=getArguments().getString("patientid");
        com.example.reubro.ghr.RoomDatabase.Patientadd patientadd1 = patientDatabase.userDao().getlast();




        @Override
        protected Void doInBackground(Void... voids) {


            PatientDiagnosis patientDiagnosis=new PatientDiagnosis();
            patientDiagnosis.setCategoryid(7);
            patientDiagnosis.setPatientnumber(patientadd1.getId());
            patientDiagnosis.setPatientid(patientid);
            patientDiagnosis.setSubcategorytitle("HEIGHT");
            patientDiagnosis.setSubcategoryvalue(heights);
            patientDatabase.patientdiagnosisDAO().insertsingle(patientDiagnosis);

            PatientDiagnosis patientDiagnosis1=new PatientDiagnosis();
            patientDiagnosis1.setCategoryid(7);
            patientDiagnosis1.setPatientnumber(patientadd1.getId());
            patientDiagnosis1.setPatientid(patientid);
            patientDiagnosis1.setSubcategorytitle("WEIGHT");
            patientDiagnosis1.setSubcategoryvalue(weights);
            patientDatabase.patientdiagnosisDAO().insertsingle(patientDiagnosis1);

            PatientDiagnosis patientDiagnosis2=new PatientDiagnosis();
            patientDiagnosis2.setCategoryid(7);
            patientDiagnosis2.setPatientnumber(patientadd1.getId());
            patientDiagnosis2.setPatientid(patientid);
            patientDiagnosis2.setSubcategorytitle("BMI");
            patientDiagnosis2.setSubcategoryvalue(bmiss);
            patientDatabase.patientdiagnosisDAO().insertsingle(patientDiagnosis2);

            PatientDiagnosis patientDiagnosis3=new PatientDiagnosis();
            patientDiagnosis3.setCategoryid(7);
            patientDiagnosis3.setPatientnumber(patientadd1.getId());
            patientDiagnosis3.setPatientid(patientid);
            patientDiagnosis3.setSubcategorytitle("TESTICULAR VOLUME");
            patientDiagnosis3.setSubcategoryvalue(String.valueOf(testicular));
            patientDatabase.patientdiagnosisDAO().insertsingle(patientDiagnosis3);


            PatientDiagnosis patientDiagnosis4=new PatientDiagnosis();
            patientDiagnosis4.setCategoryid(7);
            patientDiagnosis4.setPatientnumber(patientadd1.getId());
            patientDiagnosis4.setPatientid(patientid);
            patientDiagnosis4.setSubcategorytitle("PUBIC HAIR");
            patientDiagnosis4.setSubcategoryvalue(pubic.getSelectedItem().toString());
            patientDatabase.patientdiagnosisDAO().insertsingle(patientDiagnosis4);

            PatientDiagnosis patientDiagnosis5=new PatientDiagnosis();
            patientDiagnosis5.setCategoryid(7);
            patientDiagnosis5.setPatientnumber(patientadd1.getId());
            patientDiagnosis5.setPatientid(patientid);
            patientDiagnosis5.setSubcategorytitle("AUXILLARY HAIR");
            patientDiagnosis5.setSubcategoryvalue(aux.getSelectedItem().toString());
            patientDatabase.patientdiagnosisDAO().insertsingle(patientDiagnosis5);














            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(getContext(),"Successfully submitted",Toast.LENGTH_SHORT).show();
            sumbit.setEnabled(false);
        }
    }
}
