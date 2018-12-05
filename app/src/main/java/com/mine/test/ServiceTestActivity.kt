package com.mine.test

import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.*
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.mine.test.service.ServiceTestForGetMsg
import com.mine.test.service.ServiceTestForGetServiceObj
import kotlinx.android.synthetic.main.activity_service_test.*

class ServiceTestActivity : Activity(), View.OnClickListener {

    val TAG = "ServiceTestActivity"
    var context: Context = this;
    var getServiceObjConnection: ServiceTestForGetServiceObjConnection = ServiceTestForGetServiceObjConnection()
    var getForGetMsgConnection: ServiceTestForGetMsgConnection = ServiceTestForGetMsgConnection()
    var mBinder: ServiceTestForGetServiceObj.BindDemo? = null
    var mServiceObj: ServiceTestForGetServiceObj? = null
    lateinit var tv_ibinder_binder: Button
    lateinit var tv_ibinder_toast: Button
    lateinit var tv_ibinder_unbinder: Button
    lateinit var tv_ibinder_msg: Button
    lateinit var tv_ibinder_msg_toast: Button
    lateinit var tv_ibinder_msg_unbinder: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_test)

        initView()
        initListener()

    }


    private fun initView() {

        tv_ibinder_binder = findViewById<Button>(R.id.tv_ibinder_binder)
        tv_ibinder_toast = findViewById<Button>(R.id.tv_ibinder_toast)
        tv_ibinder_unbinder = findViewById<Button>(R.id.tv_ibinder_unbinder)

        tv_ibinder_msg = findViewById<Button>(R.id.tv_ibinder_msg)
        tv_ibinder_msg_toast = findViewById<Button>(R.id.tv_ibinder_msg_toast)
        tv_ibinder_msg_unbinder = findViewById<Button>(R.id.tv_ibinder_msg_unbinder)


    }


    private fun initListener() {
        tv_ibinder_binder.setOnClickListener(this)
        tv_ibinder_toast.setOnClickListener(this)
        tv_ibinder_unbinder.setOnClickListener(this)

        tv_ibinder_msg.setOnClickListener(this)
        tv_ibinder_msg_toast.setOnClickListener(this)
        tv_ibinder_msg_unbinder.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_ibinder_binder -> startServiceForGetServiceObj()
            R.id.tv_ibinder_toast -> {
                var msg = mServiceObj?.getStr(" get Ibinder")
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
            }
            R.id.tv_ibinder_unbinder -> {
                if (mServiceObj?.isRestricted!!) {
                    unbindService(getServiceObjConnection)
                }
            }

            R.id.tv_ibinder_msg -> {
                startServiceForGetMsg()
            }
            R.id.tv_ibinder_msg_toast -> {
            }
            R.id.tv_ibinder_msg_unbinder -> {
            }


        }
    }

    private fun startServiceForGetServiceObj() {
        var intent: Intent = Intent(this, ServiceTestForGetServiceObj::class.java)
        /**
         * flags :  * @param flags Operation options for the binding.  May be 0,
         *          {@link #BIND_AUTO_CREATE}, {@link #BIND_DEBUG_UNBIND},
         *          {@link #BIND_NOT_FOREGROUND}, {@link #BIND_ABOVE_CLIENT},
         *          {@link #BIND_ALLOW_OOM_MANAGEMENT}, or
         *          {@link #BIND_WAIVE_PRIORITY}.
         */
        bindService(intent, getServiceObjConnection, Context.BIND_AUTO_CREATE)
    }

    private fun startServiceForGetMsg() {
        var intent: Intent = Intent(this, ServiceTestForGetMsg::class.java)
        /**
         * flags :  * @param flags Operation options for the binding.  May be 0,
         *          {@link #BIND_AUTO_CREATE}, {@link #BIND_DEBUG_UNBIND},
         *          {@link #BIND_NOT_FOREGROUND}, {@link #BIND_ABOVE_CLIENT},
         *          {@link #BIND_ALLOW_OOM_MANAGEMENT}, or
         *          {@link #BIND_WAIVE_PRIORITY}.
         */
        bindService(intent, getForGetMsgConnection, Context.BIND_AUTO_CREATE)
    }


    inner class ServiceTestForGetServiceObjConnection : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
            //unbindservice 不会触发该回调
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            //step 1  get Ibinder  (获取IBinder接口)
            mBinder = service as? ServiceTestForGetServiceObj.BindDemo
            //kotlin 中 (? 表示当前是否对象可以为空 ，加在变量名后，系统在任何情况不会报它的空指针异常
            //        ， !! 表示当前对象不为空的情况下执行，加在变量名后，如果对象为null，那么系统一定会报异常！)
            mServiceObj = mBinder!!.service

        }

    }

    inner class ServiceTestForGetMsgConnection : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            //客户端并没有像扩展Binder类那样直接调用服务端的方法，而是采用了用Message来传递信息的方式达到交互的目的
            var msger: Messenger = Messenger(service)
            var msg: Message = Message()
            var bundle: Bundle = Bundle()
            bundle.putString("send", "clinet to service success");
            msg.data = bundle
            msg.replyTo = clientMsger
            msger.send(msg)
        }

    }

    var clientMsger: Messenger = Messenger(ClientHandler())

    inner class ClientHandler : Handler() {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)

        }
    }


    override fun onDestroy() {
        super.onDestroy()

        try {
            unbindService(getServiceObjConnection)
            unbindService(getForGetMsgConnection)
        } catch (e: Exception) {
            Log.d(TAG, e.toString())
        }


    }

}
