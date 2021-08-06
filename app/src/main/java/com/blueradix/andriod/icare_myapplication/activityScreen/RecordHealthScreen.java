package com.blueradix.andriod.icare_myapplication.activityScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.blueradix.andriod.icare_myapplication.R;
import com.blueradix.andriod.icare_myapplication.entities.UserHealthRecord;
import com.blueradix.andriod.icare_myapplication.recyclerView.RecordHealthViewAdapter;
import com.blueradix.andriod.icare_myapplication.recyclerView.SymptomViewAdapter;

import java.util.ArrayList;

public class RecordHealthScreen extends AppCompatActivity
{

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recordAdapter;
    private RecyclerView.LayoutManager recordLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_health_screen);

        ArrayList<UserHealthRecord> healthRecordArrayList = new ArrayList<>();
        healthRecordArrayList.add(new UserHealthRecord(1, "Air Pollution", "27/09/2017", "This PM2.5", "Making acne",R.mipmap.ic_launcher));
        healthRecordArrayList.add(new UserHealthRecord(1, "Air Pollution", "27/09/2017", "This PM2.5", "Making acne",R.mipmap.ic_launcher));
        healthRecordArrayList.add(new UserHealthRecord(1, "Air Pollution", "27/09/2017", "This PM2.5", "Making acne",R.mipmap.ic_launcher));
        healthRecordArrayList.add(new UserHealthRecord(1, "Air Pollution", "27/09/2017", "This PM2.5", "Making acne",R.mipmap.ic_launcher));

        recyclerView = findViewById(R.id.itemListsRecyclerView);
        recyclerView.setHasFixedSize(true);
        recordLayoutManager = new LinearLayoutManager(this);
        recordAdapter = new RecordHealthViewAdapter(healthRecordArrayList);
        recyclerView.setLayoutManager(recordLayoutManager);
        recyclerView.setAdapter(recordAdapter);
    }
}