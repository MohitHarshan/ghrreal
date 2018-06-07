package com.example.reubro.ghr.RoomDatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.icu.text.Replaceable;

import java.util.List;

import retrofit2.http.DELETE;

/**
 * Created by reubro on 4/5/18.
 */
@Dao
public interface PatientDao {


        @Query("SELECT * FROM Patient")
        List<Patientadd> getAll();

        @Query("SELECT * FROM Patient ORDER BY id DESC LIMIT 1;")
        List<Patientadd> getremaining();

        @Query("SELECT * FROM Patient where patient_id LIKE  :patientid")
        Patientadd findByid(String patientid);

        @Query("SELECT COUNT(*) from Patient")
        int countpatients();

        @Query("SELECT * FROM Patient ORDER BY id DESC LIMIT 1;")
        Patientadd getlast();
 @Query("SELECT gender FROM PATIENT WHERE id= :id " )
         String getgender(long id);

       @Query("Select * from Patient LIMIT -1 OFFSET :offset ")
       List<Patientadd> getpatientstosend(int offset);


        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insertAll(Patientadd... patients);

        @Delete
        void delete(Patientadd patient);

        @Delete
        void delete(Patientadd... patientadds);

        @Query("delete from Patient where id in (select id from Patient limit :x)")
        void deleteincoming(int x);

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        long insertsingle(Patientadd patient);

        @Query("DELETE FROM Patient")
        public void nukeTable();

    }



