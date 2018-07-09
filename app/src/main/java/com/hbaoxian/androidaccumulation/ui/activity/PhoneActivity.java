package com.hbaoxian.androidaccumulation.ui.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hbaoxian.androidaccumulation.R;

public class PhoneActivity extends AppCompatActivity {

    private  CustonPhoneStatesListener phoneListener;
   private   TextView phoneBtn;
   private   TextView smsBtn;
   private final int REQUEST_CALL_PHONE = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_use_activity);

        phoneBtn = (TextView) findViewById(R.id.call_phone_btn);
        smsBtn = (TextView)findViewById(R.id.send_sms_btn);


        phoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callStudentPhone("10086");
            }
        });



        smsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    /**
     * 电话拨打功能
     *
     *
     * 需要增加      <uses-permission android:name="android.permission.CALL_PHONE" /> 权限配置
     *
     * */
    private void callStudentPhone(String phone) {
        if (ContextCompat.checkSelfPermission(PhoneActivity.this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            //判断此时是否可以向用户说明为什么需要申请权限
            //说明完之后可以再来调用requestPermissions进行权限申请
            if (ActivityCompat.shouldShowRequestPermissionRationale(PhoneActivity.this,
                    Manifest.permission.CALL_PHONE)) {
                Toast.makeText(PhoneActivity.this, "我就是需要权限", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(PhoneActivity.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PHONE);

            } else {
                ActivityCompat.requestPermissions(PhoneActivity.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PHONE);
            }
        } else {
            callPhone("10086");

        }
    }

    private void callPhone(String phone) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + phone);
        intent.setData(data);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            return;
        }
        startActivity(intent);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_CALL_PHONE:
                for (String permission : permissions) {

                }
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    callPhone("10086");
                } else {
                    Toast.makeText(this, "拒绝授权", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    /***
     *
     * 电话注册监听
     *
     * */
    private void registerPhoneStateListener() {

        if (phoneListener == null) {
            phoneListener = new CustonPhoneStatesListener(getBaseContext());
            TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            if (telephonyManager != null) {
                telephonyManager.listen(phoneListener, PhoneStateListener.LISTEN_CALL_STATE);
            }
            phoneListener.callBack = new PhoneCallBack() {
                @Override
                public void callBack(int status) {

                }
            };

        }
        phoneListener.setCall_IDLE(0);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     *
     * 电话状态监听
     * */

    private class CustonPhoneStatesListener extends PhoneStateListener {

        private Context mContext;

        private int call_IDLE = 0;

        public void setCall_IDLE(int call_IDLE) {
            this.call_IDLE = call_IDLE;
        }

        public PhoneCallBack callBack;


        public  CustonPhoneStatesListener(Context context) {
            mContext = context;
        }

        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            super.onCallStateChanged(state, incomingNumber);

            switch (state) {
                case TelephonyManager.CALL_STATE_IDLE:      // 电话挂断
                    call_IDLE++;
                    if (call_IDLE == 2) {
                        if (callBack != null) {
                            callBack.callBack(1);
                        }
                    }
                    break;
                case TelephonyManager.CALL_STATE_RINGING:   // 电话响铃
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:   // 来电接通 或者 去电  但是没法区分
                    break;
            }
        }
    }


    public interface PhoneCallBack {

        void callBack(int status);
    }


}
