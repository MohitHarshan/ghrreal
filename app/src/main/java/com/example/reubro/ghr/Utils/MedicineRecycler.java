package com.example.reubro.ghr.Utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.reubro.ghr.R;
import com.example.reubro.ghr.RecyclerAdapter;
import com.example.reubro.ghr.RoomDatabase.Medicationdetailsmedicine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by reubro on 30/4/18.
 */

public class MedicineRecycler extends RecyclerView.Adapter<MedicineRecycler.Viewholder> {

  private List<MedList> medicines=new ArrayList<>();
  Context context;

    public MedicineRecycler(List<MedList> medicines, Context context) {
        this.medicines = medicines;
        this.context = context;
    }

    @Override
    public MedicineRecycler.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicinecard, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(MedicineRecycler.Viewholder holder, int position) {

    holder.medname.setText(medicines.get(position).getMedname());
        holder.indication.setText(medicines.get(position).getIndication());
        holder.dose.setText(medicines.get(position).getDose());
        holder.frequency.setText(medicines.get(position).getFrequency());
        holder.startdate.setText(medicines.get(position).getStartdate());
        holder.stopdate.setText(medicines.get(position).getStopdate());
        holder.ongoing.setText(medicines.get(position).getOngoing());


    }

    @Override
    public int getItemCount() {
        return medicines.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

     TextView medname,indication,dose,frequency,startdate,stopdate,ongoing;


        public Viewholder(View itemView) {
            super(itemView);
               medname= itemView.findViewById(R.id.medname);
            indication= itemView.findViewById(R.id.indication);
            dose= itemView.findViewById(R.id.dose);
            frequency= itemView.findViewById(R.id.frequency);
            startdate= itemView.findViewById(R.id.startentry);
            stopdate=itemView.findViewById(R.id.stopdateentry);
            ongoing=itemView.findViewById(R.id.ongoingentry);

        }
    }




}
