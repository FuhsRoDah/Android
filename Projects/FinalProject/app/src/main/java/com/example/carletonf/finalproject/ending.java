package com.example.carletonf.finalproject;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ending extends AppCompatActivity {
    public static final String endofstory = "message";
    private MediaPlayer mp;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending);
        Intent selected = getIntent();
        String selectedStory = selected.getStringExtra(endofstory);
        endText(selectedStory);
    }

    public void endText(String selectedStory){
        TextView textView = (TextView) findViewById(R.id.endText);
        if(selectedStory.equals("131")){
            stopPlaying();
            mp = MediaPlayer.create(ending.this, R.raw.p131);
            mp.start();
            textView.setText(R.string.e131);
            prisonEnd();
        }
        if(selectedStory.equals("132")){
            stopPlaying();
            mp = MediaPlayer.create(ending.this, R.raw.p132);
            mp.start();
            textView.setText(R.string.e132);
            prisonEnd();
        }
        if(selectedStory.equals("1331")){
            stopPlaying();
            mp = MediaPlayer.create(ending.this, R.raw.p1331);
            mp.start();
            textView.setText(R.string.e1331);
            deadEnd();
        }
        if(selectedStory.equals("1333")){
            stopPlaying();
            mp = MediaPlayer.create(ending.this, R.raw.p1333);
            mp.start();
            textView.setText(R.string.e1333);
            deadEnd();
        }
        if(selectedStory.equals("13321")){
            stopPlaying();
            mp = MediaPlayer.create(ending.this, R.raw.p13321);
            mp.start();
            textView.setText(R.string.e13321);
            goodEnd();
        }
        if(selectedStory.equals("13322")){
            stopPlaying();
            mp = MediaPlayer.create(ending.this, R.raw.p13322);
            mp.start();
            textView.setText(R.string.e13322);
            deadEnd();
        }
        if(selectedStory.equals("13323")){
            stopPlaying();
            mp = MediaPlayer.create(ending.this, R.raw.p13323);
            mp.start();
            textView.setText(R.string.e13323);
            deadEnd();
        }
        if(selectedStory.equals("21131")){
            stopPlaying();
            mp = MediaPlayer.create(ending.this, R.raw.p21131);
            mp.start();
            textView.setText(R.string.e21131);
            prisonEnd();
        }
        if(selectedStory.equals("21133")){
            stopPlaying();
            mp = MediaPlayer.create(ending.this, R.raw.p21133);
            mp.start();
            textView.setText(R.string.e21133);
            deadEnd();
        }
        if(selectedStory.equals("2221")){
            stopPlaying();
            mp = MediaPlayer.create(ending.this, R.raw.p2221);
            mp.start();
            textView.setText(R.string.e2221);
            goodEnd();
        }
        if(selectedStory.equals("2222")){
            stopPlaying();
            mp = MediaPlayer.create(ending.this, R.raw.p2222);
            mp.start();
            textView.setText(R.string.e2222);
            deadEnd();
        }
        if(selectedStory.equals("31211")){
            stopPlaying();
            mp = MediaPlayer.create(ending.this, R.raw.p31211);
            mp.start();
            textView.setText(R.string.e31211);
            deadEnd();
        }
        if(selectedStory.equals("3211")){
            stopPlaying();
            mp = MediaPlayer.create(ending.this, R.raw.p3211);
            mp.start();
            textView.setText(R.string.e3211);
            deadEnd();
        }
        if(selectedStory.equals("3213")){
            stopPlaying();
            mp = MediaPlayer.create(ending.this, R.raw.p3213);
            mp.start();
            textView.setText(R.string.e3213);
            goodEnd();
        }
        if(selectedStory.equals(("323"))){
            stopPlaying();
            mp = MediaPlayer.create(ending.this, R.raw.p323);
            mp.start();
            textView.setText(R.string.e323);
            prisonEnd();
        }
        if(selectedStory.equals("31213")){
            stopPlaying();
            mp = MediaPlayer.create(ending.this, R.raw.p3213);
            mp.start();
            textView.setText(R.string.e31213);
            goodEnd();
        }
    }

    public void deadEnd(){
        imageView = (ImageView) findViewById(R.id.imageView2);
        imageView.setImageResource(R.drawable.die);
    }
    public void goodEnd(){
        imageView = (ImageView) findViewById(R.id.imageView2);
        imageView.setImageResource(R.drawable.money);
    }
    public void prisonEnd(){
        imageView = (ImageView) findViewById(R.id.imageView2);
        imageView.setImageResource(R.drawable.manacles);
    }
    public void onClickMainMenu(View view){
        stopPlaying();
        Intent beginning = new Intent(this, MainActivity.class);
        startActivity(beginning);
    }

    private void stopPlaying(){

        if(mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }

}
