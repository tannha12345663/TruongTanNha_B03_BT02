package com.example.truongtannha_b03_bt02;

public class Person implements Comparable<Person>{
    int id;
    int image;
    String name;
    String numberphone;
    String email;
    String description;



    public Person(int id, int image, String name, String numberphone, String email, String description) {
        this.id = id;
        this.image=image;
        this.name = name;
        this.numberphone = numberphone;
        this.email = email;
        this.description = description;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }
}
