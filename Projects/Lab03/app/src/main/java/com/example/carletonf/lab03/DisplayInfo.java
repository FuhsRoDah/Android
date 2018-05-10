package com.example.carletonf.lab03;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import android.app.Activity;


public class DisplayInfo extends Activity {
    public static final String Team_Info = "message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_info);
        Intent show = getIntent();
        String messageText = show.getStringExtra(Team_Info);
        TextView teamInfo = (TextView)findViewById(R.id.teamInfo);
        String textUpdate = getInfo(messageText);
        ImageView teamPic = (ImageView)findViewById(R.id.teamPic);

        if(messageText.equals("Jacksonville Jaguars")){
            teamPic.setImageResource(R.drawable.jacksonville_jaguars_416x416);
        }
        else if(messageText.equals("New England Patriots")){
            teamPic.setImageResource(R.drawable.new_england_patriots_betting);
        }
        else if(messageText.equals("Minnesota Vikings")){
            teamPic.setImageResource(R.drawable.minnesota_vikings);
        }
        else if(messageText.equals("Philadelphia Eagles")){
            teamPic.setImageResource(R.drawable.philadelphia_eagles);
        }

        teamInfo.setText(textUpdate);
    }

    String getInfo(String messageText){
        String newText="";

        if(messageText.equals("Jacksonville Jaguars")){
            newText="The Jacksonville Jaguars made it to the AFC Championship game"
                    +" where they were defeated by the New England Patriots. Their"
                    +" record for the season is 10 wins and 6 losses.";
        }
        else if(messageText.equals("New England Patriots")){
            newText="The New England Patriots made it to the AFC Championship game"
                    +" where they defeated the Jacksonville Jaguars. Their"
                    +" record for the season is 13 wins and 3 losses. They're going to the"
            +" SuperBowl";
        }
        else if(messageText.equals("Minnesota Vikings")){
            newText="The Minnesota Vikings made it to the NFC Championship game"
                    +" where they were defeated by the Philadelphia Eagles. Their"
                    +" record for the season is 13 wins and 3 losses.";
        }
        else if(messageText.equals("Philadelphia Eagles")){
            newText="The Philadelphia Eagles made it to the NFC Championship game"
                    +" where they defeated the Minnesota Vikings. Their"
                    +" record for the season is 13 wins and 3 losses. They're going to the " +
                    " SuperBowl";
        }
        return newText;
    }

}
