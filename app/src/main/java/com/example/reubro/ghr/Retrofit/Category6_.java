
package com.example.reubro.ghr.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category6_ {

    @SerializedName("Category Name")
    @Expose
    private String categoryName;
    @SerializedName("medical_category_id")
    @Expose
    private Integer medicalCategoryId;
    @SerializedName("Count")
    @Expose
    private Integer count;
    @SerializedName("Treated with growth hormone")
    @Expose
    private String treatedWithGrowthHormone;
    @SerializedName("GH Brand#innovator")
    @Expose
    private String gHBrandInnovator;
    @SerializedName("GH Brand#BiosimilaR")
    @Expose
    private String gHBrandBiosimilaR;
    @SerializedName("START DATE")
    @Expose
    private String sTARTDATE;
    @SerializedName("STOP DATE")
    @Expose
    private String sTOPDATE;
    @SerializedName("Device")
    @Expose
    private String device;
    @SerializedName("GH Dose#supervised")
    @Expose
    private String gHDoseSupervised;
    @SerializedName("GH Dose#non supervised")
    @Expose
    private String gHDoseNonSupervised;
    @SerializedName("GH Dose")
    @Expose
    private String gHDose;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getTreatedWithGrowthHormone() {
        return treatedWithGrowthHormone;
    }

    public void setTreatedWithGrowthHormone(String treatedWithGrowthHormone) {
        this.treatedWithGrowthHormone = treatedWithGrowthHormone;
    }

    public String getGHBrandInnovator() {
        return gHBrandInnovator;
    }

    public void setGHBrandInnovator(String gHBrandInnovator) {
        this.gHBrandInnovator = gHBrandInnovator;
    }

    public String getGHBrandBiosimilaR() {
        return gHBrandBiosimilaR;
    }

    public void setGHBrandBiosimilaR(String gHBrandBiosimilaR) {
        this.gHBrandBiosimilaR = gHBrandBiosimilaR;
    }

    public String getSTARTDATE() {
        return sTARTDATE;
    }

    public void setSTARTDATE(String sTARTDATE) {
        this.sTARTDATE = sTARTDATE;
    }

    public String getSTOPDATE() {
        return sTOPDATE;
    }

    public void setSTOPDATE(String sTOPDATE) {
        this.sTOPDATE = sTOPDATE;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getGHDoseSupervised() {
        return gHDoseSupervised;
    }

    public void setGHDoseSupervised(String gHDoseSupervised) {
        this.gHDoseSupervised = gHDoseSupervised;
    }

    public String getGHDoseNonSupervised() {
        return gHDoseNonSupervised;
    }

    public void setGHDoseNonSupervised(String gHDoseNonSupervised) {
        this.gHDoseNonSupervised = gHDoseNonSupervised;
    }

    public String getGHDose() {
        return gHDose;
    }

    public void setGHDose(String gHDose) {
        this.gHDose = gHDose;
    }

}
