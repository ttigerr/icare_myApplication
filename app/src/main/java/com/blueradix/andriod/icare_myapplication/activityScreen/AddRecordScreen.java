package com.blueradix.andriod.icare_myapplication.activityScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blueradix.andriod.icare_myapplication.R;
import com.blueradix.andriod.icare_myapplication.entities.UserHealthRecord;
import com.google.android.material.snackbar.Snackbar;

public class AddRecordScreen extends AppCompatActivity
{

    private EditText recordTitleEditText, recordDateEditText, recordDescriptionEditText, recordSideEffectEditText;
    private UserHealthRecord userRecord;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record_screen);

        // Set the action for " add record " button
        Button addRecordButton = findViewById(R.id.addRecordButton);
        recordTitleEditText = findViewById(R.id.RecordTitleEditText);
        recordDateEditText = findViewById(R.id.RecordDateEditText);
        recordDescriptionEditText = findViewById(R.id.RecordDescriptionEditText);
        recordSideEffectEditText = findViewById(R.id.RecordSideEffectEditText);

        addRecordButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Go to the record main page when user add their record
                /*Intent addRecordScreenIntent = new Intent(AddRecordScreen.this , RecordHealthScreen.class);
                startActivity(addRecordScreenIntent);
                Toast.makeText(AddRecordScreen.this, "Record added successfully", Toast.LENGTH_SHORT).show();*/
                addNewData(v);
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

    public void addNewData(View view)
    {
        String title = recordTitleEditText.getText().toString();
        String date = recordDateEditText.getText().toString();
        String description = recordDescriptionEditText.getText().toString();
        String sideEffect = recordSideEffectEditText.getText().toString();

        if(title.trim().isEmpty())
        {
            Snackbar.make(view, R.string.activity_add_doctor_message_required, Snackbar.LENGTH_SHORT).show();
            recordTitleEditText.getText().clear();
            recordTitleEditText.requestFocus();
            return;
        }
        userRecord = new UserHealthRecord();
        userRecord.setRecordTitle(title);
        userRecord.setRecordDate(date);
        userRecord.setRecordDescription(description);
        userRecord.setRecordDescription(sideEffect);

        Intent addRecordScreenIntent = new Intent();
        addRecordScreenIntent.putExtra(UserHealthRecord.RECORD_KEY, userRecord);
        setResult(RESULT_OK, addRecordScreenIntent);
        //startActivity(addRecordScreenIntent);
        Toast.makeText(AddRecordScreen.this, "Record added successfully", Toast.LENGTH_SHORT).show();

    }
}