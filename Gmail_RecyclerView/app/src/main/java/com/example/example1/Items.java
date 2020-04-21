package com.example.example1;

import java.util.ArrayList;
import java.util.Random;

public class Items {
    String name;
    String subject;
    String content;
    String time;
    boolean isfavourite;
    int color;

    public Items(String name, String subject, String content, String time) {
        this.name = name;
        this.subject = subject;
        this.content = content;
        this.time = time;
        isfavourite = false;
        Random random =new Random();
        color = random.nextInt();
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public boolean is_favourite(){
        return isfavourite;
    }

    public int getColor(){
        return color;
    }

    public  void setFavourite( boolean favourite){
        isfavourite =favourite;
    }



}
