package ro.pub.cs.systems.eim.practicaltest01var05;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Arrays;

public class PracticalTest01Var05Service extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String[] sablonSplit = intent.getStringExtra("sablon").split(",");
        ProcThread procThread = new ProcThread(sablonSplit, getApplicationContext());
        procThread.start();
        return Service.START_REDELIVER_INTENT;
    }
}
