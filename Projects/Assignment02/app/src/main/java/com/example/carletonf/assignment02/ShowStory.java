package com.example.carletonf.assignment02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class ShowStory extends Activity {
    public static final String message = "message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_story);

        Intent intent2 = getIntent();
        String story = intent2.getStringExtra(message);
        TextView compstory = (TextView)findViewById(R.id.story);
        compstory.setText(story);

    }

    public void onClickNewStory(View view){
       Intent intent = new Intent(this, FillWords.class);
        startActivity(intent);
    }

}
