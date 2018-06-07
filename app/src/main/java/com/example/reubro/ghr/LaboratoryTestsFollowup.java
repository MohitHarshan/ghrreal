package com.example.reubro.ghr;

import android.app.DatePickerDialog;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reubro.ghr.RoomDatabase.Followup;
import com.example.reubro.ghr.RoomDatabase.PatientDatabase;

import java.util.Calendar;
import java.util.TimeZone;

public class LaboratoryTestsFollowup extends Fragment {
    Button choosedate,submit;
    EditText test1,test2,test3,test4,test5,test6,test7,test8,test9,test10,test11,test12,test13,test14,test15,test16,test17,test18,test19,test20,test21,test22,test23,test24;
    TextView datedisplay;
    private int startYear = 1999, starthMonth = 1, startDay = 1;
    PatientDatabase patientDatabase;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_laboratory_tests_followup, container, false);

        patientDatabase=PatientDatabase.getInstance(getContext());
        choosedate=(Button)view.findViewById(R.id.datechoose);
        submit=(Button)view.findViewById(R.id.sumbit);

        test1=(EditText)view.findViewById(R.id.freet3entry);
        test2=(EditText)view.findViewById(R.id.freet4entry);
        test3=(EditText)view.findViewById(R.id.t3entry);
        test4=(EditText)view.findViewById(R.id.t4entry);
        test5=(EditText)view.findViewById(R.id.tbhentry);
        test6=(EditText)view.findViewById(R.id.cortisolentry);
        test7=(EditText)view.findViewById(R.id.ghbaselineentry);
        test8=(EditText)view.findViewById(R.id.ghmaximumstimulatedentry);
        test9 =(EditText)view.findViewById(R.id.bunentry);
        test10=(EditText)view.findViewById(R.id.creatinineentry);
        test11=(EditText)view.findViewById(R.id.NAentry);
        test12=(EditText)view.findViewById(R.id.Kentry);
        test13=(EditText)view.findViewById(R.id.HCO3entry);
        test14=(EditText)view.findViewById(R.id.HBentry);
        test15=(EditText)view.findViewById(R.id.waterentry);
        test16=(EditText)view.findViewById(R.id.sgptentry);
        test17=(EditText)view.findViewById(R.id.IGF1entry);
        test18=(EditText)view.findViewById(R.id.IGP3entry);
        test19=(EditText)view.findViewById(R.id.estradiolentry);
        test20=(EditText)view.findViewById(R.id.testosteroneentry);
        test21=(EditText)view.findViewById(R.id.prolactinentry);
        test22=(EditText)view.findViewById(R.id.tissueentry);
        test23=(EditText)view.findViewById(R.id.LHentry);
        test24=(EditText)view.findViewById(R.id.fshentry);
        datedisplay=(TextView)view.findViewById(R.id.datedisplayed);
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        final DatePickerDialog datePickerDialog =  new DatePickerDialog(
                getActivity(),datePickerListener, startYear, starthMonth, startDay);
        choosedate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new insert().execute();
                getActivity().finish();

            }
        });


        return view;
    }
    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {


        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            String year1 = String.valueOf(selectedYear);
            String month1 = String.valueOf(selectedMonth + 1);
            String day1 = String.valueOf(selectedDay);

            datedisplay.setText(day1 + "/" + month1 + "/" + year1);

        }
    };

    private class insert extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... voids) {


            String dates=datedisplay.getText().toString();
            String tests1=test1.getText().toString();
            String tests2=test2.getText().toString();
            String tests3=test3.getText().toString();
            String tests4=test4.getText().toString();
            String tests5=test5.getText().toString();
            String tests6=test6.getText().toString();
            String tests7=test7.getText().toString();
            String tests8=test8.getText().toString();
            String tests9=test9.getText().toString();
            String tests10=test10.getText().toString();
            String tests11=test11.getText().toString();
            String tests12=test12.getText().toString();
            String tests13=test13.getText().toString();
            String tests14=test14.getText().toString();
            String tests15=test15.getText().toString();
            String tests16=test16.getText().toString();
            String tests17=test17.getText().toString();
            String tests18=test18.getText().toString();
            String tests19=test19.getText().toString();
            String tests20=test20.getText().toString();
            String tests21=test21.getText().toString();
            String tests22=test22.getText().toString();
            String tests23=test23.getText().toString();
            String tests24=test24.getText().toString();






            int count=getArguments().getInt("followupcount");



            int posi=getArguments().getInt("position");

            int counts=patientDatabase.followupDAO().counts(patientDatabase.userDao().getAll().get(posi).getId());

            Followup followup100=new Followup();
            followup100.setCategoryid(8);
            followup100.setCount(count);
            followup100.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup100.setSubcategorytitle("DATE");
            followup100.setSubcategoryvalue(dates);
            patientDatabase.followupDAO().insertsingle(followup100);

            Followup followup=new Followup();
            followup.setCategoryid(8);
            followup.setCount(count);
            followup.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup.setSubcategorytitle("FREE T3");
            followup.setSubcategoryvalue(tests1);
            patientDatabase.followupDAO().insertsingle(followup);

            Followup followup1=new Followup();
            followup1.setCategoryid(8);
            followup1.setCount(count);
            followup1.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup1.setSubcategorytitle("FREE T4");
            followup1.setSubcategoryvalue(tests2);
            patientDatabase.followupDAO().insertsingle(followup1);

            Followup followup2=new Followup();
            followup2.setCategoryid(8);
            followup2.setCount(count);
            followup2.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup2.setSubcategorytitle("T3");
            followup2.setSubcategoryvalue(tests3);
            patientDatabase.followupDAO().insertsingle(followup2);

            Followup followup3=new Followup();
            followup3.setCategoryid(8);
            followup3.setCount(count);
            followup3.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup3.setSubcategorytitle("T3");
            followup3.setSubcategoryvalue(tests4);
            patientDatabase.followupDAO().insertsingle(followup3);

            Followup followup4=new Followup();
            followup4.setCategoryid(8);
            followup4.setCount(count);
            followup4.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup4.setSubcategorytitle("TSH");
            followup4.setSubcategoryvalue(tests5);
            patientDatabase.followupDAO().insertsingle(followup4);

            Followup followup5=new Followup();
            followup5.setCategoryid(8);
            followup5.setCount(count);
            followup5.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup5.setSubcategorytitle("CORTISOL LEVEL");
            followup5.setSubcategoryvalue(tests6);
            patientDatabase.followupDAO().insertsingle(followup5);

            Followup followup6=new Followup();
            followup6.setCategoryid(8);
            followup6.setCount(count);
            followup6.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup6.setSubcategorytitle("GH BASELINE");
            followup6.setSubcategoryvalue(tests7);
            patientDatabase.followupDAO().insertsingle(followup6);

            Followup followup7=new Followup();
            followup7.setCategoryid(8);
            followup7.setCount(count);
            followup7.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup7.setSubcategorytitle("GH MAXIMUM STIMULATED");
            followup7.setSubcategoryvalue(tests8);
            patientDatabase.followupDAO().insertsingle(followup7);

            Followup followup8=new Followup();
            followup8.setCategoryid(8);
            followup8.setCount(count);
            followup8.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup8.setSubcategorytitle("BUN");
            followup8.setSubcategoryvalue(tests9);
            patientDatabase.followupDAO().insertsingle(followup8);


            Followup followup9=new Followup();
            followup9.setCategoryid(8);
            followup9.setCount(count);
            followup9.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup9.setSubcategorytitle("CREATININE");
            followup9.setSubcategoryvalue(tests10);
            patientDatabase.followupDAO().insertsingle(followup9);

            Followup followup10=new Followup();
            followup10.setCategoryid(8);
            followup10.setCount(count);
            followup10.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup10.setSubcategorytitle("NA+");
            followup10.setSubcategoryvalue(tests11);
            patientDatabase.followupDAO().insertsingle(followup10);

            Followup followup11=new Followup();
            followup11.setCategoryid(8);
            followup11.setCount(count);
            followup11.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup11.setSubcategorytitle("K+");
            followup11.setSubcategoryvalue(tests12);
            patientDatabase.followupDAO().insertsingle(followup11);

            Followup followup12=new Followup();
            followup12.setCategoryid(8);
            followup12.setCount(count);
            followup12.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup12.setSubcategorytitle("HCO3-");
            followup12.setSubcategoryvalue(tests13);
            patientDatabase.followupDAO().insertsingle(followup12);

            Followup followup13=new Followup();
            followup13.setCategoryid(8);
            followup13.setCount(count);
            followup13.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup13.setSubcategorytitle("HB");
            followup13.setSubcategoryvalue(tests14);
            patientDatabase.followupDAO().insertsingle(followup13);

            Followup followup14=new Followup();
            followup14.setCategoryid(8);
            followup14.setCount(count);
            followup14.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup14.setSubcategorytitle("WATER DEPRIVATION TEST");
            followup14.setSubcategoryvalue(tests15);
            patientDatabase.followupDAO().insertsingle(followup14);

            Followup followup15=new Followup();
            followup15.setCategoryid(8);
            followup15.setCount(count);
            followup15.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup15.setSubcategorytitle("SGPT");
            followup15.setSubcategoryvalue(tests16);
            patientDatabase.followupDAO().insertsingle(followup15);

            Followup followup16=new Followup();
            followup16.setCategoryid(8);
            followup16.setCount(count);
            followup16.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup16.setSubcategorytitle("IGF-1");
            followup16.setSubcategoryvalue(tests17);
            patientDatabase.followupDAO().insertsingle(followup16);

            Followup followup17=new Followup();
            followup17.setCategoryid(8);
            followup17.setCount(count);
            followup17.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup17.setSubcategorytitle("IGBP3");
            followup17.setSubcategoryvalue(tests18);
            patientDatabase.followupDAO().insertsingle(followup17);

            Followup followup18=new Followup();
            followup18.setCategoryid(8);
            followup18.setCount(count);
            followup18.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup18.setSubcategorytitle("Estradiol");
            followup18.setSubcategoryvalue(tests19);
            patientDatabase.followupDAO().insertsingle(followup18);

            Followup followup19=new Followup();
            followup19.setCategoryid(8);
            followup19.setCount(count);
            followup19.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup19.setSubcategorytitle("Testosterone");
            followup19.setSubcategoryvalue(tests20);
            patientDatabase.followupDAO().insertsingle(followup19);

            Followup followup20=new Followup();
            followup20.setCategoryid(8);
            followup20.setCount(count);
            followup20.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup20.setSubcategorytitle("Prolactin");
            followup20.setSubcategoryvalue(tests21);
            patientDatabase.followupDAO().insertsingle(followup20);

            Followup followup21=new Followup();
            followup21.setCategoryid(8);
            followup21.setCount(count);
            followup21.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup21.setSubcategorytitle("Tissue Transglutaminase");
            followup21.setSubcategoryvalue(tests22);
            patientDatabase.followupDAO().insertsingle(followup21);

            Followup followup22=new Followup();
            followup22.setCategoryid(8);
            followup22.setCount(count);
            followup22.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup22.setSubcategorytitle("LH");
            followup22.setSubcategoryvalue(tests23);
            patientDatabase.followupDAO().insertsingle(followup22);

            Followup followup23=new Followup();
            followup23.setCategoryid(8);
            followup23.setCount(count);
            followup23.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup23.setSubcategorytitle("FSH");
            followup23.setSubcategoryvalue(tests24);
            patientDatabase.followupDAO().insertsingle(followup23);


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(getContext(),"Success",Toast.LENGTH_SHORT).show();
            submit.setEnabled(false);
        }
    }
}
