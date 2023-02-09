package com.example.healendery;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class W_a_dumbelcurl_Activity extends AppCompatActivity {
    EditText dumbelcurl_weight,dumbelcurl_count,dumbelcurl_cycle;
    Button save_btn_dumbelcurl;
    private DbOpenHelper mDbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.w_a_dumbelcurl);
        ActionBar bar = getSupportActionBar();
        bar.hide();
        dumbelcurl_count = (EditText) findViewById(R.id.dumbelcurl_count);
        dumbelcurl_weight = (EditText) findViewById(R.id.dumbelcurl_weight);
        dumbelcurl_cycle = (EditText) findViewById(R.id.dumbelcurl_cycle);
        save_btn_dumbelcurl = (Button) findViewById(R.id.dumbelcurl_save_btn);

        mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();

        save_btn_dumbelcurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String type = "arm_dumbelcurl";
                String weight = dumbelcurl_weight.getText().toString();
                long count = Long.parseLong(dumbelcurl_count.getText().toString());
                String cycle = dumbelcurl_cycle.getText().toString();
                mDbOpenHelper.insertColumn(type,weight+"kg",count,cycle+"cycle");
                finish();

            }
        });

    }
}