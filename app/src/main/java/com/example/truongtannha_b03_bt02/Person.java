package com.example.truongtannha_b03_bt02;

import java.io.Serializable;

public class Person implements Serializable {
    int id;
    int image;
    String fname;
    String lname;
    String numberphone;
    String email;
    String birthday;



    public Person(int id, int image, String fname,String lname, String numberphone, String email, String birthday) {
        this.id = id;
        this.image=image;
        this.fname = fname;
        this.lname=lname;
        this.numberphone = numberphone;
        this.email = email;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getNumberphone() {
        return numberphone;
    }

    public void setNumberphone(String numberphone) {
        this.numberphone = numberphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
