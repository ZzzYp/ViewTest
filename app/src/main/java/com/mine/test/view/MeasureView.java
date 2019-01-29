package com.mine.test.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.blankj.utilcode.util.LogUtils;

/**
 * Created by Administrator on 2018-12-27.
 */

public class MeasureView extends RelativeLayout {
    public MeasureView(Context context) {
        super(context);
    }

    public MeasureView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MeasureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MeasureView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMeasureSpecSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        switch (widthMeasureSpecSpecMode) {
            case MeasureSpec.AT_MOST:
                LogUtils.e("zyp", "widthMeasureSpec  WRAP_CONTENT  MeasureSpec.AT_MOST");
                break;
            case MeasureSpec.EXACTLY:
                LogUtils.e("zyp", "widthMeasureSpec  MATCH_PARENT  MeasureSpec.EXACTLY");
                break;
            case MeasureSpec.UNSPECIFIED:
                LogUtils.e("zyp", "widthMeasureSpec    MeasureSpec.UNSPECIFIED");
                break;
            default:
                LogUtils.e("zyp", "widthMeasureSpec    default");
                break;
        }

        int heightMeasureSpecSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        switch (heightMeasureSpecSpecMode) {
            case MeasureSpec.AT_MOST:
                LogUtils.e("zyp", "heightMeasureSpec  WRAP_CONTENT  MeasureSpec.AT_MOST");
                break;
            case MeasureSpec.EXACTLY:
                LogUtils.e("zyp", "heightMeasureSpec  MATCH_PARENT  MeasureSpec.EXACTLY");
                break;
            case MeasureSpec.UNSPECIFIED:
                LogUtils.e("zyp", "heightMeasureSpec    MeasureSpec.UNSPECIFIED");
                break;
            default:
                LogUtils.e("zyp", "heightMeasureSpec    default");
                break;
        }

        //setMeasuredDimension(widthMeasureSpec,heightMeasureSpec);

        if (getChildCount() > 0) {
            View childView = getChildAt(0);
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
        }

    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (getChildCount() > 0) {
            View childView = getChildAt(0);
            childView.layout(50, 50, 200, 200);
            LogUtils.d("zyp", "   childView.getHeight()  : " + childView.getHeight() + "   childView.getWidth() : " + childView.getWidth());
            LogUtils.d("zyp", "   childView.getMeasuredHeight()  : " + childView.getMeasuredHeight()
                    + "   childView.getMeasuredWidth() : " +childView.getMeasuredWidth());
        }



    }
}
