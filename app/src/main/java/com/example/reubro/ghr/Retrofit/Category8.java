
package com.example.reubro.ghr.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category8 {

    @SerializedName("Category Name")
    @Expose
    private String categoryName;
    @SerializedName("medical_category_id")
    @Expose
    private Integer medicalCategoryId;
    @SerializedName("Height")
    @Expose
    private String height;
    @SerializedName("Weight")
    @Expose
    private String weight;
    @SerializedName("BMI")
    @Expose
    private String bMI;
    @SerializedName("Bone Age")
    @Expose
    private String boneAge;
    @SerializedName("Tanner Stages#Females#Breasts")
    @Expose
    private String tannerStagesFemalesBreasts;
    @SerializedName("Tanner Stages#Females#pubic hair")
    @Expose
    private String tannerStagesFemalesPubicHair;
    @SerializedName("Tanner Stages#Females#Auxillary hair")
    @Expose
    private String tannerStagesFemalesAuxillaryHair;
    @SerializedName("Tanner Stages#Females#Menarche")
    @Expose
    private String tannerStagesFemalesMenarche;
    @SerializedName("Tanner Stages#Males#Testicular Volume")
    @Expose
    private String tannerStagesMalesTesticularVolume;
    @SerializedName("Tanner Stages#Males#pubic hair")
    @Expose
    private String tannerStagesMalesPubicHair;

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

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBMI() {
        return bMI;
    }

    public void setBMI(String bMI) {
        this.bMI = bMI;
    }

    public String getBoneAge() {
        return boneAge;
    }

    public void setBoneAge(String boneAge) {
        this.boneAge = boneAge;
    }

    public String getTannerStagesFemalesBreasts() {
        return tannerStagesFemalesBreasts;
    }

    public void setTannerStagesFemalesBreasts(String tannerStagesFemalesBreasts) {
        this.tannerStagesFemalesBreasts = tannerStagesFemalesBreasts;
    }

    public String getTannerStagesFemalesPubicHair() {
        return tannerStagesFemalesPubicHair;
    }

    public void setTannerStagesFemalesPubicHair(String tannerStagesFemalesPubicHair) {
        this.tannerStagesFemalesPubicHair = tannerStagesFemalesPubicHair;
    }

    public String getTannerStagesFemalesAuxillaryHair() {
        return tannerStagesFemalesAuxillaryHair;
    }

    public void setTannerStagesFemalesAuxillaryHair(String tannerStagesFemalesAuxillaryHair) {
        this.tannerStagesFemalesAuxillaryHair = tannerStagesFemalesAuxillaryHair;
    }

    public String getTannerStagesFemalesMenarche() {
        return tannerStagesFemalesMenarche;
    }

    public void setTannerStagesFemalesMenarche(String tannerStagesFemalesMenarche) {
        this.tannerStagesFemalesMenarche = tannerStagesFemalesMenarche;
    }

    public String getTannerStagesMalesTesticularVolume() {
        return tannerStagesMalesTesticularVolume;
    }

    public void setTannerStagesMalesTesticularVolume(String tannerStagesMalesTesticularVolume) {
        this.tannerStagesMalesTesticularVolume = tannerStagesMalesTesticularVolume;
    }

    public String getTannerStagesMalesPubicHair() {
        return tannerStagesMalesPubicHair;
    }

    public void setTannerStagesMalesPubicHair(String tannerStagesMalesPubicHair) {
        this.tannerStagesMalesPubicHair = tannerStagesMalesPubicHair;
    }

}
