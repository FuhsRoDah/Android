package com.example.clintf.animationexample;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clintf on 3/29/17.
 */

/**
 * AnimationView - offers a graphical view of a simple animated app
 *     with BallSprites tat move around and bounce of the edges of the screen.
 *
 * Created by clintf on 3/29/17.
 * @author Clint Fuchs
 * @date 3/29/2017
 * @email clintf@coastal.edu
 * @course CSCI 343
 */
public class AnimationView extends View {



    private AnimationThread animationThread;

    private List<Sprite> spriteList;


    /**
     * Constructor that initializes this with two BallSprites and starts
     *     and animation thread that moves the BallSprites around the
     *     screen.
     *
     * @param context not null
     * @param attributeSet not null
     */
    public AnimationView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);

        initAnimationView();
    }

    private void initAnimationView(){

        this.spriteList = new ArrayList<Sprite>();

        Sprite sprite1 = new BallSprite(100, 100, 50, 50);
        sprite1.setSize(BallSprite.DEFAULT_SIZE, BallSprite.DEFAULT_SIZE);

        BallSprite sprite2 = new BallSprite(300, 300, 25, 25);
        sprite2.setSize(BallSprite.DEFAULT_SIZE, BallSprite.DEFAULT_SIZE);

        PaddleSprite paddle = new PaddleSprite(350, 1450, 0, 0);
        paddle.setSize(PaddleSprite.DEFAULT_SIZE, PaddleSprite.DEFAULT_SIZE2);

        this.spriteList.add(sprite1);
        this.spriteList.add(sprite2);
        this.spriteList.add(paddle);

        this.animationThread = new AnimationThread(this, AnimationThread.DEFAULT_FPS);
        this.animationThread.start();

    }


    /**
     * draws the BallSprites on this View and
     *    updates their position.
     *
     * @param canvas
     */
    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);

        drawAllSprites(canvas);

        updateAllSprites();

    }


    /**
     * draws all of Sprites in theList to this View.
     *
     * @param canvas should not be null
     */
    private void drawAllSprites(Canvas canvas){
        for(int index=0; index<this.spriteList.size(); index++){
            Sprite sprite = this.spriteList.get(index);

            sprite.draw(canvas);
        }
    }

    /**
     * updates the location of all of the Sprites' in theList
     */
    private void updateAllSprites(){
        for(int index=0; index<this.spriteList.size(); index++){
            Sprite sprite = this.spriteList.get(index);

            sprite.updateLocation(this.getWidth(), this.getHeight());

            paddleSpriteHitTest();

        }
    }

    private PaddleSprite getPaddle(){
        PaddleSprite paddle = null;

        for(int index=0; index<this.spriteList.size(); index++){
            if(this.spriteList.get(index) instanceof PaddleSprite){
                paddle = (PaddleSprite)this.spriteList.get(index);
            }
        }
        return paddle;
    }

    private void paddleSpriteHitTest(){
        PaddleSprite paddle = getPaddle();

        for(int index=0; index<this.spriteList.size(); index++){
            if(this.spriteList.get(index) instanceof BallSprite){
                BallSprite ball = (BallSprite)this.spriteList.get(index);
                if(ball.getRect().intersects(paddle.getRect().left,paddle.getRect().top,
                        paddle.getRect().right,paddle.getRect().bottom)){
                    ball.setxVelocity(ball.getxVelocity() * -1);
                    ball.setyVelocity(ball.getyVelocity() * -1);
                }
            }
        }

    }

    /**
     * recocgnizes a user's touch or tapping of the screen and reverses
     *    the velocity (x and y) for all of the Sprites in theList.
     * @param motionEvent should not be null
     * @return the parent's onTouchEvent
     */
    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){
        float xTouch = motionEvent.getX();
        float yTouch = motionEvent.getY();

        Sprite paddle = spriteList.get(2);
        paddle.getRect().offsetTo(xTouch-150, 1450);

        return super.onTouchEvent(motionEvent);
    }




}
