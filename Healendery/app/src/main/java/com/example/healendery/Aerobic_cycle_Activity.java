package com.example.healendery;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Aerobic_cycle_Activity extends AppCompatActivity {

    private Button CycleCalculateBtn;
    private Button CycleSaveBtn;

    private TextView CycleView;
    private TextView CycleView1;
    private TextView CycleView2;
    private Button CycleTime;
    private Button CycleTime1;
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
        setContentView(R.layout.aerobic_cycle);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        CycleTime = findViewById(R.id.a_cy_start_btn);
        CycleTime1 = findViewById(R.id.a_cy_end_btn);
        CycleView = findViewById(R.id.a_cy_time_txt);
        CycleView1 = findViewById(R.id.a_cy_time1_txt);
        CycleCalculateBtn = findViewById(R.id.cycle_calcurlate_btn);
        CycleSaveBtn = findViewById(R.id.cycle_save_btn);
        CycleView2 = findViewById(R.id.cycle_calory);
        CycleView2.setText(value+"");
        CycleTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID);
            }
        });
        CycleTime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID1);
            }
        });
        CycleCalculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveInfo myweight = (SaveInfo)getApplication();
                weight = myweight.getWeight();
                my_weight = Integer.parseInt(weight);
                value = (mHour1*60+mMinute1 - mHour*60+ mMinute) * my_weight* 0.0035 * 8;
                value = value * 5;
                CycleView2.setText(Math.round(value*100)/100.0+"kcal");
            }
        });
        CycleSaveBtn.setOnClickListener(new OnClickListener() {
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
        CycleView.setText(String.format("%d시 %d분", mHour, mMinute));
    }

    private void updateDisplay1() {
        CycleView1.setText(String.format("%d시 %d분", mHour1, mMinute1));
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