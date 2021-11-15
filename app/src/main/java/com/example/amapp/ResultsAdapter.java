package com.example.amapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.MyViewHolder> implements View.OnClickListener, Serializable {
    Context rContext;
    private ResultsAdapter.ItemClickListener rClickListener;
    private ArrayList<Results> resultsArrayList;
    private ArrayList<Results> arraylist;


    // data passed into constructor
    public ResultsAdapter(Context context, ArrayList<Results> resultsArrayList){

        this.rContext = context;
        this.resultsArrayList = resultsArrayList;
        this.arraylist = new ArrayList<>();
        this.arraylist.addAll(resultsArrayList);

    }



    // inflates the row
    @Override
    public ResultsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.results_item, parent, false);
        itemView.setOnClickListener(this);
        return new ResultsAdapter.MyViewHolder(itemView);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(final ResultsAdapter.MyViewHolder myViewHolder, int position) {
        myViewHolder.tvResult.setText(String.valueOf(resultsArrayList.get(position).getArtistName()));
    }

    // Filter Class - source https://abhiandroid.com/ui/searchview
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        resultsArrayList.clear();
        if (charText.length() == 0) {
            resultsArrayList.addAll(arraylist);
        } else {
            for (Results rr : arraylist) {
                if (rr.getArtistName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    resultsArrayList.add(rr);
                }
            }
        }
        notifyDataSetChanged();
    }

    //total number of rows
    @Override
    public int getItemCount() {

        return resultsArrayList.size();

    }



    @Override
    public void onClick(View v) {

    }

    public void setClickListener(ResultsAdapter.ItemClickListener itemClickListener) {
    this.rClickListener = itemClickListener;
    }

    // stores and recycles views as they are scrolled off screen
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvResult;

        MyViewHolder(View itemView){
            super(itemView);
            tvResult = itemView.findViewById(R.id.tvResult);
            rContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(rClickListener != null) rClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // allows clicks events to be caught
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}

