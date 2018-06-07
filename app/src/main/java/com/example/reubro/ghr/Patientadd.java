package com.example.reubro.ghr;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.File;
import java.util.Date;

public class Patientadd extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
   TextView pntid;
   TextView datedisplay;
   Button add;
   ImageView setdatee;
   Spinner genderspinner;
   Context context;


    String gender[]={"Male","Female"};
    private int startYear=1999, starthMonth=1, startDay=1;
   private int count;
 @Override
    protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_patientadd);
    setdatee=(ImageView)findViewById(R.id.setdate);

     datedisplay=(TextView)findViewById(R.id.datedisplay);
    add=(Button)findViewById(R.id.addbuttonpatient);
     final DatePickerDialog datePickerDialog = new DatePickerDialog(
          Patientadd.this   ,Patientadd.this , startYear, starthMonth, startDay);

     count = getIntent().getExtras().getInt("count");
     genderspinner=(Spinner)findViewById(R.id.genderspinner);


     ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,gender);
     adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
     genderspinner.setAdapter(adapter);




     setdatee.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         datePickerDialog.show();
     }
 });


  add.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          Intent i=new Intent(getApplicationContext(),PatientDetailsActivity.class);
          startActivity(i);






      }
  });

 }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
        Calendar newDate = Calendar.getInstance();
        newDate.set(year, monthOfYear, dayOfMonth);

        datedisplay.setText(dayOfMonth+"-"+(monthOfYear+1)+"-"+year);
    }









    public String getMyData() {
        return genderspinner.getSelectedItem().toString() ;
    }
}

