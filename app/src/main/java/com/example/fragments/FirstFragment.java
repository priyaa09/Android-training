package com.example.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FirstFragment extends Fragment {

    EditText editText;
    Button button;


    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        editText = view.findViewById(R.id.ET);
        button = view.findViewById(R.id.send);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                bundle.putString("key",editText.getText().toString());

                SecondFragment secondFragment = new SecondFragment();
                secondFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container,secondFragment).commit();
            }
        });
return view;
    }
}