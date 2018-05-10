package com.example.carletonf.lab03;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.Intent;
import android.app.Activity;


/***
 * Carleton Fuhs
 * Lab 04
 * Add sounds, images, and an application icon to the app we made for lab03
 * 02/08/18
 ***/

public class MainActivity extends Activity {
    private MediaPlayer mp;

    protected void onResume(Bundle savedInstanceState){
        mp = MediaPlayer.create(getApplicationContext(),R.raw.nfl_theme);
        mp.start();
    }
    protected void onPause(Bundle savedInstanceState){
        mp.stop();
        mp.release();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onResume(savedInstanceState);
    }

    public void onClickEnter(View view){

       Spinner team = (Spinner) findViewById(R.id.team);
       String selected = String.valueOf(team.getSelectedItem());

       Intent show = new Intent(this, DisplayInfo.class);
       show.putExtra(DisplayInfo.Team_Info,selected);
       startActivity(show);
    }

}
