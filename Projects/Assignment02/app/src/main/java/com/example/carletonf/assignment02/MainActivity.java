package com.example.carletonf.assignment02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.content.Intent;
import android.app.Activity;

/***
 * Carleton Fuhs
 * Assignment 2
 * Create Mad Libs game
 * 02/18/18
 ***/


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView mlpic = (ImageView)findViewById(R.id.mlpic);
        mlpic.setImageResource(R.drawable.madlibs);
    }

    public void onClickStart(View view){
        Intent intent = new Intent(this, FillWords.class);
        startActivity(intent);
    }
}
