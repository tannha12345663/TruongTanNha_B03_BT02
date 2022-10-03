package com.example.truongtannha_b03_bt02;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {
    public static List<Person> data;
    @Override
    public void onCreate() {
        super.onCreate();
        if (data==null){
            data=new ArrayList<>();
        }
    }

    public static List<Person> ininitPerson(){
        data.add(new Person(1,
                R.drawable.cyian,
                "Zachary Moore",
                "(027)-352-7112",
                "Zachary Moore@example.com",
                "Null"));
        data.add(new Person(2,
                R.drawable.dominic,
                "Dominic Thunes",
                "(067)-453-1128",
                "dominicthunes@example.com",
                "Null"));
        data.add(new Person(3,
                R.drawable.apolline,
                "Apolline Renard",
                "(028)-155-0657",
                "apollinerenard@example.com",
                "Null"));
        data.add(new Person(4,
                R.drawable.zachary,
                "Maria Pascual",
                "(094)-134-9948",
                "mariapascual@example.com",
                "Null"));
        data.add(new Person(5,
                R.drawable.djordy,
                "Djordy Valkema",
                "(167)-351-1900",
                "djordyvalkema@example.com",
                "Null"));
        data.add(new Person(6,
                R.drawable.jenny,
                "Jenny Jones",
                "(015)-242-8092",
                "jennyjones@example.com",
                "Null"));
        data.add(new Person(7,
                R.drawable.cyian,
                "Ceylan Catalbas",
                "(536)-393-6219",
                "ceylancatalbas@example.com",
                "Null"));
        data.add(new Person(7,
                R.drawable.seraina,
                "Seraina Henry",
                "(077)-673-2231",
                "serainahenry@example.com",
                "Null"));

        return data;
    };

}
