package com.hbaoxian.androidaccumulation.ui.activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class imageTextAdapter extends ArrayAdapter {

    private List list;

    public imageTextAdapter(Context context, int resouce, List list) {
        super(context, resouce, list);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);



    }
}
