package com.example.volley;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        if ( AppHelper.requestQueue ==null) {
            AppHelper.requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

    }
    public void Onclick(View view) {
        sendRequest();
    }

    public void sendRequest(){
        String url = "https://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt=20120101";
        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        println("응답 ->" +response);
                        processResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        println("에러->" + error.getMessage());
                    }
                }

        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String,String>();
                return params;
            }
        };//포스트방식일떄?
        request.setShouldCache(false);
        AppHelper.requestQueue.add(request);
    }

    public void println(String data ){
     textView.append(data + "\n");

    }

public void processResponse(String response){
        Gson gson = new Gson();
        MovieList movieList = gson.fromJson(response,MovieList.class);

        if(movieList !=null){
            int countMovie = movieList.boxOfficeResult.dailyBoxOfficeList.size();
            println("응답받은 영화 갯수:"+countMovie);

        }
    }

}
// dependencies (gradle) implementation 'com.android.volley:volley:1.1.0'추가