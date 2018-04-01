package com.example.jh.countdowndemo.way2;

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
import com.example.jh.countdowndemo.way1.TimerTaskActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by jinhui on 2018/4/1.
 * Email:1004260403@qq.com
 *
 * 方法二: TimerTask与Handler（不用Timer的改进型）
 */
public class TimerTask1Activity extends AppCompatActivity {

    private int recLen = 11;
    private TextView txtView;
    private Button bt_go;

    Timer timer = new Timer();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_timertask);
        txtView = (TextView) findViewById(R.id.txttime);

        timer.schedule(task, 1000, 1000);       // timeTask

        bt_go = findViewById(R.id.bt_go);
        bt_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TimerTask1Activity.this, SecondActivity.class));
            }
        });
    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            recLen--;
            Message message = new Message();
            message.what = 1;
            handler.sendMessage(message);
        }
    };

    // 创建内部handler类
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case 1:
                    txtView.setText("" + recLen);
                    if (recLen < 0) {
                        timer.cancel();
                        txtView.setVisibility(View.GONE);
                    }
            }

        }
    };

}
