package com.example.toolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar1 = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);
//        툴바 상단좌측 Toolbar 글씨 없애기
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ImageButton mailbutton = (ImageButton)findViewById(R.id.bar_mail);
        mailbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"메일버튼클릭",Toast.LENGTH_LONG).show();
            }
        });
    }
}
