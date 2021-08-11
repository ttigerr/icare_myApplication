package com.blueradix.andriod.icare_myapplication.activityScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.blueradix.andriod.icare_myapplication.R;
import com.blueradix.andriod.icare_myapplication.entities.SymptomItems;

import java.util.ArrayList;
import java.util.List;

public class HomeScreen extends AppCompatActivity
{
    int index = 0;
    List<SymptomItems> symptomList;
    SymptomItems symptom;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        // Set action to go to diagnostic screen passing by intent
        ImageButton diagnosticImageButton = findViewById(R.id.diagnosticImageButton);
        diagnosticImageButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent goToDiagnosticScreenIntent = new Intent(HomeScreen.this, SymptomScreen.class);
                startActivity(goToDiagnosticScreenIntent);
            }
        });

        // Set action to go to doctor screen passing by intent
        ImageButton doctorImageButton = findViewById(R.id.doctorImageButton);
        doctorImageButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent goToDoctorScreenIntent = new Intent(HomeScreen.this, DoctorScreen.class);
                startActivity(goToDoctorScreenIntent);
            }
        });

        // Set action to go to Health record screen passing by intent
        ImageButton recordHealthButton = findViewById(R.id.recordHealthImageButton);
        recordHealthButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent goToRecordHealthScreenIntent = new Intent(HomeScreen.this, RecordHealthScreen.class);
                startActivity(goToRecordHealthScreenIntent);
            }
        });

        // Set the action in buttons to display
        ImageButton headacheButton = findViewById(R.id.headacheScreenButton);
        headacheButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                index = 1;
                if(symptom.getSymptomId() == index)
                {
                    Intent goToSymptomDetailIntent = new Intent(HomeScreen.this, SymptomContentScreen.class);
                    goToSymptomDetailIntent.putExtra("Symptom Name",symptomList.get(0).getSymptomName());
                    goToSymptomDetailIntent.putExtra("Symptom Description",symptomList.get(0).getSymptomDescription());
                    goToSymptomDetailIntent.putExtra("Symptom Risk",symptomList.get(0).getSymptomRisk());
                    goToSymptomDetailIntent.putExtra("Symptom Cause",symptomList.get(0).getSymptomCauses());
                    goToSymptomDetailIntent.putExtra("Symptom Solution",symptomList.get(0).getSymptomSolution());

                    startActivity(goToSymptomDetailIntent);
                }
            }
        });

    }
}