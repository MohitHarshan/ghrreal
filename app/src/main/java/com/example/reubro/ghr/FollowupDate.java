package com.example.reubro.ghr;

import android.app.DatePickerDialog;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reubro.ghr.RoomDatabase.Followup;
import com.example.reubro.ghr.RoomDatabase.PatientDatabase;
import com.example.reubro.ghr.RoomDatabase.Patientadd;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class FollowupDate extends Fragment {

 public    TextView date;
    Button choose,submit;
    private int startYear = 1999, starthMonth = 1, startDay = 1;
    PatientDatabase patientDatabase;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.activity_followup_date,container,false);
patientDatabase=PatientDatabase.getInstance(getContext());


       date=(TextView)view.findViewById(R.id.datedisplay);
       choose=(Button)view.findViewById(R.id.datechoose);
submit=(Button)view.findViewById(R.id.submit);

        final ViewPager viewPager=getActivity().findViewById(R.id.container);
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        final DatePickerDialog datePickerDialog =  new DatePickerDialog(
                getActivity(),datePickerListener, startYear, starthMonth, startDay);
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });

submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        new store().execute();
        viewPager.setCurrentItem(1);
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

                date.setText(day1 + "/" + month1 + "/" + year1);

        }
    };















    private class store extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void... voids) {

          List<Patientadd> patientaddList=patientDatabase.userDao().getAll();


           int count=getArguments().getInt("followupcount");


            int posi=getArguments().getInt("position");
            Log.d("POSSSS",String.valueOf(posi));

            String nasmee=patientDatabase.userDao().getAll().get(posi).getName();
            Log.d("NAMEEE##",nasmee);
            int counts=patientDatabase.followupDAO().counts(patientaddList.get(posi).getId());
            Log.d("COUNTED",String.valueOf(counts+count));
            Log.d("COUNTS PLUS OE",String.valueOf(counts+1));


            String dates=date.getText().toString();

            Followup followup=new Followup();
            followup.setDate(dates);
            followup.setCount(count);
            followup.setCategoryid(1);
            followup.setPatientno(patientaddList.get(posi).getId());
             patientDatabase.followupDAO().insertsingle(followup);

             VitalSignsFollowup vitalSignsFollowup=new VitalSignsFollowup();
             Bundle b=new Bundle();
             b.putInt("followupcount",count);
             b.putString("date",dates);
             Log.d("FOLLOWUP COUNTS",String .valueOf(count));
             vitalSignsFollowup.setArguments(b);

            MedicalhistoryFollowup medicalhistoryFollowup=new MedicalhistoryFollowup();
            medicalhistoryFollowup.setArguments(b);

            MedicationdetailsFollowup medicationdetailsFollowup=new MedicationdetailsFollowup();
            medicationdetailsFollowup.setArguments(b);

            MedicationFollowup medicationFollowup=new MedicationFollowup();
            medicationFollowup.setArguments(b);

            LaboratoryTestsFollowup laboratoryTestsFollowup=new LaboratoryTestsFollowup();
            laboratoryTestsFollowup.setArguments(b);

            AnthropometryFollowup anthropometryFollowup=new AnthropometryFollowup();
            anthropometryFollowup.setArguments(b);

            AnthropometrymaleFollowup anthropometrymaleFollowup=new AnthropometrymaleFollowup();
            anthropometrymaleFollowup.setArguments(b);



             return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(getContext(), "Successfully submitted", Toast.LENGTH_SHORT).show();
            submit.setEnabled(false);
        }


    }




}

