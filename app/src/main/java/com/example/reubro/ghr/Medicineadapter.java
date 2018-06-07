package com.example.reubro.ghr;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by reubro on 27/4/18.
 */

public class Medicineadapter extends RecyclerView.Adapter<Medicineadapter.Viewholder>

{
    List<Medicationlist> medicine=new ArrayList<>();
    Context context;

    public Medicineadapter(List<Medicationlist> medicine, Context context) {
        this.medicine = medicine;
        this.context = context;
    }

    @Override
    public Medicineadapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicationhhistoryentry, parent, false);
        return new Viewholder(view);




    }

    @Override
    public void onBindViewHolder(Medicineadapter.Viewholder holder, int position) {

     holder.medname.setText(medicine.get(position).getName());
      holder.indication.setText(medicine.get(position).getIndication());
        holder.dose.setText(medicine.get(position).getDose());
        holder.frequency.setText(medicine.get(position).getFrequency());



    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView medname,indication,dose,frequency,startdate,stopdate,ongoing;


        public Viewholder(View itemView) {
            super(itemView);

          medname=itemView.findViewById(R.id.mednameentry);
            indication=itemView.findViewById(R.id.indication);
            dose=itemView.findViewById(R.id.dose);
            frequency=itemView.findViewById(R.id.frequency);
            startdate=itemView.findViewById(R.id.startentry);
            stopdate=itemView.findViewById(R.id.stopdateentry);


        }
    }
}
