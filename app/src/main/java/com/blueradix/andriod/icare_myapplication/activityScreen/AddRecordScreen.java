package com.blueradix.andriod.icare_myapplication.activityScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.blueradix.andriod.icare_myapplication.R;

public class AddRecordScreen extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record_screen);

        // Set the action for " add record " button
        Button addRecordButton = findViewById(R.id.addRecordButton);
        addRecordButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Go to the record main page when user add their record
                Intent addRecordScreenIntent = new Intent(AddRecordScreen.this , RecordHealthScreen.class);
                startActivity(addRecordScreenIntent);
                Toast.makeText(AddRecordScreen.this, "Record added successfully", Toast.LENGTH_SHORT).show();
            }
        });

        // Set the action for " cancel record " button
        Button cancelRecordButton = findViewById(R.id.cancelRecordButton);
        cancelRecordButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Go to the record main page when user cancel their record
                Intent cancelRecordScreenIntent = new Intent(AddRecordScreen.this , RecordHealthScreen.class);
                startActivity(cancelRecordScreenIntent);
            }
        });
    }
}