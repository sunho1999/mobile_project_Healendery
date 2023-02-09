package com.example.healendery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {

    RadioButton btn_male, btn_female;
    RadioGroup radioGroup;
    EditText height;
    EditText weight;
    Button ok;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_activity);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        btn_male = (RadioButton) findViewById(R.id.btn_male);
        btn_female = (RadioButton) findViewById(R.id.btn_female);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.kg);
        ok = (Button) findViewById(R.id.go_calen);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                    //  남성회원이면 값을 true로 저장
                if (checkedId == R.id.btn_male){
                    SaveInfo state = (SaveInfo) getApplication();
                    state.setSex(true);
                    Toast.makeText(InfoActivity.this, "남성", Toast.LENGTH_LONG).show();
                }

                // 여성회원이면 값을 false로 저장
                else if(checkedId == R.id.btn_female){
                    SaveInfo state = (SaveInfo) getApplication();
                    state.setSex(false);
                    Toast.makeText(InfoActivity.this, "여성", Toast.LENGTH_LONG).show();
                }
            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_height = height.getText().toString();
                String user_weight = weight.getText().toString();
                SaveInfo height = (SaveInfo) getApplication();
                SaveInfo weight = (SaveInfo) getApplication();
                height.setHeight(user_height.replace("cm",""));
                weight.setWeight(user_weight.replace("kg",""));

                if (user_height.length() == 0  || user_weight.length() == 0){
                    Toast.makeText(InfoActivity.this, "키와 몸무게를 입력해주세요.", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(InfoActivity.this, "입력되었습니다.", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), goalActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}