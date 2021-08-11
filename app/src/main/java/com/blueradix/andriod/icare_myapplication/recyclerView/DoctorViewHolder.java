package com.blueradix.andriod.icare_myapplication.recyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blueradix.andriod.icare_myapplication.R;
import com.blueradix.andriod.icare_myapplication.entities.DoctorLists;
import com.blueradix.andriod.icare_myapplication.entities.SymptomItems;
import com.google.android.material.card.MaterialCardView;

public class DoctorViewHolder extends RecyclerView.ViewHolder
{
    public final ImageView doctorImageView;
    public final TextView doctorTextview;
    public final TextView doctorType;
    public final MaterialCardView cardView;

    public DoctorViewHolder(@NonNull View itemView)
    {
        super(itemView);
        doctorImageView = itemView.findViewById(R.id.cardItemImageView);
        doctorTextview = itemView.findViewById(R.id.cardItemTextView);
        doctorType = itemView.findViewById(R.id.optionalTextView);
        cardView = itemView.findViewById(R.id.applicationCardView);
    }

    public void updateDoctorData(DoctorLists doctor)
    {
        View rootView = doctorImageView.getRootView();
        int resID = rootView.getResources().getIdentifier(doctor.doctorImageResource , "mipmap" , rootView.getContext().getPackageName()) ;
        doctorImageView.setImageResource(resID);
        this.doctorTextview.setText(doctor.getDoctorName());
        this.doctorType.setText(doctor.getDoctorType());
    }
}
