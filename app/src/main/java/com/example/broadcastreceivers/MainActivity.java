package com.example.broadcastreceivers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "BroadcastTest";
    private static final String TAG1 = "checking";
    private Intent intent;
    public TextView txtCounter;

    String  save;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCounter = (TextView) findViewById(R.id.count);

    }
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            updateUI(intent);
        }
    };
    public void start(View view) {
        Intent intent = new Intent(this, Receiver.class);
        intent.putExtra("counterr", txtCounter.getText());
        startService(intent);
        registerReceiver(broadcastReceiver, new IntentFilter(Receiver.BROADCAST_ACTION));

    }

    public void stop(View view) throws InterruptedException {
        super.onStop();
        intent= new Intent(this, Receiver.class);
        unregisterReceiver(broadcastReceiver);
        stopService(intent);
    }


    @Override
    public void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
        stopService(intent);
    }
    private void updateUI(Intent intent) {
        String counter = intent.getStringExtra("counter");
        Log.d(TAG, counter);

        txtCounter.setText(counter);
    }


}
