package com.example.mysmsreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {
    private static final String TAG = "SmsReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG,"OnReceive()호출됨.");
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
