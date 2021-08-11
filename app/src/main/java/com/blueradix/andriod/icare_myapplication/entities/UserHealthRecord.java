package com.blueradix.andriod.icare_myapplication.entities;

public class UserHealthRecord
{
    private long id;
    private String recordTitle;
    private String recordDate;
    private String recordDescription;
    private String recordSideEffect;
    private int recordImageResource;

    // constructor


    public UserHealthRecord(long id, String recordTitle, String recordDate, String recordDescription, String recordSideEffect, int recordImageResource)
    {
        this.id = id;
        this.recordTitle = recordTitle;
        this.recordDate = recordDate;
        this.recordDescription = recordDescription;
        this.recordSideEffect = recordSideEffect;
        this.recordImageResource = recordImageResource;
    }

    // Default constructor
    public UserHealthRecord() {
    }


    // Getter and Setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRecordTitle() {
        return recordTitle;
    }

    public void setRecordTitle(String recordTitle) {
        this.recordTitle = recordTitle;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public String getRecordDescription() {
        return recordDescription;
    }

    public void setRecordDescription(String recordDescription) {
        this.recordDescription = recordDescription;
    }

    public String getRecordSideEffect() {
        return recordSideEffect;
    }

    public void setRecordSideEffect(String recordSideEffect) {
        this.recordSideEffect = recordSideEffect;
    }

    public int getRecordImageResource() {
        return recordImageResource;
    }

    public void setRecordImageResource(int recordImageResource) {
        this.recordImageResource = recordImageResource;
    }

    @Override
    public String toString() {
        return "UserHealthRecord{" +
                "id=" + id +
                ", recordTitle='" + recordTitle + '\'' +
                ", recordDate='" + recordDate + '\'' +
                ", recordDescription='" + recordDescription + '\'' +
                ", recordRisk='" + recordSideEffect + '\'' +
                ", recordImageResource=" + recordImageResource +
                '}';
    }
}
