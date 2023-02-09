package com.example.healendery;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class W_c_pushup_Activity extends AppCompatActivity {
    EditText pushup_weight,pushup_count,pushup_cycle;
    Button save_btn_pushup;
    private DbOpenHelper mDbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.w_c_pushup);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        pushup_count = (EditText) findViewById(R.id.pushup_count);
        pushup_weight = (EditText) findViewById(R.id.pushup_weight);
        pushup_cycle = (EditText) findViewById(R.id.pushup_cycle);
        save_btn_pushup = (Button) findViewById(R.id.pushup_save_btn);

        mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();

        save_btn_pushup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String type = "chest_pushup";
                String weight = pushup_weight.getText().toString();
                long count = Long.parseLong(pushup_count.getText().toString());
                String cycle = pushup_cycle.getText().toString();
                mDbOpenHelper.insertColumn(type,weight+"kg",count,cycle+"cycle");
                finish();

            }
        });

    }
}