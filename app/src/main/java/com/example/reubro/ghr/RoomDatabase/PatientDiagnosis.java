package com.example.reubro.ghr.RoomDatabase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by reubro on 9/5/18.
 */
@Entity(tableName = "Patientdiagnosis",
        foreignKeys = {@ForeignKey(entity = Patientadd.class,parentColumns = "id",childColumns = "patientno"),
        @ForeignKey(entity = MedicalCategory.class,parentColumns = "id",childColumns = "categoryid")})

public class PatientDiagnosis {

    @PrimaryKey(autoGenerate = true)
    public int id;

@ColumnInfo(name="patientno")
public long patientnumber;

   @ColumnInfo(name = "patientid")
    public String patientid;


   @ColumnInfo(name="categoryid")
  public   int categoryid;


   @ColumnInfo(name="subcategorytitle")
    public String subcategorytitle;

   @ColumnInfo(name="subcategoryvalue")
    public String subcategoryvalue;


    public PatientDiagnosis() {
    }


    public PatientDiagnosis(int id, int patientnumber, String patientid, int categoryid, String subcategorytitle, String subcategoryvalue) {
        this.id = id;
        this.patientnumber = patientnumber;
        this.patientid = patientid;
        this.categoryid = categoryid;
        this.subcategorytitle = subcategorytitle;
        this.subcategoryvalue = subcategoryvalue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
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

    public long getPatientnumber() {
        return patientnumber;
    }

    public void setPatientnumber(long patientnumber) {
        this.patientnumber = patientnumber;
    }
}
