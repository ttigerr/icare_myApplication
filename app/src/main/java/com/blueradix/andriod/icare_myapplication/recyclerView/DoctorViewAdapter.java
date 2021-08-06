package com.blueradix.andriod.icare_myapplication.recyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blueradix.andriod.icare_myapplication.R;
import com.blueradix.andriod.icare_myapplication.activityScreen.DoctorContentScreen;
import com.blueradix.andriod.icare_myapplication.entities.DoctorLists;

import java.util.List;


public class DoctorViewAdapter extends RecyclerView.Adapter<DoctorViewHolder>
{
    private Context context;
    private List<DoctorLists> doctorLists;

    @NonNull
    @Override
    public DoctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View doctorView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_cardview_item_view, parent, false);
        DoctorViewHolder doctorViewHolder = new DoctorViewHolder(doctorView);
        return doctorViewHolder;
    }

    public DoctorViewAdapter (Context context , List<DoctorLists> doctorLists)
    {
        this.context = context;
        this.doctorLists = doctorLists;
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorViewHolder holder, int position)
    {
        DoctorLists doctor = doctorLists.get(position);
        holder.doctorImageView.setImageResource(doctor.getDoctorImageResource());
        holder.doctorTextview.setText(doctor.getDoctorName());
        holder.doctorType.setText(doctor.getDoctorType());

        // Set the action on the cardviews when users clicked on it
        holder.cardView.setOnClickListener(new View.OnClickListener()
        {
            // Hardcode to store doctor's data
            @Override
            public void onClick(View v)
            {
                Intent goToDoctorDetailIntent = new Intent(context, DoctorContentScreen.class);
                goToDoctorDetailIntent.putExtra("Doctor Name",doctorLists.get(position).getDoctorName());
                goToDoctorDetailIntent.putExtra("Doctor Type",doctorLists.get(position).getDoctorType());
                goToDoctorDetailIntent.putExtra("Description",doctorLists.get(position).getDescription());
                goToDoctorDetailIntent.putExtra("Achievements",doctorLists.get(position).getAchievement());
                goToDoctorDetailIntent.putExtra("Contact Detail",doctorLists.get(position).getContactNumber());
                goToDoctorDetailIntent.putExtra("Image",doctorLists.get(position).getDoctorImageResource());
                context.startActivity(goToDoctorDetailIntent);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return doctorLists.size();
    }
}
