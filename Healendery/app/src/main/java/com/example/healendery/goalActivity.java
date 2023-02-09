package com.example.healendery;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class goalActivity extends AppCompatActivity {

    RadioButton btn_aerobic, btn_weight;
    RadioGroup radioGroup;
    EditText day;
    Button go_calen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goal_activity);
        ActionBar bar = getSupportActionBar();
        bar.hide();
        btn_aerobic = (RadioButton) findViewById(R.id.btn_aerobic);
        btn_weight = (RadioButton) findViewById(R.id.btn_weight);
        radioGroup = (RadioGroup) findViewById(R.id.exercise_type_group);
        day = (EditText) findViewById(R.id.day);
        go_calen = (Button)findViewById(R.id.go_calen);
        SaveInfo state = (SaveInfo) getApplication();


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //  유산소이면 값을 true로 저장
                if (checkedId == R.id.btn_aerobic){

                    state.setType(true);
                    Toast.makeText(goalActivity.this, "유산소", Toast.LENGTH_LONG).show();
                }

                // 웨이트면 값을 false로 저장
                else if(checkedId == R.id.btn_weight){
                    state.setType(false);
                    Toast.makeText(goalActivity.this, "웨이트", Toast.LENGTH_LONG).show();
                }
            }


        });
        go_calen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String goal_day = day.getText().toString();
                if (goal_day.length() == 0) {
                    Toast.makeText(goalActivity.this, "기간을 입력해주세요.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(goalActivity.this, "입력되었습니다", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), CalenderActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
