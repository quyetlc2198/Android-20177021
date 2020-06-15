package com.example.bt1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;

public class CreateActivity extends AppCompatActivity {
    Database database;
    Gson gson = new Gson();
    ListView lsStudent;
    ArrayList<Model> list;
    EditText edname, edemail, edaddress,edbirthday,edid;
    public static final String OBJECT = "object";
    public static final String BUNDLE = "BUNDLE";
    Button btn_update,btn_create;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_item);
        init();
        btn_update.setEnabled(false);
        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                Model student = createStudent();
                String json = gson.toJson(student);
                bundle.putString(OBJECT,json);
                intent.putExtra(BUNDLE , bundle);
                setResult(RESULT_OK , intent);
                finish();
            }
        });
    }

    public void init(){
        btn_update = findViewById(R.id.btn_update);
        btn_create = findViewById(R.id.btn_save);
        edname = findViewById(R.id.usename);
        edbirthday = findViewById(R.id.birthday);
        edemail = findViewById(R.id.email);
        edaddress = findViewById(R.id.born);
        edid = findViewById(R.id.mssv);
    }
    public Model createStudent(){
        int id = Integer.parseInt(edid.getText().toString());
        String name = edname.getText().toString();
        String address = edaddress.getText().toString();
        String born = edbirthday.getText().toString();
        String email = edemail.getText().toString();
        Model student = new Model(name,id,email,address,born);
        return student;
    }
}
