package com.example.healendery;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class W_s_sll_Activity extends AppCompatActivity {
    EditText sll_weight,sll_count,sll_cycle;
    Button save_btn_sll;
    private DbOpenHelper mDbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.w_s_sll_activity);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        sll_count = (EditText) findViewById(R.id.sll_count);
        sll_weight = (EditText) findViewById(R.id.sll_weight);
        sll_cycle = (EditText) findViewById(R.id.sll_cycle);
        save_btn_sll = (Button) findViewById(R.id.sll_save_btn);

        mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();

        save_btn_sll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String type = "shoulder_sll";
                String weight = sll_weight.getText().toString();
                long count = Long.parseLong(sll_count.getText().toString());
                String cycle = sll_cycle.getText().toString();
                mDbOpenHelper.insertColumn(type,weight+"kg",count,cycle+"cycle");
                finish();

            }
        });

    }
}
