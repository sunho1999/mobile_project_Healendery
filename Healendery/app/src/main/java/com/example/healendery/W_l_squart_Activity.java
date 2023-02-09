package com.example.healendery;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class W_l_squart_Activity extends AppCompatActivity {
    EditText squart_weight,squart_count,squart_cycle;
    Button save_btn_squart;
    DbOpenHelper mDbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.w_l_squart);
        ActionBar bar = getSupportActionBar();
        bar.hide();
        squart_weight = (EditText) findViewById(R.id.squart_weight);
        squart_count = (EditText) findViewById(R.id.squart_count);
        squart_cycle = (EditText) findViewById(R.id.squart_cycle);
        save_btn_squart = (Button)findViewById(R.id.squart_save_btn);

        mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();

        save_btn_squart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type = "leg_squart";
                String weight = squart_weight.getText().toString();
                long count = Long.parseLong(squart_count.getText().toString());
                String cycle = squart_cycle.getText().toString();
                mDbOpenHelper.insertColumn(type,weight+"kg",count,cycle+"cycle");
                finish();
            }
        });
    }
}
