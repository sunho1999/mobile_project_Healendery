package com.example.healendery;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class W_b_repldown_Activity extends AppCompatActivity {
    EditText repldown_weight,repldown_count,repldown_cycle;
    Button save_btn_repldown;
    private DbOpenHelper mDbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.w_b_repldown);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        repldown_count = (EditText) findViewById(R.id.repldown_count);
        repldown_weight = (EditText) findViewById(R.id.repldown_weight);
        repldown_cycle = (EditText) findViewById(R.id.repldown_cycle);
        save_btn_repldown = (Button) findViewById(R.id.repldown_save_btn);

        mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();

        save_btn_repldown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String type = "back_repledown";
                String weight = repldown_weight.getText().toString();
                long count = Long.parseLong(repldown_count.getText().toString());
                String cycle = repldown_cycle.getText().toString();
                mDbOpenHelper.insertColumn(type,weight+"kg",count,cycle+"cycle");
                finish();

            }
        });

    }
}