package com.example.volley_read;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    EditText editText;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      button = findViewById(R.id.button);
       textView = findViewById(R.id.textView);
       editText = findViewById(R.id.editText);

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               makeRequest();
           }
       });
        if(requestQueue == null)
       requestQueue = Volley.newRequestQueue(getApplicationContext());
    }
    public void makeRequest(){
        String url = editText.getText().toString();

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                println("응답:"+response);

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        println("에러:" + error.getMessage());
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }

        };
    request.setShouldCache(false);
    requestQueue.add(request);

    }
    public void println(String data){
        textView.append(data+"\n");
    }


}
