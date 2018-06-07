package com.example.reubro.ghr.RoomDatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by reubro on 10/5/18.
 */
@Dao
public interface PatientdiagnosisDAO {

    @Query("SELECT * FROM Patientdiagnosis")
    List<PatientDiagnosis> getAll();


    @Query("SELECT * FROM Patientdiagnosis where patientid LIKE  :patientid")
    PatientDiagnosis findByid(String patientid);

    @Query("SELECT COUNT(*) from Patientdiagnosis")
    int countpatients();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(PatientDiagnosis... patientDiagnoses);


    @Delete
    void delete(PatientDiagnosis patientDiagnosis);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertsingle(PatientDiagnosis patientDiagnosis);

    @Query("DELETE FROM Patientdiagnosis")
    public void nukeTable();

@Query("SELECT subcategoryvalue FROM Patientdiagnosis WHERE (subcategorytitle LIKE :subcategorytitle) AND (patientno = :patientno) AND (categoryid = :categoryno)" )
 String getvalue(String subcategorytitle,long patientno,int categoryno);



}
