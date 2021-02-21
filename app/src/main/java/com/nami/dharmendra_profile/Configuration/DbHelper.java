package com.nami.dharmendra_profile.Configuration;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.nami.dharmendra_profile.Model.StudentModel;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    public static String DBNAME = "nami_db";
    public static int VERSION = 1;
    public static String STUDENTINFO = "student_info";
    public static String PK = "id";
    public static String KEY_NAME = "name";

    public DbHelper(Context context) {
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE_QUERY = "CREATE TABLE " + STUDENTINFO + "("
                + PK + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT)";
        db.execSQL(CREATE_USER_TABLE_QUERY);  //executes the DDL command
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * id, name
     * INSERT INTO student_info(name, address, phnumber) VALUES ("Jyoti");
     * @param studentModel
     */
    public void addUser(StudentModel studentModel) {
        SQLiteDatabase db = this.getWritableDatabase(); // initialize

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, studentModel.getName()); //"name", "<value>"

        db.insert(STUDENTINFO, null,values); // db insert

        db.close(); //connection close
    }

    public List<StudentModel> getAllStudents() {
        SQLiteDatabase db = this.getWritableDatabase();

        List<StudentModel> studentModelList = new ArrayList<>();

        String query = "SELECT * FROM " + STUDENTINFO;

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                StudentModel studentModel = new StudentModel(Integer.parseInt(cursor.getString(0)), cursor.getString(1));
                studentModelList.add(studentModel);
            } while (cursor.moveToNext());
        }

        return  studentModelList;
    }
}
