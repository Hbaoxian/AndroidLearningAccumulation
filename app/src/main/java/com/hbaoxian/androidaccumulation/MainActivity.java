package com.hbaoxian.androidaccumulation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hbaoxian.androidaccumulation.config.AppConfig;
import com.hbaoxian.androidaccumulation.ui.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private ListView tableView;
    private List<Map<String, String>> dataArray = new ArrayList<>();

    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataArray.addAll(AppConfig.getActivityList());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tableView = (ListView)findViewById(R.id.main_activity_table_view);


        adapter = new MainAdapter(MainActivity.this, R.layout.main_table_cell_view , dataArray);
        tableView.setAdapter(adapter);

        tableView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Map<String, String> map = dataArray.get(i);

                Class newClass = null;
                try {
                     newClass = Class.forName(map.get("target").toString());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(getBaseContext(), newClass);
                startActivity(intent);
            }
        });






        AppConfig.configImageLoader(getBaseContext());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
