package com.example.gmail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Toast.makeText(this, "hello Quyet", Toast.LENGTH_LONG).show();
    }

    public void  initView(){
        RecyclerView recyclerView  = (RecyclerView)findViewById(R.id.recyclerHero);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this ,LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<Hero> arrayList = new ArrayList<>();
        arrayList.add(new Hero("thor",R.drawable.thumb26));
        arrayList.add(new Hero("iron",R.drawable.thumb24));
        arrayList.add(new Hero("super",R.drawable.thumb23));
        arrayList.add(new Hero("hulk",R.drawable.thumb22));
        arrayList.add(new Hero("batman",R.drawable.thumb20));
    }
}
