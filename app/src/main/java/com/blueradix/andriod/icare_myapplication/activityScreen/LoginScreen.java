package com.blueradix.andriod.icare_myapplication.activityScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.blueradix.andriod.icare_myapplication.MainActivity;
import com.blueradix.andriod.icare_myapplication.R;
import com.blueradix.andriod.icare_myapplication.database.ApplicationDatabaseHelper;

public class LoginScreen extends AppCompatActivity
{
    EditText userName, password;
    Button loginButton;
    ApplicationDatabaseHelper applicationDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        // Assign the id from xml files to variables provided
        userName = (EditText)findViewById(R.id.usernameLoginEditText);
        password = (EditText)findViewById(R.id.passwordLoginEditText);
        applicationDatabaseHelper = new ApplicationDatabaseHelper(this);

        // Set action for " log in button to home page " passing by intent
        Button loginToHomePageButton = findViewById(R.id.loginToHomePageButton);
        loginToHomePageButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String username = userName.getText().toString();
                String userPassword = password.getText().toString();
                if(username.isEmpty() || userPassword.isEmpty())
                {
                    Toast.makeText(LoginScreen.this, "Please enter again", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean checkUserLoginData = applicationDatabaseHelper.checkUserLogin(username, userPassword);
                    if(checkUserLoginData == true)
                    {
                        Toast.makeText(LoginScreen.this, "Log In Successfully", Toast.LENGTH_SHORT).show();
                        Intent goToLoginToHomePageScreenIntent = new Intent(LoginScreen.this, HomeScreen.class);
                        startActivity(goToLoginToHomePageScreenIntent);
                    }
                    else
                    {
                        Toast.makeText(LoginScreen.this, "Invalid information! Please try again", Toast.LENGTH_SHORT).show();
                    }
                }

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