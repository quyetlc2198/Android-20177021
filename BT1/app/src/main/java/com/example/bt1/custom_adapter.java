package com.example.bt1;

import android.content.ContentValues;
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

public class custom_adapter extends ArrayAdapter {
    private Context context;
    private int resource;
    private ArrayList<Model> modelList;

    public custom_adapter(@NonNull Context context, int resource, @NonNull ArrayList<Model> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.modelList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_student,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.tv_id = convertView.findViewById(R.id.tv_id);
            viewHolder.tv_name = convertView.findViewById(R.id.tv_name);
            viewHolder.tv_birthday = convertView.findViewById(R.id.tv_birthday);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Model model = modelList.get(position);
        viewHolder.tv_id.setText((model.getID()) +  "");
        viewHolder.tv_name.setText((model.getName())+"");
        viewHolder.tv_birthday.setText(model.getBirthday());
        return convertView;
    }

    public class ViewHolder{
        TextView tv_id,tv_birthday;
        TextView tv_name;
    }
}
