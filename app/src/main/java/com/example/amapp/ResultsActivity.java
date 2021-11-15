package com.example.amapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultsActivity extends AppCompatActivity {

    ArrayList<Results> result;
    TextView tvArtistName, tvArtistId;
    String aName;
    int aId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tvArtistName = findViewById(R.id.tvArtistName);
        tvArtistId = findViewById(R.id.tvArtistId);
        //Intent intent = getIntent();
        aName = getIntent().getStringExtra("artistName");
        System.out.println(aName);
        //aId = getIntent().getIntExtra("artistId", 0);
        //System.out.println(aId);
        //Bundle args = intent.getBundleExtra("BUNDLE");
        //ArrayList<Results> itemClickedList = (ArrayList<Results>) args.getSerializable("itemClickedList");
        //result.clear();
        //result.addAll(itemClickedList);
        tvArtistName.setText(aName);
        //tvArtistId.setText(aId);
    }
}
