package service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by huibin on 1/11/14.
 */


public class RemoteService extends Service {
    /**
     * life cycle  onCreate -> onBind  -> onUnBind -> onDestory
     * onStartCommand not execute
     */


    private static final String TAG = "RemoteService";
    private RemoteBinder mBinder = new RemoteBinder();


    public class RemoteBinder extends Binder {
        public RemoteService getService() {
            return RemoteService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "----------------onBind");
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "----------------onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "----------------onStart");

        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "----------------onDestory");
    }


    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "----------------onUnbind");
        return super.onUnbind(intent);
    }
}
