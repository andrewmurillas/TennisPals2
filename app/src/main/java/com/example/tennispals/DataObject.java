package com.example.tennispals;

import android.media.Image;
import android.widget.ImageView;

public class DataObject {

    private String firstName;
    private String surName;
    private Image portrait;
    private String level;
    private int age;

    DataObject (String firstName, String surName, Image portrait, String level, int age){
        this.firstName = firstName;
        this.surName = surName;
        this.portrait = portrait;
        this.level = level;
        this.age = age;
    }

    public String getmText1() {
        return firstName;
    }

    public void setmText1(String mText1) {
        this.firstName = mText1;
    }

    public String getmText2() {
        return surName;
    }

    public void setmText2(String mText2) {
        this.surName = mText2;
    }

}
