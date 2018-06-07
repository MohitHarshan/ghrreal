
package com.example.reubro.ghr.Retrofit.sync;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category5 {

    @SerializedName("Category Name")
    @Expose
    private String categoryName;
    @SerializedName("medical_category_id")
    @Expose
    private Integer medicalCategoryId;
    @SerializedName("diagnosis_date")
    @Expose
    private String diagnosisDate;
    @SerializedName("Date of initiation of treatment with medications")
    @Expose
    private String dateOfInitiationOfTreatmentWithMedications;
    @SerializedName("Medication taken in past")
    @Expose
    private List<MedicationTakenInPast> medicationTakenInPast = null;

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

    public String getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(String diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public String getDateOfInitiationOfTreatmentWithMedications() {
        return dateOfInitiationOfTreatmentWithMedications;
    }

    public void setDateOfInitiationOfTreatmentWithMedications(String dateOfInitiationOfTreatmentWithMedications) {
        this.dateOfInitiationOfTreatmentWithMedications = dateOfInitiationOfTreatmentWithMedications;
    }

    public List<MedicationTakenInPast> getMedicationTakenInPast() {
        return medicationTakenInPast;
    }

    public void setMedicationTakenInPast(List<MedicationTakenInPast> medicationTakenInPast) {
        this.medicationTakenInPast = medicationTakenInPast;
    }

}
