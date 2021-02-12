package com.nami.dharmendra_profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        // Dharmendra girlfriend list
        
        List<String> dharmendraGfList = Arrays.asList("Rita", "Binita", "Basanti");

        ListView listView = findViewById(R.id.girlFriendList); // listview resource init
        // ArrayAdapter variable init.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout .simple_list_item_1, dharmendraGfList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, "Item " + position + " " + view.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}