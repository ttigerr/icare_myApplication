package com.blueradix.andriod.icare_myapplication.service;

import android.content.Context;

import com.blueradix.andriod.icare_myapplication.database.ApplicationDatabaseHelper;
import com.blueradix.andriod.icare_myapplication.entities.DoctorLists;
import com.blueradix.andriod.icare_myapplication.entities.SymptomItems;
import com.blueradix.andriod.icare_myapplication.entities.Users;

import java.util.List;

public class DataService
{
    private ApplicationDatabaseHelper sqlite;

    public void connect(){

    }

    public void disconnect(){

    }

    public void init(Context context){
        sqlite = sqlite.getInstance(context);
    }

    public Boolean add(Users users){
        return sqlite.insertNewUser(users.getUserName(), users.getEmail(), users.getPassword());
    }

    // Add new symptom data to database
    /*public Boolean add(SymptomItems symptoms)
    {
        return sqlite.insertSymptom(symptoms.getSymptomName(), symptoms.getSymptomDescription(), symptoms.getSymptomRisk(),
                symptoms.getSymptomCauses(), symptoms.getSymptomSolution(), symptoms.getSymptomImageResource());
    }*/

    public List<SymptomItems> getSymptom()
    {
        List<SymptomItems> symptoms = sqlite.getSymptom();
        return symptoms;
    }

    public List<DoctorLists> getDoctor()
    {
        List<DoctorLists> doctors = sqlite.getDoctor();
        return doctors;
    }
}

