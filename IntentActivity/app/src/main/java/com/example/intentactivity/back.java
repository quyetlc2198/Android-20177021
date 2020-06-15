package com.example.intentactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

public class back extends AppCompatActivity {
    Button back;
    final Gson gson = new Gson();
    EditText edt_name, edt_mssv;
    public final static String OBJECT = "object";
    public final static String BUNDLE = "BUNDLE";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_activity);
        back = findViewById(R.id.btn_send);
        edt_name = findViewById(R.id.edt_name);
        edt_mssv = findViewById(R.id.edt_mssv);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Model student = new Model();
                student.setName(edt_name.getText().toString());
                student.setMssv(edt_mssv.getText().toString());
                final String json = gson.toJson(student);
                byBundle(json);
            }
        });
    }


    public void byBundle(String json){
        Intent intent = new Intent(back.this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(OBJECT,json);
        intent.putExtra(BUNDLE,bundle);
        startActivity(intent);
    }
}
