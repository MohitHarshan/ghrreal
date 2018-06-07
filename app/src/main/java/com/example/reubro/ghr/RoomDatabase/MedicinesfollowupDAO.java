package com.example.reubro.ghr.RoomDatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;
@Dao
public interface MedicinesfollowupDAO {


    @Query("SELECT * FROM medicinesfollowup")
    List<Medicinesfollowup> getAll();

    @Query("SELECT * FROM medicinesfollowup ORDER BY id DESC LIMIT 1;")
    List<Medicinesfollowup> getremaining();

    @Query("SELECT * FROM medicinesfollowup where patient_id LIKE  :patientid")
    Medicinesfollowup findByid(String patientid);

    @Query("SELECT COUNT(*) from medicinesfollowup")
    int countpatients();

    @Query("SELECT * FROM medicinesfollowup ORDER BY id DESC LIMIT 1;")
    Medicinesfollowup getlast();

    @Query("SELECT * FROM medicinesfollowup WHERE patientno =:patientno AND nofollow =:nofollow")
            List<Medicinesfollowup> getmeds(long patientno,int nofollow);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Medicinesfollowup... medicinesfollowups);

    @Delete
    void delete(Medicinesfollowup medicinesfollowup);

    @Delete
    void delete(Medicinesfollowup... medicinesfollowups);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertsingle(Medicinesfollowup medicinesfollowup);

    @Query("DELETE FROM medicinesfollowup")
    public void nukeTable();

}
