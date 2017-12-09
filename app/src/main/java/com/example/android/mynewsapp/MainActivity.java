package com.example.android.mynewsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<NewsObject> newsArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsArray.add(new NewsObject("Zane is Awesome", "He is the best in the world!!"));
        newsArray.add(new NewsObject("Elaine is second Awesome", "She is the second best!!"));
    }
}
