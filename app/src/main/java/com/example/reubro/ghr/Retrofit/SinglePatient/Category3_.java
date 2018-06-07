
package com.example.reubro.ghr.Retrofit.SinglePatient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category3_ {

    @SerializedName("Category Name")
    @Expose
    private String categoryName;
    @SerializedName("Follow_date")
    @Expose
    private String followDate;
    @SerializedName("Count")
    @Expose
    private Integer count;
    @SerializedName("Pubertal Status")
    @Expose
    private String pubertalStatus;
    @SerializedName("Clinical Features")
    @Expose
    private String clinicalFeatures;
    @SerializedName("Any Previous Surgeries")
    @Expose
    private String anyPreviousSurgeries;
    @SerializedName("Any Other relevent medical History")
    @Expose
    private String anyOtherReleventMedicalHistory;

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

    public String getPubertalStatus() {
        return pubertalStatus;
    }

    public void setPubertalStatus(String pubertalStatus) {
        this.pubertalStatus = pubertalStatus;
    }

    public String getClinicalFeatures() {
        return clinicalFeatures;
    }

    public void setClinicalFeatures(String clinicalFeatures) {
        this.clinicalFeatures = clinicalFeatures;
    }

    public String getAnyPreviousSurgeries() {
        return anyPreviousSurgeries;
    }

    public void setAnyPreviousSurgeries(String anyPreviousSurgeries) {
        this.anyPreviousSurgeries = anyPreviousSurgeries;
    }

    public String getAnyOtherReleventMedicalHistory() {
        return anyOtherReleventMedicalHistory;
    }

    public void setAnyOtherReleventMedicalHistory(String anyOtherReleventMedicalHistory) {
        this.anyOtherReleventMedicalHistory = anyOtherReleventMedicalHistory;
    }

}
