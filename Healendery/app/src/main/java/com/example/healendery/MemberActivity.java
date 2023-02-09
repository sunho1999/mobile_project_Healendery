package com.example.healendery;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MemberActivity extends AppCompatActivity {

    EditText userId;
    EditText userPassword;
    EditText username;
    EditText userage;
    EditText userphonenumber;
    SQLiteDatabase newDB;
    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_activity);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        helper = new DatabaseHelper(this, "new", null, 1);

        userId = (EditText) findViewById(R.id.user_id);
        userPassword = (EditText) findViewById(R.id.user_pw);
        username = (EditText) findViewById(R.id.user_name);
        userage = (EditText)findViewById(R.id.user_age);
        userphonenumber = (EditText) findViewById(R.id.user_number);

        Button joinButton = (Button) findViewById(R.id.go_calen);

        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = userId.getText().toString().trim();
                String password = userPassword.getText().toString().trim();
                String name = username.getText().toString().trim();
                String age = userage.getText().toString().trim();
                String phonenumber = userphonenumber.getText().toString().trim();

                SaveInfo userinfo = (SaveInfo) getApplication();
                userinfo.setName(name);
                userinfo.setAge(age);
                userinfo.setPhone(phonenumber);


                if (id.length() < 5 || password.length() < 5) {
                    Toast.makeText(MemberActivity.this, "아이디 다섯 글자 이상 \n" +
                            "비밀번호 다섯 글자 이상" +
                            "\n 입력해주세요.", Toast.LENGTH_LONG).show();
                } else {
                    insertData(id, password);
                    setResult(Activity.RESULT_OK);
                    Toast.makeText(MemberActivity.this, "회원가입이 완료되었습니다", Toast.LENGTH_LONG).show();
                    finish();
                }
            }

        });
    }

    public void insertData(String id, String password) {
        newDB = helper.getWritableDatabase();

        String sql = ("insert into test(userId, password) values " +
                "(" + "'" + id + "'" + "," + "'" + password + "'" + ")");

        newDB.execSQL(sql);
    }
}