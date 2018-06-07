
package com.example.reubro.ghr.Retrofit.SinglePatient;

import java.util.List;
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
    private List<MedicationTakenInPast> medicationTakenInPast = null;

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

    public List<MedicationTakenInPast> getMedicationTakenInPast() {
        return medicationTakenInPast;
    }

    public void setMedicationTakenInPast(List<MedicationTakenInPast> medicationTakenInPast) {
        this.medicationTakenInPast = medicationTakenInPast;
    }

}
