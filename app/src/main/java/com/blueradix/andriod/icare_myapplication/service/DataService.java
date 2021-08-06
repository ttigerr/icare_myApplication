package com.blueradix.andriod.icare_myapplication.service;

import android.content.Context;

import com.blueradix.andriod.icare_myapplication.database.ApplicationDatabaseHelper;
import com.blueradix.andriod.icare_myapplication.entities.Users;

public class DataService
{
    private ApplicationDatabaseHelper sqlite;

    public void connect(){

    }

    public void disconnect(){

    }

    public void initUser(Context context){
        sqlite = sqlite.getInstance(context);
    }

    public Boolean add(Users users){
        return sqlite.insertNewUser(users.getUserName(), users.getEmail(), users.getPassword());
    }
}
