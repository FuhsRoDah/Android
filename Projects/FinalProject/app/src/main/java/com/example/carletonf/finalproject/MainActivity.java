package com.example.carletonf.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.ImageView;
import android.widget.Toast;
/*
 * Carleton Fuhs & Greg Mottola
 * 05/02/18
 * Final Project
 * Build your own adventure book - 1 complete story, multiple ends/paths
 * Voice over that reads the text
 * Images for the beginning and end
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner storySpin = (Spinner) findViewById(R.id.storySpin);
        final ImageView imageView = (ImageView) findViewById(R.id.imageView);
        storySpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(storySpin.getSelectedItem().equals("Cult Rising")){
                    imageView.setImageResource(R.drawable.orcus);
                }
                if(storySpin.getSelectedItem().equals("Treasure Hunt")){
                    imageView.setImageResource(R.drawable.treasure);
                }
                if(storySpin.getSelectedItem().equals("Dragon Slayer")){
                    imageView.setImageResource(R.drawable.dragoon);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void onStartClick(View view){
        Spinner storySpin = (Spinner) findViewById(R.id.storySpin);
        String selected = String.valueOf(storySpin.getSelectedItem());
        if(selected.equals("Cult Rising")) {
            Intent show = new Intent(this, story.class);
            show.putExtra(story.story_selected, selected);
            startActivity(show);
        }
        else{
            Toast myToast = Toast.makeText(getApplicationContext(),"This story is still in development.", Toast.LENGTH_LONG);
            myToast.show();;
        }
    }

}
