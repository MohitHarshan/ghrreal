package com.example.reubro.ghr;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.CollapsibleActionView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reubro.ghr.Retrofit.Patient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by reubro on 26/4/18.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private List<Patient> patients=new ArrayList<>();

  private  Context context;
    public interface OnRecyclerItemClickListener {

        void onRecyclerItemClick(CardView data);
    }


    public RecyclerAdapter(Context context, List<Patient> patient) {
        this.patients=patient;
        this.context=context;
    }


    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardpatient, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerAdapter.ViewHolder holder, int position) {

        holder.patientnames.setText(patients.get(position).getName());
        holder.patientages.setText(String.valueOf(patients.get(position).getAge()));
        holder.patientids.setText(String.valueOf(patients.get(position).getPatientId()));
        holder.options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                @SuppressLint("RestrictedApi") Context wrapper = new ContextThemeWrapper(context, R.style.MyPopupMenu);
                PopupMenu popup = new PopupMenu(wrapper, holder.options);

                popup.inflate(R.menu.patientpopup);

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.viewdetails:
                                Toast.makeText(context,"VIew Details",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.addafollowup:
                                Toast.makeText(context,"Add a follow up",Toast.LENGTH_SHORT).show();
                                break;

                        }
                        return false;
                    }
                });
                //displaying the popup
                popup.show();

            }
        });




}

    @Override
    public int getItemCount() {
        return patients.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

         TextView patientids,patientnames,patientages;
         CardView cardView;
         Button options;
        private OnRecyclerItemClickListener onRecyclerItemClickListener;
        public ViewHolder(final View itemView) {
            super(itemView);
            patientids=(TextView)itemView.findViewById(R.id.patientidentry);
            patientnames=(TextView)itemView.findViewById(R.id.patientnameentry);
            patientages=(TextView)itemView.findViewById(R.id.patientageentry);
            cardView=(CardView)itemView.findViewById(R.id.patientcard);

   options=(Button)itemView.findViewById(R.id.option);


        }

    }

    public void filterList(ArrayList<Patient> filteredList) {
        patients = filteredList;
        notifyDataSetChanged();
    }
}
