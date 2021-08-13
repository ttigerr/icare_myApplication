package com.blueradix.andriod.icare_myapplication.activityScreen;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.blueradix.andriod.icare_myapplication.R;
import com.blueradix.andriod.icare_myapplication.entities.DoctorLists;
import com.blueradix.andriod.icare_myapplication.recyclerView.DoctorViewAdapter;
import com.blueradix.andriod.icare_myapplication.recyclerView.OnDoctorListener;
import com.blueradix.andriod.icare_myapplication.service.DataService;

import java.util.ArrayList;
import java.util.List;

import static com.blueradix.andriod.icare_myapplication.entities.Constants.DOCTOR_CONTENT_ACTIVITY_CODE;


public class DoctorScreen extends AppCompatActivity implements OnDoctorListener
{
    private DataService doctorDataService;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter dAdapter;
    private RecyclerView.LayoutManager dLayoutManager;
    List<DoctorLists> doctorList;
    DoctorLists doctor;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_screen);

        /*// Store the data and display it in arrays
        doctorList = new ArrayList<>();
        doctorList.add(new DoctorLists(1,"David jones", "Consulting", "s simply dummy text of the printing and typesetting industry.", "The best doctor awards 2021", "0423232323", R.mipmap.ic_lmage1));
        doctorList.add(new DoctorLists(2,"Natalie Evans", "Pharmacist", "s simply dummy text of the printing and typesetting industry.", "The best doctor awards 2021", "0423232323", R.mipmap.ic_doctor1));
        doctorList.add(new DoctorLists(3,"Emma jones", "Physician", "s simply dummy text of the printing and typesetting industry.", "The best doctor awards 2021", "0423232323", R.mipmap.ic_lmage1));
        doctorList.add(new DoctorLists(4,"Mark jones", "Consulting", "s simply dummy text of the printing and typesetting industry.", "The best doctor awards 2021", "0423232323", R.mipmap.ic_doctor1));
        doctorList.add(new DoctorLists(5,"Chris Jr", "Pharmacist", "s simply dummy text of the printing and typesetting industry.", "The best doctor awards 2021", "0423232323", R.mipmap.ic_lmage1));
*/

        // Set the database
        doctorDataService = new DataService();
        doctorDataService.init(this);
        doctorList = doctorDataService.getDoctor();

        recyclerView = findViewById(R.id.itemListsRecyclerView);
        dAdapter = new DoctorViewAdapter(this, doctorList, this);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(dAdapter);

        // Return button to homepage
        ImageButton returnToHomeScreen = findViewById(R.id.returnToDoctorScreenButton);
        returnToHomeScreen.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent returnToHomeScreenIntent = new Intent(DoctorScreen.this, HomeScreen.class);
                startActivity(returnToHomeScreenIntent);

            }
        });
    }

    @Override
    public void onDoctorClick(DoctorLists doctor)
    {
        /*this.doctor = doctor;
        showDoctorDetail(doctor);*/
        Intent goToDoctorDetailScreen = new Intent(DoctorScreen.this, DoctorContentScreen.class);
        goToDoctorDetailScreen.putExtra(DoctorLists.DOCTOR_KEY, doctor);
        startActivityForResult(goToDoctorDetailScreen, DOCTOR_CONTENT_ACTIVITY_CODE);


    }


    /*private void showDoctorDetail( DoctorLists doctor)
    {
        Intent goToDoctorDetailScreen = new Intent(this, DoctorContentScreen.class);
        goToDoctorDetailScreen.putExtra(DoctorLists.DOCTOR_KEY, doctor);
        startActivityForResult(goToDoctorDetailScreen, DOCTOR_CONTENT_ACTIVITY_CODE);

    }*/

}