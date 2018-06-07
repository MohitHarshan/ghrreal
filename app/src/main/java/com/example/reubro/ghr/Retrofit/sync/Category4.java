
package com.example.reubro.ghr.Retrofit.sync;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category4 {

    @SerializedName("Category Name")
    @Expose
    private String categoryName;
    @SerializedName("medical_category_id")
    @Expose
    private Integer medicalCategoryId;
    @SerializedName("Pulse")
    @Expose
    private String pulse;
    @SerializedName("BP#Systolic")
    @Expose
    private String bPSystolic;
    @SerializedName("BP#Diastolic")
    @Expose
    private String bPDiastolic;
    @SerializedName("diagnosis_date")
    @Expose
    private String diagnosisDate;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getMedicalCategoryId() {
        return medicalCategoryId;
    }

    public void setMedicalCategoryId(Integer medicalCategoryId) {
        this.medicalCategoryId = medicalCategoryId;
    }

    public String getPulse() {
        return pulse;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse;
    }

    public String getBPSystolic() {
        return bPSystolic;
    }

    public void setBPSystolic(String bPSystolic) {
        this.bPSystolic = bPSystolic;
    }

    public String getBPDiastolic() {
        return bPDiastolic;
    }

    public void setBPDiastolic(String bPDiastolic) {
        this.bPDiastolic = bPDiastolic;
    }

    public String getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(String diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

}
