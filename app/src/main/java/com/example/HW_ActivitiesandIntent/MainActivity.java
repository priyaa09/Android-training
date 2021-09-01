package com.example.HW_ActivitiesandIntent;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;

    public static final String EXTRA_TEXT="com.example.HW_ActivitiesandIntent.EXTRA_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout);
        mShowCount = (TextView) findViewById(R.id.show_count);

    }

    public void showToast(View view) {
        String text = mShowCount.getText().toString();
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);

    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));

        }
    }

    }
