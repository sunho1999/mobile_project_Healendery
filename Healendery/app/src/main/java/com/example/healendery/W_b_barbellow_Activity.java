package com.example.healendery;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class W_b_barbellow_Activity extends AppCompatActivity {
    EditText barbellow_weight,barbellow_count,barbellow_cycle;
    Button save_btn_barbellow;
    private DbOpenHelper mDbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.w_b_barbellow);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        barbellow_count = (EditText) findViewById(R.id.barbellow_count);
        barbellow_weight = (EditText) findViewById(R.id.barbellow_weight);
        barbellow_cycle = (EditText) findViewById(R.id.barbellow_cycle);
        save_btn_barbellow = (Button) findViewById(R.id.barbellow_save_btn);

        mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();

        save_btn_barbellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String type = "back_barbellow";
                String weight = barbellow_weight.getText().toString();
                long count = Long.parseLong(barbellow_count.getText().toString());
                String cycle = barbellow_cycle.getText().toString();
                mDbOpenHelper.insertColumn(type,weight+"kg",count,cycle+"cycle");
                finish();

            }
        });

    }
}