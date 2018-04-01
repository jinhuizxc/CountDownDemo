package com.example.jh.countdowndemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by jinhui on 2018/4/1.
 * Email:1004260403@qq.com
 */
public class SecondActivity extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 回到第一个界面,因为第一个项目启动模式为：android:launchMode="singleTask"
                startActivity(new Intent(SecondActivity.this, MainActivity.class));
            }
        });
    }
}
