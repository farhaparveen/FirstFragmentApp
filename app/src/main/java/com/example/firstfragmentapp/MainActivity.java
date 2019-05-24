package com.example.firstfragmentapp;


import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyFragment.MyFragmentListener {
    String s = "";
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.etxt1);

        MyFragment frag = new MyFragment();


        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.my_layout, frag);
        Bundle b = new Bundle();
        b.putString("key", "My Hello World");
        frag.setArguments(b);
        transaction.commit();


    }


    @Override
    public void onUpdateField(String updatedText) {
        editText.setText(updatedText);
    }
}

