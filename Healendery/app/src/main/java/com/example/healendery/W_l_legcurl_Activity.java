package com.example.healendery;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class W_l_legcurl_Activity extends AppCompatActivity {
    EditText legcurl_weight,legcurl_count,legcurl_cycle;
    Button legcurl_save_btn;
    DbOpenHelper mDbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.w_l_legcurl);
        ActionBar bar = getSupportActionBar();
        bar.hide();
        legcurl_weight = (EditText) findViewById(R.id.legcurl_weight);
        legcurl_count = (EditText) findViewById(R.id.legcurl_count);
        legcurl_cycle = (EditText) findViewById(R.id.legcurl_cycle);
        legcurl_save_btn = (Button)findViewById(R.id.legcurl_save_btn);

        mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();
        legcurl_save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type = "leg_curl";
                String weight = legcurl_weight.getText().toString();
                long count = Long.parseLong(legcurl_count.getText().toString());
                String cycle = legcurl_cycle.getText().toString();
                mDbOpenHelper.insertColumn(type,weight+"kg",count,cycle+"cycle");
                finish();
            }
        });
    }
}