package com.example.reubro.ghr.RoomDatabase;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.concurrent.Executors;

/**
 * Created by reubro on 4/5/18.
 */

@android.arch.persistence.room.Database( entities = {Patientadd.class,Followup.class,PatientDiagnosis.class,MedicalCategory.class,Medicationdetailsmedicine.class,Medicinesfollowup.class}, version = 1)
public abstract class PatientDatabase extends RoomDatabase {



    private static PatientDatabase INSTANCE;
    public abstract PatientDao userDao();
    public abstract PatientdiagnosisDAO patientdiagnosisDAO();
   public abstract MedicalCategoryDAO categoryDAO();
public abstract MedicineDAO medicineDAO();
public abstract FollowupDAO followupDAO();
public abstract MedicinesfollowupDAO medicinesfollowupDAO();

    public synchronized static PatientDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = buildDatabase(context);
        }
        return INSTANCE;
    }

    private static PatientDatabase buildDatabase(final Context context) {
        return Room.databaseBuilder(context,
                PatientDatabase.class,
                "patient-database34").allowMainThreadQueries()
                .build();
    }


        public static void destroyInstance() {
            INSTANCE = null;
        }
    }




