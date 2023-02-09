package com.example.healendery;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class W_a_loappushdown_Activity extends AppCompatActivity {
    EditText loappushdown_weight,loappushdown_count,loappushdown_cycle;
    Button save_btn_loappushdown;
    private DbOpenHelper mDbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.w_a_loappushdown);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        loappushdown_count = (EditText) findViewById(R.id.loappushdown_count);
        loappushdown_weight = (EditText) findViewById(R.id.loappushdown_weight);
        loappushdown_cycle = (EditText) findViewById(R.id.loappushdown_cycle);
        save_btn_loappushdown = (Button) findViewById(R.id.loappushdown_save_btn);

        mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();

        save_btn_loappushdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String type = "arm_loappushdown";
                String weight = loappushdown_weight.getText().toString();
                long count = Long.parseLong(loappushdown_count.getText().toString());
                String cycle = loappushdown_cycle.getText().toString();
                mDbOpenHelper.insertColumn(type,weight+"kg",count,cycle+"cycle");
                finish();

            }
        });

    }
}