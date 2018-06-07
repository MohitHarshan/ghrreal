package com.example.reubro.ghr;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by reubro on 26/4/18.
 */

public class Medicationdetails extends android.support.v4.app.Fragment {


   Button addmedicine;
   RecyclerView medicinerecycler;
   List<Medicationlist> medicines;
   String mednames,doses,frequencies,indications,startdate,stopdates,ongoings;
   Medicineadapter adapter;
   public Medicationdetails() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.medicationdetailsfragment,container,false);




        addmedicine=view.findViewById(R.id.addmedicinebutton);
     medicinerecycler=view.findViewById(R.id.medicinereycler);


        LinearLayoutManager linear=new LinearLayoutManager(view.getContext());
        medicinerecycler.setLayoutManager(linear);

         mednames=getArguments().getString("medname");
         indications=getArguments().getString("indication");
        doses=getArguments().getString("dose");
        frequencies=getArguments().getString("frequency");
          startdate =getArguments().getString("startdate");
         stopdates=getArguments().getString("stopdate");
        ongoings=getArguments().getString("ongoing");

        medicines=new ArrayList<>();

        addmedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),Medicationadd.class);
                startActivity(intent);
            }
        });



            Medicationlist medicationlist=new Medicationlist(mednames,indications,doses,frequencies,startdate,stopdates,ongoings);

        medicines.add(medicationlist);




        adapter=new Medicineadapter(medicines,view.getContext());



        medicinerecycler.setAdapter(adapter);









        return view;

    }
}
