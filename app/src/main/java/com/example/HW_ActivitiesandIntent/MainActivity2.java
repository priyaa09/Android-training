package com.example.HW_ActivitiesandIntent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = getIntent();
        String text = intent.getStringExtra(MainActivity.EXTRA_TEXT);


        TextView textView = findViewById(R.id.count);
        textView.setText(text);

    }
}