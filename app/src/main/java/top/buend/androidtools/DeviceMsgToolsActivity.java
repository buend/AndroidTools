package top.buend.androidtools;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

import top.buend.toolslibrary.DeviceMsgTools;
import top.buend.toolslibrary.Tools;

public class DeviceMsgToolsActivity extends AppCompatActivity {

    private TextView mac;
    private TextView imei;
    private TextView androidId;
    private TextView sn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_msg_tools);

        mac = (TextView) findViewById(R.id.mac);
        imei = (TextView) findViewById(R.id.imei);
        androidId = (TextView) findViewById(R.id.android_id);
        sn = (TextView) findViewById(R.id.sn);

        initData();
    }

    private void initData() {
        mac.setText(DeviceMsgTools.getMac());
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            imei.setText(DeviceMsgTools.getIMEI());
        }

        androidId.setText(DeviceMsgTools.getAndroidId());
        sn.setText(DeviceMsgTools.getSN());
    }
}
