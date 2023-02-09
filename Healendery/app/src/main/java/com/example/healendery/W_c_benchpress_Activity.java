package com.example.healendery;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class W_c_benchpress_Activity extends AppCompatActivity {
    EditText benchpress_weight,benchpress_count,benchpress_cycle;
    Button save_btn_benchpress;
    private DbOpenHelper mDbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.w_c_benchpress);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        benchpress_count = (EditText) findViewById(R.id.benchpress_count);
        benchpress_weight = (EditText) findViewById(R.id.benchpress_weight);
        benchpress_cycle = (EditText) findViewById(R.id.benchpress_cycle);
        save_btn_benchpress = (Button) findViewById(R.id.benchpress_save_btn);

        mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();

        save_btn_benchpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String type = "chest_benchpress";
                String weight = benchpress_weight.getText().toString();
                long count = Long.parseLong(benchpress_count.getText().toString());
                String cycle = benchpress_cycle.getText().toString();
                mDbOpenHelper.insertColumn(type,weight+"kg",count,cycle+"cycle");
                finish();

            }
        });

    }
}