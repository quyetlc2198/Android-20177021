package com.example.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textclassifier.TextClassification;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Detail extends Fragment {
    TextView textView;
    public Fragment_Detail() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__detail, container, false);
        textView = view.findViewById(R.id.text_view);

        return view ;
    }

    public void UpdateContent(String itemsOnClick) {
        textView.setText(itemsOnClick);
    }
}
