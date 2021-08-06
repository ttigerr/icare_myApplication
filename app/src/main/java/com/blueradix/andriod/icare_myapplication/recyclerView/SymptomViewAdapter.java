package com.blueradix.andriod.icare_myapplication.recyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.blueradix.andriod.icare_myapplication.R;
import com.blueradix.andriod.icare_myapplication.entities.SymptomItems;
import java.util.ArrayList;
import java.util.List;

public class SymptomViewAdapter extends RecyclerView.Adapter<SymptomViewHolder>
{

    // Don't forget to change the variable name instead of category change to symptom
    private List<SymptomItems> symptomList;
    private Context context;
    @NonNull
    @Override
    public SymptomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View symptomView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_cardview_item_view, parent, false);
        SymptomViewHolder symptomViewHolder = new SymptomViewHolder(symptomView);
        return symptomViewHolder;
    }

    // Passing the items into the array
    public SymptomViewAdapter(Context context, List<SymptomItems> symptomList)
    {
        this.symptomList = symptomList;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull SymptomViewHolder holder, int position)
    {
        SymptomItems symptomItems = symptomList.get(position);
        holder.symptomImageView.setImageResource(symptomItems.getImageResource());
        holder.symptomNameTextView.setText(symptomItems.getSymptomName());
    }

    @Override
    public int getItemCount()
    {
        return symptomList.size();
    }
}
