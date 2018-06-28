package com.hbaoxian.androidaccumulation.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.hbaoxian.androidaccumulation.R;
import com.nostra13.universalimageloader.core.ImageLoader;

public class ShowImageActivity extends AppCompatActivity {



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_image_acvity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ImageView imageView = (ImageView)findViewById(R.id.show_image);
        setSupportActionBar(toolbar);
        ImageLoader.getInstance().displayImage("http://img02.tooopen.com/images/20150507/tooopen_sy_122395947985.jpg", imageView);

    }

    public void setSupportActionBar(Toolbar toolbar) {


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();



    }
}
