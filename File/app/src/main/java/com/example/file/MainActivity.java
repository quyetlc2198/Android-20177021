package com.example.file;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences abc = getSharedPreferences("Quyet", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = abc.edit();
        editor.putString("key","Quyet");
        editor.commit();

        String name = abc.getString("key","Quyen");
        textView = findViewById(R.id.tv);
        String sdPath = Environment.getExternalStorageDirectory().getAbsolutePath() ;
        textView.setText(sdPath);
    }
}
