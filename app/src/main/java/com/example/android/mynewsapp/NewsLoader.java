package com.example.android.mynewsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<NewsObject>> {

    private static final String LOG_TAG = NewsLoader.class.getName();



    public NewsLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<NewsObject> loadInBackground() {
        List<NewsObject> newsArray = new ArrayList<>();
        newsArray.add(new NewsObject("Zane is Awesome", "He is the best in the world!!"));
        newsArray.add(new NewsObject("Elaine is second Awesome", "She is the second best!!"));
        return newsArray;
    }
}
