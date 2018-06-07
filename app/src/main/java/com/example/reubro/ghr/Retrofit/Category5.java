
package com.example.reubro.ghr.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category5 {

    @SerializedName("Category Name")
    @Expose
    private String categoryName;
    @SerializedName("Date of initiation of treatment with medications")
    @Expose
    private String dateOfInitiationOfTreatmentWithMedications;
    @SerializedName("Medication taken in past")
    @Expose
    private String medicationTakenInPast;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDateOfInitiationOfTreatmentWithMedications() {
        return dateOfInitiationOfTreatmentWithMedications;
    }

    public void setDateOfInitiationOfTreatmentWithMedications(String dateOfInitiationOfTreatmentWithMedications) {
        this.dateOfInitiationOfTreatmentWithMedications = dateOfInitiationOfTreatmentWithMedications;
    }

    public String getMedicationTakenInPast() {
        return medicationTakenInPast;
    }

    public void setMedicationTakenInPast(String medicationTakenInPast) {
        this.medicationTakenInPast = medicationTakenInPast;
    }

}
