package com.example.healendery;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class WeightActivity extends AppCompatActivity {

    Button sholder_btn,back_btn,chest_btn,leg_btn,arm_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_activity);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        sholder_btn = (Button) findViewById(R.id.sholder_btn);
        back_btn = (Button) findViewById(R.id.back_btn);
        chest_btn = (Button) findViewById(R.id.chest_btn);
        arm_btn = (Button) findViewById(R.id.arm_btn);
        leg_btn = (Button) findViewById(R.id.leg_btn);

        //어깨
        sholder_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(WeightActivity.this, WeightShoulderActivity.class);
                startActivity(intent);
            }
        });
        //등
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(WeightActivity.this, WeightBackActivity.class);
                startActivity(intent);

            }
        });
        // 가슴
        chest_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(WeightActivity.this, WeightChestActivity.class);
                startActivity(intent);

            }
        });
        //팔
        arm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(WeightActivity.this, WeightArmActivity.class);
                startActivity(intent);

            }
        });

        //하체
        leg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(WeightActivity.this, WeightLegAcitivty.class);
                startActivity(intent);
            }
        });

    }
}