package com.example.reubro.ghr.RoomDatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by reubro on 11/5/18.
 */
@Dao
public interface MedicineDAO {

    @Query("SELECT * FROM medicines")
    List<Medicationdetailsmedicine> getAll();

    @Query("SELECT * FROM medicines ORDER BY id DESC LIMIT 1;")
    List<Medicationdetailsmedicine> getremaining();

    @Query("SELECT * FROM medicines where patientno LIKE  :patientid")
   List <Medicationdetailsmedicine> findByid(long patientid);

    @Query("SELECT COUNT(*) from medicines")
    int countpatients();

    @Query("SELECT * FROM medicines ORDER BY id DESC LIMIT 1;")
    Medicationdetailsmedicine getlast();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Medicationdetailsmedicine... medicationdetailsmedicines);

    @Delete
    void delete(Medicationdetailsmedicine medicationdetailsmedicine);

    @Delete
    void delete(Medicationdetailsmedicine... medicationdetailsmedicines);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertsingle(Medicationdetailsmedicine medicationdetailsmedicine);

    @Query("DELETE FROM medicines")
    public void nukeTable();



}
