package com.example.tableapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TableRecyclerViewAdapter extends RecyclerView.Adapter<TableRecyclerViewAdapter.ViewHolder> {
    List<String> mydata;
    LayoutInflater myinflate;
    TableRecyclerViewAdapter(List<String> data, Context context){
        this.mydata=data;
        this.myinflate=LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=myinflate.inflate(R.layout.recyclerview_row_table,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String myTable=mydata.get(position);
        holder.mytextviewTable.setText(myTable);

    }

    @Override
    public int getItemCount() {
        return mydata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView mytextviewTable;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mytextviewTable=itemView.findViewById(R.id.tv_table);
        }
    }
}
