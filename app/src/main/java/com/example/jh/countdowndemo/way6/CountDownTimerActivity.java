package com.example.jh.countdowndemo.way6;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jh.countdowndemo.R;
import com.example.jh.countdowndemo.SecondActivity;
import com.example.jh.countdowndemo.way4.TimerTask3Activity;

/**
 * Created by jinhui on 2018/4/2.
 * Email:1004260403@qq.com
 * <p>
 * Android基础之——CountDownTimer类，轻松实现倒计时功能:
 * https://www.cnblogs.com/yfceshi/p/6853746.html
 */
public class CountDownTimerActivity extends AppCompatActivity {

    private TextView tv;
    private Button bt_go;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_timertask);

        tv = (TextView) findViewById(R.id.txttime);

        bt_go = findViewById(R.id.bt_go);
        bt_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CountDownTimerActivity.this, SecondActivity.class));
            }
        });


        /** 倒计时60秒，一次1秒 */
        CountDownTimer timer = new CountDownTimer(60 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tv.setText("还剩" + millisUntilFinished / 1000 + "秒");
            }

            @Override
            public void onFinish() {
                tv.setText("倒计时完毕了");
            }
        }.start();

    }
}
