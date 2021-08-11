package com.blueradix.andriod.icare_myapplication.activityScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.blueradix.andriod.icare_myapplication.R;
import com.blueradix.andriod.icare_myapplication.entities.SymptomItems;
import com.blueradix.andriod.icare_myapplication.recyclerView.SymptomViewAdapter;
import com.blueradix.andriod.icare_myapplication.service.DataService;

import java.util.List;

public class SymptomScreen extends AppCompatActivity
{
    private DataService symptomDataService;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter sAdapter;
    private RecyclerView.LayoutManager sLayoutManager;
    List<SymptomItems> symptomItems;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostic_screen);
        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rootView = findViewById(android.R.id.content).getRootView();*/

        // display the data from database
        symptomDataService = new DataService();
        symptomDataService.init(this);
        symptomItems = symptomDataService.getSymptom();

        // Set the action to display the data on screen from database
        recyclerView = findViewById(R.id.itemListsRecyclerView);
        recyclerView.setHasFixedSize(true);
        sLayoutManager = new LinearLayoutManager(this);
        sAdapter = new SymptomViewAdapter(this, symptomItems);
        recyclerView.setLayoutManager(sLayoutManager);
        recyclerView.setAdapter(sAdapter);


        // Return button to homepage
        ImageButton returnToHomeScreen = findViewById(R.id.returnToSymptomScreenButton);
        returnToHomeScreen.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent returnToHomeScreenIntent = new Intent(SymptomScreen.this, HomeScreen.class);
                startActivity(returnToHomeScreenIntent);
            }
        });
    }


}