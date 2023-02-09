package com.example.healendery;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class My_infoActivity extends AppCompatActivity {
    TextView user_name_myinfo, user_height_myinfo,user_weight_myinfo,user_sex_myinfo,user_number_myinfo;
    Button back_calen;
    String name,height,weight,number;
    boolean sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_info_activity);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        user_name_myinfo = (TextView) findViewById(R.id.user_name_myinfo);
        user_height_myinfo = (TextView) findViewById(R.id.user_height_myinfo);
        user_weight_myinfo = (TextView) findViewById(R.id.user_weight_myinfo);
        user_sex_myinfo = (TextView) findViewById(R.id.user_sex_myinfo);
        user_number_myinfo = (TextView) findViewById(R.id.user_number_myinfo);
        back_calen = (Button) findViewById(R.id.back_calen);

        SaveInfo myinfo = (SaveInfo)getApplication();
        name = myinfo.getName();
        height = myinfo.getHeight();
        weight = myinfo.getWeight();
        sex = myinfo.getSex();
        number = myinfo.getPhone();

        user_name_myinfo.setText(name);
        user_height_myinfo.setText(height);
        user_weight_myinfo.setText(weight);
        user_number_myinfo.setText(number);
        if (sex ==true){
            user_sex_myinfo.setText("남성");
        }
        else{
            user_sex_myinfo.setText("여성");
        }


        back_calen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
