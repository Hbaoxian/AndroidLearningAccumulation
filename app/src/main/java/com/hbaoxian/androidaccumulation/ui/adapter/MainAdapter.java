package com.hbaoxian.androidaccumulation.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.hbaoxian.androidaccumulation.R;

import java.util.List;

public class MainAdapter extends ArrayAdapter {

    int resuceId ;
    private  List dataList;

    public  MainAdapter(Context context, int resousce, List list) {
        super(context,resousce, list);
        resuceId = resousce;
        dataList = list;

    }


    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        if (convertView == null) {
            convertView =  LayoutInflater.from(getContext()).inflate(R.layout.main_table_cell_view, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.cell_title);
        Object object = dataList.get(position);

        textView.setText(object.toString());
        return convertView;
    }
}
