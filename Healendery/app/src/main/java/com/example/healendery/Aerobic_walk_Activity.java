package com.example.healendery;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Aerobic_walk_Activity extends AppCompatActivity {

    private Button WalkCalculateBtn;
    private Button WalkSaveBtn;

    private TextView WalkView;
    private TextView WalkView1;
    private TextView WalkView2;
    private Button WalkTime;
    private Button WalkTime1;
    private int mHour;
    private int mMinute;
    private int mHour1;
    private int mMinute1;
    private double value = 0;
    private String weight;
    private int my_weight;

    static final int TIME_DIALOG_ID = 0;
    static final int TIME_DIALOG_ID1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aerobic_walk);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        WalkTime = findViewById(R.id.a_walk_start_btn);
        WalkTime1 = findViewById(R.id.a_walk_end_btn);
        WalkView = findViewById(R.id.a_walk_time_txt);
        WalkView1 = findViewById(R.id.a_walk_time1_txt);
        WalkCalculateBtn = findViewById(R.id.walk_calcurlate_btn);
        WalkSaveBtn = findViewById(R.id.walk_save_btn);
        WalkView2 = findViewById(R.id.walk_calory);
        WalkView2.setText(value+"");
        WalkTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID);
            }
        });
        WalkTime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID1);
            }
        });
        WalkCalculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveInfo myweight = (SaveInfo)getApplication();
                weight = myweight.getWeight();
                my_weight = Integer.parseInt(weight);
                value = (mHour1*60+mMinute1 - mHour*60+ mMinute) * my_weight* 0.0035 * 4;
                value = value * 5;
                WalkView2.setText(Math.round(value*100)/100.0+"kcal");
            }
        });
        WalkSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        final Calendar c = Calendar.getInstance();
        final Calendar c1 = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);
        mHour1 = c1.get(Calendar.HOUR_OF_DAY);
        mMinute1 = c1.get(Calendar.MINUTE);

        updateDisplay();
        updateDisplay1();

    }


    private void updateDisplay() {
        WalkView.setText(String.format("%d시 %d분", mHour, mMinute));
    }

    private void updateDisplay1() {
        WalkView1.setText(String.format("%d시 %d분", mHour1, mMinute1));
    }

    private TimePickerDialog.OnTimeSetListener mTimeSetListener =
            new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    mHour = hourOfDay;
                    mMinute = minute;
                    updateDisplay();
                }
            };
    private final TimePickerDialog.OnTimeSetListener mTimeSetListener1 =
            new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay1, int minute1) {
                    mHour1 = hourOfDay1;
                    mMinute1 = minute1;
                    updateDisplay1();
                }
            };


    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {

            case TIME_DIALOG_ID:
                return new TimePickerDialog(this, mTimeSetListener, mHour, mMinute, false);
            case TIME_DIALOG_ID1:
                return new TimePickerDialog(this, mTimeSetListener1, mHour1, mMinute1, false);
        }

        return null;
    }


}