package com.example.reubro.ghr;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by reubro on 4/5/18.
 */

public class Medicalhistoryview extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.medicalhistoryview,container,false);


        final TabLayout tab2 = (TabLayout) view.findViewById(R.id.tab2);
        FrameLayout containers = (FrameLayout) view.findViewById(R.id.medicalhistorycontainer);

        int position = tab2.getSelectedTabPosition();

        final Fragment medicalbaseline=new Medicalhistorbaseline();


      int posi=getArguments().getInt("position");
        Log.d("POSSS###",String.valueOf(posi));

      Bundle b=new Bundle();
         b.putInt("position",posi);
         medicalbaseline.setArguments(b);


      final Fragment views = new Medicalhistorbaseline();
views.setArguments(b);
        android.support.v4.app.FragmentManager fm = getFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.medicalhistorycontainer, medicalbaseline);

        ft.commit();






        tab2.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                int positions=tab.getPosition();

                switch (positions){
                    case 0:      {  android.support.v4.app.FragmentManager fm = getFragmentManager();
                        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.medicalhistorycontainer, medicalbaseline);
                        ft.commit();
                        break;
                    }

                    case 1:  {     android.support.v4.app.FragmentManager fm = getFragmentManager();
                        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.medicalhistorycontainer, views);

                        ft.commit();
                        break;
                    }

                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                android.support.v4.app.FragmentManager fm = getFragmentManager();
                android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.medicalhistorycontainer, medicalbaseline);

                ft.commit();

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });






        return view;
    }
}
