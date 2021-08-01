package com.blueradix.andriod.icare_myapplication.activityScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.blueradix.andriod.icare_myapplication.MainActivity;
import com.blueradix.andriod.icare_myapplication.R;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        // Set action for " log in button to home page " passing by intent
        Button loginToHomePageButton = findViewById(R.id.loginToHomePageButton);
        loginToHomePageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent goToLoginToHomePageScreenIntent = new Intent(LoginScreen.this, HomeScreen.class);
                startActivity(goToLoginToHomePageScreenIntent);
            }
        });

        // Set action for " return back to on boarding screen " passing by intent
        ImageButton returnToOnBoardingScreenButton = findViewById(R.id.returnButton);
        returnToOnBoardingScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent returnToOnBoardingScreenIntent = new Intent(LoginScreen.this, MainActivity.class);
                startActivity(returnToOnBoardingScreenIntent);
            }
        });
    }
}