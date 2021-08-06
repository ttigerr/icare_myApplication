package com.blueradix.andriod.icare_myapplication.recyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blueradix.andriod.icare_myapplication.R;


public class SymptomViewHolder extends RecyclerView.ViewHolder
{
    public final ImageView symptomImageView;
    public final TextView symptomNameTextView;

    public SymptomViewHolder(@NonNull View itemView)
    {
        super(itemView);
        symptomImageView = itemView.findViewById(R.id.cardItemImageView);
        symptomNameTextView = itemView.findViewById(R.id.cardItemTextView);


    }
}
