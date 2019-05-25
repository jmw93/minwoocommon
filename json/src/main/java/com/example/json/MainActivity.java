package com.example.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.android.volley.Request.Method.*;

public class MainActivity extends AppCompatActivity {
    TextView textView_result;
    RequestQueue mQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_pase = findViewById(R.id.button_parse);
        textView_result = findViewById(R.id.textView_result);
        mQueue = Volley.newRequestQueue(this);
        button_pase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            jsonParse();
            }
        });

        }
    private void jsonParse() {
        String url = "https://api.myjson.com/bins/kp9wz";
        JsonObjectRequest request = new JsonObjectRequest(Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("employees");
                    for(int i =0; i<jsonArray.length(); i++) {
                        JSONObject employee = jsonArray.getJSONObject(i);

                        String firstName = employee.getString("firstname");
                        int age = employee.getInt("age");
                        String mail = employee.getString("mail");
                        textView_result.append(firstName + ", " + String.valueOf(age) + ", "+mail + "\n\n");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
    mQueue.add(request);
    }

}
