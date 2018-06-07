package com.example.reubro.ghr.Utils;

/**
 * Created by reubro on 30/4/18.
 */

public class MedList   {

    String medname;
    String indication;
    String dose;
    String frequency;
    String startdate;
    String stopdate;
    String ongoing;

    public MedList(String medname, String indication, String dose, String frequency, String startdate, String stopdate, String ongoing) {
        this.medname = medname;
        this.indication = indication;
        this.dose = dose;
        this.frequency = frequency;
        this.startdate = startdate;
        this.stopdate = stopdate;
        this.ongoing = ongoing;
    }






    public String getMedname() {
        return medname;
    }

    public void setMedname(String medname) {
        this.medname = medname;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getStopdate() {
        return stopdate;
    }

    public void setStopdate(String stopdate) {
        this.stopdate = stopdate;
    }

    public String getOngoing() {
        return ongoing;
    }

    public void setOngoing(String ongoing) {
        this.ongoing = ongoing;
    }
}
