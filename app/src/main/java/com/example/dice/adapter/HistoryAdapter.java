package com.example.dice.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dice.R;
import com.example.dice.models.History;

import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends  RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private ArrayList<History> histories = new ArrayList<>();

    public HistoryAdapter(ArrayList<History> histories) {
        this.histories = histories;
    }

    public void setHistoryList(List<History> historyList) {
        this.histories = (ArrayList<History>) historyList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.number.setText(histories.get(position).getNumber());
        holder.timestamp.setText(histories.get(position).getTimestamp());
    }

    @Override
    public int getItemCount() {
        return histories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView number, timestamp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.randomNo);
            timestamp = itemView.findViewById(R.id.date);

        }
    }
}
