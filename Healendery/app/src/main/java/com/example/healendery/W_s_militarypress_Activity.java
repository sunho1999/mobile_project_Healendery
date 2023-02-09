package com.example.healendery;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class W_s_militarypress_Activity extends AppCompatActivity {
    EditText ml_weight,ml_count,ml_cycle;
    Button save_btn_ml;
    private DbOpenHelper mDbOpenHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.w_s_militarypress);
        ActionBar bar = getSupportActionBar();
        bar.hide();
        ml_weight = (EditText) findViewById(R.id.militarypress_weight);
        ml_count = (EditText) findViewById(R.id.militarypress_count);
        ml_cycle = (EditText) findViewById(R.id.militarypress_cycle);
        save_btn_ml = (Button)findViewById(R.id.militarypress_save_btn);

        mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();

        save_btn_ml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String type = "shoulder_ml";
                String weight = ml_weight.getText().toString();
                long count = Long.parseLong(ml_count.getText().toString());
                String cycle = ml_cycle.getText().toString();
                mDbOpenHelper.insertColumn(type,weight+"kg",count,cycle+"cycle");
                finish();

            }
        });
    }
}
