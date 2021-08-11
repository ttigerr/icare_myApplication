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
    public List<DoctorLists> getDoctor(){ return doctorLists; }
    private OnDoctorListener onDoctorListener;

    @NonNull
    @Override
    public DoctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View doctorView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_cardview_item_view, parent, false);
        DoctorViewHolder doctorViewHolder = new DoctorViewHolder(doctorView, onDoctorListener);
        return doctorViewHolder;
    }

    public DoctorViewAdapter (Context context , List<DoctorLists> doctorLists, OnDoctorListener onDoctorListener)
    {
        this.context = context;
        this.doctorLists = doctorLists;
        this.onDoctorListener = onDoctorListener;
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorViewHolder holder, int position)
    {
        //DoctorLists doctor = doctorLists.get(position);
        DoctorLists doctorItem = doctorLists.get(position);
        holder.updateDoctorData(doctorItem);
        holder.bind(doctorItem, onDoctorListener);

        // Set the action on the cardviews when users clicked on it
        /*holder.cardView.setOnClickListener(new View.OnClickListener()
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
        });*/
    }

    @Override
    public int getItemCount()
    {
        return doctorLists.size();
    }

    public void addDoctorItem( int position, DoctorLists doctor)
    {
        doctorLists.set(position, doctor);
        notifyItemChanged(position);
    }
}
