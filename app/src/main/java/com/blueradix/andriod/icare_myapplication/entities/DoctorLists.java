package com.blueradix.andriod.icare_myapplication.entities;

public class DoctorLists
{
    private long doctorId;
    private String doctorName;
    private String doctorType;
    private String description;
    private String achievement;
    private String contactNumber;
    private int doctorImageResource;

    // Constructor
    public DoctorLists(long doctorId, String doctorName, String doctorType, String description, String achievement, String contactNumber, int doctorImageResource)
    {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorType = doctorType;
        this.description = description;
        this.achievement = achievement;
        this.contactNumber = contactNumber;
        this.doctorImageResource = doctorImageResource;
    }

    public DoctorLists() {
    }

    // Getters and Setters
    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getDoctorImageResource() {
        return doctorImageResource;
    }

    public void setDoctorImageResource(int doctorImageResource) {
        this.doctorImageResource = doctorImageResource;
    }

    @Override
    public String toString() {
        return "DoctorLists{" +
                "doctorId=" + doctorId +
                ", doctorName='" + doctorName + '\'' +
                ", doctorType='" + doctorType + '\'' +
                ", description='" + description + '\'' +
                ", achievement='" + achievement + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", doctorImageResource=" + doctorImageResource +
                '}';
    }
}
