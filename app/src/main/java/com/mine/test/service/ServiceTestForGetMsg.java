package com.mine.test.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

import com.blankj.utilcode.util.LogUtils;

public class ServiceTestForGetMsg extends Service {
    private final static String TAG = "ServiceTestForGetMsg.class";
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
            if (null != msg) {
                String clientStr = msg.getData().getString("send");
                LogUtils.d(TAG, "  clientStr  : " + clientStr);
                Message message = Message.obtain();
                message.obj = " server str from ServiceTestForGetMsg";
                try {
                    msg.replyTo.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
