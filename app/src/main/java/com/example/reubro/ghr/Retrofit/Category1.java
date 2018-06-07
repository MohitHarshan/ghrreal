
package com.example.reubro.ghr.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category1 {

    @SerializedName("Category Name")
    @Expose
    private String categoryName;
    @SerializedName("Gender")
    @Expose
    private String gender;
    @SerializedName("DOB")
    @Expose
    private String dOB;
    @SerializedName("Gestational Age")
    @Expose
    private String gestationalAge;
    @SerializedName("Birth Length")
    @Expose
    private String birthLength;
    @SerializedName("Birth Weight")
    @Expose
    private String birthWeight;
    @SerializedName("Current Height")
    @Expose
    private String currentHeight;
    @SerializedName("current weight")
    @Expose
    private String currentWeight;
    @SerializedName("Mothers Height")
    @Expose
    private String mothersHeight;
    @SerializedName("Fathers Height")
    @Expose
    private String fathersHeight;
    @SerializedName("Mid Parental Height")
    @Expose
    private Object midParentalHeight;
    @SerializedName("BMI")
    @Expose
    private Object bMI;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDOB() {
        return dOB;
    }

    public void setDOB(String dOB) {
        this.dOB = dOB;
    }

    public String getGestationalAge() {
        return gestationalAge;
    }

    public void setGestationalAge(String gestationalAge) {
        this.gestationalAge = gestationalAge;
    }

    public String getBirthLength() {
        return birthLength;
    }

    public void setBirthLength(String birthLength) {
        this.birthLength = birthLength;
    }

    public String getBirthWeight() {
        return birthWeight;
    }

    public void setBirthWeight(String birthWeight) {
        this.birthWeight = birthWeight;
    }

    public String getCurrentHeight() {
        return currentHeight;
    }

    public void setCurrentHeight(String currentHeight) {
        this.currentHeight = currentHeight;
    }

    public String getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(String currentWeight) {
        this.currentWeight = currentWeight;
    }

    public String getMothersHeight() {
        return mothersHeight;
    }

    public void setMothersHeight(String mothersHeight) {
        this.mothersHeight = mothersHeight;
    }

    public String getFathersHeight() {
        return fathersHeight;
    }

    public void setFathersHeight(String fathersHeight) {
        this.fathersHeight = fathersHeight;
    }

    public Object getMidParentalHeight() {
        return midParentalHeight;
    }

    public void setMidParentalHeight(Object midParentalHeight) {
        this.midParentalHeight = midParentalHeight;
    }

    public Object getBMI() {
        return bMI;
    }

    public void setBMI(Object bMI) {
        this.bMI = bMI;
    }

}
