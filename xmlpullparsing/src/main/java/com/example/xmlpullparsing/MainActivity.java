package com.example.xmlpullparsing;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Employee> employees;
    XMLPullParserHandler parser;
    InputStream is;
    EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter =new EmployeeAdapter();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        employees = new ArrayList<>();
         parser = new XMLPullParserHandler();

        try {
        AssetManager am = getResources().getAssets();
         is =null;
        is= am.open("employee.xml");
        new Thread(new Runnable() {
            @Override
            public void run() {
                employees = parser.parse(is);
                adapter.addItems(employees);
            }
        }).start();


            LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);





        }catch (IOException e1) {
                e1.printStackTrace();
            }


    }
}
