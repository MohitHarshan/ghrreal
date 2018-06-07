
package com.example.reubro.ghr.Retrofit.sync;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category2 {

    @SerializedName("Category Name")
    @Expose
    private String categoryName;
    @SerializedName("medical_category_id")
    @Expose
    private Integer medicalCategoryId;
    @SerializedName("Paediatric growth hormone defficiency")
    @Expose
    private String paediatricGrowthHormoneDefficiency;
    @SerializedName("Adult growth hormone defficiency")
    @Expose
    private String adultGrowthHormoneDefficiency;
    @SerializedName("Turner Syndrome")
    @Expose
    private String turnerSyndrome;
    @SerializedName("Prader-willi syndrome")
    @Expose
    private String praderWilliSyndrome;
    @SerializedName("small for gestational age")
    @Expose
    private String smallForGestationalAge;
    @SerializedName("Chronic renal insufficiency")
    @Expose
    private String chronicRenalInsufficiency;
    @SerializedName("SHOX syndrome")
    @Expose
    private String sHOXSyndrome;
    @SerializedName("Idiopathic short stature")
    @Expose
    private String idiopathicShortStature;
    @SerializedName("OTHERS")
    @Expose
    private String oTHERS;
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

    public String getPaediatricGrowthHormoneDefficiency() {
        return paediatricGrowthHormoneDefficiency;
    }

    public void setPaediatricGrowthHormoneDefficiency(String paediatricGrowthHormoneDefficiency) {
        this.paediatricGrowthHormoneDefficiency = paediatricGrowthHormoneDefficiency;
    }

    public String getAdultGrowthHormoneDefficiency() {
        return adultGrowthHormoneDefficiency;
    }

    public void setAdultGrowthHormoneDefficiency(String adultGrowthHormoneDefficiency) {
        this.adultGrowthHormoneDefficiency = adultGrowthHormoneDefficiency;
    }

    public String getTurnerSyndrome() {
        return turnerSyndrome;
    }

    public void setTurnerSyndrome(String turnerSyndrome) {
        this.turnerSyndrome = turnerSyndrome;
    }

    public String getPraderWilliSyndrome() {
        return praderWilliSyndrome;
    }

    public void setPraderWilliSyndrome(String praderWilliSyndrome) {
        this.praderWilliSyndrome = praderWilliSyndrome;
    }

    public String getSmallForGestationalAge() {
        return smallForGestationalAge;
    }

    public void setSmallForGestationalAge(String smallForGestationalAge) {
        this.smallForGestationalAge = smallForGestationalAge;
    }

    public String getChronicRenalInsufficiency() {
        return chronicRenalInsufficiency;
    }

    public void setChronicRenalInsufficiency(String chronicRenalInsufficiency) {
        this.chronicRenalInsufficiency = chronicRenalInsufficiency;
    }

    public String getSHOXSyndrome() {
        return sHOXSyndrome;
    }

    public void setSHOXSyndrome(String sHOXSyndrome) {
        this.sHOXSyndrome = sHOXSyndrome;
    }

    public String getIdiopathicShortStature() {
        return idiopathicShortStature;
    }

    public void setIdiopathicShortStature(String idiopathicShortStature) {
        this.idiopathicShortStature = idiopathicShortStature;
    }

    public String getOTHERS() {
        return oTHERS;
    }

    public void setOTHERS(String oTHERS) {
        this.oTHERS = oTHERS;
    }

    public String getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(String diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

}
