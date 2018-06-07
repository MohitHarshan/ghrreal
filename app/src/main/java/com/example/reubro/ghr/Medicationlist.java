package com.example.reubro.ghr;

/**
 * Created by reubro on 27/4/18.
 */

public class Medicationlist {

    String name;
    String indication;
    String dose;
    String frequency;
    String startdate;
    String stopdate;
    String ongoing;

    public Medicationlist(String name, String indication, String dose, String frequency, String startdate, String stopdate, String ongoing) {
        this.name = name;
        this.indication = indication;
        this.dose = dose;
        this.frequency = frequency;
        this.startdate = startdate;
        this.stopdate = stopdate;
        this.ongoing = ongoing;
    }
    public Medicationlist(String name, String indication, String dose, String frequency, String startdate,  String ongoing) {
        this.name = name;
        this.indication = indication;
        this.dose = dose;
        this.frequency = frequency;
        this.startdate = startdate;
        this.ongoing = ongoing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
