package com.blueradix.andriod.icare_myapplication.activityScreen;

import android.content.Intent;
import android.os.Bundle;

import com.blueradix.andriod.icare_myapplication.R;
import com.blueradix.andriod.icare_myapplication.entities.DoctorLists;
import com.blueradix.andriod.icare_myapplication.entities.SymptomItems;
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
    DoctorLists doctor;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivityDoctorContentScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //setContentView(R.layout.activity_doctor_content_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDoctorIntentData();
            }
        });

        doctorName = findViewById(R.id.doctorNameTextview);
        doctorType = findViewById(R.id.doctorTypeTextView);
        doctorDescription = findViewById(R.id.doctorDescriptionTextView);
        achievement = findViewById(R.id.doctorArchievementTextview);
        contactDetail = findViewById(R.id.doctorContactDetailTextView);
        doctorImage = findViewById(R.id.doctorImageView);

        // Get the intent from the DoctorViewAdapter
        /*Intent doctorIntent = getIntent();
        String doctorName = doctorIntent.getExtras().getString("Doctor Name");
        String doctorType = doctorIntent.getExtras().getString("Doctor Type");
        String doctorDescription = doctorIntent.getExtras().getString("Description");
        String doctorAchievement = doctorIntent.getExtras().getString("Achievements");
        String doctorContactNumber = doctorIntent.getExtras().getString("Contact Detail");
        int doctorImage = doctorIntent.getExtras().getInt("Image");*/

        Intent intentThatCalled = getIntent();
        if(intentThatCalled.hasExtra(DoctorLists.DOCTOR_KEY))
        {
            doctor = (DoctorLists) intentThatCalled.getSerializableExtra(DoctorLists.DOCTOR_KEY);

        }

        doctorName.setText(doctor.getDoctorName());
        doctorType.setText(doctor.getDoctorType());
        doctorDescription.setText(doctor.getDescription());
        achievement.setText(doctor.getAchievement());
        contactDetail.setText(doctor.getContactNumber());
        View rootView = binding.doctorImageView.getRootView();
        int resID = rootView.getResources().getIdentifier(doctor.doctorImageResource , "mipmap" , rootView.getContext().getPackageName());
        binding.doctorImageView.setImageResource(resID);

    }

    @Override
    public void onBackPressed()
    {
        setDoctorIntentData();
        super.onBackPressed();
    }

    private void setDoctorIntentData()
    {
        Intent doctorIntent = new Intent();
        doctorIntent.putExtra(DoctorLists.DOCTOR_KEY, doctor);
        setResult(RESULT_OK, doctorIntent);
        finish();
    }
}