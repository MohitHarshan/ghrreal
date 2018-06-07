package com.example.reubro.ghr;

import android.app.DatePickerDialog;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reubro.ghr.RoomDatabase.Followup;
import com.example.reubro.ghr.RoomDatabase.PatientDatabase;

public class MedicationFollowup extends Fragment {
    public RadioGroup treatedgrowth, ghbrand, supervisedornot, interornot, didprevios;
    public RadioButton yes, no, innovator, biosimilar, yesprevious, noprevious;
    public RadioButton supervised, nonsuper, intermittent, continuous;
    String[] devices = {"PEN", "SYRINGE", "NEEDLES INJECTION"};
    public Button startchoose, stopchoose, submit;
    public TextView startdate, stopdate;
    public EditText ghdose, ifyes, longestgap, reason;
    int treated;
    int biosimilars, innovators;
    int inter, cont;
    int previo, device;
    Spinner devicespinner;
    int sper, nonsper;

    PatientDatabase patientDatabase;
    private int startYear = 1999, starthMonth = 1, startDay = 1;

    public MedicationFollowup() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_medication_followup,container,false);

        treatedgrowth=(RadioGroup) view.findViewById(R.id.treatedgrowth);
        yes=(RadioButton)view.findViewById(R.id.yes);
        no=(RadioButton)view.findViewById(R.id.no);
        ghbrand=(RadioGroup)view.findViewById(R.id.ghbrandradio);
        innovator=(RadioButton)view.findViewById(R.id.innovator);
        biosimilar=(RadioButton)view.findViewById(R.id.biosimilar);
        devicespinner=(Spinner)view.findViewById(R.id.devicespinner);
        final ViewPager viewPager=getActivity().findViewById(R.id.container);


        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,devices);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        devicespinner.setAdapter(adapter);


        device=devicespinner.getSelectedItemPosition();




        startchoose=(Button)view.findViewById(R.id.startchoose);
        stopchoose=(Button)view.findViewById(R.id.stopchoose);

        startdate=(TextView)view.findViewById(R.id.startdatedisplay);
        stopdate=(TextView)view.findViewById(R.id.stopdatedisplay);

        ghdose=(EditText)view.findViewById(R.id.ghdoseentry);
        supervisedornot=(RadioGroup)view.findViewById(R.id.suoervisedornot);
        supervised=(RadioButton)view.findViewById(R.id.supervised);
        nonsuper=(RadioButton)view.findViewById(R.id.nonsupervised);
        interornot=(RadioGroup)view.findViewById(R.id.interornot);

        intermittent=(RadioButton)view.findViewById(R.id.intermittent);
        continuous=(RadioButton)view.findViewById(R.id.continuous);

        didprevios=(RadioGroup)view.findViewById(R.id.didpreviosoccaion);
        yesprevious=(RadioButton)view.findViewById(R.id.yesprevious);
        noprevious=(RadioButton)view.findViewById(R.id.noprevious);

        ifyes=(EditText)view.findViewById(R.id.ifyesentry);

        longestgap=(EditText)view.findViewById(R.id.longestgapentry);
        reason=(EditText)view.findViewById(R.id.reasonentry);

        submit=(Button)view.findViewById(R.id.submit);
        final DatePickerDialog datePickerDialog =  new DatePickerDialog(
                getActivity(),datePickerListener, startYear, starthMonth, startDay);


        final DatePickerDialog datePickerDialog2 =  new DatePickerDialog(
                getActivity(),datePickerListener2, startYear, starthMonth, startDay);

        startchoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });

        stopchoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog2.show();
            }
        });

        patientDatabase=PatientDatabase.getInstance(getContext());



        if(yes.isChecked()) {
            treated = 1;
        }else treated=0;


        if(innovator.isChecked()) {
            innovators=1;
        }else  innovators=0;

        if(biosimilar.isChecked()) {
            biosimilars=1;
        }else biosimilars=0;



        if(supervised.isChecked()){

            sper=1;
        }else sper=0;

        if(nonsuper.isChecked()){
            nonsper=1;

        }else nonsper=0;


        if(intermittent.isChecked()){
            inter=1;
        }else inter=0;

        if(continuous.isChecked()){

            cont=1;
        }else cont=0;





        if(yesprevious.isChecked()){
            previo=1;
        }else previo=0;

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new entry().execute();
                viewPager.setCurrentItem(5);

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

            startdate.setText(day1 + "/" + month1 + "/" + year1);

        }
    };
    private DatePickerDialog.OnDateSetListener datePickerListener2 = new DatePickerDialog.OnDateSetListener() {


        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            String year1 = String.valueOf(selectedYear);
            String month1 = String.valueOf(selectedMonth + 1);
            String day1 = String.valueOf(selectedDay);

            stopdate.setText(day1 + "/" + month1 + "/" + year1);

        }
    };


    private class entry extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... voids) {



            String startsdate=startdate.getText().toString();
            String stopdates=stopdate.getText().toString();
            String ifyeses=ifyes.getText().toString();
            String ghdoses=ghdose.getText().toString();
            String longestgaps=longestgap.getText().toString();
            String reasons=reason.getText().toString();












            int count=getArguments().getInt("followupcount");
            int posi=getArguments().getInt("position");


int counts=patientDatabase.followupDAO().getAll().get(posi).getCount();
            Followup followup=new Followup();
            followup.setCategoryid(6);
            followup.setCount(count);
            followup.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup.setSubcategorytitle("Treated with growth hormone");
            followup.setSubcategoryvalue(String.valueOf(treated));
            patientDatabase.followupDAO().insertsingle(followup);

            Followup followup1=new Followup();
            followup1.setCategoryid(6);
            followup1.setCount(count);
            followup1.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup1.setSubcategorytitle("START DATE");
            followup1.setSubcategoryvalue(startsdate);
            patientDatabase.followupDAO().insertsingle(followup1);

            Followup followup2=new Followup();
            followup2.setCategoryid(6);
            followup2.setCount(count);
            followup2.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup2.setSubcategorytitle("STOP DATE");
            followup2.setSubcategoryvalue(stopdates);
            patientDatabase.followupDAO().insertsingle(followup2);

            Followup followup3=new Followup();
            followup3.setCategoryid(6);
            followup3.setCount(count);
            followup3.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup3.setSubcategorytitle("GH BRAND INNOVATOR");
            followup3.setSubcategoryvalue(String.valueOf(innovators));
            patientDatabase.followupDAO().insertsingle(followup3);

            Followup followup4=new Followup();
            followup4.setCategoryid(6);
            followup4.setCount(count);
            followup4.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup4.setSubcategorytitle("GH BRAND BIOSIMILAR");
            followup4.setSubcategoryvalue(String.valueOf(biosimilars));
            patientDatabase.followupDAO().insertsingle(followup4);

            Followup followup5=new Followup();
            followup5.setCategoryid(6);
            followup5.setCount(count);
            followup5.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup5.setSubcategorytitle("DEVICE");
            followup5.setSubcategoryvalue(String.valueOf(device));
            patientDatabase.followupDAO().insertsingle(followup5);

            Followup followup6=new Followup();
            followup6.setCategoryid(6);
            followup6.setCount(count);
            followup6.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup6.setSubcategorytitle("GH DOSE");
            followup6.setSubcategoryvalue(ghdoses);
            patientDatabase.followupDAO().insertsingle(followup6);

            Followup followup7=new Followup();
            followup7.setCategoryid(6);
            followup7.setCount(count);
            followup7.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup7.setSubcategorytitle("INTERMITTENT");
            followup7.setSubcategoryvalue(String.valueOf(intermittent));
            patientDatabase.followupDAO().insertsingle(followup7);

            Followup followup8=new Followup();
            followup8.setCategoryid(6);
            followup8.setCount(count);
            followup8.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup8.setSubcategorytitle("CONTINUOUS");
            followup8.setSubcategoryvalue(String.valueOf(continuous));
            patientDatabase.followupDAO().insertsingle(followup8);


            Followup followup9=new Followup();
            followup9.setCategoryid(6);
            followup9.setCount(count);
            followup9.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup9.setSubcategorytitle("SUPERVISED");
            followup9.setSubcategoryvalue(String.valueOf(sper));
            patientDatabase.followupDAO().insertsingle(followup9);

            Followup followup10=new Followup();
            followup10.setCategoryid(6);
            followup10.setCount(count);
            followup10.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup10.setSubcategorytitle("NON SUPERVISED");
            followup10.setSubcategoryvalue(String.valueOf(nonsper));
            patientDatabase.followupDAO().insertsingle(followup10);

            Followup followup11=new Followup();
            followup11.setCategoryid(6);
            followup11.setCount(count);
            followup11.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup11.setSubcategorytitle("Has the patient received GH on previous occcassion");
            followup11.setSubcategoryvalue(String.valueOf(previo));
            patientDatabase.followupDAO().insertsingle(followup11);

            Followup followup12=new Followup();
            followup12.setCategoryid(6);
            followup12.setCount(count);
            followup12.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup12.setSubcategorytitle("IF YES,DETAILS");
            followup12.setSubcategoryvalue(ifyeses);
            patientDatabase.followupDAO().insertsingle(followup12);

            Followup followup13=new Followup();
            followup13.setCategoryid(6);
            followup13.setCount(count);
            followup13.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup13.setSubcategorytitle("LONGEST GAP");
            followup13.setSubcategoryvalue(longestgaps);
            patientDatabase.followupDAO().insertsingle(followup13);

            Followup followup14=new Followup();
            followup14.setCategoryid(6);
            followup14.setCount(count);
            followup14.setPatientno(patientDatabase.userDao().getAll().get(posi).getId());
            followup14.setSubcategorytitle("REASON");
            followup14.setSubcategoryvalue(reasons);
            patientDatabase.followupDAO().insertsingle(followup14);



            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(getContext(),"Successfully submitted",Toast.LENGTH_SHORT).show();
            submit.setEnabled(false);
        }
    }
}