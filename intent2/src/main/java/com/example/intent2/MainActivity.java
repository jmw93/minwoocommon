package com.example.intent2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edittext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext = findViewById(R.id.editText);
    }


    public void dialButtonClick(View view) {
        String phoneNumber = edittext.getText().toString();
        dial(phoneNumber);

    }

    private void dial(String phoneNumber){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);

        }

    }
}

