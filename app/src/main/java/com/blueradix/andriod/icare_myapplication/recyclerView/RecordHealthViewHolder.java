package com.blueradix.andriod.icare_myapplication.recyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blueradix.andriod.icare_myapplication.R;


public class RecordHealthViewHolder extends RecyclerView.ViewHolder
{
    public final ImageView recordHealthImage;
    public final TextView recordTitle;
    public final TextView recordDate;

    public RecordHealthViewHolder(@NonNull View itemView)
    {
        super(itemView);
        recordHealthImage = itemView.findViewById(R.id.itemImageView);
        recordTitle = itemView.findViewById(R.id.itemNameTextView);
        recordDate = itemView.findViewById(R.id.additionalTextView);
    }

}
