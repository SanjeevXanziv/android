package com.nami.dharmendra_profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.nami.dharmendra_profile.Configuration.DbHelper;
import com.nami.dharmendra_profile.Model.StudentModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        // Dharmendra girlfriend list
        
        List<StudentModel> studentModelList = new DbHelper(this).getAllStudents();
        List<String> studentNames = new ArrayList<>();

        for (StudentModel studentModel : studentModelList) {
            studentNames.add(studentModel.getName());
        }

        ListView listView = findViewById(R.id.girlFriendList); // listview resource init
        // ArrayAdapter variable init.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout .simple_list_item_1, studentNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, "Item " + position + " " + view.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}