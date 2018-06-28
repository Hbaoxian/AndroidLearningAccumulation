package com.hbaoxian.androidaccumulation.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.hbaoxian.androidaccumulation.R;

import java.util.ArrayList;
import java.util.List;

public class ListImageActivity extends AppCompatActivity {


    private ListView listView;

    private List<Object> dataArray = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_image_activity);

        listView = (ListView) findViewById(R.id.content_list);




    }


    @Override
    protected void onDestroy() {
        super.onDestroy();




    }
}
