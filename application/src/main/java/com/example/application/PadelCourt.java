package com.example.application;

public class PadelCourt {

    private String courtName;
    private String location;
    private int hourlyRate;

    public PadelCourt() {
        super();
    }

    public PadelCourt(String courtName, String location, int hourlyRate) {
        super();
        this.courtName = courtName;
        this.location = location;
        this.hourlyRate = hourlyRate;
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return "PadelCourt [courtName=" + courtName + ", location=" + location + ", hourlyRate=" + hourlyRate + "]";
    }
}