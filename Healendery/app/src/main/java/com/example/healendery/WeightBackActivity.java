package com.example.healendery;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class WeightBackActivity extends AppCompatActivity {

    Button deadlift_btn,pullup_btn, barbellow_btn,repldown_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_back_activity);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        deadlift_btn = (Button) findViewById(R.id.deadlift_btn);
        pullup_btn = (Button) findViewById(R.id.pullup_btn);
        barbellow_btn = (Button) findViewById(R.id.barbellow_btn);
        repldown_btn = (Button) findViewById(R.id.repldown_btn);

        // 데드리프트 버튼
        deadlift_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(WeightBackActivity.this, W_b_deadlift_Activity.class);
                startActivity(intent);
            }
        });
        // 풀업 버튼
        pullup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(WeightBackActivity.this, W_b_pullup_Activity.class);
                startActivity(intent);

            }
        });
        // 바벨로우 버튼
        barbellow_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(WeightBackActivity.this, W_b_barbellow_Activity.class);
                startActivity(intent);

            }
        });
        // 렛풀다운 버튼
        repldown_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(WeightBackActivity.this, W_b_repldown_Activity.class);
                startActivity(intent);
            }
        });
    }
}

