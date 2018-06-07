package com.example.reubro.ghr.RoomDatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by reubro on 9/5/18.
 */
@Dao
public interface MedicalCategoryDAO {



    @Query("SELECT * FROM medicalcategory")
    List<MedicalCategory> getAll();

    @Query("SELECT COUNT(*) from medicalcategory")
    int countcategories();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(MedicalCategory... medicalCategories);


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertsingle(MedicalCategory medicalCategory);


}









