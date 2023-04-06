package ro.pub.cs.systems.eim.practicaltest01var05;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MessageBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("TAG_BCAST", intent.getStringExtra("bcast"));
    }
}
