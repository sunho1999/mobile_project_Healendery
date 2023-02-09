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

public class Aerobic_climbing_Activity extends AppCompatActivity {

    private Button ClimbCalculateBtn;
    private Button ClimbSaveBtn;

    private TextView ClimbView;
    private TextView ClimbView1;
    private TextView ClimbView2;
    private Button ClimbTime;
    private Button ClimbTime1;
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
        setContentView(R.layout.aerobic_climbing);
        ActionBar bar = getSupportActionBar();
        bar.hide();


        ClimbTime = findViewById(R.id.a_c_start_btn);
        ClimbTime1 = findViewById(R.id.a_c_end_btn);
        ClimbView = findViewById(R.id.a_c_time_txt);
        ClimbView1 = findViewById(R.id.a_c_time1_txt);
        ClimbCalculateBtn = findViewById(R.id.climbing_calcurlate_btn);
        ClimbSaveBtn = findViewById(R.id.climbing_save_btn);
        ClimbView2 = findViewById(R.id.climbing_calory);
        ClimbView2.setText(value+"");
        ClimbTime.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID);
            }
        });
        ClimbTime1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID1);
            }
        });
        ClimbCalculateBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveInfo myweight = (SaveInfo)getApplication();
                weight = myweight.getWeight();
                my_weight = Integer.parseInt(weight);
                value = (mHour1*60 +mMinute1 - mHour*60 + mMinute) * my_weight* 0.0035 * 6;
                value = value * 5;
                ClimbView2.setText(Math.round(value*100)/100.0+"kcal");
            }
        });
        ClimbSaveBtn.setOnClickListener(new OnClickListener() {
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
        ClimbView.setText(String.format("%d시 %d분", mHour, mMinute));
    }

    private void updateDisplay1() {
        ClimbView1.setText(String.format("%d시 %d분", mHour1, mMinute1));
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






