package com.example.healendery;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class W_s_dumbelpress_Activity extends AppCompatActivity {
    EditText dumbpelpress_weight,dumbpelpress_count,dumbpelpress_cycle ;
    Button save_btn_dumbpelpress;
    DbOpenHelper mDbOpenHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.w_s_dumbelpress);
        ActionBar bar = getSupportActionBar();
        bar.hide();
        dumbpelpress_weight = (EditText) findViewById(R.id.dumbelpress_weight);
        dumbpelpress_count = (EditText) findViewById(R.id.dumbelpress_count);
        dumbpelpress_cycle = (EditText) findViewById(R.id.dumbelpress_cycle);
        save_btn_dumbpelpress = (Button)findViewById(R.id.dumbelpress_save_btn);

        mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();

        save_btn_dumbpelpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type = "shoulder_dumbelpress";
                String weight = dumbpelpress_weight.getText().toString();
                long count = Long.parseLong(dumbpelpress_count.getText().toString());
                String cycle = dumbpelpress_cycle.getText().toString();
                mDbOpenHelper.insertColumn(type,weight+"kg",count,cycle+"cycle");
                finish();
            }
        });
    }
}