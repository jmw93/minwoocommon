package com.example.myservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       editText=(EditText)findViewById(R.id.editText);

       Button button = (Button)findViewById(R.id.button);
       button.setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View v) {
               //서비스 실행시키는 코드
              String name = editText.getText().toString();

              Intent intent = new Intent(getApplicationContext(),MyService.class);
              intent.putExtra("command","show");
              intent.putExtra("name",name);
              startService(intent);
           }
       });
    }
}
