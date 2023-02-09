package com.example.healendery;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class W_b_pullup_Activity extends AppCompatActivity {
    EditText pullup_weight,pullup_count,pullup_cycle;
    Button save_btn_pullup;
    private DbOpenHelper mDbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.w_b_pullup);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        pullup_count = (EditText) findViewById(R.id.pullup_count);
        pullup_weight = (EditText) findViewById(R.id.pullup_weight);
        pullup_cycle = (EditText) findViewById(R.id.pullup_cycle);
        save_btn_pullup = (Button) findViewById(R.id.pullup_save_btn);

        mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();

        save_btn_pullup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String type = "back_pullup";
                String weight = pullup_weight.getText().toString();
                long count = Long.parseLong(pullup_count.getText().toString());
                String cycle = pullup_cycle.getText().toString();
                mDbOpenHelper.insertColumn(type,weight+"kg",count,cycle+"cycle");
                finish();

            }
        });

    }
}