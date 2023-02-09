package com.example.healendery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class WeightChestActivity extends AppCompatActivity {

    Button benchpress_btn, inclinepress_btn, pushup_btn, dips_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_chest_activity);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        benchpress_btn = (Button) findViewById(R.id.benchpress_btn);
        inclinepress_btn = (Button) findViewById(R.id.inclinepress_btn);
        pushup_btn = (Button) findViewById(R.id.pushup_btn);
        dips_btn = (Button) findViewById(R.id.dips_btn);


        // 벤치프레스 버튼
        benchpress_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(WeightChestActivity.this, W_c_benchpress_Activity.class);
                startActivity(intent);
            }
        });
        // 인클라인 벤치프레스 버튼
        inclinepress_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(WeightChestActivity.this, W_c_inclinepress_Activity.class);
                startActivity(intent);

            }
        });
        // 푸쉬업 버튼
        pushup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(WeightChestActivity.this, W_c_pushup_Activity.class);
                startActivity(intent);

            }
        });
        // 딥스 버튼
        dips_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(WeightChestActivity.this, W_c_dips_Activity.class);
                startActivity(intent);
            }
        });
    }
}
