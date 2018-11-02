package com.mine.test;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.mine.test.utils.DpUtils;
import com.mine.test.utils.KeyboardUtil;

public class ImmersionTestActivity extends AppCompatActivity {

    private LinearLayout cl_coordinatorLayout;
    private RelativeLayout rl_coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immersion_test);

        setImmersion();
        initview();
        //new KeyboardUtil(this, findViewById(android.R.id.content)).enable();

    }

    private void initview() {

        cl_coordinatorLayout = findViewById(R.id.cl_coordinatorLayout);
        rl_coordinatorLayout = findViewById(R.id.rl_coordinatorLayout);


        findViewById(R.id.bt_color).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int colorRes = getResources().getColor(R.color.text_uncheck_background_yellow, getTheme());
                changeColor(colorRes);
            }
        });
        findViewById(R.id.bt_drawable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable = getResources().getDrawable(R.drawable.gome_picture_memo_autumn_tittle_bg, getTheme());
                changeDrawable(drawable);
            }
        });

        findViewById(R.id.iv_menu_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void changeColor(int colorRes) {
        cl_coordinatorLayout.setBackgroundColor(colorRes);
        cl_coordinatorLayout.setFitsSystemWindows(true);
        setTitleBarBgDisAttribute();
    }


    private void changeDrawable(Drawable drawable) {
        cl_coordinatorLayout.setBackground(drawable);
        cl_coordinatorLayout.setFitsSystemWindows(true);
        setTitleBarBgDisAttribute();
    }

    private void setTitleBarBgDisAttribute() {
        int statusBarHeight = getStatusBarHeight(this);
        //int titleBarWidth = DpUtils.dp2Px(this, 42);
        //RelativeLayout.LayoutParams llp = (RelativeLayout.LayoutParams) cl_coordinatorLayout.getLayoutParams();
        //llp.height = statusBarHeight + titleBarWidth;
        //llp.topMargin = statusBarHeight;
        //cl_coordinatorLayout.setLayoutParams(llp);
        cl_coordinatorLayout.setPadding(0, statusBarHeight, 0, 0);


    }

    private void setImmersion() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            //透明状态栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        }
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
    }


    private int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
