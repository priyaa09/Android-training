package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TEXT="com.example.intent.EXTRA_TEXT";

    Button button;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn);
        editText =findViewById(R.id.editText2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        openActivity2();
            }
        });

        editText.addTextChangedListener(textWatcher);
    }

    public boolean openActivity2() {
        String text = editText.getText().toString();
        if(text.isEmpty()){
            editText.setError("Name can't be empty");
            return false;
        }
        else {
            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra(EXTRA_TEXT, text);
            startActivity(intent);
            return true;
        }
    }



    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String name = editText.getText().toString().trim();
            button.setEnabled(!name.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}