package com.example.jh.countdowndemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.jh.countdowndemo.way1.TimerTaskActivity;
import com.example.jh.countdowndemo.way2.TimerTask1Activity;
import com.example.jh.countdowndemo.way3.TimerTask2Activity;
import com.example.jh.countdowndemo.way4.TimerTask3Activity;
import com.example.jh.countdowndemo.way6.CountDownTimerActivity;

/**
 * Android 常见三种倒计时的demo，整理出来！
 * 参考链接：http://blog.sina.com.cn/s/blog_46798aa80102v26f.html
 *
 * 法五



 Handler与Runnable（最简单型）



 计时与倒计时

 方法1，方法2和方法3，都是倒计时

 方法4，方法5，都是计时

 计时和倒计时，都可使用上述方法实现（代码稍加改动）

 UI线程比较

 方法1，方法2和方法3，都是在UI线程实现的计时；

 方法4和方法5，是另开Runnable线程实现计时

 实现方式比较

 方法1，采用的是Java实现，即Timer和TimerTask方式；

 其它四种方法，都采用了Handler消息处理

 推荐使用

 如果对UI线程交互要求不很高，可以选择方法2和方法3

 如果考虑到UI线程阻塞，严重影响到用户体验，推荐使用方法4，另起线程单独用于计时和其它的逻辑处理

 方法5，综合了前几种方法的优点，是最简的
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1,button2, button3, button4, button5, button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                startActivity(new Intent(this,TimerTaskActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(this,TimerTask1Activity.class));
                break;
            case R.id.button3:
                startActivity(new Intent(this,TimerTask2Activity.class));
                break;
            case R.id.button4:
                startActivity(new Intent(this,TimerTask3Activity.class));
                break;
            case R.id.button5:
                Toast.makeText(this, "无", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button6:
                startActivity(new Intent(this,CountDownTimerActivity.class));
                break;
        }
    }
}
