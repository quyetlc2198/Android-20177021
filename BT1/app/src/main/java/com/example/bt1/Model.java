package com.example.bt1;

import com.google.gson.Gson;

public class Model {
    String name;
    int ID;
    String email;
    String born;
    String birthday;

    public Model(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }



    public Model(String name,int id, String email, String born, String birthday) {
        this.name = name;
        this.ID = id;
        this.email = email;
        this.born = born;
        this.birthday = birthday;
    }

    public Model() {
    }

    public Model(String name, String email, String born, String birthday) {
        this.name = name;
        this.email = email;
        this.born = born;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Model{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                ", email='" + email + '\'' +
                ", born='" + born + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }




}
