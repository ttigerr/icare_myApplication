package com.blueradix.andriod.icare_myapplication.entities;

import java.io.Serializable;

public class SymptomItems implements Serializable
{
    public static final String SYMPTOM_KEY = "symptom_key";
    public long symptomId;
    public String symptomName;
    public String symptomDescription;
    public String symptomRisk;
    public String symptomCauses;
    public String symptomSolution;
    public String symptomImageResource;

    // Constructor
    public SymptomItems(long symptomId, String symptomName, String symptomDescription, String symptomRisk, String symptomCauses, String symptomSolution, String symptomImageResource) {
        this.symptomId = symptomId;
        this.symptomName = symptomName;
        this.symptomDescription = symptomDescription;
        this.symptomRisk = symptomRisk;
        this.symptomCauses = symptomCauses;
        this.symptomSolution = symptomSolution;
        this.symptomImageResource = symptomImageResource;
    }

    // Default constructor
    public SymptomItems() {
    }

    public long getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(long symptomId) {
        this.symptomId = symptomId;
    }

    public String getSymptomName() {
        return symptomName;
    }

    public void setSymptomName(String symptomName) {
        this.symptomName = symptomName;
    }

    public String getSymptomDescription() {
        return symptomDescription;
    }

    public void setSymptomDescription(String symptomDescription) {
        this.symptomDescription = symptomDescription;
    }

    public String getSymptomRisk() {
        return symptomRisk;
    }

    public void setSymptomRisk(String symptomRisk) {
        this.symptomRisk = symptomRisk;
    }

    public String getSymptomCauses() {
        return symptomCauses;
    }

    public void setSymptomCauses(String symptomCauses) {
        this.symptomCauses = symptomCauses;
    }

    public String getSymptomSolution() {
        return symptomSolution;
    }

    public void setSymptomSolution(String symptomSolution) {
        this.symptomSolution = symptomSolution;
    }

    public String getSymptomImageResource() {
        return symptomImageResource;
    }

    public void setSymptomImageResource(String symptomImageResource) {
        this.symptomImageResource = symptomImageResource;
    }
}
