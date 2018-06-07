package com.example.reubro.ghr;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;

import com.example.reubro.ghr.RoomDatabase.PatientDatabase;

import java.util.ArrayList;
import java.util.List;

public class ViewDetails extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    PatientDatabase patientDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_patient_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Patient Details");

        //View Pager Adapter
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());


          String id= getIntent().getExtras().getString("patientid");
          String gend=getIntent().getExtras().getString("gender");
        Log.d("GENDER",gend);
           Bundle b=new Bundle();

           b.putString("patientid",id);
           int posi=getIntent().getExtras().getInt("position");
           b.putInt("position",posi);

           Demographyview demo=new Demographyview();
             demo.setArguments(b);
           mSectionsPagerAdapter.addFragment(demo,"DEMOGRAPHY");




 Diagnosisview diagnosisview=new Diagnosisview();
         diagnosisview.setArguments(b);
        mSectionsPagerAdapter.addFragment(diagnosisview, "DIAGNOSIS");





         VitalSignsBaseline vitalview=new VitalSignsBaseline();
         vitalview.setArguments(b);
        mSectionsPagerAdapter.addFragment(vitalview,"VITAL SIGNS");



        Medicalhistorbaseline medicalhistoryview=new Medicalhistorbaseline();
        medicalhistoryview.setArguments(b);
        mSectionsPagerAdapter.addFragment(medicalhistoryview, "MEDICAL HISTORY");








        Medicationdetailsbaseline medview=new Medicationdetailsbaseline();
        medview.setArguments(b);
        mSectionsPagerAdapter.addFragment(medview, "MEDICATION DETAILS");










        MedicationBaselineView medicationview=new MedicationBaselineView();
        medicationview.setArguments(b);
        mSectionsPagerAdapter.addFragment(medicationview, "MEDICATION");







        if(gend.equals("Female")) {
           Anthrobasselineview anthropometryView=new Anthrobasselineview();
           anthropometryView.setArguments(b);

            mSectionsPagerAdapter.addFragment( anthropometryView, "ANTHROPOMETRY");

        }
        else

        {
            Anthropometrymalebaseline anthropometrymalebaseline=new Anthropometrymalebaseline();
            anthropometrymalebaseline.setArguments(b);
            mSectionsPagerAdapter.addFragment(anthropometrymalebaseline, "LABORATORY TESTS");

        }
LaboratoryBaselineView laboratoryBaselineView=new LaboratoryBaselineView();
        laboratoryBaselineView.setArguments(b);
        mSectionsPagerAdapter.addFragment(laboratoryBaselineView, "LABORATORY TESTS");


      FollowupviewActivity vitalSignsFollowupView=new FollowupviewActivity();
      vitalSignsFollowupView.setArguments(b);
      mSectionsPagerAdapter.addFragment(vitalSignsFollowupView,"FOLLOW UP");





        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        //Setting up tabs
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        tabLayout.addTab(tabLayout.newTab().setText("DEMOGRAPHY"));
        tabLayout.addTab(tabLayout.newTab().setText("DIAGNOSIS"));
        tabLayout.addTab(tabLayout.newTab().setText("VITAL SIGNS"));
        tabLayout.addTab(tabLayout.newTab().setText("MEDICAL HISTORY"));
        tabLayout.addTab(tabLayout.newTab().setText("MEDICATION DETAILS"));
        tabLayout.addTab(tabLayout.newTab().setText("MEDICATION"));
        tabLayout.addTab(tabLayout.newTab().setText("ANTHROPOMETRY"));
        tabLayout.addTab(tabLayout.newTab().setText("LABORATORY TESTS"));
        tabLayout.addTab(tabLayout.newTab().setText("FOLLOW UP"));

    }



    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public SectionsPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
