package com.example.reubro.ghr.RoomDatabase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "medicinesfollowup",
        foreignKeys = {@ForeignKey(entity = Patientadd.class,parentColumns = "id",childColumns = "patientno"),
                      @ForeignKey(entity = MedicalCategory.class,parentColumns = "id",childColumns = "categoryno"),

})


public class Medicinesfollowup {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name ="patientno")
    public long patientno;

    @ColumnInfo(name="categoryno")
    public int categoryno;

    @ColumnInfo(name = "nofollow")
    public int nofollow;

    @ColumnInfo(name="medicineno")
    public int medicineno;

    @ColumnInfo(name="medicinename")
    public String medname;

    @ColumnInfo(name="patient_id")
    public String patient_id;


    @ColumnInfo(name="indication")
    public String indication;


    @ColumnInfo(name="dose")
    public String dose;

    @ColumnInfo(name = "frequency")
    public String frequency;


    @ColumnInfo(name="startdate")
    public String startdate;



    @ColumnInfo(name="stopdate")
    public String stopdate;


    @ColumnInfo(name="Ongoing")
    public String ongoing;


    public Medicinesfollowup() {
    }

    public Medicinesfollowup(int id, long patientno, int categoryno, int nofollow, int medicineno, String medname, String patient_id, String indication, String dose, String frequency, String startdate, String stopdate, String ongoing) {
        this.id = id;
        this.patientno = patientno;
        this.categoryno = categoryno;
        this.nofollow = nofollow;
        this.medicineno = medicineno;
        this.medname = medname;
        this.patient_id = patient_id;
        this.indication = indication;
        this.dose = dose;
        this.frequency = frequency;
        this.startdate = startdate;
        this.stopdate = stopdate;
        this.ongoing = ongoing;
    }

    public int getNofollow() {
        return nofollow;
    }

    public void setNofollow(int nofollow) {
        this.nofollow = nofollow;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPatientno() {
        return patientno;
    }

    public void setPatientno(long patientno) {
        this.patientno = patientno;
    }

    public int getMedicineno() {
        return medicineno;
    }

    public void setMedicineno(int medicineno) {
        this.medicineno = medicineno;
    }

    public String getMedname() {
        return medname;
    }

    public void setMedname(String medname) {
        this.medname = medname;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getStopdate() {
        return stopdate;
    }

    public void setStopdate(String stopdate) {
        this.stopdate = stopdate;
    }

    public String getOngoing() {
        return ongoing;
    }

    public void setOngoing(String ongoing) {
        this.ongoing = ongoing;
    }

    public int getCategoryno() {
        return categoryno;
    }

    public void setCategoryno(int categoryno) {
        this.categoryno = categoryno;

    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }
}