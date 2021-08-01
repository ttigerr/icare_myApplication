package com.blueradix.andriod.icare_myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.blueradix.andriod.icare_myapplication.activityScreen.LoginScreen;
import com.blueradix.andriod.icare_myapplication.activityScreen.RegisterScreen;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set action to go to login screen passing by intent
        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent goToLoginScreenIntent = new Intent(MainActivity.this, LoginScreen.class);
                startActivity(goToLoginScreenIntent);
            }
        });

        // Set action to go to register screen passing by intent
        Button registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent goToRegisterScreenIntent = new Intent(MainActivity.this, RegisterScreen.class);
                startActivity(goToRegisterScreenIntent);
            }
        });
    }


}