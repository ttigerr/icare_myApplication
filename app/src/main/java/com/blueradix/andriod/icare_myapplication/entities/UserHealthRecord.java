package com.blueradix.andriod.icare_myapplication.entities;

public class UserHealthRecord
{
    public static final String RECORD_KEY = "record_key";
    public long id;
    public String recordTitle;
    public String recordDate;
    public String recordDescription;
    public String recordSideEffect;
    public String recordImageResource;
    public Long userId;

    // constructor


    public UserHealthRecord(long id, String recordTitle, String recordDate, String recordDescription, String recordSideEffect, String recordImageResource, Long userId)
    {
        this.id = id;
        this.recordTitle = recordTitle;
        this.recordDate = recordDate;
        this.recordDescription = recordDescription;
        this.recordSideEffect = recordSideEffect;
        this.recordImageResource = recordImageResource;
        this.userId = userId;
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

    public String getRecordImageResource() {
        return recordImageResource;
    }

    public void setRecordImageResource(String recordImageResource) {
        this.recordImageResource = recordImageResource;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString()
    {
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
