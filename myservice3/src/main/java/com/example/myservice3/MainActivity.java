package com.example.myservice3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
//        Intent passedIntent = getIntent();
//        processCommand(passedIntent); 원래 메인이 처음시작되면 oncreate부터 시작되니까 여기서  받을수도 있지만,
//        이렇게하게되면 처음에 null,null이뜸
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        processCommand(intent);

    }

    private void processCommand(Intent intent){

        if(intent!=null){
            String command = intent.getStringExtra("command");
            String name = intent.getStringExtra("name");
            Toast.makeText(this,"서비스로부터 전달받은 데이터:"+
                    command+","+name,Toast.LENGTH_LONG).show();
        }
    }
}
