package com.example.reubro.ghr;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FollowupActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Add a followup");
        setsectionpager();
    }


    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

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



    public void setsectionpager(){



        String id=getIntent().getExtras().getString("Patientid");

        //View Pager Adapter
        mSectionsPagerAdapter =new SectionsPagerAdapter(getSupportFragmentManager());



        String gender=getIntent().getExtras().getString("gender");
        String dobss=getIntent().getExtras().getString("dob");
        int position=getIntent().getExtras().getInt("position");
      int followcount=getIntent().getExtras().getInt("followupcount");
        Log.d("COUNTTHE OB@##",String.valueOf(followcount));
        Log.d("POSITIONOF THE OB@##",String.valueOf(position));
        Bundle bundle = new Bundle();
        bundle.putString("patientid", id);
        bundle.putString("gender",gender);
        bundle.putString("dob",dobss);
        bundle.putInt("followupcount",followcount);
        bundle.putInt("position",position);





        FollowupDate followupDate=new FollowupDate();
followupDate.setArguments(bundle);
        mSectionsPagerAdapter.addFragment(followupDate,"FOLLOWUP DATE");



        VitalSignsFollowup vitalSigns=new VitalSignsFollowup();
        vitalSigns.setArguments(bundle);
        mSectionsPagerAdapter.addFragment(vitalSigns,"VITAL SIGNS");




        MedicalhistoryFollowup medicalhistory=new MedicalhistoryFollowup();
        medicalhistory.setArguments(bundle);
        mSectionsPagerAdapter.addFragment(medicalhistory, "MEDICAL HISTORY");




        MedicationdetailsFollowup medicationdetails=new MedicationdetailsFollowup();
       medicationdetails.setArguments(bundle);
        mSectionsPagerAdapter.addFragment(medicationdetails, "MEDICATION DETAILS");




        MedicationFollowup medication=new MedicationFollowup();
        medication.setArguments(bundle);
        mSectionsPagerAdapter.addFragment(medication, "MEDICATION");



        if(gender.equals("Female")) {

            AnthropometryFollowup anthropometry=new AnthropometryFollowup();
anthropometry.setArguments(bundle);
            mSectionsPagerAdapter.addFragment(anthropometry, "ANTHROPOMETRY");
        }


        else
        {         AnthropometrymaleFollowup anthropometrymale=new AnthropometrymaleFollowup();
               anthropometrymale.setArguments(bundle);
            mSectionsPagerAdapter.addFragment(anthropometrymale,"ANTHROPOMETRY");
        }


        LaboratoryTestsFollowup laboratoryTests=new LaboratoryTestsFollowup();
        laboratoryTests.setArguments(bundle);

        mSectionsPagerAdapter.addFragment(laboratoryTests, "LABORATORY TESTS");


        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        tabLayout.addTab(tabLayout.newTab().setText("FOLLOWUP DATE"));
        tabLayout.addTab(tabLayout.newTab().setText("VITAL SIGNS"));
        tabLayout.addTab(tabLayout.newTab().setText("MEDICAL HISTORY"));
        tabLayout.addTab(tabLayout.newTab().setText("MEDICATION DETAILS"));
        tabLayout.addTab(tabLayout.newTab().setText("MEDICATION"));
        tabLayout.addTab(tabLayout.newTab().setText("ANTHROPOMETRY"));
        tabLayout.addTab(tabLayout.newTab().setText("LABORATORY TESTS"));



    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(),"PLEASE FILL IN ALL DETAILS", Toast.LENGTH_SHORT).show();
    }
}

