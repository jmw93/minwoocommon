package com.example.listviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Weather> data = new ArrayList<Weather>();
        data.add(new Weather("수원","25도","맑음"));
        data.add(new Weather("수원","25도","맑음"));
        data.add(new Weather("수원","25도","맑음"));
        data.add(new Weather("수원","25도","맑음"));
        data.add(new Weather("수원","25도","맑음"));
        data.add(new Weather("수원","25도","맑음"));
        data.add(new Weather("수원","25도","맑음"));
        data.add(new Weather("수원","25도","맑음"));



            Myfirstadapter adapter = new Myfirstadapter(data);
            ListView listview =findViewById(R.id.listview);
            listview.setAdapter(adapter);
        }



    }

