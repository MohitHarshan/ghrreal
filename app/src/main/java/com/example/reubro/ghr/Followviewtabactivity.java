package com.example.reubro.ghr;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

import com.example.reubro.ghr.RoomDatabase.PatientDatabase;

import java.util.ArrayList;
import java.util.List;

public class Followviewtabactivity extends AppCompatActivity {

    private SectionsPagerAdapter1 mSectionsPagerAdapter;
    private ViewPager mViewPager;

    PatientDatabase patientDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.fragment_followviewtabactivity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Followup Details");

        patientDatabase=PatientDatabase.getInstance(getApplicationContext());
        //View Pager Adapter
        mSectionsPagerAdapter = new SectionsPagerAdapter1(getSupportFragmentManager());



        Bundle b=new Bundle();

        int posi=getIntent().getExtras().getInt("position");
       long patientno=getIntent().getExtras().getLong("patientno");
       Log.d("PATIENT ISSAS",String.valueOf(patientno));
        Log.d("FOLLOW ISSAS ",String.valueOf(posi));

        b.putInt("position",posi);
        b.putLong("patientno",patientno);
      String genders;

        genders = patientDatabase.userDao().getgender(patientno);


        Vitalsignsfollowupview vitalview=new Vitalsignsfollowupview();
        vitalview.setArguments(b);
        mSectionsPagerAdapter.addFragment(vitalview,"VITAL SIGNS");



        Medicalhistoryfollowupview medicalhistoryview=new Medicalhistoryfollowupview();
        medicalhistoryview.setArguments(b);
        mSectionsPagerAdapter.addFragment(medicalhistoryview, "MEDICAL HISTORY");



        Medicationdetailsfollowupview medview=new Medicationdetailsfollowupview();
        medview.setArguments(b);
        mSectionsPagerAdapter.addFragment(medview, "MEDICATION DETAILS");



        Medicationfollowupview medicationview=new Medicationfollowupview();
        medicationview.setArguments(b);
        mSectionsPagerAdapter.addFragment(medicationview, "MEDICATION");







        if((genders.equals("F"))||(genders.equals("Female"))) {

            Anthrofollowupview anthropometryView=new Anthrofollowupview();

            anthropometryView.setArguments(b);

            mSectionsPagerAdapter.addFragment( anthropometryView, "ANTHROPOMETRY");

        }
        else

        {
            Anthropometrymalefollowview anthropometrymalebaseline=new Anthropometrymalefollowview();
            anthropometrymalebaseline.setArguments(b);
            mSectionsPagerAdapter.addFragment(anthropometrymalebaseline, "LABORATORY TESTS");

        }

        LaboratoryfollowView laboratoryBaselineView=new LaboratoryfollowView();
        laboratoryBaselineView.setArguments(b);
        mSectionsPagerAdapter.addFragment(laboratoryBaselineView, "LABORATORY TESTS");





        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        //Setting up tabs
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        tabLayout.addTab(tabLayout.newTab().setText("VITAL SIGNS"));
        tabLayout.addTab(tabLayout.newTab().setText("MEDICAL HISTORY"));
        tabLayout.addTab(tabLayout.newTab().setText("MEDICATION DETAILS"));
        tabLayout.addTab(tabLayout.newTab().setText("MEDICATION"));
        tabLayout.addTab(tabLayout.newTab().setText("ANTHROPOMETRY"));
        tabLayout.addTab(tabLayout.newTab().setText("LABORATORY TESTS"));


    }



    public class SectionsPagerAdapter1 extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public SectionsPagerAdapter1(FragmentManager manager) {
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
