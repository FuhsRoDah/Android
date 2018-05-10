package com.example.carletonf.assignment02;

import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Typeface;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;


public class FillWords extends Activity {
    public static MadLibStory madlibs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_words);

        Intent intent = getIntent();
        EditText userinput = (EditText)findViewById(R.id.userinput);
        TextView wordsleft = (TextView)findViewById(R.id.wordsleft);
        TextView wordtype = (TextView)findViewById(R.id.wordtype);

       try {
           readFile();
        }
        catch (FileNotFoundException e) {
           e.printStackTrace();
       }
        createStory(userinput, wordsleft, wordtype);
    }

    public void readFile() throws FileNotFoundException{
        String filename = "";
        StringBuffer sbuffer = new StringBuffer();
        InputStream is=null;
        int randStory=0;

        randStory = (int)Math.floor(Math.random() * 5);
        switch(randStory){
            case 0: is = this.getResources().openRawResource(R.raw.madlib0_simple);
                madlibs = new MadLibStory(is);
                break;
            case 1:  is = this.getResources().openRawResource(R.raw.madlib1_tarzan);
                madlibs = new MadLibStory(is);
                break;
            case 2: is = this.getResources().openRawResource(R.raw.madlib2_university);
                madlibs = new MadLibStory(is);
                break;
            case 3: is = this.getResources().openRawResource(R.raw.madlib3_clothes);
                madlibs = new MadLibStory(is);
                break;
            case 4: is = this.getResources().openRawResource(R.raw.madlib4_dance);
                madlibs = new MadLibStory(is);
                break;
        }
        BufferedReader reader= new BufferedReader(new InputStreamReader(is));
        if (is != null){
            try{
                while((filename = reader.readLine()) != null) {
                    sbuffer.append(filename + " ");
                }
                is.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

    }

    public void createStory(EditText userinput, TextView wordsleft, TextView wordtype){
        String ph = madlibs.getNextPlaceholder();
        userinput.setText("");
        //userinput.setText(ph);
        String words = madlibs.getPlaceholderRemainingCount() + " word(s) left";
        wordsleft.setText(words);
        wordtype.setText("Please enter a(n) " +ph);
    }


    public void onClickOk(View view){
        EditText userinput = (EditText)findViewById(R.id.userinput);
        TextView wordsleft = (TextView)findViewById(R.id.wordsleft);
        TextView wordtype = (TextView)findViewById(R.id.wordtype);
        String fill = String.valueOf(userinput.getText());
        madlibs.fillInPlaceholder(fill);
        try{
            createStory(userinput, wordsleft, wordtype);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        if(madlibs.isFilledIn()){
            onClickLastOk();
        }
    }

    public void onClickLastOk(){
        String story = madlibs.toString();
        Intent intent2 = new Intent(this, ShowStory.class);
        intent2.putExtra("message", story);
        startActivity(intent2);
    }

}
