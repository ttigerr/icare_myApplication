package com.blueradix.andriod.icare_myapplication.recyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blueradix.andriod.icare_myapplication.R;
import com.blueradix.andriod.icare_myapplication.entities.UserHealthRecord;
import com.google.android.material.card.MaterialCardView;


public class RecordHealthViewHolder extends RecyclerView.ViewHolder
{
    public final ImageView recordHealthImage;
    public final TextView recordTitle;
    public final TextView recordDate;
    public final MaterialCardView cardView;

    public RecordHealthViewHolder(@NonNull View itemView)
    {
        super(itemView);
        recordHealthImage = itemView.findViewById(R.id.itemImageView);
        recordTitle = itemView.findViewById(R.id.itemNameTextView);
        recordDate = itemView.findViewById(R.id.additionalTextView);
        cardView = itemView.findViewById(R.id.materialCardview);

    }

    public void updateRecordData(UserHealthRecord userRecord)
    {
        View rootView = recordHealthImage.getRootView();
        int resID = rootView.getResources().getIdentifier(userRecord.recordImageResource , "mipmap" , rootView.getContext().getPackageName()) ;
        recordHealthImage.setImageResource(resID);
        this.recordTitle.setText(userRecord.getRecordTitle());
        this.recordDate.setText(userRecord.getRecordDate());
    }

}
