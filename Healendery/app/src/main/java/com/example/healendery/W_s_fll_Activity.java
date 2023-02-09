package com.example.healendery;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class W_s_fll_Activity extends AppCompatActivity {
    EditText fll_weight,fll_count,fll_cycle;
    Button save_btn_fll;
    DbOpenHelper mDbOpenHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.w_s_fll_activity);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        fll_weight = (EditText) findViewById(R.id.fll_weight);
        fll_count = (EditText) findViewById(R.id.fll_count);
        fll_cycle = (EditText) findViewById(R.id.fll_cycle);
        save_btn_fll = (Button)findViewById(R.id.fll_save_btn);

        mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();

        save_btn_fll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type = "shoulder_fll";
                String weight = fll_weight.getText().toString();
                long count = Long.parseLong(fll_count.getText().toString());
                String cycle = fll_cycle.getText().toString();
                mDbOpenHelper.insertColumn(type,weight+"kg",count,cycle+"cycle");
                finish();

            }
        });
    }
}
