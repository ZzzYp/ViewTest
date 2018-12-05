package com.mine.test.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * ProjectName:ViewTest
 * CREATE BY:yupeng.zhang
 * CREATE DATE:2018/9/6
 * DESCRIBE:
 */
class PathView(context: Context) : View(context) {


    constructor(context: Context, attributeSet: AttributeSet) : this(context) {

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //直接描述路径
        drawDescribePath(canvas)
    }

    private fun drawDescribePath(canvas: Canvas) {
        //addXXX  添加子图形
        addGraph(canvas)
    }

    private fun addGraph(canvas: Canvas) {
        //user addpath draw circle
        drawCircle(canvas);
        //user addpath draw line
        drawLines(canvas);
        //user addpath draw bezier curve line
        drawBezierCurveLine(canvas);

    }

    private fun drawBezierCurveLine(canvas: Canvas) {
        var paint: Paint = Paint();
        paint.color = Color.GREEN;
        paint.style = Paint.Style.STROKE;
        paint.strokeWidth = 10F;

        var path: Path = Path();

        path.moveTo(10f, 500f);
        path.quadTo(100f, 1f, 200f, 500f);
        canvas.drawPath(path, paint)

        path.moveTo(200f,500f)
        path.cubicTo(250f,250f,400f,400f,500f,500f)
        canvas.drawPath(path, paint)
    }

    private fun drawLines(canvas: Canvas) {
        var paint: Paint = Paint();
        paint.color = Color.GREEN;
        paint.style = Paint.Style.STROKE;
        paint.strokeWidth = 10F;

        var path: Path = Path();
        path.moveTo(450F, 10F);
        /**
         * lineTo：绝对坐标
         */
        path.lineTo(450F, 300F);
        canvas.drawPath(path, paint);
        /**
         * rLineTo:相对坐标
         */
        paint.color = Color.RED;
        //重置path，移动到上一根线的终点，开始画下一根线，颜色就可以不同
        path.reset();
        path.moveTo(450F, 300F);
        path.rLineTo(100F, -150F);
        canvas.drawPath(path, paint);
        path.close();


    }

    private fun drawCircle(canvas: Canvas) {
        //add two circle
        var paint: Paint = Paint();
        paint.flags = Paint.ANTI_ALIAS_FLAG;
        paint.style = Paint.Style.FILL;
        paint.color = Color.GREEN;
        paint.strokeWidth = 10F;
        var path: Path = Path();
        path.addCircle(200F, 200F, 100F, Path.Direction.CW);
        path.addCircle(300F, 200F, 100F, Path.Direction.CCW);
        canvas.drawPath(path, paint);


    }


}