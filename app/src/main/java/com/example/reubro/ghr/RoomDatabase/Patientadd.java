package com.example.reubro.ghr.RoomDatabase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;

/**
 * Created by reubro on 2/5/18.
 */

@Entity(tableName = "Patient")
public class Patientadd{

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name="site_id")
    private String siteId;

    @ColumnInfo(name="patient_id")
    private String patientId;

    @ColumnInfo(name="name")
    private String name;

    @ColumnInfo(name="initials")
    private String initials;

    @ColumnInfo(name="gender")
    private String gender;

    @ColumnInfo(name="date_birth")
    private String dateBirth;

    @ColumnInfo(name="age")
    private Integer age;

    @ColumnInfo(name="created_date")
    private String createdDate;

    @ColumnInfo(name="modified_date")
    private String modifiedDate;


    public Patientadd() {

    }

    public Patientadd(int id, String siteId, String patientId, String name, String initials,String gender, String dateBirth, Integer age, String createdDate, String modifiedDate) {
        this.id = id;
        this.siteId = siteId;
        this.patientId = patientId;
        this.name = name;
        this.initials=initials;
        this.gender = gender;
        this.dateBirth = dateBirth;
        this.age = age;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;


    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }





}