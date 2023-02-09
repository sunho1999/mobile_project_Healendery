package com.example.healendery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class WeightLegAcitivty extends AppCompatActivity {

    Button squart_btn,legpress_btn,legextension_btn,legcurl_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_leg_activity);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        squart_btn = (Button) findViewById(R.id.squart_btn);
        legpress_btn = (Button) findViewById(R.id.legpress_btn);
        legextension_btn = (Button) findViewById(R.id.legextension_btn);
        legcurl_btn = (Button) findViewById(R.id.legcurl_btn);

        // 스쿼트 버튼
        squart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(WeightLegAcitivty.this, W_l_squart_Activity.class);
                startActivity(intent);
            }
        });
        // 레그프레스 버튼
        legpress_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(WeightLegAcitivty.this, W_l_legpress_Activity.class);
                startActivity(intent);

            }
        });
        // 레그 익스텐션 버튼
        legextension_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(WeightLegAcitivty.this, W_l_legextension_Activity.class);
                startActivity(intent);

            }
        });
        // 레그컬 버튼
        legcurl_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(WeightLegAcitivty.this, W_l_legcurl_Activity.class);
                startActivity(intent);
            }
        });
    }
}
