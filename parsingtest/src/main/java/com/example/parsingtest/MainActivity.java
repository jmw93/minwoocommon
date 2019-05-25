package com.example.parsingtest;

import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Trace;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<Tour> tourlist;
    Adapter adapter;
    RecyclerView recyclerView;
    XMLPullParserHandler xmlPullParserHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        adapter = new Adapter();
        xmlPullParserHandler = new XMLPullParserHandler();
        tourlist = new ArrayList<Tour>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        new Thread(new Runnable() {
            @Override
            public void run() {
                tourlist = xmlPullParserHandler.parsing();
                Log.d("jmw93", String.valueOf(tourlist.size()));

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.setItems(tourlist);
                        recyclerView.setAdapter(adapter);
                    }
                });
            }
        }).start();



    }
}