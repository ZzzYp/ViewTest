package com.mine.test.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2018-11-12.
 */

public class ServiceTestForGetServiceObj extends Service {

    private IBinder iBinder = new BindDemo();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {


        return iBinder;
    }


    public class BindDemo extends Binder {


        //return this Service Obj
        public ServiceTestForGetServiceObj getService() {

            return ServiceTestForGetServiceObj.this;
        }
    }

    public String getStr(String msg) {
        return "ServiceTestForGetServiceObj  : " + msg;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
