package com.example.reubro.ghr.RoomDatabase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by reubro on 9/5/18.
 */
@Entity(tableName = "followup",foreignKeys = {@ForeignKey(entity = Patientadd.class,parentColumns = "id",childColumns = "patientno"),
        @ForeignKey(entity = MedicalCategory.class,parentColumns = "id",childColumns = "categoryid")})
public class Followup {

    @PrimaryKey(autoGenerate = true)
   @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "patientno")
    public long patientno;


    @ColumnInfo(name="categoryid")
    int categoryid;


    @ColumnInfo(name="subcategorytitle")
    public String subcategorytitle;

    @ColumnInfo(name="subcategoryvalue")
    public String subcategoryvalue;


    @ColumnInfo(name="Followupcount")
    public int Followupcount;


    @ColumnInfo(name="Followupdate")
    public String date;


    public Followup() {
    }

    public Followup(int id, long patientno, int categoryid, String subcategorytitle, String subcategoryvalue, int count, String date) {
        this.id = id;
        this.patientno= patientno;
        this.categoryid = categoryid;
        this.subcategorytitle = subcategorytitle;
        this.subcategoryvalue = subcategoryvalue;
        this.Followupcount = count;
        this.date = date;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPatientid() {
        return patientno;
    }

    public void setPatientno(long patientno) {
        this.patientno= patientno;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getSubcategorytitle() {
        return subcategorytitle;
    }

    public void setSubcategorytitle(String subcategorytitle) {
        this.subcategorytitle = subcategorytitle;
    }

    public String getSubcategoryvalue() {
        return subcategoryvalue;
    }

    public void setSubcategoryvalue(String subcategoryvalue) {
        this.subcategoryvalue = subcategoryvalue;
    }

    public int getCount() {
        return Followupcount;
    }

    public void setCount(int count) {
        this.Followupcount = count;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
