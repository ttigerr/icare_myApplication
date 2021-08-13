package com.blueradix.andriod.icare_myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.blueradix.andriod.icare_myapplication.entities.DoctorLists;
import com.blueradix.andriod.icare_myapplication.entities.SymptomItems;
import com.blueradix.andriod.icare_myapplication.entities.UserHealthRecord;

import java.util.ArrayList;
import java.util.List;

public class ApplicationDatabaseHelper extends SQLiteOpenHelper
{
    private static final String TAG = ApplicationDatabaseHelper.class.getName();

    private static ApplicationDatabaseHelper mInstance = null;
    private Context context;

    //create database constants
    private static final String DATABASE_NAME = "icareApplication.db";
    private static final Integer DATABASE_VERSION = 1;

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
        db.execSQL(CREATE_TABLE_SYMPTOM);
        db.execSQL(CREATE_TABLE_DOCTOR);
        db.execSQL(CREATE_TABLE_RECORD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL(DROP_TABLE_USER);
        db.execSQL(DROP_TABLE_SYMPTOM);
        db.execSQL(DROP_TABLE_DOCTOR);
        db.execSQL(DROP_TABLE_RECORD);
        onCreate(db);
    }

    // Table for USER LOGIN
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
    // insert a new table on schema
    private static final String TABLE_SYMPTOM = "SYMPTOMS";
    private static final String COL_SYMPTOM_ID = "ID";
    private static final String COL_SYMPTOM_NAME = "NAME";
    private static final String COL_SYMPTOM_DESCRIPTION = "DESCRIPTION";
    private static final String COL_SYMPTOM_RISK = "RISK";
    private static final String COL_SYMPTOM_CAUSE = "CAUSE";
    private static final String COL_SYMPTOM_SOLUTION = "SOLUTION";
    private static final String COL_SYMPTOM_IMAGE = "IMAGE";

    private static final String CREATE_TABLE_SYMPTOM = "CREATE TABLE " + TABLE_SYMPTOM + "(" + COL_SYMPTOM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_SYMPTOM_NAME + " TEXT, " +
            COL_SYMPTOM_DESCRIPTION + " TEXT, " +
            COL_SYMPTOM_RISK + " TEXT, " +
            COL_SYMPTOM_CAUSE + " TEXT, " +
            COL_SYMPTOM_SOLUTION + " TEXT, " +
            COL_SYMPTOM_IMAGE + " TEXT )";

    private static final String DROP_TABLE_SYMPTOM = " DROP TABLE IF EXISTS " + TABLE_SYMPTOM;
    private static final String GET_ALL_SYMPTOM = "SELECT * FROM " + TABLE_SYMPTOM;

    // Insert new symptom on database table
   /* public Boolean insertSymptom(String symptomName, String symptomDescription, String symptomRisk, String symptomCause, String symptomSolution, String symptomImage)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_SYMPTOM_NAME, symptomName);
        contentValues.put(COL_SYMPTOM_DESCRIPTION, symptomDescription);
        contentValues.put(COL_SYMPTOM_RISK, symptomRisk);
        contentValues.put(COL_SYMPTOM_CAUSE, symptomCause);
        contentValues.put(COL_SYMPTOM_SOLUTION, symptomSolution);
        contentValues.put(COL_SYMPTOM_IMAGE, symptomImage);

        long Result = database.insert(TABLE_SYMPTOM, null, contentValues);
        // If the result is fail
        if(Result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }*/

    // Only use the cursor to paste the data in it
    public List<SymptomItems> getSymptom() {
        List<SymptomItems> symptom = new ArrayList<>();
        Cursor cursor = getAllSymptom();

        if(cursor.getCount() > 0) {
            SymptomItems symptoms;
            while (cursor.moveToNext()) {
                Long id = cursor.getLong(0);
                String name = cursor.getString(1);
                String description = cursor.getString(2);
                String risk = cursor.getString(3);
                String cause = cursor.getString(4);
                String solution = cursor.getString(5);
                String image = cursor.getString(6);

                symptoms = new SymptomItems(id, name, description, risk, cause, solution, image);
                symptom.add(symptoms);
            }
        }
        cursor.close();
        return symptom;
    }

    private Cursor getAllSymptom()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(GET_ALL_SYMPTOM, null);
    }

    // TABLE FOR DOCTOR
    // Insert a new table on schema
    private static final String TABLE_DOCTOR = "DOCTORS";
    private static final String COL_DOCTOR_ID = "ID";
    private static final String COL_DOCTOR_NAME = "NAME";
    private static final String COL_DOCTOR_TYPE = "TYPE";
    private static final String COL_DOCTOR_DESCRIPTION = "DESCRIPTION";
    private static final String COL_DOCTOR_ACHIEVEMENT = "ACHIEVEMENT";
    private static final String COL_DOCTOR_CONTACT = "CONTACT";
    private static final String COL_DOCTOR_IMAGE = "IMAGE";

    private static final String CREATE_TABLE_DOCTOR = "CREATE TABLE " + TABLE_DOCTOR + "(" + COL_DOCTOR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_DOCTOR_NAME + " TEXT, " +
            COL_DOCTOR_TYPE + " TEXT, " +
            COL_DOCTOR_DESCRIPTION + " TEXT, " +
            COL_DOCTOR_ACHIEVEMENT + " TEXT, " +
            COL_DOCTOR_CONTACT + " TEXT, " +
            COL_DOCTOR_IMAGE + " TEXT )";

    private static final String DROP_TABLE_DOCTOR = " DROP TABLE IF EXISTS " + TABLE_DOCTOR;
    private static final String GET_ALL_DOCTOR = "SELECT * FROM " + TABLE_DOCTOR;
    private static final String GET_DOCTOR_BY_ID = "SELECT * FROM " + TABLE_DOCTOR + "WHERE" + COL_DOCTOR_ID + " = ? ";;

    // Only use the cursor to paste the data in it
    public List<DoctorLists> getDoctor()
    {
        List<DoctorLists> doctor = new ArrayList<>();
        Cursor cursor = getAllDoctor();

        if(cursor.getCount() > 0) {
            DoctorLists doctors;
            while (cursor.moveToNext()) {
                Long id = cursor.getLong(0);
                String name = cursor.getString(1);
                String type = cursor.getString(2);
                String description = cursor.getString(3);
                String achievement = cursor.getString(4);
                String contact = cursor.getString(5);
                String image = cursor.getString(6);

                doctors = new DoctorLists(id, name, type, description, achievement, contact, image);
                doctor.add(doctors);
            }
        }
        cursor.close();
        return doctor;
    }

    private Cursor getAllDoctor()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(GET_ALL_DOCTOR, null);
    }

    public DoctorLists getDoctors(Long id)
    {
        SQLiteDatabase database = this.getReadableDatabase();
        DoctorLists doctor = null;
        Cursor cursor = database.rawQuery(GET_DOCTOR_BY_ID, new String[]{id.toString()});
        if(cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String name = cursor.getString(1);
                String type = cursor.getString(2);
                String description = cursor.getString(3);
                String achievement = cursor.getString(4);
                String contact = cursor.getString(5);
                String image = cursor.getString(6);

                doctor = new DoctorLists(id, name, type, description, achievement, contact, image);
            }
        }
        cursor.close();
        return doctor;
    }

    // TABLE FOR DOCTOR
    // Insert a new table on schema
    private static final String TABLE_RECORD = "RECORDS";
    private static final String COL_RECORD_ID = "ID";
    private static final String COL_RECORD_TITLE = "TITLE";
    private static final String COL_RECORD_DATE = "DATE";
    private static final String COL_RECORD_DESCRIPTION = "DESCRIPTION";
    private static final String COL_RECORD_SIDEEFFECT = "EFFECT";
    private static final String COL_RECORD_IMAGE = "IMAGE";
    private static final String COL_USER_ID = "USERID";

    private static final String CREATE_TABLE_RECORD = "CREATE TABLE " + TABLE_RECORD + "(" + COL_RECORD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_RECORD_TITLE + " TEXT, " +
            COL_RECORD_DATE + " TEXT, " +
            COL_RECORD_DESCRIPTION + " TEXT, " +
            COL_RECORD_SIDEEFFECT + " TEXT, " +
            COL_RECORD_IMAGE + " TEXT, " +
            COL_USER_ID + " INTEGER )";
            /*COL_ID + " INTEGER, " +
            "FOREIGN KEY(" + COL_ID + ") REFERENCES " + TABLE_USERS + "(" + COL_ID + ")" + ")";*/

    private static final String DROP_TABLE_RECORD = " DROP TABLE IF EXISTS " + TABLE_RECORD;
    private static final String GET_ALL_RECORD = "SELECT * FROM " + TABLE_RECORD;
    private static final String GET_RECORD_BY_USERID = "SELECT * FROM " + TABLE_RECORD + "WHERE" + COL_USER_ID + "= ? ";

    public List<UserHealthRecord> getRecord()
    {
        List<UserHealthRecord> record = new ArrayList<>();
        Cursor cursor = getAllDoctor();

        if(cursor.getCount() > 0) {
            UserHealthRecord records;
            while (cursor.moveToNext()) {
                Long id = cursor.getLong(0);
                String title = cursor.getString(1);
                String date = cursor.getString(2);
                String description = cursor.getString(3);
                String sideEffect = cursor.getString(4);
                String image = cursor.getString(5);
                Long userId = cursor.getLong(6);

                records = new UserHealthRecord(id, title, date, description, sideEffect, image, userId);
                record.add(records);
            }
        }
        cursor.close();
        return record;
    }

    public List<UserHealthRecord> getRecordByUserId(Long userId)
    {
        List<UserHealthRecord> record = new ArrayList<>();
        Cursor cursor = getAllRecordByUserId(userId);

        if(cursor.getCount() > 0) {
            UserHealthRecord records;
            while (cursor.moveToNext()) {
                Long id = cursor.getLong(0);
                String title = cursor.getString(1);
                String date = cursor.getString(2);
                String description = cursor.getString(3);
                String sideEffect = cursor.getString(4);
                String image = cursor.getString(5);
                //Long userId = cursor.getLong(6);

                records = new UserHealthRecord(id, title, date, description, sideEffect, image, userId);
                record.add(records);
            }
        }
        cursor.close();
        return record;
    }

    public UserHealthRecord getRecords( Long id )
    {
        SQLiteDatabase db = this.getReadableDatabase();
        UserHealthRecord records = null;
        Cursor cursor = db.rawQuery(GET_RECORD_BY_USERID, new String[]{id.toString()});


        if(cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String title = cursor.getString(1);
                String date = cursor.getString(2);
                String description = cursor.getString(3);
                String sideEffect = cursor.getString(4);
                String image = cursor.getString(5);
                Long userId = cursor.getLong(6);

                records = new UserHealthRecord(id, title, date, description, sideEffect, image, userId);
            }
        }
        cursor.close();
        return records;
    }

    private Cursor getAllRecord()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(GET_ALL_RECORD, null);
    }

    private Cursor getAllRecordByUserId( Long userId )
    {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(GET_RECORD_BY_USERID, new String[]{userId.toString()});
    }


}
