package com.example.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class menuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name","mike");

                setResult(Activity.RESULT_OK,intent);// 메뉴xml을 실행한 메인xml으로 넘겨주면서 실행시킴
                finish();
            }
        });
    }


}
/*finish하면 처음 MainActivity가 보이게된다. 왜냐면 스택구조이기 때문에.
putExtra name,mike 는 키-값 구조임*/