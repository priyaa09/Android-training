package com.example.HW_layout;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;
    private Button btn;
    private Button count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hm_layout);
        mShowCount = (TextView) findViewById(R.id.show_count);
        btn =findViewById(R.id.zero);
        count =findViewById(R.id.count);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount=0;
                if (mShowCount != null) {
                    btn.setBackgroundColor(getResources().getColor(R.color.grey));
                    mShowCount.setText(Integer.toString(mCount));
                }
            }
            });
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, "hello i m toast",
                Toast.LENGTH_LONG);
        Log.d(TAG, "showToast: toast");
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
            Log.d(TAG, "showToast: intoast");
            btn.setBackgroundColor(getResources().getColor(R.color.black));
        }
        if(mCount%2==0){
            count.setBackgroundColor(getResources().getColor(R.color.purple_200));
        }
        else{
            count.setBackgroundColor(getResources().getColor(R.color.teal_200));
        }
        Log.d(TAG, "showToast: outtoast");
    }

    }
