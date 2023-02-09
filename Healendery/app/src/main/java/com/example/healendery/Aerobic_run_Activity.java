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

public class Aerobic_run_Activity extends AppCompatActivity {

    private Button RunCalculateBtn;
    private Button RunSaveBtn;

    private TextView RunView;
    private TextView RunView1;
    private TextView RunView2;
    private Button RunTime;
    private Button RunTime1;
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
        setContentView(R.layout.aerobic_run);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        RunTime = findViewById(R.id.a_run_start_btn);
        RunTime1 = findViewById(R.id.a_run_end_btn);
        RunView = findViewById(R.id.a_run_time_txt);
        RunView1 = findViewById(R.id.a_run_time1_txt);
        RunCalculateBtn = findViewById(R.id.run_calcurlate_btn);
        RunSaveBtn = findViewById(R.id.run_save_btn);
        RunView2 = findViewById(R.id.run_calory);
        RunView2.setText(value+"");
        RunTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID);
            }
        });
        RunTime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID1);
            }
        });
        RunCalculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveInfo myweight = (SaveInfo)getApplication();
                weight = myweight.getWeight();
                my_weight = Integer.parseInt(weight);
                value = (mHour1*60+mMinute1 - mHour*60+ mMinute) * my_weight* 0.0035 * 10;
                value = value * 5;
                RunView2.setText(Math.round(value*100)/100.0+"kcal");
            }
        });
        RunSaveBtn.setOnClickListener(new View.OnClickListener() {
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
        RunView.setText(String.format("%d시 %d분", mHour, mMinute));
    }

    private void updateDisplay1() {
        RunView1.setText(String.format("%d시 %d분", mHour1, mMinute1));
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
