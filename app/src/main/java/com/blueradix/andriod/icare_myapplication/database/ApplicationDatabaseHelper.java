package com.blueradix.andriod.icare_myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ApplicationDatabaseHelper extends SQLiteOpenHelper
{
    private static final String TAG = ApplicationDatabaseHelper.class.getName();

    private static ApplicationDatabaseHelper mInstance = null;
    private Context context;

    //create database constants
    private static final String DATABASE_NAME = "icareApplication.db";
    private static final Integer DATABASE_VERSION = 1;

    // Create database for users
    private static final String TABLE_USERS = "USERS";
    private static final String COL_ID = "ID";
    private static final String COL_USER_NAME = "USERNAME";
    private static final String COL_EMAIL = "EMAIL";
    private static final String COL_PASSWORD = "PASSWORD";

    private static final String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USERS + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_USER_NAME + " TEXT, " +
            COL_EMAIL + " TEXT, " +
            COL_PASSWORD + " TEXT )";

    private static final String DROP_TABLE_USER = " DROP TABLE IF EXISTS " + TABLE_USERS;
    private static final String GET_ALL_USER = "SELECT * FROM " + TABLE_USERS;

    public static synchronized ApplicationDatabaseHelper getInstance(Context ctx)
    {
        if (mInstance == null) {
            mInstance = new ApplicationDatabaseHelper(ctx.getApplicationContext());
        }
        return mInstance;
    }

    public ApplicationDatabaseHelper(@Nullable Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL(DROP_TABLE_USER);
        onCreate(db);
    }

    // Table for USERS
    // Insert new users and store into database
    public Boolean insertNewUser(String userName, String userEmail, String userPassword)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_USER_NAME, userName);
        contentValues.put(COL_EMAIL, userEmail);
        contentValues.put(COL_PASSWORD, userPassword);

        long Result = database.insert(TABLE_USERS, null, contentValues);
        // If the result is fail
        if(Result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    // Check users login including with username and password
    public Boolean checkUserLogin(String username, String password)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("select * from USERS where username = ? and password = ?", new String[] {username, password});
        if(cursor.getCount() > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // TABLE FOR SYMPTOMS

}
