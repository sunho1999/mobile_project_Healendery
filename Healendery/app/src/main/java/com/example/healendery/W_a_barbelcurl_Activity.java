package com.example.healendery;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class W_a_barbelcurl_Activity extends AppCompatActivity {
    EditText barbelcurl_weight,barbelcurl_count,barbelcurl_cycle;
    Button save_btn_barbelcurl;
    private DbOpenHelper mDbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.w_a_barbelcurl);
        ActionBar bar = getSupportActionBar();
        bar.hide();
        barbelcurl_count = (EditText) findViewById(R.id.barbelcurl_count);
        barbelcurl_weight = (EditText) findViewById(R.id.barbelcurl_weight);
        barbelcurl_cycle = (EditText) findViewById(R.id.barbelcurl_cycle);
        save_btn_barbelcurl = (Button) findViewById(R.id.barbelcurl_save_btn);

        mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();

        save_btn_barbelcurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String type = "arm_barbelcurl";
                String weight = barbelcurl_weight.getText().toString();
                long count = Long.parseLong(barbelcurl_count.getText().toString());
                String cycle = barbelcurl_cycle.getText().toString();
                mDbOpenHelper.insertColumn(type,weight+"kg",count,cycle+"cycle");
                finish();

            }
        });

    }
}
