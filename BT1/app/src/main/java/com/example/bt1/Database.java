package com.example.bt1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {


    private static final String DATABASE_NAME ="Student_manager";
    private static final String TABLE_NAME="student";
    private static final String ID ="id";
    private static final String NAME ="name";
    private static final String EMAIL ="email";
    private static final String BIRTHDAY ="birthday";
    private static final String ADDRESS ="address"; //born
    private static final int VERSION =1;
    private Context context;

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null , VERSION);
        this.context=context;
    }

    //cau truy van
    String sqlQuery = "CREATE TABLE "+TABLE_NAME +" ( " +
            ID +" integer primary key, "+
            NAME + " TEXT, "+
            EMAIL +" TEXT, "+
            BIRTHDAY+" TEXT," +
            ADDRESS +" TEXT)";
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlQuery);
        Toast.makeText(context, "Create successfylly", Toast.LENGTH_SHORT).show();
    }

    //khi đổi version thì mới gọi tới onUpgrades
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



    public void add(Model student){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values =new ContentValues();
            values.put(NAME,student.name);
            values.put(ID ,student.ID);
            values.put(BIRTHDAY,student.birthday);
            values.put(ADDRESS,student.born);
            values.put(EMAIL,student.email);
            db.insert(TABLE_NAME,null,values);
            db.close();
    }

    public ArrayList<Model> getAllStudent(){
        ArrayList<Model> modelList = new ArrayList<>();
        String selectallquery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectallquery,null);
        if (cursor.moveToFirst()){
            do {
                Model student = new Model();
                student.setID(cursor.getInt(0));
                student.setName(cursor.getString(1));
                student.setEmail(cursor.getString(2));
                student.setBirthday(cursor.getString(3));
                student.setBorn(cursor.getString(4));
                modelList.add(student);
            }while(cursor.moveToNext());
        }
        db.close();
        return modelList;
    }

    public int UpdateStudent(Model student){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME,student.name);
//        values.put(ID ,student.ID);
        values.put(BIRTHDAY,student.birthday);
        values.put(ADDRESS,student.born);
        values.put(EMAIL,student.email);
        int t = db.update(TABLE_NAME,values,ID + "=?",new String[] {String.valueOf(student.getID())});
        return t;
    }

    public int delete(Model student){
        SQLiteDatabase db = this.getWritableDatabase();
        int t = db.delete(TABLE_NAME,ID + "=?",new String[] {String.valueOf(student.getID())});
        return t;
    }

    public ArrayList<Model> search(String s){
        ArrayList<Model> modelList = new ArrayList<>();
        String selectallquery = "SELECT * FROM " + TABLE_NAME + " WHERE NAME = " + s + "";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectallquery,null);
        if (cursor.moveToFirst()){
            do {
                Model student = new Model();
                student.setID(cursor.getInt(0));
                student.setName(cursor.getString(1));
                student.setEmail(cursor.getString(2));
                student.setBirthday(cursor.getString(3));
                student.setBorn(cursor.getString(4));
                modelList.add(student);
            }while(cursor.moveToNext());
        }
        db.close();
        return modelList;
    }


}
