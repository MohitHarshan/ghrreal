package com.example.reubro.ghr;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.reubro.ghr.RoomDatabase.Followup;
import com.example.reubro.ghr.RoomDatabase.PatientDatabase;
import com.example.reubro.ghr.RoomDatabase.Patientadd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FollowupviewActivity extends Fragment{


   RecyclerView followrecycler;
   RecyclerFollowup followadapter;
   List<Followup> followupList=new ArrayList<>();
   PatientDatabase patientDatabase;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.vitalsignsfollowupview,container,false);
        patientDatabase=PatientDatabase.getInstance(getContext());
      followrecycler=(RecyclerView)view.findViewById(R.id.followrecycler);


      int posi=getArguments().getInt("position");
      Log.d("POSITIONS",String.valueOf(posi));

      Patientadd patientadd=patientDatabase.userDao().getAll().get(posi);
      Log.d("Patient number",String.valueOf(patientadd.getId()));



      followrecycler.setLayoutManager(new LinearLayoutManager(getContext()));
try {
    followupList=patientDatabase.followupDAO().getfollowupofpatient(patientadd.getId());


}catch (Exception e){
    e.printStackTrace();
    Toast.makeText(getContext(), "NO FOLLOWUPS", Toast.LENGTH_SHORT).show();
}

      Log.d("NO OF FOLLOW UPS",String.valueOf(followupList.size()));
      followadapter=new RecyclerFollowup(followupList,getContext());

      followrecycler.setAdapter(followadapter);







        return view;
    }
}
