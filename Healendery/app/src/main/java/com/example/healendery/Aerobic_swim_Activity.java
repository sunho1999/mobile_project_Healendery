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

public class Aerobic_swim_Activity extends AppCompatActivity {

    private Button SwimCalculateBtn;
    private Button SwimSaveBtn;

    private TextView SwimView;
    private TextView SwimView1;
    private TextView SwimView2;
    private Button SwimTime;
    private Button SwimTime1;
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
        setContentView(R.layout.aerobic_swim);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        SwimTime = findViewById(R.id.a_swim_start_btn);
        SwimTime1 = findViewById(R.id.a_swim_end_btn);
        SwimView = findViewById(R.id.a_swim_time_txt);
        SwimView1 = findViewById(R.id.a_swim_time1_txt);
        SwimCalculateBtn = findViewById(R.id.swim_calcurlate_btn);
        SwimSaveBtn = findViewById(R.id.swim_save_btn);
        SwimView2 = findViewById(R.id.swim_calory);
        SwimView2.setText(value+"");
        SwimTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID);
            }
        });
        SwimTime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID1);
            }
        });
        SwimCalculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveInfo myweight = (SaveInfo)getApplication();
                weight = myweight.getWeight();
                my_weight = Integer.parseInt(weight);
                value = (mHour1*60+mMinute1 - mHour*60+ mMinute) * my_weight* 0.0035 * 7;
                value = value * 5;
                SwimView2.setText(Math.round(value*100)/100.0+"kcal");
            }
        });
        SwimSaveBtn.setOnClickListener(new View.OnClickListener() {
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
        SwimView.setText(String.format("%d시 %d분", mHour, mMinute));
    }

    private void updateDisplay1() {
        SwimView1.setText(String.format("%d시 %d분", mHour1, mMinute1));
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