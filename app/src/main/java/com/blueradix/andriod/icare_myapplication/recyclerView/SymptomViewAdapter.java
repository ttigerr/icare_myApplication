package com.blueradix.andriod.icare_myapplication.recyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.blueradix.andriod.icare_myapplication.R;
import com.blueradix.andriod.icare_myapplication.activityScreen.SymptomContentScreen;
import com.blueradix.andriod.icare_myapplication.entities.SymptomItems;

import java.util.List;

public class SymptomViewAdapter extends RecyclerView.Adapter<SymptomViewHolder>
{

    private List<SymptomItems> symptomList;
    private Context context;
    public List<SymptomItems> getSymptom() {
        return symptomList;
    }

    @NonNull
    @Override
    public SymptomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View symptomView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_view, parent, false);
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

        // Import image
        holder.updateSymptomData(symptomItems);

        // Go inside the symptom content
        holder.cardView.setOnClickListener(new View.OnClickListener()
        {
            // Hardcode to store doctor's data
            @Override
            public void onClick(View v)
            {
                Intent goToSymptomDetailIntent = new Intent(context, SymptomContentScreen.class);
                goToSymptomDetailIntent.putExtra("Symptom Name",symptomList.get(position).getSymptomName());
                goToSymptomDetailIntent.putExtra("Symptom Description",symptomList.get(position).getSymptomDescription());
                goToSymptomDetailIntent.putExtra("Symptom Risk",symptomList.get(position).getSymptomRisk());
                goToSymptomDetailIntent.putExtra("Symptom Cause",symptomList.get(position).getSymptomCauses());
                goToSymptomDetailIntent.putExtra("Symptom Solution",symptomList.get(position).getSymptomSolution());

                context.startActivity(goToSymptomDetailIntent);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return symptomList.size();
    }

    public void addItem(SymptomItems symptom) {
        symptomList.add(symptom);
        notifyItemInserted(getItemCount());
    }
}
