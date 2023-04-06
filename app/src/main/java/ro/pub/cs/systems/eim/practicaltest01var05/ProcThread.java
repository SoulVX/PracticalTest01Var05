package ro.pub.cs.systems.eim.practicaltest01var05;

import android.content.Context;
import android.content.Intent;

public class ProcThread extends Thread{

    private final String[] payload;
    private final Context context;

    public ProcThread(String[] payload, Context context) {
        this.payload = payload;
        this.context = context;
    }

    @Override
    public void run() {
        for(String val : payload) {
            sendMessage(val);
            sleep();
        }
    }

    private void sendMessage(String val) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_BATTERY_LOW);
        intent.putExtra("bcast", val);
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}
