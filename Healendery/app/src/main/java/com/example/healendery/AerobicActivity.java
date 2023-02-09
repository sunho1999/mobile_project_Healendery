package com.example.healendery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class AerobicActivity extends AppCompatActivity {

    Button cycle_btn, swim_btn, run_btn, walk_btn, climbing_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aerobic_activity);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        cycle_btn = (Button) findViewById(R.id.cycle_btn);
        swim_btn = (Button) findViewById(R.id.swim_btn);
        run_btn = (Button) findViewById(R.id.run_btn);
        walk_btn = (Button) findViewById(R.id.walk_btn);
        climbing_btn = (Button) findViewById(R.id.climbing_btn);

        //싸이클
        cycle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(AerobicActivity.this, Aerobic_cycle_Activity.class);
                startActivity(intent);
            }
        });
        //수영
        swim_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(AerobicActivity.this, Aerobic_swim_Activity.class);
                startActivity(intent);

            }
        });
        // 달리기
        run_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(AerobicActivity.this, Aerobic_run_Activity.class);
                startActivity(intent);

            }
        });
        //구보
        walk_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(AerobicActivity.this, Aerobic_walk_Activity.class);
                startActivity(intent);

            }
        });

        //등산
        climbing_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(AerobicActivity.this, Aerobic_climbing_Activity.class);
                startActivity(intent);
            }
        });


    }
}