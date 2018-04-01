package com.example.jh.countdowndemo.way1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jh.countdowndemo.R;
import com.example.jh.countdowndemo.SecondActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by jinhui on 2018/4/1.
 * Email:1004260403@qq.com
 *
 *  方法一: Timer与TimerTask（Java实现）
 */
public class TimerTaskActivity extends AppCompatActivity {

    private int recLen = 59;
    private TextView txtView;
    private Button bt_go;

    Timer timer = new Timer();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timertask);
        txtView = (TextView)findViewById(R.id.txttime);
        bt_go = findViewById(R.id.bt_go);

        timer.schedule(task, 1000, 1000);       // timeTask


        bt_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TimerTaskActivity.this, SecondActivity.class));
            }
        });
    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            // UI thread
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    recLen--;
                    txtView.setText(" " + recLen);
                    if (recLen < 0){
                        timer.cancel();
//                        txtView.setVisibility(View.GONE);
                    }
                }
            });
        }
    };


}
