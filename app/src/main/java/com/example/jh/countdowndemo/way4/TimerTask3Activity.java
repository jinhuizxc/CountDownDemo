package com.example.jh.countdowndemo.way4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jh.countdowndemo.R;
import com.example.jh.countdowndemo.SecondActivity;
import com.example.jh.countdowndemo.way3.TimerTask2Activity;

/**
 * Created by jinhui on 2018/4/2.
 * Email:1004260403@qq.com
 */
public class TimerTask3Activity extends AppCompatActivity {

    private int recLen = 11;
    private TextView txtView;
    private Button bt_go;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_timertask);
        txtView = (TextView) findViewById(R.id.txttime);

        new Thread(new MyThread()).start();         // start thread

        bt_go = findViewById(R.id.bt_go);
        bt_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TimerTask3Activity.this, SecondActivity.class));
            }
        });

    }

    public class MyThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);     // sleep 1000ms
                    Message message = new Message();
                    message.what = 1;
                    handler.sendMessage(message);
                } catch (Exception e) {
                }
            }
        }
    }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    recLen--;
                    txtView.setText("" + recLen);
            }
        }
    };

}
