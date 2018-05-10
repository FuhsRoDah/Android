package com.example.clintf.animationexample;

import com.example.clintf.animationexample.Sprite;

import android.graphics.Canvas;
/**
 * Created by CarletonF on 4/5/2018.
 */

public class PaddleSprite extends Sprite {

    public final static float DEFAULT_SIZE = 300.0f;
    public final static float DEFAULT_SIZE2 = 10.0f;

    public PaddleSprite(float xLoc, float yLoc, float xVel, float yVel){
        super(xLoc, yLoc, xVel, yVel);
    }

    /**
     * draws this onto the Canvas parameter
     * @param canvas - not null medium for drawing this on for
     */
    @Override
    public void draw(Canvas canvas){

        canvas.drawRect(super.getRect(), super.getPaint());
    }


}
