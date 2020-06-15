package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Fragment_2 blueFragment ;
    Fragment_1 redFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_add_red).setOnClickListener(this);
        findViewById(R.id.btn_add_blue).setOnClickListener(this);
        findViewById(R.id.btn_replace).setOnClickListener(this);
        findViewById(R.id.btn_remove).setOnClickListener(this);
        redFragment = new Fragment_1();
        blueFragment = Fragment_2.newInstance("val1", "val2");
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_add_red){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.layout_fragment, redFragment);
            ft.commit();
        } else if (id == R.id.btn_add_blue){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.layout_fragment, blueFragment);
            ft.commit();
        } else if (id == R.id.btn_replace){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.layout_fragment, blueFragment);
            ft.commit();
        } else if (id == R.id.btn_remove){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.remove(blueFragment);
            ft.commit();
        }
    }
}
