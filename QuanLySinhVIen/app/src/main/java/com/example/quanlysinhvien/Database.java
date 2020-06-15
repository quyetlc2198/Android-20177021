package com.example.quanlysinhvien;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.UnicodeSetSpanner;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME ="Student_manager";
    private static final String TABLE_NAME="student";
    private static final String MSSV ="mssv";
    private static final String NAME ="name";
    private static final String EMAIL ="email";
    private static final String BIRTHDAY ="birthday";
    private static final String ADDRESS ="address"; //born
    private static final int VERSION =1;
    private Context context;

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }
    String sqlQuery = "CREATE TABLE "+TABLE_NAME +" ( " +
            MSSV +" TEXT primary key , "+
            NAME + " TEXT, "+
            EMAIL +" TEXT, "+
            BIRTHDAY+" TEXT," +
            ADDRESS +" TEXT)";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlQuery);
        Toast.makeText(context, "creat sucess", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void add(Item_Student student){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MSSV,student.MSSV);
        values.put(NAME,student.Name);
        values.put(EMAIL,student.Email);
        values.put(BIRTHDAY,student.Birthday);
        values.put(ADDRESS,student.Address);
        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public ArrayList<Item_Student> getAllStudent(){
        ArrayList<Item_Student> modelList = new ArrayList<>();
        String selectallquery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectallquery,null);
        if (cursor.moveToFirst()){
            do {
                Item_Student student = new Item_Student();
                student.setMSSV(cursor.getString(0));
                student.setName(cursor.getString(1));
                student.setEmail(cursor.getString(2));
                student.setBirthday(cursor.getString(3));
                student.setAddress(cursor.getString(4));
                modelList.add(student);
            }while(cursor.moveToNext());
        }
        db.close();
        return modelList;
    }
}
