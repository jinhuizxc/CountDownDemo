package com.example.jh.countdowndemo.way3;

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
import com.example.jh.countdowndemo.way2.TimerTask1Activity;

/**
 * Created by jinhui on 2018/4/1.
 * Email:1004260403@qq.com
 * <p>
 * 方法三: Handler与Message（不用TimerTask）
 */
public class TimerTask2Activity extends AppCompatActivity {

    private int recLen = 11;
    private TextView txtView;

    private Button bt_go;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_timertask);
        txtView = (TextView) findViewById(R.id.txttime);

        Message message = handler.obtainMessage(1);     // Message
        handler.sendMessageDelayed(message, 1000);

        bt_go = findViewById(R.id.bt_go);
        bt_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TimerTask2Activity.this, SecondActivity.class));
            }
        });

    }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    recLen--;
                    txtView.setText("" + recLen);

                    if (recLen > 0) {
                        Message message = handler.obtainMessage(1);
                        handler.sendMessageDelayed(message, 1000);      // send message
                    } else {
                        txtView.setVisibility(View.GONE);
                    }
            }

        }
    };
}
