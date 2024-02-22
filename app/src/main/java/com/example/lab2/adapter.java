package com.example.lab2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class adapter extends BaseAdapter {
    public void setData(ArrayList<Contact> data){this.data=data;}
    //nguồn dữ liệu cho adapter
    private String s;
    private  ArrayList<Contact> data;
    private ArrayList<Contact> databackup;
    //ngữ cảnh của ứng dụng
    private Activity context;
    //đối tượng để phân tích layout
    private LayoutInflater inflater;
    public adapter(ArrayList<Contact>data, Activity activity){
        this.data=data;
        this.context=activity;
        this.inflater=(LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return data.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v=view;
        if(v==null) v=inflater.inflate(R.layout.layout,null);
        CheckBox checkBox=v.findViewById(R.id.checkBox);
        if(data.get(i).isStatus()==true) {
            checkBox.setChecked(true);
        }
        TextView tvname=v.findViewById(R.id.tv_name);
        tvname.setText(data.get(i).getName());
        TextView tvphone=v.findViewById(R.id.tv_phone);
        tvphone.setText(data.get(i).getPhone());
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.get(i).setStatus(checkBox.isChecked());
            }
        });
        return v;

    }
}
