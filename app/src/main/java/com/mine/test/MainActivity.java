package com.mine.test;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.mine.test.clazzTest.ChildClazz;
import com.mine.test.interfaces.ApiService;
import com.mine.test.javaTest.LinkedListTest;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private final String TAG = "MainActivity";
    private Logger logger;
    private TextView tvToPathview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        logger = Logger.getLogger(TAG);


        initView();

        initRetrifit();
        initOkHttp();

    }

    private void initOkHttp() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newCall(new Request.Builder().url("").build()).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {

            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {

            }
        });


    }

    private void initRetrifit() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("\"https://api.github.com/\"").build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<Response>> call = apiService.listRepos("ddd");
        call.enqueue(new Callback<List<Response>>() {
            @Override
            public void onResponse(Call<List<Response>> call, Response<List<Response>> response) {

            }

            @Override
            public void onFailure(Call<List<Response>> call, Throwable t) {

            }
        });


    }


    private void initView() {
        tvToPathview = findViewById(R.id.tv_to_pathview);
        tvToPathview.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    protected void onResume() {
        super.onResume();

        final boolean isChange;
        isChange = false;
        logger.info("isChange    1 :" + isChange);

        int[] intArr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = 0; i < intArr.length; i++) {
            if (5 == intArr[i]) {
                logger.info("intArr continue " + i + " :" + intArr[i]);
                continue;
            }
            logger.info("intArr  " + i + " :" + intArr[i]);
        }

        //test child and parents super
        ChildClazz childClazz = new ChildClazz();
        childClazz.print();

        testLinkList();
    }

    private void testLinkList() {


        LinkedListTest<String> linkedList = new LinkedListTest();
        for (int i = 0; i < 10; i++) {
            String s = "item" + i;
            linkedList.add(s);
        }

    }

    private WindowManager.LayoutParams mParams;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_to_pathview:
                //Intent intent = new Intent(this, PathViewActivity.class);
                Intent intent = new Intent(this, TabViewPageActivity.class);

                startActivity(intent);
                break;

            //new InnerClass().getOutObj();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int y = displayMetrics.heightPixels / 4;


/*        mParams = new WindowManager.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                0,
                // WindowManager.LayoutParams.TYPE_SYSTEM_ALERT,
//                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,// for Android 8.0
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                        WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL *//*|
                        WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |*//*,
                PixelFormat.TRANSLUCENT);

        mParams.y = 30;*/
    }


    class InnerClass {
        private void getOutObj() {
            MainActivity.this.testLinkList();
        }
    }
}
