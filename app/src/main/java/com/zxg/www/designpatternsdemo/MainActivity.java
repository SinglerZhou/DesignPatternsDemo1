package com.zxg.www.designpatternsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    //主线程创建的handler
    @SuppressLint("HandlerLeak")
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            System.out.println("handleMessage: msg.what=" + msg.what + "msg.obj=" + msg.obj);
            Log.i(TAG, "zxglog handleMessage: msg.what=" + msg.what + "msg.obj=" + msg.obj);
            //我要测试更新github
            Log.i(TAG, "zxglog handleMessage: ");

        }
    };
    //子线程创建的handler
    private Handler mHandler1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startHandler();
        //通过handler，主线程给子线程发送消息
        sendMessageToChildThread();
    }

    private void sendMessageToChildThread() {
        //延迟1s执行，防止handler没有创建
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Message message1 = mHandler1.obtainMessage();
                message1.obj = "我是主线程sendMessageToChildThread给子线程发送的消息";
                message1.what = 2;
                mHandler1.sendMessage(message1);

                childThreadToChildThread();
            }

            private void childThreadToChildThread() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = mHandler1.obtainMessage();
                        message.obj = "我是子线程 run() 给子线程发送的消息";
                        message.what = 3;
                        mHandler1.sendMessage(message);
                    }
                }).start();
            }
        }, 1000);


    }

    public void startHandler() {
        //模拟：开启子线程，发送消息给主线程

        new Thread(new Runnable() {
            @SuppressLint("HandlerLeak")
            @Override
            public void run() {
                //模拟子线程发送消息给主线程
                Log.i(TAG, "zxglog startHandler: ");
                Message message = new Message();
                message.obj = "我是子线程startHandler给主线程发送的消息";
                message.what = 1;
                mHandler.sendMessage(message);

                //这里接收其他线程发送的消息，模拟主线程给子线程发送消息
                Looper.prepare();
                mHandler1 = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        Log.i(TAG, "1 zxglog handleMessage: msg.what=" + msg.what + "/msg.obj=" + msg.obj);
                    }
                };

                Looper.loop();
            }
        }).start();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
