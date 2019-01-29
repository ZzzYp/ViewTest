package com.mine.test;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.aidlserviceapp.AidlLoginInfoBean;
import com.example.aidlserviceapp.AidlLoginInfoBeanManager;

import java.util.List;

public class AidlActivity extends Activity implements View.OnClickListener {

    private Button button_1;
    private boolean isLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);
        initView();
        initListener();
    }

    @Override
    protected void onStart() {
        super.onStart();
        lineServer();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isLine) {
            unbindService(serviceConnection);
            isLine = false;
        }

    }

    private void initView() {
        button_1 = findViewById(R.id.button_1);

    }

    private void initListener() {
        button_1.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_1:

                clickButton();

                break;
        }
    }

    AidlLoginInfoBeanManager aidlLoginInfoBeanManager = null;

    private void clickButton() {
        if (!isLine) {
            lineServer();
        }

        if (null == aidlLoginInfoBeanManager) {
            return;
        }

        AidlLoginInfoBean aidlLoginInfoBean = new AidlLoginInfoBean();
        aidlLoginInfoBean.setEmail("7878787877@136.com");
        aidlLoginInfoBean.setPassword("ewewewewwewew");
        Log.e("zyp", " clickButton  " + aidlLoginInfoBean.toString());
        try {
            aidlLoginInfoBeanManager.addAidlLoginInfoBean(aidlLoginInfoBean);

        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    private void lineServer() {
        Intent intent = new Intent();
        intent.setAction("com.example.aidlserviceapp_action");
        intent.setPackage("com.example.aidlserviceapp");
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
        isLine = true;

    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            aidlLoginInfoBeanManager = AidlLoginInfoBeanManager.Stub.asInterface(service);
            if (aidlLoginInfoBeanManager != null) {
                try {
                    List<AidlLoginInfoBean> aidlLoginInfoBeans = aidlLoginInfoBeanManager.getAidlLoginInfoBean();
                    Log.e("zyp", " AidlActivity  " + aidlLoginInfoBeans.toString());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}
