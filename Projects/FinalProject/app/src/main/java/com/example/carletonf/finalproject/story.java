package com.example.carletonf.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class story extends Activity {
    public static final String story_selected = "message";
    public String progress;
    private MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        Intent selected = getIntent();
        String selectedStory = selected.getStringExtra(story_selected);

        stopPlaying();
        mp = MediaPlayer.create(story.this, R.raw.startscreen);
        mp.start();
        progress = "";
        TextView storyText = (TextView)findViewById(R.id.storyText);
        Button b1 = (Button)findViewById(R.id.option1);
        Button b2 = (Button)findViewById(R.id.option2);
        Button b3 = (Button)findViewById(R.id.option3);
        storyText.setText(R.string.p);
        b1.setText(R.string.o1);
        b2.setText(R.string.o2);
        b3.setText(R.string.o3);
    }

    public void onClickOpt1(View view){
        progress = progress + "1";
        if(progress.equals("11")||progress.equals("121")||progress.equals("221")){
            progress = "3";
        }
        if(progress.equals("2121")){
            progress = "311";
        }
        if(progress.equals("211321")){
            progress = "311";
        }
        if(progress.equals("2131")){
            progress = "311";
        }
        if(progress.equals("231")){
            progress= "321";
        }
        if(progress.equals("2111")){
            progress = "1332";
        }
        if(progress.equals("311")){
            progress = "1332";
        }
        if(progress.equals("3131")){
            ending("131");
        }
        if(progress.equals("2321")){
            progress = "31";
        }
        Story(progress);
    }

    public void onClickOpt2(View view){
        progress = progress + "2";
        if(progress.equals("122")){
            progress = "2";
        }
        if(progress.equals("2122")){
            progress = "312";
        }
        if(progress.equals("211322")){
            progress = "312";
        }
        if(progress.equals("2132")){
            progress = "312";
        }
        if(progress.equals("233")){
            progress = "323";
        }
        if(progress.equals("3132")){
            ending("132");
        }
        if(progress.equals("3212")){
            progress = "31";
        }
        if(progress.equals("322")){
            progress = "313";
        }
        if(progress.equals("2322")){
            progress = "32";
        }
        Story(progress);
    }

    public void onClickOpt3(View view){
        progress = progress + "3";
        if(progress.equals("2123")){
            progress = "313";
        }
        if(progress.equals("223")){
            progress = "2113";
        }
        if(progress.equals("2223")){
            progress = "2113";
        }
        if(progress.equals("211323")){
            progress = "313";
        }
        if(progress.equals("2133")){
            progress = "313";
        }
        if(progress.equals("33")){
            progress = "2";
        }
        if(progress.equals("3133")){
            ending("133");
        }
        if(progress.equals("2323")){
            progress = "33";
        }
        Story(progress);

    }

    public void Story(String progress){
        TextView storyText = (TextView)findViewById(R.id.storyText);
        Button b1 = (Button)findViewById(R.id.option1);
        Button b2 = (Button)findViewById(R.id.option2);
        Button b3 = (Button)findViewById(R.id.option3);
        if(progress.equals("")){
            storyText.setText(R.string.p);
            b1.setText(R.string.o1);
            b2.setText(R.string.o2);
            b3.setText(R.string.o3);
        }
        if(progress.equals("1")){
            stopPlaying();
            mp = MediaPlayer.create(story.this, R.raw.p1);
            mp.start();
            storyText.setText(R.string.p1);
            b1.setText(R.string.o11);
            b2.setText(R.string.o12);
            b3.setText(R.string.o13);
        }
        if(progress.equals("12")){
            stopPlaying();
            mp = MediaPlayer.create(story.this, R.raw.p12);
            mp.start();
            storyText.setText(R.string.p12);
            b1.setText(R.string.o121);
            b2.setText(R.string.o122);
            b3.setText(R.string.o123);
        }
        if(progress.equals("13")){
            stopPlaying();
            mp = MediaPlayer.create(story.this, R.raw.p13);
            mp.start();
            storyText.setText(R.string.p13);
            b1.setText(R.string.o131);
            b2.setText(R.string.o132);
            b3.setText(R.string.o133);
        }
        if(progress.equals("131")){
            ending(progress);
        }
        if(progress.equals("132")){
            ending(progress);
        }
        if(progress.equals("133")){
            stopPlaying();
            mp = MediaPlayer.create(story.this, R.raw.p133);
            mp.start();
            storyText.setText(R.string.p133);
            b1.setText(R.string.o1331);
            b2.setText(R.string.o1332);
            b3.setText(R.string.o1333);
        }
        if(progress.equals("1331")){
            ending(progress);
        }
        if(progress.equals("1332")){
            stopPlaying();
            mp = MediaPlayer.create(story.this, R.raw.p1332);
            mp.start();
            storyText.setText(R.string.p1332);
            b1.setText(R.string.o13321);
            b2.setText(R.string.o13322);
            b3.setText(R.string.o13323);
        }
        if(progress.equals("13321")){
            ending(progress);
        }
        if(progress.equals("13322")){
            ending(progress);
        }
        if(progress.equals("13323")){
            ending(progress);
        }
        if (progress.equals("1333")) {
            ending(progress);
        }

        if(progress.equals("2")){
            stopPlaying();
            mp = MediaPlayer.create(story.this, R.raw.p2);
            mp.start();
            storyText.setText(R.string.p2);
            b1.setText(R.string.o21);
            b2.setText(R.string.o22);
            b3.setText(R.string.o23);
        }
        if(progress.equals("21")){
            stopPlaying();
            mp = MediaPlayer.create(story.this, R.raw.p21);
            mp.start();
            storyText.setText(R.string.p21);
            b1.setText(R.string.o211);
            b2.setText(R.string.o212);
            b3.setText(R.string.o213);
        }
        if(progress.equals("211")){
            stopPlaying();
            mp = MediaPlayer.create(story.this, R.raw.p211);
            mp.start();
            storyText.setText(R.string.p211);
            b1.setText(R.string.o2111);
            b2.setText(R.string.o2112);
            b3.setText(R.string.o2113);
        }
        if(progress.equals("212")){
            stopPlaying();
            mp = MediaPlayer.create(story.this, R.raw.p212);
            mp.start();
            storyText.setText(R.string.p212);
            b1.setText(R.string.o311);
            b2.setText(R.string.o312);
            b3.setText(R.string.o313);
        }
        if(progress.equals("213")){
            stopPlaying();
            mp = MediaPlayer.create(story.this, R.raw.p213);
            mp.start();
            storyText.setText(R.string.p213);
            b1.setText(R.string.o21131);
            b2.setText(R.string.o21132);
            b3.setText(R.string.o21133);
        }
        if(progress.equals("2112")){
            ending("1333");
        }
        if(progress.equals("2113")){
            stopPlaying();
            mp = MediaPlayer.create(story.this, R.raw.p2113);
            mp.start();
            storyText.setText(R.string.p2113);
            b1.setText(R.string.o21131);
            b2.setText(R.string.o21132);
            b3.setText(R.string.o21133);
        }
        if(progress.equals("21131")){
            ending(progress);
        }
        if(progress.equals("21132")){
            stopPlaying();
            mp = MediaPlayer.create(story.this, R.raw.p21132);
            mp.start();
            storyText.setText(R.string.p21132);
            b1.setText(R.string.o311);
            b2.setText(R.string.o312);
            b3.setText(R.string.o313);
        }
        if(progress.equals("21133")){
            ending(progress);
        }
        if(progress.equals("22")){
            stopPlaying();
            mp = MediaPlayer.create(story.this, R.raw.p22);
            mp.start();
            storyText.setText(R.string.p22);
            b1.setText(R.string.o221);
            b2.setText(R.string.o222);
            b3.setText(R.string.o223);
        }
        if(progress.equals("222")){
            stopPlaying();
            mp = MediaPlayer.create(story.this, R.raw.p222);
            mp.start();
            storyText.setText(R.string.p222);
            b1.setText(R.string.o2221);
            b2.setText(R.string.o2222);
            b3.setText(R.string.o2223);
        }
        if(progress.equals("2221")){
            ending(progress);
        }
        if(progress.equals("2222")){
            ending(progress);
        }
        if(progress.equals("2223")){
            stopPlaying();
            mp = MediaPlayer.create(story.this, R.raw.p2223);
            mp.start();
            storyText.setText(R.string.p2223);
            b1.setText(R.string.o21131);
            b2.setText(R.string.o21132);
            b3.setText(R.string.o21133);
        }
        if(progress.equals("223")){
            stopPlaying();
            mp = MediaPlayer.create(story.this, R.raw.p223);
            mp.start();
            storyText.setText(R.string.p223);
            b1.setText(R.string.o21131);
            b2.setText(R.string.o21132);
            b3.setText(R.string.o21133);
        }
        if(progress.equals("23")){
            stopPlaying();
            mp = MediaPlayer.create(story.this, R.raw.p23);
            mp.start();
            storyText.setText(R.string.p23);
            b1.setText(R.string.o231);
            b2.setText(R.string.o232);
            b3.setText(R.string.o233);
        }
        if(progress.equals("232")){
            stopPlaying();
            mp = MediaPlayer.create(story.this, R.raw.p232);
            mp.start();
            storyText.setText(R.string.p232);
            b1.setText(R.string.o311);
            b2.setText(R.string.o312);
            b3.setText(R.string.o313);
        }
        if(progress.equals("233")){
            stopPlaying();
            mp = MediaPlayer.create(story.this, R.raw.p233);
            mp.start();
            storyText.setText(R.string.p233);
            b1.setText(R.string.o21131);
            b2.setText(R.string.o21132);
            b3.setText(R.string.o21133);
        }

        if(progress.equals("3")){
            stopPlaying();
            mp = MediaPlayer.create(story.this, R.raw.p3);
            mp.start();
            storyText.setText(R.string.p3);
            b1.setText(R.string.o31);
            b2.setText(R.string.o32);
            b3.setText(R.string.o33);
        }
        if(progress.equals("31")){
            stopPlaying();
            mp = MediaPlayer.create(story.this, R.raw.p31);
            mp.start();
            storyText.setText(R.string.p31);
            b1.setText(R.string.o311);
            b2.setText(R.string.o312);
            b3.setText(R.string.o313);
        }
        if(progress.equals("312")){
            stopPlaying();
            mp = MediaPlayer.create(story.this, R.raw.p312);
            mp.start();
            storyText.setText(R.string.p312);
            b1.setText(R.string.o3121);
            b2.setText(R.string.o3122);
            b3.setText(R.string.o3123);
        }
        if(progress.equals("3121")){
            stopPlaying();
            mp = MediaPlayer.create(story.this, R.raw.p3121);
            mp.start();
            storyText.setText(R.string.p3121);
            b1.setText(R.string.o31211);
            b2.setText(R.string.o31212);
            b3.setText(R.string.o31213);
        }
        if(progress.equals("31211")){
            ending(progress);
        }
        if(progress.equals("31212")){
            ending("132");//go to prison
        }
        if(progress.equals("31213")){
            ending(progress);
        }
        if(progress.equals("313")){
            stopPlaying();
            mp = MediaPlayer.create(story.this, R.raw.p313);
            mp.start();
            storyText.setText(R.string.p313);
            b1.setText(R.string.o131);
            b2.setText(R.string.o132);
            b3.setText(R.string.o133);
        }
        if(progress.equals("32")){
            stopPlaying();
            mp = MediaPlayer.create(story.this, R.raw.p32);
            mp.start();
            storyText.setText(R.string.p32);
            b1.setText(R.string.o321);
            b2.setText(R.string.o322);
            b3.setText(R.string.o323);
        }
        if(progress.equals("321")){
            stopPlaying();
            mp = MediaPlayer.create(story.this, R.raw.p321);
            mp.start();
            storyText.setText(R.string.p321);
            b1.setText(R.string.o3211);
            b2.setText(R.string.o3212);
            b3.setText(R.string.o3213);
        }
        if(progress.equals("3211")){
            ending(progress);
        }
        if(progress.equals("3213")){
            ending(progress);
        }
        if(progress.equals("323")){
            ending(progress);
        }

    }

    public void ending(String progress){
        stopPlaying();
        Intent end = new Intent(this, ending.class);
        end.putExtra(ending.endofstory, progress);
        startActivity(end);

    }

    private void stopPlaying(){

        if(mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }

}
