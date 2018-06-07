package com.example.reubro.ghr;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class AnthropometryView extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.anthropometryview, container, false);

        final TabLayout tab2 = (TabLayout) view.findViewById(R.id.tab2);

        FrameLayout containers = (FrameLayout) view.findViewById(R.id.vitalsignscontainer);

        int position = tab2.getSelectedTabPosition();

        String id=getArguments().getString("patientid2");
        Bundle b=new Bundle();
        b.putString("patientid3",id);
        int posi=getArguments().getInt("position");
        b.putInt("position",posi);


        final Fragment anthrobasselineview=new Anthrobasselineview();
        anthrobasselineview.setArguments(b);


        android.support.v4.app.FragmentManager fm = getFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.vitalsignscontainer, anthrobasselineview);

        ft.commit();


        tab2.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                int positions=tab.getPosition();

                switch (positions){
                    case 0:      {  android.support.v4.app.FragmentManager fm1 = getFragmentManager();
                        android.support.v4.app.FragmentTransaction ft1 = fm1.beginTransaction();
                        ft1.replace(R.id.vitalsignscontainer, anthrobasselineview);

                        ft1.commit();
                        break;
                    }

                    case 1:  {     android.support.v4.app.FragmentManager fm2= getFragmentManager();
                        android.support.v4.app.FragmentTransaction ft2 = fm2.beginTransaction();
                        ft2.replace(R.id.vitalsignscontainer, anthrobasselineview);

                        ft2.commit();
                        break;
                    }


                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                android.support.v4.app.FragmentManager fm2= getFragmentManager();
                android.support.v4.app.FragmentTransaction ft2 = fm2.beginTransaction();
                ft2.replace(R.id.vitalsignscontainer, anthrobasselineview);

                ft2.commit();




            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        return view;



    }


}




