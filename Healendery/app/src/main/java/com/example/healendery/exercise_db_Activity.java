package com.example.healendery;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class exercise_db_Activity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "Main";

    Button btn_Update;
    Button btn_Insert;
    Button btn_Select;
    EditText edit_Type;
    EditText edit_Weight;
    EditText edit_Count;
    EditText edit_Cycle;
    TextView text_Type;
    TextView text_Weight;
    TextView text_Count;
    TextView text_Cycle;
    CheckBox check_ID;
    CheckBox check_Name;
    CheckBox check_Age;

    long nowIndex;
    String ID;
    String name;
    long age;
    String gender;
    String sort = "userid";

    ArrayAdapter<String> arrayAdapter;

    static ArrayList<String> arrayIndex =  new ArrayList<String>();
    static ArrayList<String> arrayData = new ArrayList<String>();
    private DbOpenHelper mDbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_db);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        btn_Insert = (Button) findViewById(R.id.btn_insert);
        btn_Insert.setOnClickListener(this);
        btn_Update = (Button) findViewById(R.id.btn_update);
        btn_Update.setOnClickListener(this);
        btn_Select = (Button) findViewById(R.id.btn_select);
        btn_Select.setOnClickListener(this);
        edit_Type = (EditText) findViewById(R.id.edit_type);
        edit_Weight = (EditText) findViewById(R.id.edit_weight);
        edit_Count = (EditText) findViewById(R.id.edit_count);
        edit_Cycle = (EditText) findViewById(R.id.edit_cycle);
        text_Type = (TextView) findViewById(R.id.text_db_type);
        text_Weight = (TextView) findViewById(R.id.text_db_weight);
        text_Count = (TextView) findViewById(R.id.text_db_count);
        text_Cycle= (TextView) findViewById(R.id.text_db_cycle);
        check_ID = (CheckBox) findViewById(R.id.check_usertype);
        check_ID.setOnClickListener(this);
        check_Name = (CheckBox) findViewById(R.id.check_weight);
        check_Name.setOnClickListener(this);
        check_Age = (CheckBox) findViewById(R.id.check_count);
        check_Age.setOnClickListener(this);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        ListView listView = (ListView) findViewById(R.id.db_list_view);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(onClickListener);
        listView.setOnItemLongClickListener(longClickListener);

        mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();

        check_ID.setChecked(true);
        showDatabase(sort);

        btn_Insert.setEnabled(true);
        btn_Update.setEnabled(false);
    }

    public void setInsertMode(){
        edit_Type.setText("");
        edit_Weight.setText("");
        edit_Count.setText("");
        edit_Cycle.setText("");
        btn_Insert.setEnabled(true);
        btn_Update.setEnabled(false);
    }

    private AdapterView.OnItemClickListener onClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Log.e("On Click", "position = " + position);
            nowIndex = Long.parseLong(arrayIndex.get(position));
            Log.e("On Click", "nowIndex = " + nowIndex);
            Log.e("On Click", "Data: " + arrayData.get(position));
            String[] tempData = arrayData.get(position).split("\\s+");
            Log.e("On Click", "Split Result = " + tempData);
            edit_Type.setText(tempData[0].trim());
            edit_Weight.setText(tempData[1].trim());
            edit_Count.setText(tempData[2].trim());
            edit_Cycle.setText((tempData[3].trim()));
            btn_Insert.setEnabled(false);
            btn_Update.setEnabled(true);
        }
    };

    private AdapterView.OnItemLongClickListener longClickListener = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            Log.d("Long Click", "position = " + position);
            nowIndex = Long.parseLong(arrayIndex.get(position));
            String[] nowData = arrayData.get(position).split("\\s+");
            String viewData = nowData[0] + ", " + nowData[1] + ", " + nowData[2] + ", " + nowData[3];
            AlertDialog.Builder dialog = new AlertDialog.Builder(exercise_db_Activity.this);
            dialog.setTitle("데이터 삭제")
                    .setMessage("해당 데이터를 삭제 하시겠습니까?" + "\n" + viewData)
                    .setPositiveButton("네", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(exercise_db_Activity.this, "데이터를 삭제했습니다.", Toast.LENGTH_SHORT).show();
                            mDbOpenHelper.deleteColumn(nowIndex);
                            showDatabase(sort);
                            setInsertMode();
                        }
                    })
                    .setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(exercise_db_Activity.this, "삭제를 취소했습니다.", Toast.LENGTH_SHORT).show();
                            setInsertMode();
                        }
                    })
                    .create()
                    .show();
            return false;
        }
    };

    public void showDatabase(String sort){
        Cursor iCursor = mDbOpenHelper.sortColumn(sort);
        Log.d("showDatabase", "DB Size: " + iCursor.getCount());
        arrayData.clear();
        arrayIndex.clear();
        while(iCursor.moveToNext()){
            String tempIndex = iCursor.getString(iCursor.getColumnIndex("_id"));
            String tempType = iCursor.getString(iCursor.getColumnIndex("userid"));
            tempType = setTextLength(tempType,30);
            String tempWeight = iCursor.getString(iCursor.getColumnIndex("name"));
            tempWeight = setTextLength(tempWeight,30);
            String tempCount = iCursor.getString(iCursor.getColumnIndex("age"));
            tempCount = setTextLength(tempCount,30);
            String tempCycle = iCursor.getString(iCursor.getColumnIndex("gender"));
            tempCycle = setTextLength(tempCycle,30);

            String Result = tempType + tempWeight + tempCount + tempCycle;
            arrayData.add(Result);
            arrayIndex.add(tempIndex);
        }
        arrayAdapter.clear();
        arrayAdapter.addAll(arrayData);
        arrayAdapter.notifyDataSetChanged();
    }

    public String setTextLength(String text, int length){
        if(text.length()<length){
            int gap = length - text.length();
            for (int i=0; i<gap; i++){
                text = text + " ";
            }
        }
        return text;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_insert:
                ID = edit_Type.getText().toString();
                name = edit_Weight.getText().toString();
                age = Long.parseLong(edit_Count.getText().toString());
                gender = edit_Cycle.getText().toString();
                mDbOpenHelper.open();
                mDbOpenHelper.insertColumn(ID, name, age, gender);
                showDatabase(sort);
                setInsertMode();
                edit_Type.requestFocus();
                edit_Type.setCursorVisible(true);
                break;

            case R.id.btn_update:
                ID = edit_Type.getText().toString();
                name = edit_Weight.getText().toString();
                age = Long.parseLong(edit_Count.getText().toString());
                gender = edit_Cycle.getText().toString();
                mDbOpenHelper.updateColumn(nowIndex,ID, name, age, gender);
                showDatabase(sort);
                setInsertMode();
                edit_Type.requestFocus();
                edit_Type.setCursorVisible(true);
                break;

            case R.id.btn_select:
                showDatabase(sort);
                break;

            case R.id.check_usertype:
                check_Name.setChecked(false);
                check_Age.setChecked(false);
                sort = "userid";
                break;

            case R.id.check_weight:
                check_ID.setChecked(false);
                check_Age.setChecked(false);
                sort = "name";
                break;

            case R.id.check_count:
                check_ID.setChecked(false);
                check_Name.setChecked(false);
                sort = "age";
                break;
        }
    }
}