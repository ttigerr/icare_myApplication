package com.blueradix.andriod.icare_myapplication.activityScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.blueradix.andriod.icare_myapplication.MainActivity;
import com.blueradix.andriod.icare_myapplication.R;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        // Set action to go to login screen passing by intent
        ImageButton diagnosticImageButton = findViewById(R.id.diagnosticImageButton);
        diagnosticImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent goToDiagnosticScreenIntent = new Intent(HomeScreen.this, DiagnosticScreen.class);
                startActivity(goToDiagnosticScreenIntent);
            }
        });
    }
}