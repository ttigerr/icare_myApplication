package com.blueradix.andriod.icare_myapplication.activityScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.blueradix.andriod.icare_myapplication.R;
import com.blueradix.andriod.icare_myapplication.entities.DoctorLists;
import com.blueradix.andriod.icare_myapplication.recyclerView.DoctorViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class DoctorScreen extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private RecyclerView.Adapter dAdapter;
    private RecyclerView.LayoutManager dLayoutManager;

    List<DoctorLists> doctorList;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_screen);

        // Store the data and display it in arrays
        doctorList = new ArrayList<>();
        doctorList.add(new DoctorLists(1,"David jones", "Consulting", "s simply dummy text of the printing and typesetting industry.", "The best doctor awards 2021", "0423232323", R.mipmap.ic_lmage1));
        doctorList.add(new DoctorLists(1,"David jones", "Consulting", "s simply dummy text of the printing and typesetting industry.", "The best doctor awards 2021", "0423232323", R.mipmap.ic_lmage1));
        doctorList.add(new DoctorLists(1,"David jones", "Consulting", "s simply dummy text of the printing and typesetting industry.", "The best doctor awards 2021", "0423232323", R.mipmap.ic_lmage1));
        doctorList.add(new DoctorLists(1,"David jones", "Consulting", "s simply dummy text of the printing and typesetting industry.", "The best doctor awards 2021", "0423232323", R.mipmap.ic_lmage1));
        doctorList.add(new DoctorLists(1,"David jones", "Consulting", "s simply dummy text of the printing and typesetting industry.", "The best doctor awards 2021", "0423232323", R.mipmap.ic_lmage1));

        recyclerView = findViewById(R.id.itemListsRecyclerView);
        dAdapter = new DoctorViewAdapter(this,doctorList);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(dAdapter);
    }

}