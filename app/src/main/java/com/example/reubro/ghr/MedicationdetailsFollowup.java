package com.example.reubro.ghr;

import android.app.DatePickerDialog;
import android.content.Context;
import android.icu.text.UnicodeSetSpanner;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reubro.ghr.RoomDatabase.Followup;
import com.example.reubro.ghr.RoomDatabase.Medicationdetailsmedicine;
import com.example.reubro.ghr.RoomDatabase.Medicinesfollowup;
import com.example.reubro.ghr.RoomDatabase.PatientDatabase;
import com.example.reubro.ghr.RoomDatabase.Patientadd;
import com.example.reubro.ghr.Utils.MedList;
import com.example.reubro.ghr.Utils.MedicineRecycler;

import java.util.ArrayList;
import java.util.List;

public class MedicationdetailsFollowup extends Fragment implements Addmeddialog.OnInputSelected{
    private List<MedList> medicines=new ArrayList<>();
    Context context;

    RecyclerView medrecycler;
    Button add,submit;
    Button choosedate;
    TextView datedisplay;
    private int startYear = 1999, starthMonth = 1, startDay = 1;
    PatientDatabase patientDatabase;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_medicationdetails_followup, container, false);

        add=(Button)view.findViewById(R.id.addmedicinebutton);
        medrecycler=(RecyclerView)view.findViewById(R.id.medicinereycler);
        final ViewPager viewPager=getActivity().findViewById(R.id.container);
        LinearLayoutManager linear=new LinearLayoutManager(getContext());
        medrecycler.setLayoutManager(linear);
        submit=(Button)view.findViewById(R.id.submit);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new insert().execute();
                viewPager.setCurrentItem(4);
            }
        });



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Addmeddialog dialog = new Addmeddialog();
                dialog.setTargetFragment(MedicationdetailsFollowup.this, 1);
                dialog.show(getFragmentManager(), "MyCustomDialog");


            }
        });
        choosedate=(Button)view.findViewById(R.id.datechoose);
        datedisplay=(TextView)view.findViewById(R.id.datedisplay);
        final DatePickerDialog datePickerDialog =  new DatePickerDialog(
                getActivity(),datePickerListener, startYear, starthMonth, startDay);



        choosedate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });


        patientDatabase=PatientDatabase.getInstance(getContext());













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

    @Override
    public void sendInput(String medname, String indication, String dose, String frequency, String startdate, String stopdate, String ongoing) {
        MedList med=new MedList(medname,indication,dose,frequency,startdate,stopdate,ongoing);
        medicines.add(med);


        MedicineRecycler adapter=new MedicineRecycler( medicines,getContext());

        adapter.notifyDataSetChanged();

        medrecycler.setAdapter(adapter);






    }


    private class insert extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            int count=getArguments().getInt("followupcount");
List<Patientadd> patientadd1=patientDatabase.userDao().getAll();



            int posi=getArguments().getInt("position");

            int followup = patientDatabase.followupDAO().countofpatient(patientadd1.get(posi).getId());
            int countss=patientDatabase.followupDAO().countofpatient(patientadd1.get(posi).getId());
            int counts=patientDatabase.followupDAO().counts(patientadd1.get(posi).getId());
            for(int i=0;i<medicines.size();i++){
                Medicinesfollowup medicationdetailsmedicine=new Medicinesfollowup();
                medicationdetailsmedicine.setPatientno(patientadd1.get(posi).getId());
                medicationdetailsmedicine.setNofollow(count);
                medicationdetailsmedicine.setDose(medicines.get(i).getDose());
                medicationdetailsmedicine.setFrequency(medicines.get(i).getFrequency());
                medicationdetailsmedicine.setOngoing(medicines.get(i).getOngoing());
                medicationdetailsmedicine.setIndication(medicines.get(i).getIndication());
                medicationdetailsmedicine.setMedname(medicines.get(i).getMedname());
                medicationdetailsmedicine.setStartdate(medicines.get(i).getStartdate());
                medicationdetailsmedicine.setStopdate(medicines.get(i).getStopdate());
                medicationdetailsmedicine.setMedicineno(i+1);
                medicationdetailsmedicine.setCategoryno(5);
                patientDatabase.medicinesfollowupDAO().insertsingle(medicationdetailsmedicine);
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(getContext(),"Successfully submitted", Toast.LENGTH_LONG).show();
            submit.setEnabled(false);
        }
    }
}
