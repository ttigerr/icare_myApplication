package com.blueradix.andriod.icare_myapplication.activityScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.blueradix.andriod.icare_myapplication.MainActivity;
import com.blueradix.andriod.icare_myapplication.R;

public class RegisterScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);

        // Set action for " register button to home page " passing by intent
        Button registerToHomePageButton = findViewById(R.id.registerToHomePageButton);
        registerToHomePageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent goToRegisterToHomePageScreenIntent = new Intent(RegisterScreen.this, HomeScreen.class);
                startActivity(goToRegisterToHomePageScreenIntent);
            }
        });

        // Set action for " return back to on boarding screen " passing by intent
        ImageButton returnToOnBoardingScreenButton = findViewById(R.id.returnButton2);
        returnToOnBoardingScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent returnToOnBoardingScreenIntent = new Intent(RegisterScreen.this, MainActivity.class);
                startActivity(returnToOnBoardingScreenIntent);
            }
        });
    }
}