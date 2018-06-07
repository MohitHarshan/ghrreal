
package com.example.reubro.ghr.Retrofit.SinglePatient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MedicationTakenInPast_ {

    @SerializedName("Ongoing")
    @Expose
    private String ongoing;
    @SerializedName("Stopdate")
    @Expose
    private String stopdate;
    @SerializedName("Startdate")
    @Expose
    private String startdate;
    @SerializedName("Frequency")
    @Expose
    private String frequency;
    @SerializedName("Dose")
    @Expose
    private String dose;
    @SerializedName("Indication")
    @Expose
    private String indication;
    @SerializedName("Medicationname")
    @Expose
    private String medicationname;

    public String getOngoing() {
        return ongoing;
    }

    public void setOngoing(String ongoing) {
        this.ongoing = ongoing;
    }

    public String getStopdate() {
        return stopdate;
    }

    public void setStopdate(String stopdate) {
        this.stopdate = stopdate;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public String getMedicationname() {
        return medicationname;
    }

    public void setMedicationname(String medicationname) {
        this.medicationname = medicationname;
    }

}
