
package com.example.reubro.ghr.Retrofit.SinglePatient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category6 {

    @SerializedName("Category Name")
    @Expose
    private String categoryName;
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
