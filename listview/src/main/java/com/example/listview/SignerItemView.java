package com.example.listview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SignerItemView extends LinearLayout {
    TextView textView_name;
    TextView textView_phone;

    public SignerItemView(Context context) {
        super(context);
        init(context);

    }

    public SignerItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_sub,this,true);

        textView_name = findViewById(R.id.textView_name);
        textView_phone = findViewById(R.id.textView_phone);
    }

    public void setName(String name){
        textView_name.setText(name);
    }

    public void setMobile(String mobile){
        textView_phone.setText(mobile);
    }


}
