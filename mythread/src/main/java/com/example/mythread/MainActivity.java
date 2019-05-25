package com.example.mythread;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView ;
   Handler handler2 = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView =findViewById(R.id.textView);
    }

    public void button1onclick(View view) {
        new Thread(new Runnable() {
            int value = 0;
            boolean running = false;
            @Override
            public void run() {
                running = true;
                while(running) {
                    value +=1;

                    handler2.post(new Runnable() {

                        @Override
                        public void run() {
                            textView.setText("현재값:"+ value);
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }



            }
        }).start();
    }

 }

//    class ValueHandler extends Handler{
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            Bundle bundle = msg.getData();
//         int value = bundle.getInt("Value");
//            textView.setText("현재값:"+ value);
//        }
//    }



