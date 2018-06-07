package com.example.reubro.ghr;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by reubro on 27/4/18.
 */

public class Medicationadd extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

 EditText medname,indication,dose,frequency;
 TextView startdate,stopdate;
  RadioGroup ongoing;
  Button add,startdateselect,stopdateselect;

    private int startYear=1999, starthMonth=1, startDay=1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicationhhistoryentry);


        medname=(EditText)findViewById(R.id.mednameentry);
        indication=(EditText)findViewById(R.id.indicationentry);
        dose=(EditText)findViewById(R.id.doseentry);
        frequency=(EditText)findViewById(R.id.frequencyentry);


        startdate=(TextView)findViewById(R.id.startdisplay);
        stopdate=(TextView)findViewById(R.id.stopdisplay);

        ongoing=(RadioGroup)findViewById(R.id.radioongoing);
        add=(Button)findViewById(R.id.Buttonaddmed);
        startdateselect=(Button)findViewById(R.id.pickstart);
        stopdateselect=(Button)findViewById(R.id.pickstop);
        final DatePickerDialog datePickerDialog = new DatePickerDialog(
                Medicationadd.this   ,Medicationadd.this , startYear, starthMonth, startDay);


        final DatePickerDialog datestop=new DatePickerDialog(Medicationadd.this,Medicationadd.this,startYear,starthMonth,startDay);

        startdateselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();



            }
        });


        stopdateselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            datestop.show();


            }
        });












        final String mednames=medname.getText().toString();
        final String indications=indication.getText().toString();
      String ongoings= String.valueOf(ongoing.getCheckedRadioButtonId());
        final String doses=dose.getText().toString();
        final String frequencies=frequency.getText().toString();
        final String startdates=startdate.getText().toString();
        final String stopdates=stopdate.getText().toString();

        Bundle data=new Bundle();
        data.putString("medname",mednames);
        data.putString("indication",indications);
        data.putString("dose",doses);
        data.putString("frequency",frequencies);
        data.putString("startdate",startdates);
        data.putString("stopdate",stopdates);
        data.putString("ongoing",ongoings);
        android.support.v4.app.Fragment medicineadd=new Medicationdetails();

        medicineadd.setArguments(data);


 add.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         Toast.makeText(getApplicationContext(),"Medicine Added",Toast.LENGTH_SHORT);




     }
 });








    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
        Calendar newDate = Calendar.getInstance();
        newDate.set(year, monthOfYear, dayOfMonth);

        startdate.setText(dayOfMonth+"-"+(monthOfYear+1)+"-"+year);
     stopdate.setText(dayOfMonth+"-"+(monthOfYear+1)+"-"+year);



    }






}
