package com.mine.test.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import java.util.jar.Attributes

/**
 * Created by Administrator on 2018-10-31.
 */
class PiePicView(context: Context) : View(context) {

    constructor(context: Context, attributeSet: AttributeSet) : this(context)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //画饼图
        drawPiePic(canvas)

    }

    private fun drawPiePic(canvas: Canvas?) {
        //饼图由不同扇形组成
        //r 为饼状图半径
        drawArc(canvas, 400f)


    }

    private fun drawArc(canvas: Canvas?, r: Float) {
        //通过不同参数画出不同扇形
        //Paint.ANTI_ALIAS_FLAG --> 抗锯齿
        var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = Color.BLUE
        paint.style = Paint.Style.FILL

        //角度0--60
        var sweepAngle60: Float = 60f
        var left60: Float = 0f
        var top60: Float = 20f
        var rectF60: RectF = RectF()
        rectF60.set(left60, top60, r, r)
        //useCenter =true 代表连接到圆心
        canvas?.drawArc(rectF60, -180f, sweepAngle60, true, paint)

        //角度 60--90
        var sweepAngle30: Float = 30f
        var left30: Float = 10f
        var top30: Float = 16f
        //sin60 = ?
        //var radians60 = Math.toRadians(sweepAngle60.toDouble())
        //var sin60 = Math.sin(radians60)
        //第二个饼图需要延长的半径
        //var rTow: Float = ((left30 - left60) * sin60).toFloat() + r
        paint.color = Color.RED
        var rectF90: RectF = RectF()
        rectF90.set(left30, top30, r, r)
        canvas?.drawArc(rectF90, -120f, sweepAngle30, true, paint)

        //角度 90--170
        var sweepAngle170: Float = 170f
        var left170: Float = 30f
        var top170: Float = 16f
        paint.color = Color.YELLOW
        var rectF170: RectF = RectF()
        rectF170.set(left170, top170, r, r)
        canvas?.drawArc(rectF170, -90f, sweepAngle170, true, paint)

        //角度 170--190
        var sweepAngle190: Float = 20f
        var left190: Float = 10f
        var top190: Float = 20f
        paint.color = Color.BLACK
        var rectF190: RectF = RectF()
        rectF190.set(left190, top190, r, r)
        canvas?.drawArc(rectF190, 80f, sweepAngle190, true, paint)


        //角度 190--220
        var sweepAngle220: Float = 30f
        var left220: Float = 0f
        var top220: Float = 20f
        paint.color = Color.CYAN
        var rectF220: RectF = RectF()
        rectF220.set(left220, top220, r, r)
        canvas?.drawArc(rectF220, 100f, sweepAngle220, true, paint)

        //角度 220--270
        var sweepAngle270: Float = 50f
        var left270: Float = 0f
        var top270: Float = 20f
        paint.color = Color.DKGRAY
        var rectF270: RectF = RectF()
        rectF270.set(left270, top270, r, r)
        canvas?.drawArc(rectF270, 130f, sweepAngle270, true, paint)
    }


}