package com.example.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Master extends Fragment {

    List<String> items;



    public Fragment_Master() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment__master, container, false);

        items = new ArrayList<>();
        for(int i =0; i < 30; i++){
            items.add("Quyet" + i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1, items);

        ListView listView= view.findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = items.get((int) id);
//                Main2Activity main2Activity = (Main2Activity) getActivity();
//                main2Activity.Update(item);

                UpdateListener updateListener = (UpdateListener)getActivity();
                updateListener.UpdateDetail(item);
            }
        });
        return view;
    }

    public interface UpdateListener{
        void UpdateDetail(String selectedItems);
    }
}
