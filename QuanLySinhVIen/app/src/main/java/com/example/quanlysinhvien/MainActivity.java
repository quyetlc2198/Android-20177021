package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Database database;
    Gson gson = new Gson();
    public static final String OBJECT = "object";
    ListView listView;
    ArrayList<Item_Student> list_student;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = new Database(this);
        list_student = database.getAllStudent();
        list_student.add(new Item_Student("20177021","Quyet"));
        list_student.add(new Item_Student("20177021","Quyet"));
        list_student.add(new Item_Student("20177021","Quyet"));
        list_student.add(new Item_Student("20177021","Quyet"));
        list_student.add(new Item_Student("20177021","Quyet"));
        listView = findViewById(R.id.list_item);
        adapter = new CustomAdapter(this , R.layout.item_row , list_student);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item_Student student = list_student.get(position);
                String json = gson.toJson(student);
                Intent intent = new Intent(MainActivity.this , EditActivity.class);
                intent.putExtra(OBJECT,json);
                startActivity(intent);
            }
        });
    }
}
