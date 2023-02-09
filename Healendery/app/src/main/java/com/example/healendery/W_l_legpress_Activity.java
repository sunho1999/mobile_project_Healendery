package com.example.healendery;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class W_l_legpress_Activity extends AppCompatActivity {
    EditText legpress_weight,legpress_count,legpress_cycle;
    Button save_btn_legpress;
    DbOpenHelper mDbOpenHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.w_l_legpress);
        ActionBar bar = getSupportActionBar();
        bar.hide();
        legpress_weight = (EditText) findViewById(R.id.legpress_weight);
        legpress_count = (EditText) findViewById(R.id.legpress_count);
        legpress_cycle = (EditText) findViewById(R.id.legpress_cycle);
        save_btn_legpress = (Button)findViewById(R.id.legpress_save_btn);

        mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();

        save_btn_legpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type = "leg_press";
                String weight = legpress_weight.getText().toString();
                long count = Long.parseLong(legpress_count.getText().toString());
                String cycle = legpress_cycle.getText().toString();
                mDbOpenHelper.insertColumn(type,weight+"kg",count,cycle+"cycle");
                finish();
            }
        });
    }
}