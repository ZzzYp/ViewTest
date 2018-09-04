package com.mine.test.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class DrawView extends View {
    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(5);
        float[] ptslin1 = {
                50, 300, 200, 250
        };
        float[] ptslin2 = {
                200, 250, 250, 100
        };
        float[] ptslin3 = {
                250, 100, 300, 250
        };
        float[] ptslin4 = {
                300, 250, 450, 300
        };

        float[] ptslin5 = {
                50, 300, 200, 350
        };
        float[] ptslin6 = {
                200, 350, 150, 500
        };

        float[] ptslin7 = {
                150, 500, 250, 400
        };
        float[] ptslin8 = {
                250, 400, 350, 500
        };

        float[] ptslin9 = {
                450, 300, 300, 350
        };
        float[] ptslin10 = {
                300, 350, 350, 500
        };

        canvas.drawLines(ptslin1, paint);
        canvas.drawLines(ptslin2, paint);
        canvas.drawLines(ptslin3, paint);
        canvas.drawLines(ptslin4, paint);
        canvas.drawLines(ptslin5, paint);
        canvas.drawLines(ptslin6, paint);
        canvas.drawLines(ptslin7, paint);
        canvas.drawLines(ptslin8, paint);
        canvas.drawLines(ptslin9, paint);
        canvas.drawLines(ptslin10, paint);
        paint.setStyle(Paint.Style.STROKE);

        canvas.drawCircle(250, 300, 200, paint);
        canvas.drawColor(Color.parseColor("#88880000"));

        //矩形
        Rect rect = new Rect();
        rect.set(600, 150, 800, 500);
        canvas.drawRect(rect, paint);

        //piont
        float[] points = {50, 600, 60, 600, 70, 600, 80, 600, 90, 600, 50, 700, 60, 700, 70, 700, 80, 700, 90, 700};
        canvas.drawPoints(points, 2, 12, paint);
        //oval
        RectF rectF = new RectF();
        rectF.set(50, 800, 200, 1000);
        canvas.drawOval(rectF, paint);
        //RoundRect

        canvas.drawRoundRect(300,800,500,1000,40,40,paint);
        //drawArc
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(550,800,700,950,0,100,true,paint);
        canvas.drawArc(550,1150,700,1300,-180,100,false,paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(750,800,900,1100,0,100,true,paint);
        canvas.drawArc(750,1150,900,1450,-180,100,false,paint);
    }
}
