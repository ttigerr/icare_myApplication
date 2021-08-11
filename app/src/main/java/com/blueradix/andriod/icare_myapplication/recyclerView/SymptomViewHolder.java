package com.blueradix.andriod.icare_myapplication.recyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blueradix.andriod.icare_myapplication.R;
import com.blueradix.andriod.icare_myapplication.entities.SymptomItems;
import com.google.android.material.card.MaterialCardView;


public class SymptomViewHolder extends RecyclerView.ViewHolder
{
    public final ImageView symptomImageView;
    public final TextView symptomNameTextView;
    public final MaterialCardView cardView;

    public SymptomViewHolder(@NonNull View itemView)
    {
        super(itemView);
        symptomImageView = itemView.findViewById(R.id.itemImageView);
        symptomNameTextView = itemView.findViewById(R.id.itemNameTextView);
        cardView = itemView.findViewById(R.id.materialCardview);

    }

    public void updateSymptomData(SymptomItems symptom)
    {
        View rootView = symptomImageView.getRootView();
        int resID = rootView.getResources().getIdentifier(symptom.symptomImageResource , "mipmap" , rootView.getContext().getPackageName()) ;
        symptomImageView.setImageResource(resID);
        this.symptomNameTextView.setText(symptom.getSymptomName());
    }


}
