
package com.example.reubro.ghr.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category7 {

    @SerializedName("Category Name")
    @Expose
    private String categoryName;
    @SerializedName("medical_category_id")
    @Expose
    private Integer medicalCategoryId;
    @SerializedName("Did the Patient Receive GH on any previous")
    @Expose
    private String didThePatientReceiveGHOnAnyPrevious;
    @SerializedName("If yes details")
    @Expose
    private String ifYesDetails;
    @SerializedName("Longest gap for non adherence hormone therappy")
    @Expose
    private String longestGapForNonAdherenceHormoneTherappy;
    @SerializedName("Reason for non adherence to therappy")
    @Expose
    private String reasonForNonAdherenceToTherappy;

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

    public String getDidThePatientReceiveGHOnAnyPrevious() {
        return didThePatientReceiveGHOnAnyPrevious;
    }

    public void setDidThePatientReceiveGHOnAnyPrevious(String didThePatientReceiveGHOnAnyPrevious) {
        this.didThePatientReceiveGHOnAnyPrevious = didThePatientReceiveGHOnAnyPrevious;
    }

    public String getIfYesDetails() {
        return ifYesDetails;
    }

    public void setIfYesDetails(String ifYesDetails) {
        this.ifYesDetails = ifYesDetails;
    }

    public String getLongestGapForNonAdherenceHormoneTherappy() {
        return longestGapForNonAdherenceHormoneTherappy;
    }

    public void setLongestGapForNonAdherenceHormoneTherappy(String longestGapForNonAdherenceHormoneTherappy) {
        this.longestGapForNonAdherenceHormoneTherappy = longestGapForNonAdherenceHormoneTherappy;
    }

    public String getReasonForNonAdherenceToTherappy() {
        return reasonForNonAdherenceToTherappy;
    }

    public void setReasonForNonAdherenceToTherappy(String reasonForNonAdherenceToTherappy) {
        this.reasonForNonAdherenceToTherappy = reasonForNonAdherenceToTherappy;
    }

}
