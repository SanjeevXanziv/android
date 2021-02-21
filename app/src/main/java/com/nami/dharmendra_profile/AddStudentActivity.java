package com.nami.dharmendra_profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.nami.dharmendra_profile.Configuration.DbHelper;
import com.nami.dharmendra_profile.Model.StudentModel;

import java.util.List;

public class AddStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
    }

    public void addStudentDb(View view) {
        EditText editText = (EditText) findViewById(R.id.addUserText);
        String name = editText.getText().toString();

        DbHelper dbHandler = new DbHelper(this);

        StudentModel studentModel = new StudentModel();
        studentModel.setName(name);

        dbHandler.addUser(studentModel);

        List<StudentModel> studentModelList = dbHandler.getAllStudents();

        for (StudentModel model : studentModelList) {
            String log = "Id: " + model.getId() + " ,Name: " + model.getName();

            Log.d("User Data: ", log);
        }
    }
}