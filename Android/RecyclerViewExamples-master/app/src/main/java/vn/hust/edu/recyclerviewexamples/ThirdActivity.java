package vn.hust.edu.recyclerviewexamples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import vn.hust.edu.recyclerviewexamples.adapters.EmailItemAdapter;
import vn.hust.edu.recyclerviewexamples.models.EmailItemModel;

public class ThirdActivity extends AppCompatActivity {

    List<EmailItemModel> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        items = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            items.add(new EmailItemModel("Hello World", "Subject subject", "Content content", "12:00 PM"));

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        EmailItemAdapter adapter = new EmailItemAdapter(items);
        recyclerView.setAdapter(adapter);
    }
}
