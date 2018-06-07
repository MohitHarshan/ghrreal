
package com.example.reubro.ghr.Retrofit.SinglePatient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category4 {

    @SerializedName("Category Name")
    @Expose
    private String categoryName;
    @SerializedName("Pulse")
    @Expose
    private String pulse;
    @SerializedName("BP#Systolic")
    @Expose
    private String bPSystolic;
    @SerializedName("BP#Diastolic")
    @Expose
    private String bPDiastolic;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getPulse() {
        return pulse;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse;
    }

    public String getBPSystolic() {
        return bPSystolic;
    }

    public void setBPSystolic(String bPSystolic) {
        this.bPSystolic = bPSystolic;
    }

    public String getBPDiastolic() {
        return bPDiastolic;
    }

    public void setBPDiastolic(String bPDiastolic) {
        this.bPDiastolic = bPDiastolic;
    }

}
