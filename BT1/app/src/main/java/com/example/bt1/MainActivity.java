package com.example.bt1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;


public class MainActivity<thecoffeehouse> extends AppCompatActivity {
    Database database;
    Button btn_delete,btn_update1,btn_create;
    Gson gson = new Gson();
    Dialog dialog;
    EditText edt_search,edt_search_ID;
    ListView lsStudent;
    ArrayList<Model> list;
    custom_adapter adapter;
    public static final String OBJECT = "object";
    public static final String BUNDLE = "BUNDLE";
    public static final int REQUEST_CODE = 111;
    public static final int REQUEST_CODE1 = 222;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // make database empty
        database = new Database(this);
        lsStudent = findViewById(R.id.lv);
        list = database.getAllStudent();
        btn_create= findViewById(R.id.btn_creat);
        list_view();
        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(MainActivity.this , CreateActivity.class);
                startActivityForResult(intent2,REQUEST_CODE1);
            }
        });


        lsStudent.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long id) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog);
                btn_delete = dialog.findViewById(R.id.btn_delete);
                btn_update1 = dialog.findViewById(R.id.btn_update1);

                dialog.show();
                final Model student = list.get(position);
                btn_delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        database.delete(student);
                        list_view();
                    }
                });
                btn_update1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Intent intent2 = new Intent(MainActivity.this , EditActivity.class);
                        Bundle bundle = new Bundle();
                        String json = gson.toJson(student);
                        bundle.putString(OBJECT,json);
                        intent2.putExtra(BUNDLE , bundle);
                        startActivityForResult(intent2,REQUEST_CODE);
                    }
                });
                return false;
            }
        });

        edt_search = findViewById(R.id.edt_search);
        edt_search_ID = findViewById(R.id.edt_search_ID);
        edt_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() > 1){
                    list_view2(s.toString());
                }else{
                    list_view();
                }

            }
        });
        edt_search_ID.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() > 1){
                    list_view3(s.toString());
                }else{
                    list_view();
                }
            }
        });
    }
    public void list_view(){
        list = database.getAllStudent();
        custom_adapter adapter =new custom_adapter(this, R.layout.item_student,list);
        lsStudent.setAdapter(adapter);
    }

    public void list_view3(String s){
        list = filter1(s);
        custom_adapter adapter =new custom_adapter(this, R.layout.item_student,list);
        lsStudent.setAdapter(adapter);
    }
    public void list_view2(String s){
        list = filter(s);
        custom_adapter adapter =new custom_adapter(this, R.layout.item_student,list);
        lsStudent.setAdapter(adapter);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 111){
            String json = data.getBundleExtra(BUNDLE).getString(OBJECT);
            Model student = gson.fromJson(json,Model.class);
            database.UpdateStudent(student);
            Toast.makeText(MainActivity.this,"update sucess",Toast.LENGTH_SHORT).show();
            list_view();
        }else{
            String json = data.getBundleExtra(BUNDLE).getString(OBJECT);
            if(json.contains("fail")){
                list_view();
            }else{
                Model student = gson.fromJson(json,Model.class);
                String test = "";
                for(int i =0; i < list.size();i++){
                    if(student.getID() == list.get(i).getID()){
                        test = "AAA";
                    }
                }
                if(test.contains("AA")){
                    Toast.makeText(MainActivity.this,"Trùng ID", Toast.LENGTH_SHORT).show();
                }else{
                    database.add(student);
                    Toast.makeText(MainActivity.this,"sucess new student",Toast.LENGTH_SHORT).show();
                    list_view();
                }

            }

        }

    }
    private ArrayList<Model> filter(String s) {
        ArrayList<Model> filterList = new ArrayList<>();
        for(Model item : list) {
            if (item.getName().toLowerCase().contains(s.toLowerCase())) {
                filterList.add(item);
            }
        }
        return filterList;
    }
    private ArrayList<Model> filter1(String s) {
        ArrayList<Model> filterList = new ArrayList<>();
        for(Model item : list) {
            if (String.valueOf(item.getID()).contains(s) ) {
                filterList.add(item);
            }
        }
        return filterList;
    }
    public void filtered(ArrayList<Model> filterList){
        list = filterList;
        adapter.notifyDataSetChanged();
    }

}
