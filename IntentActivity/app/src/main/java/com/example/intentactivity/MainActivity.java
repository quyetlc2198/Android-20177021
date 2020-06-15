package com.example.intentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tv_name,tv_mssv;
    ArrayList<Model> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceStat
        setContentView(R.layout.activity_main);
        tv_name = findViewById(R.id.tv_name);
        tv_mssv = findViewById(R.id.tv_mssv);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(back.BUNDLE);
        String json = bundle.getString(back.OBJECT);
        Gson gson = new Gson();
        Model student = gson.fromJson(json,Model.class);
        tv_name.setText(student.getName());
        tv_mssv.setText(student.getMssv());

    }
}
