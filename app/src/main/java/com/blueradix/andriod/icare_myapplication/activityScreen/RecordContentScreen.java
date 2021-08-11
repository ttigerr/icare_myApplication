package com.blueradix.andriod.icare_myapplication.activityScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.blueradix.andriod.icare_myapplication.R;

public class RecordContentScreen extends AppCompatActivity
{
    private TextView recordTitle, recordDate, recordDescription, recordSideEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_content_screen);

        recordTitle = (TextView)findViewById(R.id.recordTitleTextview);
        recordDate = (TextView)findViewById(R.id.recordDateTextView);
        recordDescription = (TextView)findViewById(R.id.recordDescriptionTextView);
        recordSideEffect = (TextView)findViewById(R.id.recordSideEffectTextview);

        // The hardcode to store the data
        // Get intents from the symptomViewAdapter
        Intent recordIntent = getIntent();
        String recordTitle = recordIntent.getExtras().getString("Record Name");
        String recordDate = recordIntent.getExtras().getString("Record Date");
        String recordDescription = recordIntent.getExtras().getString("Record Description");
        String recordSideEffect = recordIntent.getExtras().getString("Record SideEffect");

        // Set the data
        this.recordTitle.setText(recordTitle);
        this.recordDate.setText(recordDate);
        this.recordDescription.setText(recordDescription);
        this.recordSideEffect.setText(recordSideEffect);

    }
}