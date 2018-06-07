package com.example.reubro.ghr;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.reubro.ghr.RoomDatabase.Medicinesfollowup;

import java.util.ArrayList;
import java.util.List;

class MedicineviewfollowRecycler extends RecyclerView.Adapter<MedicineviewfollowRecycler.Viewholder>{


   List<Medicinesfollowup> medlists=new ArrayList<>();
   Context context;


    public MedicineviewfollowRecycler(List<Medicinesfollowup> medlists, Context context) {

        this.medlists = medlists;
        this.context = context;
    }

    @Override
    public MedicineviewfollowRecycler.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicinecard, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(MedicineviewfollowRecycler.Viewholder holder, int position) {

        holder.medname.setText(medlists.get(position).getMedname());
        holder.indication.setText(medlists.get(position).getIndication());
        holder.dose.setText(medlists.get(position).getDose());
        holder.frequency.setText(medlists.get(position).getFrequency());
        holder.startdate.setText(medlists.get(position).getStartdate());
        holder.stopdate.setText(medlists.get(position).getStopdate());
        holder.ongoing.setText(medlists.get(position).getOngoing());

    }

    @Override
    public int getItemCount() {
        return medlists.size();
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
