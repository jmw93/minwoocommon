package com.example.viewholderexam;


import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        PersonAdapter adapter = new PersonAdapter(new PersonAdapter.OnPersonClickListener() {
            @Override
            public void onPersonClicked(Person model) {
                Toast.makeText(MainActivity.this, model.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("홍길동", "10"));
        people.add(new Person("홍길동", "10"));
        people.add(new Person("홍길동", "10"));
        people.add(new Person("홍길동", "10"));

        adapter.setItems(people);

    }


}