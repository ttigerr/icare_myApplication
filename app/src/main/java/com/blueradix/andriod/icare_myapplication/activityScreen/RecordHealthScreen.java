package com.blueradix.andriod.icare_myapplication.activityScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.blueradix.andriod.icare_myapplication.R;
import com.blueradix.andriod.icare_myapplication.entities.UserHealthRecord;
import com.blueradix.andriod.icare_myapplication.recyclerView.RecordHealthViewAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class RecordHealthScreen extends AppCompatActivity
{

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recordAdapter;
    private RecyclerView.LayoutManager recordLayoutManager;
    List<UserHealthRecord> userRecordList;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_health_screen);

        userRecordList = new ArrayList<>();
        userRecordList.add(new UserHealthRecord(1, "Air Pollution", "27/09/2017", "This PM2.5", "Making acne",R.mipmap.ic_launcher3));
        userRecordList.add(new UserHealthRecord(1, "Stomachache", "27/09/2017", "This PM2.5", "Making acne",R.mipmap.ic_launcher1));
        userRecordList.add(new UserHealthRecord(1, "Sinus", "27/09/2017", "This PM2.5", "Making acne",R.mipmap.ic_launcher7));
        userRecordList.add(new UserHealthRecord(1, "Heart Attack", "27/09/2017", "This PM2.5", "Making acne",R.mipmap.ic_launcher9));

        recyclerView = findViewById(R.id.itemListsRecyclerView);
        recyclerView.setHasFixedSize(true);
        recordLayoutManager = new LinearLayoutManager(this);
        recordAdapter = new RecordHealthViewAdapter(this,userRecordList);
        recyclerView.setLayoutManager(recordLayoutManager);
        recyclerView.setAdapter(recordAdapter);

        // Return button to homepage
        ImageButton returnToHomeScreen = findViewById(R.id.returnToRecordScreenButton);
        returnToHomeScreen.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent returnToHomeScreenIntent = new Intent(RecordHealthScreen.this, HomeScreen.class);
                startActivity(returnToHomeScreenIntent);
            }
        });

        // Set the fab action
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent goToAddRecordScreenIntent = new Intent(RecordHealthScreen.this, AddRecordScreen.class);
                startActivity(goToAddRecordScreenIntent);
            }
        });
    }
}