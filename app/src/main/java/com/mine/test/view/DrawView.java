package com.mine.test.view;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

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

        drawFivePointedStar(canvas);
        //矩形
        drawRect(canvas);
        drawPoint(canvas);
        //oval 椭圆
        drawoval(canvas);
        //RoundRect  圆角矩形
        drawRoundRect(canvas);
        //drawArc  扇形
        drawArc(canvas);
        //自定义图形
    }

    private void drawArc(Canvas canvas) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
        //drawArc  扇形
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(550, 800, 700, 950, 0, 100, true, paint);
        canvas.drawArc(550, 1150, 700, 1300, -180, 100, false, paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(750, 800, 900, 1100, 0, 100, true, paint);
        canvas.drawArc(750, 1150, 900, 1450, -180, 100, false, paint);

    }


    private void drawRoundRect(Canvas canvas) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
        //RoundRect  圆角矩形
        canvas.drawRoundRect(300, 800, 500, 1000, 40, 40, paint);
    }


    private void drawoval(Canvas canvas) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
        //oval 椭圆
        RectF rectF = new RectF();
        rectF.set(50, 800, 200, 1000);
        canvas.drawOval(rectF, paint);

    }

    private void drawPoint(Canvas canvas) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
        //piont
        float[] points = {50, 600, 60, 600, 70, 600, 80, 600, 90, 600, 50, 700, 60, 700, 70, 700, 80, 700, 90, 700};
        canvas.drawPoints(points, 2, 12, paint);
    }

    private void drawRect(Canvas canvas) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);

        //矩形
        Rect rect = new Rect();
        rect.set(600, 150, 800, 500);
        canvas.drawRect(rect, paint);
    }

    private void drawFivePointedStar(Canvas canvas) {

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        //paint.setStrokeWidth(5);
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

        Paint paintCircle = new Paint(Paint.ANTI_ALIAS_FLAG);

        paintCircle.setStyle(Paint.Style.STROKE);
        paintCircle.setColor(Color.BLUE);
        //canvas.drawColor(Color.parseColor("#88880000"));
        canvas.drawCircle(250, 300, 200, paintCircle);


    }
}
