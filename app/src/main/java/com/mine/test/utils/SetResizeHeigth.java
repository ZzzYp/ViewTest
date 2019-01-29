package com.mine.test.utils;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import com.blankj.utilcode.util.LogUtils;

/**
 * Created by Administrator on 2018-10-26.
 */

/**
 * 解决 fitSystemWindow、adjustResize、FLAG_TRANSLUCENT_STATUS 一起使用的bug；
 */
public class SetResizeHeigth {

    public static void assistActivity(View content) {
        new SetResizeHeigth(content);
    }

    private View mChildOfContent;
    private int usableHeightPrevious;
    private ViewGroup.LayoutParams frameLayoutParams;

    private SetResizeHeigth(View content) {
        if (content != null) {
            mChildOfContent = content;
            mChildOfContent.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    possiblyResizeChildOfContent();
                }
            });
            frameLayoutParams = mChildOfContent.getLayoutParams();
        }
    }

    private void possiblyResizeChildOfContent() {
        int usableHeightNow = computeUsableHeight();
        LogUtils.d("zyp", "  usableHeightNow   :  " + usableHeightNow);
        LogUtils.d("zyp", "  usableHeightPrevious   :  " + usableHeightPrevious);
        if (usableHeightNow != usableHeightPrevious) {
            //if twice height is diff
            // calculate`s visual height = view`s height
            frameLayoutParams.height = usableHeightNow;
            mChildOfContent.requestLayout();
            usableHeightPrevious = usableHeightNow;
        }
    }

    private int computeUsableHeight() {
        //calculate visual height
        Rect r = new Rect();
        mChildOfContent.getWindowVisibleDisplayFrame(r);
        LogUtils.d("zyp", "   r.bottom  :  " +  r.bottom);
        return (r.bottom);
    }

}
