package com.blueradix.andriod.icare_myapplication.activityScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.blueradix.andriod.icare_myapplication.R;
import com.blueradix.andriod.icare_myapplication.databinding.ActivitySymptomContentScreenBinding;

public class SymptomContentScreen extends AppCompatActivity
{
    private TextView symptomName, symptomDescription, symptomRisk, symptomCause, symptomSolution;
    ActivitySymptomContentScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom_content_screen);
        binding = ActivitySymptomContentScreenBinding.inflate(getLayoutInflater());

        // Assign the variable into the layout
        symptomName = (TextView)findViewById(R.id.symptomNameTextview);
        symptomDescription = (TextView)findViewById(R.id.symptomDescriptionTextView);
        symptomRisk = (TextView)findViewById(R.id.symptomRiskTextview);
        symptomCause = (TextView)findViewById(R.id.symptomCausesTextView);
        symptomSolution = (TextView)findViewById(R.id.symtomSolutionTextView);

        // Get intents from the symptomViewAdapter
        Intent symptomIntent = getIntent();
        String symptomName = symptomIntent.getExtras().getString("Symptom Name");
        String symptomDescription = symptomIntent.getExtras().getString("Symptom Description");
        String symptomRisk = symptomIntent.getExtras().getString("Symptom Risk");
        String symptomCause = symptomIntent.getExtras().getString("Symptom Cause");
        String symptomSolution = symptomIntent.getExtras().getString("Symptom Solution");

        // update the data
        this.symptomName.setText(symptomName);
        this.symptomDescription.setText(symptomDescription);
        this.symptomRisk.setText(symptomRisk);
        this.symptomCause.setText(symptomCause);
        this.symptomSolution.setText(symptomSolution);


    }
}