package com.example.reubro.ghr;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.reubro.ghr.RoomDatabase.Followup;

import java.util.ArrayList;
import java.util.List;

public class RecyclerFollowup extends RecyclerView.Adapter<RecyclerFollowup.Viewholder>{
   List<Followup> followups=new ArrayList<>();
   Context context;

    public RecyclerFollowup(List<Followup> followups, Context context) {
        this.followups = followups;
        this.context = context;
    }

    @Override
    public RecyclerFollowup.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.followcards, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerFollowup.Viewholder holder, final int position) {

 holder.followupnumber.setText(String.valueOf(position+1));
holder.followcard.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(v.getContext(),Followviewtabactivity.class);
        intent.putExtra("patientno",followups.get(position).getPatientid());
         intent.putExtra("position",position);

       v.getContext().startActivity(intent);
    }
});

    }

    @Override
    public int getItemCount() {
        return followups.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
       TextView followupnumber;
       CardView followcard;

        public Viewholder(View itemView) {
            super(itemView);

       followupnumber=(TextView)itemView.findViewById(R.id.follownumber);
followcard=(CardView) itemView.findViewById(R.id.followcard);


        }
    }
}
