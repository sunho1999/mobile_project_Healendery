package com.example.healendery;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class W_l_legextension_Activity extends AppCompatActivity {
    EditText legextension_weight,legextension_count,legextension_cycle;
    Button save_btn_legextension;
    DbOpenHelper mDbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.w_l_legextension);
        ActionBar bar = getSupportActionBar();
        bar.hide();
        legextension_weight = (EditText) findViewById(R.id.legextension_weight);
        legextension_count = (EditText) findViewById(R.id.legextension_count);
        legextension_cycle = (EditText) findViewById(R.id.legextension_cycle);
        save_btn_legextension = (Button)findViewById(R.id.legextension_save_btn);

        mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();
        save_btn_legextension.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type = "leg_extension";
                String weight = legextension_weight.getText().toString();
                long count = Long.parseLong(legextension_count.getText().toString());
                String cycle = legextension_cycle.getText().toString();
                mDbOpenHelper.insertColumn(type,weight+"kg",count,cycle+"cycle");
                finish();
            }
        });
    }
}