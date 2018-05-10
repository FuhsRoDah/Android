package com.example.clintf.animationexample;

import android.graphics.Canvas;


/**
 * Represents s Sprite in the shape of a Ball
 * Created by clintf on 3/29/17.
 * @author Clint Fuchs
 * @date 3/29/2017
 * @email clintf@coastal.edu
 * @course CSCI 343
 */


public class BallSprite extends Sprite {


    public final static float DEFAULT_SIZE = 100.0f;

    public BallSprite(float xLoc, float yLoc, float xVel, float yVel){
        super(xLoc, yLoc, xVel, yVel);
    }

    /**
     * draws this onto the Canvas parameter
     * @param canvas - not null medium for drawing this on for
     */
    @Override
    public void draw(Canvas canvas){

        canvas.drawOval(super.getRect(), super.getPaint());
    }


}
