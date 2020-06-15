package com.example.intentactivity;

public class Model {
    String mssv;
    String name;

    public Model(String mssv, String name) {
        this.mssv = mssv;
        this.name = name;
    }

    public Model() {
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
