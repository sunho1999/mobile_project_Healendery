package com.example.healendery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class WeightShoulderActivity extends AppCompatActivity {

    Button sll_btn,fll_btn,milp_btn,dump_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_shoulder_activity);
        ActionBar bar = getSupportActionBar();
        bar.hide();
        sll_btn = (Button) findViewById(R.id.sll_btn);
        fll_btn = (Button) findViewById(R.id.fll_btn);
        milp_btn = (Button) findViewById(R.id.militarypress_btn);
        dump_btn = (Button) findViewById(R.id.dumbelpress_btn);

        //사이드 레터럴 버튼
        sll_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent();
                    intent = new Intent(WeightShoulderActivity.this, W_s_sll_Activity.class);
                    startActivity(intent);
            }
        });
        // 프론트레이즈 버튼
        fll_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(WeightShoulderActivity.this, W_s_fll_Activity.class);
                startActivity(intent);

            }
        });
        // 밀리터리 버튼
        milp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(WeightShoulderActivity.this, W_s_militarypress_Activity.class);
                startActivity(intent);

            }
        });
        // 덤벨프레스 버튼
        dump_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(WeightShoulderActivity.this, W_s_dumbelpress_Activity.class);
                startActivity(intent);
            }
        });
    }
}
