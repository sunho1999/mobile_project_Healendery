package com.example.healendery;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class W_b_deadlift_Activity extends AppCompatActivity {
    EditText deadlift_weight,deadlift_count,deadlift_cycle;
    Button save_btn_deadlift;
    private DbOpenHelper mDbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.w_b_deadlift);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        deadlift_count = (EditText) findViewById(R.id.deadlift_count);
        deadlift_weight = (EditText) findViewById(R.id.deadlift_weight);
        deadlift_cycle = (EditText) findViewById(R.id.deadlift_cycle);
        save_btn_deadlift = (Button) findViewById(R.id.deadlift_save_btn);

        mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();

        save_btn_deadlift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String type = "back_deadlift";
                String weight = deadlift_weight.getText().toString();
                long count = Long.parseLong(deadlift_count.getText().toString());
                String cycle = deadlift_cycle.getText().toString();
                mDbOpenHelper.insertColumn(type,weight+"kg",count,cycle+"cycle");
                finish();

            }
        });

    }
}