package com.example.healendery;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class W_c_dips_Activity extends AppCompatActivity {
    EditText dips_weight,dips_count,dips_cycle;
    Button save_btn_dips;
    private DbOpenHelper mDbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.w_c_dips);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        dips_count = (EditText) findViewById(R.id.dips_count);
        dips_weight = (EditText) findViewById(R.id.dips_weight);
        dips_cycle = (EditText) findViewById(R.id.dips_cycle);
        save_btn_dips = (Button) findViewById(R.id.dips_save_btn);

        mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();

        save_btn_dips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String type = "chest_dips";
                String weight = dips_weight.getText().toString();
                long count = Long.parseLong(dips_count.getText().toString());
                String cycle = dips_cycle.getText().toString();
                mDbOpenHelper.insertColumn(type,weight+"kg",count,cycle+"cycle");
                finish();

            }
        });

    }
}