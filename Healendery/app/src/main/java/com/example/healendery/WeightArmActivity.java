package com.example.healendery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class WeightArmActivity extends AppCompatActivity {
    Button dumbelcurl_btn,barbelcurl_btn,cablepushdown_btn,loappushdown_btn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_arm_activity);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        dumbelcurl_btn = (Button) findViewById(R.id.dumbelcurl_btn);
        barbelcurl_btn = (Button) findViewById(R.id.barbelcurl_btn);
        cablepushdown_btn = (Button) findViewById(R.id.cablepushdown_btn);
        loappushdown_btn = (Button) findViewById(R.id.loappushdown_btn);

        //덤벨 컬 버튼
        dumbelcurl_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(WeightArmActivity.this, W_a_dumbelcurl_Activity.class);
                startActivity(intent);
            }
        });
        // 바벨컬 버튼
        barbelcurl_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(WeightArmActivity.this, W_a_barbelcurl_Activity.class);
                startActivity(intent);

            }
        });
        // 케이블푸쉬 버튼
        cablepushdown_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(WeightArmActivity.this, W_a_cablepushdown_Activity.class);
                startActivity(intent);

            }
        });
        // 로프푸쉬다운 버튼
        loappushdown_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(WeightArmActivity.this, W_a_loappushdown_Activity.class);
                startActivity(intent);
            }
        });
    }
}