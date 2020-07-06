package com.example.fragment_test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_change;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_change = findViewById(R.id.btn_change);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = null;
        fragment = (FragmentA) new FragmentA();
        fragmentTransaction.add(R.id.frame,fragment);
        fragmentTransaction.commit();
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentA fragmentA = (FragmentA) getFragmentManager().findFragmentById(R.id.frag_A);

            }
        });
    }

    public void AddFragment(View view){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = null;

        switch (view.getId()){
            case R.id.btn_A: fragment = new FragmentA();
                Toast.makeText(this, "A", Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_B: fragment = new FragmentB();
                Toast.makeText(this, "B", Toast.LENGTH_LONG).show();
                break;
        }

        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }


}
