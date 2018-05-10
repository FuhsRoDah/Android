package com.example.carletonf.lab_06;

/**
 * Created by CarletonF on 4/4/2018.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;



/**
 * Created by CarletonF on 4/4/2018.
 */

public class DrawView extends View {


    public DrawView(Context context) {
        super(context);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int x = getWidth();
        int y = getHeight();
        int radius = 500;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);
        paint.setColor(Color.RED);
        canvas.drawCircle(x/2, y/2, radius, paint);
        paint.setColor(Color.WHITE);
        canvas.drawCircle(x/2, y/2, (float)(radius*.8), paint);
        paint.setColor(Color.RED);
        canvas.drawCircle(x/2, y/2, (float)(radius*.6), paint);
        paint.setColor(Color.WHITE);
        canvas.drawCircle(x/2, y/2, (float)(radius*.4), paint);
        paint.setColor(Color.RED);
        canvas.drawCircle(x/2, y/2, (float)(radius*.2), paint);
    }

}

