
package com.example.reubro.ghr.Retrofit.SinglePatient;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category5_ {

    @SerializedName("Category Name")
    @Expose
    private String categoryName;
    @SerializedName("Follow_date")
    @Expose
    private String followDate;
    @SerializedName("Count")
    @Expose
    private Integer count;
    @SerializedName("Date of initiation of treatment with medications")
    @Expose
    private String dateOfInitiationOfTreatmentWithMedications;
    @SerializedName("Followup_date")
    @Expose
    private String followupDate;
    @SerializedName("Medication taken in past")
    @Expose
    private List<MedicationTakenInPast_> medicationTakenInPast = null;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getFollowDate() {
        return followDate;
    }

    public void setFollowDate(String followDate) {
        this.followDate = followDate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getDateOfInitiationOfTreatmentWithMedications() {
        return dateOfInitiationOfTreatmentWithMedications;
    }

    public void setDateOfInitiationOfTreatmentWithMedications(String dateOfInitiationOfTreatmentWithMedications) {
        this.dateOfInitiationOfTreatmentWithMedications = dateOfInitiationOfTreatmentWithMedications;
    }

    public String getFollowupDate() {
        return followupDate;
    }

    public void setFollowupDate(String followupDate) {
        this.followupDate = followupDate;
    }

    public List<MedicationTakenInPast_> getMedicationTakenInPast() {
        return medicationTakenInPast;
    }

    public void setMedicationTakenInPast(List<MedicationTakenInPast_> medicationTakenInPast) {
        this.medicationTakenInPast = medicationTakenInPast;
    }

}
