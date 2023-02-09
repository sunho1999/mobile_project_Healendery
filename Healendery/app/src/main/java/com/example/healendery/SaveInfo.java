package com.example.healendery;

import android.app.Application;
import android.widget.TextView;

public class SaveInfo extends Application {
    private boolean sex;
    private boolean exercise_type;
    private String height;
    private String weight;
    private String age;
    private String name;
    private String phone;


    // 성별
    // 남성 true 여성 false
    public Boolean getSex(){
        return sex;
    }
    public void setSex(Boolean sex){
        this.sex = sex;
    }

    // 키
    public String getHeight(){
        return height;
    }
    public void setHeight(String height){
        this.height = height;
    }

    //몸무게
    public String getWeight(){
        return weight;
    }

    public void setWeight(String weight){
        this.weight = weight;
    }

    //운동타입
    //유산소 true 웨이트 false
    public Boolean getType(){
        return exercise_type;
    }
    public void setType(Boolean exercise_type){
        this.exercise_type = exercise_type;
    }

    //나이
    public String getAge(){
        return age;
    }
    public void setAge(String age){
        this.age = age;
    }
    //이름
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    //번호
    public String getPhone(){
        return age;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
}
