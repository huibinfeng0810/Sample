package service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.huibinfeng0810.Sample.R;

/**
 * Created by huibin on 1/11/14.
 */
public class LocalService extends Service {
    private static final String TAG = "LocalService";


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "-------------OnCreate");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d(TAG, "-------------OnStart");
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "-------------OnDestory");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
