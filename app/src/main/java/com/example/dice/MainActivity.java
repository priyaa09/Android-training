package com.example.dice;

import static java.lang.Integer.parseInt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dice.adapter.HistoryAdapter;
import com.example.dice.models.History;
import com.example.dice.persistence.HistoryDB;
import com.example.dice.util.DialogBox;
import com.example.dice.util.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button;
//    ImageView img;
    ImageView dice;


    String lastscore;
    String lastTime;
    HistoryAdapter historyadapter;

    Random myRandom = new Random();
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    private History history;
    private ArrayList<History> mhistory = new ArrayList<>();

    TextView number;
    TextView time;
    private String text;
    TextView lasts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
//        img = findViewById(R.id.history);
        dice = findViewById(R.id.dice);
        number = findViewById(R.id.lastno);
        time = findViewById(R.id.time);
        lasts = findViewById(R.id.textView);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rolldice();
            }
        });

//        img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//              startActivityForResult(new Intent(MainActivity.this,MainActivity2.class), 100);
//            }
//        });

        loadData();
        updateViews();

        if (savedInstanceState != null) {
            boolean isVisible = savedInstanceState
                    .getBoolean("reply_visible");
            if (isVisible) {
                lasts.setVisibility(View.VISIBLE);
                number.setText(savedInstanceState
                        .getString("num"));
                time.setText(savedInstanceState
                        .getString("date"));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ActionMode mode;
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.history){
            startActivityForResult(new Intent(MainActivity.this,MainActivity2.class), 100);

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (lasts.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("num", number.getText().toString());

            outState.putString("date", time.getText().toString());
        }
    }


    private void rolldice() {
        int randomNumber = myRandom.nextInt(6) + 1;

        switch (randomNumber) {
            case 1:
                lasts.setVisibility(View.VISIBLE);
                dice.setImageResource(R.drawable.dice_1);
                //number.setText(randomNumber);
                lastscore = String.valueOf(randomNumber);
                lastTime = String.valueOf(Utility.getCurrentTimeStamp());
//                time.setText(Utility.getCurrentTimeStamp());
                saveData();
                saveNewHistory(history);
                loadHistory();
                break;
            case 2:
                lasts.setVisibility(View.VISIBLE);
                dice.setImageResource(R.drawable.dice_2);
                lastscore = String.valueOf(randomNumber);
                lastTime = String.valueOf(Utility.getCurrentTimeStamp());
//                number.setText(randomNumber);
//                time.setText(Utility.getCurrentTimeStamp());
                saveData();
                saveNewHistory(history);
                loadHistory();
                break;
            case 3:
                lasts.setVisibility(View.VISIBLE);
                dice.setImageResource(R.drawable.dice_3);
//                number.setText(randomNumber);
                lastTime = String.valueOf(Utility.getCurrentTimeStamp());
                lastscore = String.valueOf(randomNumber);
//                time.setText(Utility.getCurrentTimeStamp());
                saveData();
                saveNewHistory(history);
                loadHistory();
                break;
            case 4:
                lasts.setVisibility(View.VISIBLE);
                dice.setImageResource(R.drawable.dice_4);
//                number.setText(randomNumber);
                lastscore = String.valueOf(randomNumber);
                lastTime = String.valueOf(Utility.getCurrentTimeStamp());
//                time.setText(Utility.getCurrentTimeStamp());
                saveData();
                saveNewHistory(history);
                loadHistory();
                break;
            case 5:
                lasts.setVisibility(View.VISIBLE);
                dice.setImageResource(R.drawable.dice_5);
//                number.setText(randomNumber);
                lastTime = String.valueOf(Utility.getCurrentTimeStamp());
                lastscore = String.valueOf(randomNumber);
//                time.setText(Utility.getCurrentTimeStamp());
                saveData();
                saveNewHistory(history);
                loadHistory();
                break;
            case 6:
                lasts.setVisibility(View.VISIBLE);
                openDialog();
                dice.setImageResource(R.drawable.dice_6);
//                number.setText(randomNumber);
                lastscore = String.valueOf(randomNumber);
                lastTime = String.valueOf(Utility.getCurrentTimeStamp());
//                time.setText(Utility.getCurrentTimeStamp());
                saveData();
                saveNewHistory(history);
                loadHistory();
                break;
        }
    }
    public void openDialog() {
        DialogBox exampleDialog = new DialogBox();
        exampleDialog.show(getSupportFragmentManager(), "dialog");
    }
    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT, number.getText().toString());
        editor.apply();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT, "");
    }

    public void updateViews() {
        number.setText(text);
    }

    private void saveNewHistory(History ht) {

        HistoryDB historyDB = HistoryDB.getInstance(this.getApplicationContext());
        History history = new History();
        history.setNumber(lastscore);
//        history.setNumber(number.getText().toString());
//        history.setTimestamp(time.getText().toString());
        history.setTimestamp(lastTime);
        historyDB.getHistoryDao().insertHistory(history);
    }
    private void loadHistory() {
        HistoryDB historyDB = HistoryDB.getInstance(this.getApplicationContext());
        History historyL= historyDB.getHistoryDao().getHistory();
        number.setText(historyL.getNumber());
        time.setText(historyL.getTimestamp());
    }


}