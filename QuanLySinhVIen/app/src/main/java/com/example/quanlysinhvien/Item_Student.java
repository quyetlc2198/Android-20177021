package com.example.quanlysinhvien;

public class Item_Student {
    String MSSV;
    String Name;
    String Address;
    String Birthday;
    String Email;

    public Item_Student() {
    }

    public Item_Student(String name, String address, String birthday, String email) {
        Name = name;
        Address = address;
        Birthday = birthday;
        Email = email;
    }

    public Item_Student(String MSSV, String name, String address, String birthday, String email) {
        this.MSSV = MSSV;
        Name = name;
        Address = address;
        Birthday = birthday;
        Email = email;
    }

    public Item_Student(String MSSV, String name) {
        this.MSSV = MSSV;
        Name = name;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
