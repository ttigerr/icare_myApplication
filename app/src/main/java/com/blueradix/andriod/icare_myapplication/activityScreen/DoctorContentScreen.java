package com.blueradix.andriod.icare_myapplication.activityScreen;

import android.content.Intent;
import android.os.Bundle;

import com.blueradix.andriod.icare_myapplication.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blueradix.andriod.icare_myapplication.databinding.ActivityDoctorContentScreenBinding;

public class DoctorContentScreen extends AppCompatActivity {

    ActivityDoctorContentScreenBinding binding;
    private TextView doctorName, doctorType, doctorDescription, achievement, contactDetail;
    private ImageView doctorImage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivityDoctorContentScreenBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_doctor_content_screen);

        doctorName = (TextView)findViewById(R.id.doctorNameTextview);
        doctorType = (TextView)findViewById(R.id.doctorTypeTextView);
        doctorDescription = (TextView)findViewById(R.id.doctorDescriptionTextView);
        achievement = (TextView)findViewById(R.id.doctorArchievementTextview);
        contactDetail = (TextView)findViewById(R.id.doctorContactDetailTextView);
        doctorImage = (ImageView)findViewById(R.id.doctorImageView);

        // Get the intent from the DoctorViewAdapter
        Intent doctorIntent = getIntent();
        String doctorName = doctorIntent.getExtras().getString("Doctor Name");
        String doctorType = doctorIntent.getExtras().getString("Doctor Type");
        String doctorDescription = doctorIntent.getExtras().getString("Description");
        String doctorAchievement = doctorIntent.getExtras().getString("Achievements");
        String doctorContactNumber = doctorIntent.getExtras().getString("Contact Detail");
        //int doctorImage = doctorIntent.getExtras().getInt("Image");

        // Set values
        this.doctorName.setText(doctorName);
        this.doctorType.setText(doctorType);
        this.doctorDescription.setText(doctorDescription);
        this.achievement.setText(doctorAchievement);
        this.contactDetail.setText(doctorContactNumber);
        //this.doctorImage.setImageResource(doctorImage);


        /*Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());*/


    }
}