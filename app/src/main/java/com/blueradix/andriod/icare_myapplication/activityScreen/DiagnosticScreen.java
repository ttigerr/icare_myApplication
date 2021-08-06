package com.blueradix.andriod.icare_myapplication.activityScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.blueradix.andriod.icare_myapplication.R;
import com.blueradix.andriod.icare_myapplication.entities.SymptomItems;
import com.blueradix.andriod.icare_myapplication.recyclerView.DoctorViewAdapter;
import com.blueradix.andriod.icare_myapplication.recyclerView.SymptomViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class DiagnosticScreen extends AppCompatActivity
{
    private View rootView;
    private SymptomItems category;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter sAdapter;
    private RecyclerView.LayoutManager sLayoutManager;
    List<SymptomItems> symptomItemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostic_screen);
        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rootView = findViewById(android.R.id.content).getRootView();*/

        // make array lists for the category items to display on the screen
        symptomItemsList = new ArrayList<>();
        symptomItemsList.add(new SymptomItems(1, "Eyes", R.mipmap.ic_launcher3));
        symptomItemsList.add(new SymptomItems(2, "Illness", R.mipmap.ic_launcher1));
        symptomItemsList.add(new SymptomItems(3, "Desease", R.mipmap.ic_launcher7));
        symptomItemsList.add(new SymptomItems(4, "Allergy", R.mipmap.ic_launcher9));
        symptomItemsList.add(new SymptomItems(5, "Ache", R.mipmap.ic_launcher3));

        recyclerView = findViewById(R.id.itemListsRecyclerView);
        sAdapter = new SymptomViewAdapter(this,symptomItemsList);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(sAdapter);
    }
}