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

public class RegisterScreen extends AppCompatActivity
{
    EditText userName, userEmail, userPassword;
    Button registerButton;
    ApplicationDatabaseHelper applicationDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);

        // Assign the id from xml files to variables provided
        userName = (EditText)findViewById(R.id.userNameEditText);
        userEmail = (EditText)findViewById(R.id.emailEditText);
        userPassword = (EditText)findViewById(R.id.passwordEditText);
        applicationDatabase = new ApplicationDatabaseHelper(this);

        // Set action for " register button to home page " passing by intent
        Button registerToHomePageButton = findViewById(R.id.registerToHomePageButton);
        registerToHomePageButton.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                String username = userName.getText().toString();
                String email = userEmail.getText().toString();
                String password = userPassword.getText().toString();

                // When forms are empty then display a message
                if(username.isEmpty() || email.isEmpty() || password.isEmpty())
                {
                    Toast.makeText(RegisterScreen.this, "Please fill all the fields!", Toast.LENGTH_SHORT).show();
                }
                // Continue to the next step which is add user data
                else
                {
                    Boolean insert = applicationDatabase.insertNewUser(username, email, password);
                    if(insert== true)
                    {
                        Toast.makeText(RegisterScreen.this, "Registered successfully", Toast.LENGTH_SHORT).show();

                        // Go to the homepage successfully by passing intent
                        Intent goToRegisterToHomePageScreenIntent = new Intent(RegisterScreen.this, HomeScreen.class);
                        startActivity(goToRegisterToHomePageScreenIntent);
                    }
                }
            }
        });

        // Set action for " return back to on boarding screen " passing by intent
        ImageButton returnToOnBoardingScreenButton = findViewById(R.id.returnButton2);
        returnToOnBoardingScreenButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                    Intent returnToOnBoardingScreenIntent = new Intent(RegisterScreen.this, MainActivity.class);
                    startActivity(returnToOnBoardingScreenIntent);

            }
        });
    }


}