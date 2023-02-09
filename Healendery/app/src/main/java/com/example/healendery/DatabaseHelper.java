package com.example.healendery;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String userTable = "test";
        db.execSQL("create table if not exists " + userTable + " ("
                + " _id integer PRIMARY KEY autoincrement, "
                + " userId text, "
                + " password text);");

        String userSubjectTable = "test2";
        db.execSQL("create table if not exists " + userSubjectTable + " ("
                + " _id integer PRIMARY KEY autoincrement, "
                + " userId text, "
                + " sub text, "
                + " day text, "
                + " start_time text, "
                + " finish_time text, "
                + " FOREIGN KEY (userId) REFERENCES test (userId));");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}