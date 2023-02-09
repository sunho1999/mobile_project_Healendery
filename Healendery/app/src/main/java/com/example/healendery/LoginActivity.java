package com.example.healendery;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    Button loginButton;
    Button memberButton;

    EditText id;
    EditText password;

    String userId;
    boolean userExist;

    SQLiteDatabase newDB;
    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        helper = new DatabaseHelper(this, "new", null, 1);


        loginButton = (Button) findViewById(R.id.login_btn);
        memberButton = (Button) findViewById(R.id.login_btn2);

        id = (EditText) findViewById(R.id.editTextTextPersonName);
        password = (EditText) findViewById(R.id.editTextTextPassword);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userExist = false;

                String isId = id.getText().toString().trim();
                String isPass = password.getText().toString().trim();
                if (isId.length() > 4 && isPass.length() > 4)
                    searchData(isId, isPass);
                else
                    Toast.makeText(LoginActivity.this, "입력이 잘못되었습니다.", Toast.LENGTH_SHORT);

                if (userExist) {
                    Intent intent = new Intent();
                    intent = new Intent(LoginActivity.this, InfoActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(LoginActivity.this, "아이디 혹은 비밀번호가" +
                            "없거나 잘못되었습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        memberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MemberActivity.class);
                startActivity(intent);
            }
        });
    }

    public void searchData(String isId, String isPass) {
        newDB = helper.getReadableDatabase();
        String sql = ("select userId, password from test");
        Cursor cursor = newDB.rawQuery(sql, null);

        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            String id = cursor.getString(0);
            String password = cursor.getString(1);
            if (id.equals(isId) && password.equals(isPass)) {
                userId = id;
                userExist = true;
                break;
            }
        }
    }
}