package com.example.reubro.ghr;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.reubro.ghr.Retrofit.SinglePatient.MedicationTakenInPast;
import com.example.reubro.ghr.RoomDatabase.Medicationdetailsmedicine;
import com.example.reubro.ghr.Utils.MedicineRecycler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by reubro on 8/5/18.
 */

class MedicineviewRecycler extends RecyclerView.Adapter<MedicineviewRecycler.Viewholder>{
    List<Medicationdetailsmedicine> medlist=new ArrayList<>();
    Context context;


    public MedicineviewRecycler(List<Medicationdetailsmedicine> medlist, Context context) {
        this.medlist = medlist;
        this.context = context;
    }

    @Override
    public MedicineviewRecycler.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicinecard, parent, false);
        return new MedicineviewRecycler.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(MedicineviewRecycler.Viewholder holder, int position) {
        holder.medname.setText(medlist.get(position).getMedname());
        holder.indication.setText(medlist.get(position).getIndication());
        holder.dose.setText(medlist.get(position).getDose());
        holder.frequency.setText(medlist.get(position).getFrequency());
        holder.startdate.setText(medlist.get(position).getStartdate());
        holder.stopdate.setText(medlist.get(position).getStopdate());
        holder.ongoing.setText(medlist.get(position).getOngoing());

    }

    @Override
    public int getItemCount() {
        return medlist.size();
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
