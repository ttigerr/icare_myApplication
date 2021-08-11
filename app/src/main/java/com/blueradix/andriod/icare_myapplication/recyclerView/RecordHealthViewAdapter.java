package com.blueradix.andriod.icare_myapplication.recyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blueradix.andriod.icare_myapplication.R;
import com.blueradix.andriod.icare_myapplication.activityScreen.RecordContentScreen;
import com.blueradix.andriod.icare_myapplication.entities.UserHealthRecord;

import java.util.List;


public class RecordHealthViewAdapter extends RecyclerView.Adapter<RecordHealthViewHolder>
{

    private List<UserHealthRecord> recordList;
    private Context context;

    @NonNull
    @Override
    public RecordHealthViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType)
    {
        View recordView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_view, parent, false);
        RecordHealthViewHolder recordViewHolder = new RecordHealthViewHolder(recordView);
        return recordViewHolder;
    }

    public RecordHealthViewAdapter(Context context, List<UserHealthRecord> recordList)
    {
        this.recordList = recordList;
        this.context = context;
    }
    @Override
    public void onBindViewHolder(@NonNull RecordHealthViewHolder holder, int position)
    {
        UserHealthRecord userRecordList = recordList.get(position);
        holder.recordTitle.setText(userRecordList.getRecordTitle());
        holder.recordDate.setText(userRecordList.getRecordDate());
        holder.recordHealthImage.setImageResource(userRecordList.getRecordImageResource());

        // Go inside the symptom content
        holder.cardView.setOnClickListener(new View.OnClickListener()
        {
            // Hardcode to store doctor's data
            @Override
            public void onClick(View v)
            {
                Intent goToRecordHealthContentIntent = new Intent(context, RecordContentScreen.class);
                goToRecordHealthContentIntent.putExtra("Record Name",recordList.get(position).getRecordTitle());
                goToRecordHealthContentIntent.putExtra("Record Description",recordList.get(position).getRecordDescription());
                goToRecordHealthContentIntent.putExtra("Record SideEffect",recordList.get(position).getRecordSideEffect());
                goToRecordHealthContentIntent.putExtra("Record Date",recordList.get(position).getRecordDate());

                context.startActivity(goToRecordHealthContentIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return recordList.size();
    }
}
