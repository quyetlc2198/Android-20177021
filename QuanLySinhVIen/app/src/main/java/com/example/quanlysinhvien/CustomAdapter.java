package com.example.quanlysinhvien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter<getView> extends ArrayAdapter {
    private Context context;
    private int resource;
    private ArrayList<Item_Student> modelList;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Item_Student> objects) {
        super(context, resource, objects);
        this.context= context;
        this.resource = resource;
        this.modelList = objects;
    }

    @NonNull
    @Override


        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewholder;
        if(convertView == null){
            viewholder = new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.item_row,parent,false);
            viewholder.tv_mssv = convertView.findViewById(R.id.tv_mssv);
            viewholder.tv_name = convertView.findViewById(R.id.tv_name);
            convertView.setTag(viewholder);
        }else{
            viewholder = (ViewHolder) convertView.getTag();
        }

        Item_Student student = modelList.get(position);
        viewholder.tv_mssv.setText(student.getMSSV());
        viewholder.tv_name.setText(student.getName());
        return convertView;

    }

    public class ViewHolder{
        TextView tv_mssv , tv_name;
    }
}
