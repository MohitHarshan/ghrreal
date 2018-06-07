package com.example.reubro.ghr;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by reubro on 3/5/18.
 */

public class Addmeddialog extends DialogFragment{

    private static final String TAG = "MyCustomDialog";

    private EditText medname,indication,dose,frequency;
    public static TextView startdate,stopdate;
    private RadioGroup ongoing;
    private RadioButton ongoingyes,ongoingno;
    private Button submit;
    Button startchoose,stopchoose;
    private int startYear = 1999, starthMonth = 1, startDay = 1;

    public interface OnInputSelected{
        void sendInput(String medname,String indication,String dose,String frequency,String startdate,String stopdate,String ongoing);
    }
    public OnInputSelected mOnInputSelected;



    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.medicationhhistoryentry, container, false);

        submit=view.findViewById(R.id.Buttonaddmed);
          medname= view.findViewById(R.id.mednameentry);
          indication=view.findViewById(R.id.indicationentry);
          dose=view.findViewById(R.id.doseentry);
          frequency=view.findViewById(R.id.frequencyentry);
          startdate=view.findViewById(R.id.startdisplay);
          stopdate=view.findViewById(R.id.stopdisplay);
          ongoing=view.findViewById(R.id.radioongoing);
          ongoingyes=view.findViewById(R.id.ongoingyes);
          ongoingno=view.findViewById(R.id.ongoingno);
        startchoose=(Button)view.findViewById(R.id.pickstart);
        stopchoose=(Button)view.findViewById(R.id.pickstop);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: capturing input.");
                String mednames = medname.getText().toString();
                String indications = indication.getText().toString();
                String doses = dose.getText().toString();
                String frequencies = frequency.getText().toString();
                String startdates = startdate.getText().toString();
                String stopdates=stopdate.getText().toString();
                String ongoings;
                if(ongoingyes.isChecked()) {
                   ongoings="YES";
                }
                else ongoings="NO";



                if(!mednames.equals("")){

                    mOnInputSelected.sendInput(mednames,indications,doses,frequencies,startdates,stopdates,ongoings);
                }


                getDialog().dismiss();
            }
        });

        final DatePickerDialog datePickerDialog =  new DatePickerDialog(
                getActivity(),datePickerListener, startYear, starthMonth, startDay);

        startchoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  datePickerDialog.show();
            }
        });

        final DatePickerDialog datePickerDialog2 =  new DatePickerDialog(
                getActivity(),datePickerListener2, startYear, starthMonth, startDay);


        stopchoose.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
           datePickerDialog2.show();
    }
});


        String startdates=startdate.getText().toString();
        String stopdatess=stopdate.getText().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "MM/dd/yyyy");
        Date convertedDate = new Date();
        Date convertedDate2 = new Date();

        try {
            convertedDate = dateFormat.parse(startdates);
            convertedDate2 = dateFormat.parse(stopdatess);
            if (convertedDate2.after(convertedDate)) {
                Log.d("Correct date",startdates);

            } else {
                Toast.makeText(getActivity().getApplicationContext(), "The stop date you entered is before start date", Toast.LENGTH_SHORT).show();

            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mOnInputSelected = (OnInputSelected) getTargetFragment();
        }catch (ClassCastException e){
            Log.e(TAG, "onAttach: ClassCastException : " + e.getMessage() );
        }
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {


        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            String year1 = String.valueOf(selectedYear);
            String month1 = String.valueOf(selectedMonth + 1);
            String day1 = String.valueOf(selectedDay);

            startdate.setText(month1 + "/" + day1 + "/" + year1);


        }
    };

    private DatePickerDialog.OnDateSetListener datePickerListener2 = new DatePickerDialog.OnDateSetListener() {


        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            String year1 = String.valueOf(selectedYear);
            String month1 = String.valueOf(selectedMonth + 1);
            String day1 = String.valueOf(selectedDay);

            stopdate.setText(month1 + "/" + day1 + "/" + year1);

        }
    };






}



