package com.example.reubro.ghr.RoomDatabase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by reubro on 9/5/18.
 */
@Entity(tableName = "medicalcategory")
public class MedicalCategory {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name ="title")
    public String title;


    public MedicalCategory() {
    }


    public MedicalCategory(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
