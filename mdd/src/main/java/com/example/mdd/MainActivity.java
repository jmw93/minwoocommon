package com.example.mdd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linear = findViewById(R.id.linear);
       TextView textView=linear.findViewById(R.id.textView);
        textView.setText("신기한방법");
        TextView textView2 = findViewById(R.id.textView);
        textView2.setText("두번재 방법");
    }
}
