package com.example.reubro.ghr;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PatientDetailsActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Add Patient Information");

        //View Pager Adapter
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mSectionsPagerAdapter.addFragment(new Demography(), "DEMOGRAPHY");
        mSectionsPagerAdapter.addFragment(new Diagnosis(), "DIAGNOSIS");
        mSectionsPagerAdapter.addFragment(new VitalSigns(),"VITAL SIGNS");
        mSectionsPagerAdapter.addFragment(new Medicalhistory(), "MEDICAL HISTORY");
        mSectionsPagerAdapter.addFragment(new Medicationdetails(), "MEDICATION DETAILS");
        mSectionsPagerAdapter.addFragment(new Medication(), "MEDICATION");
        mSectionsPagerAdapter.addFragment(new Anthropometry(), "ANTHROPOMETRY");
        mSectionsPagerAdapter.addFragment(new LaboratoryTests(), "LABORATORY TESTS");


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

    }

