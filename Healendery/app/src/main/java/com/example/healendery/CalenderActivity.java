package com.example.healendery;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.BoringLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CalenderActivity extends AppCompatActivity
{
    public String readDay = null;
    public String str = null;
    public CalendarView calendarView;
    public Button cha_Btn, del_Btn, save_Btn;
    public TextView diaryTextView, textView2, textView3;
    public EditText contextEditText;
    public RadioButton btn_aerobic, btn_weight;
    public RadioGroup type_radioGroup;
    public Button go_db_btn;
    public Button goal_btn;
    public Button info_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_activity);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        calendarView = findViewById(R.id.calendarView);
        diaryTextView = findViewById(R.id.diaryTextView);
        save_Btn = findViewById(R.id.save_Btn);
        del_Btn = findViewById(R.id.del_Btn);
        cha_Btn = findViewById(R.id.cha_Btn);
        goal_btn = findViewById(R.id.goal_btn);
        go_db_btn = findViewById(R.id.go_db_btn);
        info_btn = findViewById(R.id.info_btn);

        textView2 = findViewById(R.id.memotext);
        contextEditText = findViewById(R.id.contextEditText);
        btn_aerobic = (RadioButton) findViewById(R.id.btn_aerobic);
        btn_weight = (RadioButton) findViewById(R.id.btn_weight);
        type_radioGroup = (RadioGroup) findViewById(R.id.type_radioGroup);
        SaveInfo now_state = (SaveInfo) getApplication();

        type_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //  ??????????????? ?????? true??? ??????
                if (checkedId == R.id.btn_aerobic){
                    now_state.setType(true);
                    Toast.makeText(CalenderActivity.this, "?????????", Toast.LENGTH_LONG).show();
                }

                // ??????????????? ?????? false??? ??????
                else if(checkedId == R.id.btn_weight){
                    now_state.setType(false);
                    Toast.makeText(CalenderActivity.this, "?????????", Toast.LENGTH_LONG).show();
                }
            }
        });
        goal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(CalenderActivity.this, Goal_text_Activity.class);
                Toast.makeText(CalenderActivity.this, "??????????????? ???????????????", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });

        info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(CalenderActivity.this, My_infoActivity.class);
                startActivity(intent);
            }
        });


        go_db_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(CalenderActivity.this, exercise_db_Activity.class);
                Toast.makeText(CalenderActivity.this, "????????????????????? ???????????????", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
        {

            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth)
            {
                Boolean state = ((SaveInfo) getApplication()).getType();
                diaryTextView.setVisibility(View.VISIBLE);
                save_Btn.setVisibility(View.VISIBLE);
                contextEditText.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.INVISIBLE);
                cha_Btn.setVisibility(View.INVISIBLE);
                del_Btn.setVisibility(View.INVISIBLE);

                diaryTextView.setText(String.format("%d / %d / %d", year, month + 1, dayOfMonth));
                contextEditText.setText("");
                checkDay(year, month, dayOfMonth);

                AlertDialog.Builder ad = new AlertDialog.Builder(CalenderActivity.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("?????????");
                ad.setMessage("????????? ????????????????\n" + "????????? ?????????????????????????");

                final EditText et = new EditText(CalenderActivity.this);
                ad.setView(et);

                ad.setPositiveButton("??????????????????", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // ????????? true
                        if (state == true){
                            Intent intent = new Intent();
                            intent = new Intent(CalenderActivity.this, AerobicActivity.class);
                            startActivity(intent);
                            Toast.makeText(CalenderActivity.this, String.format("%d / %d / %d", year, month + 1, dayOfMonth), Toast.LENGTH_LONG).show();
                        }
                        // ????????? false
                        else if(state == false){
                            Intent intent = new Intent();
                            intent = new Intent(CalenderActivity.this, WeightActivity.class);
                            startActivity(intent);
                            Toast.makeText(CalenderActivity.this, String.format("%d / %d / %d", year, month + 1, dayOfMonth), Toast.LENGTH_LONG).show();
                        }
                        dialog.dismiss();
                    }
                });
                ad.setNegativeButton("????????????", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                ad.show();

            }
        });
        save_Btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                saveDiary(readDay);
                str = contextEditText.getText().toString();
                textView2.setText(str);
                save_Btn.setVisibility(View.INVISIBLE);
                cha_Btn.setVisibility(View.VISIBLE);
                del_Btn.setVisibility(View.VISIBLE);
                contextEditText.setVisibility(View.INVISIBLE);
                textView2.setVisibility(View.VISIBLE);

            }
        });
    }

    public void checkDay(int cYear, int cMonth, int cDay)
    {
        readDay = "" + cYear + "-" + (cMonth + 1) + "" + "-" + cDay + ".txt";
        FileInputStream fis;

        try
        {
            fis = openFileInput(readDay);

            byte[] fileData = new byte[fis.available()];
            fis.read(fileData);
            fis.close();

            str = new String(fileData);

            contextEditText.setVisibility(View.INVISIBLE);
            textView2.setVisibility(View.VISIBLE);
            textView2.setText(str);

            save_Btn.setVisibility(View.INVISIBLE);
            cha_Btn.setVisibility(View.VISIBLE);
            del_Btn.setVisibility(View.VISIBLE);

            cha_Btn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    contextEditText.setVisibility(View.VISIBLE);
                    textView2.setVisibility(View.INVISIBLE);
                    contextEditText.setText(str);

                    save_Btn.setVisibility(View.VISIBLE);
                    cha_Btn.setVisibility(View.INVISIBLE);
                    del_Btn.setVisibility(View.INVISIBLE);
                    textView2.setText(contextEditText.getText());
                }

            });
            del_Btn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    textView2.setVisibility(View.INVISIBLE);
                    contextEditText.setText("");
                    contextEditText.setVisibility(View.VISIBLE);
                    save_Btn.setVisibility(View.VISIBLE);
                    cha_Btn.setVisibility(View.INVISIBLE);
                    del_Btn.setVisibility(View.INVISIBLE);
                    removeDiary(readDay);
                }
            });
            if (textView2.getText() == null)
            {
                textView2.setVisibility(View.INVISIBLE);
                diaryTextView.setVisibility(View.VISIBLE);
                save_Btn.setVisibility(View.VISIBLE);
                cha_Btn.setVisibility(View.INVISIBLE);
                del_Btn.setVisibility(View.INVISIBLE);
                contextEditText.setVisibility(View.VISIBLE);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @SuppressLint("WrongConstant")
    public void removeDiary(String readDay)
    {
        FileOutputStream fos;
        try
        {
            fos = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
            String content = "";
            fos.write((content).getBytes());
            fos.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @SuppressLint("WrongConstant")
    public void saveDiary(String readDay)
    {
        FileOutputStream fos;
        try
        {
            fos = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
            String content = contextEditText.getText().toString();
            fos.write((content).getBytes());
            fos.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}