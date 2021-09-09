package com.example.dice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dice.adapter.HistoryAdapter;
import com.example.dice.models.History;
import com.example.dice.persistence.HistoryDB;

import java.util.ArrayList;
import java.util.List;


public class MainActivity2 extends AppCompatActivity {

    private RecyclerView recyclerview;
    private ArrayList<History> mhistory = new ArrayList<>();
    HistoryAdapter historyadapter;

    private History history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerview = findViewById(R.id.recyclerview);
        initRecyclerView();
        loadHistoryList();
//       insertFakeNotes();
    }

    private void loadHistoryList() {
        HistoryDB historyDB = HistoryDB.getInstance(this.getApplicationContext());
        List<History> historyList= historyDB.getHistoryDao().getAllHistories();
        historyadapter.setHistoryList(historyList);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==100){
            loadHistoryList();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    private void initRecyclerView() {
        Context context;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(linearLayoutManager);
        historyadapter = new HistoryAdapter(mhistory);
        recyclerview.setAdapter(historyadapter);

    }

}