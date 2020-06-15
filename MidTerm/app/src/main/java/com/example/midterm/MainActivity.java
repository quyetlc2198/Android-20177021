package com.example.midterm;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView1;
    Button btn1;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.tv1);
        btn1 = findViewById(R.id.btn1);
        textView1.setText("Xin Chafo");
        textView1.setTextColor(Color.BLUE);
        textView1.setTypeface(null , Typeface.BOLD);
        btn1.setText("ahihi");


    }
}
