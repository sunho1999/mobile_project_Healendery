package com.example.healendery;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Goal_text_Activity extends AppCompatActivity {
    EditText mygoal_text;
    Button goal_text_save_btn;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goal_text_activity);
        mygoal_text = findViewById(R.id.mygoal_text);
        goal_text_save_btn = (Button) findViewById(R.id.goal_text_save_btn);
        sp = getSharedPreferences("sp", MODE_PRIVATE);
        String save = sp.getString("save", ""); mygoal_text.setText(save);
        goal_text_save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Goal_text_Activity.this, "저장되었습니다.", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
    @Override protected void onDestroy() {
        super.onDestroy();
        save(mygoal_text.getText().toString());
    }
    public void save(String s){
        sp = getSharedPreferences("sp",MODE_PRIVATE);
    SharedPreferences.Editor editor = sp.edit();
    editor.putString("save",s); editor.commit();
    }

}