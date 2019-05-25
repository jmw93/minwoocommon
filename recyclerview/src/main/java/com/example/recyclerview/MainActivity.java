package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        PersonAdapter adapter = new PersonAdapter();
//        어댑터에 데이터 넣기
        adapter.addItem(new Person("김민수","010-000-0000"));
        adapter.addItem(new Person("김민수","010-000-0000"));
        adapter.addItem(new Person("김민수","010-000-0000"));
        adapter.addItem(new Person("김민수","010-000-0000"));
        adapter.addItem(new Person("김민수","010-000-0000"));

      recyclerView.setAdapter(adapter);


    }
}
