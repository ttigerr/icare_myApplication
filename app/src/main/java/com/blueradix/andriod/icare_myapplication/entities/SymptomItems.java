package com.blueradix.andriod.icare_myapplication.entities;

import java.io.Serializable;

public class SymptomItems implements Serializable
{
    private long symptomId;
    private String symptomName;
    private int imageResource;

    // Constructor
    public SymptomItems(int symptomId, String symptomName, int imageResource) {
        this.symptomId = symptomId;
        this.symptomName = symptomName;
        this.imageResource = imageResource;
    }

    // Default constructor
    public SymptomItems() {
    }

    // Getter
    public long getSymptomId() {
        return symptomId;
    }

    public String getSymptomName() {
        return symptomName;
    }

    public int getImageResource(){ return imageResource; }

    // Setter
    public void setSymptomId(long symptomId) {
        this.symptomId = symptomId;
    }

    public void setSymptomName(String symptomName) {
        this.symptomName = symptomName;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
