package com.example.network;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new HttpAsyncTask().execute("https://goo.gl/eIXu9l");
        Log.d("main", "httpasync실행");
    }

    private static class HttpAsyncTask extends AsyncTask<String, Void, String> {
        OkHttpClient client = new OkHttpClient();

        @Override
        protected String doInBackground(String... params) {
            String result = null;
            String strUrl = params[0];
            List<Weather> weatherList = new ArrayList<>();
            try {

                Request request = new Request.Builder().url(strUrl).build();

                Response response = client.newCall(request).execute();

                JSONArray jsonArray = new JSONArray(response.body().string());
                for(int i =0 ; i < jsonArray.length(); i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String country = jsonObject.getString("country");
                    String weather = jsonObject.getString("weather");
                    String temperature = jsonObject.getString("temperature");
                    Weather w = new Weather(country,weather,temperature);
                    weatherList.add(w);

                }
                Log.d(TAG, "onCreate : " + weatherList.toString());

            } catch (IOException e) {
                e.printStackTrace();
                    } catch (JSONException e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s != null) {
                Log.d(TAG, s);
            }
        }

    }
}
