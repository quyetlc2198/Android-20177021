package com.example.example1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Items> items;
    EditText editText;
    private EmailAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items = new ArrayList<>();
        for(int i =0; i<15;i++){
            items.add(new Items("Hello World "+ i, "Subject subject", "Content content", "12:00 PM"));
        }
        RecyclerView recyclerView =findViewById(R.id.recycler_view_item);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        final EmailAdapter adapter = new EmailAdapter(items);
        recyclerView.setAdapter(adapter);
        editText = findViewById(R.id.search);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                adapter.filtered(filter(s.toString()));
                filter(s.toString());
            }
        });

        Button btn;
        btn = findViewById(R.id.btn_favor);
        findViewById(R.id.btn_favor).requestFocus();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Items> filterList2 = new ArrayList<>();
                for(Items item: items){
                    if (item.is_favourite() == true){
                        filterList2.add(item);
                    }
                }
                adapter.filtered(filterList2);
            }
        });
    }

    private ArrayList<Items> filter(String toString) {
        ArrayList<Items> filterList = new ArrayList<>();
        for(Items item : items) {
            if (item.getName().toLowerCase().contains(toString.toLowerCase())) {
                filterList.add(item);
            }
        }
        return filterList;
    }



}
