package com.example.healendery;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class W_c_inclinepress_Activity extends AppCompatActivity {
    EditText inclinepress_weight,inclinepress_count,inclinepress_cycle;
    Button save_btn_inclinepress;
    private DbOpenHelper mDbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.w_c_inclinepress);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        inclinepress_count = (EditText) findViewById(R.id.inclinepress_count);
        inclinepress_weight = (EditText) findViewById(R.id.inclinepress_weight);
        inclinepress_cycle = (EditText) findViewById(R.id.inclinepress_cycle);
        save_btn_inclinepress = (Button) findViewById(R.id.inclinepress_save_btn);

        mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();

        save_btn_inclinepress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String type = "chest_inclinepress";
                String weight = inclinepress_weight.getText().toString();
                long count = Long.parseLong(inclinepress_count.getText().toString());
                String cycle = inclinepress_cycle.getText().toString();
                mDbOpenHelper.insertColumn(type,weight+"kg",count,cycle+"cycle");
                finish();

            }
        });

    }
}