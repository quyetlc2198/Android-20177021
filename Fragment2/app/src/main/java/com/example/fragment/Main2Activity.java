package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
class Main2Activity extends AppCompatActivity implements Fragment_Master.UpdateListener {
    Fragment_Master fragment_master;
    Fragment_Detail fragment_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        fragment_master = new Fragment_Master();
        fragment_detail = new Fragment_Detail();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment_master,fragment_master);
        ft.add(R.id.fragment_detail, fragment_detail);
        ft.commit();
    }



    @Override
    public void UpdateDetail(String selectedItems) {
        fragment_detail.UpdateContent(selectedItems);
    }
}
