package com.blueradix.andriod.icare_myapplication.recyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blueradix.andriod.icare_myapplication.R;
import com.blueradix.andriod.icare_myapplication.entities.UserHealthRecord;

import java.util.ArrayList;


public class RecordHealthViewAdapter extends RecyclerView.Adapter<RecordHealthViewHolder>
{

    private ArrayList<UserHealthRecord> recordList;
    @NonNull
    @Override
    public RecordHealthViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType)
    {
        View recordView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_view, parent, false);
        RecordHealthViewHolder recordViewHolder = new RecordHealthViewHolder(recordView);
        return recordViewHolder;
    }

    public RecordHealthViewAdapter(ArrayList<UserHealthRecord> recordList)
    {
        this.recordList = recordList;
    }
    @Override
    public void onBindViewHolder(@NonNull RecordHealthViewHolder holder, int position)
    {
        UserHealthRecord userRecordList = recordList.get(position);
        holder.recordTitle.setText(userRecordList.getRecordTitle());
        holder.recordDate.setText(userRecordList.getRecordDate());
        holder.recordHealthImage.setImageResource(userRecordList.getRecordImageResource());

    }

    @Override
    public int getItemCount() {
        return recordList.size();
    }
}
