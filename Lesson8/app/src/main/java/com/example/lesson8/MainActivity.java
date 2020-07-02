package com.example.lesson8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("DucQuyet");
        actionBar.setSubtitle("quyet");
        actionBar.setIcon(R.drawable.ic_1);
        actionBar.setDisplayShowCustomEnabled(true);
    }
    //set menu actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id  = item.getItemId();
        if(id == R.id.ic_2){
            textView.setText("Quyet");
            return true;
        }
        return false;
    }
}
