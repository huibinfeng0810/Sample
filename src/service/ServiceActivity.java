package service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import com.huibinfeng0810.Sample.R;

/**
 * Created by huibin on 1/11/14.
 */
public class ServiceActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "ServiceActivity";

    private Button startService, stopService, bindService, unBindService;

    private RemoteService remoteService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        initViews();
    }

    private void initViews() {
        startService = (Button) findViewById(R.id.startService);
        stopService = (Button) findViewById(R.id.stopService);
        bindService = (Button) findViewById(R.id.bindService);
        unBindService = (Button) findViewById(R.id.unBindService);

        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);
        bindService.setOnClickListener(this);
        unBindService.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.startService:
                break;
            case R.id.stopService:
                break;
            case R.id.bindService:
                bindRemoteService();
                break;
            case R.id.unBindService:
                unBindRemoteService();
                break;
        }
    }

    private void bindRemoteService() {
        Intent intent = new Intent(this, RemoteService.class);
        bindService(intent, mServiceConnection, BIND_AUTO_CREATE);

    }

    private void unBindRemoteService() {
        unbindService(mServiceConnection);

    }

    //remote service
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            remoteService = ((RemoteService.RemoteBinder) iBinder).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

}
