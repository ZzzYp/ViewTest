package com.mine.test.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;

public class ServiceTestForGetMsg extends Service {

    private final Messenger msg = new Messenger(new MsgHandler());

    public ServiceTestForGetMsg() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
       return msg.getBinder();
    }


    class MsgHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    }


}
